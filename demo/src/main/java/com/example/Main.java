package com.example; 

public class Main {
    public static void main(String[] args) throws InterruptedException {
        solveMaze test = new solveMaze();

        Koordinat source = new Koordinat(9,0);
        Koordinat dest = new Koordinat(0,4);

        int[][] matrix = {
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0}
        };

        int[][] matrix2 = {
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 0, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 0, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 0, 1, 1},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1},
        };

        String[][] matrixString = {
            {" ", "#", " ", "#", " "},
            {" ", "#", " ", "#", " "},
            {" ", "#", " ", "#", " "},
            {" ", "#", " ", "#", " "},
            {" ", "#", " ", "#", " "},
            {" ", " ", " ", " ", " "},
            {" ", "#", " ", "#", " "},
            {" ", " ", " ", " ", " "},
            {" ", " ", "#", " ", " "},
            {" ", "#", "#", "#", "#"}
        };

        Koordinat source2 = new Koordinat(28,2);
        Koordinat dest2 = new Koordinat(0,4);

        System.out.println("=========> Mulai");
        System.out.println(test.bfs(matrix, source, dest));
        System.out.println("=========> Beres");
    }
}

// solveMaze test
// queue.offer(new Koordinat(12,12));
//        queue.offer(new Koordinat(13,14));
//        queue.offer(new Koordinat(15,15));
//
//
//        System.out.println("titik Queue : ");
//        for (Koordinat titik : queue){
//        System.out.println("Titik : " + titik.getRow() + " " + titik.getCol());
//        }
//
//Koordinat titikSekarang = queue.poll();
//
//        System.out.println("after queue poll titik sekarang : " + + titikSekarang.getRow() + " " + titikSekarang.getCol());
//
//
//        System.out.println("titik Queue after poll() :  ");
//        for (Koordinat titik : queue){
//        System.out.println("Titik : " + titik.getRow() + " " + titik.getCol());
//        }