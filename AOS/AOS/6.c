#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main()
{
    int fd;
    char buf[1024];
    int n;

    // Create the file with a hole
    if ((fd = creat("file_with_hole.txt", 0666)) < 0) {
        perror("creat error");
        exit(1);
    }

    // Write some data to the file
    if (write(fd, "Hello world", 11) != 11) {
        perror("write error");
        exit(1);
    }

    // Create a hole by seeking past the end of the data
    if (lseek(fd, 16384, SEEK_SET) == -1) {
        perror("lseek error");
        exit(1);
    }

    // Write some more data to the file
    if (write(fd, "Goodbye world", 13) != 13) {
        perror("write error");
        exit(1);
    }

    // Close the file
    close(fd);

    // Open the file for reading
    if ((fd = open("file_with_hole.txt", O_RDONLY)) < 0) {
        perror("open error");
        exit(1);
    }

    // Read from the file and show what data is read at the offsets corresponding to the hole
    while ((n = read(fd, buf, sizeof(buf))) > 0) {
        int i;

        for (i = 0; i < n; i++) {
            if (buf[i] == '\0') {
                printf("Read a null byte at offset %ld\n", lseek(fd, 0, SEEK_CUR) - n + i);
            }
        }

        if (write(STDOUT_FILENO, buf, n) != n) {
            perror("write error");
            exit(1);
        }
    }

    if (n < 0) {
        perror("read error");
        exit(1);
    }

    // Close the file
    close(fd);

    return 0;
}

