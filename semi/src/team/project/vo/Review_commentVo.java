package team.project.vo;

public class Review_commentVo {
	private int comm_num; // 리뷰댓글번호
	private int review_num; // 리뷰번호
	private String id; // 관리자아이디
	private String title; // 답글제목
	private String content; // 답글내용

	public Review_commentVo() {
	}

	public Review_commentVo(int comm_num, int review_num, String id, String title, String content) {
		super();
		this.comm_num = comm_num;
		this.review_num = review_num;
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getComm_num() {
		return comm_num;
	}

	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
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