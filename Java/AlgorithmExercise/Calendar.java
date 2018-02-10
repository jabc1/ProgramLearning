/*
 * 	������� ��1900���Ժ������ʱ�ڵ���������
 * 
 * д���java Դ���� ��eclipse ���ɿ������е����
 * ���䵼��Ϊjar�ļ����һ�Ҫ�������ļ�-export-jar file
 * ע��һ��Ҫѡ��Main class�������.jar�ļ�,
 * ����ʱʹ�����java -jar xxx.jar
 * ���ߴ���һ��bat�ļ������������������д�����У�
 * ˫��.bat�ļ�ִ��jar�����
 *  �������Ҽ�->����->JavaӦ�ó��򣬳��������ˣ�
 *  ��Ӧ��Ŀ¼��������ɺ�׺Ϊclass���ļ���
 *  ֻҪ��Jre�ĵط�����������class��
 *   ���Ҫ��Ϊexe�Ļ���
 *   ����exe4j������exe�ļ�Ҳ���ԡ�
 */

import java.util.*;
public class Calendar {
	private final int epochYear = 1900;
	private final int[] monthDays = {29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private int year;
	private int month;
	
	public void getInputData(){
		Scanner input = new Scanner(System.in);
		System.out.println("��������ݣ�(���Ϊ��1900�꿪ʼ���������ʱ�䣬�������������磺2018)");
		this.year = input.nextInt();
		while (!checkYear()){
			System.out.println("�Բ������������ݷǷ������ٴ����������ѯ����ݣ�лл��");
			System.out.println("��������ݣ�");
			this.year = input.nextInt();
		}
		System.out.println("�������·ݣ�(�·�Ϊ1,2,...,12�е������·ݡ��磺12)");
		this.month = input.nextInt();
		while (! checkMonth()){
			System.out.println("�Բ�����������·ݷǷ������ٴ����������ѯ���·ݣ�лл��");
			System.out.println("�������·ݣ�");
			this.month = input.nextInt();
		}
	}
	
	private boolean checkYear(){
		return this.year >= this.epochYear;
	}
	
	private boolean checkMonth(){
		return 1 <= this.month && this.month <= 12;
	}
	
	public long calculateDays(){
		long days = 0;
		for (int i = epochYear; i < year; i++){
			days += 365;
			if (((i%4 == 0) && (i%100 != 0)) || (i%400 == 0)){
				days += 1;
			}
		}
		for (int i = 1; i < month; i++){
			days += getMonthDays(i, year);
		}
		return days;
	}
	
	private int getMonthDays(int monthNum, int yearNum){
		if (monthNum == 2 && (((yearNum%4 == 0) && (yearNum%100 != 0)) || (yearNum%400 == 0))){
			return monthDays[0];
		}
		return monthDays[monthNum];
	}
	
	public void printCalendar(long days){
		// ��ӡ��������ͷ
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		// ��λ1���ڱ����е�����λ��
		long offsetDay = days % 7;
		for (int i = 0; i <= offsetDay; i++){
			System.out.print("\t");
		}
		System.out.print("1\t");
		
		// ��ӡ���µ��������ڣ����ΰ���1������˳���ӡ����
		int monthdays = getMonthDays(month, year);
		for (int i = 2; i <= monthdays; i++){
			if((offsetDay + i - 1) % 7 == 6){
				System.out.println();
			}
			System.out.print(i+"\t");
		}
	}
	
	public static void calendarManager(){
		System.out.println("Welcome to my calendar app.");
		Calendar calendar = new Calendar();
		Scanner in = new Scanner(System.in);
		int command = 1;
		while (command == 1){
			calendar.getInputData();
			calendar.printCalendar(calendar.calculateDays());
			System.out.println("\n\n\nContinue to use calendar app? (1/0)");
			command = in.nextInt();
		}
	}
	
	public static void main(String[] args){
		Calendar.calendarManager();
	}
	
	
	
	/*********** version 0.1  ***********/
	private void calendar_01(){
		int sum = 0;
		int i;
		Scanner input = new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year = input.nextInt();
		System.out.println("�������·ݣ�");
		int month = input.nextInt();
		for (i=1900; i<year; i++)
		{
			if (((i%4 == 0) && (i%100 != 0)) || (i%400 == 0))
			{
				sum += 366;
			}
			else
			{
				sum += 365;
			}
		}
		/*
		switch (month)
		{
		case 1: 
		{
			if (month == 1)
			{
				break;
			}
			else
			{
				sum += 31;
			}
		}
		case 2:
		{
			if (month == 2)
			{
				break;
			}
			else
			{
				if(((year%4 == 0) && (year%100 != 0)) || (year%400 == 0))
				{
					sum += 29;
				}
				else 
				{
					sum += 28;
				}
				
			}
		}
		case 3:
		{
			if (month == 3)
			{
				break;
			}
			else
			{
				sum += 31;
			}
		}
		case 4:
		{
			if (month == 4)
			{
				break;
			}
			else
			{
				sum += 30;
			}
		}
		case 5:
		{
			if (month == 5)
			{
				break;
			}
			else
			{
				sum += 31;
			}
		}
		case 6:
		{
			if (month == 6)
			{
				break;
			}
			else
			{
				sum += 30;
			}
		}
		}
		*/
		for (i=1; i<month; i++)
		{
			if (i == 2)
			{
				if (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0))
				{
					sum += 29;
				}
				else
				{
					sum += 28;
				}
			}
			else 
			{
				if ((i == 4) || (i == 6) || (i == 9) || (i == 11))
				{
					sum += 30;
				}
				else 
				{
					sum += 31;
				}
			}
		}
		sum++;   //1�ţ����һ�졣
		int weekday = sum%7;
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		for (i=0; i<weekday; i++)
		{
			System.out.print("\t");
		}
		System.out.print("1\t");
		int monthdays;
		if (month == 2)
		{
			if (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0))
			{
				monthdays = 29;
			}
			else
			{
				monthdays = 28;
			}
		}
		else 
		{
			if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
			{
				monthdays = 30;
			}
			else 
			{
				monthdays = 31;
			}
		}
		for (i=2; i<=monthdays; i++)
		{
			if(sum%7 == 6)
			{
				System.out.println();
			}
			System.out.print(i+"\t");
			sum++;
		}
	}
}
