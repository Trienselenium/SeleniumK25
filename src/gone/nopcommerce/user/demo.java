package gone.nopcommerce.user;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class demo {

    public static void main(String[] args) {
		//
		int number = 10;

		try {
			// Đúng: Chạy hết đoạn code trong Try/ ko qua Catch
			// Sai: Gặp Exception - Nhảy qua Catch
			number = number / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(number);

		//
		String[] browserName = { "Chrome", "Firefox", "Safari" };
		try {
			browserName[0] = "Edge Chromium";
			browserName[3] = "Edge Legacy";
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String browser : browserName) {
			System.out.println(browser);
		}

		// Multi catch
		try {
			int array[] = new int[10];
			array[10] = 30 / 1;
		} catch (ArithmeticException e) {
			System.out.println("Ko thể chia cho 0");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index vượt ngoài độ dài của mảng");
		}

		//
		FileOutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream("C:\\Users\\DoDangTrien\\Desktop\\Training\\automation.txt");
			outputStream.write(65);
			System.out.println("1");
		} catch (FileNotFoundException e) {
			System.out.println("aaaa 2");
			System.out.println(e.getMessage());
			
		} catch (IOException e) {
			System.out.println("3");
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void sleepInSecond(long timeOut) throws InterruptedException {
		Thread.sleep(timeOut * 1000);
	}

}
