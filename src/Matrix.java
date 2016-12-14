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
}
