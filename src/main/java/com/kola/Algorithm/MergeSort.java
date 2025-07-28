package com.kola.Algorithm;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        k = 0;
//        while(k < right){
//            nums[left+k] = temp[k++];
//        }
        for (k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
    }
}
