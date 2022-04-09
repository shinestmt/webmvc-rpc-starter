package com.gitee.fanx.rpc;

/**
 * @author fanhang
 */
public class RpcErrorBody {
	public static final transient String RPC_ATTRIBUTE = "rpc";

	private Long timestamp;
	private Integer code;
	private String message;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
