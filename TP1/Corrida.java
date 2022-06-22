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
        for(int i = 0; i < participantes.size(); i++) {
            Carro participante = participantes.get(i);
            if (participante.getCompletou()){
                //participantes.remove(i);
                colocacao.add(participante);
            }

            status += participante.status;
            this.terminou = true; // por enquanto so itera uma vez, pois nao utiliza threads ainda

        }
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
            participante.run(); // ainda nao faz o uso de threads, por isso chama run ao inves de start
        }        
        //Monitoramento da corrida
        while (!terminou) { // por enquanto so itera uma vez, pois nao utiliza threads ainda
            atualizar();
        }
        return colocacao;
    }
}