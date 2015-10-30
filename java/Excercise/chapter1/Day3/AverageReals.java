/*
 * reads in a sequence of real numbers from standard input and prints their average
 */

package Day3;

import java.util.Scanner;

public class AverageReals
{
	public static void main(String[] args)
	{
		Scanner sinput = new Scanner(System.in);
		String buffer = sinput.nextLine();
		
		String[] buffers = buffer.trim().split(" ");
		double sum = 0.0;
		
		for (int i = 0; i < buffers.length; i++)
		{
			sum += Double.parseDouble(buffers[i]);
		}
		
		double average = sum / buffers.length;
		System.out.println("The average is " + average);
		
		sinput.close();
 	}
}

/**
 * ���������ض������		�ܼ򵥣� >
 * 	java AverageReals 1.1 2.2 3.3 > data.txt
 * 
 * ���������ض�������			�� <
 * 	java AverageReals < data.txt
 * 
 * �ܵ� piping Connecting two programs. The most flexible way to implement the standard input and standard output abstractions is to specify that they are implemented by our own programs
 * 	java RandomSeq 100 | java AverageReals
 * piping the output of one program to the input of another
 * �ȼ��ڣ�(����Ҫʹ���м��ļ� data1.txt����)
 * 	java RandomSeq 100 > data1.txt
 * 	java AverageReals < data1.txt
 *
 * ��������Filter
 * 	java RandomSeq 10 | sort	// ����
 * 	java RandomSeq 100 | more	// one screenful to show with once space bar	
 * 
 */
