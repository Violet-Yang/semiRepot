package team.project.vo;

public class itemDetailVo {
	private String name;
	private int price;
	private String info;
	private String mainSaveImg;
	private String subSaveImg;
	private String item_size;
	private String color;
	private int count;
	public itemDetailVo() {}
	public itemDetailVo(String name, int price, String info, String mainSaveImg, String subSaveImg, String item_size,
			String color, int count) {
		super();
		this.name = name;
		this.price = price;
		this.info = info;
		this.mainSaveImg = mainSaveImg;
		this.subSaveImg = subSaveImg;
		this.item_size = item_size;
		this.color = color;
		this.count = count;
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
	public String getMainSaveImg() {
		return mainSaveImg;
	}
	public void setMainSaveImg(String mainSaveImg) {
		this.mainSaveImg = mainSaveImg;
	}
	public String getSubSaveImg() {
		return subSaveImg;
	}
	public void setSubSaveImg(String subSaveImg) {
		this.subSaveImg = subSaveImg;
	}
	public String getItem_size() {
		return item_size;
	}
	public void setItem_size(String item_size) {
		this.item_size = item_size;
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
