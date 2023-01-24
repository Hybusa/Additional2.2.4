public class Main {
    public static void main(String[] args) {

        double[][] matrix = new double[][] {{1,2,-1},{-2,0,1},{1,-1,0}};
        Matrix origMatrix = new Matrix(matrix);

        origMatrix.printMatrix();
        System.out.println(origMatrix.isMatrixInvertible());
        System.out.println();
        origMatrix.printMatrix();

        Matrix inversedMatrix = new Matrix(origMatrix);
        inversedMatrix.inverseMatrix();
        inversedMatrix.printMatrix();

        origMatrix.multiplyMatrixByMatrix(inversedMatrix);
        origMatrix.printMatrix();

        origMatrix.addMatrix(inversedMatrix);
        origMatrix.printMatrix();
        System.out.println(origMatrix.compareMatrices(inversedMatrix));

        System.out.println(origMatrix.findMatrixDeterminant());

        System.out.println(origMatrix.getRows());
        System.out.println(origMatrix.getColumns());

        origMatrix.fillMatrixWithRandomFromRange(-43.4,56);
        origMatrix.printMatrix();

        origMatrix.fillMatrixWithRandom();
        origMatrix.printMatrix();







    }
}