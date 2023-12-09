#include <stdio.h>
#include <stdlib.h>

void cleanup_files() {
    printf("Doing cleanup work, Closing files\n");
    // Close any open files here
}

void cleanup_memory() {
    printf("Doing cleanup work, Freeing memory\n");
    // Free any dynamically allocated memory here
}

int main() {
    // Register the cleanup functions
    atexit(cleanup_files);
    atexit(cleanup_memory);

    // The rest of your program goes here

    return 0;
}

