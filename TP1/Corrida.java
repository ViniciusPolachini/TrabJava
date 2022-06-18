import java.net.*;
import java.io.*;
import java.util.*;


public class Corrida{
    private ArrayList<Carro> participantes;
    private Stack<String> quebrados;
    private Stack<String> abasteceu;
    private ArrayList<Carro> dianteira;
    private int nCorredores;

    public static void atualizaQuebrados(String nome){
        quebrados.push(nome);
    }

    public static void atualizaAbasteceu(String nome){
        abasteceu.push(nome);
    }

    public static void atualiza(){
    
    }

    public Corrida(int voltas, int nCorredores){
        this.nCorredores = nCorredores;

        participantes = new ArrayList<Carro>();
        quebrados = new Stack<String>();
        abasteceu = new Stack<String>();
        dianteira = new ArrayList<String>();

        Carro participante;

        for(int i=0; i<3; i++){
            dianteira = new Carro("",0,0,voltas);
        }

        for(int i=0; i<nCorredores; i++){
            participante = new Carro(Integer.toString(i), 10.0, 30.0, voltas);
            participante.start();
            participante.run();
            participantes.add(participante);
        }
    }
}