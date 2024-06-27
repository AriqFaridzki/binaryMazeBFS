package com.example;

public class Koordinat {
    int row;
    int col;
    int distance;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int beban) {
        this.distance = beban;
    }

    public int addBebanDistances(int beban){
        return this.distance = this.distance + beban;
    }

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
    public void keKanan(){ 
        this.col = this.col + 1;
    }

    public boolean checkAtas(int[][] maze, boolean[][] isVisitedMatrix){ // just checking if you can go up
        int tempRow = this.row - 1;
        int tempCol = this.col;
        boolean status = maze[tempRow][tempCol] == 1 && !isVisitedMatrix[tempRow][tempCol];

        System.out.println(" == Cek Ke Atas ==");
        System.out.println("tempRow : " + this.row);
        System.out.println("tempCol : " + this.col);

        if(status) {
            System.out.println("Status : " + status);
            System.out.println(" ======= ======= ======");
            return status;
        } else {
            System.out.println("Status : " + false);
            System.out.println(" ======= ======= ======");
        }

        return false;
        // nu uh, you stay there
    }
    public boolean checkBawah(int[][] maze, boolean[][] isVisitedMatrix){ // just checking if you can go up
        int tempRow = this.row + 1;
        int tempCol = this.col;
        boolean status = maze[tempRow][tempCol] == 1 && !isVisitedMatrix[tempRow][tempCol];

            System.out.println(" == Cek Ke Bawah ==");
            System.out.println("tempRow : " + this.row);
            System.out.println("tempCol : " + this.col);
        if(status) {
            System.out.println("Status : " + status);
            System.out.println(" ======= ======= ======");
            return status;
        } else {
            System.out.println("Status : " + false);
            System.out.println(" ======= ======= ======");
        }


        return false;


// nu uh, you stay there
    }
    public boolean checkKiri(int[][] maze, boolean[][] isVisitedMatrix){ // just checking if you can go up
        int tempRow = this.row;
        int tempCol = this.col - 1;
        boolean status = maze[tempRow][tempCol] == 1 && !isVisitedMatrix[tempRow][tempCol];

            System.out.println(" == Cek Ke kiri ==");
            System.out.println("tempRow : " + this.row);
            System.out.println("tempCol : " + this.col);

        if(status) {
            System.out.println("Status : " + status);
            System.out.println(" ======= ======= ======");
            return status;
        } else {
            System.out.println("Status : " + false);
            System.out.println(" ======= ======= ======");
        }



        return false;
// nu uh, you stay there
    }
    public boolean checkKanan(int[][] maze, boolean[][] isVisitedMatrix){ // just checking if you can go up
        int tempRow = this.row;
        int tempCol = this.col + 1; //typo
        boolean status = maze[tempRow][tempCol] == 1 && !isVisitedMatrix[tempRow][tempCol];

            System.out.println(" == Cek Ke Kanan ==");
            System.out.println("tempRow : " + this.row);
            System.out.println("tempCol : " + this.col);

        if(status) {
            System.out.println("Status : " + status);
            System.out.println(" ======= ======= ======");
            return status;
        } else {
            System.out.println("Status : " + false);
            System.out.println(" ======= ======= ======");
        }


        return false;

// nu uh, you stay there
    }





    public void printKoordinat(){
        System.out.println("Koordinat Sekarang : " + this.row + " " + this.col);
    }
}
