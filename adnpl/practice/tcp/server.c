#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<sys/socket.h>
#include<arpa/inet.h>
#include<netinet/in.h>
#include<errno.h>
#include<unistd.h>
void main()
{
FILE *fp;
int i,j,k,sockfd,listenfd,bindfd,n;
char buf[100],tmp[100],tmp1[100],ch;
struct sockaddr_in servaddr,cliaddr;
sockfd=socket(AF_INET,SOCK_STREAM,0);
bzero(&servaddr,sizeof(servaddr));
servaddr.sin_family=AF_INET;
servaddr.sin_port=htons(3001);
bindfd=bind(sockfd,(struct sockaddr*)&servaddr,sizeof(servaddr));
listen(sockfd,1);
n=sizeof(cliaddr);
listenfd=accept(sockfd,(struct sockaddr*)&cliaddr,&n);
n=read(listenfd,buf,100);
printf("\n%s \n",buf);
j=0;
for(i=n-1;i>=0;i--)
tmp[j++]=toupper(buf[i]);
tmp[j]='\0';
fp=fopen("f","r");
ch=fgetc(fp);
k=0;
while(ch!=EOF)
{
tmp1[k++]=ch;
ch=fgetc(fp);
}
tmp1[k]='\0';
n=strlen(tmp1);
write(listenfd,tmp1,n);
close(sockfd);
}




