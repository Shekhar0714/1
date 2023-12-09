#include <stdio.h>
#include <dirent.h>
#include <sys/stat.h>

int main() {
    DIR *dir = opendir(".");
    if (!dir) {
        perror("Failed to open directory");
        return 1;
    }

    struct dirent *entry;
    while ((entry = readdir(dir)) != NULL) {
        if (entry->d_type == DT_REG) {
            char filename[100];
            sprintf(filename, "./%s", entry->d_name);

            struct stat file_info;
            if (stat(filename, &file_info) < 0) {
                perror("Failed to stat file");
                continue;
            }

            printf("%s: inode=%ld, links=%ld, size=%ld\n",
                filename, file_info.st_ino, file_info.st_nlink, file_info.st_size);
        }
    }

    closedir(dir);
    return 0;
}

