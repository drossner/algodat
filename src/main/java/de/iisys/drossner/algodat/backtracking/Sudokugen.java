package de.iisys.drossner.algodat.backtracking;

import java.util.Collections;
import java.util.List;

public class Sudokugen {


    public static void main(String[] args) {
        Sudokuproblem solver = new Sudokuproblem();

        byte[][] sudoku = new byte[9][9];

        gen(solver, sudoku);

        System.out.println(solver.solve(sudoku).size());
        System.out.println("----");

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("----");

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+";");
            }
            System.out.println();
        }
    }

    private static boolean gen(Sudokuproblem solver, byte[][] sudoku){
        int x, y;
        do {
            int val = (int) (Math.random() * sudoku.length * sudoku.length);
            y = val / sudoku.length;
            x = val % sudoku.length;
        } while(sudoku[y][x] != 0);

        List<Byte> candidates = solver.getCandidates(sudoku, x, y);
        Collections.shuffle(candidates);
        for(byte cand : candidates){
            sudoku[y][x] = cand;
            int sols = solver.solve(sudoku, 2).size();
            if(sols == 1) return true;
            else if(sols == 0) continue;
            else if(gen(solver, sudoku)) return true;
        }
        sudoku[y][x] = 0;
        return false;
    }

}
