package self.sort;

import leecode.basic.ListNode;

public class bubbleSort {
	public void sortArray(int []arr){
		int tmp;
		for(int i = 0 ;i<arr.length ;i++){
			for(int j = 0;j<arr.length -1-i;j++){
				if(arr[j]>arr[j+1]){
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public void sortList(ListNode head){
		//不可换
		
	}
	
	public static void main(String []args){
		bubbleSort bs = new bubbleSort();
		int arr[] = {1,7,5,2,4,6};
		bs.sortArray(arr);
		for(int i :arr){
			System.out.println(i);
		}
	}
}
