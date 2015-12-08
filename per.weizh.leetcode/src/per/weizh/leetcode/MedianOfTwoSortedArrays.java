package per.weizh.leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	int i = 0, k = 0, mid =(n+m)/2 ,rad = (m+n)%2;
    	int count = 0;
    	int[] arr = new int[mid+1];
    	while(i<m || k < n){
    		if(count>mid)
    			break;
    		if(i>=m){
    			arr[count++] = nums2[k++];
    		}else if(k>=n){
    			arr[count++] = nums1[i++];
    		}else if(nums1[i]<=nums2[k]){
    			arr[count++] = nums1[i++];
    		}else 
    			arr[count++] = nums2[k++];
    	}

    	return (rad==0?(double)(arr[mid]+arr[mid-1])/2:arr[mid]);
    	
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {2};
		int[] nums2 ={};
		MedianOfTwoSortedArrays a = new MedianOfTwoSortedArrays();
		double r = a.findMedianSortedArrays(nums1, nums2);
		System.out.println(r);
	}

}
