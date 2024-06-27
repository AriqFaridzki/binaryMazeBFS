package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        solveMaze solve = new solveMaze();

        Koordinat source = new Koordinat(9,0);
        Koordinat dest = new Koordinat(0,4);

        String[][] maze = {
            {" ", "#", " ", "#", " "},
            {" ", "#", " ", "#", " "},
            {" ", "#", " ", "#", " "},
            {" ", "#", " ", "#", " "},
            {" ", "#", " ", "#", " "},
            {" ", " ", " ", " ", " "},
            {" ", "#", " ", "#", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "#", " ", " "},
            {" ", "#", "#", "#", "#"}
        };

        System.out.println("||====================> Binary Maze <====================||");
        int min_dist = solve.bfs(maze, source, dest);

        System.out.println("|| Maze: ");
        for (String[] mazeRow : maze) {
            System.out.println("||\t" + Arrays.toString(mazeRow));
        }
        System.out.println("|| ");

        if (min_dist > 0) {
            System.out.println("|| Minimum Distance: " + min_dist);
        } else {
            System.out.println("|| Tidak Ada Jalur/Path Menuju Destinasi Itu.");
        }
        System.out.println("||====================> Binary Maze <====================||");
    }
}
