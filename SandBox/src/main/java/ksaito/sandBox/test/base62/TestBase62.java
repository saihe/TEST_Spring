package ksaito.sandBox.test.base62;

import ksaito.sandBox.BaseClass;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TestBase62 extends BaseClass {
    private final BigInteger BASE =  new BigInteger("62");
    private final String BASE62_TABLE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public void run() {
        String targetDecimalString = "1234567890";
        print("エンコード前：" + targetDecimalString);
        String enocdeResult = encode(targetDecimalString);
        print("エンコード後：" + enocdeResult);
        String decodeResult = decode(enocdeResult);
        print("デコード後：" + decodeResult);
    }
    public void run(String targetDecimalString) {
        print("エンコード前：" + targetDecimalString);
        String enocdeResult = encode(targetDecimalString);
        print("エンコード後：" + enocdeResult);
        String decodeResult = decode(enocdeResult);
        print("デコード後：" + decodeResult);
    }
    public void run(int targetNumber) {
        String targetDecimalString = String.valueOf(targetNumber);
        print("エンコード前：" + targetDecimalString);
        String enocdeResult = encode(targetDecimalString);
        print("エンコード後：" + enocdeResult);
        String decodeResult = decode(enocdeResult);
        print("デコード後：" + decodeResult);
    }

    /**
     * 10進数から62進数へのエンコード
     * @param targetDecimalString
     * @return
     */
    public String encode(String targetDecimalString) {
        char[] tableArray = BASE62_TABLE.toCharArray();
        StringBuilder result = new StringBuilder();
        List<BigInteger> encodeResultIndexList = new ArrayList<BigInteger>();
        BigInteger divideResultInteger = new BigInteger(targetDecimalString);
        while(divideResultInteger.compareTo(BASE) >= 0) {
            BigInteger tmpModResult = divideResultInteger.remainder(BASE);
            BigInteger tmpSubtractResult = divideResultInteger.subtract(tmpModResult);
            divideResultInteger = tmpSubtractResult.divide(BASE);
            print("割り算計算結果：" + divideResultInteger.toString());
            encodeResultIndexList.add(0, tmpModResult);
        }
        encodeResultIndexList.add(0, divideResultInteger);
        for(BigInteger bi: encodeResultIndexList){
            result.append(tableArray[bi.intValue()]);
        }
        return result.toString();
    }

    /**
     * 62進数から10進数へのデコード
     * @param target62BinaryString
     * @return
     */
    public String decode(String target62BinaryString) {
        List<BigInteger> list = new ArrayList<BigInteger>();
        BigInteger addResult = new BigInteger("0");
        char[] targetCharArray = target62BinaryString.toCharArray();
        for(char c: targetCharArray) {
            int index = BASE62_TABLE.indexOf(String.valueOf(c));
            print("対象文字：" + c + "、検索結果：" + index);
            list.add(0, new BigInteger(String.valueOf(index)));
        }
        for(int i = 0; i < targetCharArray.length; i++) {
            BigInteger multiplyResult = list.get(i).multiply(BASE.pow(i));
            addResult = addResult.add(multiplyResult);
            print("計算中：" + addResult.toString());
        }
        return addResult.toString();
    }
}
