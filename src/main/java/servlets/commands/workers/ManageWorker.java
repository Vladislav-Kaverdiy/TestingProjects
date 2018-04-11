package servlets.commands.workers;

import database.dao.WorkerDao;
import database.frames.FrameWorker;
import exception.AppException;
import exception.Messages;
import bean.Worker;
import org.apache.log4j.Logger;
import servlets.Path;
import servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManageWorker implements Command {
    private static final Logger LOG = Logger.getLogger(ManageWorker.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException,
            AppException {
        try {
            LOG.debug("Command starts");

            FrameWorker frameWorker = new WorkerDao();
            Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
            List<Worker> worker = frameWorker.getWorkerByDepartmentId(departmentId);

            LOG.trace("Get worker of departmentId--> " + departmentId);
            request.setAttribute("worker", worker);
            request.setAttribute("departmentId", departmentId);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_WORKER_BY_DEPARTMENT_ID, ex);
            request.setAttribute("errorMessage", Messages.ERR_CANNOT_OBTAIN_WORKER_BY_DEPARTMENT_ID);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.ERROR_PAGE;
        }
        LOG.debug("Command finished");
        return Path.PAGE_WORKERS;
    }

}

