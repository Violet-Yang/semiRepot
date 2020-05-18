package team.project.vo;

public class itemsTotalVo {
	private int items_num;
	private int main_category_num;
	private String name;
	private int price;
	private String info;
	private String item_date;
	private int items_img_num;
	private String file_name;
	private String file_type;
	public itemsTotalVo() {}
	public itemsTotalVo(int items_num, int main_category_num, String name, int price, String info, String item_date,
			int items_img_num, String file_name, String file_type) {
		super();
		this.items_num = items_num;
		this.main_category_num = main_category_num;
		this.name = name;
		this.price = price;
		this.info = info;
		this.item_date = item_date;
		this.items_img_num = items_img_num;
		this.file_name = file_name;
		this.file_type = file_type;
	}
	public int getItems_num() {
		return items_num;
	}
	public void setItems_num(int items_num) {
		this.items_num = items_num;
	}
	public int getMain_category_num() {
		return main_category_num;
	}
	public void setMain_category_num(int main_category_num) {
		this.main_category_num = main_category_num;
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
	@Override
	public String toString() {
		return "itemsTotalVo [items_num=" + items_num + ", main_category_num=" + main_category_num + ", name=" + name
				+ ", price=" + price + ", info=" + info + ", item_date=" + item_date + ", items_img_num="
				+ items_img_num + ", file_name=" + file_name + ", file_type=" + file_type + "]";
	}
}
