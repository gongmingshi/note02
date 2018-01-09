package cn.loaol.note02.service;

import java.util.List;

import cn.loaol.note02.entity.NoteBook;

public interface NoteBookService {
	List<NoteBook> notebooklist(String userid);
	NoteBook notebookone(String notebookid);
	int insertnotebook(String userid,String notebookname);
	int updatenotebook(NoteBook notebook);
}
