#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/resource.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <number_of_children>\n", argv[0]);
        exit(EXIT_FAILURE);
    }
    int n = atoi(argv[1]);
    if (n <= 0) {
        fprintf(stderr, "Number of children should be a positive integer.\n");
        exit(EXIT_FAILURE);
    }
    struct rusage usage;
    int i;
    pid_t child_pid;

    for (i = 0; i < n; ++i) {
        child_pid = fork();

        if (child_pid == -1) {
            perror("fork");
            exit(EXIT_FAILURE);
        }
        if (child_pid == 0) { // Child process
            sleep(1); // Simulate some work in the child process
            exit(EXIT_SUCCESS);
        }
    }    int status;
    pid_t terminated_pid;

    while ((terminated_pid = waitpid(-1, &status, 0)) > 0) {
        if (WIFEXITED(status)) {
            printf("Child %d terminated.\n", terminated_pid);
        } else {
            fprintf(stderr, "Child %d terminated abnormally.\n", terminated_pid);
        }
    }
    if (getrusage(RUSAGE_CHILDREN, &usage) == 0) {
        printf("Total user mode time: %ld seconds %ld microseconds\n",
               usage.ru_utime.tv_sec, usage.ru_utime.tv_usec);
        printf("Total kernel mode time: %ld seconds %ld microseconds\n",
               usage.ru_stime.tv_sec, usage.ru_stime.tv_usec);
    } else {
        perror("getrusage");
    }
    return 0;
}
