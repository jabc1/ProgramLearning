/*
* ���� gcc ����ȫ����
* ������������ִ�У�

1.��ѡ���������
	�÷���>gcc hello.c
	���ã���hello.cԤ������ࡢ���벢�����γɿ�ִ���ļ���δָ������ļ���Ĭ�����Ϊa.exe(Linux: a.out)��

2.ѡ��-o
	�÷���>gcc hello.c -o hello
	���ã�-oѡ������ָ������ļ����ļ�����

3.ѡ��-E
	�÷���>gcc -E hello.c -o hello.i	// ����ָ������ļ��������ļ���׺�� *.i��������������������
	���ã���hello.cֻ����Ԥ�������hello.i�ļ���

4.ѡ��-S
	�÷���>gcc -S hello.i -o / gcc -S hello.c	// ����ָ������ļ��������ļ���׺�� *.s������û��������
	���ã���Ԥ��������ļ�hello.i����hello.s�ļ���

5.ѡ��-c
	�÷���>gcc -c hello.s
	���ã����������ļ�hello.s�������hello.o�ļ���

6.��ѡ������
	�÷���>gcc hello.o -o hello
	���ã�����������ļ�hello.o���ӳ����տ�ִ���ļ�hello��

7.ѡ��-O
	�÷���>gcc -O1 hello.c -o hello
	���ã�ʹ�ñ����Ż�����1������򡣼���Ϊ1~3������Խ���Ż�Ч��Խ�ã�������ʱ��Խ����

1.����ļ�һ�����
	�÷���>gcc hellofun.c hello.c -o hello
	���ã���hellofun.c��hello.c�ֱ��������ӳ�hello��ִ���ļ���

2.�ֱ�������Դ�ļ���֮��Ա���������Ŀ���ļ����ӡ�
	�÷���
		>gcc -c hellofun.c //��hellofun.c�����hellofun.o
		>gcc -c hello.c    //��hello.c�����hello.o
		>gcc -o hellofun.o hello.o -o hello //��hellofun.o��hello.o���ӳ�hello

�������ַ�����Ƚϣ���һ�з�������ʱ��Ҫ�����ļ����±��룬���ڶ��ַ�������ֻ���±����޸ĵ��ļ���δ�޸ĵ��ļ��������±��롣

8.ѡ��-M
	�÷���>gcc hello.o -o hello
	���ã������ļ���������Ϣ������Ŀ���ļ�������������Դ���롣�������������У�

9.ѡ��-MD
	�÷���>gcc -MD hello.c
	���ã�����-M���ɵĹ�����Ϣ��������ļ�hello.d��
*/

#include <stdio.h>

int main()
{
	printf("Hello Boys\n");
	
	return 0;
}