package com.foldik.xml.homework.xml.homework.util;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser {
    public void parseWithDom(){

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse("C:\\Users\\Kalmi\\Documents\\homework\\xml-homework\\xml-homework\\src\\main\\resources\\rectangle-example.xml");

            //get the rootelement
            NodeList element = document.getElementsByTagName("Rectangle");


            NodeList list = element;
            double totWidth = 0;
            double totHeight = 0;
            double totX = 0;
            double totY = 0;


            int listLength = list.getLength();

            for(int i=0;i<listLength;i++){
                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element nelement = (Element) node;
                    System.out.println("\n" + node.getNodeName());

                    System.out.println("Width : "+ nelement.getAttribute("Width"));
                    totWidth = totWidth + Double.parseDouble(nelement.getAttribute("Width"));

                    System.out.println("Height : "+ nelement.getAttribute("Height"));
                    totHeight = totHeight + Double.parseDouble(nelement.getAttribute("Height"));

                    System.out.println("X : "+ nelement.getAttribute("X"));
                    totX = totX + Double.parseDouble(nelement.getAttribute("X"));

                    System.out.println("Y : "+ nelement.getAttribute("Y"));
                    totY = totY + Double.parseDouble(nelement.getAttribute("Y"));
                }
            }
            System.out.println("----------------------------------------------");
            System.out.println("The average Width is: " +totWidth/listLength);
            System.out.println("The average Height is: " +totHeight/listLength);
            System.out.println("The average X is: " +totX/listLength);
            System.out.println("The average Y is: " +totY/listLength);



        }catch(ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }



    }
}
