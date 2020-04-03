
package org.kickstats.geo1;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 * Creates a loading screen with the SCP symbol on it.
 * 
 * @author Chase Sonnemaker using code from Leon Tabak.
 */
public class LoadingScreen extends JFrame implements ActionListener {
    
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 800;
    private final String FRAME_TITLE = "Loading...";
    private final String CONTAINED = "Contained";
    private final String BREAKOUT = "Breakout";
    private final String DRAGONS = "Here there be dragons";
    private final String SCP = "SCP";
            
    private final List<String> themes = new ArrayList<>();
    
    
    public LoadingScreen() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = this.getContentPane();
        this.panel = new Contained();
    }// LoadingScreen()
    
}// LoadingScreen()
