package com.aldi.hibernate;

import com.aldi.hibernate.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("creating new student object...");

            Student student = new Student("Piero", "Ashady", "piero@gmail.com");
            Student student2 = new Student("Fajar", "Ashady", "fajar@gmail.com");
            Student student3 = new Student("Zikri", "Ashady", "zikri@gmail.com");

            session.beginTransaction();

            session.save(student);
            // session.save(student2);
            // session.save(student3);

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            // student = session.get(Student.class, student.getId());
            student = session.get(Student.class, 3);

            System.out.println(student.getId() + " " + student.getFirstName());

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
