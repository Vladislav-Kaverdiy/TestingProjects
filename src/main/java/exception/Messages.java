package exception;

public interface Messages {

    // Manipulate Data base errors
    String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
    String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";
    String ERR_CANNOT_CLOSE_RESULT_SET = "Cannot close a result set";
    String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";


    // Manipulate Departments errors
    String ERR_CANNOT_OBTAIN_DEPARTMENT_BY_ID = "Cannot obtain a department by its id";
    String ERR_CANNOT_OBTAIN_DEPARTMENTS = "Cannot obtain departments";
    String ERR_CANNOT_UPDATE_DEPARTMENT = "Cannot update a department";
    String ERR_CANNOT_DELETE_DEPARTMENT = "Cannot delete a department";
    String ERR_CANNOT_CREATE_DEPARTMENT = "Cannot create a department";



    // Manipulate Workers errors
    String ERR_CANNOT_ADD_WORKER = "Cannot insert worker";
    String ERR_CANNOT_OBTAIN_WORKER_BY_ID = "Cannot obtain a worker by id";
    String ERR_CANNOT_OBTAIN_WORKER_BY_DEPARTMENT_ID = "Cannot obtain a worker by department id";
    String ERR_CANNOT_UPDATE_WORKER= "Cannot update a worker";
    String ERR_CANNOT_DELETE_WORKER= "Cannot delete a worker";



}