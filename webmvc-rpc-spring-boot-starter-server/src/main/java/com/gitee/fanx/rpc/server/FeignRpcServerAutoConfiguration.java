package com.gitee.fanx.rpc.server;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

/**
 * feign-rpc-server 自动配置
 * <pre>
 * 异常传递
 * <pre/>
 * @author fanhang
 */
@Configuration
public class FeignRpcServerAutoConfiguration {

	@Bean
	@ConditionalOnBean(DelegatingWebMvcConfiguration.class)
	public ErrorAttributes errorAttributes() {
		return new WebmvcRpcErrorAttributes();
	}

}
