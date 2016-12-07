/**
	计算糖果
		A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
		A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
		现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。 
		
	输入描述:
		输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。
		范围均在-30到30之间(闭区间)。
	输出描述:
		输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。
		如果不存在这样的整数A，B，C，则输出No
	输入例子:
		1 -2 3 4
	输出例子:
		2 1 3
*/
#include <iostream>
 
using namespace std;
 
int solution(int& a, int& b, int& c, int d){
    int sum2A = a + c;
    int sum2B = b + d;
    if (sum2A % 2 != 0 || sum2B % 2 != 0){
        return -1;
    }
     
    int A = sum2A / 2;
    int B = sum2B / 2;
    int B2 = c - A;
    if (B != B2){
        return -1;
    }
     
    a = A;
    b = B;
    c = d - b;
    return 0;
}
 
int main(){
    int ab = 0;
    int bc = 0;
    int ba = 0;
    int cb = 0;
     
    while (cin >> ab >> bc >> ba >> cb){
        if (solution(ab, bc, ba, cb) == 0){
            cout << ab << " " << bc << " "  << ba << endl;
        }
        else{
            cout << "No" << endl;
        }
    }
    return 0;
}
