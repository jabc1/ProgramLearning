/**
	暗黑的字符串
		一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串就是暗黑的。例如：
		BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
		AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
		你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。 
	
	输入描述:
		输入一个整数n，表示字符串长度(1 ≤ n ≤ 30)
	输出描述:
		输出一个整数表示有多少个暗黑字符串
	输入例子:
		2
		3
	输出例子:
		9
		21
*/
#include <iostream>

using namespace std;

long long NumsOfBlackString(int n){
	if (n == 1){
		return 3;
	}
	long long a = 3;
	long long b = 9;
	
	while (n > 2){
		long long c = 2 * b + a;
		a = b;
		b = c;
		n--;
	}
	return b;
}

int main(){
	int n = 0;
	while (cin >> n){
		cout << NumsOfBlackString(n) << endl;
	}
	return 0;
}