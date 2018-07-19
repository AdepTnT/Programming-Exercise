/*
	设计一个表示分数的类Fraction。这个类用两个int类型的变量分别表示分子和分母。
	这个类的构造函数是：
	
	Fraction(int a, int b)
	    构造一个a/b的分数。
	
	这个类要提供以下的功能：
	
	double toDouble();
	    将分数转换为double
	Fraction plus(Fraction r);
	    将自己的分数和r的分数相加，产生一个新的Fraction的对象。注意小学四年级学过两个分数如何相加的哈。
	Fraction multiply(Fraction r);
	    将自己的分数和r的分数相乘，产生一个新的Fraction的对象。
	void print();
	    将自己以“分子/分母”的形式输出到标准输出，并带有回车换行。如果分数是1/1，应该输出1。当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出。
	
	注意，在创建和做完运算后应该化简分数为最简形式。如2/4应该被化简为1/2。
	
	
	输入格式:
	程序运行时会得到四个数字，分别构成两个分数，依次是分子和分母。
	
	输出格式：
	输出一些算式。这些输入和输出都是由Main类的代码完成的，你的代码不要做输入和输出。
	
	输入样例：
	2 4 1 3
	
	输出样例：
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