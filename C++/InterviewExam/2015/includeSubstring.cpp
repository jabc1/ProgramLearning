/*
* ������Ŀ
*
 	�Ӵ��������⣺
		�����ַ���a�����ܰ�������(˫�ֽڣ����ֽڵ�һλΪ 1)
		�����ַ���b�����ܺ��к���
		
		�����ж�b���ַ��Ƿ���a�г����ˣ��������ظ��ַ�ʱ��a����������ͬ�Ĵ������С�
		
		���������������ˣ������1���������0(��ӡ)
*/


#include <iostream>
#include <string>

using namespace std;

int isSubstr(string str_a, string str_b);
int hashArray[1000] = {0};    // ���費����һǧ���ַ���

int main()
{
    string str_a;
    string str_b;

    cin >> str_a;
    cin >> str_b;

    cout << isSubstr(str_a, str_b) << endl;

    return 0;
}

int isSubstr(string str_a, string str_b)
{
    wchar_t ch;
    int flag = 1;

    for (unsigned int i = 0; i < str_a.size(); i++)
    {
        ch = str_a[i];
        int index = ch - 'A';
        cout << index << endl;
        hashArray[index]++;
    }

    for (unsigned int i = 0; i < str_b.size(); i++)
    {
        ch = str_b[i];
        int index = ch - 'A';
        cout << index << endl;
        if (hashArray[index] < 1)
        {
            flag = 0;
        }
        else
        {
            hashArray[index]--;
        }
    }

    return flag;
}
