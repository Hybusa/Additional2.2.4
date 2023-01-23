import java.util.Arrays;
import java.util.Random;

public class Matrix {

    private double[][] matrix;
    private int rows;
    private int columns;


    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.matrix = new double[rows][columns];
    }

    Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = matrix;
    }

    public void fillMatrixWithRandomFromRange(double min, double max) {
        fillMatrix(min, max);
    }

    public void fillMatrixWithRandom() {
        fillMatrix(-1554900.101, 1554900.101);
    }

    public void addMatrix(Matrix otherMatrix) {
        if (!checkMatrixCompatibilityForAddition(otherMatrix)) {
            System.out.println("Matrices have to be same in size");
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] += otherMatrix.matrix[i][j];
                }
            }
        }
    }

    public void multiplyMatrixByNumber(double number) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] *= number;
            }
        }
    }

    public void multiplyMatrixByMatrix(Matrix otherMatrix) {
        if (!checkMatrixCompatibilityForMultiplication(otherMatrix))
            System.out.println("Matrices have to multiplicable");
        else {
            Matrix newMatrix = new Matrix(this.rows, otherMatrix.columns);
            for (int i = 0; i < this.columns; i++) {
                for (int j = 0; j < otherMatrix.rows; j++) {
                    for (int k = 0; k < this.columns; k++) {
                        newMatrix.matrix[i][j] += (this.matrix[i][k] * otherMatrix.matrix[k][j]);
                    }
                }
            }
            this.matrix = newMatrix.matrix;
        }
    }

    private Matrix matrixCofactor(Matrix matrix, int row, int column) {
        int tmpRow = 0;
        int tmpCol = 0;
        Matrix tmpMatrix = new Matrix(matrix.rows - 1, matrix.columns - 1);
        for (int i = 0; i < matrix.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                if (i != row && j != column) {
                    tmpMatrix.matrix[tmpRow][tmpCol] = matrix.matrix[i][j];
                    tmpCol++;
                    if (tmpCol == matrix.columns - 1) {
                        tmpCol = 0;
                        tmpRow++;
                    }
                }
            }
        }
        return tmpMatrix;
    }

    public double findMatrixDeterminant() {
        double determinant = 0;
        int sign = 1;

        if (this.columns == 1)
            return this.matrix[0][0];

        if (!checkMatrixIsSquare(this))
            System.out.println("Matrix has to be square for that");
        else {

            if (this.rows == 1) {
                determinant = this.matrix[0][0];
            }
            for (int i = 0; i < this.columns; i++) {
                determinant += sign * this.matrix[0][i]
                        * (matrixCofactor(this, 0, i).findMatrixDeterminant());
                sign = -sign;
            }
            return determinant;
        }
        return -1;
    }

    public void reverseMatrix() {
        int sign = 1;
        Matrix newMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                newMatrix.matrix[i][j] = sign*(matrixCofactor(this, i, j).findMatrixDeterminant());
                sign = -sign;
            }
        }


        double determinant = this.findMatrixDeterminant();
        newMatrix.flipMatrix();
        newMatrix.multiplyMatrixByNumber(1/determinant);
        this.matrix = newMatrix.matrix;

    }

    public void setRowsAndColumns(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public double getRows() {
        return this.rows;
    }

    public double getColumns() {
        return this.columns;
    }

    public void printMatrix() {
        for (int i = 0; i < this.rows; i++) {
            System.out.println(Arrays.toString(this.matrix[i]));
        }
        System.out.println();
    }


    public void flipMatrix() {

        Matrix newMatrix = new Matrix(this.rows,this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                    newMatrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        this.matrix = newMatrix.matrix;
    }

    private boolean checkMatrixIsSquare(Matrix matrix) {
        return (matrix.rows == matrix.columns);
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

    private boolean checkMatrixCompatibilityForMultiplication(Matrix otherMatrix) {
        return this.rows == otherMatrix.columns && this.columns == otherMatrix.rows;
    }

    private boolean checkMatrixCompatibilityForAddition(Matrix otherMatrix) {
        return this.rows == otherMatrix.rows && this.columns == otherMatrix.columns;
    }
}
