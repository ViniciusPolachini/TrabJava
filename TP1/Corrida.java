import java.net.*;
import java.io.*;
import java.util.*;


public class Corrida{
    private ArrayList<Carro> participantes;
    private ArrayList<Carro> colocacao = new ArrayList<Carro>();
    private int quantidadeCorredores;
    private int probabilidadeQuebrar;
    private int probabilidadeAbastecer;
    public String status;
    private boolean terminou = false;

    public ArrayList<Carro> getColocacao() {
        return this.colocacao;
    }

    public void atualizar() {
        status = "";
        boolean aux=true;
        for(int i = 0; i < participantes.size(); i++) {
            Carro participante = participantes.get(i);
            if (participante.getCompletou() && !participante.getCheck()){
                participante.setCheck();
                colocacao.add(participante);
            }
            else if(!participante.getQuebrado() && !participante.getSemCombustivel() && !participante.getCheck()){
                aux=false;
            }
            status += participante.status;

        }
        if(aux) this.terminou=true;
    }


    public Corrida(int voltas, int quantidadeCorredores, float probabilidadeQuebrar, float probabilidadeAbastecer){
        this.quantidadeCorredores = quantidadeCorredores;

        participantes = new ArrayList<Carro>();

        //Criando os participantes
        for(int i = 0; i < quantidadeCorredores; i++){
            Carro participante = new Carro(i, probabilidadeQuebrar, probabilidadeAbastecer, voltas);
            participantes.add(participante);
        }
    }

    public ArrayList<Carro> iniciarCorrida () {
        //Preparando os participantes
        Carro.inicializar();
        for(Carro participante: participantes) {
            participante.start(); // ainda nao faz o uso de threads, por isso chama run ao inves de start
        }        
        //Monitoramento da corrida
        while (!terminou) { // por enquanto so itera uma vez, pois nao utiliza threads ainda
            atualizar();
        }
        return colocacao;
    }
}