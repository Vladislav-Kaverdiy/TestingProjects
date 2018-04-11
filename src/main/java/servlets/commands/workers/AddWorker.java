package servlets.commands.workers;

import database.dao.WorkerDao;
import database.frames.FrameWorker;
import exception.AppException;
import exception.Messages;
import bean.Worker;
import servlets.Path;
import servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import servlets.validators.WorkerValidator;

public class AddWorker implements Command {
    private static final Logger LOG = Logger.getLogger(AddWorker.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {

        LOG.debug("Command starts");
        try {

            List<String> errors = new WorkerValidator().validate(request);// check validators
            if (errors.size() != 0) {
                setValidateParameters(request);
                request.setAttribute("errors", errors);
                return Path.ADD_WORKER;
            }

            Worker worker = new Worker();
            worker.setFirstName(request.getParameter("firstName"));
            worker.setLastName(request.getParameter("lastName"));
            worker.setAge(Integer.valueOf(request.getParameter("age")));
            worker.setEmail(request.getParameter("email"));
            worker.setPhone(request.getParameter("phone"));
            worker.setRegisterDate(new Date());
            worker.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));

            LOG.trace("Get request parameters and crete worker--> "
                    + worker.toString());
            FrameWorker frameWorker = new WorkerDao();
            frameWorker.addWorkers(worker);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_ADD_WORKER, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_ADD_WORKER);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.ERROR_PAGE;
        }

        LOG.debug("Command finished");

        return Path.COMMAND_MANAGE_WORKER;
    }
    public HttpServletRequest setValidateParameters(HttpServletRequest request) {
        request.setAttribute("firstName", request.getParameter("firstName"));
        request.setAttribute("lastName", request.getParameter("lastName"));
        request.setAttribute("age", request.getParameter("age"));
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("phone", request.getParameter("phone"));
        return request;
    }
}
