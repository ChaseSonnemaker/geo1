
package org.kickstats.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * An environment for working with 3D shapes.
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 7 April 2020
 */
public class Swing3D extends JFrame implements ActionListener {
    
    //Frame constants
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 800;
    private final String FRAME_TITLE = "3D Shaded Prism";
    
    //Menu name constants
    private final String B_COLOR = "Background Color";
    private final String S_COLOR = "Shape Color";
    private final String SIDES = "Number of Sides";
    private final String SPEED = "Rotation Speed";
    private final String S_WIDTH = "Shape Width";
    private final String R_TYPE = "Type of Rotation";
    
    //Menu lists
    private final List<Color> colors = new ArrayList<>();
    
    //Panel
    private final SwingPanel3D panel;
    
    
    public void createMenu(JMenuBar m, String name, List<String> s) {
        JMenu menu = new JMenu(name);
        m.add(menu);
        
        for(String itemName : s) {
            JMenuItem newItem = new JMenuItem(itemName);
            newItem.addActionListener(this);
            newItem.setActionCommand(itemName);
            menu.add(newItem);
        }// for
    }// createMenu
    
            
    public Swing3D() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        Container pane = this.getContentPane();
        this.panel = new SwingPanel3D();
        pane.add(panel);
        this.panel.setBackground(Color.white);
        
        this.setVisible(true);
    }// Swing3D()
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        
    }// actionPerformed(ActionEvent)
    
    
    public static void main(String[] args) {
        Swing3D s3D  = new Swing3D();
    } // main( String [] )
    
    
}// Swing3D
