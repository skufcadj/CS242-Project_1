package application;
import java.lang.Object

public class Shape {
	private String type;
	private String color;
	
	public Shape( String type, String color ) {
		this.type = type;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return color + " " + type;
	}
}
