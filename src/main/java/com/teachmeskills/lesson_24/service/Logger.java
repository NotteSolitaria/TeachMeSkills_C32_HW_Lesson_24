package com.teachmeskills.lesson_24.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    public static void log(String message) throws IOException {
        try {
            File logFile = new File("C:\\Users\\danii\\IdeaProjects\\TeachMeSkills_C32_HW_Lesson_24\\src\\main\\resources\\logs.txt");

            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true));

            bw.write(message + LocalDateTime.now());
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
