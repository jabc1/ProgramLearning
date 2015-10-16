/******************************************************************************
 *  Compilation:  javac StdIn.java
 *  Execution:    java StdIn   (interactive test of basic functionality)
 *  Dependencies: none
 *
 *  Reads in data of various types from standard input.
 *
 ******************************************************************************/
package Day2.IO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class StdIn
{
	/*** begin: section (1 of 2) of code duplicated from In to StdIn. */
	
	// assume Unicode UTF-8 encoding
	private static final String CHARSET_NAME = "UTF-8";
	
	// assume language = English, country = China for consistency with System.out.
	private static final Locale LOCALE = Locale.CHINA;
	
	// the default token separator; we maintain the invariant that this value
	// is held by the scanner's delimiter between calls
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
	
	// ʹ�ÿհ׷�������
	private static final Pattern EMPTY_PATTERN = Pattern.compile("");
	
	// ���ڶ�ȡ��������
	private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
	
	/*** ������ �����1/2���ִ�In���Ƶ�StdIn */
	
	private static Scanner scanner;
	
	// ʵ�����������û�������
	private StdIn(){}
	
	//// ��ʼ������� 2/2���ִ�In���Ƶ�StdIn�������еĹ��з����ĳɹ��о�̬����
	
	// �����׼����Ϊ��(�����������ܾ���������ַ�)���򷵻���
	public static boolean isEmpty()
	{
		return !scanner.hasNext();
	}
	
	// �����׼��������һ�У��򷵻���
	public static boolean hasNextLine()
	{
		return scanner.hasNextLine();
	}
	
	// �����׼�����л����ַ����򷵻���
	public static boolean hasNextCahr()
	{
		// ����scanner�Ķ����
		scanner.useDelimiter(EMPTY_PATTERN);
		boolean result = scanner.hasNext();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}
	
	// ��ȡ��������һ�У� �������зָ���(����У���ɾ��)
	public static String readLine()
	{
		String line;
		try
		{
			line = scanner.nextLine();
		}
		catch (NoSuchElementException e)
		{
			line = null;
		}
		return line;
	}
	
	// ��ȡ��������һ���ַ�
	public static char readChar()
	{
		scanner.useDelimiter(EMPTY_PATTERN);
		String ch = scanner.next();
		assert ch.length() == 1 : "Internal (Std)In.readChar() error!"
			+ " Please contact the authors.";
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return ch.charAt(0);
	}
	
	// ��ȡ����һ���ַ�������ʽ�������е�����
	public static String readAll()
	{
		if (!scanner.hasNextLine())
		{
			return "";
		}
		String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
		// ����scanner�ǿյģ�����˵��λ��������Ǻ���Ҫ������������λ��Ǹ�λһ�¡�
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}
	
	// ��ȡ��һ���ַ�������������ַ���
	public static String readString()
	{
		return scanner.next();
	}
	
	// �ӱ�׼�����ȡ��һ��������ͣ��﷨�Ϸ�����Ϊһ������������������
	public static int  readInt()
	{
		return scanner.nextInt();
	}
	
	// �ӱ�׼�����ȡ��һ��������ͣ��﷨�Ϸ�����Ϊһ�����������ͣ���������
	public static double  readDouble()
	{
		return scanner.nextDouble();
	}
	
	// �ӱ�׼�����ȡ��һ��������ͣ��﷨�Ϸ�����Ϊһ���������ͣ���������
	public static float  readFloat()
	{
		return scanner.nextFloat();
	}
	
	// �ӱ�׼�����ȡ��һ��������ͣ��﷨�Ϸ�����Ϊһ�������Σ����������������
	public static long  readLong()
	{
		return scanner.nextLong();
	}
	
	// �ӱ�׼�����ȡ��һ��������ͣ��﷨�Ϸ�����Ϊһ�������Σ���������
	public static short  readShort()
	{
		return scanner.nextShort();
	}
	
	// �ӱ�׼�����һ���ֽڣ���������
	public static byte readByte()
	{
		return scanner.nextByte();
	}
	
	// �ӱ�׼�����һ����������ֵ��Ȼ�󷵻���
	public static boolean readBoolean()
	{
		String s = readString();
		if (s.equalsIgnoreCase("true"))
		{
			return true;
		}
		else if (s.equalsIgnoreCase("false"))
		{
			return false;
		}
		else if (s.equals("1"))
		{
			return true;
		}
		else if (s.equals("0"))
		{
			return false;
		}
		throw new InputMismatchException();
	}
	
	// �ӱ�׼�����ȡ���п��ܵ�����ֵ��ʹ��һ���ַ������鷵������
	public static String[] readAllStrings()
	{
		// ���ǿ���ʹ�� readAll.trim().split() ���������ǲ��ܱ���һ���ԣ���Ϊ trim() ����ʹ�� 0x00,0x20��Ϊ�հ׷�
		String[] tokens = WHITESPACE_PATTERN.split(readAll());
		if (tokens.length == 0 || tokens[0].length() > 0)
		{
			return tokens;
		}
		
		// ������Կ��ַ���ͷ�ģ���������һ�����
		String[] decapitokens = new String[tokens.length - 1];
		for (int i = 0; i < tokens.length - 1; i++)
		{
			decapitokens[i] = tokens[i+1];
		}
		return decapitokens;
	}
	
	// �ӱ�׼�����У���ȡ�����У����ַ����������ʽ��������
	public static String[] readAllLines()
	{
		ArrayList<String> lines = new ArrayList<String>();
		while (hasNextLine())
		{
			lines.add(readLine());
		}
		
		return lines.toArray(new String[0]);
	}
	
	// ��ȡ���������е�����
	public static int[] readAllInts()
	{
		String[] fields = readAllStrings();
		int [] vals = new int[fields.length];
		for (int i = 0; i < fields.length; i++)
		{
			vals[i] = Integer.parseInt(fields[i]);
		}
		return vals;
	}
	
	// ��ȡ���������е�˫���ȸ�����
	public static double[] readAllDoubles()
	{
		String[] fields = readAllStrings();
		double [] vals = new double[fields.length];
		for (int i = 0; i < fields.length; i++)
		{
			vals[i] = Double.parseDouble(fields[i]);
		}
		return vals;
	}
	
	//// ������ �����(2/2)���ִ�In���Ƶ�StdIn
	
	// ��StdIn����ʼ����ʱ��ִ��һ���������
	static
	{
		resync();
	}
	
	// ���StdIn�����ı䣬ʹ�����������ʼ��scanner
	private static void resync()
	{
		setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
	}
	
	private static void setScanner(Scanner scanner)
	{
		StdIn.scanner = scanner;
		StdIn.scanner.useLocale(LOCALE);
	}
	
	// ��ȡ��������
	public static int[] readInts()
	{
		return readAllInts();
	}
	
	// ��ȡ���е�˫���ȸ�����
	public static double[] readDoubles()
	{
		return readAllDoubles();
	}
	
	// ��ȡ�����ַ���
	public static String[] readStrings()
	{
		return readAllStrings();
	}
	
	// �����ķ�ʽ����Щ��������
	public static void main(String[] args)
	{
		// StdOut.print("Type a string:");
		System.out.print("Type a string:");
		String s = StdIn.readString();
		System.out.println("Your string was: " + s);
		
		
		System.out.print("Type a int:");
		int a = StdIn.readInt();
		System.out.println("Your int was: " + a);
		
	}
}
