package com.example;

public class Koordinat {
    private int row;
    private int col;
    private int distance;

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

    public Koordinat(int row, int col){
        this.row = row;
        this.col = col;
        this.distance = 0;
    }

    public void keAtas() {
        this.row = this.row - 1;
    }

    public void keBawah() {
        this.row = this.row + 1;
    }

    public void keKiri() {
        this.col = this.col - 1;
    }

    public void keKanan() {
        this.col = this.col + 1;
    }

    public boolean checkAtas(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row - 1;
        int tempCol = this.col;
        boolean status = maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];

        if(status) {
            return status;
        }

        return false;
    }

    public boolean checkBawah(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row + 1;
        int tempCol = this.col;
        boolean status = maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];

        if(status) {
            return status;
        }

        return false;
    }

    public boolean checkKiri(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row;
        int tempCol = this.col - 1;
        boolean status = maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];

        if(status) {
            return status;
        }

        return false;
    }

    public boolean checkKanan(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row;
        int tempCol = this.col + 1;
        boolean status = maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];;

        if(status) {
            return status;
        }

        return false;
    }
}
