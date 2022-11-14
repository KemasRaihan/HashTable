public class DoubleHashing {

    static String [][] storage = new String [242][10];
    public static void main(String[] args) {

//        System.out.println("Double Hashing: ");
//        System.out.println("----------------");
//        insert(9, "Zairul"); //9%5 = 4
//        insert(5, "Mazwan"); //5%5 = 0
//        insert(12, "Jilani"); //12%5 = 2
//        insert(15, "Rania");//iter 0 : 15%5 = 0, iter 1 :  (1*3)%5 = 3
//        insert(23, "Mehmet"); //iter 0 : 23%5 = 3, iter 1: (4*1)%5 = 4, iter 2 : (5*1)%5 = 0, iter 3 : (6*1)%5 = 1, iter 4: (7*1)%5 = 2
//
//        printData();

        String fileName = "G:\\My Drive\\Sheffield Hallam University\\Second Year\\Algorithms and Data Structures\\Week 7\\Week 7 Lab - Hashtable and Doubly Linked List.docx-EmbeddedFile.xlsm - iso-country-codes.txt";
        String [][] array = ReadFile.readFile(fileName);

        int key;
        String country;
        for(int i = 1; i < array.length-1; i++){
            key = Integer.parseInt(array[i][3]);
            country = array[i][0];
            insert(key, country);

        }

        printData();

    }

    public static void insert (int key, String name) {

        int i = 0;
        int index = hashFunction(key, i); // return index of the given position

        while (collision(index)==true) {
            i++;//increment the i for the next interation if there is collision
            index = hashFunction(key, i); //get the first hash with i incremented
            index *= doubleHash (key); //get the second hash and product with the first hash
            index %= storage.length;
            //System.out.println(i);

            System.out.print("Key : "+key+ " i : "+i);
            System.out.println(" index : "+index);
        }
        storage[index][0] = String.valueOf(key);
        storage[index][1] = name;
    }

    public static int hashFunction (int key, int i) {
        int index = (key%storage.length)+i;
        return index;
    }

    public static int doubleHash (int key) {
        int index = 7 - (key%7);
        return index;
    }

    public static boolean collision (int index) {
        boolean col = false;

        if (storage[index][0]!=null) {
            col = true;
        }
        return col;
    }

    public static void printData () {
        for (int i = 0; i<storage.length; i++) {
            System.out.print(i + " - " + storage[i][0]);
            System.out.print(" " + storage[i][1]);
            System.out.println();
        }
    }

}