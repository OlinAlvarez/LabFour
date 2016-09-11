//strassen's method
public class StrassenMethod{
	static int DIMENSION = 4;
	public static void main(String[] args) {
		SquareMatrix mtx1 = new SquareMatrix(DIMENSION);
		mtx1.randomize();
		SquareMatrix mtx2 = new SquareMatrix(DIMENSION);
		mtx2.randomize();
		mtx1.quarterize();
		mtx1.display();
		System.out.println("");
		mtx2.display();
		mtx2.quarterize();
		System.out.println("");

		SquareMatrix matrix = strassen(mtx1,mtx2);

		matrix.display();
	}

	static SquareMatrix strassen(SquareMatrix mtx1, SquareMatrix mtx2){
		SquareMatrix productMatrix = new SquareMatrix(DIMENSION);
		productMatrix.quarterize();
		productMatrix.setQuad(0,strassenMulti(mtx1.quadrants[0],mtx2.quadrants[0]));

		productMatrix.setQuad(1,strassenMulti(mtx1.quadrants[1],mtx2.quadrants[1]));

		productMatrix.setQuad(2,strassenMulti(mtx1.quadrants[2],mtx2.quadrants[2]));

		productMatrix.setQuad(3,strassenMulti(mtx1.quadrants[3],mtx2.quadrants[3]));

		return productMatrix;
	}
	static SquareMatrix strassenMulti(SquareMatrix mtx1, SquareMatrix mtx2){

		SquareMatrix mtx = new SquareMatrix(mtx1.size);
		mtx.createMatrix();

		int m1 = (mtx1.get(0,0)+mtx1.get(1,1)) * (mtx2.get(0,0)+mtx2.get(1,1));
		int m2 = (mtx1.get(1,0)+mtx1.get(1,1))*mtx2.get(0,0);
		int m3 = mtx1.get(0,0)*(mtx2.get(0,1)-mtx2.get(1,1));
		int m4 = mtx1.get(1,1)*(mtx2.get(1,0)-mtx2.get(0,0));
		int m5 = (mtx1.get(0,0)+mtx1.get(0,1))*mtx2.get(1,1);
		int m6 = (mtx1.get(1,0)-mtx1.get(0,0))*(mtx2.get(0,0)+mtx2.get(0,1));
		int m7 = (mtx1.get(0,1)-mtx1.get(1,1))*(mtx2.get(1,0)+mtx2.get(1,1));


		mtx.set(0,0,m1+m4-m5+m7);
		mtx.set(0,1,m3+m5);
		mtx.set(1,0,m2+m4);
		mtx.set(1,1,m1-m2+m3+m6);

		mtx.display();
		System.out.println("");

		return mtx;
	}
}