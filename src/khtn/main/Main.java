package khtn.main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import khtn.Utils.DongAUtils;
import khtn.models.Item;

public class Main {
	static String path = "http://dongabank.com.vn/exchange/export";
	public static void main(String[] args) {
		Item[] item = downloadJSON();
		showThongTin(item);
		timKiem(item);
	}
	public static Item[] downloadJSON(){
		try {
			Item[] item;
			String ret = DongAUtils.getJSON(path);
			ret = ret.replace("(", "");ret = ret.replace(")", "");
			item = DongAUtils.parseToItem(ret);
			return item;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Không tìm thấy dữ liệu từ '"+e.getMessage()+"' hoặc không có internet");
		} return null;
	}
	public static void showThongTin(Item[] item) {
		if(item!=null){
			System.out.println("=================================================================================================");
			System.out.println("Loại			Đường dẫn của hình		     	Mua TM	Mua CK	Bán TM	Bán CK");
			System.out.println("----	---------------------------------------------------     ------- ------- ------- -------");
			for (Item item2 : item) {
				System.out.println(item2.toString());
			}System.out.println("================================================================================================");
		}
	}
	public static void timKiem(Item[] item) {
		if(item!=null){
			Scanner sc = new Scanner(System.in);
			String muc;
			do{	System.out.print("Nhập loại mục: muaTM(1), muaCK(2), bánTM(3), bánCK(4): ");
			muc = sc.nextLine();
			System.out.print("Nhập loại ngoại tệ muốn xem: ");
			String loai = sc.nextLine().toUpperCase();
			for (Item item2 : item) {
				if(item2.getType().contains(loai)){ 
					switch (muc) {
						case "1":System.out.println("Mua bằng tiền mặt: "+item2.getMuatienmat());break;
						case "2":System.out.println("Mua bằng chuyển khoản: "+item2.getMuack());break;
						case "3":System.out.println("Bán bằng tiền mặt: "+item2.getBantienmat());break;
						case "4":System.out.println("Bán bằng chuyển khoản: "+item2.getBanck());break;
						default:break;
					}					
				}
			}
			System.out.print("Tìm tiếp không? (y/n): ");
			muc = sc.nextLine();
			}while(muc.equals("Y")||muc.equals("y"));
			sc.close();
		}
	}
}
