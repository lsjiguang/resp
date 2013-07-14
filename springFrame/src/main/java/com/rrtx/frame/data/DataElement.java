package com.rrtx.frame.data;

public class DataElement
{
  private String name;
  private String destName;
  private boolean append = false;

  public DataElement()
  {
  }

  public DataElement(String name)
  {
    this.name = name;
  }

  public Object clone()
  {
    DataElement element = new DataElement(this.name);
    element.setAppend(this.append);
    return element;
  }

  public void reset()
  {
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setId(String id) {
    this.name = id;
  }

  public String getName()
  {
    return this.name;
  }

  public String toString()
  {
    return toString(0);
  }

  public String toString(int tabCount) {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < tabCount; i++)
      buf.append("\t");
    buf.append("<DataElement id=\"");
    buf.append(this.name);
    if (((this instanceof IndexedCollection)) || ((this instanceof KeyedCollection)))
    {
      buf.append("\" append=\"" + this.append + "\"/>");
    }
    else buf.append("\"/>");
    return buf.toString();
  }

  public String toJSon() {
    StringBuffer buf = new StringBuffer();
    return buf.toString();
  }

  public boolean isAppend()
  {
    return this.append;
  }

  public void setAppend(boolean value)
  {
    this.append = value;
  }

  public void setDynamic(String append)
  {
    setAppend("true".equals(append));
  }

  public String getDestName() {
    return this.destName;
  }

  public void setDestName(String destName) {
    this.destName = destName;
  }
}