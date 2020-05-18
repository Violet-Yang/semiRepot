package team.project.vo;

public class itemsTotalVo {
	private int items_num;
	private String name;
	private int price;
	private String info;
	private String item_date;
	private String file_name;
	private String file_type;
	private String item_size;
	public itemsTotalVo() {}
	public itemsTotalVo(int items_num, String name, int price, String info, String item_date, String file_name,
			String file_type, String item_size) {
		super();
		this.items_num = items_num;
		this.name = name;
		this.price = price;
		this.info = info;
		this.item_date = item_date;
		this.file_name = file_name;
		this.file_type = file_type;
		this.item_size = item_size;
	}
	public int getItems_num() {
		return items_num;
	}
	public void setItems_num(int items_num) {
		this.items_num = items_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getItem_date() {
		return item_date;
	}
	public void setItem_date(String item_date) {
		this.item_date = item_date;
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
	public String getItem_size() {
		return item_size;
	}
	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}
}
