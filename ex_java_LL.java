package datastructures.linkedlists;

public class Linkedlist 
{

    Node head;
    int length;
    Linkedlist()
    {
        head=null;
    }
    Linkedlist(int tempp)
    {
        insert_at_end(this, tempp);
    }

    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }

    void deleteNode(int position)
    {
        if (head == null)
            return;
        Node temp = head;

        if (position == 0) {
            head = temp.next; 
            return;
        }
        if (temp == null || temp.next == null)
        {
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++)
        {
            temp = temp.next;
        }
        temp.next=temp.next.next;
    }
    void replace(Linkedlist list,int data,int data2)
    {
        int n=list.length;
        Node temp=list.head;
        if(list.head == null)
        {
            System.out.println("Cant replace as LinkedList is empty");
        }
        else
        {
            while(n!=0)
            {
                if(data == temp.data)
                {
                    temp.data=data2;
                }
            n--;
            }
        }

    }
    void insert_at_beginning(Linkedlist list,int data)
    {
        if(list.head == null)
        {
            list.head = new Node(data);
            list.length = 1;
        }
        else
        {
            Node newNode = new Node(data);
            newNode.next = list.head;
            list.head = newNode;
            list.length++;
        }
    }
    void insert_at_end(Linkedlist list,int data)
    {   
        Node temp= new Node(data);
        Node t=list.head;
        if(list.head == null)
        {
            list.head = temp;
            list.length=1;
        }
        else
        {
            while(t.next != null)
            {
                t=t.next;
            }
            t.next=temp;
            list.length++;
        }
    }


    void display(Linkedlist list) 
    {
        if(list.head == null)
        {
                System.out.println("list is empty");
        }
        else
        {
            Node temp=list.head;
            while(temp != null)
            {
                System.out.print(temp.data+"-->");
                temp=temp.next;
            }
        }
    }
    
    public static void main(String[] args)
    {
        Linkedlist list = new Linkedlist();
        list.insert_at_beginning(list,30);
        list.insert_at_beginning(list,20);
        list.insert_at_beginning(list,10);
        list.display(list);
        System.out.println();

        list.insert_at_end(list,40);
        list.insert_at_end(list,50);
        list.insert_at_end(list,60);

        list.display(list);
        System.out.println(list.length);

        list.replace(list,10,20);
        list.display(list);        

        list.deleteNode(2);
        list.display(list);
        
    }

}
