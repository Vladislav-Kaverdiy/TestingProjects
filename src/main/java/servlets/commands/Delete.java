package servlets.commands;

import database.dao.DepartmentDao;
import database.dao.WorkerDao;
import database.frames.FrameDepartment;
import database.frames.FrameWorker;
import exception.AppException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Delete implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {

        Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));

        if (departmentId > 0) {

            Integer.parseInt(request.getParameter("departmentId"));

            FrameDepartment frameDepartment = new DepartmentDao();
            frameDepartment.deleteDepartmentById(departmentId);


        } else {

            Integer workerId = Integer.parseInt(request.getParameter("workerId"));

            FrameWorker frameWorker = new WorkerDao();
            frameWorker.deleteWorkerById(workerId);


        }
        return CommandContainer.get(CommandTypes.MANAGE_DEPARTMENT).execute(request, response);
    }
}