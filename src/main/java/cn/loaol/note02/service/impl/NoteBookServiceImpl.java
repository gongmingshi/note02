package cn.loaol.note02.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.loaol.note02.dao.NoteBookDao;
import cn.loaol.note02.entity.NoteBook;
import cn.loaol.note02.service.NoteBookService;

@Service
public class NoteBookServiceImpl implements NoteBookService{
	@Resource
	NoteBookDao notebookdao;
	public List<NoteBook> notebooklist(String userid) {
		List<NoteBook> notebooklist=notebookdao.noteBookList(userid);
		return notebooklist;
	}
	public NoteBook notebookone(String notebookid) {
		return notebookdao.notebookone(notebookid);
	}

	public int updatenotebook(NoteBook notebook) {
		return notebookdao.updatenotebook(notebook);
	}
	public int insertnotebook(String userid, String notebookname) {
		NoteBook notebook=new NoteBook();
		notebook.setNotebookId(UUID.randomUUID().toString());
		notebook.setNotebookName(notebookname);
		notebook.setUserId(userid);
		notebook.setNotebookTypeId("5");
		notebook.setNotbookCreatetime(new Date(System.currentTimeMillis()));
		return notebookdao.insertnotebook(notebook);
	}
}
