/*
 * queen2.c
 *
 *  Created on: 2015-9-13
 *      Author: ZKY
 *      Recursion
 */


#include <stdio.h>
#include <stdlib.h>
#define QUEENS 8

int queen1(void);
int check(void);
int checkpoint(int i, int value);
void printBoard(void);
void init(void);


int states[9];	// 1,2,3...8 ��������8��
int count = 0;	// ͳ�ƺ��ʵĽ����

int main(void)
{
	printf("Hello start...\n");
	queen2();
}

// ������
int queen2(int i)
{
	/*
	int k;

	for (k = 1; k <= QUEENS; k++)
	{
		if (i == QUEENS)	// �ݹ��˳�����
		{
			if (checkpoint(i, k) == 0)
			{
				states[i] = k;

				printBoard();
			}

			return ;
		}
		else
		{
			if (checkpoint(i, k) == 0)
			{
				states[i] = k;

				queen2(i + 1);
			}
			else	// ���ݵ���һ��
			{
				if (i == 1)
				{
					exit();	// �������
				}

				i--;

				for (k = states[i] + 1; k <= QUEENS; k++)
				{
					if (checkpoint(i, k) == 0)
					{
						states[i] = k;
						queen2(i + 1);
					}
				}
			}
		}
	}
	*/

	int k = 1;

	while (k <= QUEENS)	// ��ѭ���в���һ��
	{
		if (checkpoint(i, k) == 0)
		{
			states[i] = k;
			if (i == 8)
			{
				printBoard();
				return ;
			}
			else
			{
				queen2(i + 1);
			}
		}
		else
		{
			k++;
		}
	}

	/*
	 * �������ˣ���ʼ��Ϊ for ���У�ʵ�� for �� while ���Ӽ�ࡣ
	int k;
	for (k = 1; k <= QUEENS; K++)
	{
		if (checkpoint(i, k) == 0)
		{
			states[i] = k;
			if (i == 8)
			{
				printBoard();
				return ;
			}
			else
			{
				queen2(i + 1);
			}
		}
	}

	*/

}

// �������״̬�Ƿ�Ϸ�
int check(void)
{
	int i, j;

	for (i = 1; i < QUEENS; i++)
	{
		for (j = i + 1; j <= QUEENS; j++)
		{
			// ��֤ÿ��ÿ��ֻ��һ���ʺ�
			if (states[i] == states[j])
			{
				return -1;
			}

			// ��֤�Խ�����ֻ��һ���ʺ�
			if ((states[i] - states[j]) == (i - j) || (states[i] - states[j]) == (j - i))
			{
				return -1;
			}
		}
	}

	return 0;
}

// ��� ��i�з��ڵ�value�д��Ƿ�ȫ
int checkpoint(int i, int value)
{
	int j;

	for (j = 1; j < i; j++)	// ֻ��Ҫ�����ŷź��˵ģ��������ȿ��Բ��ó�ʼ����
	{
		if (value == states[j])
		{
			return -1;
		}

		// ��֤�Խ�����ֻ��һ���ʺ�
		if ((value - states[j]) == (i - j) || (value - states[j]) == (j - i))
		{
			return -1;
		}
	}

	return 0;
}

void printBoard(void)
{
	int k;
	printf("Start output...\n");
	// �����ȷ���
	if (check() == 0)
	{
		count++;
		printf("count%d\t: ", count);
		for (k = 1; k <= QUEENS; k++)
		{
			printf("%d ", states[k]);
		}
		printf("\n");
	}
}

void init(void)
{
	int k = 2;
	for (k = 2; k <= QUEENS; k++)
	{
		states[k] = 0;
	}
}


