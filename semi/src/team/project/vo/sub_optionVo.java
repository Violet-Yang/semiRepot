package team.project.vo;

public class sub_optionVo {
	private int sub_option_num;
	private int option_num;
	private String color;
	private int count;
	public sub_optionVo() {}
	public sub_optionVo(int sub_option_num, int option_num, String color, int count) {
		super();
		this.sub_option_num = sub_option_num;
		this.option_num = option_num;
		this.color = color;
		this.count = count;
	}
	public int getSub_option_num() {
		return sub_option_num;
	}
	public void setSub_option_num(int sub_option_num) {
		this.sub_option_num = sub_option_num;
	}
	public int getOption_num() {
		return option_num;
	}
	public void setOption_num(int option_num) {
		this.option_num = option_num;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
