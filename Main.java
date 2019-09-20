
/*
Name :
Section :

 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//----------------------------------------
//
// REMARKS:The program is to craate a ,market and  read input file
//          to simulate the creation of investors and cryptocurrencies, and the buying an selling of cryptocurrencies in
//          a market from an inout file 
//          from an input fine
//
//
//-----------------------------------------
public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner keyboard; // To read in the name of the input file
        String fileName; // The name of the input file typed in by the user
        Scanner inFile; // Scanner to read from user's selected file.

        // Allow user to choose file with keyboard (console) input.

        keyboard = new Scanner(System.in);
        System.out.println("\nEnter the input file name (.txt files only): ");
        fileName = keyboard.nextLine();
        System.out.println("");
        try {
            // inFile is now set to read from the file chosen by the user.
            inFile = new Scanner(new File(fileName));
            String[] line = null;
            Market m1 = new Market();
            while (inFile.hasNextLine()) {
                line = inFile.nextLine().split(" ");
                m1.ProcessFile(line);


            }

            System.out.println();
            if ( line[0].equals("END")){
                System.out.println("DONE");
            }
            else {
                System.out.println("Error : There is something wrong with the file ");
            }



        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }
}
