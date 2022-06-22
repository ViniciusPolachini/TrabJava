import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal{

    private static JFrame tela;
    private static JPanel painel1;
    private static JPanel painel2;
    private static JLabel tituloCorrida;
    private static JLabel labelVoltas;
    private static JLabel labelCorredores;
    private static JLabel labelProbQuebrar;
    private static JLabel labelProbAbastecer;
    private static JTextField inputVoltas;
    private static JTextField inputCorredores;
    private static JTextField inputProbQuebrar;
    private static JTextField inputProbAbastecer;
    private static JButton comecar;

    private static JLabel labelStatus;
    private static JLabel labelColocacao;
    

    public static void main(String args[]) {

        criarTela();
        tela.setVisible(true);

        Corrida corrida = new Corrida(30, 10, 10, 10);
        corrida.iniciarCorrida();

        labelStatus = new JLabel(corrida.status);
        labelStatus.setBounds(20, 100, 260, 400);
        labelStatus.setFont(new Font("Arial", Font.PLAIN, 12));
        painel1.add(labelStatus);
        //tela.add(labelStatus);

        // System.out.println(corrida.status);
        // ArrayList<Carro> colocacao = corrida.getColocacao();
        // for (int i = 0; i < colocacao.size(); i++) {
        //     System.out.println((i+1) + "º lugar: Carro " + colocacao.get(i).getId());
        // }
    }

    public static void criarTela() {
        tela = new JFrame();
        tela.setBounds(100, 100, 800, 600);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.getContentPane().setLayout(null);

        tituloCorrida = new JLabel("Corrida Java");
        tituloCorrida.setBounds(320, 20, 200, 80);
        tituloCorrida.setFont(new Font("Arial", Font.PLAIN, 24));
        tela.add(tituloCorrida);

        labelCorredores = new JLabel("Número de corredores:");
        labelCorredores.setBounds(80, 110, 150, 30);
        labelCorredores.setFont(new Font("Arial", Font.PLAIN, 12));
        tela.add(labelCorredores);

        inputCorredores = new JTextField();
        inputCorredores.setBounds(90, 140, 100, 30);
        tela.add(inputCorredores);

        labelVoltas = new JLabel("Número de voltas:");
        labelVoltas.setBounds(250, 110, 150, 30);
        labelVoltas.setFont(new Font("Arial", Font.PLAIN, 12));
        tela.add(labelVoltas);

        inputVoltas = new JTextField();
        inputVoltas.setBounds(250, 140, 100, 30);
        tela.add(inputVoltas);

        labelProbAbastecer = new JLabel("Probabilidade de abastecer:");
        labelProbAbastecer.setBounds(390, 110, 160, 30);
        labelProbAbastecer.setFont(new Font("Arial", Font.PLAIN, 12));
        tela.add(labelProbAbastecer);

        inputProbAbastecer = new JTextField();
        inputProbAbastecer.setBounds(420, 140, 100, 30);
        tela.add(inputProbAbastecer);

        labelProbQuebrar = new JLabel("Probabilidade de quebrar:");
        labelProbQuebrar.setBounds(565, 110, 150, 30);
        labelProbQuebrar.setFont(new Font("Arial", Font.PLAIN, 12));
        tela.add(labelProbQuebrar);

        inputProbQuebrar = new JTextField();
        inputProbQuebrar.setBounds(570, 140, 100, 30);
        tela.add(inputProbQuebrar);

        comecar = new JButton("Começar / Reiniciar");
        comecar.setBounds(295, 200, 200, 50);
        tela.add(comecar);

        // painel1 = new JPanel();
        // painel1.setBounds(20, 270, 260, 400);
        // tela.add(painel1);

        painel1 = new JPanel();
        painel1.setBounds(10, 20, 500, 400);
        tela.add(painel1);

        

    }

}