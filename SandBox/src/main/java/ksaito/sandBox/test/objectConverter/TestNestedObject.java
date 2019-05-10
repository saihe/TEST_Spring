package ksaito.sandBox.test.objectConverter;

public class TestNestedObject {
    private String id;
    private int number;
    private boolean flag;
    private TestObject testObject;
    private TestSecondNestedObject testSecondNestedObject;

    public boolean isFlag() {
        return flag;
    }
    public TestSecondNestedObject getTestSecondNestedObject() {
        return testSecondNestedObject;
    }
    public void setTestSecondNestedObject(TestSecondNestedObject testSecondNestedObject) {
        this.testSecondNestedObject = testSecondNestedObject;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public boolean getFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public TestObject getTestObject() {
        return testObject;
    }
    public void setTestObject(TestObject testObject) {
        this.testObject = testObject;
    }
}
