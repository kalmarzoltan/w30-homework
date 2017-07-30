package com.foldik.xml.homework.xml.homework;


import com.foldik.xml.homework.xml.homework.util.DomParser;
import com.foldik.xml.homework.xml.homework.util.StaxParser;

public class App {

    public static void main(String[] args) {

        //DomParser parser1 = new DomParser();
        //parser1.parseWithDom();

        StaxParser parser2 = new StaxParser();
        parser2.parseWithStax();



    }
}
