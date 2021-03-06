package com.rrtx.frame.ibatis;
 
import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


import org.apache.commons.dbcp.DelegatingConnection;
import org.apache.commons.dbcp.PoolableConnection;
import org.springframework.beans.BeanWrapperImpl;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import com.ibatis.sqlmap.engine.type.TypeHandler;
import com.rrtx.frame.ibatis.annotation.ORACLE_TYPE;
import com.rrtx.frame.ibatis.annotation.ORACLE_TYPE_FIELD_IDX;

/**
 * @ClassName: ArrayTypeHandler 
 * @Description: 用来处理  java.util.List 作为存储过程输入参数的 handler 
 * @author qijia
 * @date 2013-5-21 上午11:23:28
 * @version	1.0
 */
public class ArrayTypeHandler implements TypeHandler {

	
	public void setParameter(PreparedStatement ps, int i, Object parameter,
			String jdbcType) throws SQLException {
		if (parameter == null) {
			ps.setNull(i, Types.ARRAY);
		} else {
			Class claz=((List)parameter).get(0).getClass();
			String structName = ((ORACLE_TYPE) claz.getAnnotation(ORACLE_TYPE.class)).structName();
			String arrayName = ((ORACLE_TYPE) claz.getAnnotation(ORACLE_TYPE.class)).arrayName();
			
			PoolableConnection connection =(PoolableConnection) ps.getConnection();
			
			Connection nativeConnection = getNativeConnection(connection);
			try{	
				ARRAY dataArray = makeARRAY(structName,arrayName,nativeConnection,(List)parameter);
				ps.setArray(i, dataArray);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	
	public Object getResult(ResultSet rs, String columnName)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		 return cs.getArray(columnIndex).getArray();
	}

	
	public Object valueOf(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean equals(Object object, String string) {
		// TODO Auto-generated method stub
		return false;
	}
	/**  
	 * @Description: 获得原生数据库连接
	*/ 
	public static Connection getNativeConnection(Connection con) throws SQLException { 

		if (con instanceof DelegatingConnection) { 
		    Connection nativeCon = ((DelegatingConnection) con).getInnermostDelegate(); 
			return (nativeCon != null ? nativeCon : con.getMetaData().getConnection()); 
		} 
		return con; 

	} 
	
	/**  
	 * @Description: 构造oracle中的自定义类型
	*/ 
	public static ARRAY makeARRAY (String oracleObjName,String oraclelistName, Connection nativeConnection, List listData){
		ARRAY dataArray=null;
		try {
			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor( oraclelistName, nativeConnection); 
			if (listData != null && listData.size() > 0) { 
				   StructDescriptor structdesc = new StructDescriptor(oracleObjName, nativeConnection);
				   
				   STRUCT[] structs = new STRUCT[listData.size()];
				   
				   Class claz=((List)listData).get(0).getClass();
				   Field[] fields = claz.getDeclaredFields();
				   
				   for (int i = 0; i < listData.size(); i++) {
					   
					 Object[] result = new Object[structdesc.getLength()]; 
				    
					 for(Field field:fields){
						int idx = field.getAnnotation(ORACLE_TYPE_FIELD_IDX.class).index();
						try {
							BeanWrapperImpl wrapper = new BeanWrapperImpl(listData.get(i));
							result[idx] = wrapper.getPropertyValue(field.getName());
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} 
					 }
				    
				    structs[i] = new STRUCT(structdesc, nativeConnection, result);
				   }
				   dataArray = new ARRAY(descriptor, nativeConnection, structs);
				  }
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dataArray;
	}
}
