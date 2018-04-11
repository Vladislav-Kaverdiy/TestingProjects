package servlets;

public interface Path {
    String ERROR_PAGE = "/WEB-INF/jsp/errorPage.jsp";
    String COMMAND_MANAGE_DEPARTMENT = "/servlet.do?command=manageDepartment";
    String PAGE_WORKERS = "/workers.jsp";
    String COMMAND_MANAGE_WORKER = "/servlet.do?command=manageWorker";
    String DEPARTMENT_PAGE = "/departments.jsp";
    String CREATE_DEPARTMENT = "/createDepartment.jsp";
    String ADD_WORKER = "/servlet.do?command=addWorker";
    String EDIT_DEPARTMENT = "/WEB-INF/jsp/department/editDepartment.jsp";
    String EDIT_WORKER_PAGE = "/WEB-INF/jsp/worker/editWorker.jsp";
    String EDIT_DEPARTMENT_PAGE = "/WEB-INF/jsp/department/editDepartment.jsp";
    String DELETE_PAGE = "/WEB-INF/jsp/delete.jsp";
    String ADD_WORKER_PAGE = "/WEB-INF/jsp/worker/addWorker.jsp";



}
