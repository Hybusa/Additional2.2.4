public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(5,7);
        matrix.fillMatrixWithRandomFromRange(-10,10);
        matrix.printMatrix();

        Matrix matrix1 = new Matrix(5,7);
        matrix1.fillMatrixWithRandomFromRange(-10,10);
        matrix1.printMatrix();

        matrix.addMatrix(matrix1);
        matrix.printMatrix();

        matrix.multiplyMatrixByNumber(4.8);
        matrix.printMatrix();

        matrix.fillMatrixWithRandom();
    }
}