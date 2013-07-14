package com.rrtx.frame.data;

public class DataField extends DataElement
{
  private Object value;
  private Object defaultValue;
  private String description;
  private String dataType;
  private boolean required = false;

  public DataField()
  {
  }

  public DataField(String name)
  {
    super(name);
  }

  public DataField(String name, Object value)
  {
    super(name);
    setValue(value);
  }

  public void setDescription(String desc)
  {
    this.description = desc;
  }

  public void setDefaultValue(Object value)
  {
    this.defaultValue = value;
  }

  public void setValue(Object value)
  {
    this.value = value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getDescription()
  {
    return this.description;
  }

  public Object getDefaultValue()
  {
    return this.defaultValue;
  }

  public Object getValue()
  {
    return this.value;
  }

  public void setDataType(String type)
  {
    this.dataType = type;
  }

  public String getDataType()
  {
    return this.dataType;
  }

  public Object clone()
  {
    DataField field = new DataField();
    field.setName(getName());
    field.setValue(this.value);

    field.setDataType(this.dataType);
    field.setAppend(isAppend());
    return field;
  }

  public void reset()
  {
  }

  public String toString()
  {
    return toString(0);
  }

  public String toString(int tabCount)
  {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < tabCount; i++)
      buf.append("\t");
    buf.append("<field id=\"");
    buf.append(getName());
    if (this.value != null) {
      buf.append("\" value=\"");
      buf.append(formatXML(this.value.toString()));
    }
    if (this.dataType != null) {
      buf.append("\" dataType=\"");
      buf.append(this.dataType);
    }
    buf.append("\"/>");
    return buf.toString();
  }

  private String formatXML(String str)
  {
    if ((str == null) || (str.length() == 0))
      return str;
    String result = str;
    result = result.replaceAll("\\&", "&amp;");
    result = result.replaceAll("\\'", "&apos;");
    result = result.replaceAll("\\\"", "&quot;");
    result = result.replaceAll("\\<", "&lt;");
    result = result.replaceAll("\\>", "&gt;");
    return result;
  }

  public boolean isRequired() {
    return this.required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }

  public String toJSon()
  {
    StringBuffer buf = new StringBuffer();
    if (this.value != null) {
      buf.append(getName());
      buf.append(":");
      String temp = this.value.toString();
      replaceJSonKeyChar(temp, "\\", "\\\\");

      temp = replaceJSonKeyChar(temp, "\"", "\\\"");
      temp = replaceJSonKeyChar(temp, "\n", "\\n");
      temp = replaceJSonKeyChar(temp, "\r", "\\r");
      temp = replaceJSonKeyChar(temp, "\t", "\\t");
      buf.append("\"" + temp + "\"");
    }
    return buf.toString();
  }

  private String replaceJSonKeyChar(String srcStr, String keyStr, String newStr)
  {
    if ((srcStr == null) || (srcStr.length() == 0))
      return srcStr;
    if ((keyStr == null) || (newStr == null))
      return srcStr;
    String temp = "";
    while (srcStr.indexOf(keyStr) != -1) {
      int idx = srcStr.indexOf(keyStr);
      temp = srcStr.substring(0, idx) + newStr;
      srcStr = srcStr.substring(idx + keyStr.length());
    }
    srcStr = temp + srcStr;
    return srcStr;
  }
}