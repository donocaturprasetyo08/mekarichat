package webautomation.mekarichat.utils;

import java.io.File;

public class DataUtils {
	public static final String titlePageLogin = "Mekari Account";
	public static final String emailMekari = "donocatur@qiscus.cx";
	public static final String passwordMekari = "tanpapassword08";
	public static final String urlDashboard = "https://messenger.mekari.com/dashboard";
	public static final String fotoProfile = foto();
	
	public static final String titleSearchTabs = "Search Chat";
	public static final String titleChatTabs = "Chats";
	public static final String titleChannelTabs = "Channels";
	public static final String titleAccountTabs = "Account";
	public static final String titleContactTabs = "Contacts";
	
	static String foto() {
		return new File("/Users/donocaturprasetyo/Pictures/testUpload.png").getAbsolutePath();
	}
	
	
	
}
