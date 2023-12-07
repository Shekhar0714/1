#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <filename>\n", argv[0]);
        exit(1);
    }

    char *filename = argv[1];
    struct stat file_info;
    if (stat(filename, &file_info) < 0) {
        perror("Failed to stat file");
        exit(1);
    }

    printf("Properties of file: %s\n", filename);
    printf("Inode number: %ld\n", file_info.st_ino);
    printf("Number of hard links: %ld\n", file_info.st_nlink);
    printf("File permissions: %o\n", file_info.st_mode & 0777);
    printf("File size: %ld bytes\n", file_info.st_size);

    return 0;
}

