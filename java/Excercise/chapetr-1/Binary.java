package Day1;

public class Binary
{
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		
		String bin = " ";
		
		while (n > 0)
		{
			bin += n % 2;	// ˳��洢 2 ������
			n /= 2;			// ���ϵ�����
		}
		
		System.out.println("Decimal: " + Integer.parseInt(args[0]));
		
		// ������������ɵ�2������������ʹ�� StringBuffer
		StringBuffer sb = new StringBuffer(bin);
		System.out.println("Binary: " + sb.reverse().toString());
	}
}
