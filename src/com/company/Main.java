         /*
         *
         * Classname: Main
         *
         * @version 22.06.2020
         * @author Serhii Tronevych

         * Module 4 task 1
         *
         * Home task. Files management.
         *
         *  1. Parse the file logs.txt (see the attachment).
         *  2. Calculate the total number of logs (lines).
         *  3. Calculate the total  number of  ERROR logs.
         *  Use previous skills - String.split
         *  4. Calculate the total number of ERROR logs. Use Files.lines.
         *  5. Compare two results.
         *
         */
         package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Main {

    public static void main(String[] args) throws IOException {

         /*@param 'startReturn'  return time start
         counting ERROR lines in the String.split way*/

        LocalDateTime startReturn = LocalDateTime.now();


         /*@param text return text from file logs.txt*/

        String text = new String(Files.readAllBytes(Paths.get
                ("C:\\Users\\Administrator\\Desktop\\logs.txt")));


          /*@param lines return text return
          String array of lines from file logs.txt*/

        String[] lines = text.split("\\n");

        System.out.println("\n This file logs.txt contains: " +
                lines.length + " lines");

        /* @param txtErrors return count of lines
         with ERROR from file logs.txt*/

        int txtErrors = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("ERROR")){
                txtErrors++;
            }
        }

        System.out.println
                ("\n This text file logs.txt contains: "
                        + txtErrors + " ERROR logs");

      /*  @param 'finishReturn' return time finish
         counting ERROR lines in the String.split way*/

        LocalDateTime finishReturn = LocalDateTime.now();

        System.out.println("For finding ERRORS needs to use String.split "
                + ChronoUnit.MILLIS.between(startReturn, finishReturn)
                + " ms");


         /*@param startFiles return time start
         counting ERROR lines in the String.split way*/

        LocalDateTime startFiles = LocalDateTime.now();


         /*@param txtErrors2 return count of lines
         with ERROR from file logs.txt*/

        final long txtErrors2 =
                Files.lines(Paths.get("C:\\Users\\Administrator\\Desktop\\logs.txt"))
                        .filter(line -> line.contains("ERROR"))
                        .count();

        System.out.println("\n This text file logs.txt contains: "
                + txtErrors2 + " ERROR logs");

        /* @param finishFiles return time finish
         counting ERROR lines in the String.split way*/

        LocalDateTime finishFiles = LocalDateTime.now();

        System.out.println("For finding ERRORS needs to use Files.lines "
                + ChronoUnit.MILLIS.between(startFiles, finishFiles)
                + " ms");

    }
}