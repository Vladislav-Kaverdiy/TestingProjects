package servlets.commands.departments;

import database.dao.DepartmentDao;
import database.frames.FrameDepartment;
import exception.AppException;
import exception.Messages;
import bean.Department;
import org.apache.log4j.Logger;
import servlets.Path;
import servlets.commands.Command;
import servlets.validators.DepartmentValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class CreateDepartment implements Command {
    private static final Logger LOG = Logger.getLogger(CreateDepartment.class);
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,
            AppException {
        LOG.debug("Command starts");
        try {

            List<String> errors = new DepartmentValidator().validate(request);// check validators
            if (errors.size() != 0) {
                setValidateParameters(request);
                request.setAttribute("errors", errors);
                return Path.CREATE_DEPARTMENT;
            }

            Department department = new Department();
            department.setFullName(request.getParameter("fullName"));
            department.setImportance(Integer.valueOf((request.getParameter("importance"))));
            department.setRegisterDate(new Date());

            LOG.trace("Get request parameters and department--> "
                    + department.toString());
            FrameDepartment frameDepartment =  new DepartmentDao();
            frameDepartment.createDepartment(department);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_CREATE_DEPARTMENT, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_CREATE_DEPARTMENT);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.ERROR_PAGE;
        }

        LOG.debug("Command finished");

        return Path.COMMAND_MANAGE_DEPARTMENT;
    }
    public HttpServletRequest setValidateParameters(HttpServletRequest request) {
        request.setAttribute("fullName", request.getParameter("fullName"));
        request.setAttribute("importance", request.getParameter("importance"));
        return request;
    }}
