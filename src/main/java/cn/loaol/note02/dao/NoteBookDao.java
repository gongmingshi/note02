package cn.loaol.note02.dao;

import java.util.List;

import cn.loaol.note02.entity.NoteBook;

public interface NoteBookDao {
	List<NoteBook> noteBookList(String userid);
	NoteBook notebookone(String notebookid);
	int insertnotebook(NoteBook notebook);
	int updatenotebook(NoteBook notebook);
}