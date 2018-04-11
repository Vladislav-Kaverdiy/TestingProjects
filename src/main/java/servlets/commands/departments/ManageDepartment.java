package servlets.commands.departments;

import database.dao.DepartmentDao;
import database.frames.FrameDepartment;
import exception.AppException;
import exception.Messages;
import bean.Department;
import org.apache.log4j.Logger;
import servlets.Path;
import servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManageDepartment implements Command {
    private Logger LOG = Logger.getLogger(ManageDepartment.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        try {
            LOG.debug("Command starts");
            FrameDepartment frameDepartment =  new DepartmentDao();
            List<Department> department = frameDepartment.getDepartments();
            LOG.trace("Get all departments");
            request.setAttribute("department", department);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_DEPARTMENTS, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_OBTAIN_DEPARTMENTS);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.ERROR_PAGE;
        }
        LOG.debug("Command finished");
        return Path.DEPARTMENT_PAGE;
    }
}