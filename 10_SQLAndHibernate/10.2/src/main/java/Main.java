
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {


    public static void main(String[] args) {

        SessionFactory sessionFactory = Hibernate.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            int i = 1;
            while (i < 46) {

                Course courses = session.get(Course.class, i++);
                System.out.println(courses.getName() + " - " + courses.getStudentsCount());
                if (courses == null) {
                    break;
                }
            }


        } catch (Exception exception) {
            System.out.println("\\n");
        }

        Hibernate.enough();
    }
}


