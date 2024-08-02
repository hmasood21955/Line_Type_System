/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package line_type_system;
import java.io.*;
/**
 *
 * @author Masood Hussain
 */
public class Line_Type_System {
public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("1. Enter Lines");
            System.out.println("2. RetrieveAll Lines");
            System.out.println("3. Retrieve and Reverse Line");
            System.out.println("4. Delete Line");
            System.out.println("5. Retrieve Longest Line");
            System.out.println("6. Delete Word in Line");
            System.out.println("7. Delete Long Lines");
            System.out.println("8. Update Line");
            System.out.println("9. Exit");

            System.out.println("Enter your choice: ");
            String choiceStr = reader.readLine();
            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    Line.enterLines(reader);
                    break;
                case 2:
                    Line.retrieveAllLines();
                    break;
                case 3:
                    Line.retrieveAndReverseLine(reader);
                    break;
                case 4:
                    Line.deleteLine(reader);
                    break;
                case 5:
                    Line.retrieveLongestLine();
                    break;
                case 6:
                    Line.deleteWordInLine(reader);
                    break;
                case 7:
                    Line.deleteLongLines();
                    break;
                case 8:
                    Line.updateLine(reader);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }  
}
