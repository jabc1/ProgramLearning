#include <iostream>

using namespace std;

/*
�ݹ��㷨��
�Զ�����
*/

long long fib1(int n)
{
    if (n==1 || n==0)
    {
        return n;
    }
    return (fib1(n-1)+fib1(n-2));
}

/*
��̬�滮�㷨��
�Ե�����
*/

long long fib2(int n)
{
    if (n==1 || n==0)
    {
        return n;
    }
    long long f1 = 0, f2 = 1;
    for (int i=1;i<n;i++)
    {
        f2 += f1;
        f1 = f2 - f1;
    }
    return f2;
}

/*
�����㷨����¼��
�Զ�����
������Ĵ��δ���㷨�������
��������������������������
*/

void fib3(long long *array, int n)
{
    array[0] = 0;
    array[1] = 1;
    for (int i=1; i<n; i++)
    {
        array[i+1] = array[i] + array[i-1];
    }
}

int main()
{
    int n=50;
    long long *array = new long long[n];
    fib3(array, n);
    for (int i=0; i<50; i++)
    {
        cout << "fib3=" << array[i] << endl;
    //    cout << "fib2=" << fib2(i) <<endl;
    //    cout << "fib1=" << fib1(i) <<endl;
    }
    return 0;
}
