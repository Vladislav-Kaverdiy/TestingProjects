package database.dao;

import database.DBFields;
import database.manager.DBManager;
import database.DBQueries;
import database.manager.DB;
import database.frames.FrameWorker;
import exception.DBException;
import exception.Messages;
import bean.Worker;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerDao implements FrameWorker {
    private DB db = new DBManager();
    private static final Logger LOG = Logger.getLogger(WorkerDao.class);

    public void addWorkers(Worker worker) throws DBException {
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_INSERT_WORKER);
            pstmt.setString(1, worker.getFirstName());
            pstmt.setString(2, worker.getLastName());
            pstmt.setInt(3, worker.getAge());
            pstmt.setString(4, worker.getEmail());
            pstmt.setString(5, worker.getPhone());
            pstmt.setDate(6, new java.sql.Date(worker.getRegisterDate().getTime()));
            pstmt.setInt(7, worker.getDepartmentId());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                LOG.trace("-- Worker inserted -->" + worker.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_ADD_WORKER
                        + worker.toString());
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_ADD_WORKER, ex);
            throw new DBException(Messages.ERR_CANNOT_ADD_WORKER, ex);
        } finally {
            db.close(con);
            db.close(pstmt);
        }
    }
    public List<Worker> getWorkerByDepartmentId(int workerId)
            throws DBException {
        List<Worker> workers = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con
                    .prepareStatement(DBQueries.SQL_FIND_ALL_WORKERS_BY_DEPARTMENT_ID);
            pstmt.setInt(1, workerId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                workers.add(extractWorker(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_WORKER_BY_DEPARTMENT_ID, ex);
            throw new DBException(
                    Messages.ERR_CANNOT_OBTAIN_WORKER_BY_DEPARTMENT_ID, ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return workers;
    }

    public Worker findWorkerById(int workerId) throws DBException {
        Worker worker = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_FIND_WORKER_BY_ID);
            pstmt.setInt(1, workerId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                worker = extractWorker(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_WORKER_BY_ID, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_WORKER_BY_ID,
                    ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return worker;
    }

    public void updateWorker(Worker worker) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            db.getInstance();
            con = db.getConnection();

            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_WORKER);
            int k = 1;
            pstmt.setString(k++, worker.getFirstName());
            pstmt.setString(k++, worker.getLastName());
            pstmt.setInt(k++, worker.getAge());
            pstmt.setString(k++, worker.getEmail());
            pstmt.setString(k++, worker.getPhone());
            pstmt.setInt(k++, worker.getWorkerId());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_UPDATE_WORKER, ex);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_WORKER, ex);
        } finally {
            db.close(con, pstmt);
        }
    }
    public void deleteWorkerById(int workerId) throws DBException {

        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_DELETE_WORKER_BY_WORKER_ID);
            pstmt.setInt(1, workerId);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_DELETE_WORKER, ex);
            throw new DBException(Messages.ERR_CANNOT_DELETE_WORKER,
                    ex);
        } finally {
            db.close(con, pstmt);
        }
    }

        public  Worker extractWorker(ResultSet rs) throws SQLException {
        Worker worker = new Worker();
        worker.setWorkerId(rs.getInt(DBFields.WORKER_ID));
        worker.setFirstName(rs.getString(DBFields.WORKER_FIRST_NAME));
        worker.setLastName(rs.getString(DBFields.WORKER_LAST_NAME));
        worker.setAge(rs.getInt(DBFields.AGE));
        worker.setEmail(rs.getString(DBFields.EMAIL));
        worker.setPhone(rs.getString(DBFields.PHONE_NUMBER));
        worker.setRegisterDate(rs.getDate(DBFields.REGISTER_DATE));
        worker.setDepartmentId(rs.getInt(DBFields.DEPARTMENT_ID));
        return worker;
    }
}
