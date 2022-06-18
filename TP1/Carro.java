import java.net.*;
import java.io.*;
import java.util.*;

public class Carro extends Thread{
    private String nome;
    private int voltas;
    private int voltasExecutadas;
    private int distancia;
    private float pQuebrar;
    private float pAbastecer;
    private boolean quebrado;
    private static boolean comecar;

    public static void inicializar(){
        comecar = true;
    }

    public void Carro(String nome, float pQuebrar, float pAbastecer, int voltas){
        this.nome = nome;
        this.pQuebrar = pQuebrar;
        this.pAbastecer = pAbastecer;
        this.voltas = voltas;
        quebrado = false;
        distancia = 0;
    }

    public void run(){
        int voltasExecutadas=0;
        Random rand = new Random();

        while(voltasExecutadas!=voltas && !quebrado){
            if(comecar){
                while(distancia<100 && !quebrado){
                    if(pQuebrar<=rand.nextFloat()*100){
                        quebrado=true
                    }
                    else if(pAbastecer<=rand.nextFloat()*100){

                    }
                    else{
                        distancia+=1;
                    }
                }
                if(!quebrado){
                    distancia=0;
                    voltasExecutadas+=1;
                }
            }
        }
    }
}