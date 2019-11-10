package com.shop.common.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseEntity<T> {
    public static <T> ResponseEntity<T> ok(T data) {
        return new ResponseEntity<>(data, Status.OK.code, Status.OK.message);
    }

    public static <T> ResponseEntity<T> status(ResponseEntity.Status status) {
        return new ResponseEntity<>(null, status.code, status.message);
    }

    public static <T> ResponseEntity<T> status(int status, String message) {
        return new ResponseEntity<>(null, status, message);
    }

    private ResponseEntity(T data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;
    private T data;

    /**
     * 状态码
     */
    public enum Status {
        OK(200, "成功"),
        BAD_REQUEST(400, "请求错误"),
        NOT_FOUND(404, "未找到数据");

        private int code;
        private String message;

        Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
