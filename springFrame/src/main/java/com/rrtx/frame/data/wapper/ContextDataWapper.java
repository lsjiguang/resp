package com.rrtx.frame.data.wapper;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rrtx.frame.context.Context;
import com.rrtx.frame.data.DataElement;
import com.rrtx.frame.data.DataField;
import com.rrtx.frame.data.KeyedCollection;
import com.rrtx.frame.exception.DuplicatedDataNameException;
import com.rrtx.frame.exception.InvalidArgumentException;
import com.rrtx.frame.exception.ObjectNotFoundException;

public class ContextDataWapper {
	private Context context;

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public DataElement getDataElement() {
		KeyedCollection kColl = new KeyedCollection("contextData");
		Iterator <String> keyIterator=context.keySet().iterator();
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			Object obj = context.get(key);
			if(obj.getClass().isAssignableFrom(List.class)){
				//TODO
			} else if(obj.getClass().isAssignableFrom(Map.class)){
				//TODO
			} else {
				
				try {
					kColl.addDataElement(new DataField(key,context.get(key)));
				} catch (DuplicatedDataNameException e) {
					e.printStackTrace();
				} catch (InvalidArgumentException e) {
					e.printStackTrace();
				}
			}
			
		}
		return kColl;
	}

	public DataElement getDataElement(String name)
			throws ObjectNotFoundException, InvalidArgumentException {
		return getDataElement(name, null);
	}

	public DataElement getDataElement(String name, Class appendClass)
			throws ObjectNotFoundException, InvalidArgumentException {
		KeyedCollection kColl = (KeyedCollection) this.getDataElement();

		DataElement element = kColl.getDataElement(name, appendClass);
		if (element != null){
			return element;
		}
		else{
			throw new ObjectNotFoundException("DataElement named [" + name + "] not defined in Context !");
		}
	}

}
