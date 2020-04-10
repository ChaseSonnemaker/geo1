
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
    
    private final double RADIUS = 0.5;
    private final double ROTATION_ANGLE = (2 * Math.PI) / 200;
    private double currentAngle = 0;
    
    //Menu manipulatable
    private Color color;
    private int sides;
    private double width;
    private int speed;

    
    public void setColor(Color c) {
        this.color = c;
    }// setColor(Color)
    
    
    public void setSides(int n) {
        this.sides = n;
    }// setSides(int)
    
    
    public void setWidth(double width) {
        this.width = width;
    }// setWidth(double)
    
    
    public void setSpeed(int n) {
        this.speed = n;
    }// setSpeed(int)
    
    
    public SwingPanel3D() {
       Timer timer = new Timer(50, this);
       timer.start();
    } // SwingPanel3D()
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        //Create AffineTransform for initial 
        int w = this.getWidth();
        int h = this.getHeight();
        
        AffineTransform transform = new AffineTransform();
        AffineTransform scale = new AffineTransform();
        scale.setToScale(w / 2, h / 2);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(1, 1);
        transform.concatenate(scale);
        transform.concatenate(translate);
        

        Matrix rotationX = new Matrix();
        Matrix rotationY = new Matrix();
        Matrix rotationZ = new Matrix();
        
        rotationX.rotateX(angle);
        rotationY.rotateY(angle);
        rotationZ.rotateZ(angle);
        
        Matrix rotate = rotationY.multiply(rotationX);

        PolygonPrism prism = new PolygonPrism(54, 0.8, 0.5);
        prism.change(rotate);

        Color color = Color.blue;
        double ambientColor = 0.2;
        Vector lightV = new Vector(1.0, 2.0, 4.0);
        lightV = lightV.normalize();

        List<Polygon3D> toDraw = prism.getOrderedShapes();
        for(Polygon3D p : toDraw) {
            Shape s = p.getShape();
            s = transform.createTransformedShape(s);
            
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            
            Vector normalP = p.getNormal();
            
            double focusedColor = lightV.dot(normalP);
            double colorChange = Math.max(ambientColor, focusedColor);
            
            red = (int) ( red * colorChange);
            green = (int) (green * colorChange);
            blue = (int) (blue * colorChange);
            
            g2D.setColor(new Color(red, green, blue));
            
            g2D.fill(s);
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
