/**Joey Wilson
 * Lab2B
 * Due 9/5/2017
 * 
 */
package lab2b;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;

public class Lab2B extends JFrame implements ActionListener{
	
	JPanel buttonPanel = new JPanel();
    JPanel artworkPanel = new JPanel();
    APanel aPanel = new APanel();
    BPanel bPanel = new BPanel();
    JButton jbtA = new JButton("Show A");
    JButton jbtB = new JButton("Show B");
    
    public Lab2B(){
        
        buttonPanel.add(jbtA,BorderLayout.NORTH);
        buttonPanel.add(jbtB,BorderLayout.NORTH);
        getContentPane().add(buttonPanel,BorderLayout.NORTH);
        getContentPane().add(artworkPanel,BorderLayout.CENTER);
        jbtA.addActionListener(this);
        jbtB.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
    	//clear out previous image
    	getContentPane().remove(artworkPanel);
    	
        if(e.getSource()==jbtA){
        	 artworkPanel = aPanel;
        }else if (e.getSource()==jbtB){
        	artworkPanel = bPanel;
        }
        getContentPane().add(artworkPanel);
        getContentPane().repaint();
        getContentPane().validate();
    }

    public static void main(String[] args) {
        // set up frame
        JFrame frame = new Lab2B();
        frame.setTitle("Joey Wilson's Art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
    }
    
}

class APanel extends JPanel{
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		setBackground(Color.BLACK);
		
		//generate 1000 stars
		for (int i=0;i<1000;i++) {
			
			int x = (int) (Math.random()*1500);
			int y = (int) (Math.random()*1500);
			g.setColor(Color.WHITE);
			g.fillOval(x,y , 2, 2);
		}
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		//sun
		g.setColor(Color.RED);
		g.fillOval(25, 25, 200, 200);
		//mercury 
		g.setColor(Color.YELLOW);
		g.fillOval(300, 200, 10, 10);
		//venus 
		g.setColor(Color.GREEN);
		g.fillOval(400, 250, 10, 10);
		//earth
		g.setColor(Color.BLUE);
		g.fillOval(500, 300, 20, 20);
		//mars
		g.setColor(Color.RED);
		g.fillOval(600, 350, 15, 15);
		//jupiter
		g.setColor(Color.ORANGE);
		g.fillOval(700, 400, 30, 30);
		//saturn
		g.setColor(Color.BLUE);
		g.fillOval(800, 450, 25, 25);
		//uranus
		g.setColor(Color.CYAN);
		g.fillOval(900, 500, 20, 20);
		//neptune
		g.setColor(Color.MAGENTA);
		g.fillOval(1000, 550, 20, 20);
		//pluto still counts
		g.setColor(Color.GRAY);
		g.fillOval(1100, 600, 10, 10);
		
		//UFO		
		g.setColor(Color.GRAY);
		g.fillOval(1000, 50, 100, 25);
		g.setColor(Color.CYAN);
		g.fillOval(1025, 40, 50, 20);
		
	}
}    

class BPanel extends JPanel {
	
	
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i=0;i<10;i++) {
			g.setColor(Color.MAGENTA);
			g.drawLine(0, i*100, 1300, 700);
			g.setColor(Color.BLUE);
			g.drawLine(1400,i*100,0,700);
		}
		//playing black, white and gray against the colors
    	g.setColor(Color.RED);
    	g.fillRect(550, 100, 100, 200);
    	g.setColor(Color.GREEN);
    	g.fillRect(750, 25, 100, 400);
    	g.setColor(Color.YELLOW);
    	g.fillRect(0, 350, 1500, 10);
    	g.setColor(Color.GRAY);
    	g.fillOval(450, 100, 500, 550);
    	g.setColor(Color.BLACK);
    	g2d.rotate(270);
    	g.fillOval(650, 350, 200, 100);
    	g.setColor(Color.WHITE);
    	g.fillOval(450, 550, 200, 100);
    }	

	
}

