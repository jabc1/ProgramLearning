/*
�εα��Եڶ��⣺
	���Ϊ����������
	���룺һ�����飬Ԫ�ؿ�������������������
	�����һ�������飡
		���������飬����Ԫ�غ�Ϊ0
	���ƣ����������͵���Ŀ��

*/

#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    int arr[100];   // ��������Ԫ�ز�����100����
    int i = 0;
    int input = 0;
    while (scanf("%d", &input) != EOF)
    {
        arr[i++] = input;
    }

    int len = 0;
    int lo = 0;
    int hi = 0;

    for (int j = 0; j < i; j++)
    {
        int t = 0;
        int sum = arr[j];
        for (int k = j + 1; k < i; k++)
        {
            sum += arr[k];
            t++;
            if (sum == 0)
            {
                if (len < t)
                {
                    len = t;
                    lo = j;
                    hi = k;
                }
            }
        }
    }

    for (int j = lo; j <= hi; j++)
    {
        printf("%d ", arr[j]);
    }

    return 0;
}
