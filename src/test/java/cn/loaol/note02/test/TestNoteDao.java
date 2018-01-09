package cn.loaol.note02.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import cn.loaol.note02.dao.NoteDao;
import cn.loaol.note02.entity.Note;


public class TestNoteDao extends BaseTest {
	@Test
	public void testnotelist() {
	NoteDao notedao=ctx.getBean("noteDao", NoteDao.class);
	List<Note> list=notedao.notelist("6d763ac9-dca3-42d7-a2a7-a08053095c08");
	System.out.println(list);
	}
	@Test
	public void testnoteone() {
		NoteDao notedao=ctx.getBean("noteDao", NoteDao.class);
		Note noteone=notedao.noteone("c784305e-66fe-4356-b855-a35c15ae5383");
		System.out.println(noteone);
	}
	@Test
	public void testinsternote() {
		NoteDao notedao=ctx.getBean("noteDao", NoteDao.class);
		Note noteone=notedao.noteone("01da5d69-89d5-4140-9585-b559a97f9cb0");
		System.out.println(noteone);
		String newid=UUID.randomUUID().toString();
		noteone.setNoteid(newid);
		noteone.setNotetitle("更新测试1111");
		noteone.setNotebody("更新测试内容11！");
		noteone.setNotelastmodifytime(System.currentTimeMillis());
		noteone.setNotecreatetime(System.currentTimeMillis());
		System.out.println(noteone);
		int rs=notedao.insertnote(noteone);
		noteone=notedao.noteone(newid);
		System.out.println(noteone);
	}
	@Test
	public void testupdatenote() {
		NoteDao notedao=ctx.getBean("noteDao", NoteDao.class);
		Note noteone=notedao.noteone("01da5d69-89d5-4140-9585-b559a97f9cb0");
		System.out.println(noteone);
		noteone.setNotetitle("更新测试1111");
		noteone.setNotebody("更新测试内容11！");
		noteone.setNotestatusid("1");
		noteone.setNotelastmodifytime(System.currentTimeMillis());
		noteone.setNotecreatetime(System.currentTimeMillis());
		System.out.println(noteone);
		int rs=notedao.updatenote(noteone);
		noteone=notedao.noteone("01da5d69-89d5-4140-9585-b559a97f9cb0");
		System.out.println(noteone);
	}
}