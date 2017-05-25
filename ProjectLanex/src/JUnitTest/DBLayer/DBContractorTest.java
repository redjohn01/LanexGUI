package JUnitTest.DBLayer;

import ModelLayer.Contractor;
import org.junit.After;
import org.junit.Test;

import DBLayer.DBConnection;
import DBLayer.DBContractor;

import java.sql.*;
import static org.junit.Assert.*;

/**
 * Created by Admin on 5/5/2017.
 */
public class DBContractorTest {
    DBContractor dbCon;
    Contractor contractor = null;
    boolean isDeleted = false;

    @org.junit.Before
    public void setUp() throws Exception {
        /*try {
            DBCleanup.cleanDB();//TODO fix the cleanDB class
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not clean up the db");
        }*/
        try{
            dbCon = new DBContractor();
            contractor = dbCon.create("test User","Strandja 21","test@gmail.bg","+1121212","MExico",86868686);
        } catch (Exception e){
            System.out.println("Couldn't insert the contractor in the DB");
            fail();
        }
    }

    @After
    public void tearDown() throws Exception {
        if (!isDeleted) {
            try {
                dbCon.delete(getContractorId());
            } catch (Exception e) {
                System.out.println("Couldn't remove the test contractor from the DB");
                fail();
            }
        }
    }


    @org.junit.Test
    public void create() throws Exception {
        try {
            assertNotNull(contractor);
        } catch(Exception e) {
            e.getMessage();
            fail();
        }
    }

    @Test
    public void read() throws Exception { 
        try {
            dbCon.read(86868686);
            assertNotNull(dbCon.read(86868686));
        } catch(Exception e) {
            e.getMessage();
            fail();
        }
    }

    @Test
    public void update() throws Exception { 
        try {
            Contractor contractor = dbCon.read(86868686);
            assertNotNull(dbCon.read(86868686));
            dbCon.update(contractor, 86868686);
        } catch(Exception e) {
            e.getMessage();
            fail();
        }
    }

    @Test
    public void delete() throws Exception {
        try {
            isDeleted = dbCon.delete(getContractorId());
            assertTrue(isDeleted);
        } catch(Exception e) {
            e.getMessage();
            fail();
        }
    }

    @Test
    public void readAll() throws Exception {
        try {
            dbCon.readAll().forEach(x -> {System.out.print(x.toString());});
            assertNotNull(dbCon.readAll());
        } catch(Exception e) {
            e.getMessage();
            fail();
        }
    }

    public int getContractorId() {
        try {
            int currentID;
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = "SELECT TOP 1 id FROM Person ORDER BY id DESC";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                currentID = rs.getInt("id");
                return currentID;
            }
        } catch (Exception e) {
            System.out.println("Couldn't return the current id");
            fail();
        }
        return 0;
    }

}