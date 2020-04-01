class Node
{
    int val;
    Node next;
    
    public Node(int value)
    {
        val = value;
        next = null;
    }
}

class LinkedList
{
    Node head;
    Node tail;
    
    public LinkedList()
    {
        head = null;
    }
    public String encodeList()
    {
        StringBuilder res = new StringBuilder("");
        if(head == null)
            return res.toString();
            
        Node iter = head;
        while(iter != null)
        {
            String v = String.valueOf(iter.val);
            res.append(v);
            res.append("$");
            iter = iter.next;
        }
        return res.toString();
    }
    
    public void addNode(Node n)
    {
        if(head == null)
        {
            head = n;
            tail = n;
        }
        else
        {
            tail.next = n;
            tail = tail.next;
        }
    }
    
    public void printLL()
    {
        Node iter = head;
        while(iter != null)
        {
            System.out.println(iter.val);
            iter = iter.next;
        }
    }
    
    public LinkedList decodeList(String s)
    {
        LinkedList result = new LinkedList();
        if(s.length() == 0)
            return result;
        
        
        StringBuilder tempVal = new StringBuilder("");
        for(int i = 0; i < s.length(); i++)
        {
           if(s.charAt(i) == '$')
           {
               int val = Integer.parseInt(tempVal.toString());
               Node tNode = new Node(val);
               result.addNode(tNode);
               tempVal = new StringBuilder("");
           }
           else
           {
               tempVal.append(s.charAt(i));
           }
        }
        
        return result;
    }
}

public class Main{

     public static void main(String []args){
        LinkedList test = new LinkedList();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        
        test.addNode(a);
        test.addNode(b);
        test.addNode(c);
        
        test.printLL();
        
        String s = test.encodeList();
        System.out.println(s);
        
        LinkedList r = test.decodeList(s);
        
        r.printLL();
     }
}
