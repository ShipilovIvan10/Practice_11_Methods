import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        byte taskNumber;

        do {
            System.out.print("Введите номер задания от 1 -  (0 - параметр выхода из программы): ");

            taskNumber = scanner.nextByte();

            switch (taskNumber) {
                case 0:
                    break;
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                default:
                    System.out.println("Введён некорректный номер задания! Всего 7 заданий. Повторите ввод номера задания!");
            }
        } while (taskNumber != 0);
    }

        static void task1(){
            PrintFormatText();
        }

        static void PrintFormatText(){
            System.out.println("\nSomeones's sitting in the shade today\n" +
                    "because someone planted a tree a long time ago.\nWarren Buffet.\n");
        }

        static void task2(){

            //Приглашение для ввода диапазона выводимых чисел
            System.out.print("Введите начало и конец диапазона соответственно (через пробел): ");
            int beginOfRange = scanner.nextInt();
            int endOfRange = scanner.nextInt();

            //Метод для вывода
            PrintAllEvenNumbersInRange(beginOfRange, endOfRange);
            //Отступ
            System.out.println();
    }

        static void PrintAllEvenNumbersInRange(int beginOfRange, int endOfRange){

            //Если начало диапазона не является чётным - сместим его
            if (beginOfRange % 2 != 0){
                beginOfRange++;
            }

            //Заглавное приглашение
            System.out.println("\nВсе чётные числа в диапазоне от " + beginOfRange + " до " + endOfRange);

            //Счётчик выведенных чисел
            int count = 0;

            //Цикл по чётным числам диапазона
            for (int number = beginOfRange; number <= endOfRange; number+=2){

                //Вывод
                System.out.print(number + "   ");

                //Инкремент счётчика
                count++;

                //Отформатируем вывод по 10 в ряду
                if (count % 10 == 0){
                    System.out.println();
                }
            }
            System.out.println();
        }

        static void task3(){

            //Параметры метода
            System.out.print("Введите длину выводимой линии:  ");
            int lengthOfLine = scanner.nextInt();

            System.out.print("Введите направление выводимой линии, где 0  -  по вертикали, 1  -  по горизонтали:  ");
            byte direction = scanner.nextByte();

            System.out.print("Введите символ из которого будет составлена линия:  ");
            scanner.nextLine();
            String str = scanner.nextLine();

            if (str.length() > 1){
                System.out.println("Введена некорректная длина символов!\n");
                return;
            }

            char symbol = str.charAt(0);

            PrintLineFromSymbol(lengthOfLine, symbol, direction);

    }

    static  void PrintLineFromSymbol(int lengthOfLine, char symbol, byte direction){

        if (direction == 0){
            for (int i = 0; i < lengthOfLine; i++){
                System.out.println(symbol);
            }
        }else if(direction == 1){
            for (int i = 0; i < lengthOfLine; i++) {
                System.out.print(symbol);
            }
        } else {
            System.out.println("Введено некорректное направление линии." +
                    " Требуется 0 - по вертикали, 1  -  по горизонтали. И всё!\n");
        }
        System.out.println();

    }

    static void task4(){

        System.out.print("Введите 4 числа (разделитель пробел):  ");

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();
        int fourthNumber = scanner.nextInt();

        System.out.println("Максимальное из введённых 4-х чисел:  " +
                PrintMaxOfFourNumbers(firstNumber, secondNumber, thirdNumber, fourthNumber) + "\n");
    }

    static int PrintMaxOfFourNumbers(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber){

        int[] arrayOfFour = new int[4];

        arrayOfFour[0] = firstNumber;
        arrayOfFour[1] = secondNumber;
        arrayOfFour[2] = thirdNumber;
        arrayOfFour[3] = fourthNumber;

        int max = Integer.MIN_VALUE;

        for (int x : arrayOfFour){
            if (x > max){
                max = x;
            }
        }

        return max;
    }

    static void task5(){

        System.out.print("\nВведите начало и конец диапазона соответственно (через пробел): ");
        int beginOfRange = scanner.nextInt();
        int endOfRange = scanner.nextInt();

        System.out.println("Сумма чисел:  " + SumOfNumbers(beginOfRange, endOfRange) + "\n");

    }

    static int SumOfNumbers(int beginOfRange, int endOfRange){

        int sum = 0;

        for (int i = beginOfRange; i <= endOfRange; i++){
            sum += i;
        }
        return sum;
    }

    static void task6() {

        System.out.print("\nВведите число: ");
        int num = scanner.nextInt();

        if (isSimply(num)){
            System.out.println("YES!");
        } else {
            System.out.println("NO!");
        }
    }

    static boolean isSimply(int num){

        //Исключим делители, кратные 2
        if (num % 2 == 0){
            return false;
        }

        //Проверяем нечётные делители
        for (int i = 3; i*i<= num; i+=2){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    static void task7(){
        System.out.print("\nВведите число: ");

        int num = scanner.nextInt();

        if (num < 1_000_00 || num > 999_999){
            System.out.println("Число не является шестизначным!");
            return;
        }

        if (isHappy(num)){
            System.out.println("YES!");
        }else{System.out.println("NO!");}

    }

    static boolean isHappy(int num){

        int sumOfFrirstPartOfNumber = 0;
        int sumOfsecondPartOfNumber = 0;

        //Преобразуем число в строку для получения отдельных цифр
        String strNumber = String.valueOf(num);

        for (int i = 0; i < 3 ; i++){

            //Извлекаем цифры из числа
            sumOfFrirstPartOfNumber += Character.getNumericValue(strNumber.charAt(i));
            sumOfsecondPartOfNumber += Character.getNumericValue(strNumber.charAt(i+3));
       }

        //Возврат значения
        if (sumOfFrirstPartOfNumber == sumOfsecondPartOfNumber){
            return true;
        } else {return false;}
    }
}