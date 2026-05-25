import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManager {
    public static Scanner sc = new Scanner(System.in);
    public static List<String> toDoList = new ArrayList<>();

   public static void main(String [] args) {
        while (true) {
            printOperation();
            int choiceOperation = getOperation();

            switch (choiceOperation) {
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                   // break;
                case 1:
                    addTask();
                    break;
                case 2:
                    showTask();
                    break;
                case 3:
                    deleteTaskByNumber();
                    break;
                case 4:
                    deleteTaskByName();
                    break;
                default:
                    System.out.println("Номера " + choiceOperation + " нет в списке дел. " +
                            "Повторите ввод.");
            }
        }


    }

    public static void printOperation() {
        System.out.println("Выберите операцию: ");
        System.out.println("0.Выход из программы");
        System.out.println("1.Добавить дело");
        System.out.println("2.Показать дела");
        System.out.println("3.Удалить дело по номеру");
        System.out.println("4.Удалить дело по названию");
    }

    public static void addTask() {
        sc.nextLine();
        System.out.println("Введите название задачи: ");
        String task = sc.nextLine();
        if (!toDoList.contains(task)) {
            toDoList.add(task);
            System.out.println("Добавлено!");
        } else {
            System.out.println("Задача уже добавлена в список");
        }
        showTask();
    }

    public static void showTask() {
        System.out.println("Ваш список дел: ");
        if (toDoList.isEmpty()) {
            System.out.println("Пустой список");
        } else {
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + "." + toDoList.get(i));
            }
        }
    }

    public static int getOperation() {
        System.out.println("Ваш выбор: ");
        while (!sc.hasNextInt()) {
            System.out.println("Пожалуйста, введите число.");
            sc.next(); // убираем ввод
            System.out.print("Ваш выбор: ");
        }
        return sc.nextInt();

    }
    private static void deleteTaskByName() {
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст.");
            return;
        }

        sc.nextLine(); // очищаем буфер
        System.out.print("Введите задачу для удаления: ");
        String task = sc.nextLine();

        if (toDoList.remove(task)) {
            System.out.println("Удалено!");
        } else {
            System.out.println("Неверное название задачи");
        }
        showTask();
    }
    private static void deleteTaskByNumber() {
        if (toDoList.isEmpty()) {
            System.out.println("Список дел пуст.");
            return;
        }

        showTask();
        System.out.print("Введите номер для удаления: ");

        if (sc.hasNextInt()) {
            int index = sc.nextInt() - 1;
            if (index >= 0 && index < toDoList.size()) {
                String removed = toDoList.remove(index);
                System.out.println("Удалено: " + removed);
            } else {
                System.out.println("Неверный номер дела");
            }
        } else {
            System.out.println("Введите верный номер дела");
            sc.next(); // очищаем неверный ввод
        }
        showTask();
    }
}


