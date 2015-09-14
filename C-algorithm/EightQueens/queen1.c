/*
 * queen1.c
 *
 *  Created on: 2015-9-13
 *      Author: ZKY
 *      Recall without Recursion
 *  ��ԭʼ�����Ľⷨ�����ݡ���̽
 *  ͨ���׶����߼���(������һ�죬�������˳��߼��������������߽�����Ū����ͷ������)
 */

#include <stdio.h>
#define QUEENS 8

void queen1(void);
int check(void);
int checkpoint(int i, int value);
int checkmodify(void);
void printBoard(void);
void init(void);


int states[9];	// 1,2,3...8 ��������8��
int count = 0;	// ͳ�ƺ��ʵĽ����

int main(void)
{
	printf("Hello start...\n");
	//queen1();

	states[1] = 1;
	states[2] = 5;
	states[3] = 8;
	states[4] = 6;
	states[5] = 3;
	states[6] = 7;
	states[7] = 2;
	states[8] = 4;

	printf("%d\n", check());

	return 0;
}

// ������
void queen1(void)
{
	int k2, k3, k4, k5, k6, k7, k8;

	states[1] = 1;	// ��ʼλ�ã���ʼ����

	while (states[1] < 9)
	{
		printf("%d:\n", states[1]);	// ��i������states[1]Ϊ���ڵ㡣
		// i = 2;  // ʹ�� i ����Ǻ��鷳��������Ҫ i-- ��
		for (k2 = 1; k2 <= QUEENS; k2++)   // �ڶ���
        {
            if (checkpoint(2, k2) == 0)
            {
                states[2] = k2;
                for (k3 = 1; k3 <= QUEENS; k3++)    // ������
                {
                    if (checkpoint(3, k3) == 0)
                    {
                        states[3] = k3;
                        for (k4 = 1; k4 <= QUEENS; k4++)    // ������
                        {
                            if (checkpoint(4, k4) == 0)
                            {
                                states[4] = k4;
                                for (k5 = 1; k5 <= QUEENS; k5++)    // ������
                                {
                                    if (checkpoint(5, k5) == 0)
                                    {
                                        states[5] = k5;
                                        for (k6 = 1; k6 <= QUEENS; k6++)    // ������
                                        {
                                            if (checkpoint(6, k6) == 0)
                                            {
                                                states[6] = k6;
                                                for (k7 = 1; k7 <= QUEENS; k7++)   // ������
                                                {
                                                    if (checkpoint(7, k7) == 0)
                                                    {
                                                        states[7] = k7;
                                                        for (k8 = 1; k8 <= QUEENS; k8++)   // �ڰ���
                                                        {
                                                            if (checkpoint(8, k8) == 0)
                                                            {
                                                                states[8] = k8;
                                                                printBoard();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
		states[1]++;	// ��֤ǰ��������ԭ�ط�ѭ��
	}
	printf("over!\n");
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

int checkmodify(void)
{
	int k;
	for (k = 1; k < QUEENS; k++)
	{
		if (states[k] > QUEENS)
		{
			return k;
		}
	}
	return 0;
}

void printBoard(void)
{
	int k;
	printf("Start output...\n");
	// �����ȷ���
	if (check() == 0)   // ���Բ���Ҫ���ɹ��˳�����һ�Σ�����϶�������ȷ������ checkpoint()���ɹ�
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



