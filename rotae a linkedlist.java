import java.util.*;
public class rotateLL {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

    }
    public void push(int key)
    {
    Node newNode=new Node(key);
        if(head==null)
        {
            head=new Node(key);
            return;
        }
        
        
        newNode.next=null;
        Node last=head;
        while(last.next!=null)
        {
            last=last.next;
        }
        last.next=newNode;        
        
    }
    public void rotate(Node h,int n)
    {
        Node prev=null,curr=h,temp=null,ncur=h;
        int count=-1;
        while(curr!=null)
        {
            count++;
            if(n==count)
                temp=curr;
            prev=curr;
            curr=curr.next;
        }
        if(curr==null)
            prev.next=head;
        while(n+1>0)
        {
            if(ncur==temp)
            {  head=ncur;
            prev.next=null;
            
            }
        prev=ncur;
            ncur=ncur.next;
            n--;
        }
        
        
        
    }

    public void print(Node h) {
        Node temp = h;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    public static void main(String args[]) {
        rotateLL ll = new rotateLL();
        
        Scanner sc=new Scanner(System.in);
        System.out.println("how many element you want to insert in linked list");
        int eleNo=sc.nextInt(),n,m;
        m=eleNo;
        System.out.println("Now insert element one by one");
        while(eleNo>0)
        {
            n=sc.nextInt();
            ll.push(n);
            eleNo--;
        }
        System.out.println("enter how many element to rotate");
        n=sc.nextInt();
        if(n>=m)
            n=n%m;
        
        
        
        System.out.println("created linkedlisi is:");
        ll.print(head);
        ll.rotate(head,n);
        System.out.println("\n linkedlist after rotation:");
        ll.print(head);
    }
}
