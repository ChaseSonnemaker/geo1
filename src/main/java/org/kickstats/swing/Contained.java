package org.kickstats.swing;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Support class for LoadingScreen.java.
 * 
 * @author Chase Sonnemaker with code from Leon Tabak.
 */
public class Contained extends JPanel {
    
    //Rectangles
    double h = 0.2;
    double w = 0.2;
    double x1 = -0.2;
    double y1 = -0.2;
    double x2 = 0;
    double y2 = -0.2;
    
    private Color color = Color.red;
            
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();
        
        //Transformations
        AffineTransform transform = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        scaling.setToScale(w / 2, h / 2);
        AffineTransform translation = new AffineTransform();
        translation.setToTranslation(1.0, 1.0);
        transform.concatenate(scaling);
        transform.concatenate(translation);
        
        g2D.setColor(this.color);
        Rectangle2D.Double rec1 = new Rectangle2D.Double(x1, y1, h, w);
        g2D.fill(rec1);
        
    }// paintComponent
}// Contained()
