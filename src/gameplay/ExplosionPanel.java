package gameplay;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import start.Frame;

public class ExplosionPanel extends JPanel{
	Cycle[] cycles;
	private int increment;
	private int explosionCount;
	private List<Color> explosionColors;
	private int buffer;
	Cycle curCycle;
	
	public ExplosionPanel(Cycle[] cycles, int increment, int buffer){
		this.cycles = cycles;
		this.increment = increment;
		this.buffer = buffer;
		
		setBounds(0,0,Frame.getXSize(), Frame.getYSize());
		setVisible(true);
		setLayout(null);
	}
	public void updatePanel(int explosionCount, List<Color> explosionColors){
		this.explosionCount = explosionCount;
		this.explosionColors = explosionColors;
		for (Cycle cycle : cycles){
			if (!cycle.isAlive){
				curCycle = cycle;
				paintImmediately(0,0,Frame.getXSize(),Frame.getYSize());
			}
		}
	}
	@Override
	public void paintComponent(Graphics g){
		for (Color color : explosionColors){
			g.setColor(color);
			g.fillOval(MapPanel.getXOffset() + curCycle.getXPos()*increment -((int)(explosionCount/2))+(int)(explosionCount*Math.random()), 
					MapPanel.getYOffset() + curCycle.getYPos()*increment -((int)(explosionCount/2))+(int)(explosionCount*Math.random()), 
					(int)(explosionCount*Math.random()), 
					(int)(explosionCount*Math.random()));
		}
	}
}
