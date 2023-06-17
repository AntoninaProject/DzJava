//Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);

        System.out.printf("Введите опериацию: 1 - треугольное сложение; 2 - факториал. ");
        
        Integer choise = f.nextInt();

        if (choise == 1) {

            System.out.printf("Введите число: ");

            Integer number = f.nextInt();

            int result = TriangleSum(number);

            System.out.println(result);

            f.close();

        } else {
            System.out.printf("Введите число: ");

            Integer number = f.nextInt();

            int result = TriangleFac(number);

            System.out.println(result);
            
            f.close();
        }
    }

    private static int TriangleSum(int number) { //Расчет суммы

        int sum = 0;

        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    private static int TriangleFac(int number) { //Расчет факториала

        int fac = 1;

        for (int i = 1; i <= number; i++) {
            fac *= i;
        }
        return fac;
    }
}