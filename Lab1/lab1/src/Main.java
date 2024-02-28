public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        String languages[]={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n = n * 3;
        n = n + 0b10101;
        n = n + 0XFF;
        n = n * 6;

        while(n > 9)
        {
            int sum = n;
            int result = 0;
            while(sum > 0)
            {
                result = result + sum%10;
                sum = sum /10;
            }
            n = result;
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
    
}