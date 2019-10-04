
class BinarySearchTree{



    class Node{
        int value;
        Node left, right;

    }
    public  Node createNode(int n) {
        Node first = new Node();
        first.value=n;
        first.left=null;
        first.right=null;
        return first;
    }

    public  Node createBST(Node start, int number){
        Node newNode = createNode(number);
        if(start==null){
            return newNode;
        }
        else{
            if(start.value>=number){
                if((start.left==null)){
                    start.left=createBST(start.left,number);}
                else{
                    createBST(start.left,number);
                }
            }
            if(start.value<number){
                if(start.right==null) {
                    start.right = createBST(start.right, number);
                }
                else{
                    createBST(start.right,number);
                }
            }
            return start;
        }


    }
    public void printInOrder(Node start){
        if (start == null) {
            return;
        }
        else {

            printInOrder(start.left);

            System.out.print(start.value +" ");
            //System.out.println("k");
            printInOrder(start.right);
        }
    }


    public Node callMethod(Node start){
        Node t = start;
        if(t.left==null){
            return t;
        }

        else {
            t = callMethod(t.left);
        }
        return t;
    }

    public Node deleteNode(Node start, int n){
        if(start==null){
            return null;
        }
        else if(start.value>n){
            start.left=deleteNode(start.left,n);
        }
        else if(start.value<n){
            start.right=deleteNode(start.right,n);
        }
        else{
            if(start.left==null||start.right==null){


                  Node t=null;
                  if(start.left==null){
                      t=start.right;
                  }
                  else if(start.right==null){
                      t=start.left;
                  }
                  else if(start.left==null&&start.right==null){
                      t=null;
                  }

                    return t;

            }
            else{
                //check
                Node fromMethod = callMethod(start.right);

                start.value=fromMethod.value;

                start.right=deleteNode(start.right, start.value);
                return start;
            }

        }
        return start;
    }


}




public class Main{
    public static void main(String args[]){
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree.Node start=null;

        start = bst.createBST(start,50);
        start = bst.createBST(start,30);
        start = bst.createBST(start,20);
        start = bst.createBST(start,40);
        start = bst.createBST(start,70);
        start = bst.createBST(start,60);
        start = bst.createBST(start,80);
        start = bst.createBST(start,160);
        start = bst.createBST(start,120);
        start = bst.createBST(start,10);
        start = bst.createBST(start,400);
        start = bst.createBST(start,200);
        start = bst.createBST(start,100);
        start = bst.createBST(start,110);
        start = bst.createBST(start,500);
        start = bst.createBST(start,170);
        start = bst.createBST(start,90);
        start = bst.createBST(start,1);
        System.out.println("BST WITH 18 NODES CREATED");
        System.out.println("");
        System.out.println("BST which is created is printed below after inorder traversal:");
        bst.printInOrder(start);
        System.out.println("\n");

        start=bst.deleteNode(start,1);
        System.out.println("BST after a leaf node is deleted and after doing inorder traversal:");
        bst.printInOrder(start);

        System.out.println("\n");
        start=bst.deleteNode(start,50);
        System.out.println("BST after deleting a node having sub tree from the previous BST and after doing inorder traversal:");
        bst.printInOrder(start);
        System.out.println("\n");
    }
}



