/**
 * Created by yegor on 12/12/16.
 */
public class Network {
//    private int[] layers;
    private Matrix[] weights;

    public Network(int[] layers) {
//        this.layers = layers;

        weights = new Matrix[layers.length - 1];

        for (int i = 0; i < weights.length; i++) {
            weights[i] = new Matrix(new double[layers[i]][layers[i + 1]]);
        }
    }

    public Matrix forward(Matrix input) {
        for (int layer = 0; layer < weights.length; layer++) {
            input = Matrix.multiply(input, weights[layer]).toSigmoid();
        }
        return  input;
    }

    public void train(double[][] input, double[][] output) {

    }

    public Matrix[] getWeights() {
        return weights;
    }

    public void randomizeWeights() {
        for (int i = 0; i < weights.length; i++) {
            double[][] values = new double[weights[i].getHeight()][weights[i].getWidth()];

            for (int j = 0; j < values.length; j++) {
                for (int k = 0; k < values[0].length; k++) {
                    values[j][k] = Math.random() * 2 - 1;
                }
            }
            weights[i] = new Matrix(values);
        }
    }

    public double getCost(double[][] input, double[][] output) {
        double sum = 0;
        Matrix out = forward(new Matrix(input));

        for (int row = 0; row < out.getHeight(); row++) {
            for (int col = 0; col < out.getWidth(); col++) {
                sum += Math.pow(out.getValues()[row][col] - output[row][col], 2) / 2;
            }
        }

        return sum;
    }
}
