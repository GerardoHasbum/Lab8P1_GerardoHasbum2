/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p1_gerardohasbum;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author ghasb
 */
public class Game {

    Random ran = new Random();//creacion de constructores
    int[][] tabin;
    int[][] tabnex;
    ArrayList<String> coordenadas;
    int rondas;

    public Game() {
    }

    public Game(int[][] tabin) {
        this.tabin = tabin;
    }

    public int[][] getTabin() {
        return tabin;
    }

    public void setTabin(int[][] tabin) {
        this.tabin = tabin;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    public int[][] getTabnex() {
        return tabnex;
    }

    public void setTabnex(int[][] tabnex) {
        this.tabnex = tabnex;
    }

    public ArrayList<String> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<String> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void PrintM(int[][] mat) {//imprime las matrices ordenadamente
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("[" + mat[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public void Play(int rondas) {//metodo play donde se corre todo el programa
        coordenadas = new ArrayList<>();
        for (int i = 0; i < tabin.length; i++) {
            for (int j = 0; j < tabin[i].length; j++) {
                if (tabin[i][j]==1) {
                    coordenadas.add(i+":"+j);
                }
            }
        }
        System.out.println("Las celdas vivas son: ");
        Print(coordenadas);
        System.out.println("ESTA IMPRESIÓN NO CUENTA COMO UNA RONDA, SOLO ES EL TABLERO INICIAL");
        PrintM(tabin);//imprime lo primero que se tiene que ver
        for (int i = 1; i <= rondas; i++) {//imprime todo el juego sin necesidad que lo toque el jugador
            System.out.println("Ronda " + i);
            NextGen();
            tabin = tabnex;//pasa la tabla nueva a la vieja para poder volver a repetir el proceso.
            PrintM(tabin);
        }
    }

    public void NextGen() {
        int cont_vecinos = 0;
        tabnex = new int[10][10];//inicia la siguiente generacion con 0s
        for (int i = 0; i < tabin.length; i++) {
            for (int j = 0; j < tabin[i].length; j++) {
                cont_vecinos = 0;//empieza el contador para cada casilla
                if (i != 0 && j != 0 && i != 9 && j != 9) {//Valida que no ponga descendientes en los bordes
                    if (tabin[i - 1][j - 1] == 1) {
                        cont_vecinos++;

                    }
                    if (tabin[i - 1][j] == 1) {
                        cont_vecinos++;

                    }
                    if (tabin[i - 1][j + 1] == 1) {
                        cont_vecinos++;

                    }
                    if (tabin[i][j - 1] == 1) {
                        cont_vecinos++;

                    }
                    if (tabin[i][j + 1] == 1) {
                        cont_vecinos++;

                    }
                    if (tabin[i + 1][j - 1] == 1) {
                        cont_vecinos++;

                    }
                    if (tabin[i + 1][j] == 1) {
                        cont_vecinos++;

                    }
                    if (tabin[i + 1][j + 1] == 1) {//mira las casillas al rededor para agregar vecinos si encuentra
                        cont_vecinos++;

                    }
                    if (cont_vecinos <= 1) {//si tiene 1 o menos vecinos se muere por falta de recreacion
                        tabnex[i][j] = 0;
                    }
                    if (cont_vecinos>=3 && tabin[i][j]==1){//valida que si hay un 1 en la casilla donde hay 3 o mas vecinos para matar o no
                        tabnex[i][j]=0;
                    }
                    if (cont_vecinos >= 3 && tabin[i][j]==0) {//si es 0 entonces sale descendiente
                        tabnex[i][j] = 1;
                    }
                    if (cont_vecinos == 2) {//si hay solo dos vecinos entonces deja al que estaba antes
                        tabnex[i][j] = tabin[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < tabnex.length; i++) {
            for (int j = 0; j < tabnex[i].length; j++) {//lee las casillas y agrega las coordenadas si encuentra una casilla con un 1
                if (tabnex[i][j] == 1) {
                    coordenadas.add(i + ":" + j);
                }
            }
        }
        System.out.println("Las Celdas vivas son:");
        Print(coordenadas);
    }

    public void Print(ArrayList<String> array) {//imprime el array
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (i != array.size() - 1) {//imprime comas para separar los conjuntos y valida que no sea el ultimo para no poner una coma al final
                System.out.print(", ");
            }
        }
        System.out.println();
        array.clear();//reinicia el array para volver a ingresar los que siguen
    }
}
