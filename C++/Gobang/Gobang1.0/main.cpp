/********************************************************************************************
*
* ��������Ŀ����
*
*   ��飺���ο�����ĥ����Ŀ��������
*   ���ԣ�C++
*   ���ܣ�������󡢷�װ����̬����֦�㷨
*   ��Ŀ�뷨����������������ʦ��C++�γ̡���������ʦ���˹����ܿγ�
*
*   @date:      2015-09-30
*   @author:    ywang
*   @versiom:   1.0
*   @right:     It can only be used for study unless be authorized by the author!
*
**********************************************************************************************/

#include <iostream>
#include "gobang.h"

using namespace std;

int main()
{
    std::cout << "��ʼ��\n";
    Gobang gob = Gobang(14);
    gob.show();

    return 0;
}


/*
�����������취��
-fexec-charset = gbk
-finput-charset = utf-8

cygwin �ı��˵��Ե����ã�ʹ�ó�Ϊ��Linuxϵͳ��������
*/
