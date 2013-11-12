import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Random;

/**
 * Реализация нейросети
 * <p/>
 * User: M9ist
 * Date: 11.11.13
 * Time: 15:56
 */
public class Neiro {
    private int heightInc, widthOut;
    private double[][] weights;

    public Neiro(final int in, final int out) {
        heightInc = in;
        widthOut = out;
        weights = new double[widthOut][heightInc];
    }

    public void randomizeNet() {
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < heightInc; i++) {
            for (int j = 0; j < widthOut; j++) {
                weights[j][i] = rnd.nextDouble();
            }
        }
    }

    public void nullNet() {
        for (int i = 0; i < heightInc; i++) {
            for (int j = 0; j < widthOut; j++) {
                weights[j][i] = 0;
            }
        }
    }

    public double activationFunction(double x) {
        return x > 0.75 ? 1.0 : 0;
    }

    public double[] activate(double[] inc) throws InvalidArgumentException {
        if (inc.length != heightInc) {
            throw new InvalidArgumentException(new String[]{"wrong length of income vector"});
        }
        double[] res = new double[widthOut];
        for (int j = 0; j < widthOut; j++) {
            res[j] = 0.0;
            for (int i = 0; i < heightInc; i++) {
                res[j] += weights[j][i] * inc[i];
            }
            res[j] = activationFunction(res[j]);
        }
        return res;
    }
}
