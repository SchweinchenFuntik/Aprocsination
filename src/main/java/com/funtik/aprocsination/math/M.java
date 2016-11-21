package com.funtik.aprocsination.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author funtik
 */
public class M {
    public static BigInteger factorial(int n){
        BigInteger res = BigInteger.valueOf(1);
        for(; n>1; n--) res = res.multiply(BigInteger.valueOf(n));
        return res;
    }
    public static BigDecimal factorialDecimal(int n){
        BigDecimal res = new BigDecimal(1);
        for(; n>1; n--) res = res.multiply(BigDecimal.valueOf(n));
        return res;
    }
}
