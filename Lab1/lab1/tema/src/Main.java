import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        StringBuilder totalNum = new StringBuilder();

        int a = 0;
        int b = 0;
        int k = 0;

        if(args.length > 0)
        {
            a = Integer.valueOf(args[0]);
            b = Integer.valueOf(args[1]);
            k = Integer.valueOf(args[2]);

            System.out.println("Intervalul numerelor");
            System.out.println("De la : " + a);
            System.out.println("Pana la : " + b);
            System.out.println("k-reductibil : " + k);
        }
        else
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Intervalul numerelor");
            System.out.print("De la : ");
            a = scan.nextInt();
            System.out.print("Pana la : ");
            b = scan.nextInt();
            System.out.print("k-reductibil : ");
            k = scan.nextInt();
        }

        for(int i = a; i <= b; i++)
        {
            int num = i;
            while(num > 9)
            {
                int numCopy = num;
                int reduct = 0;

                while(numCopy > 0)
                {
                    reduct += (int)Math.pow((numCopy % 10), 2);
                    numCopy /= 10;
                }

                num = reduct;
            }
            if(num == k)
                totalNum.append(i + " ");
        }

        System.out.println(totalNum);
        long endTime = System.currentTimeMillis();
        System.out.println("Timpul pentru executie : " + (endTime - startTime) + " milisecunde");
    }
}