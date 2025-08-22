/*package com.example.hiborm;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.example.hiborm.model.Employee;
import com.example.hiborm.util.HibernateUtil;

public class NativeSql{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        tx = session.beginTransaction();

        System.out.println("\n===== Employee Operations=====");
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
                    NativeQuery<Employee> selectQuery =session.createNativeQuery("SELECT * FROM employee", Employee.class);
                    List<Employee> employees = selectQuery.list();

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

                    NativeQuery<Employee> insertQuery =session.createNativeQuery("INSERT INTO employee(name, email) VALUES(:name, :email)");
                    insertQuery.setParameter("name", name);
                    insertQuery.setParameter("email", email);

                    int insertedRow = insertQuery.executeUpdate();
                    System.out.println("Employee data inserted successfully!"+ insertedRow);
                    break;

                    
            case 3: // Update
                    System.out.print("Enter employee ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    NativeQuery<Employee> updateQuery =session.createNativeQuery("UPDATE employee SET name = :name WHERE id = :id");
                    updateQuery.setParameter("name", newName);
                    updateQuery.setParameter("id", updateId);

                    int updatedRow = updateQuery.executeUpdate();
                    System.out.println("Employee data updated: " + updatedRow);
                    break;

            case 4: // Delete
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = sc.nextInt();

                    NativeQuery<Employee> deleteQuery =session.createNativeQuery("DELETE FROM employee WHERE id = :id");
                    deleteQuery.setParameter("id", deleteId);

                    int deletedRow = deleteQuery.executeUpdate();
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

import com.example.hiborm.model.Employee;
import com.example.hiborm.util.HibernateUtil;

public class NativeSql{
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // CREATE
        Transaction tx = session.beginTransaction();
        session.createNativeQuery("INSERT INTO employee (name, email) VALUES ('Bob', 'bob@example.com')")
                .executeUpdate();
        tx.commit();
        System.out.println("Employee Inserted via Native SQL");

        // READ
        List<Employee> employees = session.createNativeQuery("SELECT * FROM employee", Employee.class)
                .getResultList();
        employees.forEach(System.out::println);

        // UPDATE
        tx = session.beginTransaction();
        session.createNativeQuery("UPDATE employee SET email = 'bob.updated@example.com' WHERE name = 'Bob'")
                .executeUpdate();
        tx.commit();
        System.out.println("Employee Updated via Native SQL");

        // READ again
        employees = session.createNativeQuery("SELECT * FROM employee", Employee.class)
                .getResultList();
        employees.forEach(System.out::println);

        // DELETE
        tx = session.beginTransaction();
        session.createNativeQuery("DELETE FROM employee WHERE name = 'Bob'")
                .executeUpdate();
        tx.commit();
        System.out.println("Employee Deleted via Native SQL");

        session.close();
        HibernateUtil.close();
    }
}
