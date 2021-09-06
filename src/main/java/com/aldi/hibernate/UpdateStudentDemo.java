package com.aldi.hibernate;

import java.util.List;

import com.aldi.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            student.setFirstName("Rizqi");

            session.getTransaction().commit();

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
            factory.close();
        } finally {
            factory.close();
        }
    }
}
