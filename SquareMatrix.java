import java.util.Random;
public class SquareMatrix{
	int size;
	int [][] matrix;


	public SquareMatrix(int size){
		this.size=size;
		matrix = new int[size][size];
		createMatrix();
	}
	//this will just create a null matrix.
	protected void createMatrix(){
		//int  [][] = new int [size][size];
		for(int i =0;i<size;i++){
		    for(int j=0;j<size;j++){
		  	matrix[i][j] = 0;
		    }
		}
	}
	@SuppressWarnings("unused")
	protected void randomize(){
		Random rn = new Random();
		for(int i =0;i<size;i++){
		    for(int j=0;j<size;j++){
		  	matrix[i][j] = rn.nextInt(20);;
		    }
		}
	}
	protected void set(int row, int col,int val){
		matrix[row][col]=val;
	}
	protected void display(){

		for(int i=0;i<size;i++){
			System.out.print("|");
			for(int j=0;j<size;j++){
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println("|");
		}
	}
	public int get(int row, int column){
		return matrix[row][column];
	}
}
