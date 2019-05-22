import static org.junit.Assert.*;

import org.junit.Test;

public class TribonacciSequenceTest {

    private double precision = 1e-10;

    @Test
    public void test01() {
        assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, TribonacciSequence.tribonacci(new double []{1,1,1},10), precision);
    }

    @Test
    public void test02(){
        assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, TribonacciSequence.tribonacci(new double []{0,0,1},10), precision);
    }

    @Test
    public void test03(){
        assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, TribonacciSequence.tribonacci(new double []{0,1,1},10), precision);
    }

    @Test
    public void test04(){
        assertArrayEquals(
                new double []{
                        1.0, 2.0, 10.0, 13.0, 25.0, 48.0, 86.0, 159.0, 293.0, 538.0, 990.0, 1821.0,
                        3349.0, 6160.0, 11330.0, 20839.0, 38329.0, 70498.0, 129666.0, 238493.0},
                TribonacciSequence.tribonacci(new double []{1,2,10},20), precision
        );
    }

    @Test
    public void test05(){
        assertArrayEquals(
                new double []{19.0},
                TribonacciSequence.tribonacci(new double []{19, 10, 15},1), precision
        );
    }

    @Test
    public void test06(){
        assertArrayEquals(
                new double []{
                        6.0, 12.0, 6.0, 24.0, 42.0, 72.0, 138.0, 252.0, 462.0, 852.0, 1566.0, 2880.0, 5298.0,
                        9744.0, 17922.0, 32964.0, 60630.0, 111516.0
                },
                TribonacciSequence.tribonacci(new double []{6.0, 12.0, 6.0},18), precision
        );
    }
    @Test
    public void test07(){
        assertArrayEquals(
                new double []{
                        4.0, 20.0, 4.0, 28.0, 52.0, 84.0, 164.0, 300.0, 548.0, 1012.0, 1860.0, 3420.0, 6292.0,
                        11572.0, 21284.0, 39148.0, 72004.0, 132436.0, 243588.0, 448028.0, 824052.0, 1515668.0,
                        2787748.0, 5127468.0, 9430884.0
                },
                TribonacciSequence.tribonacci(new double []{4.0, 20.0, 4.0},25), precision
        );
    }
}