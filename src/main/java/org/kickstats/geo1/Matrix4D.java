
package org.kickstats.geo1;

/**
 * Models a 4x4 matrix.
 * 
 * @author Chase Sonnemaker
 */
public class Matrix4D {
    
    double[][] elements = new double[4][4];
    
    /**
     * Creates a 4x4 identity matrix.
     */
    public Matrix4D() {
        
    }// Matrix4D
    
    
    /**
     * Finds an element at a specified position in this matrix.
     * 
     * @param row The row of the element.
     * @param column The column of the element.
     * @return The value at the specified row and column of this matrix.
     */
    public double get(int row, int column) {
        return elements[row][column];
    }// get(int, int)
    
    
}// Matrix4D
