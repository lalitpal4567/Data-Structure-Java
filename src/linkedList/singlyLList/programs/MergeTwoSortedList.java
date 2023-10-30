package linkedList.singlyLList.programs;

class Node11{
    int data;
    Node11 next;

    Node11(int data){
        this.data = data;
        next = null;
    }
}

public class MergeTwoSortedList {
    Node11 head;
    Node11 newHeadList;

    // Insert at the end of the list
    public void addLast(int data) {
        Node11 newNode = new Node11(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node11 current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // merge two list (list1 + list2)
    public void mergeSortedList(Node11 headList2){
        Node11 listA = head;
        Node11 listB = headList2;
        Node11 newNode = new Node11(0);
        newHeadList = newNode;

        while(listA != null && listB != null){
            if(listA.data <= listB.data){
                newNode.next = listA;
                listA = listA.next;
            }
            else{
                newNode.next = listB;
                listB = listB.next;
            }
            newNode = newNode.next;
        }
        if(listA == null){
            newNode.next = listB;
        }
        else{
            newNode.next = listA;
        }
    }

    // displaying the list nodes
    public void printList(Node11 head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node11 current = head;

        StringBuilder str = new StringBuilder();
        str.append("[");
        while (current != null) {
            str.append(current.data);
            current = current.next;

            if (current != null) {
                str.append(", ");
            }
        }
        str.append("]");
        System.out.println(str);
    }


    public static void main(String[] args) {
        MergeTwoSortedList obj = new MergeTwoSortedList();
        obj.addLast(1);
        obj.addLast(3);
        obj.addLast(5);
        obj.addLast(8);
        obj.addLast(10);

        MergeTwoSortedList obj2 = new MergeTwoSortedList();
        obj2.addLast(2);
        obj2.addLast(4);
        obj2.addLast(6);
        obj2.addLast(7);
        obj2.addLast(11);

        System.out.println("List A");
        obj.printList(obj.head);

        System.out.println("\n" + "List B");
        obj.printList(obj2.head);

        obj.mergeSortedList(obj2.head);
        System.out.println("\n" + "List C");
        obj.printList(obj.newHeadList);
    }
}
