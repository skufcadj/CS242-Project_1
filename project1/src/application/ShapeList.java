/**
 * @author David Skufca
 * 
 * This class generates a permutation and combination of random shapes.
 */
package application;

import java.util.*;
import java.util.Random;

public class ShapeList {
	private LinkedList<Shape> orderedList = new LinkedList<Shape>();	// permutation of random shapes
	private LinkedList<Shape> randomList = new LinkedList<Shape>();		// combination version of orderedList, doe snot give away permutation
	
	Random randomNumber = new Random(); // for creating random integers
	
	/**
	 * ShapeList(N,types,colors) - generates N random shapes given the possible types and colors that you give it
	 * provides a permutation and a combination 
	 * 
	 * @param N	// number of random shapes to be generated
	 * @param types	// LinkedList of possible shape types
	 * @param colors	// LinkedList of possible shape colors
	 */
	public ShapeList( int N, LinkedList<String> types, LinkedList<String> colors ) {
		for ( int i = 0; i < N; i++ ) {
			int randomTypeIndex = randomNumber.nextInt( types.size() );
			int randomColorIndex = randomNumber.nextInt( colors.size() );
			
			String newType = types.get( randomTypeIndex );
			String newColor = colors.get( randomColorIndex );
			
			orderedList.add( new Shape( newType, newColor ) );
		}
		
		for ( int i = 0; i < types.size(); i++ ) {
			for ( int j = 0; j < colors.size(); j++ ) {
				for ( int k = 0; k < orderedList.size(); k++ ) {
					String shapeType = orderedList.get(k).getType();
					String shapeColor = orderedList.get(k).getColor();
					
					if ( shapeType == types.get(i) && shapeColor == colors.get(j) ) {
						randomList.add( orderedList.get(k) );
					}
					
				}
			}
		}
	}
	
	/**
	 * getPermutation() - returns permutation of random shapes
	 * this is what the user must guess
	 * 
	 * @return this.orderedList
	 */
	public LinkedList<Shape> getPermutation() {
		return this.orderedList;
	}
	
	/**
	 * getCombination() - returns combination of random shapes
	 * this is the pool of options for guessing
	 * 
	 * @return this.randomList
	 */
	public LinkedList<Shape> getCombination() {
		return this.randomList;
	}
	
	/**
	 * toString() - returns a string list of orderedList and randomList
	 * mostly for testing purposes
	 */
	@Override
	public String toString() {
		String olist = "";
		String rlist = "";
		
		for ( int i = 0; i < orderedList.size(); i++ ) {
			olist += orderedList.get(i).toString() + ", ";
		}
		
		for ( int i = 0; i < randomList.size(); i++ ) {
			rlist += randomList.get(i).toString() + ", ";
		}
		return "Ordered List: " + olist +"\nRandom List: " + rlist;
	}
}
