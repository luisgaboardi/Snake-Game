package visual;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tela {

    private final int width = 400;
    private final int height = 450;
    private final int posX = 600;
    private final int posY = 250;
    private JFrame janelaJogo;
    protected visual.Map mapa;

    public JFrame getJanelaJogo() {
        return janelaJogo;
    }

    public Tela() {
        initTela();
    }

    private void initTela() {

        janelaJogo = new JFrame();
        janelaJogo.getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        janelaJogo.getContentPane().setBackground(Color.DARK_GRAY);
        janelaJogo.setSize(width, height);

        JLayeredPane localScore = new JLayeredPane();
        localScore.setBounds(0, 0, width, 40);
        localScore.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

        final JLayeredPane localBotoes = new JLayeredPane();
        localBotoes.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

        mapa = new visual.Map();

        GroupLayout contJanela = new GroupLayout(janelaJogo.getContentPane());
        contJanela.setHorizontalGroup(
                contJanela.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(localScore, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addGroup(contJanela.createSequentialGroup()
                                .addGap(14)
                                .addComponent(mapa, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGap(15))
                        .addGroup(contJanela.createSequentialGroup()
                                .addGap(12)
                                .addComponent(localBotoes, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                .addGap(12))
        );
        contJanela.setVerticalGroup(
                contJanela.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(contJanela.createSequentialGroup()
                                .addComponent(localScore, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(mapa, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addGap(14)
                                .addComponent(localBotoes, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                .addGap(10))
        );

        JTextArea textoScore = new JTextArea();
        textoScore.setEditable(false);
        textoScore.setFont(new Font("Helvetica", Font.BOLD, 20));
        textoScore.setBackground(Color.DARK_GRAY);
        textoScore.setForeground(Color.WHITE);
        localScore.setLayer(textoScore, 0);
        textoScore.setText("Score:");
        textoScore.setBounds(10, 8, 70, 22);
        localScore.add(textoScore);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("000000");
        textArea.setForeground(Color.YELLOW);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setBounds(100, 15, 48, 22);
        localScore.add(textArea);

        final JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        spinner.setBounds(330, 21, 35, 20);
        spinner.setValue(5);
        localBotoes.add(spinner);

        JTextArea txtSpeed = new JTextArea();
        txtSpeed.setEditable(false);
        txtSpeed.setBackground(Color.DARK_GRAY);
        txtSpeed.setForeground(Color.WHITE);
        txtSpeed.setText("Speed");
        txtSpeed.setBounds(280, 22, 55, 20);
        localBotoes.add(txtSpeed);
        mapa.setLayout(null);

        janelaJogo.getContentPane().setLayout(contJanela);
        janelaJogo.setTitle("Snake's adventures");
        janelaJogo.setResizable(false);
        janelaJogo.setBounds(posX, posY, width, height);
        janelaJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        janelaJogo.setJMenuBar(menuBar);

        final JMenu menuCobras = new JMenu("Cobras");
        menuCobras.setHorizontalAlignment(SwingConstants.CENTER);
        menuBar.add(menuCobras);

        final JButton btnComum = new JButton("Comum");
        menuCobras.add(btnComum);
        btnComum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                mapa.setTrueStar(false);
                mapa.setTrueKitty(false);
                mapa.setTrueNormal(true);
                mapa.getSnake().setScore(0);
                mapa.setSnake(new Snake(mapa.getPontosMatriz()));
                janelaJogo.repaint();

            }
        });

        final JButton btnKitty = new JButton("Kitty");
        menuCobras.add(btnKitty);
        btnKitty.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                mapa.setTrueStar(false);
                mapa.setTrueKitty(true);
                mapa.setTrueNormal(false);
                mapa.getSnake().setScore(0);
                mapa.setKitty(new Kitty(mapa.getPontosMatriz()));
                janelaJogo.repaint();
            }
        });

        final JButton btnStar = new JButton("Star");
        menuCobras.add(btnStar);
        btnStar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                mapa.setTrueStar(true);
                mapa.setTrueKitty(false);
                mapa.setTrueNormal(false);
                mapa.getSnake().setScore(0);
                mapa.setStar(new Star(mapa.getPontosMatriz()));
                janelaJogo.repaint();
            }
        });

        final JButton start = new JButton("START");
        start.setFont(new Font("Helvetica", Font.BOLD, 16));
        start.setBounds(125, 7, 110, 35);

        localBotoes.add(start);
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if("START".equals(start.getText())) {
                    mapa.requestFocus();
                    start.setText("PAUSE");
                    spinner.setEnabled(false);
                    menuCobras.setEnabled(false);
                    mapa.setEnabled(true);
                    mapa.setJogando(true);
                } else if("PAUSE".equals(start.getText())) {
                    start.setText("START");
                    mapa.setEnabled(false);
                    spinner.setEnabled(true);
                    menuCobras.setEnabled(true);
                    mapa.setJogando(false);
                }
            }
        });
    }
}
