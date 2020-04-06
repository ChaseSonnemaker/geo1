
package org.kickstats.swing;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Models a 4x4 matrix used to perform transitions, scalings, and rotations 
 * for 4 element vectors in 3D space.
 * 
 * @author Chase Sonnemaker
 * @version 5 April 2020
 */
public class Matrix {
    
    double[][] elements = new double[4][4];
    
    /**
     * Creates a 4x4 identity matrix.
     */
    public Matrix() {
        this.identity();
    }// Matrix
    
    
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
     * Returns a single row of this matrix in string representation.
     * 
     * Strings are formatted to show 2 decimals and to be a maximum of 6 digits.
     * Using matrices with numbers larger than six digits with this 
     * method is not recommended.
     * 
     * @param row The index of the row to be converted into a string.
     * @return A formatted string representation of the row.
     */
    public String toStringRow(int row) {
        StringBuilder stringbuild = new StringBuilder();
        stringbuild.append("[ ");
        for(int i = 0; i < 3; i++) {
            String number = String.format("%2.2f", this.elements[row][i]);
            String string = String.format("%6.6s, ", number);
            stringbuild.append(string);
        }// for
        String number = String.format("%2.2f", this.elements[row][3]);
        String string = String.format("%6.6s]", number);
        stringbuild.append(string);
        return stringbuild.toString();
    }// toStringRow(int)
    
    
    /**
     * Returns a string representation of this matrix.
     * 
     * Each number in the matrix is formatted to have 2 decimals and a 
     * maximum of 6 digits so longer numbers will not look correct. 
     * This string will also be printed to 4 new lines. 
     * 
     * @return A four-line string representation of this matrix.
     */
    @Override
    public String toString() {
        StringBuilder stringRep = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            stringRep.append("\n");
            stringRep.append(this.toStringRow(i));
        }// for
        return stringRep.toString();
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
    public Matrix multiply(Matrix m) {
        Matrix newM = new Matrix();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                double sum = 0;
                for(int k = 0; k < 4; k++) {
                    sum = sum + this.elements[i][k] * m.elements[k][j];
                }//for
            newM.set(i, j, sum);
            }// for
        }// for
        return newM;
    }// multiply(Matrix)
    
    
    /**
     * Multiplies this matrix by a vector with 4 elements.
     * 
     * @param v The vector with 4 elements this matrix is to be multiplied by.
     * @return A vector of length 4 that is the product of this matrix and 
     * a vector.
     */
    public Vector multiply(Vector v) {
        Vector newV = new Vector();
        for(int i = 0; i < 4; i++) {
            double sum = 0;
            for(int j = 0; j < 4; j++) {
                sum = sum + this.elements[i][j] * v.get(j);
            }// for
            newV.set(i, sum);
        }// for
        return newV;
    }// multiply(Vector)
    
    
    /**
     * Transforms this matrix into a matrix that models a translation of a
     * vector in 3D space.
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
     * x-axis of a vector in 3D space.
     * 
     * @param angle The angle (radians) of the rotation about the x-axis.
     */
    public final void rotateX(double angle) {
        double cos = cos(angle);
        double sin = sin(angle);
        this.identity();
        this.set(1, 1, cos);
        this.set(1, 2, -sin);
        this.set(2, 1, sin);
        this.set(2, 2, cos);
    }// rotateX(double)
    
    
    /**
     * Transforms this matrix into a matrix that models a rotation about the
     * y-axis of a vector in 3D space.
     * 
     * @param angle The angle (radians) of the rotation about the y-axis.
     */
    public final void rotateY(double angle) {
        double cos = cos(angle);
        double sin = sin(angle);
        this.identity();
        this.set(0, 0, cos);
        this.set(2, 0, -sin);
        this.set(0, 2, sin);
        this.set(2, 2, cos);
    }// rotateY(double)
    
    
    /**
     * Transforms this matrix into a matrix that models a rotation about the
     * z-axis of a vector in 3D space.
     * 
     * @param angle The angle (radians) of the rotation about the z-axis.
     */
    public final void rotateZ(double angle) {
        double cos = cos(angle);
        double sin = sin(angle);
        this.identity();
        this.set(0, 0, cos);
        this.set(0, 1, -sin);
        this.set(1, 0, sin);
        this.set(1, 1, cos);
    }// rotateZ(double)
    
    
    /**
     * Transforms this matrix into a matrix that models a scaling of
     * a vector in 3D space. 
     * 
     * @param x The factor by which to scale in the x-direction.
     * @param y The factor by which to scale in the x-direction.
     * @param z The factor by which to scale in the x-direction.
     */
    public final void scale(double x, double y, double z) {
        this.identity();
        this.set(0, 0, x);
        this.set(1, 1, y);
        this.set(2, 2, z);
    }// scale(double, double, double)
    
    
    /**
     * Additional tests for the string methods contained in the Matrix
     * classes since these are difficult to formally test.
     */
    public static void main(String[] args) {
        
        //Matrix.toStringRow() Test
        Matrix newM = new Matrix();
        System.out.println(newM.toStringRow(0));
        System.out.println();
        
        //Matrix.toString() Test
        System.out.println(newM);
        System.out.println();
        
    }// main(String[])
 
    
}// Matrix
