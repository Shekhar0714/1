#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp;
    char ch;
    int count = 0;

    // Open the file for reading
    fp = fopen("sample.txt", "r");
   
    // Read every 10th character in the file and print it
    while ((ch = fgetc(fp)) != EOF) {
        if (count % 10 == 0) {
            putchar(ch);
        }
        count++;
    }

    // Print the number of characters that were printed
    printf("\nNumber of characters printed: %d\n", count);

    // Close the file
    fclose(fp);

    return 0;
}

