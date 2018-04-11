package database.frames;

import bean.Department;
import exception.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface FrameDepartment {

      List<Department> getDepartments() throws DBException ;
      Department createDepartment(Department department) throws DBException;
      Department findDepartmentById(int departmentId) throws DBException;
      void deleteDepartmentById(int departmentId) throws DBException;
      void updateDepartment(Department department) throws DBException;
      Department extractDepartment(ResultSet rs) throws SQLException;

}

