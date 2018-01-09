package cn.loaol.note02.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loaol.note02.service.impl.NoteBookServiceImpl;

@Controller
@RequestMapping("notebook")
public class NoteBookController {
	@Resource
	NoteBookServiceImpl notebookservice;
	@RequestMapping("/getnotebooklist.do")
	@ResponseBody
	public Object getNotebookList(String userid) {
		return notebookservice.notebooklist(userid);
	}
	@RequestMapping("/addnotebook.do")
	@ResponseBody
	public Object addNotebook(String userid,String notebookname) {
		return notebookservice.insertnotebook(userid,notebookname);
	}
}
