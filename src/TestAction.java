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
		int count = 0;// 计数
		int nowSize = size;// 存在的剩余数组
		for (int i = 0; nowSize != 0; i = (i + 1) % size) {
			if (arr[i] != -1) {
				if (count++ == num) {// 删除
					
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
	约瑟夫环：已知n个人(以编号1，2，3...n分别表示)
	围坐在一张圆桌周围。从编号为k的人开始报数，数到m的那个人出列;
	他的下一个人又从1开始报数，数到m的那个人又出列;依此规律重复下去，
	直到圆桌周围的人全部出列。
	*/
	
	/**
	 * 最大数字 maxInt
	 * 开始数字 startInt
	 * 报数大小出列  size
	 * 
	 * 
	 */
	public static void yuesefuhuan1(int size, int maxInt,int startInt) {
		//int x=1,y=2,z=3;
		//System.out.println(y+=z--/++x);
		
		//System.out.println(y+=--z/++x);
		
		//假设x=1，若y=x++，则y=1，若y=++x，则y=2，明白了吧。
		
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
			
			// 判断是否到队尾
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
