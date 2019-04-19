package ksaito;


import java.text.MessageFormat;

public class Main {

    public static void main(String[] args) {
//        Ryu001 ryu001 = new Ryu001();
//        ryu001.ryu();
//        Ryu002 ryu002 = new Ryu002();
//        ryu002.ryu();
        print("吉田竜也の姓名");
        print("姓：{0}、名：{1}", new String[]{"吉田", "竜也"});
    }

    /**
     * コンソール出力
     * @param message
     */
    public static void print(String message) {
        System.out.println(message);
    }
    /**
     * コンソール出力
     * @param message
     * @param paramaterArray
     */
    public static void print(String message, Object[] paramaterArray) {
        System.out.println(MessageFormat.format(message, paramaterArray));
    }
}
