package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class solveMaze {
    public int bfs(String[][] maze, Koordinat titikAwal, Koordinat titikAkhir) {
        int mazeRow = maze.length;
        int mazeCol = maze[0].length;
        boolean[][] isVisited = new boolean[mazeRow][mazeCol];

        int[][] mazeHistoryDist = new int[mazeRow][mazeCol];
        Koordinat[][] mazeHistory = new Koordinat[mazeRow][mazeCol];

        Queue<Koordinat> queue = new LinkedList<>();
        queue.offer(titikAwal);

        isVisited[titikAwal.getRow()][titikAwal.getCol()] = true;

        Koordinat titikSekarang;

        while (!queue.isEmpty()) {
            titikSekarang = queue.poll();
            mazeHistoryDist[titikSekarang.getRow()][titikSekarang.getCol()] = titikSekarang.getDistance();
            int titikAkhirRow = titikAkhir.getRow();
            int titikAkhirCol = titikAkhir.getCol();

            if (titikSekarang.getRow() == titikAkhirRow) {
                if (titikSekarang.getCol() == titikAkhirCol) {
                    printVisualisasi(maze, mazeHistory, mazeHistoryDist, titikSekarang);
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
                    mazeHistory[tempTitik.getRow()][tempTitik.getCol()] = titikSekarang;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}

            try {
                if (titikSekarang.checkBawah(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keBawah();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;
                    mazeHistory[tempTitik.getRow()][tempTitik.getCol()] = titikSekarang;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}

            try {
                if (titikSekarang.checkKiri(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keKiri();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;
                    mazeHistory[tempTitik.getRow()][tempTitik.getCol()] = titikSekarang;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}

            try {
                if (titikSekarang.checkKanan(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keKanan();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;
                    mazeHistory[tempTitik.getRow()][tempTitik.getCol()] = titikSekarang;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        return 0;
    }

    public void printVisualisasi(String[][] maze, Koordinat[][] mazeHistory, int[][] mazeHistoryDist, Koordinat titikSekarang) {
        System.out.println("|| --> Visualisasi: ");
        System.out.println("||\t\tJalan yang bisa diakses : " + "\uD83D\uDFE1");
        System.out.println("||\t\tJalan yang Terblokir / not visited : " + "\uD83D\uDEA7");
        System.out.println("||\t\tJalan yang ditempuh : " + "\uD83D\uDEE4️");
        System.out.println("|| ");
        System.out.println("||    ▪ Jalur Ditempuh:");
        printMazePath(maze,mazeHistory, titikSekarang);
        System.out.println("|| ");

        System.out.println("||    ▪ Koordinat didalamnya:");
        printKoordinatMaze(maze);
        System.out.println("|| ");
        System.out.println("||    ▪ Perhitungan jarak tiap titik:");
        printMazeDistance(mazeHistoryDist);
    }

    private void printMazePath(String[][] maze, Koordinat[][] mazeHistory, Koordinat destination) {
        String[][] fixedPath = new String[maze.length][maze[0].length];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].equals(" ")){
                    fixedPath[i][j] = "\uD83D\uDFE1";
                } else {
                    fixedPath[i][j] = "\uD83D\uDEA7";
                }
            }
        }
//         init
        int currentRow = destination.getRow();
        int currentCol = destination.getCol();

        Koordinat next;

        while (currentRow != -1 && currentCol != -1) {
            fixedPath[currentRow][currentCol] = "\uD83D\uDEE4️";

            next =  mazeHistory[currentRow][currentCol];

            if (next != null) {
                currentRow = next.getRow();
                currentCol = next.getCol();
            } else {
                currentRow = -1;
                currentCol = -1;
            }
        }

        for (String[] strings : fixedPath) {
            System.out.print("||\t\t");

            for (String string : strings) {
                System.out.print(string + "|");
            }

            System.out.println();
        }
    }

    private void printKoordinatMaze(String [][] maze) {
        for (int i = 0; i < maze.length; i++) {
            System.out.print("||\t\t");

            for (int j = 0; j < maze[i].length; j++) {
                String k = maze[i][j];
                if (k.equals(" ")) {
                    System.out.print("{" + i + "," + j + "}|");
                } else {
                    System.out.print("\uD83D\uDEA7.\uD83D\uDEA7|");
                }
            }

            System.out.println();
        }
    }

    private void printMazeDistance(int[][] maze) {
        for (int[] row : maze) {
            System.out.print("||\t\t|");

            for (int col : row) {
                System.out.print(" " + (col < 10 ? "0" + col : col) + " |");
            }

            System.out.println();
        }
    }
}
