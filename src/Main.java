import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание №11");
        System.out.println("Методы.");
        int taskNumberRun;
        try {
            taskNumberRun = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Какое задание нужно выполнить? (1-10)"));
        } catch (Exception e) {
            taskNumberRun = 0;
            //e.printStackTrace(); // Выводит сообщение об ошибке
        }
        switch (taskNumberRun) {
            case 1 -> task1();    //Задание 1
            case 2 -> task2();    //Задание 2
            case 3 -> task3();    //Задание 3
//            case 4 -> task4();    //Задание 4
//            case 5 -> task5();    //Задание 5
//            case 6 -> task6();    //Задание 6
//            case 7 -> task7();    //Задание 7
//            case 8 -> task8();    //Задание 8
//            case 9 -> task9();    //Задание 9
//            case 10 -> task10();    //Задание 10
//            case 11 -> task11();    // Задание 12
            default -> System.out.println("Вы не выбрали задание!?: " + taskNumberRun);
        }
        System.out.println("_________");
        System.out.println("Домашка закончилась. Всем спасибо, все свободны.");
    }

    private static void task3() {
        System.out.println("Задание 4");
        //Инициализация
        String deliveryMessag = "Потребуется дней: ";
        int deliveryDistance = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Введите расстояние от офиса до клиента:"));
        //Решение
        deliveryMessag = deliveryMessag +
                ((deliveryDey(deliveryDistance)!=0) ?
                        deliveryDey(deliveryDistance) : "Доставка не предусмотренна");
        //Вывод
        System.out.println(deliveryMessag);
    }

    private static int deliveryDey(int deliveryDistance) {
        int deliveryDey = 1;
        if (deliveryDistance > 20 ) deliveryDey += 1;
        if (deliveryDistance > 60 ) deliveryDey += 1;
        if (deliveryDistance > 100 ) deliveryDey = 0;
        return deliveryDey;
    }

    private static void task2() {
        System.out.println("Задание 2");
        //Инициализация
        // Запрашиваем у пользователя операционную систему и год выпуска
        //System.out.println("Какая у вас операционная система?");
        String os = JOptionPane.showInputDialog(null, "Введите название вашей операционной системы:");
        int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите год выпуска вашего телефона:"));
        //Решение
        //Вывод
        switch (clientOS(os, year)) {
            case 0 -> System.out.println(
                    "Установите облегченную версию приложения для iOS по ссылке");
            case 1 -> System.out.println(
                    "Установите облегченную версию приложения для Android по ссылке");
            case 2 -> System.out.println(
                    "Установите версию приложения для iOS по ссылке");
            case 3 -> System.out.println(
                    "Установите версию приложения для Android по ссылке");
            default -> System.out.println(
                    "Для Вашей OS: \"" + os + "\" "+year+" глда выпуска - установка приложения не предусмотрена");
        }
    }

    private static int clientOS(String os, int year) {
        int clientDeviceYear = LocalDate.now().getYear()-3;
        // Определяем, какая операционная система установлена
        if (os.equals("iOS") && year<=clientDeviceYear) return 0; // Переменная clientOS равна 0, так как это iOS старая
        else if (os.equals("iOS")) return 2; //iOS новая
        if (os.equals("Android") && year<=clientDeviceYear) return 1;   // Переменная clientOS равна 1, так как это Android старая
        else if (os.equals("Android")) return 3; // Android - новая
        return -1;
    }

    private static void task1() {
        System.out.println("Задание 1");
        //Инициализация
        int year; // Задаем интересующий нас год
        year = Integer.parseInt(JOptionPane.showInputDialog(null, "Задаем интересующий нас год:"));
        //Решение и Вывод
        if (isLeap(year)) System.out.println(year + " год является високосным");
        else System.out.println(year + " не является високосным годом");
    }

    private static boolean isLeap(int year) {
        return (year % 400 == 0 || year % 4 == 0) && year % 100 != 0;
    }

}