#ifndef _READTXT_
#define _READTXT_

#include <stdio.h>
#include <io.h>     // #include <io.h>

/*
    #include <io.h>
    ��<io.h>��ͷ�ļ���:
        �����ļ����� struct _finddata_t�ṹ��: �洢�ļ�������Ϣ��
            unsigned atrrib���ļ����ԵĴ洢λ�á�
            ���洢һ��unsigned��Ԫ�����ڱ�ʾ�ļ������ԡ��ļ���������λ��ʾ�ģ���Ҫ������һЩ��
                _A_ARCH���浵����_A_HIDDEN�����أ���_A_NORMAL����������_A_RDONLY��ֻ������_A_SUBDIR���ļ��У���_A_SYSTEM��ϵͳ����
            ��Щ������<io.h>�ж���ĺ꣬����ֱ��ʹ�ã��������������ʵ��һ���޷������ͣ�ֻ�����������Ӧ����2�ļ����ݣ��Ӷ���ֻ֤��һλΪ1��������λΪ0����
            ��Ȼ��λ��ʾ����ô��һ���ļ��ж������ʱ����������ͨ��λ��ķ�ʽ�����õ��������Ե��ۺϡ�����ֻ��+����+ϵͳ���ԣ�Ӧ��Ϊ��
                _A_HIDDEN | _A_RDONLY | _A_SYSTEM

            time_t time_create�������time_t��һ���������ͣ������洢ʱ���

            time_t time_access���ļ����һ�α����ʵ�ʱ�䡣

            time_t time_write���ļ����һ�α��޸ĵ�ʱ�䡣

            _fsize_t size���ļ��Ĵ�С�������_fsize_tӦ�ÿ����൱��unsigned���ͣ���ʾ�ļ����ֽ�����

            char name[_MAX_FNAME]���ļ����ļ����������_MAX_FNAME��һ�������꣬����<stdlib.h>ͷ�ļ��б����壬��ʾ�����ļ�������󳤶ȡ�

            struct _finddata_t
            {
                unsigned attrib;
                time_t time_create;
                time_t time_access;
                time_t time_write;
                _fsize_t size;
                char name[_MAX_FNAME];
            };

        ����:
        long _findfirst( char *filespec, struct _finddata_t *fileinfo )��
            ����ֵ��������ҳɹ��Ļ���������һ��long�͵�Ψһ�Ĳ����õľ��������һ��Ψһ��ţ�������������_findnext�����б�ʹ�á���ʧ�ܣ��򷵻�-1��
            ������  filespec�������ļ����ַ�������֧��ͨ��������磺*.c�����ʾ��ǰ�ļ����µ����к�׺ΪC���ļ���
                    fileinfo �����������������ļ���Ϣ�Ľṹ���ָ�롣����ṹ������ڵ��ô˺���ǰ�������������ó�ʼ����ֻҪ�������ڴ�ռ�Ϳ����ˡ������ɹ��󣬺�������ҵ����ļ�����Ϣ��������ṹ���С�

        int _findnext( long handle, struct _finddata_t *fileinfo );
            ����ֵ�����ɹ�����0�����򷵻�-1
            ����:   handle������_findfirst�������ػ����ľ����
                    fileinfo���ļ���Ϣ�ṹ���ָ�롣�ҵ��ļ��󣬺��������ļ���Ϣ����˽ṹ���С�

        int _findclose( long handle );
            ����ֵ���ɹ�����0��ʧ�ܷ���-1��
            ������  handle ��_findfirst�������ػ����ľ����

        ����_findfirst���ҵ�һ���ļ������ɹ����÷��صľ������_findnext���������������ļ�����������Ϻ��ã���_findclose������������

    // gcc struct _finddata_t δ����Ľ���취
        codeblocks ʹ�� cygwin�����gcc������
        żȻ����Ūһ���Զ���ȡ�ļ���������Ƭ���Զ���ʾ��С����
            Ȼ���ѧϰ�¶�ȡ�ļ��������ļ��Ĳ������ٶ�һ�£��ܶ�ͬ��������
            �ҵ��˴�ţ�Ĳ���(http://blog.csdn.net/alsm168/article/details/6503434)��ѧϰ���£����÷ǳ��������壬�������˿������
            ps: �����Ĳ��ͺܶ࣬���ݺ���Ҳ��90%���ϵ����ƶȵġ�
            ���Ե�ʱ�򣬷����������ˣ�storage size of 'fileinfo' isn't known������Ӧ����struct _finddata_t����δ�����
            �����ٶȣ�����ͬ�������ͬ־�ܶ࣬Ҳ�н����������ξͲ������ˣ����кܶ�������Ӧ��������δ��ġ�
            ����1���Լ�����һ�� struct _finddata_t �ṹ��
                struct _finddata_t
                {
                    unsigned attrib;
                    time_t time_create;
                    time_t time_access;
                    time_t time_write;
                    _fsize_t size;
                    char name[_MAX_FNAME];
                };

    û��io.h ͷ�ļ� (cygwin io.h ����֣�)
        cygwin/usr/include�У���/usr/include/sys��û�У����ǡ�io.h"����û�й��ڶ�ȡĿ¼���ļ��ĺ����ͽṹ���壡
        mingw/include ������"io.h"��Ҳ������struct _finddata32_t��struct _finddata64_t�����ݽṹ�����ǲ�֪����ôʹ�ã�

*/

/*
    ��ȡͬһ�ļ����µ�����txt�ļ�
    ����ļ��Ĳ�������ָ����·���н��У���α���Ӳ�̣�������Ӳ���в����ļ�����Ҫ�ݹ����

    �ҵ������������0�����򷵻�-1
*/

/***************************************************************
int readtxt()
{
    struct _finddata32_t fileinfo;  // _finddata32_t
    long fHandle;

    const char *to_search = "D:\\Soft\\Python\\workspace\\sampleGUI\\*.py"; // Ŀ������ļ���*ͨ���
    if ((fHandle = _findfirst(to_search, &fileinfo)) == -1L)
    {
        printf("There is no suitable file!\n");
        return -1;
    }
    printf("%s\n", fileinfo.name);  // ��ӡ�ļ���
    while(! _findnext(fHandle, &fileinfo))
    {
        printf("%s\n", fileinfo.name);
    }

    _findclose(fHandle);

    return 0;
}
*********************************************************/

#endif // _READTXT_



