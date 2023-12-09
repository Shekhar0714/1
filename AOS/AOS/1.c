#include<stdio.h>
#include<unistd.h>
int main()
{
    int fd[2],dupFd;
    char *filename1 ="ls";
    char *filename2 ="wc";
    char *arg1 = "-l";
    pipe(fd);
    if(!fork())// return 0 for child process and 1 for parent process
    {
        close(1); // 1 for closing stdout
        dup(fd[1]);
        close(fd[0]);
        execlp(filename1,filename1,arg1,NULL);
    }else
    {
        close(0);
        dup(fd[0]);
        close(fd[1]);
        execlp(filename2,filename2,arg1,NULL);
    } 
}