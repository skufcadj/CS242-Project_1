package application;
	
import javafx.application.Application;
import java.util.*;
import java.util.Random;

public class ShapeList {
	LinkedList<Shape> orderedList = new LinkedList<Shape>();
	LinkedList<Shape> randomList = new LinkedList<Shape>();
	
	Random randomNumber = new Random();
	
	public ShapeList( int N, LinkedList<String> types, LinkedList<String> colors ) {
		for ( int i = 0; i < N; i++ ) {
			int randomTypeIndex = randomNumber( types.size() );
			int randomColorIndex = randomNumber( colors.size() );
			
			String newType = types.get( randomTypeIndex );
			String newColor = types.get( randomColorIndex );
			
			orderedList.add( new Shape( newType, newColor ) );
		}
		
		for ( int i = 0; i < orderedList.size() )
	}

}
