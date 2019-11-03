package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;


public class Tela {

    private final int width = 400;
    private final int height = 450;
    private final int posX = 600;
    private final int posY = 250;
    private JFrame janelaJogo;
    protected Grid grid;
    
    public JFrame getJanelaJogo() {
        return janelaJogo;
    }

    public Tela() {
        initTela();
    }
    
    private void initTela() {
        
        janelaJogo = new JFrame();
        janelaJogo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        janelaJogo.getContentPane().setBackground(Color.LIGHT_GRAY);
        janelaJogo.setSize(width, height);
        
        JLayeredPane areaTitulo = new JLayeredPane();
        areaTitulo.setBounds(0, 0, width, 40);
	areaTitulo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        final JLayeredPane areaBotoes = new JLayeredPane();
	areaBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        
        grid = new Grid();
        
        GroupLayout contJanela = new GroupLayout(janelaJogo.getContentPane());
		contJanela.setHorizontalGroup(
			contJanela.createParallelGroup(Alignment.LEADING)
				.addComponent(areaTitulo, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
				.addGroup(contJanela.createSequentialGroup()
					.addGap(14)
					.addComponent(grid, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(contJanela.createSequentialGroup()
					.addGap(12)
					.addComponent(areaBotoes, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
					.addGap(12))
	);
    contJanela.setVerticalGroup(
            contJanela.createParallelGroup(Alignment.LEADING)
                    .addGroup(contJanela.createSequentialGroup()
                            .addComponent(areaTitulo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addGap(10)
                            .addComponent(grid, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addGap(14)
                            .addComponent(areaBotoes, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addGap(10))
	);
                
        JTextArea textArea = new JTextArea();
	textArea.setEditable(false);
        textArea.setText("000000");
        textArea.setForeground(Color.YELLOW);
        textArea.setBackground(Color.BLACK);
	textArea.setBounds(313, 23, 48, 15);
	areaBotoes.add(textArea);
        
        JTextArea txtrScore = new JTextArea();
	txtrScore.setEditable(false);
	txtrScore.setBackground(Color.LIGHT_GRAY);
	txtrScore.setText("Score:");
	txtrScore.setBounds(260, 22, 50, 30);
	areaBotoes.add(txtrScore);
        
        final JSpinner spinner = new JSpinner();
	spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
	spinner.setBounds(200, 21, 35, 20);
        spinner.setValue(5);
	areaBotoes.add(spinner);
        
        JTextArea txtrSpeed = new JTextArea();
	txtrSpeed.setEditable(false);
	txtrSpeed.setBackground(Color.LIGHT_GRAY);
	txtrSpeed.setText("Speed");
	txtrSpeed.setBounds(145, 22, 55, 20);
	areaBotoes.add(txtrSpeed);
        grid.setLayout(null);
        
        JTextArea textoTitulo = new JTextArea();
	textoTitulo.setEditable(false);
	textoTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
	textoTitulo.setBackground(Color.LIGHT_GRAY);
        areaTitulo.setLayer(textoTitulo, 0);
	textoTitulo.setText("Snake");
	textoTitulo.setBounds(10, 8, 70, 22);
	areaTitulo.add(textoTitulo);
                
        janelaJogo.getContentPane().setLayout(contJanela);
        janelaJogo.setTitle("Snake");
        janelaJogo.setResizable(false);
        janelaJogo.setBounds(posX, posY, width, height);
        janelaJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        janelaJogo.setJMenuBar(menuBar);
        
        final JMenu mnSnake = new JMenu("Snake");
	mnSnake.setHorizontalAlignment(SwingConstants.CENTER);
	menuBar.add(mnSnake);
        
        final JButton btnSimple = new JButton("Simple");
	mnSnake.add(btnSimple);
	btnSimple.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(grid.getSnake().snakeType[0] != true) {
                    grid.getSnake().snakeType[0] = true;
                    grid.getSnake().snakeType[1] = false;
                    grid.getSnake().snakeType[2] = false;
                    grid.getSnake().score = 0;
                    grid.setSnake(new Snake(grid.pontosMatriz));
                    grid.fruit.locateFruit();
                    grid.repaint();	
                }
                		
            }
	});
		
	final JButton btnStar = new JButton("Star");
        mnSnake.add(btnStar);
	btnStar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(grid.getSnake().snakeType[1] != true) {
                    grid.getSnake().snakeType[1] = true;
                    grid.getSnake().snakeType[0] = false;
                    grid.getSnake().snakeType[2] = false;
                    grid.getSnake().score = 0;
                    grid.setSnake(new Star(grid.pontosMatriz));
                    grid.fruit.locateFruit();
                    grid.repaint();	
                }
            }
        });
		
	final JButton btnKitty = new JButton("Kitty");
	mnSnake.add(btnKitty);
	btnKitty.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if(grid.getSnake().snakeType[2] != true) {
                    grid.getSnake().snakeType[2] = true;
                    grid.getSnake().snakeType[0] = false;
                    grid.getSnake().snakeType[1] = false;
                    grid.getSnake().score = 0;
                    grid.setSnake(new Kitty(grid.pontosMatriz));
                    grid.fruit.locateFruit();
                    grid.repaint();	
                }
            }
	});
        
        final JMenu mnFrutas = new JMenu("Fruits");
	menuBar.add(mnFrutas);
		
	JRadioButtonMenuItem rdbtnmntmSimple = new JRadioButtonMenuItem("Simple");
	rdbtnmntmSimple.setSelected(true);
	mnFrutas.add(rdbtnmntmSimple);
		
	JRadioButtonMenuItem rdbtnmntmBomb = new JRadioButtonMenuItem("Bomb");
	mnFrutas.add(rdbtnmntmBomb);
		
	JRadioButtonMenuItem rdbtnmntmBig = new JRadioButtonMenuItem("Big");
	mnFrutas.add(rdbtnmntmBig);
		
	JRadioButtonMenuItem rdbtnmntmDecrease = new JRadioButtonMenuItem("Decrease");
	mnFrutas.add(rdbtnmntmDecrease);
 
        final JButton btnNewButton = new JButton("PLAY");
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
	btnNewButton.setBounds(12, 13, 110, 35);
	areaBotoes.add(btnNewButton);
	btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
		if("PLAY".equals(btnNewButton.getText())) {
                    btnNewButton.setText("PAUSE");
                    spinner.setEnabled(false);
                    mnSnake.setEnabled(false);
                    mnFrutas.setEnabled(false);
                    grid.inGame = true;
                    grid.setEnabled(true);
		} else if("PAUSE".equals(btnNewButton.getText())) {
                    btnNewButton.setText("PLAY");
                    grid.inGame = false;
                    grid.setEnabled(false);
                } 
            }
	});
    }

}
