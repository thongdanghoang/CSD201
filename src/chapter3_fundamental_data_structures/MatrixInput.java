/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter3_fundamental_data_structures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thong
 */
public class MatrixInput {

    public int[][] read() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("source.txt")));
        String strLength = sc.nextLine();
        int intLength = Integer.parseInt(strLength);
        int[][] read = new int[intLength][intLength];
        while (sc.hasNextLine()) {
            for (int[] myArray1 : read) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    myArray1[j] = Integer.parseInt(line[j]);
                }
            }
        }
        return read;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.deepToString(new MatrixInput().read()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatrixInput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
