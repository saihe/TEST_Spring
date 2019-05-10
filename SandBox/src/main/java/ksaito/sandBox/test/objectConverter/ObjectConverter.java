package ksaito.sandBox.test.objectConverter;

import ksaito.sandBox.BaseClass;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;

public class ObjectConverter extends BaseClass {
    public enum MODE {
        CSV, JSON;
    }
    public enum QUOTE {
        DOUBLE, SINGLE, NONE;
    }
    public void run(){
        run(createTestObject(), MODE.CSV, QUOTE.SINGLE);
        run(createTestObject(), MODE.JSON , null);
    }
    public void run(Object targetObject, MODE mode, QUOTE quote) {
        String result = "";
        switch (mode) {
            case CSV:
                result = convertToCSV(targetObject, QUOTE.SINGLE);
                print(result);
                break;
            case JSON:
                result = convertToJSON(targetObject);
                print(result);
                break;
            default:
                break;
        }
    }

    public String convertToCSV(Object targetObject, QUOTE quote) {
        StringBuilder resultString = new StringBuilder();
        try {
            for (Field field : targetObject.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                resultString.append(",");
                resultString.append(atatchQuote(String.valueOf(field.get(targetObject)), quote));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return resultString.deleteCharAt(0).toString();
    }

    public String convertToJSON(Object targetObject) {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{");
        try{
            for (Field field : targetObject.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                resultString.append(",");
                resultString.append(atatchQuote(String.valueOf(field.getName()), QUOTE.DOUBLE));
                resultString.append(": ");
                resultString.append(atatchQuote(String.valueOf(field.get(targetObject)), QUOTE.DOUBLE));
            }
            if(resultString.toString().length() > 1) resultString.deleteCharAt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultString.append("}");

        return resultString.toString();
    }

    private TestObject createTestObject() {
        TestObject testObject = new TestObject();
        testObject.setId("001");
        testObject.setName("TEST");
        testObject.setAge(18);
        testObject.setBirthday(new Date());
        return testObject;
    }
    private TestObject createTestObject(String id, String name, Integer age, Date birthday) {
        TestObject testObject = new TestObject();
        testObject.setId((Objects.nonNull(id) ? id : "TEST_ID_001"));
        testObject.setName((Objects.nonNull(name) ? name : "TEST太郎"));
        testObject.setAge((Objects.nonNull(age) ? age : 18));
        testObject.setBirthday((Objects.nonNull(birthday) ? birthday : new Date()));
        return testObject;
    }

    private String atatchQuote(String targetString, QUOTE quote) {
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
}
