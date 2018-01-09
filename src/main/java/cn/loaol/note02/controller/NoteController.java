package cn.loaol.note02.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loaol.note02.entity.Note;
import cn.loaol.note02.service.impl.NoteServiceImpl;

@Controller
@RequestMapping("note")
public class NoteController {
	@Resource
	NoteServiceImpl noteservice;
	@RequestMapping("/getnotelist.do")
	@ResponseBody
	public Object getnotelist(String notebookid) {
		return noteservice.notelist(notebookid);
	}
	@RequestMapping("/updatenote.do")
	@ResponseBody
	public Object updatenote(String noteid,String notetitle,String notebody) {
		Note note=noteservice.noteone(noteid);
		note.setNotetitle(notetitle);
		note.setNotebody(notebody);
		noteservice.updatenote(note);
		return noteservice.updatenote(note);
	}
	@RequestMapping("/addnote.do")
	@ResponseBody
	public Object addnote(String userid,String notebookid,String notetitle) {
		return noteservice.insternote(userid, notebookid, notetitle);
	}
}
