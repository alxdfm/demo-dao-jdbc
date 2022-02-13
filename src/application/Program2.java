package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST1: department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TEST2: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST3: department insert ===");
		Department newDepartment = new Department(null, "VSC");
		departmentDao.insert(newDepartment);
		System.out.println("Insert! New id = "+newDepartment.getId());
		
		System.out.println("\n=== TEST4: department update ===");
		department = departmentDao.findById(3);
		department.setName("Chemistry");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST5: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = scan.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete complete!");
		
		scan.close();	
	}

}
