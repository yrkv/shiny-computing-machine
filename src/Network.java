/**
 * Created by yegor on 12/12/16.
 */
public class Network {
//    private int[] layers;
    private Matrix[] weights;

    public Network(int[] layers) {
//        this.layers = layers; // this may be necessary for some of the backpropagation stuff.

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

    public void train(Matrix input, Matrix output) {
        for (int i = 0; i < weights.length; i++) {
            Matrix guess = forward(input);

            Matrix error = Matrix.add(Matrix.scalarMultiply(-1, output), guess);

            Matrix backpropagatingError = Matrix.scalarMultiply(error, weights[i].toSigmoidPrime());

            Matrix aaa = Matrix.multiply()
        }
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

    // badly named. The function name doesn't give any info. You will have no idea what "cost" is supposed to be.
    // also need to shift away from using double[][] and just use the Matrix class.
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
