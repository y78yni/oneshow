package com.oneshow.commom.constants;

import java.util.HashMap;
import java.util.Map;

public final class CommonConstants {
    /**
     * KEY分隔符
     */
    public static final char KEY_SAPERATOR = '-';

    public static final String REGEX_PUNC = "[\\pP‘’“”×]";

    public static final String REGEX_EN_CHAR = "[a-zA-Z]";// 英文字符正则表达式
    /**
     * Encoding: "UTF-8".
     */
    public static final String UTF8 = "UTF-8";

    public static final int LOGGER_STRING_LENGTH = 20;

    public static final String REGX_MINUS = "-"; // 减号分割

    public static final String SUCCESS = "success";

    public static final int DEFAULT_PAGE_INDEX = 1;

    public static final int DEFAULT_PAGE_SIZE = 10;

    public static Map<Integer, String> dataTypeMap = new HashMap<Integer, String>();
    /**
     * 正常
     **/
    public static final int STATUS_NOTDEL = 0;
    /**
     * 删除
     **/
    public static final int STATUS_DEL = 1;
    /**
     * 待激活
     **/
    public static final int STATUS_ACTIVATE = 2;
    /**
     * 无效
     **/
    public static final int STATUS_INVALID = 3;
    public static final int EMAIL_REDIS_TIME = 60 * 15; // 邮箱激活码有效时间

    public static final String SESSION_CURRENT_USER_NAME = "currentUser";

    /**
     * 禁用构造函数
     */
    private CommonConstants() {
        // 禁用构造函数
    }


    /**
     * 组装KEY值，默认使用'-'作为分割符号
     *
     * @param inputs
     * @return
     */
    public static String getKey(String... inputs) {
        return getKey(KEY_SAPERATOR, inputs);
    }

    /**
     * 组装KEY值
     *
     * @param inputs
     * @return
     */
    public static String getKey(char separator, String... inputs) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            result.append(input);

            if (i != inputs.length - 1) {
                result.append(separator);
            }
        }

        return result.toString();
    }

}
