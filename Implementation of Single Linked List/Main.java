class LinkedList {
        public Node head;

        public class Node{
            int value;
            Node next;
            Node(int n){
                this.value=n;
                this.next=null;
            }

        }

        public Node addNode(Node head, int number){
            Node newNode=new Node(number);
            if(head==null){
                return newNode;
            }
            else
            {
                head.next = addNode(head.next, number);
                return head;
            }

        }


        public void printList(Node head){
            if(head==null)
                return ;
            else{
                System.out.print(head.value+ " ");
                printList(head.next);
            }
        }

        public Node selectionSort(Node head){
            if(head.next==null){

                return head;
            }

                Node minimum = head;
                Node before=null;
                Node After = head;
                while(After.next!=null){


                    if(minimum.value>After.next.value){

                        minimum=After.next;
                        before=After;

                    }

                    After = After.next;

                }



            if(minimum!=head){

                if(head.next==minimum){

                    head.next=minimum.next;
                    minimum.next=head;
                    head=minimum;

                }
                else{

                    Node temp=head.next;
                    head.next=minimum.next;
                    before.next=head;
                    head=minimum;
                    minimum.next=temp;

                    }

            }

            head.next=selectionSort((head.next));

                return head;

            }
    }
public class Main {

    public static void main(String[] args) {
	LinkedList list = new LinkedList();
	LinkedList.Node start = list.head;
	int i=0;


		while(i<16){
			start=list.addNode(start, (int)(Math.random()*1000));
			i++;
		}

		System.out.println("SINGLE LINKED LIST WITH 16 NODES CREATED\n");
		System.out.println("Single Linked list which is not sorted: ");
		list.printList(start);
		System.out.println("\n");
		start=list.selectionSort(start);
		System.out.println("Single Linked list after sorting: ");
		list.printList(start);
		System.out.println("\n");

    }
}

