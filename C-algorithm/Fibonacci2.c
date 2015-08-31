/**
* @see fabonacci �����㷨���о���
*       1. ��ͨ�ݹ�ķ�����ʵ�����: O(n^2)    �Զ�����
*       2. ��Ч�ʵĵ���������ʵ��Ҳ��: O(n)    �Ե�����
*       3. ���Ч�ķ�����ʵ�ָ���: O(log(n))
* @author ywang
* @date 2015-08-24
* @note All Rights Reserved!
*/

/*
* ����˵����쳲���������
*   f(n) = f(n-1) + f(n-2)  when n >= 2
*   f(0) = 0
*   f(1) = 1
*
*/

#include <stdio.h>

// recurve
long fab(int n)
{
    if (n == 1)
    {
        return 1;
    }
    else if (n == 0)
    {
        return 0;
    }
    return fab(n - 1) + fab(n - 2);
}

// iterate
long fab2(int n)
{
    int i = 0;
    long a = 0;
    long b = 1;
    if (n == 1)
    {
        return 1;
    }
    else if (n == 0)
    {
        return 0;
    }

    for (i = 1; i < n; i++)
    {
        b += a;
        a = b - a;
    }
    return b;
}

// ����˷�
/*
* {f(n), f(n-1), f(n-1), f(n-2)} ={1, 1, 1,0}^n-1
* ע��{f(n+1), f(n), f(n), f(n-1)}��ʾһ�������ھ����е�һ�е�һ����f(n+1)����һ�еڶ�����f(n)���ڶ��е�һ����f(n)��
* �ڶ��еڶ�����f(n-1)
* ���ݣ�ʹ�õݹ飬log(n)
*
*/

/*
typedef struct matrix Mat
{
    int a00;
    int a01;
    int a10;
    int a11;
};
�޸ģ�
struct matrix
{
    int a00;
    int a01;
    int a10;
    int a11;
};
typedef struct matrix Mat;
*/

typedef struct matrix
{
    int a00;
    int a01;
    int a10;
    int a11;
}Mat;

// ����˷�
Mat matMultiple(Mat mat1, Mat mat2)
{
    int a00 = mat1.a00 * mat2.a00 + mat1.a01 * mat2.a10;
    int a01 = mat1.a00 * mat2.a01 + mat1.a01 * mat2.a11;
    int a10 = mat1.a10 * mat2.a00 + mat1.a11 * mat2.a10;
    int a11 = mat1.a10 * mat2.a01 + mat1.a11 * mat2.a11;
    mat1.a00 = a00;
    mat1.a01 = a01;
    mat1.a10 = a10;
    mat1.a11 = a11;
    return mat1;
}

// ���� �ݹ鷽ʽ
Mat matPow(Mat mat, int n)
{
    if (n == 1)
    {
        return mat;
    }
    if (n % 2 == 0)
    {
        return matPow(matMultiple(mat, mat), n/2);
    }
    else
    {
        return matMultiple(matPow(matMultiple(mat, mat), n/2), mat);
    }
}

long fab3(int n)
{
    Mat mat0 = {1, 1, 1, 0};
    Mat mat1;
    if (n == 1)
    {
        return 1;
    }
    else if (n == 0)
    {
        return 0;
    }
    mat1 = matPow(mat0, n - 1);
    return mat1.a00;
}

int main()
{
    int n = 0;
    int flag = 1;
    while (flag > 0)
    {
        printf("Please choose a method: 1, 2, 3\n");
        scanf("%d", &flag);
        printf("Please choose the number of terms: n\n");
        scanf("%d", &n);
        if (n < 0)
        {
            printf("bad number: %d < 0\n", n);
            n = 0;
        }
        switch (flag)
        {
            case 1:
                printf("fab(%d) = %ld\n", n, fab(n)); break;
            case 2:
                printf("fab(%d) = %ld\n", n, fab2(n)); break;
            case 3:
                printf("fab(%d) = %ld\n", n, fab3(n)); break;
            default:
                printf("The method is not completed!\n");
                flag = 0;
                break;
        }
    }
    return 0;
}
