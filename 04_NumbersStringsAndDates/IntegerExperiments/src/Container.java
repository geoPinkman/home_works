public class Container
    //Home work 4.1 done
{
    public int count;
    //public String s;
    //public char ch;
    public int sum;


    public Integer sumDigits(Integer count)
    {
        //s = Integer.toString(count);
        //ch = s.charAt(0);
        //s = String.valueOf(ch);
        //@TODO: write code here
        for (int i = 0; i < Integer.toString(count).length(); i++) {
            sum += Integer.parseInt(String.valueOf(Integer.toString(count).charAt(i)));
        }
        return sum;
    }
}