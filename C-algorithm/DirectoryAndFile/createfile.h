#ifndef _CREATEFILE_
#define _CREATEFILE_

#include <stdio.h>

/*
* ���Լ���ָ��·���£�����c�����ļ�
* �����·����������Ч�ģ������޷��ɹ�
*   eg������ Soft\\Csource\\test
        ����ͻ��� D:\\Soft\\Csource�ļ���(�������Ѿ��е��ļ���)���洴��һ��test.c�ļ�
*/
void createfile()
{
    char dirName[50];
    char path[50];
    FILE *fp;

    printf("Please input the directory name: ");
    scanf("%s", dirName);
    sprintf(path, "D:\\%s.c", dirName); // create a file path
    fp = fopen(path, "wb");     // ���ļ�������ʱ���Զ�������
    fwrite("#include <stdio.h> \n", 1, 20, fp); // ���ȱ���Ϊ 20�� 21���ж����ַ���
    fwrite("I am a test file!\n", 1, 30, fp);

    fclose(fp);
}


#endif // _CREATEFILE_
