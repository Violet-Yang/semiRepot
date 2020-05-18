package team.project.vo;

public class pre_categoryVo {
	private int pre_category_num;
	private String name;
	public pre_categoryVo(){}
	public pre_categoryVo(int pre_category_num, String name) {
		super();
		this.pre_category_num = pre_category_num;
		this.name = name;
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
