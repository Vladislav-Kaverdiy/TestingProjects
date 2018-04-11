package database.frames;

import bean.Worker;
import exception.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface FrameWorker {
    void addWorkers(Worker worker) throws DBException;
    List<Worker> getWorkerByDepartmentId(int workerId) throws DBException;
    Worker findWorkerById(int workerId) throws DBException;
    void updateWorker(Worker worker) throws DBException;
    void deleteWorkerById(int workerId) throws DBException;
    Worker extractWorker(ResultSet rs) throws SQLException;

}
