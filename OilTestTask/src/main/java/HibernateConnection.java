
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;

public class HibernateConnection {
    private Session session = null;
    public static final String [] LETTERS = {"a", "b", "c", "d", "e"};


    private Session getSession() {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        this.session = sessionFactory.openSession();
        return session;
    }

    public Set<Equipment> getAllEq() {
        List<Equipment> list = session.createQuery("from Equipment").list();
        return new HashSet<>(list);
    }
    public Set<Well> getAllWell() {
        List<Well> list = session.createQuery("from Well").list();
        return new HashSet<>(list);
    }

    public Well getWellById(int id) {
        String hql = "from Well where id = :id";
        List<Well> wellList = session.createQuery(hql).setParameter("id", id).list();
        if (!wellList.isEmpty()) {
            return wellList.get(0);
        } else {
            return null;
        }
    }

    public Well getWellByName(String name) {
        String hql = "from Well where name = :name";
        List<Well> wellList = session.createQuery(hql).setParameter("name", name).getResultList();
        if (!wellList.isEmpty()) {
            return wellList.get(0);
        } else {
            return null;
        }
    }

    public Equipment getEquipById(int id) {
        String hql = "from Equipment where id = :id";
        List<Equipment> equipmentList = session.createQuery(hql).setParameter("id", id).list();
        if (!equipmentList.isEmpty()) {
            return equipmentList.get(0);
        } else {
            return null;
        }
    }

    public Equipment getEquipByName(String name) {
        String hql = "from Equipment where name = :name";
        List<Equipment> equipmentList = session.createQuery(hql).setParameter("name", name).getResultList();
        if (!equipmentList.isEmpty()) {
            return equipmentList.get(0);
        } else {
            return null;
        }
    }

    public void createAndSaveEquipment(String name) {
        Equipment eq = new Equipment();
        eq.setName(name);
        if (getEquipByName(name) == null) {
            Transaction tx = session.beginTransaction();
            session.save(eq);
            tx.commit();
        } else {
            System.out.println("the object is already in the db");
        }
    }

    public void createAndSaveWell(String name) {
        Well well = new Well();
        well.setName(name);
        if (getWellByName(name) == null) {
            Transaction tx = session.beginTransaction();
            session.save(well);
            tx.commit();
        } else {
            System.out.println("the well is already in the db");
        }
    }

    public void fixEquipmentOnWell(String equipName, String wellName) {
        Equipment equipment;
        Well well;
        equipment = getEquipByName(equipName);
        well = getWellByName(wellName);
        Transaction tx = session.beginTransaction();
        if (equipment == null & well != null) {
            equipment = new Equipment();
            equipment.setName(equipName);
            equipment.setWell(well);
        } else if (equipment == null & well == null) {
            equipment = new Equipment();
            well = new Well();
            well.setName(wellName);
            session.save(well);
            equipment.setName(equipName);
            equipment.setWell(well);
        } else if (well == null) {
            well = new Well();
            well.setName(wellName);
            session.save(well);
            equipment.setWell(well);
        } else {
            equipment.setWell(well);
        }
        session.save(equipment);
        tx.commit();
    }

    private static String getRandomString() {
        int result;
        do {
            result = (int) (Math.random() * 10);
        } while (!(result >= 0 & result <= LETTERS.length - 1));
        return LETTERS[result];
    }
    private static int getRandomNumber() {
        int result;
        do {
            result = (int) (Math.random() * 10);
        } while (!(result >= 0 & result <= LETTERS.length - 1));
        return result;
    }
    private static Set<String> getNameSet(int number) {
        Set<String> nameSet = new HashSet<>();
        while (nameSet.size() <= number) {
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                name.append(getRandomString());
            }
            for (int i = 0; i < 2; i++) {
                name.append(getRandomNumber());
            }
            nameSet.add(name.toString());
        }
        return nameSet;
    }

    public static void main(String[] args) {
        HibernateConnection hCon = new HibernateConnection();
        Session session = hCon.getSession();

        System.out.println("oil company main menu");
        System.out.println("insert \"create equipment\" and \"count\" of equipments (create N) and push Enter");
        System.out.println("insert \"create well\" and \"count\" of wells (create N) and push Enter");
        System.out.println("insert \"show equipment\" to show all equipments ib db");
        System.out.println("insert \"show wells\" to show all equipments ib db");
        System.out.println("insert \"show\" and \"well_name\" to info about well");
        System.out.println("insert fix eq1,eq2...eqN by \"well_Name\"");

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            if (command.equals("exit")) {
                break;
            }
            if (command.equals("xml")) {
                try {
                    XmlMapper xmlMapper = new XmlMapper();
                    for (Well well : hCon.getAllWell()) {
                        System.out.println(well);
                        System.out.println(xmlMapper.writeValueAsString(new Well(well.getId(), well.getName(), well.getEquipments())));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
            }
            String[] instructions = command.split(" ");
            if ((instructions[0] + " " + instructions[1]).equals("create equipment")) {
                getNameSet(Integer.parseInt(instructions[2])).forEach(hCon::createAndSaveEquipment);
            }
            if ((instructions[0] + " " + instructions[1]).equals("create well")) {
                getNameSet(Integer.parseInt(instructions[2])).forEach(hCon::createAndSaveWell);
            }
            if ((instructions[0] + " " + instructions[1]).equals("show wells")) {
                Set<Well> wellSet = hCon.getAllWell();
                for (Well well : wellSet) {
                    System.out.println(well.toStringEquipCount());
                }
            }
            if ((instructions[0] + " " + instructions[1]).equals("show well")) {
                System.out.println(hCon.getWellByName(instructions[2]));
            }
            if ((instructions[0] + " " + instructions[1]).equals("show equipments")) {
                Set<Equipment> equipmentSet = hCon.getAllEq();
                for (Equipment equipment : equipmentSet) {
                    System.out.println(equipment.toString());
                }
            }
            if (instructions.length > 3) {
                if (instructions[0].equals("fix") & instructions[3] != null) {
                    String equips = instructions[1];
                    String[] equipsAsElements = equips.split(",");
                    for (String equip : equipsAsElements) {
                        hCon.fixEquipmentOnWell(equip, instructions[3]);
                    }
                }
            } else {
                System.out.println("try again");
            }
            command = scanner.nextLine();
        }
        session.close();
    }
}
