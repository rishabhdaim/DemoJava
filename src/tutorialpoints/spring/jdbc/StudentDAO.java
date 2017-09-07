/**
 * 
 */
package tutorialpoints.spring.jdbc;

import java.util.List;

import tutorialpoints.spring.annotation.Student;
import tutorialpoints.spring.jdbc.tx.StudentMarks;

/**
 * @author Rishabh.Daim
 *
 */
public interface StudentDAO {

	/**
	 * This is the method to be used to create a record in the Student table.
	 */
	public void create(String name, Integer age);

	/**
	 * This is the method to be used to create a record in the Student and Marks
	 * tables.
	 */
	public void create(String name, Integer age, Integer marks, Integer year);
	
	/**
	 * This is the method to be used to create a record in the Student and Marks
	 * tables. Transaction will be managed by AOP
	 */
	public void createAopTx(String name, Integer age, Integer marks, Integer year);

	/**
	 * This is the method to be used to list down a record from the Student
	 * table corresponding to a passed student id.
	 */
	public Student getStudent(Integer id);

	/**
	 * This is the method to be used to list down all the records from the
	 * Student table.
	 */
	public List<Student> listStudents();
	
	/**
	 * This is the method to be used to list down all the records from the
	 * Student & Marks table.
	 */
	public List<StudentMarks> listStudentMarks();

	/**
	 * This is the method to be used to delete a record from the Student table
	 * corresponding to a passed student id.
	 */
	public void delete(Integer id);
	
	
	/**
	 * This is the method used to delete all records from student & marks table
	 */
	public void truncate();

	/**
	 * This is the method to be used to update a record into the Student table.
	 */
	public void update(Integer id, Integer age);
}
