package com.gitee.fanx.rpc.client;

import feign.MethodMetadata;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

/**
 * FeignClient 类支持 @RequestMapping
 * @author fanhang
 */
public class RequestMappingFeignClientSpringMvcContract extends SpringMvcContract {
	@Override
	protected void processAnnotationOnClass(MethodMetadata data, Class<?> clz) {
		RequestMapping classAnnotation = findMergedAnnotation(clz, RequestMapping.class);
		if (classAnnotation == null) {
			super.processAnnotationOnClass(data, clz);
			return;
		}
		if (classAnnotation.path().length == 0) {
			return;
		}
		Assert.state(classAnnotation.path().length == 1, "RequestMapping#path only one is supported");
		String prefix = classAnnotation.path()[0];
		if (StringUtils.hasText(prefix)) {
			data.template().uri(prefix);
		}
	}
}
