
package org.kickstats.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
    private final String S_SIDES = "Number of Sides";
    private final String R_SPEED = "Rotation Speed";
    private final String S_WIDTH = "Shape Width";
    private final String R_TYPE = "Type of Rotation";
    
    //Menu HashMaps
    private final HashMap<String, Color> colors = new HashMap<>();
    private final HashMap<String, Integer> sideNums = new HashMap<>();
    private final HashMap<String, Integer> speeds = new HashMap<>();
    private final HashMap<String, Double> widths = new HashMap<>();
    private final HashMap<String, Integer> types = new HashMap<>();
    private final int items = 9;
    
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
        
        //Initial setup
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        Container pane = this.getContentPane();
        this.panel = new SwingPanel3D();
        pane.add(panel);
        
        
        //Color HashMap creation
        this.colors.put("Red", new Color(255, 51, 51));
        this.colors.put("Blue", new Color(51, 153, 255));
        this.colors.put("Green", new Color(0, 204, 0));
        this.colors.put("Orange", new Color(255, 153, 0));
        this.colors.put("Gold", new Color(255, 204, 51));
        this.colors.put("Purple", new Color(102, 0, 153));
        this.colors.put("Brown", new Color(153, 102, 0));
        this.colors.put("Gray", new Color(153, 153, 153));
        this.colors.put("White", new Color(255, 255, 255));
        
        
        //Rotation type HashMap creation
        this.types.put("x-axis Rotation", 0);
        this.types.put("y-axis Rotation", 1);
        this.types.put("z-axis Rotation", 2);
        
        
        //widths, sideNums, and speeds HashMap creation
        for(int i = 0; i < items; i++) {
            int sides = 3 + i * 3;
            String sidesName = "Sides: " + sides;
            
            int speed = i;
            String speedName = "Speed: " + speed;
            
            double width = 0.1 + i * 0.1;
            String widthName = "Width: " + width;
            
            this.sideNums.put(sidesName, sides);
            this.speeds.put(speedName, speed);
            this.widths.put(widthName, width);            
        }// for
        
        
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
