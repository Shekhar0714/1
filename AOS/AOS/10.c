#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
    int fd, saved_stdout;

    saved_stdout = dup(STDOUT_FILENO); // save the current standard output
    fd = open("output1.txt", O_WRONLY | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR); // open the output file

    if (fd == -1) {
        perror("open error");
        exit(1);
    }

    if (dup2(fd, STDOUT_FILENO) == -1) { // redirect the standard output to the output file
        perror("dup2 error");
        exit(1);
    }

    printf("This message will be written to output.txt.\n");

    if (dup2(saved_stdout, STDOUT_FILENO) == -1) { // restore the standard output
        perror("dup2 error");
        exit(1);
    }

    printf("This message will be written to the console.\n");

    close(fd);

    return 0;
}

