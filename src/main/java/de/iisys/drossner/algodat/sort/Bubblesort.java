package de.iisys.drossner.algodat.sort;

public class Bubblesort {


    public int[] bubblesort(int[] arr){
        for(int i = arr.length-1; i > 0; i--){
            for(int k = 0; k < i; k++){
                if(arr[k] > arr[k+1]) swap(arr, k, k+1);
            }
        }
        return  arr;
    }

    private void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[1_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (a.length * 10));
        }

        Bubblesort bubble = new Bubblesort();
        bubble.bubblesort(a);

    }

}
