package de.iisys.drossner.algodat.backtracking;


import java.util.Deque;
import java.util.LinkedList;

public class Damenproblem {

    public boolean[][] solve(final int n){
        boolean[][] ret = new boolean[n][n];
        Deque<Dame> damen = new LinkedList<>();
        solve(0, damen, n);
        damen.forEach(dame -> ret[dame.y][dame.x] = true);

        return ret;
    }

    private boolean solve(int yRow, Deque<Dame> damen, final int n){
        if(yRow >= n) return true;
        boolean solution = false;
        for(int x = 0; x < n && !solution; x++){
            boolean bedroht = false;
            Dame neu = new Dame(x, yRow);
            for(Dame set : damen){
                bedroht = set.bedroht(neu, n);
                if(bedroht) break;
            }
            if(!bedroht){
                damen.push(neu);
                solution = solve(yRow+1, damen, n);
                if(!solution) damen.pop();
            }
        }
        return solution;
    }

    private class Dame{
        private final int x;
        private final int y;

        Dame(int x, int y){
            this.x = x;
            this.y = y;
        }

        boolean bedroht(Dame other, final int n){
            int oX = other.x;
            int oY = other.y;
            return(x == oX || y == oY ||
                    x+y == oX+oY ||
                    n-1-x+y == n-1-oX+oY);
        }
    }

    public static void main(String[] args) {
        Damenproblem solver = new Damenproblem();
        boolean result[][] = solver.solve(10);

        System.out.print("   ");
        for(int i = 0; i < result.length; i++){
            System.out.print(" "+i);
        }
        System.out.println();

        for(int y = 0; y < result.length; y++){
            System.out.print(y+": ");
            for(int x = 0; x < result.length; x++){
                System.out.print(result[y][x]? " X" : "  ");
            }
            System.out.println();
        }
    }

}
