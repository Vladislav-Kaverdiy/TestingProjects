package servlets.hibernateValidators;

import bean.Department;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class DepartmentValidator {

    public List<String> validate(HttpServletRequest request){
        List<String> errors = new ArrayList<>();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator= validatorFactory.getValidator();


        String fullName = request.getParameter("fullName");
        Set<ConstraintViolation<String>> constraintViolations = validator.validate(fullName);

        for(ConstraintViolation<String> constraintViolation: constraintViolations){

            StringBuilder stringBuilder = new StringBuilder("property Department fullName: ");
            stringBuilder.append(constraintViolation.getPropertyPath());
            stringBuilder.append(constraintViolation.getInvalidValue());
            stringBuilder.append(constraintViolation.getMessage());

            errors.add(constraintViolation.getMessage());
        }

        String importance = request.getParameter("importance");
        Set<ConstraintViolation<String>> constraintViolations2 = validator.validate(importance);

        for(ConstraintViolation<String> constraintViolation2: constraintViolations2){

        StringBuilder stringBuilder = new StringBuilder("property Department importance: ");
        stringBuilder.append(constraintViolation2.getPropertyPath());
        stringBuilder.append(constraintViolation2.getInvalidValue());
        stringBuilder.append(constraintViolation2.getMessage());

        errors.add(constraintViolation2.getMessage());
        }


    return  errors;
    }

}