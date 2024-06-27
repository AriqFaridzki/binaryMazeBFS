package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class solveMaze {
    Koordinat titikAwal, titikAkhir;

    public int bfs(int[][] maze, Koordinat titikAwal, Koordinat titikAkhir) throws InterruptedException {
        // every object kept their own value

        int mazeRow = maze.length;
        int mazeCol = maze[0].length;
        boolean[][] isVisited = new boolean[mazeRow][mazeCol];

        // set dest and source
        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;

        int[][] mazeHistory = new int[mazeRow][mazeCol]; // untuk melihat history yang telah ditelusuri

        Queue<Koordinat> queue = new LinkedList<>(); // init queue
        queue.offer(this.titikAwal); // add titikAwal to the queue

        isVisited[this.titikAwal.getRow()][this.titikAwal.getCol()] = true; // set titikAwal as visited
        // seeVisitedPoint(isVisited);

        printQueue(queue);

        Koordinat titikSekarang;

        while(!queue.isEmpty()){ // while queue is not empty
            /// @todo agak bingung ini cara implementasinya

            titikSekarang = queue.poll(); // take the head content, and remove from queue ( FIFO )
            int titikAkhirRow = this.titikAkhir.getRow();
            int titikAkhirCol = this.titikAkhir.getCol();

            
            if( titikSekarang.getRow() == titikAkhirRow) {
                if (titikSekarang.getCol() == titikAkhirCol) {
                    return titikSekarang.getDistance();
                }
            } // jika titikSekarang udh sampai destinasi maka

            //titikSekarang now 9,0
            // @todo
            // check if titikSekarang can move up,down,right,left
                // if true then
                    // move titikSekarang to up,down,right,left
                    // jik ada yang tidak pindah maka tinggalkan
                    // jika ada yang pindah maka update totalDistancenya
                    // tambahin ke queue


            // cek jika titik Sekarang bisa ke atas
            try{
                // Thread.sleep(1000);
                if(titikSekarang.checkAtas(maze, isVisited)) {
                    Koordinat tempTitik = new Koordinat(titikSekarang.row, titikSekarang.col);

                    // get current last updated Distances
                    // tempTitik.setDistance(titikSekarang.getDistance());
                    int newDistance = titikSekarang.getDistance() + 1;

                    System.out.println("TitikSekarang : " + tempTitik.getRow() + " " + tempTitik.getCol());
                    System.out.println("membuat clone titikSekarang dengan tempTitik....");

                    tempTitik.keAtas(); // go up then ( sekarang koordinat tempTitik menjadi 8,0 )
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()] = true;
                    System.out.println("eksekusi pindah tempat ke atas...." + tempTitik.getRow() + " " + tempTitik.getCol());

                    // tempTitik.addBebanDistances(1); // add bebanDistances
                    System.out.println("menambah distance + 1....");

                    /// add to the log history maze ( manual )
                    mazeHistory[tempTitik.getRow()][tempTitik.getCol()] = tempTitik.getDistance();
                    System.out.println("mencatat ke log history....");

                    queue.offer(tempTitik); // save Checkpoint ( add to the queue )
                    System.out.println("memasukan ke titik baru queue....");

                    printMazePath(mazeHistory);
                    System.out.println(" ");
                    // System.exit(0);

                    printQueue(queue);
                    System.out.println(" ");
                    printVisitedPoint(isVisited);
                }
            } catch (ArrayIndexOutOfBoundsException e){

            }

            // cek jika titik Sekarang bisa ke bawah
            try{
                // Thread.sleep(1000);
                if(titikSekarang.checkBawah(maze, isVisited)) {
                    // int distances = titikSekarang.getDistance();
                    // sengaja biar cek nanti bisa di ngecek dan tidak berubah variablenya
                    Koordinat tempTitik = new Koordinat(titikSekarang.row, titikSekarang.col);

                    int newDistance = titikSekarang.getDistance() + 1;

                    System.out.println("TitikSekarang : " + tempTitik.getRow() + " " + tempTitik.getCol());
                    System.out.println("membuat clone titikSekarang dengan tempTitik....");

                    tempTitik.keBawah(); // go down then ( sekarang koordinat tempTitik menjadi 8,0 )
                    tempTitik.setDistance(newDistance);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()]=true;
                    System.out.println("eksekusi pindah tempat ke Bawah...." + tempTitik.getRow() + " " + tempTitik.getCol());

                    // tempTitik.addBebanDistances(1); // add bebanDistances
                    System.out.println("menambah distance + 1....");


                    /// add to the log history maze ( manual )
                    mazeHistory
                            [tempTitik.getRow()]
                            [tempTitik.getCol()] = tempTitik.getDistance();
                    System.out.println("mencatat ke log history....");

                    queue.offer(tempTitik); // save Checkpoint ( add to the queue )
                    System.out.println("memasukan ke titik baru queue....");

                    printMazePath(mazeHistory);
                    System.out.println(" ");
                    // System.exit(0);

                    printQueue(queue);
                    System.out.println(" ");
                    printVisitedPoint(isVisited);
                }
            } catch (ArrayIndexOutOfBoundsException e){

            }

            // cek jika titik Sekarang bisa ke kiri
            try{
                // Thread.sleep(1000);
                if(titikSekarang.checkKiri(maze, isVisited)) {
                    // int distances = titikSekarang.getDistance();
                    // sengaja biar cek nanti bisa di ngecek dan tidak berubah variablenya

                    Koordinat tempTitik = new Koordinat(titikSekarang.row, titikSekarang.col);
                    int newDistance = titikSekarang.getDistance() + 1;


                    System.out.println("TitikSekarang : " + tempTitik.getRow() + " " + tempTitik.getCol());
                    System.out.println("membuat clone titikSekarang dengan tempTitik....");

                    tempTitik.keKiri(); // go down then ( sekarang koordinat tempTitik menjadi 8,0 )
                    tempTitik.setDistance(newDistance);
                    

                    isVisited[tempTitik.getRow()][tempTitik.getCol()]=true;
                    System.out.println("eksekusi pindah tempat ke Kiri...." + tempTitik.getRow() + " " + tempTitik.getCol());

                    // tempTitik.addBebanDistances(1);
                    System.out.println("menambah distance + 1....");

                    /// add to the log history maze ( manual )
                    mazeHistory[tempTitik.getRow()][tempTitik.getCol()] = tempTitik.getDistance();
                    System.out.println("mencatat ke log history....");

                    queue.offer(tempTitik); // save Checkpoint ( add to the queue )
                    System.out.println("memasukan ke titik baru queue....");

                    printMazePath(mazeHistory);
                    System.out.println(" ");
                    // System.exit(0);

                    printQueue(queue);
                    System.out.println(" ");
                    printVisitedPoint(isVisited);
                }
            } catch (ArrayIndexOutOfBoundsException e){

            }

            // cek jika titik Sekarang bisa ke kanan
            try{
                // Thread.sleep(1000);
                if(titikSekarang.checkKanan(maze, isVisited)) {
                    // int distances = titikSekarang.getDistance();
                    // sengaja biar cek nanti bisa di ngecek dan tidak berubah variablenya

                    Koordinat tempTitik = new Koordinat(titikSekarang.row, titikSekarang.col);
                    int newDistance = titikSekarang.getDistance() + 1;
                    
                    
                    System.out.println("TitikSekarang : " + tempTitik.getRow() + " " + tempTitik.getCol());
                    System.out.println("membuat clone titikSekarang dengan tempTitik....");
                    
                    tempTitik.keKanan(); // go down then ( sekarang koordinat tempTitik menjadi 8,0 )
                    tempTitik.setDistance(newDistance);
                    System.out.println("the distance now : " + tempTitik);

                    isVisited[tempTitik.getRow()][tempTitik.getCol()]=true; //update Visited Node

                    System.out.println("eksekusi pindah tempat ke Kanan...." + tempTitik.getRow() + " " + tempTitik.getCol());

                    tempTitik.addBebanDistances(1); // add bebanDistances
                    System.out.println("menambah distance + 1....");

                    /// add to the log history maze ( manual )
                    mazeHistory[tempTitik.getRow()][tempTitik.getCol()] = tempTitik.getDistance();
                    System.out.println("mencatat ke log history....");

                    queue.offer(tempTitik); // save Checkpoint ( add to the queue )
                    System.out.println("memasukan ke titik baru queue....");

                    printMazePath(mazeHistory);
                    System.out.println(" ");
                    // System.exit(0);

                    printQueue(queue);
                    System.out.println(" ");
                    printVisitedPoint(isVisited);
                }
            } catch (ArrayIndexOutOfBoundsException e){

            }
        }

        return -1; // if no route to be found
    }

    public void printVisitedPoint(boolean[][] booleanMatrix){
        System.out.println("boolean Length Row      : " + booleanMatrix.length);
        System.out.println("boolean Length Column   : " + booleanMatrix[0].length);
        System.out.println(" ");
        System.out.println("see Visited Point       : ");

        for (int i = 0; i < booleanMatrix.length; i++) {
            System.out.print("Row " + i + " - ");
            for (int j = 0; j < booleanMatrix[i].length; j++) {
                System.out.print(booleanMatrix[i][j] + "|");
            }
            System.out.println();
        }
    }

    public void printQueue(Queue<Koordinat> queue){
        System.out.println("titik Queue : ");

        for (Koordinat titik : queue){
        System.out.println("Titik : " + titik.getRow() + " " + titik.getCol());
        }
    }

    // untuk print titik yang sudah ditempuh
    public void printMazePath(int[][] mazeHistory){
        System.out.println("Maze history : ");

        // mazeHistory[titikTarget.getRow()][titikTarget.getCol()] = titikTarget.getDistance();
        // getBeban nanti mungkin berubah tapi intinya gitu
        // @todo bingung cara untuk update setiap method dipanggil si mazeHistory nanti aja

        for (int i = 0; i < mazeHistory.length; i++) {
            System.out.print("Row " + i + " - ");
            for (int j = 0; j < mazeHistory[i].length; j++) {
                System.out.print(mazeHistory[i][j] + "|");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }
}
