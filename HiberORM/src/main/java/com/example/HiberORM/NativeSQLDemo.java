package com.example.HiberORM;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.example.HiberORM.model.Employee;
import com.example.HiberORM.util.HibernateUtil;

public class NativeSQLDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE
//        String insertq = "INSERT INTO Employee (name, email) VALUES (?, ?)";
//        NativeQuery<?> insert = session.createNativeQuery(insertq);
//        insert.setParameter(1, "Madan");
//        insert.setParameter(2, "madan@example.com");
//        insert.executeUpdate();



    

//        // UPDATE (update email by id)
//        String updateQuery = "UPDATE Employee SET email=? WHERE id=?";
//        NativeQuery<?> update = session.createNativeQuery(updateQuery);
//        update.setParameter(1, "newemail@example.com");
//        update.setParameter(2, 22); // id = 22
//        update.executeUpdate();
//
//        // DELETE (delete employee by id)
        String deleteQuery = "DELETE FROM Employee WHERE id=?";
        NativeQuery<?> delete = session.createNativeQuery(deleteQuery);
        delete.setParameter(1, 23); // id = 23
        delete.executeUpdate();
        System.out.println("Data is delted");

        
        // READ
        String selectQuery = "SELECT * FROM Employee";
        NativeQuery<Object[]> select = session.createNativeQuery(selectQuery, Object[].class);
        for (Object[] row : select.list()) {
            System.out.println("ID: " + row[0] + ", Name: " + row[2] + ", Email: " + row[1]);
        }
        tx.commit();
        session.close();
    }
}