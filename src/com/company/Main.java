package com.company;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {


        HashMap<String, TestSubject> hashMap = new HashMap<>();
        String selectedString = "";
        for (int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            hashMap.put(subject.getId(), subject);
            System.out.println(i);
            if (i == 27) {
                selectedString = subject.getId();
                System.out.println(selectedString);
                System.out.println(i);
            }

        }

        System.out.println(hashMap.get(selectedString).getId());

        if (hashMap.get(selectedString).getId() == selectedString) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");


        }

        TreeMap<Integer, TestSubject> subjectTreeMap = new TreeMap<>(new TestComparator());
        for (int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            subjectTreeMap.put(subject.getOrdinal(), subject);

        }
        System.out.println(subjectTreeMap.lastEntry());

        Parser parser = new Parser();
        ArrayList<String> list = new ArrayList<String>();
        File file = new File("voyna.Tom1.txt");
        try {
            list = parser.parse(file);
            System.out.println(getCount(list));

        } catch (IOException e) {
            e.printStackTrace();
        }

        for ( int i = 1; i <=10; i++){
            for (int t = 1; t <=10; t++){
                System.out.print(i*t + " ");
            }
            System.out.println("");
        }

    }
    public static int getCount (ArrayList<String> list) {
        int count = 0;
        String getPattern = " страдани[е€юй]";
        Pattern pattern = Pattern.compile(getPattern, Pattern.CASE_INSENSITIVE);
        for (String s : list) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()){
                count++;
            }
        }
        return count;
    }


    }