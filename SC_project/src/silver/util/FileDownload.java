package silver.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받기
		String dir = request.getParameter("dir");
		String fname = request.getParameter("filename");
		
		String path = 
			getServletContext().getRealPath(dir);
		
		String serverFullPath =
		  path+System.getProperty("file.separator")+
		  fname;
		
		File file = new File(serverFullPath);
		
		byte[] buf = new byte[2048];
		
		//전송 데이터가 stream처리될 때 문자셋 지정
		response.setContentType(
		  "application/octet-stream;charset=8859_1;");
		
		//다운로드 대화상자 처리
		response.setHeader("Content-Disposition",
		  "attachment;filename=\""+
		  new String(fname.getBytes(),"ISO8859_1")+
		  "\";");
		
		//전송타입이 이진파일(binary)
		response.setHeader("Content-Transfer-Encoding",
			"binary");
		
		if(file.isFile()){
			BufferedInputStream bis = 
				new BufferedInputStream(
					new FileInputStream(file));
			
			// 요청한 곳으로 보내기 위한
			// 스트림은 response를 통해서 얻어낸다.
			BufferedOutputStream bos =
				new BufferedOutputStream(
					response.getOutputStream());
			
			int size = -1;
			try {
				while((size = bis.read(buf)) != -1){
					bos.write(buf, 0, size);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				if(bos != null)
					bos.close();
				if(bis != null)
					bis.close();
			}
		}
		
	}

	

}







