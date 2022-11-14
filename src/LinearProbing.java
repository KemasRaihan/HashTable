public class LinearProbing {

    static String[] myTable = new String[242];

    public static void main(String[] args) {

//        System.out.println("Linear probing: ");
//        System.out.println("----------------");
//        insert(9, "Zairul");
//        insert(5, "Mazwan");
//        insert(12, "Jilani");
//        insert(15, "Rania");
//        insert(11, "Mehmet");
//
//        //System.out.println(collision (1));
//        printData();

        String fileName = "G:\\My Drive\\Sheffield Hallam University\\Second Year\\Algorithms and Data Structures\\Week 7\\Week 7 Lab - Hashtable and Doubly Linked List.docx-EmbeddedFile.xlsm - iso-country-codes.txt";
        String [][] array = ReadFile.readFile(fileName);
        //printData(array);

        for(int i = 1; i < array.length-1; i++){
            insert(Integer.parseInt(array[i][3]), array[i][0]);
        }

        printData();

    }

    // returns the key
    public static int hashFunction(int key) {
        int index = -1;
        index = key % myTable.length;
        return index;
    }

    // insert item into the table
    public static void insert(int key, String name) {
        //get the index to store the name using hash function
        int index = hashFunction(key);
        int i = 1;
        while (collision(index) == true) {
            index = probLinear(key, i);
            i++;
        }
        // insert data into the name
        myTable[index] = name;
    }

    public static int probLinear(int key, int i) {
        int index = (key + i) % myTable.length;
        return index;
    }

    // check for collision
    public static boolean collision(int index) {
        boolean col = false;
        if (myTable[index] != null) {
            col = true;
        }
        return col;
    }

    public static void printData() {
        for (int i = 0; i < myTable.length; i++) {
            System.out.print(myTable[i]);
            System.out.println();
        }
    }
}

