package Day1;

public class NewtonSqrt
{
	public static void main(String[] args)
	{
		double x = Double.parseDouble(args[0]);
		if (x < 0)
		{
			System.out.println("Parameter is complex number");
			return ;
		}
		double new_t = 1.0;
		double old_t = 1e-15;
		// while (t != x/t) ����С����������ѭ��...
		while (new_t != old_t)	
		{
			old_t = new_t;
			new_t = (old_t + x / old_t) / 2;
			
			//System.out.println("t:  " + new_t); // �仯����
		}
		System.out.println("The sqrt of " + x + " is:" + new_t);
	}
}

/*
 * Standard:
 * epsilon��relative error tolerance
 *  
 * double epsilon = 1e-15;
 * while (Math.abs(t - x/t) > epsilon) t = (t + x/t)/2;
 */
