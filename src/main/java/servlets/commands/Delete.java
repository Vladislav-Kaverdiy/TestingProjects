package servlets.commands;

import database.dao.DepartmentDaoDaoImpl;
import database.dao.WorkerDaoDaoImpl;
import database.dao.DepartmentDao;
import database.dao.WorkerDao;
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

            DepartmentDao departmentDao = new DepartmentDaoDaoImpl();
            departmentDao.deleteDepartmentById(departmentId);


        } else {

            Integer workerId = Integer.parseInt(request.getParameter("workerId"));

            WorkerDao workerDao = new WorkerDaoDaoImpl();
            workerDao.deleteWorkerById(workerId);


        }
        return CommandContainer.get(CommandTypes.MANAGE_DEPARTMENT).execute(request, response);
    }
}