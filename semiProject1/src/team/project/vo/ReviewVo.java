package team.project.vo;

public class ReviewVo {
	private int review_num; // 리뷰번호
	private int items_num; // 상품번호
	private String id; // 회원아이디
	private String title; // 리뷰제목
	private String content; // 리뷰내용

	public ReviewVo() {
	}

	public ReviewVo(int review_num, int items_num, String id, String title, String content) {
		super();
		this.review_num = review_num;
		this.items_num = items_num;
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public int getItems_num() {
		return items_num;
	}

	public void setItems_num(int items_num) {
		this.items_num = items_num;
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