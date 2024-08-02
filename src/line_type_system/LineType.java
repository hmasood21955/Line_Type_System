/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package line_type_system;

/**
 *
 * @author Masood Hussain
 */
public class LineType {
    String line;
    LineType(String line) {
        if (line.length() <= 80) {
            this.line = line;
        } else {
            System.out.println("Line exceeds 80 characters. It will be truncated.");
            this.line = line.substring(0, 80);
        }
    }
}
