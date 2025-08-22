/*package com.example.hiborm;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.hiborm.model.Employee;
import com.example.hiborm.util.HibernateUtil;

public class Hql{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;


        tx = session.beginTransaction();

        System.out.println("\n===== Employee Operations =====");
        System.out.println("1. View All Employees");
        System.out.println("2. Insert Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) 
        {
            case 1: // View all employees
	             	Query<Employee> query1 = session.createQuery("FROM Employee", Employee.class);
	                List<Employee> employees = query1.list();
	                
	                System.out.println("\n		===== Employee List =====\n");
	                for (Employee e : employees) {
	                    System.out.println(e.toString());
	                }
	                break;


            case 2: // Insert
                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter employee email: ");
                    String email = sc.nextLine();

                    Employee emp = new Employee();
                    emp.setName(name);
                    emp.setEmail(email);
                    session.save(emp);

                    System.out.println("Employee data inserted successfully!");
                    break;

                    
            case 3: // Update
                    System.out.print("Enter employee ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    String hqlUpdate = "UPDATE Employee SET name = :name WHERE id = :id";
                    Query<Employee> query2 = session.createQuery(hqlUpdate);
                    query2.setParameter("name", newName);
                    query2.setParameter("id", updateId);

                    int updatedRow = query2.executeUpdate();
                    System.out.println("Employee data updated: " + updatedRow);
                    break;
                    

            case 4: // Delete
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = sc.nextInt();

                    String hqlDelete = "DELETE FROM Employee WHERE id = :id";
                    Query<Employee> query3 = session.createQuery(hqlDelete);
                    query3.setParameter("id", deleteId);

                    int deletedRow = query3.executeUpdate();
                    System.out.println("Employee data deleted: " + deletedRow);
                    break;

            default:
                    System.out.println("Invalid choice.");
        }

        tx.commit();
        session.close();
    }
}*/
package com.example.hiborm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.hiborm.model.Employee;
import com.example.hiborm.util.HibernateUtil;

public class Hql {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // CREATE
        Transaction tx = session.beginTransaction();
        Employee emp = new Employee("Alice", "alice@example.com");
        session.persist(emp);
        tx.commit();
        System.out.println("Employee Created: " + emp);

        // READ
        Employee eData = session.get(Employee.class, emp.getId());
        System.out.println("Fetched Employee: " + eData);

        // UPDATE
        tx = session.beginTransaction();
        Query<?> updateQuery = session.createQuery("UPDATE Employee SET email = :email WHERE id = :id");
        updateQuery.setParameter("email", "alice.updated@example.com");
        updateQuery.setParameter("id", emp.getId());
        int updated = updateQuery.executeUpdate();
        tx.commit();
        System.out.println("Updated rows: " + updated);

        // READ ALL
        Query<Employee> allQuery = session.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = allQuery.getResultList();
        employees.forEach(System.out::println);

        // DELETE
        tx = session.beginTransaction();
        Query<?> deleteQuery = session.createQuery("DELETE FROM Employee WHERE id = :id");
        deleteQuery.setParameter("id", emp.getId());
        int deleted = deleteQuery.executeUpdate();
        tx.commit();
        System.out.println("Deleted rows: " + deleted);

        session.close();
        HibernateUtil.close();
    }
}
