package com.rrtx.frame.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IndexedCollection extends DataElement
  implements List
{
  private DataElement dataElement = new KeyedCollection();
  private List datas;

  public IndexedCollection()
  {
    this.datas = new ArrayList();
  }

  public IndexedCollection(String name)
  {
    super(name);
    this.datas = new ArrayList();
  }

  public DataElement getElementAt(int idx)
  {
    return getElementAt(idx, null);
  }

  public DataElement getElementAt(int idx, Class appendClass)
  {
    if ((isAppend()) && (idx >= this.datas.size())) {
      try {
        while ((this.datas.size() <= idx) && (appendClass != null)) {
          DataElement tmp = (DataElement)this.dataElement.clone();
          tmp.setAppend(isAppend());
          this.datas.add(tmp);
        }
      } catch (Exception e) {
            return null;
      }
    }
    return (DataElement)this.datas.get(idx);
  }

  public int size()
  {
    return this.datas.size();
  }

  public DataElement removeElementAt(int idx)
  {
    if (idx > this.datas.size()) {
      return null;
    }
    return (DataElement)this.datas.remove(idx);
  }

  public void removeAll()
  {
    this.datas.clear();
  }

  public void addDataElement(DataElement element)
  {
    if (isAppend()) {
      element.setAppend(isAppend());
    }
    this.datas.add(element);
  }

  public void setDataElement(DataElement element)
  {
    element.setAppend(isAppend());
    this.dataElement = element;
  }

  public DataElement getDataElement()
  {
    return this.dataElement;
  }

  public Object clone()
  {
    IndexedCollection iColl = new IndexedCollection(getName());
    iColl.setDataElement(this.dataElement);
    iColl.setAppend(isAppend());
    for (int i = 0; i < this.datas.size(); i++) {
      DataElement element = (DataElement)this.datas.get(i);
      iColl.addDataElement((DataElement)element.clone());
    }
    return iColl;
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
    buf.append("<iColl id=\"");
    buf.append(getName());
    buf.append("\" append=\"" + isAppend() + "\">\n");

    if (this.datas.size() > 0) {
      for (int i = 0; i < this.datas.size(); i++) {
        DataElement element = (DataElement)this.datas.get(i);
        buf.append(element.toString(tabCount + 1));
        buf.append("\n");
      }

    }

    for (int i = 0; i < tabCount; i++)
      buf.append("\t");
    buf.append("</iColl>");

    return buf.toString();
  }

  public boolean isEmpty()
  {
    return this.datas.isEmpty();
  }

  public boolean contains(Object obj)
  {
    return this.datas.contains(obj);
  }

  public Iterator iterator()
  {
    return this.datas.iterator();
  }

  public Object[] toArray()
  {
    return this.datas.toArray();
  }

  public Object[] toArray(Object[] arg0)
  {
    return this.datas.toArray(arg0);
  }

  public boolean add(Object arg0)
  {
    if ((arg0 instanceof DataElement)) {
      ((DataElement)arg0).setAppend(isAppend());
    }
    return this.datas.add(arg0);
  }

  public boolean remove(Object arg0)
  {
    return this.datas.remove(arg0);
  }

  public boolean containsAll(Collection arg0)
  {
    return this.datas.containsAll(arg0);
  }

  public boolean addAll(Collection arg0)
  {
    Iterator list = arg0.iterator();
    while (list.hasNext()) {
      Object arg = list.next();
      if ((arg instanceof DataElement)) {
        ((DataElement)arg).setAppend(isAppend());
      }
    }
    return this.datas.addAll(arg0);
  }

  public boolean addAll(int arg0, Collection arg1)
  {
    Iterator list = arg1.iterator();
    while (list.hasNext()) {
      Object arg = list.next();
      if ((arg instanceof DataElement)) {
        ((DataElement)arg).setAppend(isAppend());
      }
    }
    return this.datas.addAll(arg0, arg1);
  }

  public boolean removeAll(Collection arg0)
  {
    return this.datas.removeAll(arg0);
  }

  public boolean retainAll(Collection arg0)
  {
    return this.datas.retainAll(arg0);
  }

  public void clear()
  {
    this.datas.clear();
  }

  public boolean equals(Object arg0)
  {
    return super.equals(arg0);
  }

  public int hashCode()
  {
    return super.hashCode();
  }

  public Object get(int arg0)
  {
    if ((isAppend()) && (arg0 >= this.datas.size())) {
      try {
        while (this.datas.size() <= arg0) {
          DataElement tmp = (DataElement)this.dataElement.clone();
          tmp.setAppend(isAppend());
          this.datas.add(tmp);
        }
      } catch (Exception e) {
            return null;
      }
    }
    return this.datas.get(arg0);
  }

  public Object set(int arg0, Object arg1)
  {
    if ((arg1 instanceof DataElement)) {
      ((DataElement)arg1).setAppend(isAppend());
    }
    return this.datas.set(arg0, arg1);
  }

  public void add(int arg0, Object arg1)
  {
    if ((arg1 instanceof DataElement)) {
      ((DataElement)arg1).setAppend(isAppend());
    }
    this.datas.add(arg0, arg1);
  }

  public Object remove(int arg0)
  {
    return this.datas.remove(arg0);
  }

  public int indexOf(Object arg0)
  {
    return this.datas.indexOf(arg0);
  }

  public int lastIndexOf(Object arg0)
  {
    return this.datas.lastIndexOf(arg0);
  }

  public ListIterator listIterator()
  {
    return this.datas.listIterator();
  }

  public ListIterator listIterator(int arg0)
  {
    return this.datas.listIterator(arg0);
  }

  public List subList(int arg0, int arg1)
  {
    return this.datas.subList(arg0, arg1);
  }

  public void setAppend(boolean append)
  {
    super.setAppend(append);
    for (int i = 0; i < this.datas.size(); i++)
      if ((this.datas.get(i) instanceof DataElement))
        ((DataElement)this.datas.get(i)).setAppend(append);
  }

  public String toJSon()
  {
    StringBuffer buf = new StringBuffer();
    if (getName() != null) {
      buf.append(getName() + ":");
    }
    buf.append("[");
    if (this.datas.size() > 0) {
      for (int i = 0; i < this.datas.size(); i++) {
        DataElement element = (DataElement)this.datas.get(i);
        String str = "";
        if ((element instanceof DataField))
          str = ((DataField)element).toJSon();
        if ((element instanceof IndexedCollection))
          str = ((IndexedCollection)element).toJSon();
        if ((element instanceof KeyedCollection))
          str = ((KeyedCollection)element).toJSon();
        buf.append(str);
        if (i != this.datas.size() - 1)
          buf.append(",");
      }
    }
    buf.append("]");
    return buf.toString();
  }
}