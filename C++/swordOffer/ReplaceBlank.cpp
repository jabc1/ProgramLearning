/*
 * main.cpp
 *
 *  Created on: 2015-9-8
 *      Author: ZKY
 */

/*
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy
 * ˼·�ǣ������ұ��������ҵ����滻
 */
#include <iostream>
#include <cstdio>

class ReplaceBlank
{
public:
	/*
	 // �汾һ����������֣�����֮��str��û�б��޸ģ�����������
	void replaceSpace(char *str, int length)
	{
		char *p = str;
		str = new char[2 * length];
		int index = 0;
		for (int i = 0; i <= length; i++)
		{
			if (p[i] != ' ')
			{
				str[index++] = p[i];
			}
			else
			{
				str[index++] = '%';
				str[index++] = '2';
				str[index++] = '0';
			}
		}
		str[index] = '\0';
		printf("%s\n", str);
	}
	*/
	void replaceSpace(char *str, int length)
	{
		char *p = new char[length];
		for (int i = 0; i <= length; i++)
		{
			p[i] = str[i];
		}
		int index = 0;
		for (int i = 0; i <= length; i++)
		{
			if (p[i] != ' ')
			{
				str[index++] = p[i];
			}
			else
			{
				str[index++] = '%';
				str[index++] = '2';
				str[index++] = '0';
			}
		}
		str[index] = '\0';
		printf("%s\n", str);
	}
};

int main()
{
	char test[] = {"We Are Happy"};
	ReplaceBlank rb;
	rb.replaceSpace(test, 12);
	printf("%s\n", test);
	return 0;
}
