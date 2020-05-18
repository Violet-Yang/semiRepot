package team.project.vo;

public class main_categoryVo {
	private int main_category_num;
	private int pre_category_num;
	private String name;
	public main_categoryVo(){}
	public main_categoryVo(int main_category_num, int pre_category_num, String name) {
		super();
		this.main_category_num = main_category_num;
		this.pre_category_num = pre_category_num;
		this.name = name;
	}
	public int getMain_category_num() {
		return main_category_num;
	}
	public void setMain_category_num(int main_category_num) {
		this.main_category_num = main_category_num;
	}
	public int getPre_category_num() {
		return pre_category_num;
	}
	public void setPre_category_num(int pre_category_num) {
		this.pre_category_num = pre_category_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
