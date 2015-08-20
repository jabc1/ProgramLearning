/**
* ���ACM fire net����
* http://acm.zju.edu.cn/onlinejudge/showProblem.do?problemCode=1002
* �����㷨ʵ�֣��ο���ͥɢ��Դ����
* http://www.cnblogs.com/phinecos/archive/2008/09/18/1293017.html?updated=1
*/
#include <stdio.h>

//����ȫ�ֱ������ʺϵݹ麯��
char board[4][4];
int maxsum = 0;

int flag(int row, int col) //��Ǻ����ж�
{
    int i = 0;
    for (i = row - 1; i >= 0; i--)
    {
        if (board[i][col] == 'X')
        {
            break;
        }
        else if (board[i][col] == '1')
        {
            return 0;
        }
    }
    for (i = col - 1; i >= 0; i--)
    {
        if (board[row][i] == 'X')
        {
            break;
        }
        else if (board[row][i] == '1')
        {
            return 0;
        }
    }
    return 1;
}

void solve(int k, int currentsum, int n) //���ݵݹ麯��
{
    int row;
    int column;
    if (k == n * n)
    {
        if (currentsum > maxsum)
        {
            maxsum = currentsum;
        }
        return ;
    }
    else
    {
        row = k / n;
        column = k % n;
        if (board[row][column] == '.' && flag(row, column) == 1)
        {
            board[row][column] = '1';   //���÷���
            solve(k+1, currentsum+1, n);
            board[row][column] = '.';   //����
        }
        solve(k+1, currentsum, n);
    }
}

int main()
{
    int n = 0;
    int i = 0;

    while (scanf("%d", &n) != EOF && n > 0)
    {
        for (i = 0; i < n; i++)
        {
            scanf("%s", board[i]);
        }
        maxsum = 0;
        solve(0, 0, n);
        printf("%d\n", maxsum);
    }
    return 0;
}
