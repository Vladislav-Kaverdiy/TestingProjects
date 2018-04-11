package database.manager;
import exception.DBException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface DB {

    DBManager getInstance() throws DBException;
    Connection getConnection() throws DBException;
    void close(Connection con);
    void close(Statement stmt);
    void close(ResultSet rs);
    void close(Connection con, Statement stmt);
    void close(Connection con, Statement stmt, ResultSet rs);
    void rollback(Connection con);



}
