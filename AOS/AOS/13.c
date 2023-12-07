#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    pid_t pid;
    int status;

    if (argc < 2) {
        printf("Usage: %s command [arguments]\n", argv[0]);
        exit(1);
    }

    pid = fork();

    if (pid < 0) {
        perror("fork error");
        exit(1);
    }

    if (pid == 0) {
        // child process
        if (execvp(argv[1], &argv[1]) < 0) {
            perror("exec error");
            exit(1);
        }
    } else {
        // parent process
        wait(&status);
        printf("Child process %d exited with status %d.\n", pid, WEXITSTATUS(status));
        printf("Parent process %d exited.\n", getpid());
        exit(0);
    }

    return 0;
}

