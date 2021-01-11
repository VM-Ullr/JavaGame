package game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import sort.Sort;

public class PanelPlateau extends PanelComp{
	
	protected Plateau plate;
	protected ImageIcon water = new ImageIcon("photos/water.png");
	protected ImageIcon grass = new ImageIcon("photos/grass.png");
	protected ImageIcon grass2 = new ImageIcon("photos/grass2.png");
	protected ImageIcon flower1 = new ImageIcon("photos/flower1.png");
	protected ImageIcon bridge = new ImageIcon("photos/bridge.png");
	protected ImageIcon rocher = new ImageIcon("photos/rock.png");
	protected ImageIcon flower2 = new ImageIcon("photos/flower2.png");
	protected Sort animSpell;
	
	public PanelPlateau(PanelFond parent, perso J1, perso J2) {
		super(parent);
		setBounds(20, 20, 17*30, 17*30);
		plate = new Plateau(J1,J2);
		animSpell = null;
	}
		
	@Override
	public void paintComponent(Graphics g) {
		int[][] plateauMonde = plate.getPlateauMod();
		perso[][] plateauPerso = plate.getPlateauPerso();
		for (int i = 0; i < plateauMonde[0].length; i++) {
			for (int j = 0; j < plateauMonde.length; j++) {
				switch (plateauMonde[j][i]) {
				case 0:
					g.drawImage(grass.getImage(), i*30, j*30, null);
					break;	
				case 3:
					g.drawImage(rocher.getImage(), i*30, j*30, null);
					break;
				case 4:
					g.drawImage(flower2.getImage(), i*30, j*30, null);
					break;
				case 5:
					g.drawImage(flower1.getImage(), i*30, j*30, null);
					break;
				case 6:
					g.drawImage(flower2.getImage(), i*30, j*30, null);
					break;
				case 7:
					g.drawImage(grass2.getImage(), i*30, j*30, null);
					break;
				case 8:
					g.drawImage(water.getImage(), i*30, j*30, null);
					break;
				case 9:
					g.drawImage(bridge.getImage(), i*30, j*30, null);
					break;
				default:
					break;
				}
			}
		}
		
		if (plate.getSelectedSort() != null){
			for (int i = (plate.getActualPlayer().getPosX()-plate.getSelectedSort().getPortee() >0)? plate.getActualPlayer().getPosX()-plate.getSelectedSort().getPortee() : 0; i <= ((plate.getActualPlayer().getPosX()+plate.getSelectedSort().getPortee() < plateauPerso.length)? plate.getActualPlayer().getPosX()+plate.getSelectedSort().getPortee() : plateauPerso.length); i++) {
				for (int j = (plate.getActualPlayer().getPosY()-plate.getSelectedSort().getPortee() >0)? plate.getActualPlayer().getPosY()-plate.getSelectedSort().getPortee() : 0; j <= ((plate.getActualPlayer().getPosY()+plate.getSelectedSort().getPortee() < plateauPerso.length)? plate.getActualPlayer().getPosY()+plate.getSelectedSort().getPortee() : plateauPerso.length); j++) {
					if(plate.selectedSort.isInRange(i, j)){
						g.drawRect(i*30, j*30,30,30);
					}
				}
			}
		}
		
		for (int i = 0; i < plateauPerso.length; i++) {
			for (int j = 0; j < plateauPerso[0].length; j++) {
				if (plateauPerso[i][j] != null){
					g.drawImage(plateauPerso[i][j].getJeton().getImage(), j*30, i*30, null);
				}
			}
		}
		if (animSpell != null) {
			if (animSpell.isOnAnimation()) {
				g.drawImage(animSpell.getCurentAnim().getImage(), animSpell.getPosXAnim(), animSpell.getPosYAnim(), null);
			}
		}
		
	}
	
	/**
	 * @return the plate
	 */
	public Plateau getPlateau() {
		return plate;
	}

	/**
	 * @param animSpell the animSpell to set
	 */
	public void setAnimSpell(Sort animSpell) {
		this.animSpell = animSpell;
	}
	
}
