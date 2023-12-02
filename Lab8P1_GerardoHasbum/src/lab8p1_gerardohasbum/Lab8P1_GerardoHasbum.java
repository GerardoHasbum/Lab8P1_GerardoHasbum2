package lab8p1_gerardohasbum;
//fila 3 silla 9
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab8P1_GerardoHasbum {

    static Scanner jhin = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        
        System.out.println("*****MENU*****");
        System.out.println("1. Game of Life");
        System.out.println("2. Salir de programa");
        int opcion = jhin.nextInt();
        while (opcion > 0 && opcion < 2) {//loop para entrar al menu y correro los programas
            
            switch (opcion) { //elige el programa
                case 1:
                    int[][] tabin = new int[10][10];//crea la matriz vacia
                    Game g = new Game(tabin);//llama a la clase para que corra los metodos incluidos en ella
                    for (int i = 0; i < tabin.length; i++) {//llena la matriz original alazar con 1s y 0s
                        for (int j = 0; j < tabin[i].length; j++) {
                            int x = ran.nextInt(2);
                            tabin[i][j] = x;
                        }
                    }
                    for (int i = 0; i < tabin.length; i++) {//pone los bordes a ser 0
                        tabin[i][0]=0;
                        tabin[0][i]=0;
                        tabin[i][9]=0;
                        tabin[9][i]=0;
                    }
                    System.out.println("Cuantas rondas le guastaria jugar?");
                    int rondas = jhin.nextInt();
//                    g.PrintM(tabin); esto no iba por eso comentario
                    g.Play(rondas);//llama el metodo de la clase
                    break;
            }
            System.out.println("*****MENU*****");
            System.out.println("1. Game of Life");
            System.out.println("2. Salir de programa");
            opcion = jhin.nextInt();
        }
    }

}
