package servlets.commands.commandsShow.worker;

import exception.AppException;
import servlets.Path;
import servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowWorker implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        request.setAttribute("departmentId",request.getParameter("departmentId"));
        return Path.ADD_WORKER_PAGE;
    }
}
