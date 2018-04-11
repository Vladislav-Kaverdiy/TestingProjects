package servlets.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkerValidator {
    private static Pattern pattern;
    private static Matcher matcher;

    public List<String> validate(HttpServletRequest request){
        List<String> errors = new ArrayList<>();

        //////////////////firstName//////////////////////////////////

        String firstName = request.getParameter("firstName");
        String checkName = "^[a-zA-Z0-9_-]{3,15}$";
        pattern = Pattern.compile(checkName);
        matcher = pattern.matcher(firstName);
        if(firstName == null || firstName.isEmpty()){
            errors.add("First Name cannot be empty!");
        }
        else  if(!matcher.matches())
        {
            errors.add("Your First Name is invalid!");
        }

        //////////////////lastName//////////////////////////////////

        String lastName = request.getParameter("lastName");
        String checkName1 = "^[a-zA-Z0-9_-]{3,15}$";
        pattern = Pattern.compile(checkName1);
        matcher = pattern.matcher(lastName);
        if(lastName == null || lastName.isEmpty()){
            errors.add("Last Name cannot be empty!");
        }
        else  if(!matcher.matches())
        {
            errors.add("Your Last Name is invalid!");
        }

        //////////////////age//////////////////////////////////

        String age = request.getParameter("age");

        if(age == null || age.isEmpty()){
            errors.add("Age cannot be empty!");
        }

        //////////////////email//////////////////////////////////

        String email = request.getParameter("email");
        String checkEmail = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        pattern = Pattern.compile(checkEmail);
        matcher = pattern.matcher(email);
        if (email == null || email.isEmpty()) {
            errors.add("Email cannot empty!");
        }
        else  if(!matcher.matches()) {
            errors.add("Your email address is invalid!(You have to enter for example ****@mail/gmail.ru/com)");
        }

        //////////////////phone//////////////////////////////////

        String phone = request.getParameter("phone");
        String checkName2 = "^\\+?([0-9]{2})?\\(?[0-9]{3}\\)?[0-9]{3}\\-?[0-9]{2}\\-?[0-9]{2}$";
        pattern = Pattern.compile(checkName2);
        matcher = pattern.matcher(phone);
        if(phone == null || phone.isEmpty()){
            errors.add("Phone cannot be empty!");
        }
        else  if(!matcher.matches())
        {
            errors.add("Your Phone is invalid!(You have to enter for example 380*********)");
        }

        return  errors;
    }

}
