package cn.wjs;


/**
 * @author 吴锦森 
 * @version 创建时间：2015年5月3日
 * 类说明
 */
@SuppressWarnings("serial")
public class VisitPersonPage implements java.io.Serializable{
	private String user_id;
	private String name;
	private String sex;
	private String birthday;
	private String certificate_type;
	private String certificate_type_number;
	private String cellphone;
	private String social_security_cards;
	private String address;
	
	
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCertificate_type() {
		return certificate_type;
	}
	public void setCertificate_type(String certificate_type) {
		this.certificate_type = certificate_type;
	}
	public String getCertificate_type_number() {
		return certificate_type_number;
	}
	public void setCertificate_type_number(String certificate_type_number) {
		this.certificate_type_number = certificate_type_number;
	}
	public String getSocial_security_cards() {
		return social_security_cards;
	}
	public void setSocial_security_cards(String social_security_cards) {
		this.social_security_cards = social_security_cards;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "VisitPerson [user_id=" + user_id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", certificate_type=" + certificate_type + ", certificate_type_number=" + certificate_type_number + ", social_security_cards=" + social_security_cards + ", address=" + address + "]";
	}
	
}
