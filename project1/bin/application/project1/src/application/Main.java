package application;
	
import java.util.*;

public class Main {
	public static void main (String[] args ) {
		LinkedList<String> shapes = new LinkedList<String>();
		String str1 = new String("square");
		String str2 = new String("circle");
		String str3 = new String("triangle");
		String str4 = new String("diamond");
		shapes.add( str1 );
		shapes.add( str2 );
		shapes.add( str3 );
		shapes.add( str4 );
		
		LinkedList<String> colors = new LinkedList<String>();
		str1 = "red";
		str2 = "blue";
		str3 = "yellow";
		str4 = "green";
		colors.add( str1 );
		colors.add( str2 );
		colors.add( str3 );
		colors.add( str4 );
		
		int n = 10;
		
		ShapeList list = new ShapeList(n, shapes, colors);
		System.out.println(list.toString());
		
		
	}
}