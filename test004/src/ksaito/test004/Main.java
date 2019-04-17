package ksaito.test004;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BigInteger number = new BigInteger("9999999999999999999");
        String TABLE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        BigInteger BASE = new BigInteger("62");

        List<BigInteger> tmpResultList = new ArrayList<BigInteger>();
        BigInteger[] tmpResultArray = new BigInteger[2];
        tmpResultArray[0] = number.abs();
        while (tmpResultArray[0].compareTo(BASE) > 0) {
            tmpResultArray = tmpResultArray[0].divideAndRemainder(BASE);
            System.out.println("商：" + tmpResultArray[0]);
            System.out.println("余：" + tmpResultArray[1]);
            tmpResultList.add(0, tmpResultArray[1]);

        }
        tmpResultList.add(0, tmpResultArray[0]);
//        BigInteger tmpDivideResult = number.abs();
//        while (tmpDivideResult.compareTo(BASE) > 0) {
//            BigInteger[] tmpResult = tmpDivideResult.divideAndRemainder(BASE);
//            BigInteger tmpModResult = new BigInteger(number.toString());
//            tmpModResult = tmpDivideResult.mod(BASE);
//            tmpDivideResult = tmpDivideResult.divide(BASE);
//            System.out.println("商（" + tmpDivideResult + " divide " + BASE + "）：" + tmpDivideResult.toString());
//            System.out.println("余（" + tmpDivideResult + " mod " + BASE + "）：" + tmpModResult.toString());
//            System.out.println("余（" + tmpDivideResult + " % " + BASE + "）：" + tmpResult[1].toString());
//            tmpResultList.add(0, tmpModResult);
//
//        }
//        tmpResultList.add(0, tmpDivideResult);

        StringBuilder sb = new StringBuilder(0);
        System.out.println("計算結果各要素：");
        for (BigInteger bi: tmpResultList) {
            System.out.println(bi);
            sb.append(bi);
        }
        System.out.println(sb.toString());

    }
}
