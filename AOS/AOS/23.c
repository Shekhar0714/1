#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *read_file, *write_file;
    char ch, next_ch;

    // Open the read file for reading
    read_file = fopen("sample.txt", "r");
    
    // Open the write file for writing
    
    write_file = fopen("sample2.txt", "w");
    if (write_file == NULL) {
        printf("Error: Unable to open write file for writing.\n");
        exit(EXIT_FAILURE);
    }

    // Read alternate characters from the read file and write them to the write file
    while ((ch = fgetc(read_file)) != EOF) {
        next_ch = fgetc(read_file);
        if (next_ch != EOF) {
            fputc(ch, write_file);
        }
    }

    // Close the files
    fclose(read_file);
    fclose(write_file);

    return 0;
}

