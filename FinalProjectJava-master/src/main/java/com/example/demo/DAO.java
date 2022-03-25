package com.example.demo;

import java.util.*;

public class DAO {
    public Map FilterByColumn(List<String> columnName ) {
        Hashtable<String, Integer> freq= new Hashtable<String, Integer>();
        for (String r:columnName){
            freq.put(r, Collections.frequency(columnName, r));
        }


        Map sorted = sort(freq);

        return sorted;
    }
    public Map  filterSkills(List<List<String>> skills){
        List<String> skillsLst=new ArrayList<>();
        for (List<String> r:skills){
            for(int k=0;k<r.size();k++){
                skillsLst.add(r.get(k));
            }
        }

        return FilterByColumn(skillsLst);

    }


    public Map<String, Integer> sort(Map<String, Integer> freq){
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(freq.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        Map<String, Integer> sorted = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> i : list) {
            sorted.put(i.getKey(), i.getValue());
        }

        return sorted;
    }

    public void printFreq(Map<String, Integer> freqTable, String name, int top) {
        System.out.println("\nMost Popular " + name + ":\n");
        final int[] cnt = {freqTable.size()};
        freqTable.forEach(
                (k, v) -> {
                    cnt[0] -= 1;
                    if (cnt[0] <= top) {
                        System.out.println(k + " : " + v);
                    }
                });



    }

    public Map webPrint(Map<String,Integer> m,int top){

        Map<String,Integer> map=new HashMap();
        final int[] cnt = {m.size()};
        m.forEach(
                (k, v) -> {
                    cnt[0] -= 1;
                    if (cnt[0] <= top) {
                        map.put(k,v);
                    }
                });
        return sort(map);
    }
}
