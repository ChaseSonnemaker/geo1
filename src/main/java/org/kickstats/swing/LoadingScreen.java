
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
 * Creates a loading screen with the SCP symbol on it.
 * 
 * @author Chase Sonnemaker using code from Leon Tabak.
 */
public class LoadingScreen extends JFrame implements ActionListener{
    
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 800;
    private final String FRAME_TITLE = "Loading...";
    private final String CONTAINED = "Contained";
    private final String BREAKOUT = "Breakout";
    private final String DRAGONS = "Here there be dragons";
    private final String SCP = "SCP";
            
    private final List<String> themes = new ArrayList<>();
    private final Symbol panel;
    
    
    public LoadingScreen() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = this.getContentPane();
        this.panel = new Symbol();
        pane.add(panel);
        this.panel.setBackground(Color.BLACK);
        
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu themeMenu = new JMenu("Themes");
        menuBar.add(themeMenu);
        
        JMenuItem item1 = new JMenuItem(CONTAINED);
        item1.addActionListener(this);
        item1.setActionCommand(CONTAINED);
        themeMenu.add(item1);
        
        JMenuItem item2 = new JMenuItem(BREAKOUT);
        item2.addActionListener(this);
        item2.setActionCommand(BREAKOUT);
        themeMenu.add(item2);
        
        JMenuItem item3 = new JMenuItem(DRAGONS);
        item3.addActionListener(this);
        item3.setActionCommand(DRAGONS);
        themeMenu.add(item3);
        
        JMenuItem item4 = new JMenuItem(SCP);
        item4.addActionListener(this);
        item4.setActionCommand(SCP);
        themeMenu.add(item4);
        
        this.setVisible(true);
    }// LoadingScreen()
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String actionCommand = event.getActionCommand();
            
    } // actionPerformed( ActionEvent ) 
    
    public static void main(String[] args) {
        LoadingScreen ls = new LoadingScreen();
    } // main( String [] )
    
}// LoadingScreen()
