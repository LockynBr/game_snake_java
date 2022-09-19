package snake;

import java.awt.Color	;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int snakeDirection = 2;
	int comidaX = 400;
	int comidaY = 400;
	int [] xSnake =new int[500];
	int [] ySnake =new int[500];
	int tamanho = 1;

	public Snake() {
		setFocusable(true);
		setDoubleBuffered(true);
		Timer timer = new Timer(150, this);
		timer.start();
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case KeyEvent.VK_UP:
			snakeDirection = 0;
			break;
		case KeyEvent.VK_DOWN:
			snakeDirection = 1;
			break;
		case KeyEvent.VK_RIGHT:
			snakeDirection = 2;
			break;
		case KeyEvent.VK_LEFT:
			snakeDirection = 3;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 800);

		for (int i = 0; i < tamanho; i++) {

			g.setColor(Color.GREEN);
			g.fillRect(xSnake[i], ySnake[i], 40, 40);
			
			g.setColor(Color.RED);
			g.fillOval(comidaX, comidaY, 40, 40);
		}

		g.dispose();
	}

	private void update() {
		int xAntigo = xSnake[0];
		int yAntigo = ySnake[0];
		switch (snakeDirection) {
		case 0: //cima
			ySnake[0] -= 40;
			if(ySnake[0] < 0)
				ySnake[0] = 800;
			break;
		case 1: //baixo
			ySnake[0] += 40;
			if(ySnake[0] > 800)
				ySnake[0] = 40;
			break;
		case 2: //direita
			xSnake[0] +=40;
			if(xSnake[0] > 800)
				xSnake[0] = 40;
			break;
		case 3: //esquerda
			xSnake[0] -=40;
			if(xSnake[0] < 0)
				xSnake[0] = 800;
			break;
		default:
			break;
		}

		
		if(xSnake[0] == comidaX && ySnake[0] == comidaY) {
			Random random = new Random();
			comidaX = random.nextInt(19)*40;
			comidaY = random.nextInt(19)*40;
			tamanho++;
		}
		
		for (int i = 1; i < tamanho; i++) {
			int xAntigo2 = xSnake[i];
			int yAntigo2 = ySnake[i];
			xSnake[i] = xAntigo;
			ySnake[i] = yAntigo;
			xAntigo = xAntigo2;
			yAntigo = yAntigo2;
		}

	}
}
