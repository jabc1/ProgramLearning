/*
�εα��Ե�һ�⣺
	��2*2�Ӿ��������
	���룺һ������ 1 2 3;3 4 5;6 7 8...
		��Ҫ�������룺��ȡ����m, ����n(C++��֪����ô������%d���ܶ�ȡ";"��%c����̫���ѣ�������֪�����ֵĴ�С)
		���� java��split()�����������ǳ�����
	�����2*2���Ӿ��󣬱�֤������
	˼·��û�кð취����٣�
	
*/

package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str_in = new String();
		str_in = br.readLine();	// ��ȡ����
		
		String num[] = str_in.split(";");	// �ָ�
		int m = num.length;	// ������
		int n = 0;
		
		String num1[] = num[0].split(" ");
		n = num1.length;	// ������
		
		int[][] arr = new int[m][n];
		int maxsum = 0;
		
		for (int i = 0; i < m; i++)
		{
			String[] num2 = num[i].split(" ");
			for (int j = 0; j < n; j++)
			{
				arr[i][j] = Integer.parseInt((String)num2[j]);	// ����ת��Ϊint
			}
		}
		
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < m-1; i++)
		{
			for (int j = 0; j < n-1; j++)
			{
				int sum = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
				if (sum > maxsum)
				{
					maxsum = sum;
					row = i;
					col = j;
				}
			}
		}
		System.out.println(arr[row][col] + " " + arr[row][col+1]);
		System.out.println(arr[row+1][col] + " " + arr[row+1][col+1]);
	}
}
