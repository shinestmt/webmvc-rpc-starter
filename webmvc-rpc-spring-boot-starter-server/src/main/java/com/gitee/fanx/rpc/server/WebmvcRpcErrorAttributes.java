package com.gitee.fanx.rpc.server;

import com.gitee.fanx.rpc.RpcErrorBody;
import com.gitee.fanx.rpc.RpcException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 服务端返回标准化rpc异常
 *
 * @author fanhang
 */
public class WebmvcRpcErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

		RpcErrorBody body = new RpcErrorBody();
		body.setTimestamp(System.currentTimeMillis());

		Throwable throwable = getError(webRequest);
		int code = 500;
		String message = throwable.getMessage();
		if (throwable instanceof RpcException) {
			RpcException rpcException = (RpcException) throwable;
			code = rpcException.getCode();
		}
		body.setCode(code);
		body.setMessage(message);
		errorAttributes.put(RpcErrorBody.RPC_ATTRIBUTE, body);
		return errorAttributes;
	}

}
