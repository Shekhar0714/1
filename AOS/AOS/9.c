#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>

int main()
{
    DIR *dir;
    struct dirent *ent;
    struct stat st;
    char *cwd = ".";

    if ((dir = opendir(cwd)) == NULL) {
        perror("opendir error");
        exit(1);
    }

    while ((ent = readdir(dir)) != NULL) {
        char *filename = ent->d_name;

        if (stat(filename, &st) == -1) {
            perror("stat error");
            exit(1);
        }

        if (S_ISDIR(st.st_mode) && strcmp(filename, ".") != 0 && strcmp(filename, "..") != 0) {
            printf("%s\n", filename);
        }
    }

    closedir(dir);

    return 0;
}

