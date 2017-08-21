package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private DataSource dataSource;
	 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
 
    @Override
    public void save(Employee employee) {
        String query = "insert into Emp (empid, name, role, city, country) values (?,?,?,?,?)";
        try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getRole());
            ps.setString(4, employee.getCity());
            ps.setString(5, employee.getCountry());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Emp saved with empid="+employee.getId());
            }else System.out.println("Emp save failed with empid="+employee.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
 
    @Override
    public Employee getById(int id) {
        String query = "select name, role, city, country from Emp where empid = ?";
        Employee emp = null;
        ResultSet rs = null;
        try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                emp = new Employee();
                emp.setId(id);
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                emp.setCity(rs.getString("city"));
                emp.setCountry(rs.getString("country"));
                System.out.println("Emp Found::"+emp);
            }else{
                System.out.println("No Emp found with empid="+id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return emp;
    }
 
    @Override
    public void update(Employee employee) {
        String query = "update Emp set name=?, role=? where empid=?";
        try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getRole());
            ps.setInt(3, employee.getId());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Emp updated with empid="+employee.getId());
            }else System.out.println("No Emp found with empid="+employee.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
 
    @Override
    public void deleteById(int id) {
        String query = "delete from Emp where empid=?";
        try (Connection con = dataSource.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, id);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Emp deleted with empid="+id);
            }else System.out.println("No Emp found with empid="+id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
 
    @Override
    public List<Employee> getAll() {
        String query = "select empid, name, role, city, country from Emp";
        List<Employee> empList = new ArrayList<Employee>();
        ResultSet rs = null;
        try (Connection con = dataSource.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            rs = ps.executeQuery();
            while(rs.next()){
                Employee emp = new Employee();
                emp.setId(rs.getInt("empid"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                emp.setCity(rs.getString("city"));
                emp.setCountry(rs.getString("country"));
                empList.add(emp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return empList;
    }
}