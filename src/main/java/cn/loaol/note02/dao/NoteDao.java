package cn.loaol.note02.dao;

import java.util.List;

import cn.loaol.note02.entity.Note;

public interface NoteDao {
	List<Note> notelist(String notebookid);
	Note noteone(String noteid);
	int insertnote(Note note);
	int updatenote(Note note);
}
