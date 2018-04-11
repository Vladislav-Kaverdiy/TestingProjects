package servlets.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepartmentValidator {

    private static Pattern pattern;
    private static Matcher matcher;

    public List<String> validate(HttpServletRequest request){
        List<String> errors = new ArrayList<>();

        String fullName = request.getParameter("fullName");
        String checkName = "^[a-zA-Z0-9_-]{3,15}$";
        pattern = Pattern.compile(checkName);
        matcher = pattern.matcher(fullName);
        if(fullName == null || fullName.isEmpty()){
            errors.add("Full Name cannot be empty!");
        }
        else  if(!matcher.matches())
        {
            errors.add("Your Full Name is invalid!");
        }

        String importance = request.getParameter("importance");

        if(importance == null || importance.isEmpty()){
            errors.add("Importance cannot be empty!");
        }


        return  errors;
    }


}