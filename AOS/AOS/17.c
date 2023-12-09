#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int pipefd[2];
    pid_t pid;
    char message[] = "Hello, child process!";
    char buffer[100];

    if (pipe(pipefd) == -1) {
        printf("Error: Unable to create pipe.\n");
        exit(EXIT_FAILURE);
    }

    pid = fork();
    if (pid == -1) {
        printf("Error: Unable to create child process.\n");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) {
        close(pipefd[1]);  // Close unused write end of the pipe

        read(pipefd[0], buffer, sizeof(buffer));
        printf("Child process received message: %s\n", buffer);

        close(pipefd[0]);  // Close read end of the pipe
        exit(EXIT_SUCCESS);
    } else {
        close(pipefd[0]);  // Close unused read end of the pipe

        write(pipefd[1], message, strlen(message));
        printf("Parent process sent message: %s\n", message);

        close(pipefd[1]);  // Close write end of the pipe
        wait(NULL);  // Wait for child to terminate
    }

    return 0;
}

