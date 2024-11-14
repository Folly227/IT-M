import java.util.Scanner;

class Main {

    public static String calc(String input) throws Exception {
        String[] element = input.split(" ");
        if (element.length != 3) {
            throw new Exception("Строка не является математической операцией.");
        }

        int num1;
        int num2;

        try {
            num1 = Integer.parseInt(element[0]);
            num2 = Integer.parseInt(element[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Операнды должны быть целыми числами от 1 до 10.");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно.");
        }

        switch (element[1]) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            case "/":
                if (num2 == 0) {
                    throw new Exception("Деление на ноль.");
                }
                return String.valueOf(num1 / num2);
            default:
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическую операцию (например, 3 + 4):");
        String input = scanner.nextLine();
        try {
            String output = calc(input);
            System.out.println("Результат: " + output);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
