package servlets.hibernateValidators;


import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WorkerValidator {

    public List<String> validate(HttpServletRequest request){

        List<String> errors = new ArrayList<>();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator= validatorFactory.getValidator();

        //////////////////firstName//////////////////////////////////

        String firstName = request.getParameter("firstName");
        Set<ConstraintViolation<String>> constraintViolations = validator.validate(firstName);

        for(ConstraintViolation<String> constraintViolation: constraintViolations){

            StringBuilder stringBuilder = new StringBuilder("property Worker firstName: ");
            stringBuilder.append(constraintViolation.getPropertyPath());
            stringBuilder.append(constraintViolation.getInvalidValue());
            stringBuilder.append(constraintViolation.getMessage());

            errors.add(constraintViolation.getMessage());
        }

        //////////////////lastName//////////////////////////////////

        String lastName = request.getParameter("lastName");
        Set<ConstraintViolation<String>> constraintViolations2 = validator.validate(lastName);

        for(ConstraintViolation<String> constraintViolation2: constraintViolations2){

            StringBuilder stringBuilder = new StringBuilder("property Worker lastName: ");
            stringBuilder.append(constraintViolation2.getPropertyPath());
            stringBuilder.append(constraintViolation2.getInvalidValue());
            stringBuilder.append(constraintViolation2.getMessage());

            errors.add(constraintViolation2.getMessage());
        }

        //////////////////age//////////////////////////////////

        String age = request.getParameter("age");
        Set<ConstraintViolation<String>> constraintViolations3 = validator.validate(age);

        for(ConstraintViolation<String> constraintViolation3: constraintViolations3){

            StringBuilder stringBuilder = new StringBuilder("property Worker age: ");
            stringBuilder.append(constraintViolation3.getPropertyPath());
            stringBuilder.append(constraintViolation3.getInvalidValue());
            stringBuilder.append(constraintViolation3.getMessage());

            errors.add(constraintViolation3.getMessage());
        }

        //////////////////email//////////////////////////////////

        String email = request.getParameter("email");
        Set<ConstraintViolation<String>> constraintViolations4 = validator.validate(email);

        for(ConstraintViolation<String> constraintViolation4: constraintViolations4){

            StringBuilder stringBuilder = new StringBuilder("property Worker email: ");
            stringBuilder.append(constraintViolation4.getPropertyPath());
            stringBuilder.append(constraintViolation4.getInvalidValue());
            stringBuilder.append(constraintViolation4.getMessage());

            errors.add(constraintViolation4.getMessage());
        }

        //////////////////phone//////////////////////////////////

        String phone = request.getParameter("phone");
        Set<ConstraintViolation<String>> constraintViolations5 = validator.validate(phone);

        for(ConstraintViolation<String> constraintViolation5: constraintViolations5){

            StringBuilder stringBuilder = new StringBuilder("property Worker phone: ");
            stringBuilder.append(constraintViolation5.getPropertyPath());
            stringBuilder.append(constraintViolation5.getInvalidValue());
            stringBuilder.append(constraintViolation5.getMessage());

            errors.add(constraintViolation5.getMessage());
        }

        return  errors;
    }

}