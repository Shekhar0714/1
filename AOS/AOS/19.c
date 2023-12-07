#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    int fd1, fd2;
    char buffer[20];

    // Open the file for reading and writing
    fd1 = open("file.txt", O_RDWR | O_CREAT, 0666);
    if (fd1 == -1) {
        printf("Error: Unable to open file for reading and writing.\n");
        exit(EXIT_FAILURE);
    }

    // Duplicate the file descriptor
    fd2 = dup(fd1);

    // Write some data to the file using the first file descriptor
    write(fd1, "Hello, world!", 13);

    // Read the data from the file using the second file descriptor
    lseek(fd2, 0, SEEK_SET);
    int nbytes = read(fd2, buffer, sizeof(buffer));
    if (nbytes == -1) {
        printf("Error: Unable to read from file.\n");
        exit(EXIT_FAILURE);
    }

    // Print the data that was read from the file
    printf("Data read from file: %.*s\n", nbytes, buffer);

    // Close the file descriptors
    close(fd1);
    close(fd2);

    return 0;
}

