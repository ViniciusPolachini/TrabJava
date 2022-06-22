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

        //     //Montagem das mensagens:
        //     if(participante.getQuebrado()){
        //         status += montarMensagemCarroQuebrado(participante.getId());
        //     } else if (participante.getSemCombustivel()) {
        //         status += montarMensagemSemCombustivel(participante.getId());
        //     } else {
        //         status += montarStatus(participante.getId(), participante.getVoltasExecutadas(), participante.getCompletou());
        //     }

            status += participante.status;
            this.terminou = true;

        }
        // if (colocacao.size() == quantidadeCorredores){
        //     this.terminou = true;
        // }
    }

    // public String montarStatus (long id, long voltasExecutadas, boolean completou) {
    //     if (completou){
    //         return ("\nCarro" + id + " - Voltas executadas: " + voltasExecutadas);
    //     }
    //     return ("\nCarro" + id + " Terminou a corrida!");
    // }

    // public String montarMensagemCarroQuebrado(long id) {
    //     return ("\nCarro" + id + " quebrado!");
    // }

    // public String montarMensagemSemCombustivel(long id) {
    //     return ("\nCarro" + id + " sem combustivel!");
    // }

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
            participante.run();
        }        
        //Monitoramento da corrida
        while (!terminou) {
            atualizar();
        }
        return colocacao;
    }
}