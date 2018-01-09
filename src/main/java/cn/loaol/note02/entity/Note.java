package cn.loaol.note02.entity;

import java.io.Serializable;

public class Note implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String noteid;
	private String notebookid;
	private String userid;
	private String notestatusid;
	private String notetypeid;
	private String notetitle;
	private String notebody;
	private Long notecreatetime;
	private Long notelastmodifytime;
	public String getNoteid() {
		return noteid;
	}
	public void setNoteid(String noteid) {
		this.noteid = noteid;
	}
	public String getNotebookid() {
		return notebookid;
	}
	public void setNotebookid(String notebookid) {
		this.notebookid = notebookid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNotestatusid() {
		return notestatusid;
	}
	public void setNotestatusid(String notestatusid) {
		this.notestatusid = notestatusid;
	}
	public String getNotetypeid() {
		return notetypeid;
	}
	public void setNotetypeid(String notetypeid) {
		this.notetypeid = notetypeid;
	}
	public String getNotetitle() {
		return notetitle;
	}
	public void setNotetitle(String notetitle) {
		this.notetitle = notetitle;
	}
	public String getNotebody() {
		return notebody;
	}
	public void setNotebody(String notebody) {
		this.notebody = notebody;
	}
	public Long getNotecreatetime() {
		return notecreatetime;
	}
	public void setNotecreatetime(Long notecreatetime) {
		this.notecreatetime = notecreatetime;
	}
	public Long getNotelastmodifytime() {
		return notelastmodifytime;
	}
	public void setNotelastmodifytime(Long notelastmodifytime) {
		this.notelastmodifytime = notelastmodifytime;
	}
	public Note(String noteid, String notebookid, String userid, String notestatusid, String notetypeid,
			String notetitle, String notebody, Long notecreatetime, Long notelastmodifytime) {
		super();
		this.noteid = noteid;
		this.notebookid = notebookid;
		this.userid = userid;
		this.notestatusid = notestatusid;
		this.notetypeid = notetypeid;
		this.notetitle = notetitle;
		this.notebody = notebody;
		this.notecreatetime = notecreatetime;
		this.notelastmodifytime = notelastmodifytime;
	}
	public Note() {
	}
	@Override
	public String toString() {
		return "Note [noteid=" + noteid + ", notebookid=" + notebookid + ", userid=" + userid + ", notestatusid="
				+ notestatusid + ", notetypeid=" + notetypeid + ", notetitle=" + notetitle + ", notebody=" + notebody
				+ ", notecreatetime=" + notecreatetime + ", notelastmodifytime=" + notelastmodifytime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noteid == null) ? 0 : noteid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (noteid == null) {
			if (other.noteid != null)
				return false;
		} else if (!noteid.equals(other.noteid))
			return false;
		return true;
	}
	
}
