package com.alibaba.NetCTOSS.usermag.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.Messager;
import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.usermag.realm.CustomizedToken;
import com.alibaba.NetCTOSS.usermag.realm.LoginType;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;
import com.alibaba.NetCTOSS.usermag.service_handle.IUserHandleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final String USER_LOGIN_TYPE = LoginType.USER.toString();

	@Resource
	private IUserDemandService iUserDemandService;
	@Resource
	private IUserHandleService iUserHandleService;

	/**
	 * 用户账户登录
	 * 
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = { "application/json" })
	public Messager login(UserBean user, String code, String loginType, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();// 获取subject主体内容
		CustomizedToken customizedToken = new CustomizedToken(user.getLoginName(), user.getPassword(), USER_LOGIN_TYPE);
		// UsernamePasswordToken token = new UsernamePasswordToken();
		Session session = subject.getSession();
		// 得到后台随机生成验证码的数字是多少
		String CODE = (String) session.getAttribute("code");

		Messager msg = null;
		try {
			subject.login(customizedToken);

			session.setAttribute("user", user);
			/*
			 * System.out.println("sessionId:" +session.getId());
			 * System.out.println("sessionHost:" + session.getHost());
			 * System.out.println("sessionTimeout:" + session.getTimeout());
			 * session.setAttribute("info", "session的数据");
			 */
			if (!CODE.equals(code)) {
				msg = new Messager(0, "验证码输入错误，请重新输入！");
				return msg;
			} else {
				msg = new Messager(1, "登录成功！");
				return msg;
			}
		} catch (Exception e) {
			msg = new Messager(-1, "用户名或者密码错误，请重新输入！");
			return msg;
		}
	}

	@RequestMapping(value = "/find", method = { RequestMethod.GET }, produces = { "application/json" })
	public Map<Object, Object> likeFindAll(UserBean UserBean, Integer page, Integer rows) {
		Map<Object, Object> map = new HashMap<>();

		List<UserBean> li = iUserDemandService.findLikeByBean(UserBean);

		PageHelper.startPage(page, rows);

		List<UserBean> lis = iUserDemandService.findLikeByBean(UserBean);

		PageInfo<UserBean> pages = new PageInfo<UserBean>(lis);

		map.put("total", li.size());// 得到总条数
		map.put("rows", pages.getList());// 得到每页的数据

		return map;
	}

	@RequestMapping(value = "/findone", method = { RequestMethod.GET }, produces = { "application/json" })
	public UserBean findOne(UserBean UserBean) {
		UserBean bean = iUserDemandService.findByBean(UserBean);
		return bean;
	}
	@RequestMapping(value = "/allname", method = { RequestMethod.GET }, produces = { "application/json" })
	public List<Map> findAllName() {
		
		List<Map> li  = new ArrayList<>();
 		
		List<UserBean> list = iUserDemandService.findAllUserBean();
		//转换
		for (UserBean mealBean : list) {
			Map map = new HashMap<>();
			map.put("id", mealBean.getLoginName());
			map.put("text", mealBean.getLoginName());
			li.add(map);
		}
		
		return  li;
	}

	@RequestMapping(value = "/updateone", method = { RequestMethod.PUT })
	public void updaeOne(UserBean UserBean) {
		UserBean user = new UserBean();
		user.setId(UserBean.getId());
		user = iUserDemandService.findByBean(user);

		user.setAddress(UserBean.getAddress());
		user.setGender(user.getGender());
		user.setIdCard(user.getIdCard());
		user.setLoginName(user.getLoginName());
		user.setPostcode(user.getPostcode());
		user.setPassword(user.getPassword());
		user.setQq(user.getQq());
		user.setTel(user.getTel());

		iUserHandleService.updateUserBean(user);
	}

	@RequestMapping(value = "/deleteone", method = { RequestMethod.DELETE })
	public void deleteOne(UserBean UserBean) {

		UserBean = iUserDemandService.findByBean(UserBean);

		UserBean.setBo(0);

		iUserHandleService.updateUserBean(UserBean);
	}

	@RequestMapping(value = "/addone", method = { RequestMethod.POST })
	public void addOne(UserBean UserBean) {
		iUserHandleService.saveUserBean(UserBean);
	}

	@RequestMapping(value = "/users", method = { RequestMethod.POST }, produces = { "application/json" })
	public Map adds(@RequestParam("file") CommonsMultipartFile file) {
		// 文件的原始名称
		String originalFilename = file.getOriginalFilename();

		// 给真实文件的文件名前面加上一个时间戳
		String fileName = System.currentTimeMillis() + "_" + originalFilename;
		String dir = "D://files";
		String path = "";

		Map map = new HashMap<>();
		List<UserBean> li = new ArrayList<>();

		try {
			File fileDir = new File(dir);
			if (!fileDir.exists() || !fileDir.isDirectory()) {
				fileDir.mkdir();
			}
			path = dir + File.separator + fileName;
			file.getFileItem().write(new File(path));// 就完成了临时文件，存储到真实文件的过程

			InputStream inputStream = new FileInputStream(path);

			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);

			DataFormatter formatter = new DataFormatter();

			// 变量没行数据
			for (Row row : sheet) {

				// 创建对象 用于保存数据 每行中每列的
				UserBean userBean = new UserBean();
				int a = 1;
				for (Cell cell : row) {
					CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());

					// 单元格名称 不是第一行的 表头
					String str = cellRef.formatAsString();
					if (!str.matches("[A,Z]+1")) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:// 字符串型

							setBean1(userBean, a, cell.getRichStringCellValue().getString());
							break;
						case Cell.CELL_TYPE_NUMERIC:// 数值型

							if (DateUtil.isCellDateFormatted(cell)) {
								// 如果是date类型则 ，获取该cell的date值

								System.out.println(cell.getDateCellValue());
							} else {// 纯数字
								setBean2(userBean, a, cell.getNumericCellValue());
							}
							break;
						default:
							map.put("mag", "添加失败，文件不符合规范，数据为空等问题");
							return map;
						}
					}
					a++;
				}
				if (findOne(userBean) != null) {
					map.put("mag", "添加失败，文件不符合规范，或者有账户已经存在");
					return map;
				} else {
					li.add(userBean);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("mag", "添加失败，文件不符合规范，或者有账户已经存在");
			return map;
		}

		for (UserBean userBean : li) {
			addOne(userBean);
		}
		map.put("mag", "添加成功");
		return map;
	}

	@RequestMapping(value = "/findAll", method = { RequestMethod.GET }, produces = { "application/json" })
	public List<UserBean> findAllUser() {

		List<UserBean> list = iUserDemandService.findAllUserBean();

		return list;
	}
	
	
	@RequestMapping(value = "/findYearByAccountName", method = { RequestMethod.GET }, produces = { "application/json" })
	public List<AccountYearBillBean> findYearByAccountName(String AccountName) {

		List<AccountYearBillBean> list = iUserDemandService.findByAccountYearBillBeanByAccoundName(AccountName);

		return list;
	}

	private void setBean1(UserBean bean, int a, String cell) {
		switch (a) {
		case 1:// 名字
			bean.setUserName(cell);
			break;
		case 4:// 性别
			if ("男".equals(cell)) {
				bean.setGender(1);
			} else
				bean.setGender(0);
			break;
		case 5:// 通信地址
			bean.setAddress(cell);
			break;
		case 8:// 登录名
			bean.setLoginName(cell);
			break;
		case 9:// 登录密码
			bean.setPassword(cell);
			break;
		}
	}

	private void setBean2(UserBean bean, int a, double cell) {
		switch (a) {
		case 2:// 电话号码
			bean.setTel((int) cell + "");
			break;
		case 3:// 身份证
			bean.setIdCard((int) cell + "");
			break;
		case 6:// 邮编
			bean.setPostcode((int) cell);
			break;
		case 7:// QQ
			bean.setQq((int) cell + "");
			break;
		}
	}

}
