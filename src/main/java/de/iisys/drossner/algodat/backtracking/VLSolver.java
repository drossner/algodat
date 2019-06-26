package de.iisys.drossner.algodat.backtracking;

import java.util.List;

public class VLSolver {


    static Sudokuproblem solver = new Sudokuproblem();

    public void solve(byte[][] sudoku){
        solve(sudoku, solver.findNext(sudoku, 0, 0));
    }

    private boolean solve(byte[][] sudoku, int pos){
        if(pos >= sudoku.length * sudoku.length) return true;
        int x = pos % sudoku.length;
        int y = pos / sudoku.length;

        List<Byte> candidates = solver.getCandidates(sudoku, x, y);
        for(byte cand : candidates){
            sudoku[y][x] = cand;
            boolean success = solve(sudoku, solver.findNext(sudoku, x, y));
            if(success) return success;
        }
        sudoku[y][x] = 0;
        return false;
    }


}
