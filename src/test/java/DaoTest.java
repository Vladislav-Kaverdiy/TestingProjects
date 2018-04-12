import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoTest {

    @Test
    public void checkConnectionToDb(){


        Connection con ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zadanie", "root", "KaVeRdIy1996");
            con.setAutoCommit(false);
            con.setTransactionIsolation(2);
            Assert.assertFalse(con.isClosed());
        } catch (Exception ex) {

            Assert.fail();
        }

    }

}
