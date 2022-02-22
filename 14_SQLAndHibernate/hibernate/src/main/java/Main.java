
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        String sqlQuery = "insert into LinkedPurchaseList(student_id, course_id)" +
                         " select Students.id, Courses.id from Courses" +
                         " join Subscriptions ON Subscriptions.course_id = Courses.id" +
                         " join Students ON Students.id = Subscriptions.student_id;";

        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();
//        String hql = "from Course course";
//        List<Course> courses = session.createQuery(hql).getResultList();
//        System.out.println(courses.size());
//
//        for(Course course : courses) {
//            List<Student> students = course.getStudents();
//            for (Student student : students) {
//                LinkedPurchaseList list = new LinkedPurchaseList();
//                list.setKey(new Key(student.getId(), course.getId()));
//                session.save(list);
//            }
//        }
//
        String hql = "from PurchaseList";
        List<PurchaseList> list = session.createQuery(hql).getResultList();

        for (PurchaseList qq : list) {
            LinkedPurchaseList link = new LinkedPurchaseList();

            Query query = session.createQuery("from Student where name = :studentName");
            query.setParameter("studentName", qq.getStudentName());

            Query query1 = session.createQuery("from Course where name = :courseName");
            query1.setParameter("courseName", qq.getCourseName());

            link.setKey(new Key(((Student) query.getSingleResult()).getId(), ((Course) query1.getSingleResult()).getId()));
            session.save(link);
        }

        ts.commit();
        session.clear();
        session.close();
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

    public static void Task3(Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root)
                .where(builder.greaterThan(root.get("price"), 100_000))
                .orderBy(builder.desc(root.get("price")));
        List<Course> test = session.createQuery(query).setMaxResults(5).getResultList();
        for (Course course : test) {
            System.out.println(course.getName() + " - " + course.getPrice());
        }

        session.clear();
        session.close();
    }
}
