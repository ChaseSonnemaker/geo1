
package org.kickstats.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * An environment for working with 3D shapes.
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 7 April 2020
 */
public class Swing3D extends JFrame implements ActionListener {
    
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 800;
    private final String FRAME_TITLE = "3D Shapes";
    
    private final SwingPanel3D panel;
    
    
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
