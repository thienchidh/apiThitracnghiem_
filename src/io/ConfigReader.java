package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ConfigReader extends Config {

    public ConfigReader() {
        super("");
    }

    public ConfigReader(String basePath) {
        super(basePath);
    }

    public synchronized String readFileAsString(String fileName) {
        createFileIfNotExist(fileName);

        String newPath = basePath + "/" + fileName;

        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(newPath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
