package com.foldik.xml.homework.xml.homework.util;


import com.foldik.xml.homework.xml.homework.model.Rectangle;
import org.apache.commons.io.IOUtils;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.Writer;

public class RectangleXmlBuilder {

    private static final String OBJECTS_TAG = "Objects";
    private Writer writer;
    private XMLStreamWriter xMLStreamWriter;

    public RectangleXmlBuilder(Writer writer) {
        try {
            this.writer = writer;
            xMLStreamWriter = XMLOutputFactory.newFactory().createXMLStreamWriter(writer);
            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeStartElement(OBJECTS_TAG);
        } catch (XMLStreamException e) {
            closeSteamsAndThrowIllegalStateException(e);
        }
    }

    public RectangleXmlBuilder addRectangle(Rectangle rectangle) {
        try {
            xMLStreamWriter.writeStartElement("Rectangle");
            xMLStreamWriter.writeAttribute("Width", Double.toString(rectangle.getWidth()));
            xMLStreamWriter.writeAttribute("Height", Double.toString(rectangle.getHeight()));
            xMLStreamWriter.writeAttribute("X", Double.toString(rectangle.getX()));
            xMLStreamWriter.writeAttribute("Y", Double.toString(rectangle.getY()));
            xMLStreamWriter.writeAttribute("Color", rectangle.getColor().getHex());
            xMLStreamWriter.writeEndElement();
        } catch (XMLStreamException e) {
            closeSteamsAndThrowIllegalStateException(e);
        }
        return this;
    }

    public void close() {
        try {
            xMLStreamWriter.writeEndDocument();
            xMLStreamWriter.flush();
            xMLStreamWriter.close();
            IOUtils.closeQuietly(writer);
        } catch (XMLStreamException e) {
            closeSteamsAndThrowIllegalStateException(e);
        }
    }

    private void closeSteamsAndThrowIllegalStateException(XMLStreamException e) {
        if (xMLStreamWriter != null) {
            try {
                xMLStreamWriter.close();
            } catch (XMLStreamException e1) {
                throw new IllegalStateException(e1);
            }
            IOUtils.closeQuietly(writer);
        }
        throw new IllegalStateException(e);
    }
}
