package com.whir.fxfk.test;
import java.util.ArrayList;
import java.util.List;


public class TestAction {
	
	
	
	public static void main(String[] args) {
		//yuesefuhuan(10,3);
		//System.out.println(2%100-1);
		yuesefuhuan1(3,10,0);
	}
	
	
	public static void yuesefuhuan(int size, int num) {
		int arr[] = new int[size];
		for (int k = 0; k < arr.length; k++) {
			arr[k] = k;
		}
		int count = 0;// ����
		int nowSize = size;// ���ڵ�ʣ������
		for (int i = 0; nowSize != 0; i = (i + 1) % size) {
			if (arr[i] != -1) {
				if (count++ == num) {// ɾ��
					
					arr[i] = -1;
					nowSize--;
					count = 0;
				}
			}
		}
		for (int k = 0; k < arr.length; k++) {
			System.out.println(arr[k]);
		}

	}
	
	/*
	Լɪ�򻷣���֪n����(�Ա��1��2��3...n�ֱ��ʾ)
	Χ����һ��Բ����Χ���ӱ��Ϊk���˿�ʼ������m���Ǹ��˳���;
	�����һ�����ִ�1��ʼ������m���Ǹ����ֳ���;���˹����ظ���ȥ��
	ֱ��Բ����Χ����ȫ�����С�
	*/
	
	/**
	 * ������� maxInt
	 * ��ʼ���� startInt
	 * �����С����  size
	 * 
	 * 
	 */
	public static void yuesefuhuan1(int size, int maxInt,int startInt) {
		//int x=1,y=2,z=3;
		//System.out.println(y+=z--/++x);
		
		//System.out.println(y+=--z/++x);
		
		//����x=1����y=x++����y=1����y=++x����y=2�������˰ɡ�
		
		int x=1;
		//int y=x--;
		int y=--x;
		System.out.println("========7777777======>"+y);
		
		
		int c=0;
		y=c--;
		System.out.println("======890======>"+c);
		for(int a=0;a<0;a--){
			System.out.println("c====2========>"+c);
			return;
		}
		System.out.println("c======1======>"+c);
		
		List list=new ArrayList();
		for(int i=0;i<maxInt;i++){
			list.add(i+1);
		}
		while(list.size()>0){
			
			
			startInt=startInt+size;
			startInt =startInt % (list.size()) - 1;
			
			
//			System.out.println("startInt========>"+startInt);
			
			// �ж��Ƿ񵽶�β
			if (startInt < 0) {
				//System.out.println(list.get(list.size() - 1));
				list.remove(list.size() - 1);
				startInt = 0;
			} else {
				//System.out.println(list.get(startInt));
				list.remove(startInt);
			}
			
			
			
		}
		
		
	}
}
