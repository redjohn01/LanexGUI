package DBLayer;

import ModelLayer.Employee;
import ModelLayer.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Yeah on 5/8/2017.
 */
public interface IDBEmployee {
    Employee create(String name, String address, String email, String phone, String city,int work_id)throws SQLException;
    Employee read(int id) throws SQLException;
    boolean update(Employee employee,int workId ) throws SQLException;
    boolean delete(int id)throws SQLException;
    ArrayList<Person> readAll() throws SQLException;
}
