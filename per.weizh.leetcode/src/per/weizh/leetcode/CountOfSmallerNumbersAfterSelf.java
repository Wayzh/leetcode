package per.weizh.leetcode;

import java.util.ArrayList;

class Solution {
	class Pair{
		public final int val;
		public final int index;
		public Pair(){
			this.val = 0;
			this.index = 0;
		}
		public Pair(int val,int index){
			this.val = val;
			this.index = index;
		}
	}
	public void merge(Pair[] p_arrs,int[] res ,int start_1,int end_1,int start_2,int end_2 ){
		int cur1 = start_1, cur2 = start_2;
		Pair[] tmp = new Pair[end_2-start_1+1];
		int count = 0;
		int i = 0;
		while(cur1<=end_1 || cur2 <=end_2){
			if(cur1> end_1){ 
//				System.out.println(p_arrs[cur2].index + " : " + p_arrs[cur2].val );
				tmp[i++] = p_arrs[cur2++];
				
				
			}else if(cur2>end_2){
				res[p_arrs[cur1].index] += count; 
//				System.out.println(p_arrs[cur1].index + " : " + p_arrs[cur1].val );
				
				tmp[i++] = p_arrs[cur1++];
			}else if(p_arrs[cur1].val > p_arrs[cur2].val){
				
				tmp[i++] = p_arrs[cur2++];
				count++;	
//				System.out.println(p_arrs[cur1].index + " : " + p_arrs[cur1].val);
			}else
			{
//				System.out.println(p_arrs[cur1].index + " : " + p_arrs[cur1].val);
				res[p_arrs[cur1].index] += count; 
				tmp[i++] = p_arrs[cur1++];	
			}
			
		}
		for(int k = 0 ; k < end_2-start_1+1;k++)
		{
			p_arrs[start_1+k] = tmp[k];
		}
	}
	public void merge_sort(Pair [] p_arrs ,int[] res ,int start,int end){
		if(start>=end)
			return;
		int mid = start+(end-start)/2;
		merge_sort(p_arrs,res,start,mid);
		merge_sort(p_arrs,res,mid+1,end);
		merge(p_arrs,res,start,mid,mid+1,end);
	
	}
    public ArrayList<Integer> countSmaller(int[] nums) {
    	ArrayList<Integer> list =new ArrayList<Integer>();
    	int length = nums.length;
    	int[] res = new int [length];
    	Pair [] p_arrs = new Pair[length];
    	for (int i = 0 ; i < length ; i++){
    		p_arrs[i] = new Pair(nums[i],i);
    	}
    		
    	merge_sort(p_arrs,res,0,length-1);
    	for(int i = 0 ; i< length ; i++){
    		list.add(res[i]);
    	}
		return list;
    }


}
public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试样例
		int [] a = { 5, 2, 6, 1 };
		Solution test = new Solution();
		ArrayList<Integer> list = new ArrayList<Integer>();	
		list = test.countSmaller(a);
		System.out.println(list.toString());
		
	}

}
