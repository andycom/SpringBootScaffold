package com.fancv.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 获取jvm系统信息的工具类
 */
public class SystemInfoUtil {

    /**
     * 匿名内部类
     */
    private static Set<String> infoTypeList = new HashSet<String>(32) {{
        add("os.name");
        add("os.version");
        add("user.name");
        add("user.dir");
    }};
    ;

    public static String getSystemInfo(String infoType) {
        if (StringUtils.isEmpty(infoType)) {
            return null;
        } else if (infoTypeList.contains(infoType)) {
            return System.getProperty(infoType);
        } else {
            return null;
        }
    }
}
