
package org.kickstats.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A panel of 3D shapes.
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 7 April 2020
 */
public class SwingPanel3D extends JPanel implements ActionListener {
    
    final double TRIANGLE_LENGTH = 0.5;
    final double ROTATION = (2 * Math.PI) / 60;
    
    double angle = Math.PI / 3;
    
    
    public SwingPanel3D() {
       Timer timer = new Timer(50, this);
       timer.start();
    } // SwingPanel3D()
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        g2D.setColor(Color.black);
                
        int w = this.getWidth();
        int h = this.getHeight();
        
        Matrix scale = new Matrix();
        scale.scale(w/2, h/2, 1);
        Matrix translate = new Matrix();
        translate.translate(1, 1, 1);
        Matrix rotation = new Matrix();
        rotation.rotateY(angle);
        
//        Matrix rotation2 = new Matrix();
//        rotation2.rotateY(angle);
        
        Matrix originalTransform = scale.multiply(translate);
        Matrix transform = originalTransform.multiply(rotation);
//        Matrix transform2 = originalTransform.multiply(rotation2);
        
//        Polygon3D thing = new Polygon3D(6, 0.8, 0);
//        thing.change(transform);
//        Shape newThing = thing.getShape();
//        System.out.println("OG");
//        for(Vector v : thing.getPoints()) {
//            System.out.println(v);
//        }
//        g2D.draw(newThing);

        PolygonPrism prism = new PolygonPrism(10, 0.8, 0.5);
        prism.change(transform);
//        Polygon3D face1 = prism.getFace1();
////        face1.change(transform);
//        Shape poly1 = face1.getShape();
//        System.out.println("test");
//        for(Vector v : face1.getPoints()) {
//            System.out.println(v);
//        }
//        g2D.draw(poly1);
//        
//        
//        Polygon3D face2 = prism.getFace2();
////        face2.change(transform);
//        Shape poly2 = face2.getShape();
//        System.out.println("test2");
//        for(Vector v : face2.getPoints()) {
//            System.out.println(v);
//        }
//        g2D.draw(poly2);
//        
//        
//        List<Polygon3D> recs = prism.getRectangles();
//        for(Polygon3D p : recs) {
//            Shape newP = p.getShape();
//            g2D.draw(newP);
//        }
//        Vector lightSource = new Vector(0.5, 0.5, 0.5);
//        lightSource = transform2.multiply(lightSource);
//        
//        double origR = 102.0 / 255.0;
//        double origG = 0.0 / 255.0;
//        double origB = 153.0 / 255.0;
                

        List<Polygon3D> toDraw = prism.getOrderedShapes();
        for(Polygon3D p : toDraw) {
            Shape s = p.getShape();
            
//            float newR = (float) p.getNewColorValue(origR, lightSource);
//            float newG = (float) p.getNewColorValue(origG, lightSource);
//            float newB = (float) p.getNewColorValue(origB, lightSource);
            
            g2D.setColor(Color.red);
            g2D.fill(s);
            g2D.setColor(Color.black);
            g2D.draw(s);
        }// for

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
