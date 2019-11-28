#include<stdio.h>
#include<stdlib.h>
void main()
{
int fd1[2],fd2[2],n,pid;
char buf[100];
pipe(fd1);
pipe(fd2);
pid=fork();

if(pid==0)
{
close(fd1[0]);
printf("\nchild process");
write(fd1[1],"where are you?",15);
close(fd2[1]);
n=read(fd2[0],buf,100);
buf[n]='\0';
printf("\n%s\n",buf);
sleep(2);
}

else
{
close(fd1[1]);
printf("\nparent process");
n=read(fd1[0],buf,100);
buf[n]='\0';
printf("\n%s\n",buf);
close(fd2[0]);
write(fd2[1],"I am in college",16);
}

}



















/*#include<stdio.h>
#include<stdlib.h>
void main()
{
int n,fd[2];
char buff[100];
pipe(fd);
printf("\n read fd:%d",fd[0]);
printf("\n write fd:%d",fd[1]);
write(fd[1],"hello",6);
n=read(fd[0],buff,sizeof(buff));
printf("\n read data:%s",buff);
}
*/
