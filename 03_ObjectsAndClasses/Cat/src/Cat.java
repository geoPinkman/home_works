

public class Cat
{
    // HOME WORK DONE
    private final int CAT_EYES_COUNT = 2;
    private final double CAT_MIN_WEIGHT = 1000;
    private final double CAT_MAX_WEIGHT = 9000;

    private double originWeight;
    private double weight;
    private Colors color;
    private boolean isAlive;


    private double sumAmount;
    private static int catCount;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        catCount++;
    }

    public boolean isAlive()
    {
        if (weight < CAT_MIN_WEIGHT || weight > CAT_MAX_WEIGHT) {
            return isAlive = false;
        }
        else
            return isAlive = true;
    }

    public Cat(Cat other) {
        this.weight = other.weight;
        this.originWeight = other.weight;
        this.color = other.color;
        Cat.catCount++;


    }

    public Cat copy() {
        return new Cat(this);
    }

   /* public void setCatCopy(double weight, Colors color)
    {
        this.weight = weight;
        this.originWeight = weight;
        this.color = color;
    }
*/


    public Cat(double weight)
    {
        this.weight = weight;
        this.originWeight = weight;
        catCount++;
    }

    public void setCatColor(Colors color)
    {
        this.color = color;
    }

    public Colors getCatColor()
    {
        return color;
    }

    public static Integer getCatCount()
    {
        return catCount;
    }

    public double getMaxWeight()
    {
        return CAT_MAX_WEIGHT;
    }

    public double getMinWeight()
    {
        return CAT_MIN_WEIGHT;
    }

    public void meow()
    {
        if (isAlive() == false){
            System.out.println("The cat is already dead");
        }
        else {
            System.out.println("Meow...");
            this.weight = weight - 1000;
            if (isAlive() == false) {
                catCount--;
            }
        }
    }


    public void pee()
    {
        if (isAlive() == false){
            System.out.println("The cat is already dead");
        }
        else {
            System.out.println("Pee...");
            this.weight = weight - 10;
            if (isAlive() == false) {
                catCount--;
            }
        }

    }

    public void feed(Double amount)
    {
        if (isAlive() == false){
            System.out.println("The cat is already dead");
        }
        else {
            this.weight = weight + amount;
            this.sumAmount += amount;
            if (isAlive() == false) {
                catCount--;
            }
        }
    }

    public void drink(Double amount)
    {
        if (isAlive() == false){
            System.out.println("The cat is already dead");
        }
        else {
            this.weight = weight + amount;
            this.sumAmount += amount;
            if (isAlive() == false) {
                catCount--;
            }
        }
    }


    public double getSumFood()
    {
        return sumAmount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < CAT_MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > CAT_MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}