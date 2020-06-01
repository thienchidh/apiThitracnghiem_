package io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Config {
    protected String basePath;

    public Config(String basePath) {
        this.basePath = basePath;
        this.basePath = System.getProperty("user.dir") + "/" + basePath + "/";
        File file = new File(this.basePath);
        if (!file.exists()) {
            boolean ignoredResult = file.mkdirs();
        }
    }

    public synchronized File createFileIfNotExist(String fileName) {
        String path = basePath + "/" + fileName;
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public synchronized Date getLastModifiedFile(String fileName) {
        File file = createFileIfNotExist(fileName);
        return new Date(file.lastModified());
    }

}
