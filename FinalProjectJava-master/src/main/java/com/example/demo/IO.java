package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IO {
    public List<POJO> readCSVFile(String fileName) {
        List<POJO> jobs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line = br.readLine();

            if (line != null) {
                line = br.readLine();
            }

            while (line != null) {
                String[] attributes = line.split(",");
                POJO j = createJob(attributes);
                jobs.add(j);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return jobs;
    }

    public POJO createJob(String[] metadata) {

        String title= metadata[0];
        String company= metadata[1] ;
        String location= metadata[2];
        String type= metadata[3];
        String level= metadata[4];
        String yearsExp= metadata[5];
        String country= metadata[6];
        List<String> skills=new ArrayList<>();
        for(int k=7;k<metadata.length;k++){
            skills.add(metadata[k]);
        }


        return new POJO(title,company,location,type,level,yearsExp,country,skills);
    }
}
