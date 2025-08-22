package com.example.HiberORM;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.HiberORM.model.Employee;
import com.example.HiberORM.util.HibernateUtil;

public class HQLDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE (use entity object)
//        Employee s = new Employee("Shamshad","shamsha@gmail.com");
//        session.save(s);

        
        // UPDATE
//        String hqlUpdate = "UPDATE Employee SET email = :email WHERE id = :id";
//        Query<?> update = session.createQuery(hqlUpdate);
//        update.setParameter("email", "mdaarifraza03@gmail.com");
//        update.setParameter("id", 1);
//        update.executeUpdate();

        // DELETE
        String hqlDelete = "DELETE FROM Employee WHERE id = :id";
        Query<?> delete = session.createQuery(hqlDelete);
        delete.setParameter("id", 26);
        delete.executeUpdate();
        
        
     // READ
        String hqlSelect = "FROM Employee";
        Query<Employee> query = session.createQuery(hqlSelect, Employee.class);
        for (Employee emp : query.list()) {
            System.out.println(emp.getId()+" "+emp.getName() + " " + emp.getEmail());
        }


        tx.commit();
        session.close();
    }
}