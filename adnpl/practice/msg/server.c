#include<stdio.h>
#include<stdlib.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<sys/types.h>
#include<string.h>
void main()
{
key_t ipckey;
int mq_id;
struct {
long type;
char text[100];
}mymsg;
ipckey=ftok("/tmp/foo",42);
mq_id=msgget(ipckey,IPC_CREAT|0666);
memset(&mymsg.text,0,sizeof(mymsg.text));
strcpy(mymsg.text,"rahul kotha");
mymsg.type=1;
msgsnd(mq_id,&mymsg,sizeof(mymsg),0);
}
