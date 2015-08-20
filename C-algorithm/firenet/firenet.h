/**
* �ǵݹ鷽��
*/
#include <stdio.h>

struct node
{
    int row;
    int column;
    char flag;
};

int flag_stack[16]; //���鵱��ջ�á�
int flag_rank;


Phinecos(��ͥɢ��)
רע�ڿ�Դ�������о���Ӧ��
ZOJ1002 Fire Net(�ǵݹ�棩

��ǰ�õݹ�Ļ�������˼·����һ�Σ��μ�ZOJ1002 Fire Net(�ݹ��)�����������÷ǵݹ�ķ������Կ����Ǻǣ�����������Ҫ�Ѱ�����Ҫ���Ƕ�ջ�﾿����ʲô����һ����˼·һֱû���塣�����������һ���ʱ�䣬�����÷ǵݹ�ķ�����1002��AC���ˣ��ڴ������������˶�ջ��εĸ��ģ��ϵͳ��ջ����Ϊ������������ʱ�����˼�֦��������д�û��Ǻ��ã�����˼����θĽ���
���ƴ���
/********************************
Written by : phinecos(��ͥɢ��)
Data       : 2/11/2008 16:30
Description: �ǵݹ飬ģ��ϵͳ��ջ������ư˻ʺ�����
State : Accepted
Run Time: 0ms
Run Memory:    184KB
****************************************/

#include<iostream>
#include <stack>
using namespace std;

const int MAXSIZE = 4;// ��ͼ����С
char map[MAXSIZE][MAXSIZE];// ��ͼ
int maxNum,n;

struct Node
{
    int row;//��
    int col;//��
    int level;//��ǰ���
};

bool CanPut(int row, int col)
{//�����Ƿ���Է��õﱤ��row��col�д�����Ϊλ���Ǵ�С����ǰ���ģ����ֻ��Ҫ���Աȴ����Ե�С��λ��
    int i;
    //����col�����Ƿ��������ĵﱤ
    for (i = row - 1; i >= 0; --i)
    {
        if (map[i][col] == 'O') return false;
        if (map[i][col] == 'X') break;
    }
    //����row�����Ƿ��������ĵﱤ
    for (i = col - 1; i >= 0; --i)
    {
        if (map[row][i] == 'O') return false;
        if (map[row][i] == 'X') break;
    }
    return true;
}

void Solve(int k,int curNum)
{
    stack<Node> s1;//�������ջ
    Node node;
    int row,col,i;
    int curLevel = 0;//��ǰ���

    //��ʼ�����ջ
    node.row=k/n;
    node.col = k%n;
    node.level = curLevel;//��ǰ��ջ����ǵ�0��
    s1.push(node);

    while (!s1.empty())
    {
        node = s1.top();
        row = node.row;
        col = node.col;

        if (map[row][col]=='.'&&CanPut(row,col)==true)
        {//map[row][col]���в��Ҿ����Կ��Է���,��ռ�ݴ�λ��
            map[row][col] = 'O';
            //��ջ��μ�1
            curLevel++;
            node.level = curLevel;//��Ϊ�����ջ��˵���ͷ��
            s1.pop();
            s1.push(node);
            curNum++;//���õ�������Ŀ��1
        }

        if (row==n-1&&col==n-1)
        {//���������ջ������һ�������
            if (curNum>maxNum)
            {//������һ��������Ŀ
                maxNum = curNum;
            }
            if (curLevel==0)
            {//���ص���0�㣬��˵���Ѿ����������������
                break;
            }

            /*
            *������δ���ǳ��ͼ�Ȥζ���Ҿ�Ȼ��������whileѭ����It's rubbish,��ϲ���!!!!
            */

            //ȥ����ǰ��ջ��
            while (!s1.empty())
            {
                node = s1.top();
                if (node.level==curLevel)
                {
                    s1.pop();
                    --k;
                }
                else
                {
                    curLevel--;
                    curNum--;
                    break;
                }
            }
            //��һ�������ջ��ʱ�ǿյģ���������Ҫ�����������������1����Ϊѭ������������ȥ�ˡ���������
            if(s1.empty())
            {
                curLevel--;
                curNum--;
            }
            //����һ�����ͷ���ָ����������ǰ�'O'�ٴ˱��'.',���Ҳ�θ�Ϊ��һ�㣩
            ++k;
            row = k/n;
            col = k%n;
            map[row][col] = '.';
            node.row = row;
            node.col = col;
            node.level = curLevel;
            s1.push(node);
            //����һ����ͷ������һ�����Ϊ��㣬����
            if (k+1<n*n)
            {
                ++k;
                node.row = k/n;
                node.col = k%n;
                node.level = curLevel;
                s1.push(node);
            }
            else
            {//���������һ��Ԫ��ʱ������һ����������Σ���ʱ��ǰ�������������Ѿ�������ϣ������Ҫ����ǰ��ջ�����յ������������ն�����ǰ����һ���ģ��ɾ�Ȼ�ֵ������˱���룬���ˡ�����
                if (curLevel==0)
                {
                    break;
                }
                while (!s1.empty())
                {
                    node = s1.top();
                    if (node.level==curLevel)
                    {
                        s1.pop();
                        --k;
                    }
                    else
                    {
                        curLevel--;
                        curNum--;
                        break;
                    }
                }

                if (s1.empty())
                {
                    curLevel--;
                    curNum--;
                }
                ++k;
                row = k/n;
                col = k%n;
                map[row][col] = '.';
                node.row = row;
                node.col = col;
                node.level = curLevel;
                s1.push(node);

                ++k;
                node.row = k/n;
                node.col = k%n;
                node.level = curLevel;
                s1.push(node);
            }

        }
        else
        {//��û������һ��ջ��ε����һ���ڵ㣬������
            ++k;
            node.row = k/n;
            node.col = k%n;
            node.level = curLevel;
            s1.push(node);
        }
    }
}

int main()
{
    int i,j;
    while(cin>>n&&n!=0)
    {
        //�����ͼ
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                cin>>map[i][j];
            }
        }
        maxNum=0;//�����ܷ��õ���Ŀ
        //��ʼ����,�������Ϊ���Ͻ�
        Solve(0,0);
        cout<<maxNum<<endl;
    }
    return 0;
}


