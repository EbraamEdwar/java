package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebTester {
    DAOTester t=new DAOTester();
    @RequestMapping("/dataSummary")
    public ResponseEntity<Object> printSummary(){
       return new ResponseEntity<>(t.data(), HttpStatus.OK);
   }
    @RequestMapping("/popularTitles")
    public ResponseEntity<Object> printTitles(){
        return new ResponseEntity<>(t.getTitle(), HttpStatus.OK);
    }
    @RequestMapping("/popularSkills")
    public ResponseEntity<Object> printSkills() {
       return new ResponseEntity<>(t.getSkills(), HttpStatus.OK);
   }
    @RequestMapping("/popularAreas")
    public ResponseEntity<Object> printAreas() {
        return new ResponseEntity<>(t.getCountry(), HttpStatus.OK);
    }
    @RequestMapping("/popularCompanies")
    public ResponseEntity<Object> printCompanies() {
        return new ResponseEntity<>(t.getCompany(), HttpStatus.OK);
    }
}
