package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ProcessHandle {
    public static synchronized String newMyJavaHandleProcess(String pathToJavaProcess, List<String> args) {
        StringBuilder res = new StringBuilder();
        try {
            List<String> list = new LinkedList<>();
            list.add("java");
            list.add("-jar");
            list.add(pathToJavaProcess);
            list.addAll(args);

            System.out.println(list);

            ProcessBuilder processBuilder = new ProcessBuilder(list);
            Process start = processBuilder.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(start.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String s = res.toString();
        System.out.println(s);
        return s;
    }
}
