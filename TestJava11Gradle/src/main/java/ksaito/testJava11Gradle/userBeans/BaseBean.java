package ksaito.testJava11Gradle.userBeans;

import ksaito.testJava11Gradle.userUtilities.ObjectConverterUtilities;

public class BaseBean {
    public String toString(Object object) {
        try {
            return ObjectConverterUtilities.convertToJSON(object);
        } catch (IllegalAccessException e) {
            return "";
        }
    }

}
