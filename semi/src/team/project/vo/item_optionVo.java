package team.project.vo;

public class item_optionVo {
	private int option_num;
	private int items_num;
	private String item_size;
	item_optionVo(){}
	public item_optionVo(int option_num, int items_num, String item_size) {
		super();
		this.option_num = option_num;
		this.items_num = items_num;
		this.item_size = item_size;
	}
	public int getOption_num() {
		return option_num;
	}
	public void setOption_num(int option_num) {
		this.option_num = option_num;
	}
	public int getItems_num() {
		return items_num;
	}
	public void setItems_num(int items_num) {
		this.items_num = items_num;
	}
	public String getItem_size() {
		return item_size;
	}
	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}
	
}
