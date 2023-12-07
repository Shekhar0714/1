#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <dirent.h>
#include <sys/stat.h>
#include <unistd.h>

int main()
{
    DIR *dir;
    struct dirent *ent;
    struct stat st;
    char *cwd = getcwd(NULL, 0);

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

        if (S_ISREG(st.st_mode) && (st.st_mode & S_IWUSR)) {
            printf("%s\n", filename);
        }
    }

    closedir(dir);
    free(cwd);

    return 0;
}

