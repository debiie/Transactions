/*CLASS: LinkedLIst...


 REMARKS: The linked list is data typre that stores objects in a node

-----------------------------------------
*/

import java.util.Objects;

public class LinkedList {
    class  Node {
        public  int amount  ;// amount of crypto the investor has
        private Object  anObject ;
        private Node next  ;

        public Node( Object anObject, Node nod ) {
            this.anObject = anObject;
            this.next  = nod ;
            amount = 0 ;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public Object getObject() {
            return anObject;
        }

        public void setCrypto(Object crypto) {
            this.anObject = crypto;
        }
    }
    private Node head ;



    public LinkedList(){
         head = null;
    }


    // the search method returns the object if found and returns null if not foud

    ///insert to the head of a linked list
    public void insert(Object cry ){

        head = new Node ( cry , head );

    }
     public boolean isEmpty(){
        return head==null;
     }

    public void insertToEnd(Object obj ){// this method inserts to the end of a  linked list

        if ( head == null ) {
            insert ( obj );
        }
        else {
            Node curr = head;
            while ( curr.next != null ){
                curr= curr.next;
            }
            curr.next = new Node (obj , null );


        }

    }

    // this ethod is to return the last obkect in a linked List
    // it would return null if there are no Objects  in the linked list
    public Object getLast ( ){

        Object ret = null ;
        if (head != null  ) {
            Node curr =this.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            ret = curr.getObject();
        }
        return ret;
    }


    /*
    Search method
    Purpose: To go through each node in the linked list and search for a particulart object

    PARAMETERS: It takes in an Object


    Returns:It return the object if found in the list and returns null if not in the list
     */
    public Object search (Object obj ){
        Object ret = null;
        Node curr = head ;
        while ( curr != null ){
            if (curr.getObject().equals(obj)){
                ret  =curr.anObject ;

            }
            curr= curr.next;
        }
        return ret ;
    }

    /*
    Print method
    PURPOSE : The print method should print out each object in the linked list if  the linked list is not empty

    PARAMETER :
    Return :It returns a string which is the Objects toString or "EMPTY" if the linkedlist is empty

     */
    public  String  print  (){

        String str = " ";//  the string to be returned
         if (head!=null) {
             Node curr = head;// pointer to the head node
             while (curr != null) {
                 str += curr.anObject.toString();
                 str += "\n\t";
                 curr = curr.next;

             }
         }else  {
             str = "Empty";
         }
        return str;
    }


    /*********************************************************************
     *  compare
     * PURPOSE:The method searches compares each object compares the object of two linked list ,
     * PARARMETER : The method takes in a Linked lIst
     * RETURN : returns true if the object in the calling list is the same as the objects in the passed linked list
     *
     *********************************************************************/

    public boolean compare (LinkedList obj ){
        boolean ret = false ;
        System.out.println("ok ");
         if ( head != null && obj.head != null  ){
             Node curr = this.head ;
             Node curr2 = obj.head;

             while ( curr!= null && curr2 != null  ){

                 if ( curr.getObject().equals(curr2.anObject)){
                     ret= true ;
                 }
                 curr= curr .next;
                 curr2 = curr2.next;
             }
         }
         else if (head == null && obj.head == null ){
             //check if  both the list are emoty then it should return true
             ret = true ;
         }
         return ret ;
    }

}
