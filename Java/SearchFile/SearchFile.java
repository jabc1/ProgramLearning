/**
 * @function: �����ļ����а������ļ�
 * @parameter: �ֶ�����Ŀ���ļ���
 * @return: ��������ļ�
 * @author: ywang
 * @date: 2015-10-12
 * 
 */
package Test;

import java.io.*;
import java.util.Scanner;

public class SearchFile
{
	static int level = 0;
	/************************************** �汾1
	public static void fileSearch(File file)
	{
		System.out.println(file.getName() + "/");
		level++;
		for (int j = 0; j < level; j++)
		{
			System.out.print("\t");
		}
		
		File[] listfiles = file.listFiles();
		if (listfiles.length == 0)
		{
			System.out.println("There is no files!");
			return ;
		}
		
		for (int i = 0; i < listfiles.length; i++)
		{
			if (listfiles[i].isDirectory())
			{
				fileSearch(listfiles[i]);
				level--;
			}
			else
			{
				if (i != 0)
				{
					for (int j = 0; j < level; j++)
					{
						System.out.print("\t");
					}
				}
				System.out.println(listfiles[i].getName());
			}
		}
	}
	
	��ʽλ�ã��ǳ����level++ --��λ�õ�
	*******************************************************************/
	
	/***************************** �汾2 **********************************
	public static void fileSearch(File file)
	{
		for (int j = 0; j < level; j++)
		{
			System.out.print("\t");
		}
		System.out.println(file.getName() + "/");
		level++;
		for (int j = 0; j < level; j++)
		{
			System.out.print("\t");
		}
		
		File[] listfiles = file.listFiles();
		if (listfiles.length == 0)
		{
			System.out.println("There is no files!");
			return ;
		}
		
		for (int i = 0; i < listfiles.length; i++)
		{
			if (listfiles[i].isDirectory())
			{
				fileSearch(listfiles[i]);
				level--;
			}
			else
			{
				System.out.println(listfiles[i].getName());
				if (i != listfiles.length - 1)
				{
					for (int j = 0; j < level; j++)
					{
						System.out.print("\t");
					}
				}
				
			}
		}
	}
	**************************************************************************/
	/***************************** �汾3 **************************************/
	public static void fileSearch(File file)
	{
		System.out.println(file.getName() + "/");
		level++;
		
		File[] listfiles = file.listFiles();
		if (listfiles.length == 0)
		{
			System.out.println("There is no files!");
			return ;
		}
		
		for (int i = 0; i < listfiles.length; i++)	// ���ڽ���ˣ���Ŀ¼���ļ���ȫ�ֿ�������̸�ۼ��ɣ��򵥴ֱ�����������
		{
			if (listfiles[i].isDirectory())
			{
				for (int j = 0; j < level; j++)
				{
					System.out.print("\t");
				}
				fileSearch(listfiles[i]);
				level--;
			}
			else
			{
				for (int j = 0; j < level; j++)
				{
					System.out.print("\t");
				}
				System.out.println(listfiles[i].getName());
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please input the directory name: ");
		String filename = input.next();	// "./": Exercise/ �ļ���		"../": workspace/ �ļ���
		
		File file = new File(filename);
		if (! file.exists())
		{
			System.out.println(filename + " does not exist!");
			System.exit(0);
		}
		
		if (file.isDirectory())
		{
			fileSearch(file);
		}
		else
		{
			System.out.println(file.getName() + " is not a directory!");
		}
		
		input.close();
	}
}
