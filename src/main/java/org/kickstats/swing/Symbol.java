
package org.kickstats.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Contains methods used to draw the symbol and a loading screen sign.
 * 
 * Also allows for rotation and movement of these drawings.
 * 
 * @author Chase Sonnemaker using code from Leon Tabak
 * @version 5 April 2020
 */
public class Symbol extends JPanel implements ActionListener {
    
    private final double ARROW_ANGLE = (2 * Math.PI) / 3;
    
    //Speed
    private int speed = 1;
    
    //Main Circle
    double centerX = 0;
    double centerY = -0.4;
    double radius = 0.4;
    
    //Arrow Lines
    double origX = 0;
    double origY = -0.875;
    double origX2 = 0;
    double origY2 = -0.6;
    
    //Arrow Points
    double arpX = 0;
    double arpY = -0.45;
    double arX = -0.075;
    double arY = -0.6;
    double arX2 = 0.075;
    double arY2 = -0.6;
    
    //Outer Circle Hats
    double outerX1 = 0.12;
    double outerY1 = -0.9;
    double outerX2 = 0.1;
    double outerY2 = -0.98;
    double outerX3 = -0.1;
    double outerY3 = -0.98;
    double outerX4 = -0.12;
    double outerY4 = -0.9;
    
    //Outer Circle Arcs
    double centerX2 = 0;
    double centerY2 = -0.4;
    double radius2 = 0.514;
    double startAngle = 197;
    double endAngle = -93.5;
    
    //Loading Lines
    double loadStartX = 0;
    double loadStartY = 0.425;
    double loadEndX = 0;
    double loadEndY = 0.475;
    double loadCenterX = 0;
    double loadCenterY = 0.525;
    int loadLines = 8;
    
    //Rotation
    double rotateSymbol = 360;
    double rotateLoad = 60;
    double moveSymbol = (2 * Math.PI) / this.rotateSymbol;
    double moveLoad = (2 * Math.PI) / this.rotateLoad;
    double angleSymbol = 0;
    double angleLoad = 0;
    
    //Color
    private Color color = Color.white;
    
    //Move
    double xMove1 = 0;
    double yMove1 = 0;
    Random rdm1 = new Random();
    Random rdm2 = new Random();
 
    
    /**
     * Creates and instance of the Symbol class which sets a timer moving to 
     * induce animation.
     */
    public Symbol() {
       Timer timer = new Timer(50, this);
       timer.start();
    } // SwingPanel()
    
    
    /**
     * Sets the speed instance variable to a new integer value.
     * 
     * @param i A factor by which to increase the change in movement and 
     * angle of shapes.
     */
    public void setSpeed(int i) {
        this.speed = i;
    }// setSpeed
    
    
    /**
     * Creates an AffineTransform object designed to scale a new shape to fit 
     * the window, and rotate the shape to a starting position.
     * 
     * @param initialAngle The starting angle (radians) of the shape.
     * @return An AffineTransform object that will scale and rotate a shape.
     */
    public AffineTransform rotateToPlace(double initialAngle) {
        int w = this.getWidth();
        int h = this.getHeight();
        
        AffineTransform transform = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        scaling.setToScale(w / 2, h / 2);
        AffineTransform translation = new AffineTransform();
        translation.setToTranslation(1.0, 1.0);
        AffineTransform rotate1 = new AffineTransform();
        rotate1.setToRotation(initialAngle, centerX, centerY);
        
        transform.concatenate(scaling);
        transform.concatenate(translation);
        transform.concatenate(rotate1);
        
        return transform;
    }// rotateToPlace(double)
    
    
    /**
     * Creates the AffineTransform object designed to move an arrow to, scale
     * an arrow to the window, rotate the arrow to a starting position, and
     * rotate the arrow to a new position based on spin movement.
     * 
     * @param initialAngle The starting angle (radians) of the arrow.
     * @param newAngle The new angle (radians) of the arrow given rotation
     * @return An AffineTransform object which can be used to transform an
     * arrow to the correct spin position.
     */
    public AffineTransform spinArrows(double initialAngle, double newAngle) {

        AffineTransform transform = rotateToPlace(initialAngle);
        
        AffineTransform rotate2 = new AffineTransform();
        rotate2.setToRotation(newAngle, centerX, centerY);
        transform.concatenate(rotate2);
        
        return transform;
    }// spinArrows(double, double)
    
    
    /**
     * Creates a straight line shape object using parameters defined in this
     * class.
     * 
     * @param initialAngle The starting angle (radians) of the line.
     * @param newAngle The angle change (radians) of the line due to a rotation.
     * @return A straight line shape with parameters defined in this class, 
     * scaled to the window, and rotated based on an initial and changed angle.
     */
    public Shape createArrow(double initialAngle, double newAngle) {
        AffineTransform transform = spinArrows(initialAngle, newAngle);
        
        Line2D.Double line = new Line2D.Double(origX, origY, origX2, origY2);
        Shape arrow = transform.createTransformedShape(line);
        
        return arrow;
    }// createArrow(double, double)
    
    
    /**
     * Creates a triangular arrowhead shape using parameters defined in this
     * class.
     * 
     * @param initialAngle The starting angle (radians) of the arrowhead.
     * @param newAngle The angle change (radians) of the arrowhead due to 
     * a rotation.
     * @return A triangular arrowhead shape with parameters defined in this 
     * class, scaled to the window, and rotated based on an initial 
     * and changed angle.
     */
    public Shape createArrowHead(double initialAngle, double newAngle) {
        AffineTransform transform = spinArrows(initialAngle, newAngle);
        
        Path2D.Double arrowhead = new Path2D.Double();
        arrowhead.moveTo(arpX, arpY);
        arrowhead.lineTo(arX, arY);
        arrowhead.lineTo(arX2, arY2);
        Shape arrowFin = transform.createTransformedShape(arrowhead);
        
        return arrowFin;
    }// createArrowHead(double, double)
    
    
    /**
     * Creates an arc using parameters defined in this class. 
     * 
     * The arc is part of the outer circle of the symbol.
     * 
     * @param angle The angle (radians) of the arc.
     * @return An arc shape with class defined parameters, scaled to the 
     * window, and at a defined angle. 
     */
    public Shape createArc(double angle) {
        AffineTransform transform = rotateToPlace(angle);
        
        double d1 = 2 * this.radius2;
        double ulx1 = this.centerX2 - this.radius2;
        double uly1 = this.centerY2 - this.radius2;
        
        Arc2D.Double arc = new Arc2D.Double(ulx1, uly1, d1, d1, startAngle, 
                                            endAngle, Arc2D.OPEN);
        Shape arcFin = transform.createTransformedShape(arc);
        
        return arcFin;
    }// createArc(double)
    
    
    /**
     * Creates a hat shape object using parameters defined in this class.
     * 
     * The hat shape is part of the symbol that connects the outer arcs and 
     * are placed over the arrows.
     * 
     * @param angle The angle (radians) of the hat.
     * @return A hat shape object with class defined parameters, scaled to 
     * the window, and at a specified angle.
     */
    public Shape createHat(double angle) {
        AffineTransform transform = rotateToPlace(angle);
        
        Path2D.Double outerHat = new Path2D.Double();
        outerHat.moveTo(outerX1, outerY1);
        outerHat.lineTo(outerX2, outerY2);
        outerHat.lineTo(outerX3, outerY3);
        outerHat.lineTo(outerX4, outerY4);
        Shape outer = transform.createTransformedShape(outerHat);
        
        return outer;
    }// createHat(angle)
    
    
    /**
     * Paints the symbol and loading shapes onto the window.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
  
        //Color and stroke sizes used
        g2D.setColor(this.color);
        BasicStroke stroke = new BasicStroke(15f);
        g2D.setStroke(stroke);
        
        
        //Drawing the first circle
        AffineTransform transform = rotateToPlace(0);
        double d = 2 * this.radius;
        double ulx = this.centerX - this.radius;
        double uly = this.centerY - this.radius;
        Ellipse2D.Double circle = new Ellipse2D.Double(ulx, uly, d, d);
        Shape circle1 = transform.createTransformedShape(circle);
        g2D.draw(circle1);
        
        
        //Adjusting stroke size
        BasicStroke stroke2 = new BasicStroke(8f);
        g2D.setStroke(stroke2);
        
        
        //Drawing the arrows
        g2D.draw(createArrow(0, angleSymbol));
        g2D.draw(createArrow(ARROW_ANGLE, angleSymbol));
        g2D.draw(createArrow(-ARROW_ANGLE, angleSymbol));
        
        g2D.fill(createArrowHead(0, angleSymbol));
        g2D.fill(createArrowHead(ARROW_ANGLE, angleSymbol));
        g2D.fill(createArrowHead(-ARROW_ANGLE, angleSymbol));
        
        
        //Adjusting stroke size
        BasicStroke stroke3 = new BasicStroke(5f);
        g2D.setStroke(stroke3);
        
        
        //Drawing the outer circle
        g2D.draw(createArc(0));
        g2D.draw(createArc(ARROW_ANGLE));
        g2D.draw(createArc(-ARROW_ANGLE));
        
        g2D.draw(createHat(0));
        g2D.draw(createHat(ARROW_ANGLE));
        g2D.draw(createHat(-ARROW_ANGLE));
        
        
        //Loading sign and movement 
        for(int i = 0; i < loadLines; i++) {
            double newAngle = i * ((2 * Math.PI) / loadLines);
            
            int w = this.getWidth();
            int h = this.getHeight();
            
            AffineTransform transform2 = new AffineTransform();
            AffineTransform scaling2 = new AffineTransform();
            scaling2.setToScale(w / 2, h / 2);
            AffineTransform translation2 = new AffineTransform();
            translation2.setToTranslation(1.0, 1.0);
            AffineTransform move = new AffineTransform();
            move.translate(xMove1, yMove1);
            AffineTransform rotate = new AffineTransform();
            rotate.setToRotation(newAngle + angleLoad, 
                                    loadCenterX, loadCenterY);
            
            transform2.concatenate(scaling2);
            transform2.concatenate(move);
            transform2.concatenate(rotate);
 
            Line2D.Double newLine = new Line2D.Double(loadStartX, loadStartY, 
                                        loadEndX, loadEndY);
            Shape newLineFin = transform2.createTransformedShape(newLine);
            
            g2D.draw(newLineFin);
        }// for
    
    } // paintComponent( Graphics )

    
    /**
     * Creates changes in the position and angle of the shapes to create 
     * animation based on a timer. 
     * 
     * Redraws the picture with new parameters based on a timer.
     * 
     * @param event Some event (such as a timer) by which change will occur.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        //Symbol Rotate
        this.angleSymbol = this.angleSymbol + this.speed * this.moveSymbol;
        if(this.angleSymbol > (2 * Math.PI)) {
            this.angleSymbol = this.angleSymbol / this.rotateSymbol;
        }// if
        
        //Loading Rotate
        this.angleLoad = this.angleLoad + this.speed * this.moveLoad;
        if(this.angleLoad > (2 * Math.PI)) {
            this.angleLoad = this.angleLoad / this.rotateLoad;
        }// if
        
        //Loading random movement
        if(this.xMove1 > 1) {
            this.xMove1 = this.xMove1 + this.speed * 
                (( - 0.05));
        }// if
        else if((this.xMove1 < -1)) {
            this.xMove1 = this.xMove1 + this.speed *
                    ((0.05));
        }// else if
        else {
            this.xMove1 = this.xMove1 + this.speed * 
                (rdm1.nextDouble() * 0.1 - 0.05);
        }// else
        
                
        if(this.yMove1 > 1) {
            this.yMove1 = this.yMove1 + this.speed * 
                (( - 0.05));
        }// if
        else if((this.yMove1 < -1)) {
            this.yMove1 = this.yMove1 + this.speed *
                    ((0.05));
        }// else if
        else {
            this.yMove1 = this.yMove1 + this.speed * 
                (rdm2.nextDouble() * 0.1 - 0.05);
        }// else

        this.repaint();
    } // actionPerformed( ActionEvent )

}// Symbol
