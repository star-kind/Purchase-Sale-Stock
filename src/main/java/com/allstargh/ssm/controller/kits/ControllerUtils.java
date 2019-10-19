package com.allstargh.ssm.controller.kits;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allstargh.ssm.json.ResponseResult;
import com.allstargh.ssm.pojo.Accounts;
import com.allstargh.ssm.service.ex.SelfServiceException;
import com.allstargh.ssm.service.ex.ServiceExceptionEnum;

/**
 * 控制器之超类
 * 
 * @author gzh
 *
 */
@ControllerAdvice
public class ControllerUtils {
	/**
	 * "成功"状态码(响应)
	 */
	public static final Integer SUCCESS = 200;

	/**
	 * 工程日志目录绝对之前置根路径
	 */
	public final static String ENGINE_DAILY_PATH = "/home/admin/workspace/eclipse/eclipse-workspace/Logs/";

	/**
	 * 系统换行符
	 */
	protected static final String LINE_SEPARATOR = System.getProperty("line.separator") + "</p>";

	/**
	 * 文件输出流
	 */
	protected static FileOutputStream fos = null;

	/**
	 * 二进制数组,充作缓冲对象
	 */
	protected static byte[] buff = null;

	/**
	 * 当前时间字符串
	 */
	protected static String now_time = null;

	static {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		now_time = format.format(new Date());
	}

	/** p标签前缀 */
	public static String p_tag_prefix = "<p>";

	/**
	 * 统一将异常封入json实体
	 * 
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({ SelfServiceException.class })
	public ResponseResult<Void> exceptioHandler(Throwable e) {
		ResponseResult<Void> rr = new ResponseResult<Void>();

		rr.setMessage(e.getMessage());

		/* 根据异常信息设置异常码 */
		switch (e.getMessage()) {
		case "审批已过截止期,禁止更改":
			rr.setState(ServiceExceptionEnum.OVER_DEADLINE.getCode());
			break;

		case "权限错位,您没有相应权限":
			rr.setState(ServiceExceptionEnum.COMPETENCE_DISLOCATION.getCode());
			break;

		case "您已下线,请重新登录":
			rr.setState(ServiceExceptionEnum.OFFLINE_LOGIN.getCode());
			break;

		case "此名已有人先用,请另换名字":
			rr.setState(ServiceExceptionEnum.UNAME_DUPLICATE_CONFLICT.getCode());
			break;

		case "1个电话至多只准绑定注册1个账户":
			rr.setState(ServiceExceptionEnum.COUNT_PHONE_OUT_RANGE.getCode());
			break;

		case "您尚未填完信息":
			rr.setState(ServiceExceptionEnum.SUBMIT_DATA_UNCOMPLETELY.getCode());
			break;

		case "用户名或密码未输入":
			rr.setState(ServiceExceptionEnum.UNAME_OR_KWD_NOT_INPUT.getCode());
			break;

		case "用户名错误,无此用户名":
			rr.setState(ServiceExceptionEnum.USRNAME_ERR.getCode());
			break;

		case "密码错误,请检查密码无误后再登录":
			rr.setState(ServiceExceptionEnum.KEYWORD_ERR.getCode());
			break;

		case "您的账号已被注销,请联络管理员重新激活":
			rr.setState(ServiceExceptionEnum.CANCELED_ACCOUNT.getCode());
			break;

		case "未寻获有关结果":
			rr.setState(ServiceExceptionEnum.NO_RESULT_RECORD.getCode());
			break;

		case "系统繁忙,请稍后重试":
			rr.setState(ServiceExceptionEnum.SYSTEM_BUSY.getCode());
			break;

		case "提交为空":
			rr.setState(ServiceExceptionEnum.COMMIT_HAS_NULL.getCode());
			break;

		}

		return rr;
	}

	/**
	 * 
	 * @param session
	 * @return
	 * @throws SelfServiceException
	 */
	public Integer getUsridFromSession(HttpSession session) throws SelfServiceException {
		Integer usrid = null;
		int anchor = 0;

		try {
			usrid = Integer.parseInt(session.getAttribute("usrid").toString());
		} catch (Exception e) {
			e.printStackTrace();
			anchor = 1;
		}

		if (anchor == 1) {
			String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(description);
		}

		return usrid;

	}

	/**
	 * 
	 * @param session
	 * @return
	 * @throws SelfServiceException
	 */
	public String getUsrnameFromSession(HttpSession session) throws SelfServiceException {
		int anchor = 0;
		String usrname = null;

		try {
			usrname = session.getAttribute("usrname").toString();
		} catch (Exception e) {
			e.printStackTrace();
			anchor = 1;
		}

		if (anchor == 1) {
			String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();
			throw new SelfServiceException(description);
		}

		return usrname;

	}

	/**
	 * 创建文件夹和文件
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String createDirectoryAndFile(String fileName) throws IOException {
		File file = new File(ENGINE_DAILY_PATH);

		if (!file.exists()) {
			file.mkdir();
		}

		File fi = new File(file, fileName);
		fi.createNewFile();

		String path = fi.getAbsolutePath();

		return path;
	}

	/**
	 * 把记录写入日志文件(针对单行操作)
	 * 
	 * @param affect
	 * @param fileName
	 * @param sentence
	 */
	public void writeRecordLog(Integer affect, String fileName, String sentence) {
		String filePath = null;

		try {
			filePath = createDirectoryAndFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (affect == 1) {
			textWriter(sentence, filePath);
		}

	}

	/**
	 * 把记录写入日志文件(针对单行操作) <b>overload</b>
	 * 
	 * @param fileName
	 * @param sentence
	 */
	public void writeRecordLog(String fileName, String sentence) {
		String filePath = null;

		try {
			filePath = createDirectoryAndFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		textWriter(sentence, filePath);

	}

	/**
	 * 将内容写入文件中
	 * 
	 * @param record
	 * @param filePath
	 */
	public void textWriter(String record, String filePath) {
		try {
			fos = new FileOutputStream(filePath, true);
			buff = record.getBytes();
			fos.write(buff);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}