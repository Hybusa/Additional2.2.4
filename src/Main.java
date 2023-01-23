public class Main {
    public static void main(String[] args) {

      /*  Matrix matrix = new Matrix(5,7);
        matrix.fillMatrixWithRandomFromRange(-10,10);
        matrix.printMatrix();

        Matrix matrix1 = new Matrix(5,7);
        matrix1.fillMatrixWithRandomFromRange(-10,10);
        matrix1.printMatrix();

        matrix.addMatrix(matrix1);
        matrix.printMatrix();

        matrix.multiplyMatrixByNumber(4.8);
        matrix.printMatrix();

        matrix.fillMatrixWithRandom();*/
        double[][] matrix = new double[][] {{1,2,-1},{-2,0,1},{1,-1,0}};
        Matrix origMatrix = new Matrix(matrix);
        Matrix newMatrix = new Matrix(matrix);

        origMatrix.printMatrix();

        newMatrix.printMatrix();

        System.out.println(newMatrix.findMatrixDeterminant());

        newMatrix.reverseMatrix();

        newMatrix.printMatrix();

        origMatrix.multiplyMatrixByMatrix(newMatrix);
        origMatrix.printMatrix();





    }
}