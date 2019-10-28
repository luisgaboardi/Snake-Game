package visual;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

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
import java.util.ArrayList;
import java.util.List;

public class Tela {

	private int largura = 400;
    private int altura = 435;
    private int posX = 650;
    private int posY = 150;
    private static double scale = 15;
    private Snake snake = new Snake();
    
    private JFrame janelaJogo;
    
    @SuppressWarnings("serial")
	public static class Grid extends JPanel {

        private List<Point> fillCells;

        public Grid() {
            fillCells = new ArrayList<>(475);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 375, 285);

//            g.setColor(Color.WHITE);
//            for (int i = 0; i <= 360; i += getScale()) {
//                g.drawLine(i, 0, i, 285);
//            }
//
//            for (int i = 0; i <= 270; i += getScale()) {
//                g.drawLine(0, i, 375, i);
//            }
        }

        public void fillCell(int x, int y) {
            fillCells.add(new Point(x, y));
            repaint();
        }

    }

	public static double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		Tela.scale = scale;
	}
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
		areaTitulo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		areaTitulo.setBackground(Color.WHITE);
		
		JLayeredPane areaBotoes = new JLayeredPane();
		areaBotoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		Grid grid = new Grid();
		
		GroupLayout contJanela = new GroupLayout(janelaJogo.getContentPane());
		contJanela.setHorizontalGroup(
			contJanela.createParallelGroup(Alignment.LEADING)
				.addComponent(areaTitulo, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
				.addGroup(contJanela.createSequentialGroup()
					.addGap(12)
					.addComponent(grid, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
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
					.addComponent(grid, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(areaBotoes, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addGap(10))
		);
		
		final JButton btnNewButton = new JButton("PLAY");
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
		btnNewButton.setBounds(15, 11, 110, 35);
		areaBotoes.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("000000");
		textArea.setBounds(305, 20, 48, 15);
		areaBotoes.add(textArea);
		
		JTextArea txtrScore = new JTextArea();
		txtrScore.setEditable(false);
		txtrScore.setBackground(Color.LIGHT_GRAY);
		txtrScore.setText("Score:");
		txtrScore.setBounds(265, 20, 52, 20);
		areaBotoes.add(txtrScore);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(190, 18, 33, 20);
		areaBotoes.add(spinner);
		
		JTextArea txtrSpeed = new JTextArea();
		txtrSpeed.setEditable(false);
		txtrSpeed.setBackground(Color.LIGHT_GRAY);
		txtrSpeed.setText("Speed");
		txtrSpeed.setBounds(145, 20, 42, 20);
		areaBotoes.add(txtrSpeed);
		grid.setLayout(null);
		
		JTextArea textoTitulo = new JTextArea();
		textoTitulo.setEditable(false);
		textoTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		textoTitulo.setBackground(Color.LIGHT_GRAY);
		areaTitulo.setLayer(textoTitulo, 0);
		textoTitulo.setText("Snake");
		textoTitulo.setBounds(10, 8, 73, 30);
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