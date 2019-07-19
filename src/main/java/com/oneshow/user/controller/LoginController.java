package com.oneshow.user.controller;

import com.aliyuncs.exceptions.ClientException;
import com.oneshow.commom.exception.SBException;
import com.oneshow.commom.util.Assert;
import com.oneshow.commom.util.R;
import com.oneshow.commom.util.RedisUtil;
import com.oneshow.commom.util.ValidatorUtils;
import com.oneshow.user.entity.Form.LoginForm;
import com.oneshow.user.entity.User;
import com.oneshow.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;

@Controller
public class LoginController {

	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	@Resource
	private RedisUtil redisUtil;

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String loginPage() {
	// return "login";
	// }
	/**
	 * 登录
	 *
	 * @return
	 */
	@ApiOperation(value = "登录")
	@PostMapping("/login")
	@ResponseBody
	public R login(@RequestBody LoginForm loginForm) {
		ValidatorUtils.validateEntity(loginForm);
		UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getLoginName(), loginForm.getPassWord());
		Subject subject = SecurityUtils.getSubject();
		R r = new R();
		try {
			subject.login(token);
			r.put("msg", "成功");
			return r;
		} catch (AuthenticationException e) {
			String msg = "用户或密码错误";
			if (StringUtils.isNotEmpty(e.getMessage())) {
				msg = e.getMessage();
			}
			return R.error(msg);
		}
	}

	/**
	 * 手机登录
	 *
	 * @return
	 */
	@ApiOperation(value = "手机登录")
	@PostMapping("/phonLogin")
	@ResponseBody
	public R phonLogin(String phone, String code) {
		User user = userService.findPhone(phone);
		if (user == null) {
			throw new SBException("手机号错误");
		}
		String redisPhone = (String) redisUtil.get(phone);
		if (!redisPhone.equals(phone) && redisPhone != null) {
			throw new SBException("验证码错误");
		}
		redisUtil.del(code);
		return R.ok();
	}
	/**
	 * 手机登录验证码
	 *
	 * @return
	 */
	@ApiOperation(value = "登录验证码")
	@PostMapping(value = "/loginCode")
	@ResponseBody
	public R loginCode(String phone) throws ClientException {
		Assert.isNull(phone, "手机不能为空");
		User user = userService.findPhone(phone);
		if (user == null) {
			throw new SBException("手机错误，请重新输入");
		}
		// 随机生成6位数字
		String code = String.valueOf(new Random().nextInt(899999) + 100000);
		// MoblieMessageUtil.RegisterSms(phone, code,"login");
		// 验证码存入redis15分钟
		log.info(code);
		redisUtil.set(phone, code, 900);
		return R.ok("短信发送成功");
	}
	/**
	 * 退出登陆
	 */
	@ApiOperation(value = "退出登陆")
	@PostMapping("/logout")
	@ResponseBody
	public R loginOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return R.ok("成功");
	}

	@GetMapping("/unauth")
	public String unauth() {
		return "error/unauth";
	}

	/**
	 * 注册
	 *
	 * @return
	 */
	@ApiOperation(value = "注册")
	@PostMapping("/register")
	@ResponseBody
	public R register(@RequestBody User user) {
		ValidatorUtils.validateEntity(user);
		// TODO 后续注册用户时不允许全数字作为userName，因为手机注册的时候默认手机也为用户名。
		userService.save(user);
		return R.ok();
	}

	/**
	 * 手机注册
	 *
	 * @return
	 */
	@ApiOperation(value = "手机注册")
	@PostMapping("/phoneRegister")
	@ResponseBody
	public R phoneRegister(@RequestBody User user, String code) {
		if (userService.findPhone(user.getMobile()) != null) {
			throw new SBException("此手机号已存在");
		}
		String redisCode = (String) redisUtil.get(user.getMobile());
		if (!redisCode.equals(code) && redisCode != null) {
			throw new SBException("验证码错误");
		}
		userService.savaPhone(user);
		redisUtil.del(user.getMobile());
		return R.ok();
	}

	/**
	 * 发送手机注册验证码
	 *
	 * @return
	 */
	@ApiOperation(value = "手机注册验证码")
	@PostMapping(value = "/phoneCode")
	@ResponseBody
	public R phoneCode(String phone) throws ClientException {
		Assert.isNull(phone, "手机不能为空");
		User user = userService.findPhone(phone);
		if (user != null) {
			throw new SBException("此手机号已存在");
		}
		// 随机生成6位数字
		String code = String.valueOf(new Random().nextInt(899999) + 100000);
		// MoblieMessageUtil.RegisterSms(phone, code,"res");
		// 验证码存入redis15分钟
		log.info(code);
		redisUtil.set(phone, code, 900);
		return R.ok("短信发送成功");
	}
}
