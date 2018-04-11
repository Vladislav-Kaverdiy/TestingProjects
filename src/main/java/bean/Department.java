package bean;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class Department {
    @NotEmpty(message = "Department id cannot be empty!")
    private Integer departmentId;

    @NotEmpty(message = "Full Name cannot be empty!")
    @Size(min = 3, max = 15, message = "The size must be greater than 3 and less than 15!")
    @Pattern(regexp = "^[a-zA-Z0-9_-]")
    private String fullName;

    @NotEmpty(message = "Importance cannot be empty!")
    private Integer importance;

    @NotEmpty
    @Past
    private Date registerDate;


    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getFullName() {
        return fullName;
    }



    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", fullName='" + fullName + '\'' +
                ", importance=" + importance +
                ", registerDate=" + registerDate +
                '}';
    }
}
