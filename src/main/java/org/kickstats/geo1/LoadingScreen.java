
package org.kickstats.geo1;

import java.awt.Color;
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
}// LoadingScreen()
