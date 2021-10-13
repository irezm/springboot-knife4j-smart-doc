package cn.irez.doc.api;

import cn.hutool.http.HttpStatus;
import cn.irez.doc.constant.HttpState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Result接口统一返回对象
 */
@Getter
@Setter
@SuppressWarnings("unused")
@Accessors(chain = true)
@NoArgsConstructor
public class Result<T> implements Serializable {
	/** 状态码 */
	private int code = HttpStatus.HTTP_OK;
	/** 消息 */
	private String msg = "success";
	/** 数据 */
	private T data;

	public Result(T data) {
		this.data = data;
	}

	public Result(String msg) {
		this.msg = msg;
	}

	public Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(int code, T data) {
		this.code = code;
		this.data = data;
	}

	public Result(HttpState httpState, String msg) {
		this.code = httpState.getCode();
		this.msg = msg;
	}

	public Result(HttpState httpState, T data) {
		this.code = httpState.getCode();
		this.msg = httpState.getMsg();
		this.data = data;
	}

	public Result(int code, String msg, T date){
		this.code = code;
		this.msg = msg;
		this.data = date;
	}

	public Result(int code, boolean success, T data) {
		this.code = code;
		this.data = data;
	}

	public Result(int code, boolean success, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(HttpState httpState, boolean success, String msg) {
		this.code = httpState.getCode();
		this.msg = msg;
	}

	public Result(HttpState httpState, boolean success, T data) {
		this.code = httpState.getCode();
		this.msg = httpState.getMsg();
		this.data = data;
	}

	public static<T> Result<T> ok(){
		return new Result<>();
	}

	public static<T> Result<T> ok(String msg){
		return new Result<>(msg);
	}

	public static<T> Result<T> ok(T data){
		return new Result<>(data);
	}

	public static<T> Result<T> ok(int code, T data){
		return new Result<>(code,data);
	}

	public static<T> Result<T> ok(HttpState httpState){
		return new Result<>(httpState.getCode(),httpState.getMsg(),null);
	}

	public static<T> Result<T> ok(HttpState httpState, T data){
		return new Result<>(httpState.getCode(),httpState.getMsg(),data);
	}

	public static<T> Result<T> error(String msg){
		return new Result<>(HttpState.INTERNAL_SERVER_ERROR,msg);
	}

	public static<T> Result<T> error(T data){
		return new Result<>(HttpState.INTERNAL_SERVER_ERROR,data);
	}

	public static<T> Result<T> error(int code, String msg){
		return new Result<>(code,msg);
	}

	public static<T> Result<T> error(int code, T data){
		return new Result<>(code,data);
	}

	public static<T> Result<T> error(HttpState httpState){
		return new Result<>(httpState.getCode(),httpState.getMsg());
	}

	public static<T> Result<T> error(HttpState httpState, T data){
		return new Result<>(httpState.getCode(),httpState.getMsg(),data);
	}
}