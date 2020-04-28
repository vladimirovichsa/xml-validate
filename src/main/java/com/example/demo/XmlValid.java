package com.example.demo;

import com.ctc.wstx.stax.WstxInputFactory;

import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.validation.XMLValidationSchema;
import org.codehaus.stax2.validation.XMLValidationSchemaFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLStreamException;

public class XmlValid {

    public static void main(String[] args) {
        validate();
    }

    public static boolean validate() {
        try {
            InputStream reader = XmlValid.class.getClassLoader().getResourceAsStream("xml/v134/416/416_01.xml");
            URL resource = XmlValid.class.getClassLoader().getResource("xsd/public/134/documents.xsd");
            XMLValidationSchema schema = XMLValidationSchemaFactory
                    .newInstance(XMLValidationSchema.SCHEMA_ID_W3C_SCHEMA)
                    .createSchema(
                            new FileReader(resource.getFile()),
                            resource.getPath(),
                            resource.getPath());

            XMLStreamReader2 xmlReader = (XMLStreamReader2) new WstxInputFactory().createXMLStreamReader(reader);
            xmlReader.validateAgainst(schema);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
