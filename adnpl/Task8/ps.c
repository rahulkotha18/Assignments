#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<poll.h>
#include<errno.h>
#define MAXLINE 100
#define SERV_PORT 5939
#define POLLRDNORM 5
#define INFTIM 5
#define OPEN_MAX 5
int main(int argc,char **argv)
{
int k,i,maxi,listenfd,connfd,sockfd,nready;
ssize_t n;
char line[MAXLINE];
socklen_t clilen;
struct pollfd client[OPEN_MAX];
struct sockaddr_in cliaddr,servaddr;
listenfd=socket(AF_INET,SOCK_STREAM,0);
bzero(&servaddr,sizeof(servaddr));
servaddr.sin_family=AF_INET;
servaddr.sin_port=htons(SERV_PORT);
servaddr.sin_addr.s_addr=htonl(INADDR_ANY);
bind(listenfd,(struct sockaddr*)&servaddr,sizeof(servaddr));
listen(listenfd,5);
client[0].fd=listenfd;
client[0].events=POLLRDNORM;
for(i=1;i<OPEN_MAX;i++)
{
nready=poll(client,maxi+1,INFTIM);
if(client[0].revents&POLLRDNORM)
{
clilen=sizeof(cliaddr);
connfd=accept(listenfd,(struct sockaddr*)&cliaddr,&clilen);
for(i=1;i<OPEN_MAX;i++)
if(client[i].fd<0)
{
client[i].fd=connfd;
break;
}
if(i==OPEN_MAX)
{
printf("too many client requests");
exit(0);
}
client[i].events=POLLRDNORM;
if(i>maxi)
maxi=i;
if(--nready<=0)
continue;
}
for(i=1;i<=maxi;i++)
{
if((sockfd=client[i].fd)<0)
continue;
if(client[i].revents&(POLLRDNORM|POLLERR))
{
if((n=read(sockfd,line,MAXLINE))<0)
{
printf("\n data from the client is %s",line);
if(errno==ECONNRESET)
{
close(sockfd);
client[i].fd=-1;
}
else
printf("read line error");
}
else if(n==0)
{
close(sockfd);
client[i].fd=-1;
}
else
{
printf("\n data from the client is %s",line);
write(sockfd,line,n);
}
if(--nready<=0)
break;
}
}
}
}
