package com.foldik.xml.homework.xml.homework.util;

import com.foldik.xml.homework.xml.homework.model.Rectangle;

import javax.xml.stream.*;
import javax.xml.stream.events.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;


public class StaxParser {


    public void parseWithStax() {

        double totWidth = 0;
        double totHeight = 0;
        double totX = 0;
        double totY = 0;
        int listLength = 0;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(
                            new FileReader("C:\\Users\\Kalmi\\Documents\\homework\\xml-homework\\xml-homework\\src\\main\\resources\\rectangle-example.xml"));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("Rectangle")) {
                            System.out.println("Start Element : Rectangle");
                            listLength = listLength + 1;


                            Iterator<Attribute> attributes = startElement.getAttributes();

                            String color = attributes.next().getValue();
                            System.out.println("Color : " + color);

                            String x = attributes.next().getValue();
                            System.out.println("X : " + x);
                            totX = totX + Double.parseDouble(x);

                            String y = attributes.next().getValue();
                            System.out.println("Y : " + y);
                            totY = totY + Double.parseDouble(y);

                            String height = attributes.next().getValue();
                            System.out.println("Height : " + height);
                            totHeight = totHeight + Double.parseDouble(height);

                            String width = attributes.next().getValue();
                            System.out.println("Width : " + width);
                            totWidth = totWidth + Double.parseDouble(width);


                        } else System.out.println("---------------------------------------------");
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("Rectangle")) {
                            System.out.println("End Element : Rectangle");
                            System.out.println("-------------------------------");
                        }
                        break;


                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------");
        System.out.println("The average Width is: " +totWidth/listLength);
        System.out.println("The average Height is: " +totHeight/listLength);
        System.out.println("The average X is: " +totX/listLength);
        System.out.println("The average Y is: " +totY/listLength);
    }
}
