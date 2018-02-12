/*
 * ���������⣺������⹤�� jstack
 * ������������: ����ռ��һЩ��Դ(��)���ȴ�һЩ��Դ(��)
 * ���룺�ַ������� n
 * 		n�У�����id ռ����id(�б�',') �ȴ���id(�б�',') �ո��ʾ����Դ!!!
 * 		example
 * 		7
 * 		123 1001,1002 1003
 * 		127   1100
 * 		128 1010
 * 		129
 * 		124 1007 1008
 * 		125 1003 1004
 * 		126 1004 1002
 * �������������  int
 * 		1
 * 
 */

package Test;

import java.util.*;
import java.io.*;

public class DeadLock
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		int n;
		if(input.hasNext())
			n = (int) input.nextInt();
		else 
			n=0;
		
		ArrayList[] id_have = new ArrayList[n];
		ArrayList[] id_wait = new ArrayList[n];
		for (int i = 0; i < n; i++)
		{
			id_have[i] = new ArrayList();
			id_wait[i] = new ArrayList();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str_in = new String();
		
		for (int i = 0; i< n; i++)
		{
			str_in = br.readLine();
			char char_in[] = str_in.toCharArray();
			String num[] = str_in.split(" ");
			
			//int leng = str_in.length(); // �����ո�
			int len = num[0].length();
			int leng = num.length;
			
			if (leng == 1)
			{
				// û��ռ�н��̺͵ȴ�����
				continue;
			}
			else if (leng == 2)
			{
				if (char_in[len] == ' ')
				{
					// û��ռ�н���
					String wait[] = num[1].split(",");
					for (int w = 0; w < wait.length; w++)
					{
						// ����ֱ���ַ����洢
						id_wait[i].add(wait[w]);
					}
				}
				else
				{
					// û�еȴ�����
					String have[] = num[1].split(",");
					for (int h = 0; h < have.length; h++)
					{
						id_have[i].add(have[h]);
					}
				}
			}
			else
			{
				String have[] = num[1].split(",");
				for (int h = 0; h < have.length; h++)
				{
					id_have[i].add(have[h]);
				}
				
				String wait[] = num[2].split(",");
				for (int w = 0; w < wait.length; w++)
				{
					id_wait[i].add(wait[w]);
				}
			}
		}
		
		input.close();
		br.close();
		
		// �������
		int counter = 0;
		for (int i = 0; i < n - 1; i++)
		{
			int flag = 0;
			
			Iterator it_h = id_have[i].iterator();
			while (it_h.hasNext())
			{
				int id_h = Integer.parseInt((String)it_h.next());
				
				for (int j = i + 1; j < n; j++)	// j = i+1 ��ǰ���ƣ����ظ�
				{
					Iterator it_w = id_wait[j].iterator();
					while (it_w.hasNext())
					{
						int id_w = Integer.parseInt((String)it_w.next());
						
						if (id_h == id_w)
						{
							flag = 1;	// ���ܼ򵥵�counter++
						}
					}
				}
			}
			
			// һ��ͬʱ�����ȴ���ռ������Դ���б�������ȥһ������������������Դ��ì�����⣡
			// ������ȥ A -> B  B -> C ���������ΪA�Ѿ��ȿ����ˣ������ȿ���B
			Iterator it_w2 = id_wait[i].iterator();
			while (it_w2.hasNext())
			{
				int id_w2 = Integer.parseInt((String) it_w2.next());
				
				for (int j = i + 1; j < n; j++)
				{
					Iterator it_h2 = id_have[j].iterator();
					while (it_h2.hasNext())
					{
						int id_h2 = Integer.parseInt((String) it_h2.next());
						
						if (id_h2 == id_w2)
						{
							flag = 1;	// ���ܼ򵥵�counter++
						}
					}
				}
			}
			
			if (flag == 1)
			{
				counter++;
			}
		}
		
		System.out.println(counter);
		
	}
}



/*****************************************

 		Scanner input = new Scanner(System.in);
		int n;
		if(input.hasNext())
			n = (int) input.nextInt();
		else 
			n=0;
		
		int[][] id_have = new int[n][10];	// �������10����Դ
		int[][] id_wait = new int[n][10];	// �������10����Դ
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str_in = new String();
		
		for (int i = 0; i< n; i++)
		{
			str_in = br.readLine();
			
			// �����ַ�����������Խ�磬�׳��쳣
			char char_in[] = str_in.toCharArray();
			int len = char_in.length;
			
			int j = 0;
			int k = 0;
			int t = 0;
			
			// �������̺�
			String res = new String("");
			while (char_in[j] != ' ')
			{
				res += char_in[j++];
			}
			id_have[i][k++] =  Integer.parseInt(res);	// ����id_have[][0]��
				
			// ����ռ�н��̺�
			if (char_in[j+1] == ' ')
			{
				j = j + 3;
			}
			else
			{
				j = j + 1;
				while(true)
				{
					res = new String("");
					while (char_in[j] != ',' && char_in[j] != ' ')
					{
						res += char_in[j++];
					}
					id_have[i][k++] = Integer.parseInt(res);
					if (char_in[j] == ',')
					{
						j = j + 1;
					}
					else if (char_in[j] == ' ')
					{
						j = j + 1;
						break;
					}
				}
			}
			
			// �����ȴ����̺�
			if (char_in[j] != ' ')
			{
				while(j < len)
				{
					res = new String("");
					while (j < len && char_in[j] != ',' && char_in[j] != ' ')
					{
						res += char_in[j];
						j++;
					}
					id_wait[i][t++] =  Integer.parseInt(res);
					if (j < len && char_in[j] == ',')
					{
						j = j + 1;
					}
					else // if (j < len && char_in[j] == ' ')
					{
						break;
					}
				}
			}
		}
		
7
123 1001,1002 1003
127   1100
128 1010  
129    
124 1007 1008
125 1003 1004
126 1004 1002
 
 *****************************************/
