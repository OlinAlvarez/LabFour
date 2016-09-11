import java.util.Random;
public class SquareMatrix{
	int size;
	int [][] matrix;
	SquareMatrix[] quadrants = new SquareMatrix[4];

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
		  	matrix[i][j] = rn.nextInt(5)+1;;
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
	public SquareMatrix minus(SquareMatrix mtx){
		SquareMatrix m1 = new SquareMatrix(size);
		m1.createMatrix();
	 	for (int i=0;i<size ;i++ ) {
	 		for (int j=0;j<size ;j++ ) {
	 			m1.set(i,j,matrix[i][j]-mtx.get(i,j));
	 		}
	 	}
	 	return m1;
	}
	public SquareMatrix plus(SquareMatrix mtx){
		SquareMatrix m1 = new SquareMatrix(size);
		m1.createMatrix();
	 	for (int i=0;i<size ;i++ ) {
	 		for (int j=0;j<size ;j++ ) {
	 			m1.set(i,j,matrix[i][j]+mtx.get(i,j));
	 		}
	 	}
	 	return m1;
	}
	public void quarterize(){
		for(int i=0;i<4;i++){
			quadrants[i] = new SquareMatrix(size/2);
		}
		for (int i=0;i<size ;i++ ) {
			for (int j=0;j<size ;j++ ) {
				if(i<(size/2) && j<(size/2)){

					quadrants[0].set(i,j,matrix[i][j]);
				}
				else if(i<(size/2) && j>=(size/2)){

					quadrants[1].set(i,j-(size/2),matrix[i][j]);

				}
				else if(i>=(size/2) && j<(size/2)){

					quadrants[2].set(i-(size/2),j,matrix[i][j]);
				}
				else if(i>=(size/2) && j>=(size/2)){

					quadrants[3].set(i-(size/2),j-(size/2),matrix[i][j]);
				}

			}
		}
	}
	public void setQuad(int index,SquareMatrix m1){
		for(int i=0;i<quadrants[index].size;i++){
			for(int j=0;j<quadrants[index].size;j++){
				quadrants[index].set(i,j,m1.get(i,j));
				switch(index){
					case 0: matrix[i][j]=quadrants[index].get(i,j);
						break;
					case 1: matrix[i][j+index]=quadrants[index].get(i,j);
						break;
					case 2: matrix[i + index][j]=quadrants[index].get(i,j);
						break;
					case 3: matrix[i+ index-1][j+index-1]=quadrants[index].get(i,j);
						break;
				}
			}
		}
	}


}
