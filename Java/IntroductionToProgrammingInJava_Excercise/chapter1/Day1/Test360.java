/*
 * 360 ������Ŀ1��
 * 		�����������¹��ܣ�����������ġ����������ӡ� 2,3,5,7...
 * 		��������ַ�����ͼ ��5*3 
 **************
 -   
| |

| |
 - 
**************

 |

 |

**************
 - 
  |
 -
| 
 - 
**************

| |
 - 
  |
  
**************
 - 
| 
 - 
  |
 - 
**************
 -
|
 -
| |
 - 
**************
 - 
  |
 
  |
 
**************
 -
| |
 -
| |
 _ 
**************
 -
| |
 -
  |
 - 
**************
 * 		���룺 66
 * 		����� * ���߸�һ���ո�
 -     -
  |     |    |   |
 -  *  -  *   
|       |    |   |
 -     -
 
 ˼·��
 	��һ����������е�  prime factor	(��Ҫ�洢)
 	�ڶ����������������ӣ���λ���ֽ��Ϊһλһλ�� eg:17 = 1 7	(��Ҫ�洢)
 		������Ҫ�������λ��
 		while(i < n)
		{
			i *= 10;
		}
		while(n >= 0)
		{
			i /= 10;
			remainder = n / i;
			n = n - i * remainder;
		}

 	��������һ��һ�����������֮��������ո񣬵����м�  ��*��
 	ʵ�֣������ִ洢�ھ���֮�У��������
 */

package Day1;

import java.util.Scanner;

public class Test360
{                      
	char gui[ ][  ] = {{' ','-',' ',  ' ',' ',' ',  ' ','-',' ',  ' ','-',' ',  ' ',' ',' ',  ' ','-',' ',  ' ','-',' ',  ' ','-',' ',  ' ','-',' ',  ' ','-',' '},
			     	   {'|',' ','|',  ' ','|',' ',  ' ',' ','|',  ' ',' ','|',  '|',' ','|',  '|',' ',' ',  '|',' ',' ',  ' ',' ','|',  '|',' ','|',  '|',' ','|'},
			     	   {' ',' ',' ',  ' ',' ',' ',  ' ','-',' ',  ' ','-',' ',  ' ','-',' ',  ' ','-',' ',  ' ','-',' ',  ' ',' ',' ',  ' ','-',' ',  ' ','-',' '},
			     	   {'|',' ','|',  ' ','|',' ',  '|',' ',' ',  ' ',' ','|',  ' ',' ','|',  ' ',' ','|',  '|',' ','|',  ' ',' ','|',  '|',' ','|',  ' ',' ','|'},
			     	   {' ','-',' ',  ' ',' ',' ',  ' ','-',' ',  ' ','-',' ',  ' ',' ',' ',  ' ','-',' ',  ' ','_',' ',  ' ',' ',' ',  ' ','-',' ',  ' ','-',' '}};
/*	                    
 * 0:(0-2)	1:(3-5)	2:(6-8)	3:(9-11)	n:(3n-3n+2)
 * ���ַ����У����Ҷ�Ӧ�����֣�һ��һ�������������������ÿ�������ٽ�����
 */
	
 	public void myPrint(int n)
	{
 		int i = 1;
 		System.out.println("�������");
		while (n > 0)
		{
			System.out.println("�� " + i + " :");
			myPrintGUI(n % 10);
			i++;
			n /= 10;
		}
	}
	
 	public void myPrintGUI(int n)
	{
		switch (n)
		{
			case 0:print0();break;
			case 1:print1();break;
			case 2:print2();break;
			case 3:print3();break;
			case 4:print4();break;
			case 5:print5();break;
			case 6:print6();break;
			case 7:print7();break;
			case 8:print8();break;
			case 9:print9();break;
			default: break;
		}
	}
	
 	// ����������У����������һ��
	public void print0()
	{
		System.out.println(" - ");
		System.out.println("| |");
		System.out.println("   ");
		System.out.println("| |");
		System.out.println(" - ");
	}

	public void print1()
	{
		System.out.println("   ");
		System.out.println(" | ");
		System.out.println("   ");
		System.out.println(" | ");
		System.out.println("   ");
	}

	public void print2()
	{
		System.out.println(" - ");
		System.out.println("  |");
		System.out.println(" - ");
		System.out.println("|  ");
		System.out.println(" - ");
	}

	public void print3()
	{
		System.out.println(" - ");
		System.out.println("  |");
		System.out.println(" - ");
		System.out.println("  |");
		System.out.println(" - ");
	}

	public void print4()
	{ 
		System.out.println("   ");
		System.out.println("| |");
		System.out.println(" - ");
		System.out.println("  |");
		System.out.println("   ");
	}

	public void print5()
	{
		System.out.println(" - ");
		System.out.println("|  ");
		System.out.println(" - ");
		System.out.println("  |");
		System.out.println(" - ");
	}

	public void print6()
	{
		System.out.println(" - ");
		System.out.println("|  ");
		System.out.println(" - ");
		System.out.println("| |");
		System.out.println(" - ");
	}

	public void print7()
	{
		System.out.println(" - ");
		System.out.println("  |");
		System.out.println("   ");
		System.out.println("  |");
		System.out.println("   ");
	}
	
	public void print8()
	{
		System.out.println(" - ");
		System.out.println("| |");
		System.out.println(" - ");
		System.out.println("| |");
		System.out.println(" - ");
	}
	
	public void print9()
	{
		System.out.println(" - ");
		System.out.println("| |");
		System.out.println(" -  ");
		System.out.println("  |");
		System.out.println(" - ");
	}
	
	
	public void factor(int n)
	{
		System.out.println("The factors is :");
		for (int i = 2; i <= n; i++)
		{
			if (n % i == 0)
			{
				while (n % i == 0)
				{
					n /= i;
				}
				myPrint(i);
				System.out.println("");
			}
		}
	}
	public static void main(String[] args)
	{
		Test360 obj = new Test360();
		
		System.out.println("Please input a number:");
		
		Scanner input = new Scanner(System.in);
		int n;
		if(input.hasNext())
			n = (int) input.nextInt();
		else 
			n=0;
		
		input.close();
		obj.factor(n);
	}
}




 

  


