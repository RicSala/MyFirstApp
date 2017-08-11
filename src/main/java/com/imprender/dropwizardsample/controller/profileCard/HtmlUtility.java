package com.imprender.dropwizardsample.controller.profileCard;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HtmlUtility {


  public static String substituteKeysPerValues(String template, Map<String, String> listKeysAndValues) {
    //Given a template String and a Map<String, String> of placeholders and values, it substitutes the
    //placeholders for their value in every instance of the given String

    String customizedString = template;

    for (String placeHolder: listKeysAndValues.keySet() ) {
      customizedString = customizedString.replace("{{"+placeHolder+"}}", listKeysAndValues.get(placeHolder));
      // System.out.println("\\{\\{");
    }
    return customizedString;
  }



  public static String readFile(String path, Charset encoding)
  //COMENTAR CON FERRAN
    throws IOException
  {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
  }



  public static Map<String, Integer[]> findPlaceHolders(String template, String opener, String closer) {
  //FUNCTION: given a String template, an opener String (open placeholder) and a closer String (close placholder)
  //it returns a map of placholders (key) and their coordinates (position of first open and position of last close)

    Map<String, Integer[]> coordinates = new HashMap<String, Integer[]>();
    List<Integer> openerCoordinates = new ArrayList<Integer>();
    List<Integer> closerCoordinates = new ArrayList<Integer>();

    //List of integer with the position of every instance of the placeholders marks
    openerCoordinates = positionsOfSubstring(opener, template);
    closerCoordinates = positionsOfSubstring(closer, template);

    //Creates the output map, combining both coordintes and the name in each item.

    for (int i = 0; i < openerCoordinates.size(); i++) {
      Integer[] coordinate = {openerCoordinates.get(i), closerCoordinates.get(i)}; //create coordinate pairs
      String coordinateName = template.substring(openerCoordinates.get(i)+closer.length(), closerCoordinates.get(i)); //get coordinate name
      coordinates.put(coordinateName, coordinate);
    }

    return coordinates;
  }



  static public List<Integer> positionsOfSubstring (String substring, String text ) {
    //Given a text and a substring, it returns a List<Integer> of the position of each instance of the substring

      List<Integer> coordinates = new ArrayList<Integer>();

      for (int i = 0; i < text.length();) { //increasing by 1 wuold be inneficiente and return repeated values
        coordinates.add(text.indexOf(substring, i));

        //if this instance is the last one, do break the loop
        if (text.indexOf(substring, i) == text.lastIndexOf(substring)) {
          break;
        }

        i = text.indexOf(substring, i) + 1; //each time it finds an instance, it jumps right to the next char
        }
      return coordinates;
  }



}
