package team.project.vo;

public class itemsVo {
	private int items_num;
	private int main_category_num;
	private String name;
	private int price;
	private String info;
	private String item_date;
	public itemsVo() {}
	public itemsVo(int items_num, int main_category_num, String name, int price, String info, String item_date) {
		super();
		this.items_num = items_num;
		this.main_category_num = main_category_num;
		this.name = name;
		this.price = price;
		this.info = info;
		this.item_date = item_date;
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
}
