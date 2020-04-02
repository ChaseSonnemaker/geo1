
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
        this.identity();
    }// Matrix4D
    
    
    /**
     * Finds an element at a specified position in this matrix.
     * 
     * @param row The row of the element.
     * @param column The column of the element.
     * @return The value at the specified row and column of this matrix.
     */
    public double get(int row, int column) {
        return this.elements[row][column];
    }// get(int, int)
    
    
    /**
     * Sets the value at a specified position in this 
     * matrix to a specified value.
     * 
     * @param row The row of the element to set.
     * @param column The column of the element to set.
     * @param value The value to set at the specified position.
     */
    public final void set(int row, int column, double value) {
        this.elements[row][column] = value;
    }// set(int, int, double)
    
    
    /**
     * Returns a string representation of this matrix.
     * 
     * Each number in the matrix is formatted to be 8 digits so 
     * longer numbers will not look correct.
     * 
     * @return A four-line string representation of this matrix.
     */
    @Override
    public String toString() {
        return "";
    }// toString()
    
    
    /**
     * Turns this matrix into the identity matrix.
     */
    public final void identity() {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(i == j) {
                   this.set(i, j, 1);
                }// if
                else {
                    this.set(i, j, 0);
                }// else
            }// for
        }// for
    }// identity() 
    
    
    /**
     * Multiplies this matrix by another 4x4 matrix.
     * 
     * @param m The 4x4 matrix this matrix is to be multiplied by.
     * @return A 4x4 matrix that is the product of the other two matrices.
     */
    public Matrix4D multiply(Matrix4D m) {
        return new Matrix4D();
    }// multiply(Matrix4D)
    
    
    /**
     * Multiplies this matrix by a vector with 4 elements.
     * 
     * @param v The vector with 4 elements this matrix is to be multiplied by.
     * @return A vector of length 4 that is the product of this matrix and 
     * a vector.
     */
    public Vector4D multiply(Vector4D v) {
        return new Vector4D(0, 0, 0, 0);
    }// multiply(Vector4D)
    
    
    /**
     * Transforms this matrix into a matrix that models a translation of a
     * position in 3D space.
     * 
     * This position can be represented by a vector of 4 elements. 
     * 
     * @param x The distance the vector will move in the x-direction.
     * @param y The distance the vector will move in the y-direction.
     * @param z The distance the vector will move in the z-direction.
     */
    public final void translate(double x, double y, double z) {
        this.identity();
        this.set(0, 3, x);
        this.set(1, 3, y);
        this.set(2, 3, z);
    }// translate(double, double, double)
    
    
    /**
     * Transforms this matrix into a matrix that models a rotation about the
     * x-axis of a position in 3D space.
     * 
     * This position can be represented by a vector of 4 elements.
     * 
     * @param angle The angle (radians) of the rotation about the x-axis.
     */
    public final void rotateX(double angle) {
        
    }// rotateX(double)
    
    
    /**
     * Transforms this matrix into a matrix that models a rotation about the
     * y-axis of a position in 3D space.
     * 
     * This position can be represented by a vector of 4 elements.
     * 
     * @param angle The angle (radians) of the rotation about the y-axis.
     */
    public final void rotateY(double angle) {
        
    }// rotateY(double)
    
    
    /**
     * Transforms this matrix into a matrix that models a rotation about the
     * z-axis of a position in 3D space.
     * 
     * This position can be represented by a vector of 4 elements.
     * 
     * @param angle The angle (radians) of the rotation about the z-axis.
     */
    public final void rotateZ(double angle) {
        
    }// rotateZ(double)
    
    
    /**
     * Transforms this matrix into a matrix that models a scaling of
     * a position in 3D space. 
     * 
     * This position can be represented by a vector of 4 elements.
     * 
     * @param x The factor by which to scale in the x-direction.
     * @param y The factor by which to scale in the x-direction.
     * @param z The factor by which to scale in the x-direction.
     */
    public final void scale(double x, double y, double z) {
        
    }// scale(double, double, double)
    
    
}// Matrix4D
