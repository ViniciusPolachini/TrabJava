import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.io.*;


public class Principal{

    private static JFrame tela;
    private static JTextArea painel1;
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

    private static JTextArea labelStatus;
    private static JLabel labelColocacao;
    

    public Principal() {
        criarTela();
        tela.setVisible(true);
    }

    private class Handler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            if(event.getSource()==comecar){
                int voltas = Integer.parseInt(inputVoltas.getText());
                int nCorredores = Integer.parseInt(inputCorredores.getText());
                float pQuebrar = Float.parseFloat(inputProbQuebrar.getText());
                float pAbastecer = Float.parseFloat(inputProbAbastecer.getText());

                if(voltas>=10 && nCorredores>0){
                    comecaCorrida(voltas, nCorredores, pQuebrar, pAbastecer);
                }
            }
        }
    }

    public void comecaCorrida(int voltas, int nCorredores, float pQuebrar, float pAbastecer){
            Corrida corrida = new Corrida(voltas, nCorredores, pQuebrar, pAbastecer);
            corrida.iniciarCorrida();
            String status=corrida.status;
            status+="\n\n";            

            ArrayList<Carro> colocacao = corrida.getColocacao();
            for (int i = 0; i < colocacao.size(); i++) {
                status+="\n"+(i+1) + "º lugar: Carro " + colocacao.get(i).getId();
            }
            labelStatus.setText(status);
    }

    static public void distanciaPercorrida(int distancia, int volta, int carro){
        System.out.println(String.valueOf(carro)+": distancia-"+String.valueOf(distancia)+" volta-"+String.valueOf(volta));
    }

    public void criarTela() {
        Handler h = new Handler();

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
        comecar.addActionListener(h);
        tela.add(comecar);

        labelStatus = new JTextArea();
        labelStatus.setBounds(100, 270, 500, 200);
        labelStatus.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(labelStatus, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tela.add(scroll);
        tela.add(labelStatus);


        // painel1 = new JPanel();
        // painel1.setBounds(20, 270, 260, 400);
        // tela.add(painel1);

    }

}