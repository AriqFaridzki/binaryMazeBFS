package com.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class solveMaze {
    Koordinat titikAwal, titikAkhir;
    boolean[][] visitedPath;
    int numPath = 0;

    public int bfs(String[][] maze, Koordinat titikAwal, Koordinat titikAkhir) {
        int mazeRow = maze.length;
        int mazeCol = maze[0].length;
        boolean[][] isVisited = new boolean[mazeRow][mazeCol];

        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;

        Queue<Koordinat> queue = new LinkedList<>();
        queue.offer(this.titikAwal);

        isVisited[this.titikAwal.getRow()][this.titikAwal.getCol()] = true;

        Koordinat titikSekarang;

        while(!queue.isEmpty()) {
            titikSekarang = queue.poll();
            int titikAkhirRow = this.titikAkhir.getRow();
            int titikAkhirCol = this.titikAkhir.getCol();

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

    public void path(String[][] mat, Koordinat koordinatSekarang, Koordinat koordinatTujuan, int min_dist) {
        if (mat.length == 0 || mat[koordinatSekarang.getRow()][koordinatSekarang.getCol()].equals("#") || mat[koordinatTujuan.getRow()][koordinatTujuan.getCol()].equals("#"))  {
            return;
        }

        int row = mat.length;
        int col = mat[0].length;

        this.visitedPath = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.visitedPath[i][j] = false;
            }
        }

        findPath(mat, koordinatSekarang.getRow(), koordinatSekarang.getCol(), koordinatTujuan, min_dist, 0);
    }

    public int findPath(String[][] mat, int koordinatSekarangX, int koordinatSekarangY, Koordinat koordinatTujuan, int min_dist, int dist) {
        if (koordinatSekarangX == koordinatTujuan.getRow() && koordinatSekarangY == koordinatTujuan.getCol()) {
            if (dist == min_dist) {
                this.numPath++;

                System.out.println("|| - Path ke " + this.numPath);
                for (int a = 0; a < this.visitedPath.length; a++) {
                    System.out.print("||     [");
                    for (int b = 0; b < this.visitedPath[0].length; b++) {
                        if (a == koordinatSekarangX && b == koordinatSekarangY) {
                            System.out.print(" P ");
                        } else {
                            System.out.print(" " + (this.visitedPath[a][b] ? "O" : "#") + " ");
                        }
                    }
                    System.out.println("]");
                }
                System.out.println("|| ");
            }

            min_dist = Math.min(dist, min_dist);
            return min_dist;
        }

        this.visitedPath[koordinatSekarangX][koordinatSekarangY] = true;

        if (isSafe(mat, this.visitedPath, koordinatSekarangX + 1, koordinatSekarangY)) {
            min_dist = findPath(mat, koordinatSekarangX + 1, koordinatSekarangY, koordinatTujuan, min_dist, dist + 1);
        }

        if (isSafe(mat, this.visitedPath, koordinatSekarangX, koordinatSekarangY + 1)) {
            min_dist = findPath(mat, koordinatSekarangX, koordinatSekarangY + 1, koordinatTujuan, min_dist, dist + 1);
        }

        if (isSafe(mat, this.visitedPath, koordinatSekarangX - 1, koordinatSekarangY)) {
            min_dist = findPath(mat, koordinatSekarangX - 1, koordinatSekarangY, koordinatTujuan, min_dist, dist + 1);
        }

        if (isSafe(mat, this.visitedPath, koordinatSekarangX, koordinatSekarangY - 1)) {
            min_dist = findPath(mat, koordinatSekarangX, koordinatSekarangY - 1, koordinatTujuan, min_dist, dist + 1);
        }

        this.visitedPath[koordinatSekarangX][koordinatSekarangY] = false;
        return min_dist;
    }

    static boolean isSafe(String[][] mat, boolean[][] visited, int x, int y) {
        return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y].equals(" ") && !visited[x][y]);
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
