package servlets.commands.workers;

import database.dao.WorkerDao;
import database.frames.FrameWorker;
import exception.AppException;
import bean.Worker;
import servlets.Path;
import servlets.commands.Command;
import servlets.commands.CommandContainer;
import servlets.commands.CommandTypes;
import servlets.validators.WorkerValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditWorker implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {

        List<String> errors = new WorkerValidator().validate(request);// check validators
        if (errors.size() != 0) {
            setValidateParameters(request);
            request.setAttribute("errors", errors);
            return Path.EDIT_WORKER_PAGE;
        }

        FrameWorker frameWorker = new WorkerDao();

        Integer workerId = Integer.parseInt(request.getParameter("workerId"));

        Worker worker = frameWorker.findWorkerById(workerId);
        worker.setFirstName(request.getParameter("firstName"));
        worker.setLastName(request.getParameter("lastName"));
        worker.setAge(Integer.valueOf(request.getParameter("age")));
        worker.setEmail(request.getParameter("email"));
        worker.setPhone(request.getParameter("phone"));
        frameWorker.updateWorker(worker);
        return CommandContainer.get(CommandTypes.MANAGE_DEPARTMENT).execute(request, response);
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
