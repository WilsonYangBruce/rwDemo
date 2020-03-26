package com.example.demo1.result;

public class ResultTool {
    private static ResultEntity tool = ResultEntity.getInstance();

    public static ResultEntity result(Object data) {
        clearData();
        if (data == null) {
            tool.setCode(HttpResponseCode.FAIL.code);
            tool.setMessage(HttpResponseCode.FAIL.response);
            return tool;
        } else {
            tool.setCode(HttpResponseCode.OK.code);
            tool.setMessage(HttpResponseCode.OK.response);
            tool.setData(data);
            return tool;
        }
    }

    /**
     * 成功
     */
    public static ResultEntity ok() {
        clearData();
        ok(null);
        return tool;
    }

    public static ResultEntity ok(String msg) {
        clearData();
        tool.setCode(HttpResponseCode.OK.code);
        tool.setMessage(msg);
        return tool;
    }

    public static ResultEntity ok(Object data) {
        clearData();
        tool.setCode(HttpResponseCode.OK.code);
        tool.setMessage(HttpResponseCode.OK.response);
        tool.setData(data);
        return tool;
    }

    public static ResultEntity ok(Object data, String msg) {
        clearData();
        tool.setCode(HttpResponseCode.OK.code);
        tool.setMessage(msg);
        tool.setData(data);
        return tool;
    }

    /**
     * 失败
     */
    public static ResultEntity fail(ResultEntity resultEntity) {
        clearData();
        return resultEntity;
    }

    public static ResultEntity fail() {
        clearData();
        tool.setCode(HttpResponseCode.FAIL.code);
        tool.setMessage(HttpResponseCode.FAIL.response);
        return tool;
    }

    public static ResultEntity fail(String msg) {
        clearData();
        tool.setCode(HttpResponseCode.FAIL.code);
        tool.setMessage(msg);
        return tool;
    }

    public static ResultEntity fail(int code) {
        clearData();
        tool.setCode(code);
        return tool;
    }

    public static ResultEntity fail(HttpResponseCode code) {
        clearData();
        tool.setCode(code.code);
        tool.setMessage(code.response);
        return tool;
    }

    public static ResultEntity fail(HttpResponseCode code, String msg) {
        clearData();
        tool.setCode(code.code);
        tool.setMessage(msg);
        return tool;
    }

    public static ResultEntity fail(int code, String msg) {
        clearData();
        tool.setCode(code);
        tool.setMessage(msg);
        return tool;
    }

    private static void clearData() {
        tool.setCode(0);
        tool.setMessage("");
        tool.setData(null);
    }

    /**
     * 统一的返回码
     */
    public enum HttpResponseCode {
        OK(200, "成功"),
        FAIL(400, "fail"),
        UNAUTHORIZED(401, "Unauthorized"),
        NOT_LOGIN(403, "Forbidden"),
        NOT_FOUND(404, "没找到"),
        NO_RIGHT(405, "Method Not Allowed"),
        SERVER_FAIL(500, "服务器错误");
        private int code;
        private String response;

        HttpResponseCode(int code, String response) {
            this.code = code;
            this.response = response;
        }
    }
}
