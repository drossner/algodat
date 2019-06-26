package de.iisys.drossner.algodat.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sudokuproblem {

    public List<byte[][]> solve(byte[][] sudoku, int limit){
        List<byte[][]> solutions = new LinkedList<>();
        solve(solutions, sudoku, findNext(sudoku, 0 ,0), limit);
        return solutions;
    }

    public List<byte[][]> solve(byte[][] sudoku){
        return solve(sudoku, Integer.MAX_VALUE);
    }

    private int solve(List<byte[][]> sol, byte[][] sudoku, int pos, int limit){
        if(limit <= 0) return 0;
        if(pos >= sudoku.length * sudoku.length){
            byte [][] clone = new byte[sudoku.length][];
            for(int i = 0; i < sudoku.length; i++)
                clone[i] = sudoku[i].clone();
            sol.add(clone);
            return --limit;
        }
        int y = pos / sudoku.length;
        int x = pos % sudoku.length;

        List<Byte> canidates = getCandidates(sudoku, x, y);
        if(canidates.isEmpty()) return limit;
        for(byte val : canidates){
            sudoku[y][x] = val;
            limit = solve(sol, sudoku, findNext(sudoku, x, y), limit);
        }
        sudoku[y][x] = 0;
        return limit;
    }

    public int findNext(byte[][] sudoku, int x, int y){
        int val = y*sudoku.length + x;
        while(val < sudoku.length * sudoku.length &&
                sudoku[val / sudoku.length][val % sudoku.length] != 0) val++;
        return val;
    }

    public List<Byte> getCandidates(byte[][] sudoku, int x, int y){
        boolean[] nums = new boolean[10];
        for (int i = 0; i < sudoku.length; i++) {
            nums[sudoku[y][i]] = true; //x
        }

        for (int i = 0; i < sudoku.length; i++) {
            nums[sudoku[i][x]] = true; //y
        }

        //sub square
        int xsquare = x / 3;
        int ysquare = y / 3;

        for(int k = ysquare * 3; k < (ysquare+1) * 3; k++){
            for(int l = xsquare * 3; l < (xsquare+1) * 3; l++){
                nums[sudoku[k][l]] = true;
            }
        }
        List<Byte> ret = new LinkedList<>();
        for(int i = 1; i < nums.length; i++){
            if(!nums[i]) ret.add((byte) i);
        }
        return ret;
    }

    public static void main(String[] args) {
        byte[][] sudoku = new byte[9][9];
        sudoku[0][0] = 1;
        sudoku[3][5] = 6;
        sudoku[7][2] = 9;
        Sudokuproblem solver = new Sudokuproblem();

        List<byte[][]> solutions = solver.solve(sudoku, 2);
        sudoku = solutions.get(1);

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

}
