package per.weizh.leetcode;

import java.awt.List;
import java.util.ArrayList;
class Pair{
	public final int val;
	public final int index;
	public Pair(int val,int index){
		this.val = val;
		this.index = val;
	}
}
class Solution {
	public void merge(Pair[] p_arrs,int[] res ,int start_1,int end_1,int start_2,int end_2 ){
		int cur1 = start_1, cur2 = start_2;
		Pair[] tmp = new Pair[end_2-start_1+1];
		int count = 0;
		while(cur1<=end_1 || cur2 <=end_2){
			if(cur1> end_1){
				
			}
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
    	for (int i = 0 ; i < length ; i++)
    		p_arrs[i] = new Pair(nums[i],i);
    	merge_sort(p_arrs,res,0,length-1);
		return list;
    }


}
public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] a = { 5, 2, 6, 1 };
		Solution test = new Solution();



		
	}

}
