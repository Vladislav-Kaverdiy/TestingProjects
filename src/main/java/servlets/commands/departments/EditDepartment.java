package servlets.commands.departments;

import database.dao.DepartmentDao;
import database.frames.FrameDepartment;
import exception.AppException;
import bean.Department;
import servlets.Path;
import servlets.commands.Command;
import servlets.commands.CommandContainer;
import servlets.commands.CommandTypes;
import servlets.validators.DepartmentValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditDepartment implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {

        List<String> errors = new DepartmentValidator().validate(request);// check validators
        if (errors.size() != 0) {
            setValidateParameters(request);
            request.setAttribute("errors", errors);
            return Path.EDIT_DEPARTMENT;
        }

        FrameDepartment frameDepartment =  new DepartmentDao();
        Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));

        Department department = frameDepartment.findDepartmentById(departmentId);
        department.setFullName(request.getParameter("fullName"));
        department.setImportance(Integer.valueOf((request.getParameter("importance"))));
        frameDepartment.updateDepartment(department);



        return CommandContainer.get(CommandTypes.MANAGE_DEPARTMENT).execute(request, response);
        }

        public HttpServletRequest setValidateParameters(HttpServletRequest request) {

        request.setAttribute("fullName", request.getParameter("fullName"));
        request.setAttribute("importance", request.getParameter("importance"));
        return request;
    }
}

