
package org.kickstats.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Creates a loading screen with the SCP symbol and a moving loading screen 
 * symbol on it.
 * 
 * An experiment designed to work on creating more precise and defined shapes
 * as well as work on random movement, boundaries, and refactoring. 
 * 
 * @author Chase Sonnemaker using code from Leon Tabak.
 * @version 7 April 2020
 */
public class LoadingScreen extends JFrame implements ActionListener{
    
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 800;
    private final String FRAME_TITLE = "Loading...";
    private final int SPEEDS = 6;
    private final String SPEED = "Speed";

    private final Symbol panel;
    
    
    /**
     * Creates the loading screen which holds the animations of the symbols and
     * contains a menu for changing the speed of the symbol.
     */
    public LoadingScreen() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = this.getContentPane();
        this.panel = new Symbol();
        pane.add(panel);
        this.panel.setBackground(Color.BLACK);
        
        //Speed Menu
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu speedMenu = new JMenu(SPEED);
        menuBar.add(speedMenu);
        
        for(int i = 0; i < SPEEDS; i++) {
            String label = SPEED + " " + i;
            JMenuItem item = new JMenuItem(label);
            item.addActionListener(this);
            item.setActionCommand(label);
            speedMenu.add(item);
        }// for
        
        this.setVisible(true);
    }// LoadingScreen()
    
    /**
     * Changes the speed of the animation based on menu interaction.
     * 
     * @param event Some event (menu click) 
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
        
        if (actionCommand.indexOf(SPEED) >= 0) {
            int i = SPEED.length();
            String suffix = actionCommand.substring(i).trim();
            int index = Integer.parseInt(suffix);
            this.panel.setSpeed(index);
        } // if
            
    } // actionPerformed( ActionEvent ) 
    
    /**
     * Runs the loading screen animation.
     */
    public static void main(String[] args) {
        LoadingScreen ls = new LoadingScreen();
    } // main( String [] )
    
}// LoadingScreen()
