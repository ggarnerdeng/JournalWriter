//Garner Deng
//JournalWriter.java
//10/12/2022

import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import javax.swing.JOptionPane;

class JournalWriter {
    public static void main(String[] args) {

        File Journals = new File("Journals.txt");
        try {
            if (!Journals.exists()) {

                System.out.printf("\nCreating 'Journals.txt'.");
                Journals.createNewFile();

                FileWriter writer = new FileWriter(Journals, true);
                writer.write("First Journal Entry\n");
                writer.close();
            } 

            FileWriter writeHere = new FileWriter(Journals, true);
            BufferedWriter br = new BufferedWriter(writeHere);
            Scanner input = new Scanner(System.in);

            String prompInput = JOptionPane.showInputDialog(null, """
                This is a daily Journal.
                3 Things you are grateful for.
                What happened today.
                What will happen tomorrow.
                """);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  

            br.write("\n"+dtf.format(now)+"\n"+prompInput+"\n");

            input.close();
            br.close();
            writeHere.close();
        }

        catch (IOException e) {
            System.out.printf("\nError. Check the file 'Journals.txt'.");
        }
    }
}