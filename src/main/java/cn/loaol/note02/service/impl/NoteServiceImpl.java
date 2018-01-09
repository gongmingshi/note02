package cn.loaol.note02.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.loaol.note02.dao.NoteDao;
import cn.loaol.note02.entity.Note;
import cn.loaol.note02.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	@Resource
	NoteDao notedao;
	public List<Note> notelist(String notebookid) {
		List<Note> notelist=notedao.notelist(notebookid);
		return notelist;
	}
	public Note noteone(String noteid) {
		return notedao.noteone(noteid);
	}
	public int updatenote(Note note) {
		return notedao.updatenote(note);
	}
	public int insternote(String userid, String notebookid, String notetitle) {
		Note note=new Note();
		note.setNoteid(UUID.randomUUID().toString());
		note.setNotebookid(notebookid);
		note.setUserid(userid);
		note.setNotetitle(notetitle);
		note.setNotestatusid("1");
		note.setNotebody("");
		return notedao.insertnote(note);
	}

}
