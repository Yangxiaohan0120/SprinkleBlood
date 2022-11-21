package org.example.EnterpriseInterview.didi;

/**
 * @author Chris Yang
 * created 2022-08-12 20:23
 **/
public class MidNumber {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totallen = length1 + length2;
        if (totallen % 2 == 1) {
            int midIndex = totallen / 2;
            return getKthElement(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = totallen / 2 - 1, midIndex2 = totallen / 2;
            return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }

    }

    public int getKthElement(int[] nums1, int[] nums2, int index) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            if (length1 == index1) {
                return nums2[index2 + index - 1];
            }

            if (length2 == index2) {
                return nums1[index1 + index - 1];
            }

            if (index == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = index / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                index -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                index -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,5,7};
        int[] nums2 = {3,4,6,9};
        System.out.println(new MidNumber().findMedianSortedArrays(nums1,nums2));
    }
}
