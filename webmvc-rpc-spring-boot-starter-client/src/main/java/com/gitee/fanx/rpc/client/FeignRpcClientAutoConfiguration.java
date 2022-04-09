package com.gitee.fanx.rpc.client;

import feign.codec.ErrorDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.openfeign.FeignBuilderCustomizer;
import org.springframework.cloud.openfeign.FeignClientSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign-rpc-client 自动配置
 * <pre>
 * 异常信息传递
 * FeignClient 类支持 @RequestMapping
 * <pre/>
 * @author fanhang
 */
@Configuration
public class FeignRpcClientAutoConfiguration {

	@Bean
	@ConditionalOnBean(FeignClientSpecification.class)
	public ErrorDecoder errorDecoder() {
		return new FeignRpcErrorDecoder();
	}

	@Bean
	@ConditionalOnBean(FeignClientSpecification.class)
	public FeignBuilderCustomizer feignBuilderCustomizer() {
		return (builder) -> builder.contract(new RequestMappingFeignClientSpringMvcContract());
	}

}
