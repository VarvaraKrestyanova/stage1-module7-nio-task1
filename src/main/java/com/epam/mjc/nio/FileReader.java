package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String[] arrLineData;
            String line;
            while ((line = reader.readLine()) != null) {
                arrLineData = line.split(": ");

                switch (arrLineData[0]) {
                    case "Name": {name = arrLineData[1]; break;}
                    case "Age": {age = Integer.valueOf(arrLineData[1]); break;}
                    case "Email": {email = arrLineData[1];  break;}
                    case "Phone": {phone = Long.valueOf(arrLineData[1]); break;}
                    default: {
                        throw new UnknownProfileKeyException(arrLineData[0]);
                    }
                }
            }
        } catch (UnknownProfileKeyException | IOException e) {
            e.printStackTrace();
        }

        return new Profile(name, age, email, phone);
    }
}
