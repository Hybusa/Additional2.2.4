import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix(5,7);
        matrix.fillMatrixWithRandom();
        matrix.printMatrix();
        matrix.multiplyMatrixByNumber(3);
        matrix.printMatrix();

    }
}