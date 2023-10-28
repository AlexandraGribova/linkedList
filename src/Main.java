import java.lang.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu menu = new Menu();
        // Выводим меню пользователю и даем право выбора
        while(true)
        {
            menu.printMenu();
            int iteam = in.nextInt();
            menu.runProcess(iteam);
        }
    }
}