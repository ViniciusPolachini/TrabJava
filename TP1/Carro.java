import java.net.*;
import java.io.*;
import java.util.*;

public class Carro extends Thread {
    private int id;
    private int voltas;
    private int voltasExecutadas;
    private int distancia;
    private float probabilidadeQuebrar;
    private float probabilidadeAbastecer;
    private boolean quebrado = false;
    private boolean semCombustivel = false;
    private boolean completou = false;
    private boolean check = false;
    public String status;
    private static boolean comecar;

    public boolean getQuebrado() {
        return quebrado;
    }

    public boolean getSemCombustivel() {
        return semCombustivel;
    }
    
    public boolean getCheck(){
        return check;
    }

    public boolean getCompletou() {
        return completou;
    }

    public long getId() {
        return id;
    }

    public long getVoltasExecutadas() {
        return voltasExecutadas;
    }

    public void setCheck(){
        check = true;
    }

    public static void inicializar() {
        comecar = true;
    }

    public Carro (int id, float probabilidadeQuebrar, float probabilidadeAbastecer, int voltas) {
        this.id = id;
        this.probabilidadeQuebrar = probabilidadeQuebrar;
        this.probabilidadeAbastecer = probabilidadeAbastecer;
        this.voltas = voltas;
        quebrado = false;
        distancia = 0;
    }

    public String montarStatus (long id, long voltasExecutadas) {
        return ("\nCarro" + id + " Terminou a corrida!" + " - Voltas executadas: " + voltasExecutadas);
    }

    public String montarMensagemCarroQuebrado(long id, long voltasExecutadas) {
        return ("\nCarro" + id + " quebrado apos " + voltasExecutadas + " voltas");
    }

    public String montarMensagemSemCombustivel(long id, long voltasExecutadas) {
        return ("\nCarro" + id + " sem combustivel apos " + voltasExecutadas + " voltas");
    }

    public void run() {
        voltasExecutadas = 0;
        Random rand = new Random();

        while(voltasExecutadas != voltas) {
            if(comecar) {
                while(distancia < 100) {
                    status = "";
                    if(probabilidadeQuebrar >= rand.nextFloat() * 100000) {
                        quebrado = true;
                        status += montarMensagemCarroQuebrado(id, voltasExecutadas);
                        break;
                    } else if(probabilidadeAbastecer >= rand.nextFloat() * 100000) {
                        semCombustivel = true;
                        status += montarMensagemSemCombustivel(id, voltasExecutadas);
                        break;
                    } else{
                        distancia+=1;
                    }
                }
                if(!quebrado && !semCombustivel){
                    distancia=0;
                    voltasExecutadas+=1;
                } else break;
            }
            if(voltasExecutadas == voltas) {
                completou = true;
                status += montarStatus(id, voltasExecutadas);
            }
        }
    }
}