import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipment")
public class Equipment {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "well_id", referencedColumnName = "id")
    private Well well;

    public Equipment() {
    }

    public Equipment(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Well getWell() {
        return well;
    }

    public void setWell(Well well) {
        this.well = well;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return id == equipment.id && Objects.equals(name, equipment.name) && Objects.equals(well, equipment.well);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, well);
    }


    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public String toStringEquipment() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", well=" + well.getName() +
                '}';
    }
}
