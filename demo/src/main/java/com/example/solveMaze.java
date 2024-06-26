package com.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Thread;

public class solveMaze {

    Koordinat titikAwal, titikAkhir;

    public int bfs(int[][] maze, Koordinat titikAwal, Koordinat titikAkhir) throws InterruptedException {
//        every object kept their own value

        int mazeRow = maze.length;
        int mazeCol = maze[0].length;
        boolean[][] isVisited = new boolean[mazeRow][mazeCol];

//        set dest and source
        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;

        int[][] mazeHistory = new int[mazeRow][mazeCol]; // untuk melihat history yang telah ditelusuri


        Queue<Koordinat> queue = new LinkedList<>(); // init queue
        queue.offer(this.titikAwal); // add titikAwal to the queue

        isVisited[this.titikAwal.row][this.titikAwal.col] = true; // set titikAwal as visited
//        seeVisitedPoint(isVisited);

        printQueue(queue);

        Koordinat titikSekarang;

        while(!queue.isEmpty()){ // while queue is not empty


            /// @todo agak bingung ini cara implementasinya

            titikSekarang = queue.poll(); // take the head content, and remove from queue ( FIFO )

            if( titikSekarang == this.titikAkhir ) {
                return titikSekarang.getDistance();
            } // jika titikSekarang udh sampai destinasi maka


            //titikSekarang now 9,0
            // @todo
            // check if titikSekarang can move up,down,right,left
                // if true then
                    // move titikSekarang to up,down,right,left
                    // jik ada yang tidak pindah maka tinggalkan
                    // jika ada yang pindah maka update totalDistancenya
                    // tambahin ke queue


            // cek jika titikSekarang bisa ke atas

            try{
            if(titikSekarang.checkAtas(maze, isVisited)) {

//               int distances = titikSekarang.getDistance();
                // sengaja biar cek nanti bisa di ngecek dan tidak berubah variablenya

                Koordinat tempTitik = titikSekarang;
                System.out.println("TitikSekarang : " + tempTitik.getRow() + " " + tempTitik.getCol());
                System.out.println("membuat clone titikSekarang dengan tempTitik....");
                Thread.sleep(1000);

                tempTitik.keAtas(); // go up then ( sekarang koordinat tempTitik menjadi 8,0 )
                isVisited[tempTitik.getRow()][tempTitik.getCol()]=true;
                System.out.println("eksekusi pindah tempat ke atas...." + tempTitik.getRow() + " " + tempTitik.getCol());
                Thread.sleep(1000);

                tempTitik.addBebanDistances(1); // add bebanDistances
                System.out.println("menambah distance + 1....");
                Thread.sleep(1000);

                /// add to the log history maze ( manual )
                mazeHistory
                        [tempTitik.getRow()]
                        [tempTitik.getCol()] = titikSekarang.getDistance();
                System.out.println("mencatat ke log history....");

                Thread.sleep(1000);
                queue.offer(tempTitik); // save Checkpoint ( add to the queue )
                System.out.println("memasukan ke titik baru queue....");

                printMazePath(mazeHistory);
                System.out.println(" ");
//                System.exit(0);

                printQueue(queue);
                System.out.println(" ");
                printVisitedPoint(isVisited);
            }
            } catch (ArrayIndexOutOfBoundsException e){

            }

            try{
            if(titikSekarang.checkBawah(maze, isVisited)) {

//               int distances = titikSekarang.getDistance();
                // sengaja biar cek nanti bisa di ngecek dan tidak berubah variablenya

                Koordinat tempTitik = titikSekarang;
                System.out.println("TitikSekarang : " + tempTitik.getRow() + " " + tempTitik.getCol());
                System.out.println("membuat clone titikSekarang dengan tempTitik....");
                Thread.sleep(1000);

                tempTitik.keBawah(); // go down then ( sekarang koordinat tempTitik menjadi 8,0 )
                isVisited[tempTitik.getRow()][tempTitik.getCol()]=true;
                System.out.println("eksekusi pindah tempat ke Bawah...." + tempTitik.getRow() + " " + tempTitik.getCol());
                Thread.sleep(1000);

                tempTitik.addBebanDistances(1); // add bebanDistances
                System.out.println("menambah distance + 1....");
                Thread.sleep(1000);

                /// add to the log history maze ( manual )
                mazeHistory
                        [tempTitik.getRow()]
                        [tempTitik.getCol()] = titikSekarang.getDistance();
                System.out.println("mencatat ke log history....");

                Thread.sleep(1000);
                queue.offer(tempTitik); // save Checkpoint ( add to the queue )
                System.out.println("memasukan ke titik baru queue....");

                printMazePath(mazeHistory);
                System.out.println(" ");
//                System.exit(0);

                printQueue(queue);
                System.out.println(" ");
                printVisitedPoint(isVisited);


            }
            } catch (ArrayIndexOutOfBoundsException e){

            }

            try{
            if(titikSekarang.checkKiri(maze, isVisited)) {

//               int distances = titikSekarang.getDistance();
                // sengaja biar cek nanti bisa di ngecek dan tidak berubah variablenya

                Koordinat tempTitik = titikSekarang;
                System.out.println("TitikSekarang : " + tempTitik.getRow() + " " + tempTitik.getCol());
                System.out.println("membuat clone titikSekarang dengan tempTitik....");
                Thread.sleep(1000);

                tempTitik.keKiri(); // go down then ( sekarang koordinat tempTitik menjadi 8,0 )
                isVisited[tempTitik.getRow()][tempTitik.getCol()]=true;
                System.out.println("eksekusi pindah tempat ke Kiri...." + tempTitik.getRow() + " " + tempTitik.getCol());
                Thread.sleep(1000);

                tempTitik.addBebanDistances(1); // add bebanDistances
                System.out.println("menambah distance + 1....");
                Thread.sleep(1000);

                /// add to the log history maze ( manual )
                mazeHistory
                        [tempTitik.getRow()]
                        [tempTitik.getCol()] = titikSekarang.getDistance();
                System.out.println("mencatat ke log history....");

                Thread.sleep(1000);
                queue.offer(tempTitik); // save Checkpoint ( add to the queue )
                System.out.println("memasukan ke titik baru queue....");

                printMazePath(mazeHistory);
                System.out.println(" ");
//                System.exit(0);

                printQueue(queue);
                System.out.println(" ");
                printVisitedPoint(isVisited);

            }
            } catch (ArrayIndexOutOfBoundsException e){

            }

            try{
            if(titikSekarang.checkKanan(maze, isVisited)) {

//               int distances = titikSekarang.getDistance();
                // sengaja biar cek nanti bisa di ngecek dan tidak berubah variablenya

                Koordinat tempTitik = titikSekarang;
                System.out.println("TitikSekarang : " + tempTitik.getRow() + " " + tempTitik.getCol());
                System.out.println("membuat clone titikSekarang dengan tempTitik....");
                Thread.sleep(1000);

                tempTitik.keKanan(); // go down then ( sekarang koordinat tempTitik menjadi 8,0 )
                isVisited[tempTitik.getRow()][tempTitik.getCol()]=true;
                System.out.println("eksekusi pindah tempat ke Kanan...." + tempTitik.getRow() + " " + tempTitik.getCol());
                Thread.sleep(1000);

                tempTitik.addBebanDistances(1); // add bebanDistances
                System.out.println("menambah distance + 1....");
                Thread.sleep(1000);

                /// add to the log history maze ( manual )
                mazeHistory
                        [tempTitik.getRow()]
                        [tempTitik.getCol()] = titikSekarang.getDistance();
                System.out.println("mencatat ke log history....");

                Thread.sleep(1000);
                queue.offer(tempTitik); // save Checkpoint ( add to the queue )
                System.out.println("memasukan ke titik baru queue....");

                printMazePath(mazeHistory);
                System.out.println(" ");
//                System.exit(0);

                printQueue(queue);
                System.out.println(" ");
                printVisitedPoint(isVisited);

            }
            } catch (ArrayIndexOutOfBoundsException e){

            }
        }



        return -1; // if no route to be found
    }

    public void executeMovement(Koordinat titikSekarang, int[][] maze, boolean[][] isVisited){
//        int[][] maze, boolean[][] isVisitedMatrix



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

    /// untuk print titik yang sudah ditempuh
    public void printMazePath(int[][] mazeHistory){
        System.out.println("Maze history : ");

//        mazeHistory[titikTarget.getRow()][titikTarget.getCol()] = titikTarget.getDistance();
        /// getBeban nanti mungkin berubah tapi intinya gitu
        /// @todo bingung cara untuk update setiap method dipanggil si mazeHistory nanti aja


        for (int i = 0; i < mazeHistory.length; i++) {
            System.out.print("Row " + i + " - ");
            for (int j = 0; j < mazeHistory[i].length; j++) {
                System.out.print(mazeHistory[i][j] + "|");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

}



