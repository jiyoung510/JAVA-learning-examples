package model1.board;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.servlet.ServletContext;
import common.JDBConnect;

public class BoardDAO extends JDBConnect {
	public BoardDAO(ServletContext application) {
		super(application);
	}
	
	// �˻� ���ǿ� �´� �Խù��� ������ ��ȯ
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0; // �ʱⰪ ����
		// �Խù� ���� ������ ������ �ۼ� SELECT COUNT(*) FROM BOARD WHERE searchField LIKE '%searchWord%'
		String query = "SELECT COUNT(*) FROM BOARD ";
		if(map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " " + "LIKE '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement(); // ������ ����
			rs = stmt.executeQuery(query); // ���� ����
			rs.next();
			totalCount = rs.getInt(1); // ù��° �÷� ���� ������
		} catch(Exception e) {
			System.out.println("�Խù� ���� ���ϴ� �� ���� �߻�");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	// �Խù� ��� ��������
	public List<BoardDTO> selectList(Map<String, Object> map){
		List<BoardDTO> bbs = new Vector<BoardDTO>(); // ���(�Խù� ���)�� ���� ����
		
		String query = "SELECT * FROM BOARD ";
		if(map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " " + "LIKE '%" + map.get("searchWord") + "%'";			
		}
		query += " ORDER BY NUM DESC "; // �������� ����
		try {
			stmt = con.createStatement(); // ������ ����
			rs = stmt.executeQuery(query); // ������ ����
			
			while(rs.next()) { // ����� ���������� �ݺ� ���
				// �� ��(�Խù� �ϳ�)�� ������ DTO�� ����
				BoardDTO dto = new BoardDTO(); // dto��ü ����
				
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto); // DTO�� LIST �÷��ǿ� ��´�.
			}
		} catch(Exception e) {
			System.out.println("�Խù� ��ȸ �� ���� �߻�");
			e.printStackTrace(); // ���� �߻� �� �α� ���
		}
		return bbs; // ���� ����� list �÷����� jsp ��ȯ
	}
	
	// ����¡ ó���� �޼���
    public List<BoardDTO> selectListPage(Map<String, Object> map) {
        List<BoardDTO> bbs = new Vector<BoardDTO>();  // ���(�Խù� ���)�� ���� ����
        
        // ������ ���ø�  
        String query = " SELECT * FROM ( "
                     + "    SELECT Tb.*, ROWNUM rNum FROM ( "
                     + "        SELECT * FROM board ";

        // �˻� ���� �߰� 
        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField")
                   + " LIKE '%" + map.get("searchWord") + "%' ";
        }
        
        query += "      ORDER BY num DESC "
               + "     ) Tb "
               + " ) "
               + " WHERE rNum BETWEEN ? AND ?"; 

        try {
            // ������ �ϼ� 
            psmt = con.prepareStatement(query);
            psmt.setString(1, map.get("start").toString());
            psmt.setString(2, map.get("end").toString());
            
            // ������ ���� 
            rs = psmt.executeQuery();
            
            while (rs.next()) {
                // �� ��(�Խù� �ϳ�)�� �����͸� DTO�� ����
                BoardDTO dto = new BoardDTO();
                dto.setNum(rs.getString("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setId(rs.getString("id"));
                dto.setVisitcount(rs.getString("visitcount"));

                // ��ȯ�� ��� ��Ͽ� �Խù� �߰�
                bbs.add(dto);
            }
        } 
        catch (Exception e) {
            System.out.println("�Խù� ��ȸ �� ���� �߻�");
            e.printStackTrace();
        }
        
        // ��� ��ȯ
        return bbs;
    }
	
	// �Խñ� �����͸� �޾� DB�� �߰��մϴ�.
	public int insertWrite(BoardDTO dto){
    	int result = 0;
    	
    	try {
    		//INSERT ������ �ۼ�
    		String query = "INSERT INTO board( "
    					 + " num, title, content, id, visitcount) "
    					 + " VALUES( "
    					 + " seq_board_num.NEXTVAL, ?, ?, ?, 0)";
    		psmt = con.prepareStatement(query); //���� ����
    		psmt.setString(1, dto.getTitle());
    		psmt.setString(2, dto.getContent());
    		psmt.setString(3,  dto.getId());
    		
    		result = psmt.executeUpdate();
    	}
    	catch(Exception e) {
    		System.out.println("�Խù� �Է� �� ���� �߻�");
    		e.printStackTrace();
    	}
    	return result;
    }
	
	// ������ �Խù��� ã�� ������ ��ȯ�ϴ� �޼���
	public BoardDTO selectView(String num) {
		BoardDTO dto = new BoardDTO();
		
		// ���� ����
		String query = "SELECT B.*, M.name " // board ���̺��� ��� �÷���, member ���̺��� name �÷��� ����
				+ " FROM member M INNER JOIN board B " // member�� M����, board�� B�� ��Ī ���
				+ " ON M.id=B.id "
				+ " WHERE num=?";
		// board ���̺��� �ۼ����� ���̵� ����ȴ�.
		// �̸��� ����ϱ� ���ؼ� member ���̺���� ������ �ʿ��ϴ�.
		// board ���̺��� ��� �÷��� member ���̺��� name �÷��� �����´�.
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num); // ���Ķ���͸� �Ϸù�ȣ�� ����
			rs = psmt.executeQuery(); // �������� �����Ͽ� rs�� ����
			
			if(rs.next()) { // ResultSet ��ü�� ��ȯ�� ���� next() Ȯ��
				dto.setNum(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString(6));
				dto.setName(rs.getString("name"));
			}
		} catch(Exception e) {
			System.out.println("�Խù� �󼼺��� ���� �߻�");
			e.printStackTrace();
		}
		return dto;
	}
	
	// ��ȸ�� ���� �޼���
	public void updateVisitCount(String num) {
		String query = "UPDATE board SET "
				+ " visitcount = visitcount+1 "
				+ " WHERE num=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num); // ���Ķ���͸� �Ϸù�ȣ�� ����
			rs = psmt.executeQuery(); // �������� �����Ͽ� rs�� ����
		} catch(Exception e) {
			System.out.println("�Խù� ��ȸ�� ���� ���� �߻�");
			e.printStackTrace();
		}
	}
	
	// �Խñ� �����ϱ� �޼��� 
	public int updateEdit(BoardDTO dto) { // �Խù� ������
		int result = 0;
		
		try { // ������ �ۼ�
			String query = "UPDATE board SET "
					+ " title=?, content=? "
					+ " WHERE num=? ";
			
			// ������ �ϼ� -> ���Ķ���� ����
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());
			
			// ������ ����
			result = psmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("�Խù� ���� �� ���� �߻�");
			e.printStackTrace();
		}
		
		return result;
	}
	
	// �Խù� �����ϱ� �޼���
		public int deletePost(BoardDTO dto) { // �Խù� ������
			int result = 0;
			
			try {
				// ������ ���ø�
				String query = "DELETE FROM board WHERE num=? ";
				
				// ������ �ϼ�
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getNum());
				
				// ������ ����
				result = psmt.executeUpdate();
			} catch(Exception e) {
				System.out.println("�Խù� ���� �� ���� �߻�");
				e.printStackTrace();
			}
			
			return result;
		}
}
