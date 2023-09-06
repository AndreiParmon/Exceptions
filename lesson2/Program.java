import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {
        //task1();
        //task2();
        //task3();
        //task4();
    }
    public static void task1(){
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        boolean input = false;
        while (!input){
            System.out.print("Введите дробное число через запятую: ");
            if (scanner.hasNextFloat()){
                number = scanner.nextFloat();
                input = true;
            }else {
                System.out.println("Ошибка ввода! Введите дробное число!");
                scanner.next();
            }
        }
    }

    public static void task2(){
        try {
            int d = 0;
            int[] intArray = new int[5];
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    public static void task3(){
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            int[] abc = { 1, 2 };
            abc[2] = 9;
        }catch (ArithmeticException ex) {
            System.out.println("");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void task4() throws Exception {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Введите строку: ");
            String str = scanner.nextLine();
            if (str.isEmpty()){
                throw new Exception("Пустая строка!!!");
            }
            System.out.printf("Вы ввели: %s", str);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
