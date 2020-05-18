package team.project.vo;

public class items_imgVo {
	private int items_img_num;
	private int items_num;
	private String file_name;
	private String file_type;
	public items_imgVo() {}
	public items_imgVo(int items_img_num, int items_num, String file_name, String file_type) {
		super();
		this.items_img_num = items_img_num;
		this.items_num = items_num;
		this.file_name = file_name;
		this.file_type = file_type;
	}
	public int getItems_img_num() {
		return items_img_num;
	}
	public void setItems_img_num(int items_img_num) {
		this.items_img_num = items_img_num;
	}
	public int getItems_num() {
		return items_num;
	}
	public void setItems_num(int items_num) {
		this.items_num = items_num;
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
