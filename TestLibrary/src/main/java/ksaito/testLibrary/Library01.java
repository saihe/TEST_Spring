package ksaito.testLibrary;

import java.util.List;

public class Library01 {
    /**
     * コンソール出力メソッド
     * @param message
     */
    public static void print(String message) {
        System.out.println(message);
    }
    public static void print(List<String> messageList) {
        messageList.forEach(message -> System.out.println(message));
    }
}
