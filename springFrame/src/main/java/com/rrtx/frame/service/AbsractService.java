package com.rrtx.frame.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rrtx.frame.exception.ZTEPayException;

/**
 * @ClassName: AbsractService 
 * @Description: 服务对象的抽象类，提供对ibatis的基本封装
 * @author qijia
 * @date 2013-5-15 下午4:52:47
 * @version	1.0
 */
public abstract class AbsractService {
	
	//@Autowired
	private SqlMapClient sqlMapClientTemplate;  //ibatis	
	public SqlMapClient getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(SqlMapClient sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	
	
    /**  
     * @Description: 访问存储过程
    */ 
    public void CallProcedure(Parameters paramerters,String procedureIbatisName) throws ZTEPayException{ 
		try {
			getSqlMapClientTemplate().queryForObject(procedureIbatisName, paramerters);
		} catch (SQLException e) { 
			e.printStackTrace();
			throw new ZTEPayException("FAPPUB03"); 
		}
		
		if(!"0".equals(paramerters.getRetCode())){
			throw new ZTEPayException(paramerters.getRetCode()); 
		}
		
	}
}
