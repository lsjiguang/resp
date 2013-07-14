package com.rrtx.frame.ibatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ORACLE_TYPE_FIELD_IDX 
 * @Description: TODO 用来标记field 的序号，便于与oracle中的对象进行映射
 * @author qijia
 * @date 2013-5-21 上午11:21:59
 * @version	1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ORACLE_TYPE_FIELD_IDX {
	public abstract int index();
}
