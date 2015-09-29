/**************************************************************
* 360������1
* �����磺
    ����: m,n   2�������� m ������m��ͬѧ��n����n���ϵ
        n�й�ϵ���룡
        ���� m,n
        ...
        m = 0, n = 0ʱ�����������

    �����n    �������

    ��������ͬһ���ط���ͬѧ�������硣

    3 1
    2 4
    2 6

    2 (2��ͬѧ��������)

    ˼·�����ཻ��
        ����ͬһ���ط���������ͬ�ĸ��ڵ㣬ͳ�Ƽ��ϴ�С����
        union() / find()
********************************************************************/


#include <iostream>

int students[1001]; // ѧ�����飬����ѧ������������1000

void init(int students[], int len);
int find(int stu);

int main()
{
    using namespace std;

    int stu1;
    int stu2;
//    int stu = 1;    // ��ҪѰ����������ͬѧ��С��

    while (true)
    {
        int m;
        int n;
        cin >> m >> n;
        if (m == 0 && n == 0)
        {
            break;
        }

        init(students, 1001);

        while (n--)
        {
            cin >> stu1 >> stu2;
            int root1 = find(stu1);
            int root2 = find(stu2);

            students[root1] += students[root2] - 1;

            students[stu2] = root1;
            students[root2] = root1;
 //           for (int i = 0; i <= m; i++)
 //           {
 //               cout << students[i] << endl;
 //           }
        }

        int poeple = 0 - students[find(1)];

        cout << poeple << endl;
    }
    return 0;
}

void init(int students[], int len)
{
    for (int i = 1; i < len; i++)
    {
        students[i] = 0;
    }
}

int find(int stu)
{
    if (students[stu] > 0)
    {
        return find(students[stu]);
    }
    return stu;
}
