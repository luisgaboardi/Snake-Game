package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;

import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Grid extends JPanel implements ActionListener {

    private final int width = 370;
    private final int height = 290;
    final int pontosMatriz = 1140;
    private final int scale = 10;
    private final int delay = 100;
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

    public void initGrid() {
        setFocusable(true);
        setBackground(Color.BLACK);
        initGame();
    }

    public void initGame() {
        this.snake = new Snake(pontosMatriz);
        for (int z = 0; z < snake.getBodySize(); z++) {
            snake.getBodyPos()[z].x = 100 - z * scale;
            snake.getBodyPos()[z].y = 100;
        }

        randomFruit();

        timer = new Timer(delay, this);
        timer.start();

        Action leftAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!snake.rightDirection) {
                    snake.leftDirection = true;
                    snake.upDirection = false;
                    snake.downDirection = false;
                    repaint();
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
                    repaint();
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
                    repaint();
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
                    repaint();
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

    protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action) {
        InputMap im = getInputMap(condition);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

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
        }
    }

    public void randomFruit() {

        Random r = new Random();
        int randomFruit = r.nextInt(101);
        if (randomFruit >= 10 && randomFruit < 60) {
            fruit = new Fruit();
            fruit.setScoreValue(snake.getSpeed());
            return;
        } else if (randomFruit >= 60 && randomFruit < 80) {
            fruit = new Bomb();
        } else if (randomFruit >= 80) {
            fruit = new Big();
            fruit.setScoreValue(2 * snake.getSpeed());
            return;
        } else if (randomFruit < 10) {
            fruit = new Decrease();
        }
    }

    public boolean checkApple() {

        return (snake.getBodyPos()[0].x == fruit.getPos().x) && (snake.getBodyPos()[0].y == fruit.getPos().y);
    }

    public void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        setBackground(Color.BLACK);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height / 2);

        timer.stop();
    }

    @Override
    @SuppressWarnings("UnusedAssignment")
    public void actionPerformed(ActionEvent arg0) {
        if (!morto && inGame) {
            morto = snake.checkCollision();
            if (checkApple()) {
                if (fruit instanceof Bomb) {
                    morto = true;
                } else if (fruit instanceof Decrease) {
                    snake.setBodySize(5);
                    unico = false;
                } else {
                    unico = snake.addPart();
                    snake.setScore(snake.getScore() + fruit.getScoreValue());
                    
                }
            }
            snake.move();
            repaint();
        }
    }

}
