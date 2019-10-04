 class heapSort {

    public void maxHeap(int ar[], int size, int root) {

        int max = root;
        int l = root * 2;
        int r = (root * 2) + 1;


        if (l <= size && ar[l] > ar[root]) {
            max = l;
        }
        if (r <= size && ar[r] > ar[max]) {
            max = r;
        }
        if (max != root) {
            int temp = ar[root];
            ar[root] = ar[max];
            ar[max] = temp;
            maxHeap(ar, size, max);
        }

    }
    void printList(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public int[] buildHeap(int ar[], int size){
        for(int i = size/2; i>=1 ;i--){
            maxHeap(ar, size, i);
        }
        return ar;
    }
    public int[] sortHeap(int ar[], int size){
        for(int i = size ; i>=1 ; i--){

            int temp = ar[1];
            ar[1]=ar[i];
            ar[i]=temp;
           /* printList(ar);
            System.out.println(); */
            maxHeap(ar, --size, 1);
        }

        return ar;
    }
}


   public class Main {

        public static void main(String args[]) {


            int[] ar = new int[22];
            ar[0] = 21;


        for(int i=1; i<=21; i++){
          ar[i]=  (int)(Math.random()*1000);
        }
            heapSort heap = new heapSort();
        System.out.println("The original list with 21 random numbers, The first element is the number of nodes.");

            heap.printList(ar);
            System.out.println('\n');

            ar = heap.buildHeap(ar, ar[0]);
            System.out.println("Heap from the above list of random numbers, The first element is the number of nodes.");
            heap.printList(ar);
            System.out.println('\n');
            ar = heap.sortHeap(ar, ar[0]);

            System.out.println("Sorted list from the above heap, The first element is the number of nodes.");
            heap.printList(ar);
            System.out.println('\n');
        }


    }


