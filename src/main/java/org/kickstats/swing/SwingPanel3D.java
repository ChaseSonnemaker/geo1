
package org.kickstats.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Creates a panel used to animate a rotating shaded 3D shape.
 * 
 * Designed to be used in the Swing3D class, and is the panel that the 
 * window created by Swing3D class uses.
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 10 April 2020
 */
public class SwingPanel3D extends JPanel implements ActionListener {
    
    private final double FULL_CIRCLE = 2 * Math.PI;
    private final double RADIUS = 0.5;
    private final double ROTATION_ANGLE = FULL_CIRCLE / 200;
    private final double AMBIENT_LIGHT = 0.25;
    private final Vector LIGHT_VECTOR = new Vector(1.0, 2.0, 4.0).normalize();
    
    private double currentAngle = 0;
    
    //Menu manipulatable
    private Color color;
    private int shape;
    private int sides;
    private double width;
    private int speed;
    private int rotationSelection;

    
    /**
     * Sets the color of the 3D shape.
     * 
     * @param c The color the 3D shape will be set to.
     */
    public void setColor(Color c) {
        this.color = c;
    }// setColor(Color)
    
    /**
     * Sets the shape-type of the 3D shape.
     * 
     * @param n An integer corresponding to a 3D shape type.
     * 0 corresponds to a prism, 1 corresponds to an antiprism,
     * and 2 corresponds to a pyramid.
     */
    public void setShape(int n) {
        this.shape = n;
    }// setShape(int)
    
    /**
     * Creates a list of Polygon3D objects which come from a transformed
     * 3D shape. 
     * 
     * Uses the instance variable <code>shape</code> defined in this class to 
     * determine the type of 3D shape object to create. Uses the other instance 
     * variables and constants of <code>sides</code>, <code>RADIUS</code>, and
     * <code>width</code> defined in this class as parameters for the 3D object. 
     * The returned Polygon3D object list is ordered such that each polygon 
     * can be converted into a shape and drawn to visualize a 3D shape object.
     * 
     * @param m A matrix that models a 3D transformation or the identity matrix 
     * if no change is required. 
     * @return A list of Polygon3D objects ordered from smallest unit-vector 
     * z-coordinate to largest, all ready to be converted to shapes and drawn 
     * to visualize a 3D shape with class defined parameters.
     */
    public List<Polygon3D> getShapeOutline(Matrix m) {
        List<Polygon3D> shapeList = new ArrayList<>();

        switch(this.shape) {
            case 0:
                PolygonPrism prism = new PolygonPrism(this.sides, this.RADIUS, 
                                                        this.width);
                prism.change(m);
                shapeList = prism.getOrderedShapes();
                break;
            case 1:
                PolygonAntiPrism antiPrism = new PolygonAntiPrism(this.sides, 
                                                    this.RADIUS, this.width);
                antiPrism.change(m);
                shapeList = antiPrism.getOrderedShapes();
                break;
            case 2:
                PolygonPyramid pyramid = new PolygonPyramid(this.sides, 
                                                    this.RADIUS, this.width);
                pyramid.change(m);
                shapeList = pyramid.getOrderedShapes();
                break;       
        }// switch
        return shapeList;
    }// getShapeOutline(Matrix)
    
    
    /**
     * Sets the number of sides that the main face(s) of the 3D shape will have.
     * 
     * @param n The number of sides that the 3D shape's main face(s) will have.
     */
    public void setSides(int n) {
        this.sides = n;
    }// setSides(int)
    
    
    /**
     * Sets the width of the 3D shape.
     * 
     * This is the distance the main faces are from each other (the 
     * perpendicular height of the side faces) or, for pyramids, the distance 
     * from the main face to the capstone (the perpendicular height of the side
     * triangle faces).
     * 
     * @param width The width the 3D shape will be set to have.
     */
    public void setWidth(double width) {
        this.width = width;
    }// setWidth(double)
    
    
    /**
     * Sets the factor that the rotation of the 3D shape is multiplied by.
     * 
     * This allows for faster or slower rotation.
     * 
     * @param n The factor that the rotation speed will be multiplied by.
     */
    public void setSpeed(int n) {
        this.speed = n;
    }// setSpeed(int)
    
    
    /**
     * Sets the axis of rotation of the 3D shape.
     * 
     * @param n A number representing an axis of rotation to apply to the 3D
     * shape. 0 corresponds to x-axis rotation, 1 corresponds to y-axis 
     * rotation, and 2 corresponds to z-axis rotation.
     */
    public void setRotation(int n) {
        this.rotationSelection = n;
    }// setRotation(int)
    
    
    /**
     * Creates a 4x4 matrix modeling a rotation of a specified angle 
     * around a set axis.
     * 
     * Uses the instance variable <code>rotationSelection</code>, which can be 
     * set using the setRotation method, to select an axis of rotation and 
     * create this matrix.
     * 
     * @param angle The angle (radians) of rotation.
     * @return A 4x4 matrix modeling the specified axis of rotation.
     */
    public Matrix getRotation(double angle) {
        Matrix newRotation = new Matrix();
        
        switch(this.rotationSelection){
            case 0:
                newRotation.rotateX(angle);
                break;
            case 1:
                newRotation.rotateY(angle);
                break;
            case 2:
                newRotation.rotateZ(angle);
                break;
        }// switch
        return newRotation;
    }// getRotation(double)
    
    
    /**
     * Creates an instance of this class which starts a timer that controls 
     * animation speed.
     */
    public SwingPanel3D() {
       Timer timer = new Timer(50, this);
       timer.start();
    } // SwingPanel3D()
    
    
    /**
     * Creates, transforms, draws, and shades the 3D shape object. 
     * 
     * The method used to create the images. Documented details of how 
     * this works can be found in the source code.
     * 
     * @param g A Graphics object. 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        //Create AffineTransform for initial scaling
        int w = this.getWidth();
        int h = this.getHeight();
        
        AffineTransform transform = new AffineTransform();
        AffineTransform scale = new AffineTransform();
        scale.setToScale(w / 2, h / 2);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(1, 1);
        transform.concatenate(scale);
        transform.concatenate(translate);
        

        //Create rotation matrix
        Matrix rotation = this.getRotation(this.currentAngle);

        
        //Create prism object and rotate it
        List<Polygon3D> shapeList = this.getShapeOutline(rotation);


        //Create shapes and shade
        for(Polygon3D p : shapeList) {
            
            //Determine shading
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            
            Vector normalP = p.getNormal();
            
            double focusedColor = this.LIGHT_VECTOR.dot(normalP);
            double colorChange = Math.max(this.AMBIENT_LIGHT, focusedColor);
            
            red = (int) ( red * colorChange);
            green = (int) (green * colorChange);
            blue = (int) (blue * colorChange);
            
            g2D.setColor(new Color(red, green, blue));
            
            //Create and fill shape
            Shape s = p.getShape();
            s = transform.createTransformedShape(s);
            g2D.fill(s);
        }// for
    }//paintComponent(Graphics)    
    
    
    /**
     * Uses a timer created during the creation of this class instance to 
     * change the angle of the 3D shape object and redraw the image.
     * 
     * This creates an animation effect and allows for changes to be made to 
     * the attributes of the 3D Shape.
     * 
     * @param event An event trigger caused by the timer.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        double angleChange = this.ROTATION_ANGLE * this.speed;
        
        if(this.currentAngle < (this.FULL_CIRCLE)) {
            this.currentAngle = this.currentAngle + angleChange;
        }// if
        else {
            this.currentAngle = this.currentAngle + angleChange 
                                - (this.FULL_CIRCLE);
        }// else
        
        this.repaint();
    }// actionPerformed(ActionEvent)
    
    
}// SwingPanel3D
