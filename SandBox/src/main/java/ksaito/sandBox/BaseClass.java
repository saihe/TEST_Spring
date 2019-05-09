package ksaito.sandBox;

import java.util.List;
import java.util.Objects;

public abstract class BaseClass {
    public static void print(List<String> args) {
        if(Objects.nonNull(args)) {
            for(String str: args){
                System.out.println(str);
            }
        } else {
//            System.out.println("Warning: Argument is null.");
        }
    }
    public static void print(String[] args) {
        if(Objects.nonNull(args)) {
            for(String str: args){
                System.out.println(str);
            }
        } else {
//            System.out.println("Warning: Argument is null.");
        }
    }
    public static void print(String str) {
        if(Objects.nonNull(str)) {
            System.out.println(str);
        } else {
//            System.out.println("Warning: Argument is null.");
        }
    }
    public abstract void run();
}
