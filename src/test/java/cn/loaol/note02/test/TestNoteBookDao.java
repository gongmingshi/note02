package cn.loaol.note02.test;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import cn.loaol.note02.dao.NoteBookDao;
import cn.loaol.note02.entity.NoteBook;

public class TestNoteBookDao extends BaseTest {
	@Test
	public void testnotebookList() {
		NoteBookDao notebookdao=ctx.getBean("noteBookDao", NoteBookDao.class);
		List<NoteBook> list=notebookdao.noteBookList("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println(list);
	}
	
	@Test
	public void testnotebookone() {
		NoteBookDao notebookdao=ctx.getBean("noteBookDao", NoteBookDao.class);
		NoteBook notebookone=notebookdao.notebookone("0037215c-09fe-4eaa-aeb5-25a340c6b39b");
		System.out.println(notebookone);
	}
	
	@Test
	public void testupdatenotebook() {
		NoteBookDao notebookdao=ctx.getBean("noteBookDao", NoteBookDao.class);
		NoteBook notebookone=notebookdao.notebookone("0037215c-09fe-4eaa-aeb5-25a340c6b39b");
		notebookone.setNotebookName("update123123");
		notebookdao.updatenotebook(notebookone);
		System.out.println(notebookone);
	}
	
	@Test
	public void testinsertnotebook() {
		NoteBookDao notebookdao=ctx.getBean("noteBookDao", NoteBookDao.class);
		NoteBook notebookone=new NoteBook();
		String notebookId=UUID.randomUUID().toString();
		notebookone.setNotebookId(notebookId);
		notebookone.setUserId("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		notebookone.setNotebookName("inster测试");
		notebookone.setNotebookTypeId("5");
		notebookone.setNotbookCreatetime(new Date(System.currentTimeMillis()));
		notebookdao.insertnotebook(notebookone);
		notebookone=notebookdao.notebookone(notebookId);
		System.out.println(notebookone);
	}
}
