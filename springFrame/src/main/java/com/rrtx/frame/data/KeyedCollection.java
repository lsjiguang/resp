package com.rrtx.frame.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rrtx.frame.exception.DuplicatedDataNameException;
import com.rrtx.frame.exception.InvalidArgumentException;
import com.rrtx.frame.exception.ObjectNotFoundException;

public class KeyedCollection extends DataElement
  implements Map
{
  private Map dataElements;
  private List dataNames;

  public KeyedCollection()
  {
    this.dataElements = new HashMap();
    this.dataNames = new ArrayList();
  }

  public KeyedCollection(String name)
  {
    super(name);
    this.dataElements = new HashMap();
    this.dataNames = new ArrayList();
  }

  public Object getDataValue(String dataName)
    throws ObjectNotFoundException, InvalidArgumentException
  {
    DataField field = (DataField)getDataElement(dataName);
    if (field == null) {
      throw new ObjectNotFoundException("DataField named[" + dataName + "] not defined in KeyedCollection [" + getName() + "]!");
    }
    return field.getValue();
  }

  /** @deprecated */
  public Object getValueAt(String dataName)
    throws ObjectNotFoundException, InvalidArgumentException
  {
    return getDataValue(dataName);
  }

  public void setDataValue(String dataName, Object value)
    throws InvalidArgumentException, ObjectNotFoundException
  {
    DataField field = (DataField)getDataElement(dataName);
    if ((field == null) && (isAppend())) {
      field = new DataField(dataName, value);
      try {
        addDataElement(field);
      } catch (Exception ee) {
      }
    }
    if (field == null) {
      throw new ObjectNotFoundException("DataField named[" + dataName + "] not defined in KeyedCollection [" + getName() + "]!");
    }
    field.setValue(value);
  }

  /** @deprecated */
  public void setValueAt(String dataName, Object value)
    throws InvalidArgumentException, ObjectNotFoundException
  {
    setDataValue(dataName, value);
  }

  public DataElement getDataElement(int idx)
    throws InvalidArgumentException
  {
    if ((idx < 0) || (idx >= this.dataNames.size())) {
      throw new InvalidArgumentException("idx out of bound while get dataElement from keyedCollection!");
    }

    String dataName = (String)this.dataNames.get(idx);
    return (DataElement)this.dataElements.get(dataName);
  }

  public DataElement getDataElement(String dataName)
    throws InvalidArgumentException
  {
    return getDataElement(dataName, null);
  }

  public DataElement getDataElement(String dataName, Class appendClass)
    throws InvalidArgumentException
  {
    if (dataName == null) {
      throw new InvalidArgumentException("dataName should not be null when get dataElement from KeyedCollection!");
    }

    int idx = dataName.indexOf('.');

    if (idx != -1) {
      String empDataName = dataName.substring(0, idx);
      int eidx = empDataName.indexOf("[");
      if ((empDataName.charAt(idx - 1) == ']') && (eidx != -1)) {
        int pos = Integer.parseInt(empDataName.substring(eidx + 1, idx - 1));
        String iCollName = empDataName.substring(0, eidx);
        IndexedCollection iColl = (IndexedCollection)this.dataElements.get(iCollName);

        if ((iColl == null) && (isAppend()) && (appendClass != null)) {
          iColl = new IndexedCollection();
          iColl.setName(iCollName);
          iColl.setAppend(isAppend());
          try {
            addDataElement(iColl);
          } catch (Exception ee) {
            return null;
          }
        }
        if (iColl == null) {
          return null;
        }
        return ((KeyedCollection)iColl.getElementAt(pos, KeyedCollection.class)).getDataElement(dataName.substring(idx + 1), appendClass);
      }

      String kCollName = empDataName;
      KeyedCollection kColl = (KeyedCollection)this.dataElements.get(kCollName);

      if ((kColl == null) && (isAppend()) && (appendClass != null)) {
        kColl = new KeyedCollection();
        kColl.setName(kCollName);
        kColl.setAppend(isAppend());
        try {
          addDataElement(kColl);
        } catch (Exception ee) {
          return null;
        }
      }
      if (kColl == null) {
        return null;
      }
      return kColl.getDataElement(dataName.substring(idx + 1), appendClass);
    }

    DataElement field = (DataElement)this.dataElements.get(dataName);
    if ((field == null) && (isAppend()) && (appendClass != null)) {
      try {
        field = (DataElement)appendClass.newInstance();
        field.setName(dataName);
        field.setAppend(isAppend());
        addDataElement(field);
      } catch (Exception ee) {
        return null;
      }
    }
    if (field != null) {
      return field;
    }
    return null;
  }

  /** @deprecated */
  public DataElement getElementAt(String dataName)
    throws InvalidArgumentException
  {
    return getDataElement(dataName);
  }

  /** @deprecated */
  public DataElement removeElementAt(String dataName)
  {
    return removeDataElement(dataName);
  }

  public DataElement removeDataElement(String dataName)
  {
    if (dataName == null) {
      return null;
    }
    int idx = dataName.indexOf('.');
    if (idx != -1) {
      String kCollName = dataName.substring(0, idx);
      KeyedCollection kColl = (KeyedCollection)this.dataElements.get(kCollName);

      if (kColl == null) {
        return null;
      }

      return kColl.removeDataElement(dataName.substring(idx + 1));
    }

    this.dataNames.remove(dataName);
    return (DataElement)this.dataElements.remove(dataName);
  }

  public Object clone()
  {
    KeyedCollection kColl = new KeyedCollection(getName());
    kColl.setAppend(isAppend());
    for (int i = 0; i < this.dataNames.size(); i++) {
      DataElement element = (DataElement)this.dataElements.get(this.dataNames.get(i));

      element = (DataElement)element.clone();
      try {
        kColl.addDataElement(element);
      }
      catch (Exception e) {
      }
    }
    return kColl;
  }

  public void reset()
  {
  }

  public void addDataElement(DataElement dataElement)
    throws DuplicatedDataNameException, InvalidArgumentException
  {
    if (dataElement.getName() == null)
    {
      throw new InvalidArgumentException("Datafield's name should not be null!");
    }

    if (this.dataNames.contains(dataElement.getName())) {
      String tmp = dataElement.getClass().toString();
      int idx = tmp.lastIndexOf(".");
      if (idx != -1) {
        tmp = tmp.substring(idx + 1);
      }
      throw new DuplicatedDataNameException(tmp + " named [" + dataElement.getName() + "] still exist in KeyedCollection [" + getName() + "]!");
    }

    if (isAppend()) {
      dataElement.setAppend(isAppend());
    }
    this.dataElements.put(dataElement.getName(), dataElement);
    this.dataNames.add(dataElement.getName());
  }

  public void addDataField(DataField field)
    throws DuplicatedDataNameException, InvalidArgumentException
  {
    addDataElement(field);
  }

  public void addKeyedCollection(KeyedCollection kColl)
    throws InvalidArgumentException, DuplicatedDataNameException
  {
    addDataElement(kColl);
  }

  public void addIndexedCollection(IndexedCollection iColl)
    throws InvalidArgumentException, DuplicatedDataNameException
  {
    addDataElement(iColl);
  }

  public void addDataField(String name, Object value)
    throws InvalidArgumentException, DuplicatedDataNameException
  {
    if (name == null) {
      throw new InvalidArgumentException("Datafield's name should not be null!");
    }

    DataField field = new DataField(name, value);
    addDataField(field);
  }

  public String toString()
  {
    return toString(0);
  }

  public String toString(int tabCount)
  {
    StringBuffer buf = new StringBuffer();

    for (int i = 0; i < tabCount; i++) {
      buf.append("\t");
    }
    buf.append("<kColl id=\"");
    buf.append(getName());
    buf.append("\" append=\"" + isAppend() + "\">\n");

    for (int i = 0; i < this.dataNames.size(); i++) {
      String dataName = (String)this.dataNames.get(i);
      DataElement element = (DataElement)this.dataElements.get(dataName);
      buf.append(element.toString(tabCount + 1));
      buf.append("\n");
    }

    for (int i = 0; i < tabCount; i++) {
      buf.append("\t");
    }
    buf.append("</kColl>");

    return buf.toString();
  }

  public int size()
  {
    if (this.dataNames == null) {
      return 0;
    }
    return this.dataNames.size();
  }

  public boolean isEmpty()
  {
    return (this.dataNames == null) || (this.dataNames.size() == 0);
  }

  public boolean containsKey(Object key)
  {
    if (this.dataElements == null) {
      return false;
    }
    return this.dataElements.containsKey(key);
  }

  public boolean containsValue(Object value)
  {
    if (this.dataElements == null) {
      return false;
    }
    return this.dataElements.containsValue(value);
  }

  public Object get(Object key)
  {
    if (this.dataElements == null) {
      return null;
    }
    DataElement tmp = (DataElement)this.dataElements.get(key);
    if (tmp == null)
      return null;
    if ((tmp instanceof DataField)) {
      return ((DataField)tmp).getValue();
    }
    return tmp;
  }

  public Object put(Object key, Object value)
  {
    try
    {
      addDataField(key.toString(), value);
    }
    catch (Exception e) {
      try {
        setDataValue(key.toString(), value);
      }
      catch (Exception ee)
      {
      }
    }
    return value;
  }

  public Object remove(Object key)
  {
    if (this.dataElements != null) {
      this.dataNames.remove(key);
      return this.dataElements.remove(key);
    }

    return null;
  }

  public void putAll(Map mapValue)
  {
    Object[] keys = mapValue.keySet().toArray();
    for (int i = 0; i < keys.length; i++) {
      Object key = keys[i];
      Object value = mapValue.get(key);
      put(key, value);
    }
  }

  public void clear()
  {
    if (this.dataElements != null) {
      this.dataElements.clear();
      this.dataNames.clear();
    }
  }

  public Set keySet()
  {
    if (this.dataElements != null)
      return this.dataElements.keySet();
    return null;
  }

  public Collection values()
  {
    if (this.dataElements != null)
      return this.dataElements.values();
    return null;
  }

  public Set entrySet()
  {
    if (this.dataElements != null) {
      return this.dataElements.entrySet();
    }
    return null;
  }

  public boolean equals(Object arg0)
  {
    return super.equals(arg0);
  }

  public int hashCode()
  {
    return super.hashCode();
  }

  public void setAppend(boolean append)
  {
    super.setAppend(append);
    Iterator nameList = this.dataNames.iterator();
    while (nameList.hasNext())
      ((DataElement)this.dataElements.get((String)nameList.next())).setAppend(append);
  }

  public String toJSon()
  {
    StringBuffer buf = new StringBuffer();
    if (getName() != null) {
      buf.append(getName() + ":");
    }
    buf.append("{");
    for (int i = 0; i < this.dataNames.size(); i++) {
      String dataName = (String)this.dataNames.get(i);
      DataElement element = (DataElement)this.dataElements.get(dataName);
      String str = "";
      if ((element instanceof DataField))
        str = ((DataField)element).toJSon();
      if ((element instanceof IndexedCollection))
        str = ((IndexedCollection)element).toJSon();
      if ((element instanceof KeyedCollection))
        str = ((KeyedCollection)element).toJSon();
      if ((str != null) && (str.length() > 0)) {
        buf.append(str);
        if (i != this.dataNames.size() - 1)
          buf.append(",");
      }
    }
    buf.append("}");
    return buf.toString();
  }
}