import java.util.stream.Stream;

public class TribonacciSequence {

    public static double[] tribonacci(double[] s, int n) {
         return Stream.iterate(
                    new double[]{s[0], s[1], s[2]},
                    p -> new double[]{p[1], p[2], p[0] + p[1] + p[2]}
                 )
                .limit(n)
                .mapToDouble(p -> p[0])
                .toArray();
    }
}