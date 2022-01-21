
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        HomeTask2(sessionFactory.openSession());
        HomeTask1(sessionFactory.openSession());

        sessionFactory.close();
    }

    public static void HomeTask1(Session session) {
        Course course;
        for (int i  = 1; i <= 45; i++) {
            course = session.get(Course.class, i);
            System.out.println(i + " - course name: " + course.getName() + " - " + course.getStudentsCount() + " students, teacher name is " + course.getTeacher().getName());
            List<Student> students = course.getStudents();
            for (Student student : students) {
                System.out.println(student.getName() + " - " + student.getRegistrationDate());
            }
        }

        session.clear();
        session.close();
    }

    public static void HomeTask2(Session session) {
        PurchaseList list = session.get(PurchaseList.class, 1);
        System.out.println(list.getCourseName() + " " + list.getPrice());

        session.clear();
        session.close();
    }
}
