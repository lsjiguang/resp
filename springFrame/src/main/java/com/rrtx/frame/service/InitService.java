package com.rrtx.frame.service;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.rrtx.app.constants.Constants;

/**
 * @ClassName: InitService 
 * @Description: 服务启动后，进行应用的参数初始化
 * @author qijia
 * @date 2013-5-27 下午5:58:13
 * @version	1.0
 */
@Component
public class InitService extends AbsractService implements  ApplicationListener {
	@Resource
	private CommService commService;
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		//Constants.init(commService);
	}

}
