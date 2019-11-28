#include <stdio.h>

#include <unistd.h>

#include <sys/types.h>

#include <string.h>

#include <stdlib.h>

void main() 
{ 
  
 int pipefd[2],n;
 char buff[100];
        
    pipe(pipefd);
        
     printf("\nreadfd=%d",pipefd[0]);
      
        printf("\nwritefd=%d",pipefd[1]); 
       
         write(pipefd[1],"helloworld",12); 
      
           n=read(pipefd[0],buff,sizeof(buff));
      
              printf("\n size of the data%d",n); 
 
       printf("\n data from pipe:%s",buff); 

} 

