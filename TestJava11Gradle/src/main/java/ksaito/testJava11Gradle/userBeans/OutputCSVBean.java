package ksaito.testJava11Gradle.userBeans;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class OutputCSVBean extends BaseBean{
    private String id;
    private String firstName;
    private String lastName;
    private String sex;
}
