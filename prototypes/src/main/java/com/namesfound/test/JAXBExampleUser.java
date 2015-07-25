package com.namesfound.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author marcel-serra.ribeiro on 23/07/2015.
 */
public class JAXBExampleUser {
  private static final String FILE_NAME = "jaxb-user.xml";

  public static void main(String[] args) {
    User user = new User("John", "Doo");
    jaxbObjectToXML(user);
    User empFromFile = jaxbXMLToObject();
    System.out.println(empFromFile.toString());

    try {
      FileInputStream fileInputStream = new FileInputStream(new File(FILE_NAME));
      User user2 = jaxbXMLStringToObject(fileInputStream);
      System.out.println(user2.toString());
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }


  private static User jaxbXMLToObject() {
    try {
      JAXBContext context = JAXBContext.newInstance(User.class);
      Unmarshaller un = context.createUnmarshaller();
      User user = (User) un.unmarshal(new File(FILE_NAME));
      return user;
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return null;
  }


  private static void jaxbObjectToXML(User emp) {

    try {
      JAXBContext context = JAXBContext.newInstance(User.class);
      Marshaller m = context.createMarshaller();
      //for pretty-print XML in JAXB
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

      // Write to System.out for debugging
      // m.marshal(emp, System.out);

      // Write to File
      m.marshal(emp, new File(FILE_NAME));
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }


  private static User jaxbXMLStringToObject(InputStream input) {
    try {
      JAXBContext context = JAXBContext.newInstance(User.class);
      Unmarshaller un = context.createUnmarshaller();
      User user = (User) un.unmarshal(input);
      return user;
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return null;
  }


}
