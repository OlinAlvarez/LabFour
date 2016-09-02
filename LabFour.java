import java.util.Random;

public class LabFour{
	//implementing square matrix multiplication.

	//This is where you can change the size of the matrix you want to use.
	static int DIM = 2;
	public static void main(String[] args){
		//matrix
		SquareMatrix mtx_1 = new SquareMatrix(DIM);
		SquareMatrix mtx_2 = new SquareMatrix(DIM);
		mtx_1.randomize();
		mtx_2.randomize();

		mtx_1.display();
		System.out.println();
		mtx_2.display();

		SquareMatrix mtx_3 = multiply(mtx_1,mtx_2);
		mtx_3.display();

	}
	static SquareMatrix multiply(SquareMatrix m1, SquareMatrix m2){
		SquareMatrix m3 = new SquareMatrix(DIM);
		m3.createMatrix();

		//Remember that m1 * m2 != m2 * m1 in every case.
		//also not that the format is going to be row column.
		for(int i=0;i<DIM;i++){
		     for(int j=0;j<DIM;j++){
		    	 for(int k=0;k<DIM;k++){
		          m3.set(i,j,m3.get(i,j) + m1.get(i,k)*m2.get(k,j));
		    	 }
		     }
		}
		/*
		 *	|a b|   |e g |    |a x e + b * h   a * g + b * i|
 		 *  |c d| X |h i | =  |c * e + d * h   c * g + d * i|
		 * */
		return m3;
	}

}
