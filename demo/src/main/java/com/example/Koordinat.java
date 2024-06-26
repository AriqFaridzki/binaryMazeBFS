package com.example;

public class Koordinat {
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    int row;
    int col;

    public int getDistance() {
        return distance;
    }

    public int addBebanDistances(int beban){
        return this.distance = this.distance + beban;
    }

    int distance;

    public Koordinat(int row, int col){
        this.row = row;
        this.col = col;
        this.distance = 0;
    }

    public void keAtas(){
        this.row = this.row - 1;
    } // execute : move to up
    public void keBawah(){
        this.row = this.row + 1;
    }
    public void keKiri(){
        this.col = this.col - 1;
    }
    public void keKanan(){ this.col = this.col + 1;
    }

    public boolean checkAtas(int[][] maze, boolean[][] isVisitedMatrix){ // just checking if you can go up
        int tempRow = this.row - 1;
        int tempCol = this.col;
        boolean status = maze[tempRow][tempCol] == 1 && !isVisitedMatrix[tempRow][tempCol];
        System.out.println(" ======= Checking ======");
        System.out.println("tempRow : " + this.row);
        System.out.println("tempCol : " + this.col);
        System.out.println("checkAtas : " + status);
        System.out.println(" ======= ======= ======");



        return maze[tempRow][tempCol] == 1 && !isVisitedMatrix[tempRow][tempCol]; // you can go up
// nu uh, you stay there
    }





    public void tambahBeban(){
        this.distance++;
    };

    public void printKoordinat(){
        System.out.println("Koordinat Sekarang : " + this.row + " " + this.col);
    }
}
