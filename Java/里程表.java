/*
 ��ĳ���Ҫ����һ�ű�Ȼ�󣬸���������������е����ƣ���������������֮�����̡�

ע�⣺�κ���������֮�����̶��Ѿ�����������Ҫ���㾭��������ת��
ע�⣺�㲢����Ҫȥ¼����ͼ�����ݣ��������ڳ��������и��ġ�

�����ʽ:
���ȣ����������ɸ����е����֡�ÿ�����ֶ�ֻ��һ��Ӣ�ĵ��ʣ��м䲻���ո���������š�����������Ϊ��###��������#�ţ�ʱ����ʾ�����������������###������һ�����е����֡�����Ƕ����ĳ������ֵ�����Ϊn��
Ȼ��������nxn��һ���������󡣵�һ�е�ÿһ�����֣���ʾ�������������е�һ���������ε���һ������֮�����̡�����ͬһ������֮������Ϊ0��
����������������е����֡�

�����ʽ��
�������������֮��ľ��롣

����������
Hagzou	Hugzou	Jigxng    ###
0	1108	708
1108	0	994
708	994	0
Hagzou    Jigxng

���������
708
 */

package main;

import java.util.ArrayList;
import java.util.Scanner;

class MileTable{

	private ArrayList<String>  city=new ArrayList<String>();
	private int [][]mile;
	Scanner in =new Scanner(System.in);
	MileTable(){
		String cityName=in.next();
		while(!(cityName.equals("###")))
		{
			city.add(cityName);
			cityName=in.next();
		}
		mile=new int[city.size()][city.size()];
	}
	
	public void setMile()
	{
		
		for(int i=0;i<city.size();i++)
		{
			for(int j=0;j<city.size();j++)
			{
				mile[i][j]=in.nextInt();
			}
		}
	}
	
	public int getMile()
	{
		String start=in.next();
		String end=in.next();
		return mile[city.indexOf(start)][city.indexOf(end)];
	}	
}


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MileTable mt =new MileTable();
		mt.setMile();
		System.out.println(mt.getMile());
		
	}
}

