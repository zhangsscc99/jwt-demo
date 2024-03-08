package top.lukeewin.jwtdemo2.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ErrorEnum {
    SUCCESS(200, "操作成功"),
    FAIL(300, "获取数据失败"),
    USER_EX(301, "user not existed, login again"),
    ERROR(302, "error request"),
    USERNAME_PASSWORD_ERROR(303, "username or password error"),
    NO_TOKEN(400, "no token, login again please"),
    TOKEN_VERIFY_ERROR(401, "token verified failure, login again please"),
    TOKEN_EX(402, "token expired");
    private final Integer code;;
    private final String msg;
}
