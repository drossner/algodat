package de.iisys.drossner.algodat.codingbat;

public class Array3 {

    public boolean canBalance(int[] nums) {
        int[] sumleft = new int[nums.length];
        int[] sumright = new int[nums.length];

        int tmp = 0;
        for(int i = 0; i < sumleft.length; i++){
            sumleft[i] = tmp + nums[i];
            tmp = sumleft[i];
        }

        tmp = 0;
        for(int j = sumright.length - 1; j >= 0; j--){
            sumright[j] = tmp + nums[j];
            tmp = sumright[j];
        }

        for(int k = 0; k < nums.length - 1; k++){
            if(sumleft[k] == sumright[k+1]) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Array3 arr3 = new Array3();
        int[] test = {2, 1, 1, 2, 1};
        System.out.println(arr3.canBalance(test));
    }

}
