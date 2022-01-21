import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
