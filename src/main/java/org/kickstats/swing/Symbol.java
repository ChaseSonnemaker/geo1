
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
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Contains methods used to build the loading symbols.
 * 
 * @author Chase Sonnemaker using code from Leon Tabak
 */
public class Symbol extends JPanel implements ActionListener {
    
    private final double ARROW_ANGLE = (2 * Math.PI) / 3;
    
    double centerX = 0;
    double centerY = -0.4;
    double radius = 0.4;
    
    double origX = 0;
    double origY = -0.875;
    double origX2 = 0;
    double origY2 = -0.6;
    
    double arpX = 0;
    double arpY = -0.45;
    double arX = -0.075;
    double arY = -0.6;
    double arX2 = 0.075;
    double arY2 = -0.6;
    
    double outerX1 = 0.12;
    double outerY1 = -0.9;
    double outerX2 = 0.1;
    double outerY2 = -0.98;
    double outerX3 = -0.1;
    double outerY3 = -0.98;
    double outerX4 = -0.12;
    double outerY4 = -0.9;
    
    double centerX2 = 0;
    double centerY2 = -0.4;
    double radius2 = 0.514;
    double startAngle = 197;
    double endAngle = -93.5;
    
    double loadStartX = 0;
    double loadStartY = 0.425;
    double loadEndX = 0;
    double loadEndY = 0.475;
    double loadCenterX = 0;
    double loadCenterY = 0.525;
    int loadLines = 8;
    
    double rotateSymbol = 360;
    double rotateLoad = 60;
    double moveSymbol = (2 * Math.PI) / this.rotateSymbol;
    double moveLoad = (2 * Math.PI) / this.rotateLoad;
    double angleSymbol = 0;
    double angleLoad = 0;
        
    private Color color = Color.white;
    
    public Symbol() {
       Timer timer = new Timer(50, this);
       timer.start();
    } // SwingPanel()
    
    public Color getColor() {
        return this.color;
    }// getColor()
    
    public void setColor(Color c) {
        this.color = c;
    }// setColor
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform transform = new AffineTransform();
        AffineTransform scaling = new AffineTransform();
        scaling.setToScale(w / 2, h / 2);
        AffineTransform translation = new AffineTransform();
        translation.setToTranslation(1.0, 1.0);
        transform.concatenate(scaling);
        transform.concatenate(translation);
        
        g2D.setColor(this.getColor());
        BasicStroke stroke = new BasicStroke(15f);
        g2D.setStroke(stroke);
        
        AffineTransform transform2 = new AffineTransform();
        AffineTransform rotate2 = new AffineTransform();
        rotate2.setToRotation(ARROW_ANGLE, centerX, centerY);
        transform2.concatenate(scaling);
        transform2.concatenate(translation);
        transform2.concatenate(rotate2);
        
        AffineTransform transform3 = new AffineTransform();
        AffineTransform rotate3 = new AffineTransform();
        rotate3.setToRotation(-ARROW_ANGLE, centerX, centerY);
        transform3.concatenate(scaling);
        transform3.concatenate(translation);
        transform3.concatenate(rotate3);

        
        //First Circle
        double d = 2 * this.radius;
        double ulx = this.centerX - this.radius;
        double uly = this.centerY - this.radius;
        Ellipse2D.Double circle = new Ellipse2D.Double(ulx, uly, d, d);
        Shape circle1 = transform.createTransformedShape(circle);
        g2D.draw(circle1);
        
        BasicStroke stroke2 = new BasicStroke(8f);
        g2D.setStroke(stroke2);
        
        BasicStroke stroke3 = new BasicStroke(5f);
        g2D.setStroke(stroke3);
        
        //OuterHat1
        Path2D.Double outerHat1 = new Path2D.Double();
        outerHat1.moveTo(outerX1, outerY1);
        outerHat1.lineTo(outerX2, outerY2);
        outerHat1.lineTo(outerX3, outerY3);
        outerHat1.lineTo(outerX4, outerY4);
        Shape outer1 = transform.createTransformedShape(outerHat1);
        g2D.draw(outer1);
        
        //OuterHat2
        Path2D.Double outerHat2 = new Path2D.Double();
        outerHat2.moveTo(outerX1, outerY1);
        outerHat2.lineTo(outerX2, outerY2);
        outerHat2.lineTo(outerX3, outerY3);
        outerHat2.lineTo(outerX4, outerY4);
        Shape outer2 = transform2.createTransformedShape(outerHat2);
        g2D.draw(outer2);
        
        //OuterHat3
        Path2D.Double outerHat3 = new Path2D.Double();
        outerHat3.moveTo(outerX1, outerY1);
        outerHat3.lineTo(outerX2, outerY2);
        outerHat3.lineTo(outerX3, outerY3);
        outerHat3.lineTo(outerX4, outerY4);
        Shape outer3 = transform3.createTransformedShape(outerHat3);
        g2D.draw(outer3);
        
        BasicStroke stroke4 = new BasicStroke(5f, BasicStroke.CAP_ROUND, 
                                                        BasicStroke.JOIN_ROUND);
        g2D.setStroke(stroke4);
        
        //Arc1
        double d1 = 2 * this.radius2;
        double ulx1 = this.centerX2 - this.radius2;
        double uly1 = this.centerY2 - this.radius2;
        Arc2D.Double arc1 = new Arc2D.Double(ulx1, uly1, d1, d1, startAngle, 
                                            endAngle, Arc2D.OPEN);
        Shape arcFin1 = transform.createTransformedShape(arc1);
        g2D.draw(arcFin1);
        
        //Arc2
        Arc2D.Double arc2 = new Arc2D.Double(ulx1, uly1, d1, d1, startAngle, 
                                            endAngle, Arc2D.OPEN);
        Shape arcFin2 = transform2.createTransformedShape(arc2);
        g2D.draw(arcFin2);
        
        //Arc3
        Arc2D.Double arc3 = new Arc2D.Double(ulx1, uly1, d1, d1, startAngle, 
                                            endAngle, Arc2D.OPEN);
        Shape arcFin3 = transform3.createTransformedShape(arc3);
        g2D.draw(arcFin3);
        
        //Symbol Rotate
        AffineTransform symbol = new AffineTransform();
        symbol.setToRotation(angleSymbol, centerX, centerY);
        transform.concatenate(symbol);
        transform2.concatenate(symbol);
        transform3.concatenate(symbol);
        
        //Arrow 1
        Line2D.Double line1 = new Line2D.Double(origX, origY, origX2, origY2);
        Shape arrow1 = transform.createTransformedShape(line1);
        Path2D.Double arrowhead1 = new Path2D.Double();
        arrowhead1.moveTo(arpX, arpY);
        arrowhead1.lineTo(arX, arY);
        arrowhead1.lineTo(arX2, arY2);
        Shape arrowFin1 = transform.createTransformedShape(arrowhead1);
        g2D.draw(arrow1);
        g2D.fill(arrowFin1);
        
        //Arrow2
        Line2D.Double line2 = new Line2D.Double(origX, origY, origX2, origY2);
        Shape arrow2 = transform2.createTransformedShape(line2);
        Path2D.Double arrowhead2 = new Path2D.Double();
        arrowhead2.moveTo(arpX, arpY);
        arrowhead2.lineTo(arX, arY);
        arrowhead2.lineTo(arX2, arY2);
        Shape arrowFin2 = transform2.createTransformedShape(arrowhead2);
        g2D.draw(arrow2);
        g2D.fill(arrowFin2);
        
        
        //Arrow3        
        Line2D.Double line3 = new Line2D.Double(origX, origY, origX2, origY2);
        Shape arrow3 = transform3.createTransformedShape(line3);
        Path2D.Double arrowhead3 = new Path2D.Double();
        arrowhead3.moveTo(arpX, arpY);
        arrowhead3.lineTo(arX, arY);
        arrowhead3.lineTo(arX2, arY2);
        Shape arrowFin3 = transform3.createTransformedShape(arrowhead3);
        g2D.draw(arrow3);
        g2D.fill(arrowFin3);
        
        //Load Sign
        AffineTransform transform4 = new AffineTransform();
        AffineTransform rotate4 = new AffineTransform();
        Line2D.Double newLine = new Line2D.Double();
        Shape newLineFin = transform4.createTransformedShape(newLine);
        for(int i = 0; i < loadLines; i++) {
            double newAngle = i * ((2 * Math.PI) / loadLines);
            transform4 = new AffineTransform();
            transform4.concatenate(scaling);
            transform4.concatenate(translation);
            rotate4 = new AffineTransform();
            rotate4.setToRotation(newAngle + angleLoad, 
                                    loadCenterX, loadCenterY);
            transform4.concatenate(rotate4);
            
            newLine = new Line2D.Double(loadStartX, loadStartY, 
                                        loadEndX, loadEndY);
            newLineFin = transform4.createTransformedShape(newLine);
            
            g2D.draw(newLineFin);
        }// for
    
    } // paintComponent( Graphics )

    
    @Override
    public void actionPerformed(ActionEvent event) {
        this.angleSymbol = this.angleSymbol + this.moveSymbol;
        if(this.angleSymbol > (2 * Math.PI)) {
            this.angleSymbol = this.angleSymbol / this.rotateSymbol;
        }// if
        
        this.angleLoad = this.angleLoad + this.moveLoad;
        if(this.angleLoad > (2 * Math.PI)) {
            this.angleLoad = this.angleLoad / this.rotateLoad;
        }// if

        this.repaint();
    } // actionPerformed( ActionEvent )

}// Symbol
