package snake;

import javax.swing.JFrame;

public class Container extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Container() {
		add(new Snake());
		setTitle("Snake");
		setSize(800, 840);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Container();
	}
}
