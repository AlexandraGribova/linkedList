import java.lang.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        menu.addMenuItem("1. Добавить эл-т в односвязный список");
        menu.addMenuItem("2. Удалить эл-т из односвязного списка по значению");
        menu.addMenuItem("3. Удалить эл-т из односвязного списка по индексу");
        menu.addMenuItem("4. Получить значение элемента по его индексу");
        menu.addMenuItem("5. Сортировка текущего списка");
        menu.addMenuItem("6. Вывести текущий односвязный список");
        // Создание объекта класса, реализуещего интерфейс
        MainMenu listener = new MainMenu(){
            @Override
            public void execute(linkedList newList, int iteam){
                int elem;
                switch(iteam) {
                    case (1):
                        System.out.print("Введите число для добавления: ");
                        elem = in.nextInt();
                        newList.addToEndOfList(elem);
                        break;
                    case (2):
                        System.out.print("Введите число для удаления: ");
                        elem = in.nextInt();
                        newList.removeByValue(elem);
                        break;
                    case (3):
                        System.out.print("Введите индекс для удаления: ");
                        elem = in.nextInt();
                        newList.removeByIndex(elem);
                        break;
                    case (4):
                        System.out.print("Введите индекс элемента: ");
                        elem = in.nextInt();
                        System.out.println(newList.getValueByIndex(elem));
                        break;
                    case (5):
                        newList.sortList();
                    case (6):
                        newList.showAllList();
                        break;
                }
};
        };

        // Добавляем "Слушателя". Каждый слушатель может выполнять различные действия при вызове
        menu.addListener(listener);
        // Выводим меню пользователю и даем право выбора
        while(true)
        {
            menu.printMenu();
            int iteam = in.nextInt();
            menu.runProcess(iteam);

        }



    }
}