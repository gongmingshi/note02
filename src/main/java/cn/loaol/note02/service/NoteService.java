package cn.loaol.note02.service;

import java.util.List;

import cn.loaol.note02.entity.Note;

public interface NoteService {
	List<Note> notelist(String notebookid);
	Note noteone(String noteid);
	int insternote(String userid,String notebookid,String notebooktitle);
	int updatenote(Note note);
}
