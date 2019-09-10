package json;

import java.io.Serializable;

/**
 * 响应结果类 state;//状态代号 message;//消息 data;//传输之数据,泛型未定
 */
public class ResponseResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer state;// 状态码
	private String message;// 消息
	private T data;// 传输之数据,泛型未定

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseResult(Integer state) {
		this.state = state;
	}

	public ResponseResult(String message) {
		this.message = message;
	}

	public ResponseResult(T data) {
		this.data = data;
	}

	public ResponseResult(Integer state, String message) {
		this.state = state;
		this.message = message;
	}

	public ResponseResult(String message, T data) {
		this.message = message;
		this.data = data;
	}

	public ResponseResult(Integer state, String message, T data) {
		this.state = state;
		this.message = message;
		this.data = data;
	}

	public ResponseResult(Integer state, T data) {
		this.state = state;
		this.data = data;
	}

	public ResponseResult() {
	}

	@Override
	public String toString() {
		return "ResponseResult{" + "state=" + state + ", message='" + message
				+ '\'' + ", data=" + data + '}';
	}
}
