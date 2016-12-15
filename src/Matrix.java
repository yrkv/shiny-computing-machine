/**
 * Created by yegor on 12/12/16.
 */
public class Matrix {
    private double[][] values;
    private int height;
    private int width;

    public Matrix(double[][] values) {
        this.values = values;
        height = values.length;
        width = values[0].length;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    public double[][] getValues() {
        return values;
    }


    public Matrix toSigmoid() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                values[i][j] = 1/(1+Math.exp(-values[i][j]));
            }
        }

        return new Matrix(values);
    }
    public Matrix toSigmoidPrime() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                values[i][j] = Math.exp(-values[i][j]) / Math.pow(1 + Math.exp(-values[i][j]), 2);
            }
        }

        return new Matrix(values);
    }

    public Matrix transpose() {
        double[][] newValues = new double[values[0].length][values.length];

        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[0].length; col++) {
                newValues[col][row] = values[row][col];
            }
        }

        return new Matrix(newValues);
    }



    public static Matrix multiply(Matrix a, Matrix b) {
        double[][] valuesA = a.getValues();
        double[][] valuesB = b.getValues();

        double[][] values = new double[a.getHeight()][b.getWidth()];

        for (int row = 0; row < a.getHeight(); row++) {
            for (int col = 0; col < b.getWidth(); col++) {
                for (int i = 0; i < a.getWidth(); i++) {
                    values[row][col] += valuesA[row][i] * valuesB[i][col];
                }
            }
        }

        return new Matrix(values);
    }

    public static Matrix scalarMultiply(Matrix a, Matrix b) {
        double[][] outputValues = new double[a.getHeight()][a.getWidth()];
        for (int row = 0; row < a.getHeight(); row++) {
            for (int col = 0; col < a.getWidth(); col++) {
                outputValues[row][col] = a.getValues()[row][col] * b.getValues()[row][col];
            }
        }

        return new Matrix(outputValues);
    }
    public static Matrix scalarMultiply(double multiplier, Matrix matrix) {
        double[][] outputValues = new double[matrix.getHeight()][matrix.getWidth()];
        for (int row = 0; row < matrix.getHeight(); row++) {
            for (int col = 0; col < matrix.getWidth(); col++) {
                outputValues[row][col] = multiplier * matrix.getValues()[row][col];
            }
        }

        return new Matrix(outputValues);
    }
    public static Matrix scalarMultiply(Matrix matrix, double multiplier) {
        double[][] outputValues = new double[matrix.getHeight()][matrix.getWidth()];
        for (int row = 0; row < matrix.getHeight(); row++) {
            for (int col = 0; col < matrix.getWidth(); col++) {
                outputValues[row][col] = multiplier * matrix.getValues()[row][col];
            }
        }

        return new Matrix(outputValues);
    }


    public static Matrix add(Matrix a, Matrix b) {
        double[][] valuesA = a.getValues();
        double[][] valuesB = b.getValues();

        double[][] outputValues = new double[a.getHeight()][a.getWidth()];

        for (int i = 0; i < valuesA.length; i++) {
            for (int j = 0; j < valuesA[0].length; j++) {
                outputValues[i][j] = valuesA[i][j] + valuesB[i][j];
            }
        }

        return new Matrix(outputValues);
    }
}
