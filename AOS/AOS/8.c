#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h
typedef struct {
    char *filename;
    off_t size;
} FileInfo;

int compareFileInfo(const void *a, const void *b) {
    return ((FileInfo *)a)->size - ((FileInfo *)b)->size;
}
int main(int argc, char *argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s <file1> <file2> ... <fileN>\n", argv[0]);
        exit(EXIT_FAILURE);
    }
    int num_files = argc - 1;
    FileInfo *file_info_array = malloc(num_files * sizeof(FileInfo));
    if (file_info_array == NULL) {
        perror("malloc");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < num_files; ++i) {
        struct stat st;
        if (stat(argv[i + 1], &st) == 0) {
            file_info_array[i].filename = argv[i + 1];
            file_info_array[i].size = st.st_size;
        } else {
            perror("stat");
            exit(EXIT_FAILURE);
        }
    }
    qsort(file_info_array, num_files, sizeof(FileInfo), compareFileInfo);
    for (int i = 0; i < num_files; ++i) {
        printf("%s: %ld bytes\n", file_info_array[i].filename, (long)file_info_array[i].size);
    }
    free(file_info_array);
    return 0;
}
