package bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class Worker {
    @NotEmpty(message = "Worker id cannot be empty!")
    private Integer workerId;

    @NotEmpty(message = "First Name cannot be empty!")
    @Size(min = 3, max = 15, message = "The size must be greater than 3 and less than 15!")
    @Pattern(regexp = "^[a-zA-Z0-9_-]")
    private String firstName;

    @NotEmpty(message = "Last Name cannot be empty!")
    @Size(min = 3, max = 15, message = "The size must be greater than 3 and less than 15!")
    @Pattern(regexp = "^[a-zA-Z0-9_-]")
    private String lastName;

    @NotEmpty(message = "Age cannot be empty!")
    private Integer age;

    @NotEmpty(message = "Email cannot be empty!")
    @Email(message = "Your email address is invalid!(You have to enter for example ****@mail/gmail.ru/com)")
    private String email;

    @NotEmpty(message = "Phone cannot be empty!")
    @Pattern(regexp ="^\\+?([0-9]{2})?\\(?[0-9]{3}\\)?[0-9]{3}\\-?[0-9]{2}\\-?[0-9]{2}$", message = "Your Phone is invalid!(You have to enter for example 380*********)")
    private String phone;

    @Past
    private Date registerDate;

    private Integer departmentId;

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId=" + workerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registerDate=" + registerDate +
                ", departmentId=" + departmentId +
                '}';
    }
}
