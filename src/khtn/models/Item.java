package khtn.models;

public class Item {
	private String type;
	private String imageurl;
	private String muatienmat;
	private String muack;
	private String bantienmat;
	private String banck;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getMuatienmat() {
		return muatienmat;
	}
	public void setMuatienmat(String muatienmat) {
		this.muatienmat = muatienmat;
	}
	public String getMuack() {
		return muack;
	}
	public void setMuack(String muack) {
		this.muack = muack;
	}
	public String getBantienmat() {
		return bantienmat;
	}
	public void setBantienmat(String bantienmat) {
		this.bantienmat = bantienmat;
	}
	public String getBanck() {
		return banck;
	}
	public void setBanck(String banck) {
		this.banck = banck;
	}
	public Item(String type, String imageurl,
			String muatienmat, String muack,
			String bantienmat, String banck) {
		super();
		this.type = type;
		this.imageurl = imageurl;
		this.muatienmat = muatienmat;
		this.muack = muack;
		this.bantienmat = bantienmat;
		this.banck = banck;
	}
	@Override
	public String toString() {
		return type + "	"
				+ imageurl + " 	" + muatienmat
				+ "	" + muack + "	"
				+ bantienmat + "	" + banck;
	}
	
}
