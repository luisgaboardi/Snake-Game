package visual;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tela {

	private int largura = 400;
    private int altura = 450;
    private int posX = 650;
    private int posY = 150;
    private Snake snake = new Snake();
    
    private JFrame janelaJogo;

	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	public JFrame getJanelaJogo() {
		return janelaJogo;
	}
	public void setJanelaJogo(JFrame janelaJogo) {
		this.janelaJogo = janelaJogo;
	}
	
	public void beginGame() {
		
	}

	public Tela() {
		janelaJogo = new JFrame();
		janelaJogo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		janelaJogo.getContentPane().setBackground(Color.LIGHT_GRAY);
		janelaJogo.setSize(300, 350);
		
		JLayeredPane areaTitulo = new JLayeredPane();
		areaTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		areaTitulo.setBackground(Color.WHITE);
		
		JLayeredPane areaBotoes = new JLayeredPane();
		areaBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel telaJogo = new JPanel();
		telaJogo.setBackground(Color.BLACK);
		telaJogo.setSize(280, 300);
		
		GroupLayout contJanela = new GroupLayout(janelaJogo.getContentPane());
		contJanela.setHorizontalGroup(
			contJanela.createParallelGroup(Alignment.LEADING)
				.addComponent(areaTitulo, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
				.addGroup(contJanela.createSequentialGroup()
					.addGap(12)
					.addComponent(telaJogo, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
					.addGap(12))
				.addGroup(contJanela.createSequentialGroup()
					.addGap(12)
					.addComponent(areaBotoes, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
					.addGap(12))
		);
		contJanela.setVerticalGroup(
			contJanela.createParallelGroup(Alignment.LEADING)
				.addGroup(contJanela.createSequentialGroup()
					.addComponent(areaTitulo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(telaJogo, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(areaBotoes, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addGap(10))
		);
		
		JButton btnNewButton = new JButton("PLAY");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnNewButton.getText() == "PLAY") {
					btnNewButton.setText("PAUSE");
					
					///				 	 ///
					///				 	 ///
					///  COMECAR O JOGO  ///
					///					 ///
					///					 ///
					
				} else {
					btnNewButton.setText("PLAY");
					
					///				 	///
					///				 	///
					///  PAUSAR O JOGO  ///
					///					///
					///					///
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(10, 10, 90, 30);
		areaBotoes.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("000000");
		textArea.setBounds(306, 18, 42, 16);
		areaBotoes.add(textArea);
		
		JTextArea txtrScore = new JTextArea();
		txtrScore.setEditable(false);
		txtrScore.setBackground(Color.LIGHT_GRAY);
		txtrScore.setText("Score:");
		txtrScore.setBounds(264, 18, 52, 20);
		areaBotoes.add(txtrScore);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(190, 15, 33, 20);
		areaBotoes.add(spinner);
		
		JTextArea txtrSpeed = new JTextArea();
		txtrSpeed.setEditable(false);
		txtrSpeed.setBackground(Color.LIGHT_GRAY);
		txtrSpeed.setText("Speed");
		txtrSpeed.setBounds(145, 18, 42, 20);
		areaBotoes.add(txtrSpeed);
		telaJogo.setLayout(null);
		
		JTextArea textoTitulo = new JTextArea();
		textoTitulo.setEditable(false);
		textoTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		textoTitulo.setBackground(Color.LIGHT_GRAY);
		areaTitulo.setLayer(textoTitulo, 0);
		textoTitulo.setText("Snake");
		textoTitulo.setBounds(10, 5, 73, 30);
		areaTitulo.add(textoTitulo);
		janelaJogo.getContentPane().setLayout(contJanela);
		janelaJogo.setTitle("Snake");
		janelaJogo.setResizable(false);
		janelaJogo.setBounds(posX, posY, largura, altura);
		janelaJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		janelaJogo.setJMenuBar(menuBar);
		
		JMenu mnCobra = new JMenu("Snake");
		mnCobra.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnCobra);
		
		JButton btnComum = new JButton("Simple");
		mnCobra.add(btnComum);
		
		JButton btnStar = new JButton("Star");
		mnCobra.add(btnStar);
		
		JButton btnKitty = new JButton("Kitty");
		mnCobra.add(btnKitty);
		
		JMenu mnFrutas = new JMenu("Fruits");
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
	}
}