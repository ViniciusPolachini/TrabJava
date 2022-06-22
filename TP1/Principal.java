import java.util.ArrayList;

public class Principal{

    public static void main(String args[]) {
        Corrida corrida = new Corrida(10, 10, 10, 10);
        corrida.iniciarCorrida();
        System.out.println(corrida.status);
        ArrayList<Carro> colocacao = corrida.getColocacao();
        for (int i = 0; i < colocacao.size(); i++) {
            System.out.println((i+1) + "º lugar: Carro " + colocacao.get(i).getId());
        }
    }

}