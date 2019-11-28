#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>
#define F1 "r1"
#define F2 "r2"
void main()
{
int i,n,rfd,wfd;
char buf[100];
mkfifo(F2,0666);
mkfifo(F1,0666);
rfd=open(F2,O_RDONLY);
wfd=open(F1,O_WRONLY);
n=read(rfd,buf,100);
printf("data from client:%s\n",buf);
write(wfd,"hello rahul",12);
}
