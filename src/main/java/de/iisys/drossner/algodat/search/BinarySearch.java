package de.iisys.drossner.algodat.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 7, 23, 24, 58, 99, 100};

        System.out.println(binRekSearch(arr, 3, 0, arr.length));
        System.out.println(binRekSearch(arr, 55, 0, arr.length));
        System.out.println(binRekSearch(arr, 7, 0, arr.length));
        System.out.println(binRekSearch(arr, 100, 0, arr.length));
        System.out.println(binRekSearch(arr, 24, 0, arr.length));
        System.out.println(binRekSearch(arr, 6, 0, arr.length));
    }

    public static int binSearch(int[] arr, int element) {
        int start = 0;
        int end = arr.length;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == element) return mid;
            else if(arr[mid] > element) {
                //first half
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static int binRekSearch(int[] arr, int element, int start, int end) {
        if (end <= start) return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == element) return mid;
        else if(arr[mid] > element) {
            //first half
            return binRekSearch(arr, element, start, mid);
        } else {
            return binRekSearch(arr, element, mid + 1, end);
        }
    }
}
