package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.text.DefaultFormatter;

public class Window extends JFrame {

    private final int width = 400;
    private final int height = 450;

    private Grid grid;

    private JButton btnPlay;
    private JSpinner speedValue;
    private JTextArea score;

    public Window() {
        initWindow();
    }

    private void initWindow() {

        grid = new Grid();
        grid.addKeyListener(grid);
        grid.setFocusable(true);
        add(grid);

        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().setBackground(new Color(0, 90, 0));
        setSize(width, height);

        final JLayeredPane areaTitulo = new JLayeredPane();
        areaTitulo.setBounds(0, 0, width, 40);
        areaTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

        final JLayeredPane areaBotoes = new JLayeredPane();
        areaBotoes.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

        GroupLayout contJanela = new GroupLayout(getContentPane());
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

        score = new JTextArea();
        score.setEditable(false);
        score.setText("000000");
        score.setForeground(Color.YELLOW);
        score.setBackground(Color.BLACK);
        score.setBounds(313, 23, 48, 15);
        score.setFocusable(false);
        areaBotoes.add(score);

        JTextArea txtScore = new JTextArea();
        txtScore.setEditable(false);
        txtScore.setForeground(Color.BLACK);
        txtScore.setBackground(new Color(0, 90, 0));
        txtScore.setText("Score:");
        txtScore.setBounds(270, 22, 45, 15);
        txtScore.setFocusable(false);
        areaBotoes.add(txtScore);

        speedValue = new JSpinner();
        speedValue.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        speedValue.setBounds(200, 21, 35, 20);
        speedValue.setValue(5);
        speedValue.setFocusable(false);
        areaBotoes.add(speedValue);
        JComponent comp = speedValue.getEditor();
        JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
        DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
        formatter.setCommitsOnValidEdit(true);
        speedValue.addChangeListener((ChangeEvent e) -> {
            int value = (int) speedValue.getValue();
            grid.getSnake().setSpeed(value);
            grid.fruit.setScoreValue(value);
        });

        JTextArea txtSpeed = new JTextArea();
        txtSpeed.setEditable(false);
        txtSpeed.setForeground(Color.BLACK);
        txtSpeed.setBackground(new Color(0, 90, 0));
        txtSpeed.setText("Speed");
        txtSpeed.setBounds(155, 22, 40, 17);
        txtSpeed.setFocusable(false);
        areaBotoes.add(txtSpeed);

        JTextArea textoTitulo = new JTextArea();
        textoTitulo.setEditable(false);
        textoTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
        textoTitulo.setBackground(new Color(0, 90, 0));
        textoTitulo.setForeground(Color.BLACK);
        textoTitulo.setText("Snake");
        textoTitulo.setBounds(10, 8, 70, 22);
        textoTitulo.setFocusable(false);
        areaTitulo.add(textoTitulo);

        getContentPane().setLayout(contJanela);
        setTitle("Snake");
        setResizable(false);
        setPreferredSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFocusable(false);
        setJMenuBar(menuBar);

        final JMenu menuSnake = new JMenu("Snake");
        menuSnake.setFocusable(false);
        menuBar.add(menuSnake);

        final JButton btnSimple = new JButton("Simple");
        btnSimple.setFocusable(false);
        menuSnake.add(btnSimple);
        btnSimple.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (grid.getSnake().snakeType[0] != true) {
                    grid.getSnake().snakeType[0] = true;
                    grid.getSnake().snakeType[1] = false;
                    grid.getSnake().snakeType[2] = false;
                    grid.getSnake().setScore(0);
                    grid.setSnake(new Snake(grid.nPoints));
                    grid.repaint();
                }
            }
        });

        final JButton btnStar = new JButton("Star");
        btnStar.setFocusable(false);
        menuSnake.add(btnStar);
        btnStar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (grid.getSnake().snakeType[1] != true) {
                    grid.getSnake().snakeType[1] = true;
                    grid.getSnake().snakeType[0] = false;
                    grid.getSnake().snakeType[2] = false;
                    grid.getSnake().score = 0;
                    grid.setSnake(new Star(grid.nPoints));
                    grid.repaint();
                }
            }
        });

        final JButton btnKitty = new JButton("Kitty");
        btnKitty.setFocusable(false);
        menuSnake.add(btnKitty);
        btnKitty.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (grid.getSnake().snakeType[2] != true) {
                    grid.getSnake().snakeType[2] = true;
                    grid.getSnake().snakeType[0] = false;
                    grid.getSnake().snakeType[1] = false;
                    grid.getSnake().score = 0;
                    grid.setSnake(new Kitty(grid.nPoints));
                    grid.repaint();
                }
            }
        });

        btnPlay = new JButton("PLAY");
        btnPlay.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnPlay.setBounds(14, 14, 110, 35);
        btnPlay.setFocusable(false);
        areaBotoes.add(btnPlay);
        btnPlay.addMouseListener(new MouseAdapter() {
            @Override
            @SuppressWarnings("empty-statement")
            public void mouseClicked(MouseEvent arg0) {
                if ("PLAY".equals(btnPlay.getText())) {

                    btnPlay.setText("RESET");

                    speedValue.setEnabled(false);
                    menuSnake.setEnabled(false);

                    grid.gameLoop.start();
                    grid.setEnabled(true);

                    grid.inGame = true;
                    repaint();

                } else if ("RESET".equals(btnPlay.getText())) {

                    grid.snake.dead = true;

                }
            }
        });

        pack();

    }

    protected int speedFormula(int x) {
        return x * x - 17 * x + 140;
    }

    public class Grid extends JPanel implements KeyListener, Runnable {

        private final int width = 370;
        private final int height = 290;
        private final int nPoints = 1073;
        private final int scale = 8;
        private boolean inGame = false;

        private Thread gameLoop;
        private Snake snake;
        private Fruit fruit;
        private Fruit fruit2;
        private Barriers barrier;

        public Snake getSnake() {
            return snake;
        }

        public void setSnake(Snake snake) {
            this.snake = snake;
        }

        public Grid() {
            initGrid();
        }

        private void initGrid() {
            setBackground(Color.BLACK);
            initGame();
        }

        private void initGame() {

            snake = new Snake(nPoints);

            barrier = new Barriers();

            boolean posAvailable;

            fruit = new Fruit();
            do {
                posAvailable = fruit.newPos(grid, snake, barrier);
            } while (!posAvailable);

            fruit2 = selectRandomFruit();
            do {
                posAvailable = fruit2.newPos(grid, snake, barrier);
            } while (!posAvailable);

            gameLoop = new Thread(this);

        }

        protected Fruit selectRandomFruit() {

            Fruit fruitX = new Fruit();

            Random r = new Random();
            int randomFruit = r.nextInt(101);

            if (randomFruit >= 10 && randomFruit < 60) {
                fruitX = new Fruit();
                fruitX.setScoreValue(snake.getSpeed());
            } else if (randomFruit >= 60 && randomFruit < 80) {
                fruitX = new Bomb();
            } else if (randomFruit >= 80) {
                fruitX = new Big();
                fruitX.setScoreValue(2 * snake.getSpeed());
            } else if (randomFruit < 10) {
                fruitX = new Decrease();
            }

            return fruitX;
        }

        @Override
        public void run() {
            System.out.println("");
            while (inGame && !snake.dead) {

                snake.dead = snake.checkCollision();
                if (fruit.checkAppleEaten(snake)) {
                    score.setText(Integer.toString(snake.getScore()));
                }
                if (fruit2.checkAppleEaten(snake)) {
                    score.setText(Integer.toString(snake.getScore()));
                }
                snake.move();
                repaint();

                try {
                    Thread.sleep(speedFormula(snake.getSpeed()));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if ("PLAY".equals(btnPlay.getText())) {
                gameStart(g);
            }

            barrier.paintComponent(g);

            if (!snake.dead) {

                g.setColor(snake.getColor());
                for (int z = snake.getBodySize() - 1; z > 0; --z) {
                    int posX = (int) snake.getBodyPos()[z].getX();
                    int posY = (int) snake.getBodyPos()[z].getY();
                    g.fillRect(posX + 2, posY + 2, scale, scale);
                }
                if (!fruit.onScreen || !fruit2.onScreen) {
                    
                    boolean posAvailable;

                    do {
                        posAvailable = fruit.newPos(grid, snake, barrier);
                    } while (!posAvailable);

                    fruit2 = selectRandomFruit();
                    
                    do {
                        posAvailable = fruit2.newPos(grid, snake, barrier);
                    } while (!posAvailable);

                }

                g.setColor(fruit.getColor());
                g.fillRect(fruit.getPos().x + 2, fruit.getPos().y + 2, scale, scale);

                g.setColor(fruit2.getColor());
                g.fillRect(fruit2.getPos().x + 2, fruit2.getPos().y + 2, scale, scale);

                Toolkit.getDefaultToolkit().sync();

            } else {
                gameOver(g);
                Window.this.dispose();
                int sameSpeed = (int) speedValue.getValue();
                speedValue.setValue(sameSpeed);
                new Window().speedValue.setValue(sameSpeed);

            }
        }

        private void gameStart(Graphics g) {

            String msg = "Press PLAY to start";
            Font small = new Font("Helvetica", Font.BOLD, 20);
            FontMetrics metr = getFontMetrics(small);

            setBackground(Color.BLACK);
            g.setColor(Color.GREEN);
            g.setFont(small);
            g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 2);

        }

        private void gameOver(Graphics g) {

            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = getFontMetrics(small);

            g.clearRect(0, 0, width + 5, height + 5);
            g.setColor(Color.black);
            g.fillRect(0, 0, width + 5, height + 5);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 3);
            g.drawString(("Score: " + snake.getScore()), (width - metr.stringWidth("Score: " + snake.getScore())) / 2, height / 2);

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int k = e.getKeyCode();

            if (k == KeyEvent.VK_UP && !snake.downDirection) {
                snake.upDirection = true;
                snake.downDirection = false;
                snake.rightDirection = false;
                snake.leftDirection = false;
            } else if (k == KeyEvent.VK_DOWN && !snake.upDirection) {
                snake.upDirection = false;
                snake.downDirection = true;
                snake.rightDirection = false;
                snake.leftDirection = false;
            } else if (k == KeyEvent.VK_LEFT && !snake.rightDirection) {
                snake.upDirection = false;
                snake.downDirection = false;
                snake.rightDirection = false;
                snake.leftDirection = true;
            } else if (k == KeyEvent.VK_RIGHT && !snake.leftDirection) {
                snake.upDirection = false;
                snake.downDirection = false;
                snake.rightDirection = true;
                snake.leftDirection = false;
            }
        }

//        public class FruitTimer extends JPanel implements Runnable {
//
//            private int time;
//
//            @Override
//            public void run() {
//                fruitLoop();
//            }
//
//            public void fruitLoop() {
//                
//                while (inGame && !snake.dead) {
//                    
//                        fruit = grid.selectRandomFruit();
//
//                        if (fruit instanceof Decrease) {
//                            time = 3000;
//                        } else if (fruit instanceof Bomb) {
//                            time = 6000;
//                        } else if (fruit instanceof Big) {
//                            time = 4000;
//                        } else if (fruit instanceof Fruit) {
//                            time = 6000;
//                        }
//
//                        fruit.newPos(grid, snake);
//                        //grid.repaint(); // Curioso
//
//                        try {
//                            Thread.sleep(time);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(FruitTimer.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                }
//            }
//
//        }
        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

    }

}
