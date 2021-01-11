package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.Timer;


/**Fenêtre principale du jeu
 */

public class Frame extends JFrame implements KeyListener, MouseListener	 {
	private PanelFond contentPane;
	private Timer timer;
	private ActionListener taskPerformer;
	private int delay;
    
	public Frame() {
		setLayout(null);
		setSize(1300, 735);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		setToPanel(new PanelChoice(this));
		delay = 50; //milliseconds
		taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		};
		timer = new Timer(delay, taskPerformer);
		timer.start();
		setVisible(true);
	}
	
	public void setToPanel(PanelFond panel) {
		contentPane = panel;
		setContentPane(panel);
		revalidate();
		repaint();
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		contentPane.onKeyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		contentPane.onMousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
}
