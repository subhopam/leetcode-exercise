/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

 */



import java.util.Arrays;

class MedianSortArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int resultNum[]=new int[]{};
        if(nums1.length ==0 && nums2.length ==0){
            return 0.0;
        }else if(nums1.length ==0 && nums2.length > 0){
            resultNum= nums2;
        }else if(nums2.length ==0 && nums1.length > 0 ){
            resultNum= nums1;
        }else{
            resultNum=this.mergeTwoSortedArrays(nums1,nums2);
        }
        System.out.println(Arrays.toString(resultNum));

        if(resultNum.length%2==0){
            return (double)(resultNum[resultNum.length/2-1]+resultNum[resultNum.length/2])/2;
        }else{
            return (double)resultNum[(int)(resultNum.length/2)];
        }
    }

     public int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
         int resultNum[]=new int[nums1.length+nums2.length];
         int i=0,j=0,k=0;

         while(nums1.length>0 && nums2.length>0 && i<nums1.length && j < nums2.length && k <resultNum.length){
             if(nums1[i] < nums2[j]){
                 resultNum[k]=nums1[i];
                 i++;
             }else if(nums1[i] > nums2[j]){
                 resultNum[k]=nums2[j];
                 j++;
             }else if(nums1[i] == nums2[j]){
                 resultNum[k]=nums1[i];
                 System.out.println("resultNum[k] assigned nums1[i] "+k+" "+nums1[i]);
                 i++;

             }
             k++;
         }
         if(i< nums1.length){
             //copy all remaining values of nums1 into resultNum
             for(int index=i;index<nums1.length;index++){
                 resultNum[k]=nums1[index];
                 k++;
             }
         }else if(j< nums2.length){
             //copy all remaining values of nums1 into resultNum
             for(int index=j;index<nums2.length;index++){
                 resultNum[k]=nums2[index];
                 k++;
             }
         }
         System.out.println("Returning "+Arrays.toString(resultNum));
         return resultNum;

    }
}
