import java.util.Arrays;

public class Matrix {

    double[][] matrix;
    int rows;
    int columns;


    Matrix(int rows, int columns) {
        this.matrix = new double[rows][columns];
    }

    Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] fillMatrixWithRandomFromRange(double min, double max) {
        return fillMatrix(min, max);
    }

    public double[][] fillMatrixWithRandom() {
        return fillMatrix(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    public double[][] addMatrix(double[][] otherMatrix)
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] += otherMatrix[i][j];
            }
        }
        return this.matrix;
    }

    public double[][] multiplyMatrixByNumber(double number)
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] *= number;
            }
        }
        return this.matrix;
    }

    public void printMatrix()
    {
        for(int i = 0; i < this.rows; i++) {
            System.out.println(Arrays.toString(this.matrix[i]));
        }
    }

    private double[][] fillMatrix(double min, double max) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                matrix[i][j] = getRandomDouble(min, max);
            }
        }
        return matrix;
    }

    private static double getRandomDouble(double min, double max) {
        return ((Math.random() * (max - min)) + min);
    }
}
