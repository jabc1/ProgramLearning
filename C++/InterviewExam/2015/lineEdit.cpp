/*******************************************************************************************
*
* 360������
* �б༭����
    ���룺��һ�� ����n��������n������������Ҫ����
            ����n���ַ�����
        �ַ���С��100��ÿ���ַ�һ����('a'~'z','A'~'Z', '*', '!', '(', ')', '+', '@', '#')�е�һ��
    �����n�У�
        ��������'#'����ɾ����ǰ��һ���ַ�������'@',��ɾ����ǰ���һ���С�

    test:
    3
    whli##ilr#e(s#*s)
    outcha@putchar(*s=#++)
    returnWA##A!!##C

    while(*s)
    putchar(*s++)
    returnAC
*********************************************************************************************/

#include <iostream>
#include <string>
#include <stdio.h>

using namespace std;

int main()
{
    int n = 0;
    string str_input;
    char output[100];   // ʹ�� string ���У�������

    cin >> n;

    while (n--)
    {
        cin >> str_input;

        int j = 0;
        for (unsigned int i = 0; i < str_input.size(); i++)
        {
            if (str_input[i] == '#')
            {
                j--;
            }
            else if (str_input[i] == '@')
            {
                j = 0;
            }
            else
            {
                if (j < 0)
                {
                    j = 0;
                }
                output[j++] = str_input[i];
            }
        }
        output[j] = '\0';

        cout << output << endl;
    }
    return 0;
}

