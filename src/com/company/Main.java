package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       ListH<String> list = new ListH<>();
        list.add("Fisting");
        list.add("anal");
        list.add("gfgf");

        for(int i =0; i< list.length(); i++){
            try {
                System.out.println(list.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("gfdgd");



    }

    }
