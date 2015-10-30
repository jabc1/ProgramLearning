package Day2;

public class PrimeCount
{
	public static void main(String[] args)
	{
		int N = Integer.parseInt(args[0]);
		
		// ��ʡ�ռ�  boolean int 
		char primeSieve[] = new char[N+1];
		for (int i = 2; i <= N; i++)
		{
			primeSieve[i] = '1';
		}
		
		for (int i = 2; i*i <= N; i++)
		{
			if (primeSieve[i] == '1')
			{
				/*
				int j = 2 * i;
				while (j <= N)
				{
					primeSieve[j] = '0';
					j += i;
				}*/
				for (int j = i; i * j <= N; j++)
				{
					// i*i ��ʼ���߼�����ȷ��!!!! ��ΪС�� i*i�Ķ������ˡ����� 2i,3i and so forth ��2�ı�����3�ı���etc���ǵġ�
					primeSieve[i*j] = '0';
				}
			}
		}
		
		int count = 0;
		for (int i = 2; i <=N; i++)
		{
			if (primeSieve[i] == '1')
			{
				count++;
			}
		}
		System.out.println("Counts of prime <= " + N + " is " + count);
	}
	
}
