package team.project.vo;

public class Detail_imgVo {
	private int detail_num_img;
	private int items_img_num;
	private String file_name;
	private String file_type;
	public Detail_imgVo() {}
	public Detail_imgVo(int detail_num_img, int items_img_num, String file_name, String file_type) {
		super();
		this.detail_num_img = detail_num_img;
		this.items_img_num = items_img_num;
		this.file_name = file_name;
		this.file_type = file_type;
	}
	public int getDetail_num_img() {
		return detail_num_img;
	}
	public void setDetail_num_img(int detail_num_img) {
		this.detail_num_img = detail_num_img;
	}
	public int getItems_img_num() {
		return items_img_num;
	}
	public void setItems_img_num(int items_img_num) {
		this.items_img_num = items_img_num;
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
