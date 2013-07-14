package com.rrtx.frame.ibatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ORACLE_TYPE 
 * @Description: TODO 将对象映射为oracle中的类型，用于将list对象直接作为参数传入存储过程
 * @author qijia
 * @date 2013-5-21 上午11:21:04
 * @version	1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ORACLE_TYPE {
	public abstract String structName();
	public abstract String arrayName();
}
