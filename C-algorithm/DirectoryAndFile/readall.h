/*
* ������ִ�У�dir c:\*.* /s/b > allfile.txt
    ��c�������ļ�������� allfile.txt�У�

    c���Ե���cmd Ϊ system����cmd�����
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

void readall()
{
    FILE *fp = NULL;
    char *fbuffer;
    int i, len;

    system("dir c:\\*.* /s/b > filelist.txt");          // ȫ���ļ�
    system("dir c:\\*.txt /b > filelist_curr.txt"); // ��ǰĿ¼�µ�txt�ļ�

    Sleep(100);
    fp = fopen("filelist.txt", "r");

    fseek(fp, 0, SEEK_END); // ���ļ�ָ���ƶ����ļ���β
    len = ftell(fp);    // ��ȡ�ļ�����
    fbuffer = (char*)malloc(sizeof(char) * len);
    rewind(fp); // ��λ�ļ�ָ��

    fread(fbuffer, 1, len, fp); // while() fgets() fputs()

    for (i = 0; i < len; i++)
    {
        printf("%c", fbuffer[i]);
    }

    fclose(fp);
}
