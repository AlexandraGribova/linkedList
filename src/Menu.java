import java.util.ArrayList;
public class Menu {

    private ArrayList<String> menuIteam = new ArrayList<>();
    private ArrayList<MainMenu> menuListener = new ArrayList<>();

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
        String  getProcess= menuIteam.get(iteam-1);
        for (MainMenu listener : menuListener) {
            listener.execute(newList, iteam);
        }
    }
}
