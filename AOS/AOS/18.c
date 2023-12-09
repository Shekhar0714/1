#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    int fd;
    char buffer1[] = "Hello";
    char buffer2[] = "World";
    char buffer3[] = "!!!";
    char read_buffer[20];

    // Open the file for writing
    fd = open("file.txt", O_WRONLY | O_CREAT, 0666);
    if (fd == -1) {
        printf("Error: Unable to open file for writing.\n");
        exit(EXIT_FAILURE);
    }

    // Write the first buffer to the file
    write(fd, buffer1, sizeof(buffer1));

    // Create a hole in the file by seeking past 100 bytes
    lseek(fd, 100, SEEK_CUR);

    // Write the second buffer to the file
    write(fd, buffer2, sizeof(buffer2));

    // Create another hole in the file by seeking past another 100 bytes
    lseek(fd, 100, SEEK_CUR);

    // Write the third buffer to the file
    write(fd, buffer3, sizeof(buffer3));

    // Close the file
    close(fd);

    // Open the file for reading
    fd = open("file.txt", O_RDONLY);
    if (fd == -1) {
        printf("Error: Unable to open file for reading.\n");
        exit(EXIT_FAILURE);
    }

    // Read the contents of the file and display them
    int nbytes = read(fd, read_buffer, sizeof(read_buffer));
    while (nbytes != 0) {
        write(STDOUT_FILENO, read_buffer, nbytes);
        nbytes = read(fd, read_buffer, sizeof(read_buffer));
    }

    // Close the file
    close(fd);

    return 0;
}

