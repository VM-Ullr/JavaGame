package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class PanelGame extends PanelFond {
	
	protected PanelPlateau panelPlateau;
	protected PanelEtatperso panelEtatperso1;
	protected PanelEtatperso panelEtatperso2;
	protected PanelDial panelDial;
	protected int delay;
	protected ActionListener taskPerformer;
	protected Timer timer;



	public PanelGame(Frame parent, perso J1, perso J2) {
		super(parent);
		Thread song = SoundManager.randomSong();
		song.start();
		fondmenu = new ImageIcon("photos/fond.png");
		setLayout(null);
		panelPlateau = new PanelPlateau(this, J1, J2);
		add(panelPlateau);
		panelEtatperso1 = new PanelEtatperso(this,J1,20);
		add(panelEtatperso1);
		panelEtatperso2 = new PanelEtatperso(this,J2,280);
		add(panelEtatperso2);
		panelDial = new PanelDial(this, panelPlateau); 
		add(panelDial);
		delay = 1000; //milliseconds
		taskPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				song.stop();
				SoundManager.randVictorySong().start();
				goToPanelFond(new PanelFin(parent, J1, J2));
				setVisible(false);	
			}
		};
		timer = new Timer(delay, taskPerformer);

	}
	
	@Override
	public void onKeyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Z:
			panelPlateau.getPlateau().setSelectedSort(null);
			panelDial.setLignes(panelPlateau.getPlateau().deplacement(8, panelPlateau.getPlateau().actualPlayer));
			break;
		case KeyEvent.VK_Q:
			panelPlateau.getPlateau().setSelectedSort(null);
			panelDial.setLignes(panelPlateau.getPlateau().deplacement(4, panelPlateau.getPlateau().actualPlayer));
			break;
		case KeyEvent.VK_S:
			panelPlateau.getPlateau().setSelectedSort(null);
			panelDial.setLignes(panelPlateau.getPlateau().deplacement(5, panelPlateau.getPlateau().actualPlayer));
			break;
		case KeyEvent.VK_D:
			panelPlateau.getPlateau().setSelectedSort(null);
			panelDial.setLignes(panelPlateau.getPlateau().deplacement(6, panelPlateau.getPlateau().actualPlayer));
			break;
		case KeyEvent.VK_SPACE:
			panelDial.setLignes(panelPlateau.getPlateau().passerTour());
			panelDial.setJeton(panelPlateau.getPlateau().getActualPlayer());
			break;
		case KeyEvent.VK_1:
			panelPlateau.getPlateau().setSelectedSort(panelPlateau.getPlateau().actualPlayer.getSort()[0]);
			break;
		case KeyEvent.VK_2:
			panelPlateau.getPlateau().setSelectedSort(panelPlateau.getPlateau().actualPlayer.getSort()[1]);
			break;
		case KeyEvent.VK_3:
			panelPlateau.getPlateau().setSelectedSort(panelPlateau.getPlateau().actualPlayer.getSort()[2]);
			break;
		case KeyEvent.VK_4:
			panelPlateau.getPlateau().setSelectedSort(panelPlateau.getPlateau().actualPlayer.getSort()[3]);
			break;
			
		default:
			break;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, this.getSize().width, this.getSize().height);
		g.drawImage(fondmenu.getImage(), 0, 0, null);
	}


	/**
	 * @return the parent
	 */
	public Frame getParent() {
		return parent;
	}


	/**
	 * @param parent the parent to set
	 */
	public void setParent(Frame parent) {
		this.parent = parent;
	}


	/**
	 * @return the fondmenu
	 */
	public ImageIcon getFondmenu() {
		return fondmenu;
	}


	/**
	 * @param fondmenu the fondmenu to set
	 */
	public void setFondmenu(ImageIcon fondmenu) {
		this.fondmenu = fondmenu;
	}


	/**
	 * @return the panelPlateau
	 */
	public PanelPlateau getPanelPlateau() {
		return panelPlateau;
	}


	/**
	 * @param panelPlateau the panelPlateau to set
	 */
	public void setPanelPlateau(PanelPlateau panelPlateau) {
		this.panelPlateau = panelPlateau;
	}

	public PanelDial getPanelDial() {
		return panelDial;
	}

	public void setPanelDial(PanelDial panelDial) {
		this.panelDial = panelDial;
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		if (panelPlateau.getPlateau().getSelectedSort() != null){
			int posX = e.getX();
			int posY = e.getY();
			if(posX>= 20 && posX<=20+17*30 && posY>= 20 && posY<=20+17*30){
				posX = (posX-20)/30;
				posY = (posY-55)/30;
				if (panelPlateau.getPlateau().getSelectedSort().isInRange(posX, posY) && panelPlateau.getPlateau().getPlateauPerso()[posY][posX]!=null) {
					panelPlateau.setAnimSpell(panelPlateau.getPlateau().getSelectedSort());
					panelDial.setLignes(panelPlateau.getPlateau().getSelectedSort().lancerSort(panelPlateau.getPlateau(), posX, posY));
					if (panelPlateau.getPlateau().endGame()) {
						timer.start();
					}
				}
			}
		}
		panelPlateau.getPlateau().setSelectedSort(null);
	}
}
