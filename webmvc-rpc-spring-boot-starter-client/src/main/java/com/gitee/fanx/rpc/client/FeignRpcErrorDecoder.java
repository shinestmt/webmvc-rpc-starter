package com.gitee.fanx.rpc.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitee.fanx.rpc.RpcAttributes;
import com.gitee.fanx.rpc.RpcErrorBody;
import com.gitee.fanx.rpc.RpcException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * rpc客户端解析异常响应
 *
 * @author fanhang
 */
public class FeignRpcErrorDecoder implements ErrorDecoder {
	private static final Logger log = LoggerFactory.getLogger(FeignRpcErrorDecoder.class);

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public Exception decode(String methodKey, Response response) {
		try (InputStream in = response.body().asInputStream()) {
			RpcAttributes attributes = objectMapper.readValue(in, RpcAttributes.class);
			RpcErrorBody errorBody;
			if (attributes != null && (errorBody = attributes.getRpc()) != null && errorBody.getCode() != null) {
				return new RpcException(errorBody.getCode(), errorBody.getMessage());
			}
			return new RpcException(response.status(), "unknown-exception-" + response.status());
		} catch (IOException e) {
			log.warn("ErrorDecoder exception: {}", e.getMessage());
			return e;
		}
	}

}
