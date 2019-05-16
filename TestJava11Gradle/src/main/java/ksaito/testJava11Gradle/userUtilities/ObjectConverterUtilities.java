package ksaito.testJava11Gradle.userUtilities;

import java.lang.reflect.Field;
import java.util.List;

public class ObjectConverterUtilities {
    public enum QUOTE {
        DOUBLE, SINGLE, NONE;
    }

    private static String atatchQuote(String targetString, QUOTE quote) {
        StringBuffer result = new StringBuffer();
        switch (quote) {
            case DOUBLE:
                result.append("\"");
                result.append(targetString);
                result.append("\"");
                break;
            case SINGLE:
                result.append("'");
                result.append(targetString);
                result.append("'");
                break;
            case NONE:
                result.append(targetString);
                break;
            default:
                result.append(targetString);
                break;
        }
        return result.toString();
    }

    public static String convertToCSV(Object targetObject, QUOTE quote) throws IllegalAccessException{
        StringBuilder resultString = new StringBuilder();
        for (Field field : targetObject.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            resultString.append(",");
            resultString.append(atatchQuote(String.valueOf(field.get(targetObject)), quote));
        }
        return resultString.deleteCharAt(0).toString();
    }
    public static String convertToCSV(List<Object> targetObjectList, QUOTE quote) throws IllegalAccessException {
        StringBuilder resultString = new StringBuilder();
            for(Object tmpObject: targetObjectList) {
            resultString.append(convertToCSV(tmpObject, quote));
            resultString.append("\n");
        }
        return resultString.toString();
    }
    public static String convertToJSON(Object targetObject) throws IllegalAccessException {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{");
        for (Field field : targetObject.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            resultString.append(",");
            resultString.append(atatchQuote(String.valueOf(field.getName()), QUOTE.DOUBLE));
            resultString.append(": ");
            String typeName = field.get(targetObject).getClass().getTypeName();
            if(typeName.contains("java.")) {
                resultString.append(atatchQuote(String.valueOf(field.get(targetObject)), QUOTE.DOUBLE));
            } else {
                resultString.append(convertToJSON(field.get(targetObject)));
            }

        }
        if(resultString.toString().length() > 1) resultString.deleteCharAt(1);
        resultString.append("}");

        return resultString.toString();
    }

    public static String convertToJSON(List<Object> targetObjectList) throws IllegalAccessException {
        StringBuilder resultString = new StringBuilder();
        resultString.append("[");
        for(Object tmpObject: targetObjectList) {
            resultString.append(",");
            resultString.append(convertToJSON(tmpObject));
        }
        if(resultString.toString().length() > 1) resultString.deleteCharAt(1);
        resultString.append("]");

        return resultString.toString();
    }
}
