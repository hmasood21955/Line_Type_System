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
class Line{

   static final int MAX_LINES = 25;
   static LineType[] page = new LineType[25];
    static int lineCount = 0;
    public static void enterLines(BufferedReader reader) throws IOException {
        if (lineCount >= MAX_LINES) {
            System.out.println("Page is full. Cannot add more lines.");
            return;
        }
        System.out.println("Enter Line #: " + (lineCount + 1));
        String text = reader.readLine();
        page[lineCount++] = new LineType(text);
    }
    public static void retrieveAllLines() {
        for (int i = 0; i < lineCount; i++) {
            System.out.println("Line #" + (i + 1) + ": " + page[i].line);
        }
    }
    public static void retrieveAndReverseLine(BufferedReader reader) throws IOException {
        System.out.println("Enter Line #: ");
        String lineNumberStr = reader.readLine();
        int lineNumber = Integer.parseInt(lineNumberStr);

        if (lineNumber > 0 && lineNumber <= lineCount) {
            String line = page[lineNumber - 1].line;
            String reversed = new StringBuilder(line).reverse().toString();
            System.out.println("Reversed Line: " + reversed);
        } else {
            System.out.println("Invalid Line Number");
        }
    }
    public static void deleteLine(BufferedReader reader) throws IOException {
        System.out.println("Enter Line # to Delete: ");
        String lineNumberStr = reader.readLine();
        int lineNumber = Integer.parseInt(lineNumberStr);

        if (lineNumber > 0 && lineNumber <= lineCount) {
            for (int i = lineNumber - 1; i < lineCount - 1; i++) {
                page[i] = page[i + 1];
            }
            page[--lineCount] = null;
            System.out.println("Line " + lineNumber + " Deleted Successfully");
        } else {
            System.out.println("Invalid Line Number");
        }
    }
    public static void retrieveLongestLine() {
        if (lineCount == 0) {
            System.out.println("No lines available.");
            return;
        }
        LineType longestLine = page[0];
        for (int i = 1; i < lineCount; i++) {
            if (page[i].line.length() > longestLine.line.length()) {
                longestLine = page[i];
            }
        }
        System.out.println("Longest Line: " + longestLine.line);
    }
    public static void deleteWordInLine(BufferedReader reader) throws IOException {
        System.out.println("Enter Line #: ");
        String lineNumberStr = reader.readLine();
        int lineNumber = Integer.parseInt(lineNumberStr);

        if (lineNumber > 0 && lineNumber <= lineCount) {
            System.out.println("Enter Word to Delete: ");
            String word = reader.readLine();
            page[lineNumber - 1].line = page[lineNumber - 1].line.replace(word, "").trim();
            System.out.println("Word deleted successfully.");
        } else {
            System.out.println("Invalid Line Number");
        }
    }
    public static void deleteLongLines() {
        for (int i = 0; i < lineCount; ) {
            if (page[i].line.length() > 50) {
                for (int j = i; j < lineCount - 1; j++) {
                    page[j] = page[j + 1];
                }
                page[--lineCount] = null;
                System.out.println("Deleted line with more than 50 characters");
            } else {
                i++;
            }
        }
    }
    public static void updateLine(BufferedReader reader) throws IOException {
        System.out.println("Enter Line #: ");
        String lineNumberStr = reader.readLine();
        int lineNumber = Integer.parseInt(lineNumberStr);

        if (lineNumber > 0 && lineNumber <= lineCount) {
            System.out.println("Enter new content: ");
            String newContent = reader.readLine();
            page[lineNumber - 1].line = new LineType(newContent).line;
            System.out.println("Line updated successfully.");
        } else {
            System.out.println("Invalid Line Number");
        }
    }
}

