
package org.kickstats.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A panel of 3D shapes.
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 7 April 2020
 */
public class SwingPanel3D extends JPanel implements ActionListener {
    
    
    public SwingPanel3D() {
       Timer timer = new Timer(50, this);
       timer.start();
    } // SwingPanel3D()
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        g2D.setColor(Color.red);
        
        int w = this.getWidth();
        int h = this.getHeight();
        
        Matrix scaling = new Matrix();
        scaling.scale(w / 2, h / 2, 1);
        Matrix translation = new Matrix();
        translation.translate(1, 1, 0);
        
        Matrix start = scaling.multiply(translation);
        
        Triangle3D triangle = new Triangle3D(0.5);
        triangle.change(start);
        Shape newTriangle = triangle.getShape();
        
        g2D.fill(newTriangle);
        
        g2D.setColor(Color.black);
        g2D.draw(newTriangle);
        
    }//paintComponent(Graphics)    
        
    @Override
    public void actionPerformed(ActionEvent event) {
        this.repaint();
    }// actionPerformed(ActionEvent)
    
    
}// SwingPanel3D
