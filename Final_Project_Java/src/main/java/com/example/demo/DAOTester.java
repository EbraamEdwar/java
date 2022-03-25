package com.example.demo;

import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOTester {
    List<String> title = new ArrayList<>();
    List<String> company= new ArrayList<>();
    List<String> location= new ArrayList<>();
    List<String> type= new ArrayList<>();
    List<String> level= new ArrayList<>();
    List<String> yearsExp= new ArrayList<>();
    List<String> country= new ArrayList<>();
    List<List<String>> skills= new ArrayList<>();
    HashMap<String,String> dataInfo=new HashMap<>();
    DAO t=new DAO();

    public DAOTester() {
        IO csv = new IO();
        List<POJO> jobs= new ArrayList<>();
        jobs = csv.readCSVFile("src/main/java/com/example/demo/Wuzzuf_Jobs.csv");


        for(POJO j:jobs)
        {
            assert false;
            title.add(j.getTitle());
            company.add(j.getCompany());
            location.add(j.getLocation());
            type.add(j.getType());
            level.add(j.getLevel());
            yearsExp.add(j.getYearsExp());
            country.add(j.getCountry());
            skills.add(j.getSkills());

        }
        Table job = Table.create("Jobs").addColumns(
                StringColumn.create("Title", title),
                StringColumn.create("Company", company),
                StringColumn.create("Location", location),
                StringColumn.create("Type", type),
                StringColumn.create("Level", level),
                StringColumn.create("Years of Experience", yearsExp),
                StringColumn.create("Country", country));
        dataInfo.put("DataSet Shape before cleaning",job.shape());
        System.out.println(job.structure());
        System.out.println(job.shape());
        System.out.println(job.first(5));
        System.out.println(job.summary());
        job = job.dropDuplicateRows();
        dataInfo.put("DataSet Shape after dropping duplicates",job.shape());
        job = job.dropRowsWithMissingValues();
        job= job.where(job.stringColumn("Years of Experience").isNotEqualTo("null Yrs of Exp"));
        dataInfo.put("DataSet Shape after dropping Null Values",job.shape());
        System.out.println(job.shape());
        t.printFreq(t.FilterByColumn(company), "Company",5);
        t.printFreq(t.FilterByColumn(title), "Titles",5);
        t.printFreq(t.FilterByColumn(location), "Area",10);
        t.printFreq(t.filterSkills(skills),"Skills",10);



        charts v= new charts();
        v.piechart(t.FilterByColumn(company),"Top Job Demanding Companies", 10);
        v.barchart(t.FilterByColumn(title), "Top Job Titles","Titles", 5);
        v.barchart(t.FilterByColumn(location), "Top Job Demanding Areas","Area", 6);
        v.piechart(t.filterSkills(skills), "Top Required Job Skills", 10);



    }
    public Map data(){
        return dataInfo;
    }


    public Map getTitle() {


        return t.webPrint(t.FilterByColumn(this.title),10);
    }

    public Map getCompany() {


        return   t.webPrint(t.FilterByColumn(this.company),10);
    }

    public Map getCountry() {


        return   t.webPrint(t.FilterByColumn(this.location),5);
    }

    public Map getSkills() {
        Map skill=t.webPrint(t.filterSkills (this.skills),10);

        return  skill;
    }
}
