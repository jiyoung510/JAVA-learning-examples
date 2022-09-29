package membership;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
	// ����� �����ͺ��̽����� ������ �Ϸ�� MemberDAO ��ü�� �����Ѵ�.
	public MemberDAO(ServletContext application) {
		super(application);
	}
	
	// ����� ���̵�/�н������ ��ġ�ϴ� ȸ�� ������ ��ȯ�Ѵ�.
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO(); // ȸ�� ���� DTO ��ü ����
		String query = "SELECT * FROM member WHERE id=? AND pass=?"; // ������ ���ø�
		
		try {
			// ���� ����
			psmt = con.prepareStatement(query); // ���� ������ �غ�
			psmt.setString(1, uid); // �������� ù��° ���Ķ���Ϳ� �� ����
			psmt.setString(2, upass); // �������� �ι�° ���Ķ���Ϳ� �� ����
			rs = psmt.executeQuery(); // ������ ����
			
			// ��� ó��
			if(rs.next()) {
				// ���� ����� ���� ȸ�� ������ DTO ��ü�� ����
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString(4));
				dto.setBirth(rs.getString("birth"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto; // DTO ��ü ��ȯ
	}
	
	// ȸ�������� ȸ�� �߰� �޼���
	public int insertMember(MemberDTO dto){
    	int result = 0;
    	
    	try {
    		//INSERT ������ �ۼ�
    		String query = "INSERT INTO member( "
    					 + " id, name, pass, regidate, birth, addr, email) "
    					 + " VALUES( "
    					 + " ?, ?, ?, sysdate, ?, ?, ?)";
    		psmt = con.prepareStatement(query); //���� ����
    		psmt.setString(1, dto.getId());
    		psmt.setString(2, dto.getName());
    		psmt.setString(3,  dto.getPass());
    		psmt.setString(4,  dto.getBirth());
    		psmt.setString(5, dto.getAddr());
    		psmt.setString(6, dto.getEmail());
    		
    		result = psmt.executeUpdate();
    	}
    	catch(Exception e) {
    		System.out.println("ȸ������ �Է� �� ���� �߻�");
    		e.printStackTrace();
    	}
    	return result;
    }
	
	public int memberCount() {
		int totalCount = 0; // �ʱⰪ ����
		String query = "SELECT COUNT(*) FROM MEMBER ";
		try {
			stmt = con.createStatement(); // ������ ����
			rs = stmt.executeQuery(query); // ���� ����
			rs.next();
			totalCount = rs.getInt(1); // ù��° �÷� ���� ������
		} catch(Exception e) {
			System.out.println("ȸ��  ���� ���ϴ� �� ���� �߻�");
			e.printStackTrace();
		}
		return totalCount; // 5
	}
	
	// �Խù� ��� ��������
	public List<MemberDTO> selectMemberList(){
		List<MemberDTO> bbs = new Vector<MemberDTO>(); // ���(�Խù� ���)�� ���� ����
		
		String query = "SELECT * FROM MEMBER ";
		query += " ORDER BY REGIDATE "; // �������� ����
		try {
			stmt = con.createStatement(); // ������ ����
			rs = stmt.executeQuery(query); // ������ ����
			
			while(rs.next()) { // ����� ���������� �ݺ� ���
				// �� ��(�Խù� �ϳ�)�� ������ DTO�� ����
				MemberDTO dto = new MemberDTO(); // dto��ü ����
				
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setRegidate(rs.getString("regidate"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				
				bbs.add(dto); // DTO�� LIST �÷��ǿ� ��´�.
			}
		} catch(Exception e) {
			System.out.println("ȸ��  ��ȸ �� ���� �߻�");
			e.printStackTrace(); // ���� �߻� �� �α� ���
		}
		return bbs; // ���� ����� list �÷����� jsp ��ȯ
	}
	
	public MemberDTO memberView(String id) {
		MemberDTO dto = new MemberDTO();
		
		// ���� ����
		String query = "SELECT * FROM MEMBER " 
				+ " WHERE id=? ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id); 
			rs = psmt.executeQuery(); 
			
			if(rs.next()) { // ResultSet ��ü�� ��ȯ�� ���� next() Ȯ��
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
				dto.setBirth(rs.getString("birth"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				
			}
		} catch(Exception e) {
			System.out.println("member �󼼺��� ���� �߻�");
			e.printStackTrace();
		}
		return dto;
	}
	
	public int deleteMember(MemberDTO dto) {
		int result = 0;
		
		try {
			// ������ ���ø�
			String query = "DELETE FROM member WHERE id=? ";
			
			// ������ �ϼ�
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			
			// ������ ����
			result = psmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("ȸ�� ���� �� ���� �߻�");
			e.printStackTrace();
		}
		
		return result;
	}
	
		public int updateMemberEdit(MemberDTO dto) { 
			int result = 0;
			
			try { // ������ �ۼ�
				String query = "UPDATE member SET "
						+ " pass=?, name=?, birth=?, addr=?, email=? "
						+ " WHERE id=? ";
				
				// ������ �ϼ� -> ���Ķ���� ����
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getPass());
				psmt.setString(2, dto.getName());
				psmt.setString(3, dto.getBirth());
				psmt.setString(4, dto.getAddr());
				psmt.setString(5, dto.getEmail());
				psmt.setString(6, dto.getId());
				
				// ������ ����
				result = psmt.executeUpdate();
			} catch(Exception e) {
				System.out.println("member ���� �� ���� �߻�");
				e.printStackTrace();
			}
			
			return result;
		}
}
