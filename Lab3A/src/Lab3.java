/**Joey Wilson
 * Lab 3
 * 9/14/2017
 */
 

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.*;

public class Lab3 extends JFrame implements ActionListener{
	private JTextField jtfName = new JTextField(20);
	private JTextField jtfStreet = new JTextField(20);
	private JTextField jtfCity = new JTextField(20);
        
	String[] states = { " ", "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", 
                        "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", 
                        "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", 
                        "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY",
                        "OH", "OK", "OR", "PA", "RI", "SC", "SD", 
			"TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY" };
        
	private JComboBox jcbState = new JComboBox(states);
	private JTextField jtfZip = new JTextField(5);
        
	private JRadioButton jrbFootball = new JRadioButton("Football");
	private JRadioButton jrbBasketball = new JRadioButton("Basketball");
	private JRadioButton jrbBaseball = new JRadioButton("Baseball"); 
        
	private JTextField jtfOther = new JTextField(20);
	private JRadioButton jrbOther = new JRadioButton("Other: ");
	private final JButton btnSubmit = new JButton("Submit");
       
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnAction = new JMenu("Action");
	private final JMenu mnHelp = new JMenu("Help");
        
	private final JMenuItem mntmSubmit = new JMenuItem("Submit");
	private final JMenuItem mntmClear = new JMenuItem("Clear");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmInfo = new JMenuItem("Info");
        private final JMenuItem mnOpen = new JMenuItem("Open");
        
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel otherPanel = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
        
        public char color = 'z';
        
        private Graphics g;
 
	public static void main(String args[]) {
		Lab3 frame = new Lab3();
		frame.pack();
		frame.setTitle("Joey's LAB3: PRIVACY INVADER "
                        + "WITH PRETTY PICTURES");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public Lab3() {
            getContentPane().setLayout(new BorderLayout(0, 0));
            
            getContentPane().add(panel_3, BorderLayout.WEST);
            panel_3.setLayout(new BorderLayout(0, 0));
            JPanel p1 = new JPanel();
            panel_3.add(p1, BorderLayout.NORTH);
            p1.setBorder(new TitledBorder("Enter Your Personal "
                    + "Information:"));
            p1.setVisible(true);
            p1.setLayout(new BorderLayout(0, 0));
            p1.add(panel_2, BorderLayout.CENTER);
            panel_2.setLayout(new BorderLayout(0, 0));
            panel_2.add(jtfStreet);
            panel_2.add(jtfCity, BorderLayout.SOUTH);
            panel_2.add(jtfName, BorderLayout.NORTH);

            p1.add(panel_1, BorderLayout.WEST);
            panel_1.setLayout(new BorderLayout(0, 0));
            JLabel lblCity = new JLabel("City:  ");
            lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
            panel_1.add(lblCity, BorderLayout.SOUTH);
            JLabel lblStreet = new JLabel("   Street Address:  ");
            panel_1.add(lblStreet, BorderLayout.CENTER);
            JLabel lblName = new JLabel("Name:  ");
            lblName.setHorizontalAlignment(SwingConstants.RIGHT);
            panel_1.add(lblName, BorderLayout.NORTH);

            p1.add(panel, BorderLayout.SOUTH);
            panel.setLayout(new GridLayout(0, 4, 0, 0));
            JLabel lblState = new JLabel("State:  ");
            lblState.setHorizontalAlignment(SwingConstants.RIGHT);
            panel.add(lblState);
            panel.add(jcbState);
            jcbState.addActionListener(this);
            JLabel lblZipCode = new JLabel("Zip Code:  ");
            lblZipCode.setHorizontalAlignment(SwingConstants.RIGHT);
            panel.add(lblZipCode);
            jtfZip.setHorizontalAlignment(SwingConstants.TRAILING);
            panel.add(jtfZip);
            jtfZip.addActionListener(this);

            jtfName.addActionListener(this);
            jtfCity.addActionListener(this);
            jtfStreet.addActionListener(this);

            JPanel p2 = new JPanel();
            panel_3.add(p2, BorderLayout.CENTER);
            p2.setLayout(new GridLayout(0, 2));
            p2.setBorder(new TitledBorder("Choose Your Favorite "
                    + "Spectator Sport:"));
            p2.add(jrbBaseball);
            p2.add(jrbFootball);
            p2.add(jrbBasketball);

            p2.add(otherPanel);
            otherPanel.setLayout(new BorderLayout(0, 0));
            otherPanel.add(jrbOther, BorderLayout.WEST);
            otherPanel.add(jtfOther);
            jrbOther.addActionListener(this);
            p2.setVisible(true);
            jtfOther.setEnabled(false);


            setJMenuBar(menuBar);
            menuBar.add(mnAction);   
            mnAction.add(mntmSubmit);
            mnAction.add(mntmClear);
            mnAction.add(mntmExit);
            menuBar.add(mnHelp);
            mnHelp.add(mntmInfo);
            mnAction.add(mnOpen);
            
            mnAction.setMnemonic('a');
            menuBar.add(mnAction);
            mntmSubmit.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_S, InputEvent.CTRL_MASK));
            mnAction.add(mntmSubmit);
            mntmClear.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_C, InputEvent.CTRL_MASK));
            mnAction.add(mntmClear);
            mntmExit.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_E, InputEvent.CTRL_MASK));
            mnAction.add(mntmExit);
            mnHelp.setMnemonic('h');
            menuBar.add(mnHelp);
            mntmInfo.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_I, InputEvent.CTRL_MASK));
            mnHelp.add(mntmInfo);
            mnOpen.setMnemonic('o');
            mnOpen.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_O, InputEvent.CTRL_MASK));
            
            panel_3.add(btnSubmit, BorderLayout.SOUTH);
           
            btnSubmit.addActionListener(this);
            mntmClear.addActionListener(this);
            mntmExit.addActionListener(this);
            mntmInfo.addActionListener(this);
            
        
            addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                        g = getGraphics();
                        g.setColor(Color.BLACK);
                        
                        if(color == 'y')
                            g.setColor(Color.yellow);
                        else if(color =='b')    
                            g.setColor(Color.blue);
                        else if(color == 'r')
                            g.setColor(Color.red);
                        else if(color =='g')
                            g.setColor(Color.green);
                        
                        
                        if (e.getX()>635)
                            g.fillOval(e.getX()-35, e.getY()-35, 70, 70);
                    }
                });
             
            class ChangeButton extends JButton{
                public ChangeButton(){
                    this.setText("Change Color");
                    addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent e){
                        
                          color = e.getKeyChar();
                        }
                    });
                           
                }
         
            }
            
            ChangeButton colorButton = new ChangeButton();
 
            panel_4.setPreferredSize(new Dimension(500,200));
            panel_4.setLayout(new BorderLayout(0,0));
            panel_4.add(colorButton, BorderLayout.SOUTH);
            
            getContentPane().add(panel_4,BorderLayout.EAST);
	}
	

	public void actionPerformed(ActionEvent e) {
		
                if (jrbOther.isSelected())
                    jtfOther.setEnabled(true);
                
		if (e.getSource()==btnSubmit || e.getSource()== mntmSubmit) {
                   System.out.println(jtfName.getText());
                   System.out.println(jtfStreet.getText());
                   System.out.println(jtfCity.getText());
                   System.out.println(jtfZip.getText());
                   System.out.println(jcbState.getSelectedItem());
                   
                   if(jrbFootball.isSelected())
                       System.out.println("Football");
                   if(jrbBaseball.isSelected())
                       System.out.println("Baseball");
                   if(jrbBasketball.isSelected())
                       System.out.println("Basketball");
                   if(jrbOther.isSelected())
                       System.out.println(jtfOther.getText());
                   
                   
                } else if (e.getSource()==mntmClear){
                    jtfName.setText(""); 
                    jtfStreet.setText("");
                    jtfCity.setText("");
                    jtfZip.setText("");
                    jtfOther.setText("");
                    jcbState.setSelectedItem(null);
                    jrbFootball.setSelected(false);
                    jrbBaseball.setSelected(false);
                    jrbOther.setSelected(false);
                    jrbBasketball.setSelected(false);
                    
                } else if (e.getSource()==mntmInfo){
                    JOptionPane.showMessageDialog(null,
                            "Program written by: \n"
                                    + "Joey Wilson\n"
                                    + "JAVA 2 \n"
                                    + "PROF. Richard Soden\n"
                                    + "Lab 3" );
                } else if (e.getSource()==mntmExit) {
                    System.exit(0);
                } 
	}
 
}

/**OUTPUT
 *  asdf
    jkl;
    fdaa
    1337
    AK
    Football
    Baseball
    Basketball
    hackathon
 */
