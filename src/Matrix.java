import java.util.Arrays;
import java.util.Random;

public class Matrix {

    private final double[][] matrix;
    private  int rows;
    private int columns;


    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.matrix = new double[rows][columns];
    }

    Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public void fillMatrixWithRandomFromRange(double min, double max) {
        fillMatrix(min, max);
    }

    public void fillMatrixWithRandom() {
        fillMatrix(-1554900.101,1554900.101);
    }

    public void addMatrix(Matrix otherMatrix)
    {
        if(!checkMatrixCompatibility(otherMatrix)) {
            System.out.println("Matrices have to be same in size");
        }
        else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] += otherMatrix.matrix[i][j];
                }
            }
        }
    }

    public void multiplyMatrixByNumber(double number)
    {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] *= number;
            }
        }
    }

    public double getRows()
    {
        return this.rows;
    }

    public double getColumns()
    {
        return this.columns;
    }

    public void printMatrix()
    {
        for(int i = 0; i < this.rows; i++) {
            System.out.println(Arrays.toString(this.matrix[i]));
        }
        System.out.println();
    }

    private void fillMatrix(double min, double max) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.matrix[i][j] = getRandomDouble(min, max);
            }
        }
    }

    private static double getRandomDouble(double min, double max) {
        Random random = new Random();
        return ((random.nextDouble() * (max - min)) + min);
    }

    private  boolean checkMatrixCompatibility(Matrix otherMatrix)
    {
        return this.rows == otherMatrix.rows && this.columns == otherMatrix.columns;
    }
}
