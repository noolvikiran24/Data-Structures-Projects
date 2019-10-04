

public class Main {

    public static String hashTable[];

    static void hashTableCreate(int size){
        hashTable = new String[size];

        }

       public static int calculateKey(String s){
        int key=0;
        for(int i=0;i<s.length();i++){
            key+=((i+1)*s.charAt(i));
        }
        return key;
        }
        static int nearestPrime(int length){
        for(int num=length; true; num++){
            boolean prime = true;
            int l = (int)Math.sqrt(length);
            for(int j=2;j<=l;j++){
                if((num%j)==0){
                    prime=false;
                    break;
                }
            }
            if(prime){
               // System.out.println("Prime no:"+num);
                return num;
            }
        }


        }

        static int rehashing(String freshArray[]){

        int rehashSize = nearestPrime((hashTable.length)*2);

        //System.out.println("newsi"+rehashSize);
            hashTableCreate(rehashSize);


           int newCollisions = insertQuadratic(freshArray);
           //System.out.println("nC"+newCollisions);
            System.out.println("Hashtable is rehashed.");
            System.out.println();
            System.out.println("New size of the hash table is: "+rehashSize);
            System.out.println();
           return newCollisions;
        }

        static int insertQuadratic(String stringArr[]){
        int collisions=0;
        float loadsize = 0;

        for(int i=0; i<stringArr.length; i++){
            int count=1;
            int index = ((calculateKey(stringArr[i]))%hashTable.length);
            while(hashTable[index]!=null){
                collisions++;
                index = (((index + count*count))%hashTable.length);
                count++;
            }
            hashTable[index]=stringArr[i];
            loadsize++;
            if((loadsize/hashTable.length)>.5){
                String freshArray[]= new String[(int)loadsize];
                int f=0;
                for(int nA=0;nA<hashTable.length;nA++){
                    if(hashTable[nA]!=null){
                        freshArray[f]=hashTable[nA];
                        f++;
                    }
                }
                for(int nl=0; nl<hashTable.length;nl++){
                    hashTable[nl]=null;
                }

                collisions= collisions+rehashing(freshArray);
              // int rehashSize= nearestPrime((hashTable.length)*2);
               // hashTable(rehashSize);
                //insertQuadratic(freshArray,hashTable);
                //rehashing(freshArray,hashTable);
              /*  System.out.println("***************************");
                for(int l=0;l<freshArray.length;l++){
                    System.out.print(freshArray[l]+" ");

                }
                System.out.println();
                System.out.println("***************************");*/



            }
        }
return collisions;
        }



    public static void main(String[] args) {
	// write your code here
        Main hashM = new Main();
String stringArr[] = {"iBchRYJB","xvu Gx", "dvfaDQxL", "Rla", "vbLorLjz", "v qyB", "rYlNbRLG", "ghg", "LE RnBX", "vJnYVhgI", "GCVp",
        "VHMuT", "YMiwOr", "iNPuSOX", "Y saHWnh", "Iew ", "rF ZHv", "RCW j", "pOQit", "eZYQpypA" };
        hashM.hashTableCreate(31);

        

System.out.println();
   int collisions=hashM.insertQuadratic(stringArr);

System.out.println("Hash table with collision resolution scheme of open addressing - quadratic is below:\n");

for(int k=0;k<hashTable.length;k++){
    if(((k%10)==0)&&(k!=0)){
        System.out.println();
    }
    if(hashTable[k]==null){
        System.out.print("**"+" ");
    }
    else{

    System.out.print("\""+hashTable[k]+"\""+" ");}

}
System.out.println();

System.out.println();
System.out.println("Total number of collisions occurred: "+collisions);
        System.out.println();
    }
}
