package cn.irez.doc.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum HttpState {
    //HTTP 状态码
    OK(200,"成功"),
    BAD_REQUEST(400,"错误请求"),
    UNAUTHORIZED(401,"未经授权"),
    INTERNAL_SERVER_ERROR(500,"内部服务器错误");

    @Getter
    private final Integer code;
    @Getter
    private final String msg;
}