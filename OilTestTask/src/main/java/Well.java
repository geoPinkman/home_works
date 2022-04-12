import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "well")
public class Well {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "well", cascade = CascadeType.ALL)
    private Set<Equipment> equipments = new HashSet<>();

    public Well(int id, String name, Set<Equipment> equipments) {
        this.id = id;
        this.name = name;
        this.equipments = equipments;
    }

    public Well() {
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

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

//    public void addEquipment(Equipment eq) {
//        eq.setWell(this);
//        this.equipments.add(eq);
//    }


    @Override
    public String toString() {
        return "Well{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", equipments=" + getEquipments() +
                '}';
    }

    public String toStringEquipCount() {
        return "Well{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", equipments=" + equipments.size() +
                '}';
    }

}