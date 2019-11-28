#include <unistd.h>

#include <errno.h>

#include <sys/stat.h>

#include <string.h>

#include <sys/types.h>

#include <fcntl.h>

#include <sys/types.h>

#include <sys/ipc.h>

#include <sys/shm.h>

#include <stdio.h>

#include <sys/sem.h>

# include <stdlib.h>


#define SHMSZ 4 /* Good for integer */

#define BUF_SZ 16

#define SHM_KEY 1234

#define SEM_KEY 1235

#define CHILD_INCREMENT_COUNT 6

#define PARENT_INCREMENT_COUNT 8


union semun {
int val; /* value for SETVAL */
};

main()
{

int shmid;

int semid;

key_t key;

int *child_shm, *parent_shm;

union semun arg;

int i;

struct sembuf operations[1];

int status;

int pid;


/*
* Create the shared segment.& semaphore. 
*/

if ((shmid = shmget(SHM_KEY, SHMSZ, IPC_CREAT | 0666)) < 0) {

perror("shmget");

exit(1);

}


if ((semid = semget(SEM_KEY, 1, IPC_CREAT | 0666)) < 0) {

perror("semget");

exit(1);

}


/*
* Initialize the semaphore to value 1. The idea is multiple processes
* do semop() of -1. 
So only one is allowed in critical section.

* initialize the shm to 0.
*/

arg.val = 1;

if (semctl(semid, 0, SETVAL, arg) < 0) {

perror("semctl");

exit(1);
}


if ((parent_shm = shmat(shmid, NULL, 0)) == (int *)-1) {
perror("parent shmat");
exit(1);
}

*parent_shm = 0;

/*
* create a child process. The above opened shm & sem fds get
* copied to child process as a result of fork(). They both attach to the
* shared memory and use the semphore to increment the value in the shm.
*/

if ((pid = fork()) < 0) {
printf("Child Process Creation Error:%d\n", errno);
return;
}

/* 
* Child process attaches to shm. It fill operations to block till 
* it gets -1. Since the initial value of semaphore is 1, only one
* process can do -1. The other process will see the value as 0 and 
* block till it sees sem value as 1. After semop(), increment the shm
* integer by 1. Then again use the semop to set the sem value to 1, so 
* that other process gets the chance to run. 
* Repeat the above for a defined number of times. Later similar thing is
* done for parent process also. 
*/

if (pid == 0) {

if ((child_shm = shmat(shmid, NULL, 0)) == (int *)-1) {
perror("child shmat");
exit(1);
}

for (i = 0; i < CHILD_INCREMENT_COUNT; i++) {

operations[0].sem_num = 0;
operations[0].sem_op = -1;
operations[0].sem_flg = 0;

if (semop(semid, operations, 1) < 0) {
perror("child semop");
exit(1);
}

*child_shm = *child_shm + 1;

if (i%1000 == 0) {
usleep(1); // sleep 1 us to increase window of critical section
}

operations[0].sem_num = 0;
operations[0].sem_op = 1;
operations[0].sem_flg = 0;

if (semop(semid, operations, 1) < 0) {
perror("child semop");
exit(1);
}

}

} 


if (pid != 0) {

for (i = 0; i < PARENT_INCREMENT_COUNT; i++) {

operations[0].sem_num = 0;
operations[0].sem_op = -1;
operations[0].sem_flg = 0;

if (semop(semid, operations, 1) < 0) {
perror("parent semop");
exit(1);
}

*parent_shm = *parent_shm + 1;

if (i%1500 == 0) {
sleep(1); // sleep 1 us to increase window of critical section
}

operations[0].sem_num = 0;
operations[0].sem_op = 1;
operations[0].sem_flg = 0;

if (semop(semid, operations, 1) < 0) {
perror("parent semop");
exit(1);
}

}

// wait for child to complete
wait(&status);

/* 
* now that parent and child are done incrementing, check the 
* consistency of the shm memory.
*/

printf("Child Incremented %d times, Parent %d times. SHM Value %d\n", 
CHILD_INCREMENT_COUNT, PARENT_INCREMENT_COUNT, *parent_shm);
if (*parent_shm == (CHILD_INCREMENT_COUNT + PARENT_INCREMENT_COUNT)) {
printf("Total of Parent & Child matches SHM value\n");
} else {
printf("BUG - Total of Parent & Child DOESNT match SHM value\n");
}
}

exit(0);

}
