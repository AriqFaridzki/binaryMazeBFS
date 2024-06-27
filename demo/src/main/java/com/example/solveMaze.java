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

        int[][] mazeHistory = new int[mazeRow][mazeCol];

        Queue<Koordinat> queue = new LinkedList<>();
        queue.offer(this.titikAwal);

        isVisited[this.titikAwal.getRow()][this.titikAwal.getCol()] = true;

        Koordinat titikSekarang;

        while(!queue.isEmpty()) {
            titikSekarang = queue.poll();
            int titikAkhirRow = this.titikAkhir.getRow();
            int titikAkhirCol = this.titikAkhir.getCol();

//            System.out.println();
//            printVisitedPoint(isVisited);
//            System.out.println("Jarak Sekarang: " + titikSekarang.getDistance());
//            System.out.println();

            if(titikSekarang.getRow() == titikAkhirRow) {
                if (titikSekarang.getCol() == titikAkhirCol) {
                    return titikSekarang.getDistance();
                }
            }

            try{
                if(titikSekarang.checkAtas(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keAtas();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored){}

            try{
                if(titikSekarang.checkBawah(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keBawah();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored){}

            try{
                // Thread.sleep(1000);
                if(titikSekarang.checkKiri(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keKiri();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored){}

            try{
                // Thread.sleep(1000);
                if(titikSekarang.checkKanan(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.getRow(), titikSekarang.getCol());
                    int newDistance = titikSekarang.getDistance() + 1;

                    tempTitik.keKanan();
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;

                    queue.offer(tempTitik);
                }
            } catch (ArrayIndexOutOfBoundsException ignored){}
        }

        return 0;
    }

    public void printVisitedPoint(boolean[][] booleanMatrix){
        for (boolean[] matrix : booleanMatrix) {
            System.out.print("|");
            for (boolean b : matrix) {
                System.out.print(" " + (b ? "O" : "X") + " ");
            }
            System.out.println("|");
        }
    }

    public void printQueue(Queue<Koordinat> queue){
        System.out.println("Titik Queue : ");

        for (Koordinat titik : queue){
            System.out.println("Titik : (" + titik.getRow() + ", " + titik.getCol() + ")");
        }
    }

    public void printMazePath(int[][] mazeHistory){
        System.out.println("Maze history : ");

        for (int i = 0; i < mazeHistory.length; i++) {
            System.out.print("Row " + i + " - ");

            for (int j = 0; j < mazeHistory[i].length; j++) {
                System.out.print(mazeHistory[i][j] + "|");
            }

            System.out.println();
        }
    }
}
