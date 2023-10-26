import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    Scanner in = new Scanner(System.in);
    private ArrayList<String> menuIteam = new ArrayList<>();
    private ArrayList<MainMenu> menuListener = new ArrayList<>();

    public Menu(){
        // Заполнение меню
        addMenuItem("1. Добавить эл-т в односвязный список");
        addMenuItem("2. Удалить эл-т из односвязного списка по значению");
        addMenuItem("3. Удалить эл-т из односвязного списка по индексу");
        addMenuItem("4. Получить значение элемента по его индексу");
        addMenuItem("5. Сортировка текущего списка");
        addMenuItem("6. Вывести текущий односвязный список");
        // Создание анонимных классов для обработки пунктов меню
        MainMenu listener1 = new MainMenu(){
            @Override
            public void execute(linkedList newList){
                System.out.print("Введите число для добавления: ");
                int elem = in.nextInt();
                newList.addToEndOfList(elem);
            };
        };
        MainMenu listener2 = new MainMenu(){
            @Override
            public void execute(linkedList newList){
                System.out.print("Введите число для удаления: ");
                int elem = in.nextInt();
                newList.removeByValue(elem);
            };
        };
        MainMenu listener3 = new MainMenu(){
            @Override
            public void execute(linkedList newList){
                System.out.print("Введите индекс для удаления: ");
                int elem = in.nextInt();
                newList.removeByIndex(elem);
            };
        };
        MainMenu listener4 = new MainMenu(){
            @Override
            public void execute(linkedList newList){
                System.out.print("Введите индекс элемента: ");
                int elem = in.nextInt();
                System.out.println(newList.getValueByIndex(elem));
            };
        };
        MainMenu listener5 = new MainMenu(){
            @Override
            public void execute(linkedList newList){
                newList.sortList();
            };
        };
        MainMenu listener6 = new MainMenu(){
            @Override
            public void execute(linkedList newList){
                newList.showAllList();
            };
        };
        // Добавляем "Слушателя". Каждый слушатель может выполнять различные действия при вызове
        addListener(listener1);
        addListener(listener2);
        addListener(listener3);
        addListener(listener4);
        addListener(listener5);
        addListener(listener6);
    }
    private linkedList newList = new linkedList();

    // Заполнение меню пунктами
    public void addMenuItem(String iteam){
        menuIteam.add(iteam);
    }
    public void addListener(MainMenu listener){
        menuListener.add(listener);
    }

    public void printMenu(){
        for(int i=0; i<menuIteam.size(); i++)
            System.out.println(menuIteam.get(i));
    }

    public void runProcess(int iteam){
        MainMenu listener = menuListener.get(iteam - 1);
        listener.execute(newList);
    }
}
