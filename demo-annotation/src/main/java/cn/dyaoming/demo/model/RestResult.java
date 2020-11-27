package cn.dyaoming.demo.model;

import java.io.Serializable;

/**
 * <p>
 * 基本返回结果集
 * </p>
 * 
 * @author DYAOMING
 * @since 2019-04-17
 * @version 0.0.3
 */
public class RestResult<T extends Object> implements Serializable {

	private static final long serialVersionUID = 7525673191984540412L;

	private boolean flag;
	private String code;
	private String message;
	private T data;

	/**
	 * 默认构造函数
	 */
	public RestResult() {
		setFlag(true);
		setCode("0000");
		setMessage("业务执行成功");
	}

	/**
	 * 基础构造函数
	 * 
	 * @param cFlag boolean类型 结果标志
	 * @param cCode String类型 结果编码
	 */
	public RestResult(boolean cFlag, String cCode) {

		setFlag(cFlag);
		setCode(cCode);
		/* TODO message 未转换 */
		setMessage(cCode);
	}

	/**
	 * 带结果说明的构造函数
	 * 
	 * @param cFlag boolean类型 结果标志
	 * @param cCode String类型 结果编码
	 * @param cMsg  String类型 结果说明
	 */
	public RestResult(boolean cFlag, String cCode, String cMsg) {

		setFlag(cFlag);
		setCode(cCode);
		setMessage(cMsg);
	}

	/**
	 * <p>
	 * 成功
	 * </p>
	 * 
	 * @return BaseResult
	 */
	public static RestResult success() {
		return new RestResult();
	}

	/**
	 * <p>
	 * 失败
	 * </p>
	 * 
	 * @param cCode String类型 失败标识
	 * @param cMsg  String类型 失败说明
	 * @return BaseResult
	 */
	public static RestResult fail(String cCode, String cMsg) {
		return new RestResult(false, cCode, cMsg);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

}
