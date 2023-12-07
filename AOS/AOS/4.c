#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main()
{
    int fd[2];
    pid_t pid;
    char buf[100];

    // Create the pipe
    if (pipe(fd) < 0) {
        fprintf(stderr, "Pipe creation failed\n");
        exit(1);
    }

    // Fork the process
    pid = fork();

    if (pid < 0) {
        fprintf(stderr, "Fork failed\n");
        exit(1);
    }
    else if (pid == 0) {
        // Child process
        close(fd[0]); // Close unused read end
        write(fd[1], "Hello World\n", strlen("Hello World\n"));
        write(fd[1], "Hello SPPU\n", strlen("Hello SPPU\n"));
        write(fd[1], "Linux is Funny\n", strlen("Linux is Funny\n"));
        
      
        exit(0);
    }
    else {
        // Parent process
        close(fd[1]); // Close unused write end
        printf("parent recieve msg:\n");

        while (read(fd[0], buf, sizeof(buf)) > 0) {
            printf("%s", buf);
        }

        printf("\n");
    }

    return 0;
}

