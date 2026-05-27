package com.example.template.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Servlet 工具类
 * <p>
 * 工具类命名规范: 以 Utils/Util 后缀结尾
 * 工具类中的方法均为 static, 通过类名直接调用
 * </p>
 */
public class ServletUtils {

    private ServletUtils() {
    }

    /**
     * 获取当前请求的 HttpServletRequest 对象
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Objects.requireNonNull(attrs).getRequest();
    }

    /**
     * 获取当前请求的 HttpServletResponse 对象
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Objects.requireNonNull(attrs).getResponse();
    }

    /**
     * 获取请求头信息
     *
     * @param headerName 请求头名称
     * @return 请求头值
     */
    public static String getHeader(String headerName) {
        return getRequest().getHeader(headerName);
    }

    /**
     * 获取客户端真实 IP (兼容代理场景)
     *
     * @return 客户端 IP 地址
     */
    public static String getClientIp() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("X-Forwarded-For");
        // X-Forwarded-For 可能有多个 IP, 取第一个
        if (ip != null && ip.length() > 0 && !"unknown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(',');
            return index > 0 ? ip.substring(0, index) : ip;
        }
        ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
