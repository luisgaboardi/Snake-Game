package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.text.DefaultFormatter;

public class Janela {

    private final int width = 400;
    private final int height = 450;
    private final int posX = 600;
    private final int posY = 250;
    private JFrame janelaJogo;
    protected Grid grid;
    private JButton btnPlay;
    private JSpinner speedValue;
    private JTextArea score;

    public JFrame getJanelaJogo() {
        return janelaJogo;
    }

    public Janela() {
        initJanela();
    }

    private void initJanela() {

        janelaJogo = new JFrame();
        janelaJogo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
        janelaJogo.getContentPane().setBackground(new Color(0, 90, 0));
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

        score = new JTextArea();
        score.setEditable(false);
        score.setText("000000");
        score.setForeground(Color.YELLOW);
        score.setBackground(Color.BLACK);
        score.setBounds(313, 23, 48, 15);
        areaBotoes.add(score);

        JTextArea txtScore = new JTextArea();
        txtScore.setEditable(false);
        txtScore.setForeground(Color.BLACK);
        txtScore.setBackground(new Color(0, 90, 0));
        txtScore.setText("Score:");
        txtScore.setBounds(270, 22, 45, 15);
        areaBotoes.add(txtScore);

        speedValue = new JSpinner();
        speedValue.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        speedValue.setBounds(200, 21, 35, 20);
        speedValue.setValue(5);
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
        areaBotoes.add(txtSpeed);

        JTextArea textoTitulo = new JTextArea();
        textoTitulo.setEditable(false);
        textoTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
        textoTitulo.setBackground(new Color(0, 90, 0));
        textoTitulo.setForeground(Color.BLACK);
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

        final JMenu menuSnake = new JMenu("Snake");
        menuSnake.setHorizontalAlignment(SwingConstants.CENTER);
        menuBar.add(menuSnake);

        final JButton btnSimple = new JButton("Simple");
        menuSnake.add(btnSimple);
        btnSimple.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (grid.getSnake().snakeType[0] != true) {
                    grid.getSnake().snakeType[0] = true;
                    grid.getSnake().snakeType[1] = false;
                    grid.getSnake().snakeType[2] = false;
                    grid.getSnake().score = 0;
                    grid.setSnake(new Snake(grid.pontosMatriz));
                    grid.repaint();
                }

            }
        });

        final JButton btnStar = new JButton("Star");
        menuSnake.add(btnStar);
        btnStar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (grid.getSnake().snakeType[1] != true) {
                    grid.getSnake().snakeType[1] = true;
                    grid.getSnake().snakeType[0] = false;
                    grid.getSnake().snakeType[2] = false;
                    grid.getSnake().score = 0;
                    grid.setSnake(new Star(grid.pontosMatriz));
                    grid.repaint();
                }
            }
        });

        final JButton btnKitty = new JButton("Kitty");
        menuSnake.add(btnKitty);
        btnKitty.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (grid.getSnake().snakeType[2] != true) {
                    grid.getSnake().snakeType[2] = true;
                    grid.getSnake().snakeType[0] = false;
                    grid.getSnake().snakeType[1] = false;
                    grid.getSnake().score = 0;
                    grid.setSnake(new Kitty(grid.pontosMatriz));
                    grid.repaint();
                }
            }
        });

        final JMenu menuFrutas = new JMenu("Fruits");
        menuBar.add(menuFrutas);

        JRadioButtonMenuItem btnFruitSimple = new JRadioButtonMenuItem("Simple");
        btnFruitSimple.setSelected(true);
        menuFrutas.add(btnFruitSimple);

        JRadioButtonMenuItem btnFruitBomb = new JRadioButtonMenuItem("Bomb");
        menuFrutas.add(btnFruitBomb);

        JRadioButtonMenuItem btnFruitBig = new JRadioButtonMenuItem("Big");
        menuFrutas.add(btnFruitBig);

        JRadioButtonMenuItem btnFruitDecrease = new JRadioButtonMenuItem("Decrease");
        menuFrutas.add(btnFruitDecrease);

        btnPlay = new JButton("PLAY");
        btnPlay.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnPlay.setBounds(12, 13, 110, 35);
        areaBotoes.add(btnPlay);
        btnPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if ("PLAY".equals(btnPlay.getText())) {
                    btnPlay.setText("PAUSE");
                    speedValue.setEnabled(false);
                    menuSnake.setEnabled(false);
                    menuFrutas.setEnabled(false);
                    grid.setEnabled(true);
                    grid.inGame = true;
                    grid.setEnabled(true);
                    int speed = speedFormula(grid.getSnake().getSpeed());
                    grid.timer = new Timer(speed, grid); // Thread aqui
                    grid.timer.start();
                    grid.repaint();
                } else if ("PAUSE".equals(btnPlay.getText())) {
                    btnPlay.setText("PLAY");
                    grid.inGame = false;
                    grid.setEnabled(false);
                    grid.timer.stop();

                }
            }
        });

    }

    protected int speedFormula(int x) {
        return 1 * x * x - 17 * x + 140;
    }

    public class Grid extends JPanel implements ActionListener {

        private final int width = 370;
        private final int height = 290;
        final int pontosMatriz = 1073;
        private final int scale = 10;
        boolean inGame = false;
        boolean morto = false;

        Timer timer;
        private Snake snake;
        Fruit fruit;
        private boolean unico = false;

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
            setEnabled(false);
            setFocusable(true);
            setBackground(Color.BLACK);
            initGame();
        }

        private void initGame() {
            this.snake = new Snake(pontosMatriz);

            for (int z = 0; z < snake.getBodySize(); z++) {
                snake.getBodyPos()[z].x = 100 - z * scale;
                snake.getBodyPos()[z].y = 100;
            }

            randomFruit();

            Action leftAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!snake.rightDirection) {
                        snake.leftDirection = true;
                        snake.upDirection = false;
                        snake.downDirection = false;
                    }
                }
            };

            Action rightAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!snake.leftDirection) {
                        snake.rightDirection = true;
                        snake.upDirection = false;
                        snake.downDirection = false;
                    }
                }
            };
            Action upAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!snake.downDirection) {
                        snake.upDirection = true;
                        snake.rightDirection = false;
                        snake.leftDirection = false;
                    }

                }
            };
            Action downAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!snake.upDirection) {
                        snake.downDirection = true;
                        snake.rightDirection = false;
                        snake.leftDirection = false;
                    }
                }
            };

            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), leftAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_KP_LEFT, 0), leftAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_4, 0), leftAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), leftAction);

            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), rightAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_KP_RIGHT, 0), rightAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_6, 0), rightAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), rightAction);

            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), upAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_KP_UP, 0), upAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), upAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), upAction);

            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), downAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_KP_DOWN, 0), downAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_0, 0), downAction);
            bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), downAction);

        }

        private void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action) {
            InputMap im = getInputMap(condition);
            ActionMap am = getActionMap();

            im.put(keyStroke, name);
            am.put(name, action);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if ("PLAY".equals(btnPlay.getText())) {
                gameStart(g);
            }

            if (!morto) {
                g.setColor(snake.getColor());

                for (int z = snake.getBodySize() - 1; z > 0; --z) { // Fixes delay in eating fruit
                    int posX = (int) snake.getBodyPos()[z].getX();
                    int posY = (int) snake.getBodyPos()[z].getY();
                    g.fillRect(posX, posY, scale, scale);
                }

                g.setColor(fruit.getColor());
                g.fillRect(fruit.getPos().x, fruit.getPos().y, scale, scale);

                Toolkit.getDefaultToolkit().sync();

                if (!unico && !morto) {
                    unico = true;

                    randomFruit();
                    fruit.locateFruit();

                }
            } else {
                gameOver(g);
                janelaJogo.dispose();
                int sameSpeed = (int)speedValue.getValue();
                initJanela();
                speedValue.setValue(sameSpeed);
                getJanelaJogo().setVisible(true);
            }
        }

        private void randomFruit() {

            Random r = new Random();
            int randomFruit = r.nextInt(101);
            if (randomFruit >= 10 && randomFruit < 60) {
                fruit = new Fruit();
                fruit.setScoreValue(snake.getSpeed());
            } else if (randomFruit >= 60 && randomFruit < 80) {
                fruit = new Bomb();
            } else if (randomFruit >= 80) {
                fruit = new Big();
                fruit.setScoreValue(2 * snake.getSpeed());
            } else if (randomFruit < 10) {
                fruit = new Decrease();
            }
        }

        private boolean checkApple() {

            if ((snake.getBodyPos()[0].x == fruit.getPos().x) && (snake.getBodyPos()[0].y == fruit.getPos().y)) {

                if (fruit instanceof Bomb) {
                    morto = true;
                } else if (fruit instanceof Decrease) {
                    snake.setBodySize(5);
                    unico = false;
                } else {
                    unico = snake.addPart();
                    if (snake instanceof Star) {
                        fruit.setScoreValue(2 * fruit.getScoreValue());
                    }
                    snake.setScore(snake.getScore() + fruit.getScoreValue());
                }

                return true;
            }
            return false;
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

            setBackground(Color.BLACK);
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 3);
            g.drawString(("Score: " + snake.getScore()), (width - metr.stringWidth("Score: " + snake.getScore())) / 2, height / 2);

            timer.stop();
        }

        @Override
        @SuppressWarnings("UnusedAssignment")
        public void actionPerformed(ActionEvent arg0) {
            if (!morto && inGame) {
                morto = snake.checkCollision();
                if (checkApple()) {
                    Janela.this.score.setText(Integer.toString(snake.getScore()));
                }
                snake.move();
                repaint();
            }
        }

    }

}
