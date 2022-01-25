import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "PurchaseList")
// Я добавил в таблицу PurchaseList еще один столбец count,
// затем заполнил его числами по возрастанию и затем сделал этот столбец ключом
// ALTER TABLE PurchaseList ADD COLUMN count INT NOT NULL;
// SET @x = 0;
// UPDATE PurchaseList SET count=(@x:=@x+1);
// ALTER TABLE PurchaseList CHANGE count count INT KEY auto_increment;
public class PurchaseList {
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "course_name")
    private String courseName;
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int count;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PurchaseList{" +
                "studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", price=" + price +
                ", subscriptionDate=" + subscriptionDate +
                ", count=" + count +
                '}';
    }
}
