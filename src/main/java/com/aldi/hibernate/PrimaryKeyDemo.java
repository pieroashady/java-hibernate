package com.aldi.hibernate;

import java.util.Date;
import java.util.List;

import com.aldi.hibernate.entity.Student;
import com.aldi.hibernate.utils.DateUtils;

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

            String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

            Student student = new Student("Piero", "Ashady", "piero@gmail.com", theDateOfBirth);
            Student student2 = new Student("Fajar", "Ashady", "fajar@gmail.com", theDateOfBirth);
            Student student3 = new Student("Zikri", "Ashady", "zikri@gmail.com", theDateOfBirth);

            session.beginTransaction();

            session.save(student);
            // session.save(student2);
            // session.save(student3);

            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            // student = session.get(Student.class, student.getId());
            // student = session.get(Student.class, 3);
            List<Student> students = session.createQuery("from student").getResultList();

            // System.out.println(student.getId() + " " + student.getFirstName());
            System.out.println(students);

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
