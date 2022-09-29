package fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class FileUtil {
	// ���� ���ε�(multipart / form-data ��û) ó��
	public static MultipartRequest UploadFile(HttpServletRequest req, String saveDirectory, int maxPostSize) {
		try {
			// ���ε� ����
			return new MultipartRequest(req, saveDirectory, maxPostSize, "UTF-8");
		} catch(Exception e) {
			// ���ε� ����
			e.printStackTrace();
			return null;
		}
	}
	
	// ���� �ٿ�ε� ó��
		public static void download(HttpServletRequest req, HttpServletResponse resp, String directory, String sfileName, String ofileName) {
			String sDirectory = req.getServletContext().getRealPath(directory);
			try {
				//������ ã�� �Է� ��Ʈ�� ����
				File file = new File(sDirectory, sfileName);
				InputStream iStream = new FileInputStream(file);
				
				//�ѱ� ���ϸ� ���� ����
				String client = req.getHeader("User-Agent");
				if(client.indexOf("WOW64") == -1) {
					ofileName = new String(ofileName.getBytes("UTF-8"), "ISO-8859-1");
				}
				else {
					ofileName = new String(ofileName.getBytes("KSC5601"), "ISO-8859-1");
				}
				
				//���� �ٿ�ε�� ���� ��� ����
				resp.reset();
				resp.setContentType("application/octet-stream");
				resp.setHeader("Content-Disposition", "attachment; filename=\"" + ofileName + "\"");
				resp.setHeader("Content-Length", "" + file.length());
				
				//out.clear(); //��� ��Ʈ�� �ʱ�ȭ
				
				//response ���� ��ü�κ��� ���ο� ��� ��Ʈ�� ����
				OutputStream oStream = resp.getOutputStream();
				
				//��� ��Ʈ���� ���� ���� ���
				byte b[] = new byte[(int)file.length()];
				int readBuffer = 0;
				while((readBuffer = iStream.read(b)) > 0) {
					oStream.write(b, 0, readBuffer);
				}
				
				//��/��� ��Ʈ�� ����
				iStream.close();
				oStream.close();
			}
			catch(FileNotFoundException e){
				System.out.println("������ ã�� �� �����ϴ�.");
				e.printStackTrace();
				
			}
			catch(Exception e) {
				System.out.println("���ܰ� �߻��Ͽ����ϴ�.");
				e.printStackTrace();
			}
		}
		
		// ������ ��ġ�� ������ �����մϴ�.
		public static void deleteFile(HttpServletRequest req, String directory, String filename) {
			String sDirectory = req.getServletContext().getRealPath(directory);
			File file = new File(sDirectory + File.separator + filename);
			if(file.exists()) {
				file.delete();
			}
		}
}