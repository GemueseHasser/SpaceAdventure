package de.jonas.spaceadventure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.yaml.snakeyaml.Yaml;

public class WriteInfosInConfig {

    Map<String, Object> data = new HashMap<>();

    public WriteInfosInConfig() {
        Properties properties = System.getProperties();
        String path = WriteInfosInConfig.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath = null;
        try {
            decodedPath = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        data.put("author", "Jonas");
        data.put("version", "1.0");
        data.put("file", decodedPath);
        data.put("os", properties.getProperty("os.name"));

        Yaml yaml = new Yaml();
        FileWriter writer = null;
        try {
            writer = new FileWriter(getClass().getResource("/de/jonas/res/config.yml").getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        yaml.dump(data, writer);
        System.out.println(data);
        write();
    }

    private void write() {
        PrintWriter pWriter = null;

        if (data.get("os") == "Linux") {
            try {
                pWriter = new PrintWriter(
                    new BufferedWriter(new FileWriter(getClass().getResource("/de/jonas/res/restart.sh").getFile())));
                pWriter.println("sleep 3 && java -jar " + data.get("file"));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                if (pWriter != null) {
                    pWriter.flush();
                    pWriter.close();
                }
            }
        } else {
            try {
                pWriter = new PrintWriter(
                    new BufferedWriter(new FileWriter(getClass().getResource("/de/jonas/res/restart.bat").getFile())));
                pWriter.println("@echo off");
                pWriter.println("ping 127.0.0.1 -n 3 -w 1000 > nul");
                pWriter.println("java -jar " + data.get("file"));
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                if (pWriter != null) {
                    pWriter.flush();
                    pWriter.close();
                }
            }
        }
    }

}
