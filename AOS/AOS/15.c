#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <dirent.h>
#include <sys/stat.h>
#include <time.h>

int main() {
    DIR *dir;
    struct dirent *entry;
    struct stat file_stat;
    time_t start_time, end_time;

    start_time = mktime(&(struct tm){.tm_year=123, .tm_mon=4, .tm_mday=1}); // 1st May 2023
    end_time = mktime(&(struct tm){.tm_year=123, .tm_mon=4, .tm_mday=15}); // 15th May 2023

    dir = opendir(".");
    if (dir == NULL) {
        printf("Unable to open directory.");
        exit(1);
    }

    while ((entry = readdir(dir)) != NULL) {
        stat(entry->d_name, &file_stat);
        if (S_ISREG(file_stat.st_mode) && file_stat.st_mtime >= start_time && file_stat.st_mtime <= end_time) {
            printf("%s (inode: %ld)\n", entry->d_name, file_stat.st_ino);
        }
    }

    closedir(dir);

    return 0;
}

