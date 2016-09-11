
public class test{

	public static void main(String[] args) {
		SquareMatrix matrix = new SquareMatrix(4);
		matrix.randomize();
		matrix.display();
		System.out.println("");
		matrix.quarterize();
		for(int i=0;i<4;i++){
			matrix.quadrants[i].display();
			System.out.println("");
		}
	}

}