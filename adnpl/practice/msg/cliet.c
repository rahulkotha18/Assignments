#include<stdio.h>
#include<stdlib.h>
#include<sys/ipc.h>
#include<sys/msg.h>
#include<sys/types.h>
#include<string.h>
void main()
{
key_t ipckey;
int r,mq_id;
struct {
long type;
char text[100];
}mymsg;
ipckey=ftok("/tmp/foo",42);
mq_id=msgget(ipckey,IPC_CREAT|0666);
r=msgrcv(mq_id,&mymsg,sizeof(mymsg),0,0);
printf("%s",mymsg.text);
}
