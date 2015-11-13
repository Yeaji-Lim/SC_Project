package silver.util;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;

public class FileSaveUtil {

	public static String checkSameFileName(
		String filename, String path)throws Exception{
		
		int period = filename.lastIndexOf(".");
		String f_name = filename.substring(0,period);
		String suffix = filename.substring(period); //.txt
		
		String saveFileName = path + 
			System.getProperty("file.separator")+
			filename;
			
		// 저장될 파일명과 동일한 이름이 있는지를 
		// 확인한 후 있다면 새로운 이름으로 저장하자
		File dest = new File(saveFileName);
		int idx = 1;
		while(dest != null && dest.exists()){
			// 동일한 이름이 있는 경우! 새로운 이름을
			// 만들어 반복적으로 체크해야 한다.
			// 년,월,일,시,분,초 의 값으로 파일명을
			// 만들자!
//			Calendar cal = Calendar.getInstance();
//			
//			int yy = cal.get(Calendar.YEAR);
//			int mm = cal.get(Calendar.MONTH)+1;//1월의 값이 0이다.
//			int dd = cal.get(Calendar.DATE);
//			int h = cal.get(Calendar.HOUR);
//			int m = cal.get(Calendar.MINUTE);
//			int s = cal.get(Calendar.SECOND);
//			
//			String strTime = String.format(
//				"%d%02d%02d%02d%02d%02d",
//				yy,mm,dd,h,m,s);
//			
//			filename = strTime+"_"+filename;
			
			
			//순수한 파일명 뒤에 준비된 숫자를 붙인다.
			//filename = f_name + String.valueOf(idx++)+suffix;
			StringBuffer sbuf = new StringBuffer();
			sbuf.append(f_name);//원래 파일명 : test
			sbuf.append(idx++);//숫자 : test1
			sbuf.append(suffix); //확장자 : test1.txt
			
			filename = sbuf.toString();// test1.txt
			
			saveFileName = path + 
				System.getProperty("file.separator")+
				filename;
			
			dest = new File(saveFileName);
		}
		
		return filename;
	}
	
	//파일을 업로드 하는 메서드
	public static String saveFile(File src, 
		String filename, String path)throws Exception{
		
		String saveFileName = path + 
				System.getProperty("file.separator")+
				filename;
		
		File dest = new File(saveFileName);
		
		while(dest.exists()){
Calendar cal = Calendar.getInstance();
			
			int yy = cal.get(Calendar.YEAR);
			int mm = cal.get(Calendar.MONTH)+1;//1월의 값이 0이다.
			int dd = cal.get(Calendar.DATE);
			int h = cal.get(Calendar.HOUR);
			int m = cal.get(Calendar.MINUTE);
			int s = cal.get(Calendar.SECOND);
			
			String strTime = String.format(
				"%d%02d%02d%02d%02d%02d",
				yy,mm,dd,h,m,s);
			
			filename = strTime+"_"+filename;
			
			saveFileName = path + 
				System.getProperty("file.separator")+
				filename;
			
			dest = new File(saveFileName);
		}
		
		//임시 파일을 저장하는 클래스를 활용한다.
		FileUtils.copyFile(src, dest);
		
		return filename;
	}
}







