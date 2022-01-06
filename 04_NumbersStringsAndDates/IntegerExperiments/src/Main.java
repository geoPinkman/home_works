public class Main
    //Home work 4.1 done
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count = 9999;
        System.out.println(container.sumDigits(container.count));
        // Translate char to int
        Character ch = '9';
        int i = Integer.parseInt(Character.toString(ch));
        System.out.println(i);

    }


}
