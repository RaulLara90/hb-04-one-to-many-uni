package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {


            session.beginTransaction();

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Instractor: " + tempInstructor);
            System.out.println("Courses: " + tempInstructor.getCourses());


            session.getTransaction().commit();
            System.out.println("Done!!!");


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
