import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {

    public static void main(String[] args) {



    }

    public static String [][] readFile (String fileName) {

        String [][] data = null;

        try {
            FileReader fr = new FileReader (fileName);
            BufferedReader br = new BufferedReader (fr);

            int col=0, row=0;
            String line = null;

            while ((line = br.readLine()) != null) {
                row++;
                String [] column = line.split("\t");
                col = column.length;

            }

            int i=0, j=0;
            //System.out.println("No of row and col : "+row+" "+col);
            data  = new String [row][col];
            br = new BufferedReader (new FileReader (fileName));

            while((line = br.readLine())!=null) {
                String [] column = line.split("\t");
                for (j=0; j<column.length; j++) {
                    data[i][j] = column[j];
                    //System.out.println(column[j]);
                }
                i++;
            }

            br.close();
            fr.close();
        }
        catch(Exception e) {
            System.err.print("Unable to read the file");
        }
        return data;
    }

    public static void printData (Object [][] data) {
        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data[i].length; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }



}