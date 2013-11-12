/**
 * Created with IntelliJ IDEA.
 * User: M9ist
 * Date: 11.11.13
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
public class NeiroTest {
    // собственно само хранилище весов
    private double[][] net;
    // скорость обучения
    private double alpha;
    private int sizeIn;
    private int sizeOut;

    public NeiroTest(final int sizeIn, final int sizeOut, final double alpha) {
        net = new double[sizeIn][sizeOut];
        this.alpha = alpha;
        this.sizeIn = sizeIn;
        this.sizeOut = sizeOut;
    }

    /**
     * производит обучение системы
     *
     * @param in
     * @param out
     */
    public void makeTraining(final double[] in, final int[] out) {
        for (int step = 0; step < out.length; step++) {
            double guess = 0;
            for (int i = 0; i < in.length; i++) {
                guess += net[i][step];
            }
            final int res = activationFunction(guess);
            // теперь возможны три варианта:
            // 1. guess == out[step]
            // 2. guess == 0 out[step] == 1
            // 3. guess == 1 out[step] == 0
            if (res == out[step]) {
                continue;
            }
            // значит всем участвующим в процессе узлам надо изменить вес на скорость обучения
            for (int i = 0; i < in.length; i++) {
                if (in[i] != 0) {
                    net[i][step] += (res == 1 ? -1 : 1) * alpha;
                    if (net[i][step] < 0) {
                        net[i][step] = 0;
                    }
                }
            }
        }
    }

    /**
     * активационная функция, используемая нами
     *
     * @param x
     * @return
     */
    private int activationFunction(double x) {
        return x > 0.75 ? 1 : 0;
    }

    public int[] getResult(final double in[]) {
        final double[] resCalc = new double[sizeOut];
        for (int i = 0; i < sizeOut; i++) {
            for (int j = 0; j < sizeIn; j++) {
                resCalc[i] += net[j][i] * in[j];
            }
        }
        final int[] res = new int[sizeOut];
        for (int i = 0; i < sizeOut; i++) {
            res[i] = activationFunction(resCalc[i]);
        }
        return res;
    }
}
