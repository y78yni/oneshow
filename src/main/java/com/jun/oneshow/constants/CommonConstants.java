package com.jun.oneshow.constants;

import java.util.HashMap;
import java.util.Map;

public final class CommonConstants {
	/** KEY分隔符 */
	public static final char KEY_SAPERATOR = '-';

	public static final String DIR_SAPERATOR = "/";

	public static final int MAX_SEARCH_NUM = 10000;// 最大查询条数

	public static final String SENSITIVE_CONTENT = "[敏感日志]";

	public static final String HTTP_QUERY_STRING = "HTTP_QUERY_STRING";

	public static final String HTML_SPAN_TAG_START = "<span class=\"high-light\">";

	public static final String HTML_SPAN_TAG_END = "</span>";

	public static final String HTML_SPAN_TAG_ALIAS_START = "<nE7jA5mnE7jA5m>";

	public static final String HTML_SPAN_TAG_ALIAS_END = "<7jA5m7jA5m>";

	public static final String REGEX_PUNC = "[\\pP‘’“”×]";

	public static final String HTML_TAG_REGEX = "<[^<>]*>";

	public static final String REGEX_ZH_CHAR = "[\u4e00-\u9fa5]";// 中文字符正则表达式

	public static final String REGEX_EN_CHAR = "[a-zA-Z]";// 英文字符正则表达式

	/** Encoding: "UTF-8". */
	public static final String UTF8 = "UTF-8";

	public static final int LOGGER_STRING_LENGTH = 20;
	// regular expression
	public static final String REGX_DIGIT = "\\d+";// 判断是否是数字
	public static final String REGX_ONE_SPACE = " "; // 单个空格
	public static final String REGX_MULTI_SPACE = "\\s{1,}"; // 多个空格
	public static final String REGX_MINUS = "-"; // 减号分割
	public static final String REGX_COMMA = ",";// 逗号分隔
	public static final String REGX_UNDERLINE = "_"; // 下划线
	public static final String REGX_COLON = ":"; // 冒号
	public static final String REGX_MULTI_WELL = "###"; // 三个井号
	public static final String REGX_OCTOTHORP = "#";// 一个井号
	public static final String REGX_DOT = ".";// 一个点
	public static final String REG_DOUBLE_VERTICALE_LINE = "||";// 双竖线

	public static final int TMX_SENTENCE_TAG = 1;
	public static final int GLS_TAG = 2;




	public static final String SUCCESS = "success";


	public static final int DEFAULT_PAGE_INDEX = 1;
	public static final int DEFAULT_PAGE_SIZE = 10;

	public static Map<Integer, String> dataTypeMap = new HashMap<Integer, String>();


	/** 删除 **/
	public static final int STATUS_DEL = 0;
	/** 正常 **/
	public static final int STATUS_NOTDEL = 1;
	/** 待激活 **/
	public static final int STATUS_ACTIVATE = 2;
	/** 无效 **/
	public static final int STATUS_INVALID = 3;
	public static final int EMAIL_REDIS_TIME = 60 * 15; // 邮箱激活码有效时间

	public static final String SESSION_CURRENT_USER_NAME = "currentUser";
	// public static final String AGG_DETAIL = "agg_detail";

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
