package ksaito.testJava11Gradle.userBeans;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class InputCSVBean extends BaseBean{
    @CsvBindByName(column = "col1", required = false)
    private String id;
    @CsvBindByName(column = "col2", required = false)
    private String firstName;
    @CsvBindByName(column = "col3", required = false)
    private String lastName;
    @CsvBindByName(column = "col4", required = false)
    private String sex;
}
