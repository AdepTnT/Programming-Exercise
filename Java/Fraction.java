/*
	���һ����ʾ��������Fraction�������������int���͵ı����ֱ��ʾ���Ӻͷ�ĸ��
	�����Ĺ��캯���ǣ�
	
	Fraction(int a, int b)
	    ����һ��a/b�ķ�����
	
	�����Ҫ�ṩ���µĹ��ܣ�
	
	double toDouble();
	    ������ת��Ϊdouble
	Fraction plus(Fraction r);
	    ���Լ��ķ�����r�ķ�����ӣ�����һ���µ�Fraction�Ķ���ע��Сѧ���꼶ѧ���������������ӵĹ���
	Fraction multiply(Fraction r);
	    ���Լ��ķ�����r�ķ�����ˣ�����һ���µ�Fraction�Ķ���
	void print();
	    ���Լ��ԡ�����/��ĸ������ʽ�������׼����������лس����С����������1/1��Ӧ�����1�������Ӵ��ڷ�ĸʱ������Ҫ����������֣���31/30��һ����ȷ�������
	
	ע�⣬�ڴ��������������Ӧ�û������Ϊ�����ʽ����2/4Ӧ�ñ�����Ϊ1/2��
	
	
	�����ʽ:
	��������ʱ��õ��ĸ����֣��ֱ𹹳����������������Ƿ��Ӻͷ�ĸ��
	
	�����ʽ��
	���һЩ��ʽ����Щ��������������Main��Ĵ�����ɵģ���Ĵ��벻Ҫ������������
	
	����������
	2 4 1 3
	
	���������
	1/2
	1/3
	5/6
	1
	1/2
	1/3
*/
package main;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}
}

class Fraction {
	private int fz=1;
	private int fm=1;
	
	Fraction(int a,int b) 
	{
		fz=a;
		fm=b;
		fz=simp(this).fz;
		fm=simp(this).fm;
	}
	
	public double toDouble() 
	{
		return (double)fz/fm;
	}


	public Fraction plus(Fraction r) {
		Fraction res=new Fraction(1,1);
		res.fz=fz*r.fm+fm*r.fz;
		res.fm=fm*r.fm;
		
		return simp(res);
	}

	public Fraction multiply(Fraction r) {
		Fraction res=new Fraction(1,1);
		res.fz=fz*r.fz;
		res.fm=fm*r.fm;
		
		return simp(res);
	}

	public void print() {
		if(fm==1)
		{
			System.out.println(fz);
		}
		else
		{
			System.out.println(fz+"/"+fm);
		}
	}
	
	public static int gcd(int a,int b)
	{
		int r=1;
		while(r!=0)
		{
			r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
	
	public static Fraction simp(Fraction r) 
	{
		int gcd=gcd(r.fz,r.fm);
		r.fz/=gcd;
		r.fm/=gcd;
		return r;
	}
}