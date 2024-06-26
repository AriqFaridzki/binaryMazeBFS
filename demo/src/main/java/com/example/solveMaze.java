package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class solveMaze {

    Koordinat titikAwal, titikAkhir;

    public void bfs(int[][] maze, Koordinat titikAwal, Koordinat titikAkhir){
//        every object kept their own value

//        set mazeRow
        int mazeRow = maze.length;
        int mazeCol = maze[0].length;
        boolean[][] isVisited = new boolean[mazeRow][mazeCol];

//        set dest and source
        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;


        Queue<Koordinat> queue = new LinkedList<>(); // init queue
        queue.offer(this.titikAwal); // add titikAwal to the queue

        isVisited[this.titikAwal.row][this.titikAwal.col] = true; // set titikAwal as visited
//        seeVisitedPoint(isVisited);

        printQueue(queue);

        Koordinat titikSekarang;

        while(!queue.isEmpty()){ // while queue is not empty
            titikSekarang = queue.poll(); // take the head content, and remove from queue ( FIFO )

            //titikSekarang at 9,0

            // i need to move titikSekarangit to up,down,right,left
        }

//        return -1;
    }

    public void executeMovement(Koordinat titikSekarang, int[][]){
        titikSekarang.checkAtas();

    }


    public void printVisitedPoint(boolean[][] booleanMatrix){
        System.out.println("boolean Length Row      : " + booleanMatrix.length);
        System.out.println("boolean Length Column   : " + booleanMatrix[0].length);
        System.out.println(" ");
        System.out.println("see Visited Point       : ");

        for (int i = 0; i < booleanMatrix.length; i++) {
            System.out.println(booleanMatrix[i] + " - ");
            for (int j = 0; j < booleanMatrix[i].length; j++) {
                System.out.print(booleanMatrix[i][j] + "|");
            }
        }
    }

    public void printQueue(Queue<Koordinat> queueTitik){
        System.out.println("titik Queue : ");

        for (Koordinat titik : queueTitik){
        System.out.println("Titik : " + titik.getRow() + " " + titik.getCol());
        }
    }
}

