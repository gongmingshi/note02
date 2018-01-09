package cn.loaol.note02.entity;

import java.io.Serializable;
import java.sql.Date;

public class NoteBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String notebookId;
	private String userId;
	private String notebookTypeId;
	private String notebookName;
	private String notebookDesc;
	private Date notbookCreatetime;

	public NoteBook() {
	}
	public NoteBook(String notebookId, String userId, String notebookTypeId, String notebookName, String notebookDesc,
			Date notbookCreatetime) {
		super();
		this.notebookId = notebookId;
		this.userId = userId;
		this.notebookTypeId = notebookTypeId;
		this.notebookName = notebookName;
		this.notebookDesc = notebookDesc;
		this.notbookCreatetime = notbookCreatetime;
	}
	
	@Override
	public String toString() {
		return "NoteBook [notebookId=" + notebookId + ", userId=" + userId + ", notebookTypeId=" + notebookTypeId
				+ ", notebookName=" + notebookName + ", notebookDesc=" + notebookDesc + ", notbookCreatetime="
				+ notbookCreatetime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notebookId == null) ? 0 : notebookId.hashCode());
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
		NoteBook other = (NoteBook) obj;
		if (notebookId == null) {
			if (other.notebookId != null)
				return false;
		} else if (!notebookId.equals(other.notebookId))
			return false;
		return true;
	}
	public String getNotebookId() {
		return notebookId;
	}
	public void setNotebookId(String notebookId) {
		this.notebookId = notebookId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNotebookTypeId() {
		return notebookTypeId;
	}
	public void setNotebookTypeId(String notebookTypeId) {
		this.notebookTypeId = notebookTypeId;
	}
	public String getNotebookName() {
		return notebookName;
	}
	public void setNotebookName(String notebookName) {
		this.notebookName = notebookName;
	}
	public String getNotebookDesc() {
		return notebookDesc;
	}
	public void setNotebookDesc(String notebookDesc) {
		this.notebookDesc = notebookDesc;
	}
	public Date getNotbookCreatetime() {
		return notbookCreatetime;
	}
	public void setNotbookCreatetime(Date notbookCreatetime) {
		this.notbookCreatetime = notbookCreatetime;
	}
	
	
}
