package com.zuiqiang.notice.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.zuiqiang.notice.domain.Notice;
import com.zuiqiang.notice.service.Noticeservice;

/**
 * 公告管理
 * 
 * @author 12645
 *
 */


@Controller
@RequestMapping("/admin/notice")
public class NoticeController {
	@Autowired
	private Noticeservice noticeservice;

	Notice notice = new Notice();

	
	/**  公告的查询
	 * @param  noticeId
	 *@return Notice
	 */
	@GetMapping(value = { "/select" })
	@ResponseBody
	public Notice selectByPrimaryKey(@RequestParam("noticeId") Integer noticeId) { // 返回到页面,公告内容是乱码
		return noticeservice.selectByPrimaryKey(noticeId);
	}

	
	
	/**插入公告
	 * @param  Notice
	 *@return  int
	 */
	@PostMapping(value = { "/insertall" })
	@ResponseBody
	public int insertNotice(Notice notice) {

		return noticeservice.insert(notice);
	}

	
	
	/**插入只给有值的字段赋值（会对传进来的值做非空判断）
	 * @param  notice
	 *@return  int
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {

		// 转换日期
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
	}

	@PostMapping(value = {"insert"})     //insertSelective 对应的 SQL 语句加入了 NULL 检验，只会插入数据不为 null 的字段，
//	                                              而 insert会插入所有字段，会插入 null 数据，     如果定义了表default字段，使用 insert 还是会插入 null 
//	                                               而忽略default , insertSelective 当字段为 null 时会用 default 自动填充
	@ResponseBody
	public int insertSelective(Notice notice) {
		int insertSelective = noticeservice.insertSelective(notice);
		return insertSelective;
	}
	
//	public int insertSelective(@RequestParam(value = "noticeContent",required = false) String noticeContent,//使用inserSelective就会只给有值的字段赋值
//							   @RequestParam(value = "userId",required = false) Integer userId,
//							   @RequestParam(value = "noticeId",required = false) Integer noticeId,
//							   @RequestParam(value = "noticeCreatetime",required = false) Date noticeCreatetime) {
//		//value表示参数名字  required表示是否为必需，defaultValue表示默认值
//		if ( noticeContent == null) {
//			Map<String, String> ret = new HashMap<String, String>();
//			ret.put("notice!", "当前公告为空");
//			notice.setNoticeContent(ret.toString());
//			if (noticeCreatetime == null) {
//				notice.setNoticeCreatetime(new Date());
//				if (userId == null) {
//					notice.setUserId(666);
//					return noticeservice.insertSelective(notice);
//				}else {
//					notice.setUserId(userId);
//					return noticeservice.insertSelective(notice);
//				}
//			}
//			else {
//				notice.setNoticeCreatetime(noticeCreatetime);
//				if (userId == null) {
//					notice.setUserId(666);
//					return noticeservice.insertSelective(notice);
//				}
//				else {
//					notice.setUserId(userId);
//					return noticeservice.insertSelective(notice);
//				}
//			}
//		}else {
//			notice.setNoticeContent(noticeContent);	
//		}
//		if(userId == null) {
//			notice.setUserId(999);
//			if (noticeCreatetime == null) {
//				notice.setNoticeCreatetime(new Date());
//				return noticeservice.insertSelective(notice);
//			}
//			else {
//				notice.setNoticeContent(noticeContent);
//				notice.setNoticeCreatetime(noticeCreatetime);
//				return noticeservice.insertSelective(notice);
//			}
//		}
//	 	if (noticeservice.insertSelective(notice) <= 0) {
//	 		Map<String, String> ret1 = new HashMap<String, String>();
//			ret1.put("notice!", "失败");
//			notice.setNoticeContent(ret1.toString());
//			return 404;
//			}
//		if (noticeCreatetime == null) {
//			notice.setNoticeCreatetime(new Date());
//			return noticeservice.insertSelective(notice);
//		}
//		else {
//			notice.setNoticeCreatetime(noticeCreatetime);
//			return noticeservice.insertSelective(notice);
//		}
//	}

	
	/** 对注入的字段全部更新
	 * @param  notice
	 *@return  int
	 */	

@PostMapping(value = {"updateall"})             //对你注入的字段全部更新，将为空的字段在数据库中置为NULL。
@ResponseBody
public int updateByPrimaryKey( Notice notice) {
	
	int updateall = noticeservice.updateByPrimaryKey(notice);
	return updateall;
	
}


/**对字段进行判断再更新(如果为Null就忽略更新)
 * @param  notice
 *@return  int
 */
@PostMapping(value = {"update"})
@ResponseBody
public int updateByPrimaryKeySelective(Notice notice) {
	int updatea = noticeservice.updateByPrimaryKeySelective(notice);
	return updatea;
	
}


/**刪除
 * @param  noticeId
 *@return  int
 */
@GetMapping(value = {"delete"})
@ResponseBody
public int deleteNotice(@RequestParam("noticeId") Integer noticeId) {
	return noticeservice.deleteByPrimaryKey(noticeId);
}
}