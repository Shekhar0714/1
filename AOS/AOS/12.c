#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *file1, *file2;
    int c;

    // open file1 for reading
    file1 = fopen("file1.txt", "r");
    if (file1 == NULL) {
        perror("file1.txt open error");
        exit(1);
    }

    // open file2 for writing
    file2 = fopen("file2.txt", "w");
    if (file2 == NULL) {
        perror("file2.txt open error");
        exit(1);
    }

    // copy the contents of file1 to file2
    while ((c = getc(file1)) != EOF) {
        putc(c, file2);
    }

    // close the files
    fclose(file1);
    fclose(file2);

    // remove file1
    if (remove("file1.txt") == -1) {
        perror("file1.txt remove error");
        exit(1);
    }

    // rename file2 to file1
    if (rename("file2.txt", "file1.txt") == -1) {
        perror("file2.txt rename error");
        exit(1);
    }

    printf("Content of file1.txt moved to file2.txt, file1.txt removed, and file2.txt renamed to file1.txt.\n");

    return 0;
}

