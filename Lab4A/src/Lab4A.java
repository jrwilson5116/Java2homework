/**Joey Wilson
 * Lab4A.java
 * DUE: 9/19/2017
 *
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4A extends JFrame 
implements ActionListener{

    private final JButton btStart = new JButton("Start");
    private final JButton btStop = new JButton("Stop");
    private final JButton btFaster = new JButton("Faster");
    private final JButton btSlower = new JButton("Slower");
    private final JButton btReverse = new JButton("Reverse");

    Timer timer;
    private int speed = 2;
    int theta = 0;
    long fasterItterations = 1;

    public static void main(String[] args) {
        // 
        JFrame frame = new Lab4A();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Joey's Fan");
        frame.setSize(750,500);
        frame.setVisible(true);
    }

    public Lab4A() {
        JPanel buttonPanel = new JPanel(); 
        JPanel fanPanel = new Fan();

        buttonPanel.setLayout(new GridLayout(1,5));
        buttonPanel.add(btStart);
        buttonPanel.add(btStop);
        buttonPanel.add(btFaster);
        buttonPanel.add(btSlower);
        buttonPanel.add(btReverse);

        btStart.addActionListener(this);
        btStop.addActionListener(this);
        btFaster.addActionListener(this);
        btSlower.addActionListener(this);
        btReverse.addActionListener(this);

        getContentPane().add(buttonPanel,BorderLayout.SOUTH);
        getContentPane().add(fanPanel, BorderLayout.CENTER);
    }

    class Fan extends JPanel{

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

        int x = xCenter - radius;
        int y = yCenter - radius;
        int h = (int)(getHeight() * 0.8);
        int w = (int)(getWidth() * 0.8);

        setBackground(Color.YELLOW);
        g.setColor(Color.BLUE);

        g.fillArc(x, y, 2 * radius, 2 * radius, theta, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, theta+72, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, theta+144, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, theta+216, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, theta+288, 30);

        repaint();

        ActionListener rotateFan = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //System.out.println("test");
                if (fasterItterations%2!=0)
                    theta+=speed;
                fasterItterations++;
            }        	
        };
        timer = new Timer(16,rotateFan);
    }

}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        int storeSpeed = 2;
        
        if (e.getSource()==btStart) {
            if (speed == 0)
                speed = storeSpeed;
            timer.start();
            //fasterItterations++;
        }else if(e.getSource()==btStop) {
                timer.stop();
                storeSpeed = speed;
                speed = 0;
        }else if(e.getSource()==btFaster) {
                speed *= 2;
        }else if(e.getSource()==btSlower) {
                speed /= 2;
        }else if(e.getSource()==btReverse) {
                speed*=-1;
        }
    }

}
