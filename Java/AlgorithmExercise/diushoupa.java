/*
 * author : ywang
 * function: ɾ����m������
 * date :2015/1/19
 * *************************************
 * ��ϰ���������
 */

package com.ywang;

public class diushoupa
{
	public static void main(String[] args)
	{
		CycLink mylink = new CycLink();
		mylink.setK(5);
		mylink.setM(7);
		mylink.printLink();
		Child first = mylink.first();
		while (!mylink.empty()){
			first = mylink.play(first);
		}
	}
}

class Child
{
	int data;
	Child next = null;
	
	public Child(int data)
	{
		this.data = data;	//���
	}
}

class CycLink
{
	//�ȶ���ָ���һ��С��������
	Child firstChild = null;  //ָ���һ��С�������ò��ܸı䡣
	Child index = null;  //�α꣬����
	int length = 0;    //С������
	int k = 0;
	int m = 0;
	
	public CycLink(int l){
		this.length = l;
		createLink();
	}
	
	public CycLink(){
		this.length = 16;
		createLink();
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public boolean empty(){
		return length == 0;
	}
	
	//���ÿ�ʼ����С�����
	public void setK(int k)
	{
		this.k = k;
	}
	
	//����m��ɾ����m��С��
	public void setM(int m)
	{
		this.m = m;
	}
	
	public Child first(){
		return firstChild;
	}
	
	public Child play(Child first)
	{
		Child temp = first;
		//�ҵ���m��С��
		for ( int i=1; i<k; i++)
		{
			temp = temp.next;
		}
		//ɾ����m��С��
		for (int j=1; j<m-1;j++)
		{
			temp = temp.next;
		}
		Child del = temp.next;
		System.out.println(del.data);
		temp = del.next;//�������м��temp.next
		this.length--;
		
		return temp;
	}
	
	
	//��ʼ����������
	public void createLink()
	{
		for (int i=1; i<=length; i++)
		{
			if (i==1)
			{
				//������һ��С��
				Child ch = new Child(i);
				this.firstChild = ch;
				this.index = firstChild;
			}
			else 
			{
				if (i == length)
				{
					Child ch = new Child(i);
					index.next = ch;
					index = ch;
					index.next = this.firstChild;	
				}
				else
				{
					Child ch = new Child(i);
					index.next = ch;
					index = ch;
				}
			}
		}
	}
	
	//��ӡ
	public void printLink()
	{
		//�����α�
		Child temp = this.firstChild;
		do
		{
			if (temp == null){
				System.out.println("No");
				break;
			}
			System.out.println(temp.data);
			temp = temp.next;
		}while (temp != this.firstChild);
		System.out.println();
	}
}