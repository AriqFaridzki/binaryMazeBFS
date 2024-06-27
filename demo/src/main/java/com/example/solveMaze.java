package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class solveMaze {
    Koordinat titikAwal, titikAkhir;

    public int bfs(String[][] maze, Koordinat titikAwal, Koordinat titikAkhir) throws InterruptedException {
        int mazeRow = maze.length;
        int mazeCol = maze[0].length;
        boolean[][] isVisited = new boolean[mazeRow][mazeCol];

        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;

        int[][] mazeHistoryDist = new int[mazeRow][mazeCol];
        Koordinat[][] mazeHistory = new Koordinat[mazeRow][mazeCol];

        Queue<Koordinat> queue = new LinkedList<>();
        queue.offer(this.titikAwal);

        isVisited[this.titikAwal.getRow()][this.titikAwal.getCol()] = true;

        Koordinat titikSekarang;

        while (!queue.isEmpty()) {
            titikSekarang = queue.poll();
            mazeHistoryDist[titikSekarang.getRow()][titikSekarang.getCol()] = titikSekarang.getDistance();
            mazeHistory[titikSekarang.getRow()][titikSekarang.getCol()] = titikSekarang;
            int titikAkhirRow = this.titikAkhir.getRow();
            int titikAkhirCol = this.titikAkhir.getCol();

//            System.out.println();
//            printVisitedPoint(isVisited);
//            System.out.println("Jarak Sekarang: " + titikSekarang.getDistance());
//            System.out.println();

            if (titikSekarang.getRow() == titikAkhirRow) {
                if (titikSekarang.getCol() == titikAkhirCol) {
                    printMazePath2(maze,mazeHistoryDist, titikSekarang);
//                    printKoodinatMaze(mazeHistory);
                    return titikSekarang.getDistance();
                }
            }

            try {
                if (titikSekarang.checkAtas(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keAtas();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }

            try {
                if (titikSekarang.checkBawah(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keBawah();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }

            try {
                // Thread.sleep(1000);
                if (titikSekarang.checkKiri(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keKiri();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }

            try {
                // Thread.sleep(1000);
                if (titikSekarang.checkKanan(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keKanan();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        }

        return 0;
    }


    public void printVisitedPoint(boolean[][] booleanMatrix) {
        for (boolean[] matrix : booleanMatrix) {
            System.out.print("|");
            for (boolean b : matrix) {
                System.out.print(" " + (b ? "O" : "X") + " ");
            }
            System.out.println("|");
        }
    }

    public void printQueue(Queue<Koordinat> queue) {
        System.out.println("Titik Queue : ");

        for (Koordinat titik : queue) {
            System.out.println("Titik : (" + titik.getRow() + ", " + titik.getCol() + ")");
        }
    }

    public void printMazePath(String[][] maze, Koordinat[][] mazeHistory, Koordinat destination) {
        // destination 0,4, gimana caranya ke 9,0?
        // we have mazeHistory which is the total distance taken from 9,0
        // each row have unique number of distances

        //        Maze history :
        //        Row 0 - 9|0|11|0|{1,2}| <-- start here
//                Row 1 - 8|0|10|0|12| <
//                Row 2 - 7|0|9|0|11|
//                Row 3 - 6|0|8|0|10|
//                Row 4 - 5|0|7|0|9|
//                Row 5 - 4|5|6|7|8|
//                Row 6 - 3|0|5|0|7|
//                Row 7 - 2|3|4|5|6|
//                Row 8 - 1|2|0|6|7|
//                Row 9 - 0|0|0|0|0|

        // String[][] maze = {
        //            {" ", "#", " ", "#", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", " ", " ", " ", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", " ", " ", " ", " "},
        //            {" ", " ", "#", " ", " "},
        //            {" ", "#", "#", "#", "#"}
        //        };

        // 1st loop check Row
        // 2nd Loop check Column


        // String[][] maze, ini maze soal
        // Koordinat[][] mazeHistory, ini koordinat array 2d
        // Koordinat destination

        String[][] fixedPath = new String[maze.length][maze[0].length];
        int currentRow = destination.getRow(); // 0
        int currentCol = destination.getCol(); // 4

        Koordinat next;

        while (currentRow != -1 && currentCol != -1) {
            fixedPath[currentRow][currentCol] = "✨"; // tandai 0,4 dengan bintang

            next = mazeHistory[currentRow][currentCol]; // akses mazeHistory dengan cords 0,4 yaitu sebuah koordinat

            if (next != null) { // jika koordinat yang diakses itu ndak null maka > ambil valuenya
                currentRow = next.getRow();
                currentCol = next.getCol();
            } else { // terminate loops
                currentRow = -1;
                currentCol = -1;
            }
        }

//        System.out.println("Maze history : ");

//        for (String[] path : fixedPath){
//
//        }
//
//        for (int i = 0; i < fixedPath.length; i++) {
//            System.out.print("Row " + i + " - ");
//
//            for (int j = 0; j < fixedPath[i].length; j++) {
//                System.out.print(fixedPath[i][j] + "|");
//            }
//
//            System.out.println();
//        }
//    }

//        public void printMazeDist(int[][] mazePathDist){
//            for (int i = 0; i < mazePathDist.length; i++) {
//                System.out.print("Row " + i + " - ");
//
//                for (int j = 0; j < mazePathDist[i].length; j++) {
//                    System.out.print(mazePathDist[i][j] + "|");
//                }
//
//                System.out.println();
//            }
//        }


    }

    public void printMazePath2(String[][] maze, int[][] mazeHistoryDist, Koordinat destination) {
        // destination 0,4, gimana caranya ke 9,0?
        // we have mazeHistory which is the total distance taken from 9,0
        // each row have unique number of distances

        //        Maze history :
        //        Row 0 - 9|0|11|0|13| <-- start here
//                Row 1 - 8|0|10|0|12| <
//                Row 2 - 7|0|9|0|11|
//                Row 3 - 6|0|8|0|10|
//                Row 4 - 5|0|7|0|9|
//                Row 5 - 4|5|6|7|8|
//                Row 6 - 3|0|5|0|7|
//                Row 7 - 2|3|4|5|6|
//                Row 8 - 1|2|0|6|7|
//                Row 9 - 0|0|0|0|0|

        // String[][] maze = {
        //            {" ", "#", " ", "#", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", " ", " ", " ", " "},
        //            {" ", "#", " ", "#", " "},
        //            {" ", " ", " ", " ", " "},
        //            {" ", " ", "#", " ", " "},
        //            {" ", "#", "#", "#", "#"}
        //        };

        // 1st loop check Row
        // 2nd Loop check Column


        // String[][] maze, ini maze soal
        // Koordinat[][] mazeHistory, ini int distance array 2d
        // Koordinat destination

        String[][] fixedPath = new String[maze.length][maze[0].length];
        int currentRow = destination.getRow(); // 0
        int currentCol = destination.getCol(); // 4

        int next;
        int now;


        while (currentRow != -1 && currentCol != -1) {
            fixedPath[currentRow][currentCol] = "✨"; // tandai 0,4 dengan bintang

            now = mazeHistoryDist[currentRow][currentCol]; // 13

//            if (next != null) { // jika koordinat yang diakses itu ndak null maka > ambil valuenya
//                currentRow = next.getRow();
//                currentCol = next.getCol();
//            } else { // terminate loops
//                currentRow = -1;
//                currentCol = -1;
//            }

            if(currentRow != 0){
                if(mazeHistoryDist[currentRow - 1][currentCol] == now - 1 ){
                    currentRow--;
                }
            }

            if(currentRow != maze.length - 1){
                if(mazeHistoryDist[currentRow + 1][currentCol] == now - 1 ){
                    currentRow++;
                }
            }

            if(currentCol != 0){
                if(mazeHistoryDist[currentRow][currentCol - 1] == now - 1 ){
                    currentCol--;
                }
            }

            if(currentCol != maze[0].length - 1){
                if(mazeHistoryDist[currentRow][currentCol + 1] == now - 1 ){
                    currentCol++;
                }
            }


        }

//        System.out.println("Maze history : ");

//        for (String[] path : fixedPath){
//
//        }
//
//        for (int i = 0; i < fixedPath.length; i++) {
//            System.out.print("Row " + i + " - ");
//
//            for (int j = 0; j < fixedPath[i].length; j++) {
//                System.out.print(fixedPath[i][j] + "|");
//            }
//
//            System.out.println();
//        }
//    }

//        public void printMazeDist(int[][] mazePathDist){
//            for (int i = 0; i < mazePathDist.length; i++) {
//                System.out.print("Row " + i + " - ");
//
//                for (int j = 0; j < mazePathDist[i].length; j++) {
//                    System.out.print(mazePathDist[i][j] + "|");
//                }
//
//                System.out.println();
//            }
//        }


    }

    public void printKoodinatMaze(Koordinat[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            System.out.print("Row " + i + " - ");

            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "|");
            }

            System.out.println();
        }
    }
}
