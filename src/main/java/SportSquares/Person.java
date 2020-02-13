package SportSquares;
/**
 * This class associates the names and squares together
 * 
 * @author MikeBednarski
 * 
 */

public class Person {
	
	private String name;
	private int squares;
	
	public Person(String name, int squares) {
		this.name = name;
		this.squares = squares;
	}
	
	public void addSquares(int squares) {
		this.squares += squares;
	}
	
	public void subtractSquares(int squares) {
		this.squares -= squares;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSquares() {
		return squares;
	}

}
