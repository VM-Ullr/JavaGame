package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class PanelChoice extends PanelFond {
	
	protected boolean firstPlayer;
	protected boolean choice;
	protected ImageIcon J1;
	protected ImageIcon J2;
	protected perso choiceFirstPlayer;
	protected perso choiceSecondPlayer;
	protected int delay;
	protected ActionListener taskPerformer;
	protected Timer timer;

	public PanelChoice(Frame parent) {
		super(parent);
		Thread song = SoundManager.music("sfx/menu.wav");
		song.start();
		fondmenu = new ImageIcon("photos/fondmenu.png");
		firstPlayer = true;
		choice = true;
		choiceFirstPlayer = null;
		choiceSecondPlayer = null;
		delay = 1000; //milliseconds
		taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				goToPanelFond(new PanelGame(parent, choiceFirstPlayer, choiceSecondPlayer));
				setVisible(false);
				song.stop();
			}
		};
		timer = new Timer(delay, taskPerformer);
	}
	
	@Override
	public void onKeyPressed(KeyEvent e) {
		if(choice) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_1:
				if (firstPlayer) {
					J1 = new ImageIcon("photos/paladinmenu.png");
					firstPlayer = false;
					choiceFirstPlayer = new paladin();
				} else if (!(choiceFirstPlayer instanceof paladin)){
					J2 = new ImageIcon("photos/paladinmenu.png");
					choiceSecondPlayer = new paladin();
					choice = false;
				}
				break;
			case KeyEvent.VK_2:
				if (firstPlayer) {
					J1 = new ImageIcon("photos/archermenu.png");
					firstPlayer = false;
					choiceFirstPlayer = new archer();
				} else if (!(choiceFirstPlayer instanceof archer)) {
					J2 = new ImageIcon("photos/archermenu.png");
					choiceSecondPlayer = new archer();
					choice = false;
				}		
				break;
			case KeyEvent.VK_3:
				if (firstPlayer) {
					J1 = new ImageIcon("photos/voleurmenu.png");
					firstPlayer = false;
					choiceFirstPlayer = new voleur();
				} else if (!(choiceFirstPlayer instanceof voleur)){
					J2 = new ImageIcon("photos/voleurmenu.png");
					choiceSecondPlayer = new voleur();
					choice = false;
				}
				break;
			case KeyEvent.VK_4:
				if (firstPlayer) {
					J1 = new ImageIcon("photos/berserkermenu.png");
					firstPlayer = false;
					choiceFirstPlayer = new berserker();
				} else if (!(choiceFirstPlayer instanceof berserker)){
					J2 = new ImageIcon("photos/berserkermenu.png");
					choiceSecondPlayer = new berserker();
					choice = false;
				}
				break;
			case KeyEvent.VK_5:
				if (firstPlayer) {
					J1 = new ImageIcon("photos/magemenu.png");
					firstPlayer = false;
					choiceFirstPlayer = new mage();
				} else if (!(choiceFirstPlayer instanceof mage)){
					J2 = new ImageIcon("photos/magemenu.png");
					choiceSecondPlayer = new mage();
					choice = false;
				}
				break;
			default:
				break;
			}
		}
		SoundManager.play("sfx/selection.wav");
	}

	public void paintComponent(Graphics g) {
		g.drawImage(fondmenu.getImage(), 0, 0, null);
		if (!firstPlayer) {
			g.drawImage(J1.getImage(), 225, 60, null);
			if (!choice) {
				g.drawImage(J2.getImage(), 775, 60, null);
				timer.start();
			}
		}
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
