package webautomation.mekarichat.utils;

import java.util.Arrays;
import java.util.List;

public class TestData {
	public static final String titlePageLogin = "Mekari Account";
	public static final String emailMekari = "emailMekari";
	public static final String passwordMekari = "passwordMekari";
	
	public static final String urlDashboard = "https://messenger.mekari.com/dashboard";
	public static final String fotoProfile = "/Users/donocaturprasetyo/Pictures/testUpload.png";
	public static final String fotoProfileOri = "/Users/donocaturprasetyo/Pictures/hello12.jpg";
	public static final String locationVideo = "/Users/donocaturprasetyo/Pictures/mp4-1mb.mp4";
	public static final List<String> fileDoc = Arrays.asList("/Users/donocaturprasetyo/Desktop/sample_testing/doc/doc-sample.doc", 
			"/Users/donocaturprasetyo/Desktop/sample_testing/doc/docx-sample.docx", 
			"/Users/donocaturprasetyo/Desktop/sample_testing/doc/odp-sample.odp",
			"/Users/donocaturprasetyo/Desktop/sample_testing/doc/ods-sample.ods",
			"/Users/donocaturprasetyo/Desktop/sample_testing/doc/odt-sample.odt",
			"/Users/donocaturprasetyo/Desktop/sample_testing/doc/ppt-sample.ppt",
			"/Users/donocaturprasetyo/Desktop/sample_testing/doc/pptx-sample.pptx",
			"/Users/donocaturprasetyo/Desktop/sample_testing/doc/xls-sample.xls",
			"/Users/donocaturprasetyo/Desktop/sample_testing/doc/xlsx-sample.xlsx");
	public static final List<String> fileVideo = Arrays.asList("/Users/donocaturprasetyo/Desktop/sample_testing/video/mp4-1mb.mp4", 
			"/Users/donocaturprasetyo/Desktop/sample_testing/video/mov-2mb.mov");
	public static final String titleSearchTabs = "Search Chat";
	public static final String titleChatTabs = "Chats";
	public static final String titleChannelTabs = "Channels";
	public static final String titleAccountTabs = "Account";
	public static final String titleContactTabs = "Contacts";
	
	public static final String sendMessage = "Hello Test "+randomAngka();
	public static final String emoji = "monkey";
	
	public static final String nameChannel = "test";
	public static final String channelType = "Private channel";
	public static final String channelTypes = "Private Channel";
	public static final String whoInvite = "Admin";
	public static final String changeNameChannel = "group test";
	public static final String changeChannelType = "Public channel";
	public static final String changeChannelTypes = "Public Channel";
	public static final String changeWhoInvite = "Everyone";
	public static final String changePurpose = "hello world 2022";
	
	public static String randomAngka() {
		int i = ((int)(Math.random()*9000)+1000);
		String s=Integer.toString(i);
		return s;
	}
}
