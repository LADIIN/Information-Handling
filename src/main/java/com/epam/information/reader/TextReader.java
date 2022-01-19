package com.epam.information.reader;

import com.epam.information.exception.InformationHandlingException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {

    public String read(String filepath) throws InformationHandlingException {
        if (filepath == null || filepath.isEmpty()) {
            throw new InformationHandlingException("Filepath is empty or null.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(filepath);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new InformationHandlingException("Can't open file: ", e);
        }
        return stringBuilder.toString().trim();
    }

}
