package de.iisys.drossner.algodat.backtracking;

import java.io.*;
import java.util.List;

public class ReadSudoku {

    public static void main(String[] args) throws IOException {
        final String LOCATION = "./stuff/sudoku.csv";
        BufferedReader reader = new BufferedReader(new FileReader(new File(LOCATION)));

        byte[][] sudoku = new byte[9][9]; //otherwise its not sudoku
        int row = 0;
        String line;
        while( (line = reader.readLine()) != null  ){
            String[] splitline = line.split(";");
            for (int i = 0; i < splitline.length; i++) {
                sudoku[row][i] = Byte.parseByte(splitline[i]);
            }
            row++;
        }

        System.out.println("Done, sudoku field filled!");

        Sudokuproblem solver = new Sudokuproblem();
        List<byte[][]> liste = solver.solve(sudoku);
        sudoku = liste.get(0);
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

}
