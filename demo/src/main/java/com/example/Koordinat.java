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

    public void keAtasKanan() {
        this.row = this.row - 1;
        this.col = this.col + 1;
    }

    public void keAtasKiri() {
        this.row = this.row - 1;
        this.col = this.col - 1;
    }

    public void keBawahKanan() {
        this.row = this.row + 1;
        this.col = this.col + 1;
    }

    public void keBawahKiri() {
        this.row = this.row + 1;
        this.col = this.col - 1;
    }

    public boolean checkAtasKanan(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row - 1;
        int tempCol = this.col + 1;

        return maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];
    }

    public boolean checkAtasKiri(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row - 1;
        int tempCol = this.col - 1;

        return maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];
    }

    public boolean checkBawahKanan(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row + 1;
        int tempCol = this.col + 1;

        return maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];
    }

    public boolean checkBawahKiri(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row + 1;
        int tempCol = this.col - 1;

        return maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];
    }

    public boolean checkAtas(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row - 1;
        int tempCol = this.col;

        return maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];
    }

    public boolean checkBawah(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row + 1;
        int tempCol = this.col;

        return maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];
    }

    public boolean checkKiri(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row;
        int tempCol = this.col - 1;

        return maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];
    }

    public boolean checkKanan(String[][] maze, boolean[][] isVisitedMatrix) {
        int tempRow = this.row;
        int tempCol = this.col + 1;

        return maze[tempRow][tempCol].equals(" ") && !isVisitedMatrix[tempRow][tempCol];
    }
}
