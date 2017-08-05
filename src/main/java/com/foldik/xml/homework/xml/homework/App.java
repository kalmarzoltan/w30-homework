package com.foldik.xml.homework.xml.homework;


import com.foldik.xml.homework.xml.homework.util.DomParser;
import com.foldik.xml.homework.xml.homework.util.StaxParser;

public class App {

    public static void main(String[] args) {

        //DomParser parser1 = new DomParser();
        //parser1.parseWithDom("C:\\Users\\Kalmi\\Documents\\homework\\xml-homework\\xml-homework\\src\\main\\resources\\rectangle-example.xml");

        //StaxParser parser2 = new StaxParser();
        //parser2.parseWithStax();

        DomParser parser3 = new DomParser();
        parser3.parseWithDom("C:\\Users\\Kalmi\\Documents\\homework\\xml-homework\\xml-homework\\src\\main\\resources\\invalid-rectangle-xml-example.xml");

    }
}
