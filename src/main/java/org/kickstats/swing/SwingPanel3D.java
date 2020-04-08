
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
        translate.translate(1, 1, 0);
        Matrix rotation = new Matrix();
        rotation.rotateY(angle);
        
        Matrix transform = scale.multiply(translate).multiply(rotation);
        
        Polygon3D thing = new Polygon3D(6, 0.8, 0);
        thing.change(transform);
        Shape newThing = thing.getShape();
        System.out.println("OG");
        for(Vector v : thing.getPoints()) {
            System.out.println(v);
        }
        g2D.draw(newThing);

        PolygonPrism prism = new PolygonPrism(6, 0.8, 0.5);
        Polygon3D face1 = prism.getFace1();
        face1.change(transform);
        Shape poly1 = face1.getShape();
        System.out.println("test");
        for(Vector v : face1.getPoints()) {
            System.out.println(v);
        }
        g2D.draw(poly1);
        
//        prism.change(transform);
        
//        System.out.println("new");
//        Polygon3D primary1 = prism.getPrimary1();
//        primary1.change(transform);
//        Shape p1 = primary1.getShape();
//        g2D.draw(p1);
//        for(Vector v : primary1.getPoints()) {
//            System.out.println(v);
//        }
//         
//        System.out.println("new2");
//        Polygon3D primary2 = prism.getPrimary2();
//        primary2.change(transform);
//        Shape p2 = primary2.getShape();
//        g2D.draw(p2);
//        for(Vector v : primary2.getPoints()) {
//            System.out.println(v);
//        }
//         
//        List<Vector> s1 = primary1.getPoints();
//        List<Vector> s2 = primary2.getPoints();
//        
//        for(int i = 0; i < s1.size() - 1; i++){
//            Vector p00 = s1.get(i);
//            Vector p10 = s2.get(i);
//            Vector p11 = s1.get(i + 1);
//            Vector p01 = s2.get(i + 1);
//            
//            Polygon3D rec = new Polygon3D(p00, p10, p01, p11);
//            
//            for(Vector v : rec.getPoints()) {
//                System.out.println(i + "1");
//                System.out.println(v);
//            }
//            
//            for(Vector v : rec.getPoints()) {
//                System.out.println(i + "2");
//                System.out.println(v);
//            }
//            
//            Shape rectangle = rec.getShape();
//            
//            g2D.fill(rectangle);
//            
//        }// for
//         List<Polygon3D> recs = prism.getRectangles();
//         int i = 0;
//         for(Polygon3D p : recs) {
//             System.out.println(i);
//             i++;
//             p.change(transform);
//             for(Vector v : p.getPoints()) {
//                 System.out.println(v);
//             }
//             Shape rectangle = p.getShape();
//             
//             g2D.draw(rectangle);
//         }// for      
        
        
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
