/**
	https://leetcode.com/problems/median-of-two-sorted-arrays/
**/

/**
	There are two sorted arrays nums1 and nums2 of size m and n respectively.

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
**/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small, large;
        if(nums1.length<nums2.length) {
            small = nums1;
            large = nums2;
        } else {
            small = nums2;
            large = nums1;
        }
        double median = 0.0;
        boolean odd = false;
        int m = small.length;
        int n = large.length;
        if((m+n)%2 == 1) {
            odd = true;
        }
        int a = 0, b = m, i=0, j=0;
        while(a<=b) {
            // System.out.println("a="+a+"\nb="+b);
            i = (a+b)/2;
            j = (m+n+1)/2 - i;
            // System.out.println("i="+i+"\nj="+j);
            if(i>0 && j<n && small[i-1]>large[j]) {
                b = i-1;
            } else if (j>0 && i<m && large[j-1]>small[i]) {
                a = i+1;
            } else {
                if(i == 0) {
                    median = large[j-1];
                } else if (j == 0){
                    median = small[i-1];
                } else {
                    median = Math.max(small[i-1],large[j-1]);
                    // System.out.println("Median++++"+median);
                }
                break;
            }
        }
        
        if(odd == true)
            return (double)median;
        if(i == m) {
            return (median+large[j])/2.0;
        }
        if(j == n) {
            return (median+small[i])/2.0;
        }
        
        return (median+Math.min(small[i], large[j]))/2.0;
    }
}