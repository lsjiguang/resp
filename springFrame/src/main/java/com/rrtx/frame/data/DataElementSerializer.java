package com.rrtx.frame.data;

public class DataElementSerializer
{ 
  public static String doSerialize(DataElement element)
  {
    String xmlHead = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
    return xmlHead + element.toString();
  }

}
