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
        private  Node(){}
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

    private Node[] frontBackSplit(){
        Node slow = currentNode;
        Node fast = currentNode.next;
        // продвигаем fast на два узла и продвигаем slow на один узел
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        Node[] arr = new Node[]{ currentNode, slow.next };
        slow.next = null;

        return arr;
    }

    private Node sortedMerge(Node l1, Node l2){
        Node dummy = new Node();
        Node tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null)
            tail.next = l1;
        else
            tail.next = l2;
        return dummy.next;
    }
    // Разделение списка на две части
    private Node[] split(Node source){
        if (source == null || source.next == null)
            return new Node[]{ source, null };

        Node slow = source;
        Node fast = source.next;

        // advance `fast` two nodes, and advance `slow` one node
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        Node[] arr = new Node[]{ source, slow.next };
        slow.next = null;

        return arr;
    }

    private Node mergeSort(Node head){
        if(head==null || head.next == null)
            return head;
        Node[] arr = split(head);
        Node left = mergeSort(arr[0]);
        Node right = mergeSort(arr[1]);
        return sortedMerge(left, right);
    }

    public void sortList(){
        head = mergeSort(head);
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
