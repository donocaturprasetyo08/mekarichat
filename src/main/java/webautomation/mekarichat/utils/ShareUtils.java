package webautomation.mekarichat.utils;

public class ShareUtils {
	public static void hardWait(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
