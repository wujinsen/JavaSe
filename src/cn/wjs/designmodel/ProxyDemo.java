package cn.wjs.designmodel;

public class ProxyDemo {
	public static void main(String[] args) {
		RentHouse rent = new RentCompany();
		rent.house("小心黑ZhongJie");
		rent.house("租房贵");
	}
}

interface RentHouse {// 租房
	public void house(String url);
}
//真是租房
class RealRent implements RentHouse {
	public void house(String url) {
		System.out.println("北京:" + url);
	}
}
//中介公司
class RentCompany implements RentHouse {
	private RentHouse r;// 保存真正租房操作

	public RentCompany() {// 关系在编译时确定
		this.r = new RealRent();//真实类
	}

	public boolean check(String url) {
		if (url.contains("黑ZhongJie")) {
			System.out.println("不能租房");
			return false;
		}
		return true;
	}

	public void house(String url) {
		if (this.check(url)) {// 通过检查了
			this.r.house(url);// 真实操作
		}
	}
}