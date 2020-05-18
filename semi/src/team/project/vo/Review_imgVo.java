package team.project.vo;

public class Review_imgVo {
	private int re_img_num;
	private int review_num;
	private String file_name;
	private String file_type;

	public Review_imgVo() {
	}

	public Review_imgVo(int re_img_num, int review_num, String file_name, String file_type) {
		super();
		this.re_img_num = re_img_num;
		this.review_num = review_num;
		this.file_name = file_name;
		this.file_type = file_type;
	}

	public int getRe_img_num() {
		return re_img_num;
	}

	public void setRe_img_num(int re_img_num) {
		this.re_img_num = re_img_num;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
}