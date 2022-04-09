package com.gitee.fanx.rpc;

/**
 * @author fanhang
 */
public class RpcException extends RuntimeException {

	private Integer code;

	public RpcException(int code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

}
