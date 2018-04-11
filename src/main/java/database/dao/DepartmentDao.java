package database.dao;
import database.DBFields;
import database.manager.DBManager;
import database.DBQueries;
import database.manager.DB;
import database.frames.FrameDepartment;
import exception.DBException;
import exception.Messages;
import bean.Department;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao implements FrameDepartment {

    private static DB db = new DBManager();
    private static final Logger LOG = Logger.getLogger(DB.class);

    public List<Department> getDepartments() throws DBException {
        List<Department> departments = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(DBQueries.SQL_FIND_ALL_DEPARTMENTS);
            while (rs.next()) {
                departments.add(extractDepartment(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_DEPARTMENTS, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_DEPARTMENTS, ex);
        } finally {
            db.close(con, stmt, rs);
        }
        return departments;
    }

    public Department createDepartment(Department department) throws DBException {
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_INSERT_DEPARTMENT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, department.getFullName());
            pstmt.setString(2, String.valueOf(department.getImportance()));
            pstmt.setDate(3, new java.sql.Date(department.getRegisterDate().getTime()));
            int result = pstmt.executeUpdate();
            if (result > 0) {
                LOG.trace("-- Department inserted -->" + department.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_CREATE_DEPARTMENT
                        + department.toString());
            }
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                department.setDepartmentId(generatedKeys.getInt(1));
            }
            con.commit();
            return department;
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_CREATE_DEPARTMENT, ex);
           throw new DBException(Messages.ERR_CANNOT_CREATE_DEPARTMENT, ex);
        } finally {
            db.close(con);
            db.close(pstmt);
        }
    }
    public Department findDepartmentById(int departmentId) throws DBException {
        Department department = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_FIND_DEPARTMENTS_BY_ID);
            pstmt.setInt(1, departmentId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                department = extractDepartment(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_DEPARTMENT_BY_ID, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_DEPARTMENT_BY_ID,
                    ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return department;
    }
    public void deleteDepartmentById(int departmentId) throws DBException {
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_DELETE_DEPARTMENT_BY_DEPARTMENT_ID);
            pstmt.setInt(1, departmentId);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_DELETE_DEPARTMENT, ex);
            throw new DBException(ex.getMessage(),
                    ex);
        } finally {
            db.close(con, pstmt);
        }
    }

    public void updateDepartment(Department department) throws DBException {

        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_DEPARTMENT);
            int counter = 1;
            pstmt.setString(counter++, department.getFullName());
            pstmt.setString(counter++, String.valueOf(department.getImportance()));
            pstmt.setInt(counter++, department.getDepartmentId());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_UPDATE_DEPARTMENT, ex);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_DEPARTMENT, ex);
        } finally {
            db.close(con, pstmt);
        }
    }

    public Department extractDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setDepartmentId(rs.getInt(DBFields.DEPARTMENT_ID));
        department.setFullName(rs.getString(DBFields.DEPARTMENT_FULL_NAME));
        department.setImportance(rs.getInt(DBFields.IMPORTANCE));
        department.setRegisterDate(rs.getDate(DBFields.REGISTER_DATE));

        return department;
    }

}
