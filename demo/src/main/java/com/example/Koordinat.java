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

    public int getBeban() {
        return beban;
    }

    public int setBeban(int beban){
        return this.beban = this.beban + beban;
    }

    int beban;

    public Koordinat(int row, int col){
        this.row = row;
        this.col = col;
        this.beban = 0;
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
        int tempRow = this.row;
        int tempCol = this.col;

        if(maze[tempRow][tempCol] == 1 && !isVisitedMatrix[tempRow][tempCol]){
            return true; // you can go up
        }

        return false; // nu uh, you stay there
    }





    public void tambahBeban(){
        this.beban++;
    };

    public void printKoordinat(){
        System.out.println("Koordinat Sekarang : " + this.row + " " + this.col);
    }
}
