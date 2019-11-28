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
int n,rfd,wfd;
char buf[100];
wfd=open(F2,O_WRONLY);
rfd=open(F1,O_RDONLY);
write(wfd,"HELLO RAHUL",12);
n=read(rfd,buf,100);
printf("recevied response from server:%s\n",buf);
}
