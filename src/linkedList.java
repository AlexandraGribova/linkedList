import java.lang.*;
public class linkedList {
    class Node{
        public int value;
        public int index;
        public Node next;

        private Node(int value){
            this.value = value;
            this.index = current_index;
            next = null;
        }
    }

    private Node head;

    public linkedList(){
        head = null;
    }

    private Node currentNode;
    private int current_index = 0;

    public void addToEndOfList(int value){
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            currentNode = head;
        }
        else {
            while (currentNode.next != null)
                currentNode = currentNode.next;
            currentNode.next = newNode;
        }
        current_index += 1;
    }

    public void removeByValue(int value){
        currentNode = head;
        Node prevNode = currentNode;
        while(currentNode.next != null && currentNode.value !=value) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        // Еслм дошли до конца списка и не нашли заданного значения
        if (currentNode.value == value)
            // Мы удаляем заголовок(корень) списка
            if (currentNode == head)
                head = currentNode.next;
            else
                prevNode.next = currentNode.next;
        else
            System.out.println("В текущем односвязном списке не найдено значение '" + value + "'");

    }

    public void removeByIndex(int index){
        currentNode = head;
        Node prevNode = currentNode;
        while(currentNode.next != null & currentNode.index !=index) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        // Еслм дошли до конца списка и не нашли заданного индекса
        if(currentNode.next == null)
            System.out.println("В текущем односвязном списке не найдено значения с индексом '" + index + "'");
            // Мы удаляем заголовок(корень) списка
        else if (currentNode == head)
            head = currentNode;
        else
            prevNode.next = currentNode.next;
    }

    public Integer getValueByIndex(int index){
        currentNode = head;
        while(currentNode.next != null & currentNode.index!=index)
            currentNode = currentNode.next;
        if (currentNode.next == null)
            return null;
        else
            return currentNode.index;
    }

    public void sortList(){
        System.out.println("1");
    }

    public void showAllList(){
        if (head != null) {
            currentNode = head;
            while (currentNode.next != null) {
                System.out.print(currentNode.value + " -> ");
                currentNode = currentNode.next;
            }
            System.out.print(currentNode.value + "\n");
        }
        else
            System.out.println("Список пуст");
    }
}
