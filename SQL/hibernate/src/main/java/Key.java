import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
@Embeddable
public class Key implements Serializable {
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "course_id")
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}

