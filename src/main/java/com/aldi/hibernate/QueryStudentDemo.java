package com.aldi.hibernate;

import java.util.List;

import com.aldi.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("creating new student object...");

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            for (Student student : students) {
                System.out.println(student.getEmail());
            }

            List<Student> students2 = session.createQuery("from Student s where s.lastName='Ashady'").getResultList();

            for (Student student : students2) {
                System.out.println(student.getLastName());
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
            factory.close();
        } finally {
            factory.close();
        }
    }
}
