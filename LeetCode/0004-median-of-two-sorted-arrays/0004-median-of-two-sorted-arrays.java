class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = nums1.length;
        int j = nums2.length;
        int[] arr = new int[i + j];
        int idx1 = 0, idx2 = 0, idx3 = 0;

        while (idx1 < i && idx2 < j) {
            if (nums1[idx1] <= nums2[idx2]) {
                arr[idx3++] = nums1[idx1++];
            } else {
                arr[idx3++] = nums2[idx2++];
            }
        }

        while (idx1 < i) {
            arr[idx3++] = nums1[idx1++];
        }

        while (idx2 < j) {
            arr[idx3++] = nums2[idx2++];
        }

        int idx = i + j;
        if (idx % 2 == 0) {
            return (arr[idx / 2 - 1] + arr[idx / 2]) / 2.0;
        } else {
            return arr[idx / 2];
        }
    }
}