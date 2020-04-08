
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
    
    final double TRIANGLE_LENGTH = 0.8;
    final double ROTATION = (2 * Math.PI) / 60;
    
    double angle = 0;
    
    
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
        Matrix rotateX = new Matrix();
        rotateX.rotateX(angle);
        Matrix rotateY = new Matrix();
        rotateY.rotateY(angle);
        Matrix rotateZ = new Matrix();
        rotateZ.rotateZ(angle);
        
        Matrix rotate = rotateX.multiply(rotateY).multiply(rotateZ);
        Matrix position = scaling.multiply(translation).multiply(rotate);
        
        Triangle3D triangle = new Triangle3D(TRIANGLE_LENGTH);
        triangle.change(position);
        Shape newTriangle = triangle.getShape();
        
        g2D.fill(newTriangle);
        
        g2D.setColor(Color.black);
        g2D.draw(newTriangle);
        
    }//paintComponent(Graphics)    
        
    @Override
    public void actionPerformed(ActionEvent event) {
        if(this.angle < (2 * Math.PI)) {
            this.angle = this.angle + this.ROTATION;
        }// if
        else {
            this.angle = this.angle + this.ROTATION - (2 * Math.PI);
        }// else
        
        this.repaint();
    }// actionPerformed(ActionEvent)
    
    
}// SwingPanel3D
