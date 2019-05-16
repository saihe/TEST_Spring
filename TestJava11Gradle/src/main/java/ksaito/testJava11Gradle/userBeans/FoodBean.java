package ksaito.testJava11Gradle.userBeans;

import lombok.Data;

@Data
public class FoodBean extends BaseBean{
    private String name;
    private String color;
    public String toString() {
        return super.toString(this);
    }
}
