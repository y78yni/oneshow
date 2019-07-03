package com.jun.oneshow.exception;

import com.jun.oneshow.constants.CommonConstants;

public enum SystemErrorCode implements ErrorCode {
	/** 系统成功 **/
	SUC("成功", "0"),

	/** 非法参数 */
	ILLEGAL_PARAMETER("非法参数。", "SB01001"),

	/** 系统异常 */
	SYSTEM_ERROR("系统异常，请稍后重试。", "SB01002"),

	/** 数据库访问异常 */
	DB_ACCESS_ERROR("数据库访问异常。", "SB01003"),

	/** 系统加载错误 **/
	SYS_INIT_ERROR("系统加载错误 。", "SB01004"),

	/** redis资源错误 **/
	REDIS_RES_ERROR("redis资源错误。 ", "SB01014"),

	/** redis获取错误 **/
	REDIS_GET_ERROR("redis获取错误。", "SB01015"),

	/** redis存储错误 **/
	REDIS_PUT_ERROR("redis存储错误。", "SB01016"),

	/** 用户不存在 **/
	NOT_EXIST_USER("用户不存在", "SB01017"),
	/** 密码错误 **/
	PASSWORD_CODE_ERROR("密码错误。", "SB01018"),
	/** 邮件发送异常 **/
	SEND_MAIL_ERROR("邮件发送失败。", "SB01019"),
	/** 用户状态不正确 **/
	INVALID_USER_STATE("用户状态不正确。", "SB01020"),
	/** 审核后台用户无权限操作 **/
	SYS_MGR_UAUTHORIZED_OPERATION("无权限操作。", "SB01021"),
	/** 用户访问次数超限 **/
	USER_CALL_EXCEEDS("访问次数超限", "SB01022"),
	/** 购物车中没有数据 **/
	EMPTY_TU_CART("下载失败", "SB01023"),
	/** 系统维护 **/
	SYSTEM_MAINTENANCE("系统维护中，暂不支持登陆和注册操作！", "SB01024"),
	/** 手太快，请输入验证码后继续 **/
	ACCESS_LIMIT("手太快，请输入验证码后继续...", "SB01025"),

	/** 文件不存在 **/
	FILE_NOT_EXITS("文件不存在", "SB01026"),
	/** zip文件中包含多个文件 **/
	TOO_MANY_FILE_IN_ZIP("zip文件中包含多个文件", "SB01027"),
	/** zip文件中包含多个文件 **/
	IMPORT_DATA_SOURCE_ERROR("导入数据源数据有误", "SB01028"),

	UNKNOWN_ERROR("未知错误", "SB00000"), ES_ERROR("ES发生错误", "SB01029"), INDEX_ERROR("索引错误", "SB01030"),
	/** 用户名未激活，请点击去激活 **/
	USER_NOT_ACTIVATE("用户名未激活，请点击去激", "SB01051"),
	/** 用户名不能为空 **/
	USER_EMPTY("用户名不能为空", "SB01032"),
	/** 姓名不能为空 **/
	REAL_NAME_EMPTY("用户名不能为空", "SB01043"),
	/** 密码不能为空 **/
	USERPWD_EMPTY("密码不能为空", "SB01033"),
	/** 用户已存在 **/
	USER_EXIST("用户已存在", "SB01046"),
	/** 邮箱已存在 **/
	EMAIL_EXIST("邮箱已存在", "SB01047"),
	/** 手机已存在 **/
	PHONE_EXIST("手机已存在", "SB01048"),
	/** 邮箱不能为空 **/
	EMAIL_EMPTY("邮箱不能为空", "SB01037"),
	/** 手机不能为空 **/
	PHONE_EMPTY("手机不能为空", "SB01049"),
	/** 手机错误 **/
	PHONE_ERROR("手机错误", "SB01050"),
	/** 添加用户失败 **/
	ADD_USER_ERROR("添加用户失败", "SB01034"),
	/** 邮件激活码错误 **/
	EMAIL_CODE_ERROR("邮件激活码错误或者已经失效", "SB01035"),
	/** 邮件激活错误 **/
	EMAIL_ACTION_ERROR("邮件激活", "SB01036"),
	/** 用户未登录 **/
	USER_NOT_LOGIN("用户未登录", "SB01038"),

	/** 用户无访问权限 **/
	USER_NO_ACESS("用户无访问权限", "SB01039"),
	/** 获取省份列表失败 **/
	GET_PROVINCE_ERROR("获取省份列表失败", "SB01041"),
	/** 获取单位类型列表失败 **/
	GET_UNTYPE_ERROR("获取单位类型列表失败", "SB01042"),
	/** 机构用户无法添加收藏夹 **/
	ORG_USER_ERROR("机构用户无法添加收藏夹", "SB01043"),
	/** 用户名或者密码错误 **/
	USER_USERPASSWORD_ERROR("用户名或者密码错误", "SB01031"),
	/** 收藏夹已存在此条数据 **/
	FAVORITES_EXIST_ERROR("收藏夹已存在此条数据", "SB01044"),
	/** 邮箱格式可能不对 **/
	EMAIL_ERROR_PATTERN("邮箱格式可能不对", "SB01045"),
	/** 数据库操作错误 **/
	SQL_ERROR("数据库操作错误", "SB01040");

	/** 异常描述 */
	private final String description;

	/** 异常编码 */
	private final String shortCode;

	private SystemErrorCode(String description, String shortCode) {
		this.description = description;
		this.shortCode = shortCode;
	}

	@Override
	public String getDescription() {
		return CommonConstants.getKey(this.description);
	}

	@Override
	public String getCode() {
		return this.shortCode;
	}

	@Override
	public ExceptionType getType() {
		return ExceptionType.SYSTEM_ERROR;
	}

	@Override
	public String toString() {
		return "[" + getCode() + "," + getDescription() + "]";
	}

}
