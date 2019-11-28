#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<poll.h>
#include<errno.h>
#define MAXLINE 100
#define SERV_PORT 5939
main(int argc,char **argv)
{
int sockfd,fd;
struct sockaddr_in servaddress;
char sendline[100],recvline[100];
int i=0;
sockfd=socket(AF_INET,SOCK_STREAM,0);
bzero(&servaddress,sizeof(servaddress));
servaddress.sin_family=AF_INET;
servaddress.sin_port=htons(SERV_PORT);
servaddress.sin_addr.s_addr=inet_addr(argv[1]);
connect(sockfd,(struct sockaddr*)&servaddress,sizeof(servaddress));
printf("Enter sentence to send");
while(fgets(sendline,MAXLINE,stdin)!=NULL)
{
write(sockfd,sendline,MAXLINE);
printf("line send:%s",sendline);
read(sockfd,recvline,MAXLINE);
printf("echoed sentence %s",recvline);
}
close(sockfd);
return 0;
}
