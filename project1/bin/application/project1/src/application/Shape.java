/**
 * @author David Skufca
 * 
 * Shape class used as object in ShapeList. Holds type of shape and color of said shape
 */
package application;

public class Shape {
	private String type;	// type of shape (i.e. square, circle, triangle, etc.)
	private String color;	// color of shape (i.e. red, blue, yellow, etc.)
	
	/**	
	 * Shape(type, color) - creates shape and assigns type & color
	 * 
	 * @param type
	 * @param color
	 */
	public Shape( String type, String color ) {
		this.type = type;
		this.color = color;
	}
	
	/**
	 * getType() - returns the type of shape
	 * 
	 * @return this.type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * getColor() - returns the color of shape
	 * 
	 * @return this.color
	 */
	public String getColor() {
		return this.color;
	}
	/**
	 * toString() - returns a description of shape in format "color type" (i.e. "red circle")
	 * 
	 * @return color + " " + type
	 */
	@Override
	public String toString() {
		return color + " " + type;
	}
}
