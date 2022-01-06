import javax.swing.colorchooser.ColorSelectionModel;



public class Loader
        // HOME WORK DONE
{
    public static void main(String[] args)
    {
        Cat cat1 = new Cat();
        cat1.setCatColor(Colors.BLACK);
        System.out.println("Cat1 color: " + cat1.getCatColor());
        System.out.println("Cat1 status: " + cat1.getStatus() + ", weight: " + cat1.getWeight());
        System.out.println("Cat1 eating...");
        cat1.feed((double)100);
        System.out.println("Cat1 ate: " + cat1.getSumFood());
        System.out.println("Cat1 status: " + cat1.getStatus() + ", weight: " + cat1.getWeight());
        for (int i = 0; i < 3; i++)
        {
            cat1.pee();
        }
        System.out.println("Cat1 ate: " + cat1.getSumFood());
        System.out.println("Cat1 status: " + cat1.getStatus() + ", weight: " + cat1.getWeight());

        Cat cat2 = new Cat();
        System.out.println("Cat2 status: " + cat2.getStatus() + ", weight: " + cat2.getWeight());
        System.out.println("Cat2 meowing...");
        cat2.meow();
        System.out.println("Cat2 status: " + cat2.getStatus() + ", weight: " + cat2.getWeight());

        Cat cat3 = new Cat();
        System.out.println("Cat3 status: " + cat3.getStatus() + ", weight: " + cat3.getWeight());
        System.out.println("Cat3 drinking...");
        while (cat3.getWeight() < cat3.getMaxWeight())
        {
            cat3.drink((double)50);
        }
        System.out.println("Cat3 drank: " + cat3.getSumFood());
        System.out.println("Cat3 status: " + cat3.getStatus() + ", weight: " + cat3.getWeight());
        cat3.meow();

        Cat cat4 = new Cat();
        System.out.println("Cat4 status: " + cat4.getStatus() + ", weight: " + cat4.getWeight());
        System.out.println("Cat4 meowing...");
        while (cat4.getWeight() > cat4.getMinWeight())
        {
            cat4.meow();
        }
        System.out.println("Cat4 status: " + cat4.getStatus() + ", weight: " + cat4.getWeight());

        Cat cat5 = new Cat(1100);
        System.out.println("Cat5 status: " + cat5.getStatus() + ", weight: " + cat5.getWeight());
        System.out.println("Cat5 drinking...");
        cat5.drink((double)50);
        System.out.println("Cat5 status: " + cat5.getStatus() + ", weight: " + cat5.getWeight());


        Cat cat6 = cat1.copy();
        System.out.println("Cat6 color: " + cat6.getCatColor());
        System.out.println("Cat6 status: " + cat6.getStatus() + ", weight: " + cat6.getWeight());

        Cat cat7 = new Cat(cat2);
        System.out.println("Cat7 color: " + cat7.getCatColor());
        System.out.println("Cat7 status: " + cat7.getStatus() + ", weight: " + cat7.getWeight());

        System.out.println("Cat count: " + Cat.getCatCount());
    }
}