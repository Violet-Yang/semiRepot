package team.project.vo;

public class NoticeVo {
	private int notice_num;
	private String id; // 관리자아이디
	private String title;
	private String content;

	public NoticeVo() {
	}

	public NoticeVo(int notice_num, String id, String title, String content) {
		super();
		this.notice_num = notice_num;
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}