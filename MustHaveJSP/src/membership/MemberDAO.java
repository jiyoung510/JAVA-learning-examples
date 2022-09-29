package membership;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
	// 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성한다.
	public MemberDAO(ServletContext application) {
		super(application);
	}
	
	// 명시한 아이디/패스워드와 일치하는 회원 정보를 반환한다.
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO(); // 회원 정보 DTO 객체 생성
		String query = "SELECT * FROM member WHERE id=? AND pass=?"; // 쿼리문 템플릿
		
		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setString(1, uid); // 쿼리문의 첫번째 인파라미터에 값 설정
			psmt.setString(2, upass); // 쿼리문의 두번째 인파라미터에 값 설정
			rs = psmt.executeQuery(); // 쿼리문 실행
			
			// 결과 처리
			if(rs.next()) {
				// 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
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
		return dto; // DTO 객체 반환
	}
	
	// 회원가입한 회원 추가 메서드
	public int insertMember(MemberDTO dto){
    	int result = 0;
    	
    	try {
    		//INSERT 쿼리문 작성
    		String query = "INSERT INTO member( "
    					 + " id, name, pass, regidate, birth, addr, email) "
    					 + " VALUES( "
    					 + " ?, ?, ?, sysdate, ?, ?, ?)";
    		psmt = con.prepareStatement(query); //동적 쿼리
    		psmt.setString(1, dto.getId());
    		psmt.setString(2, dto.getName());
    		psmt.setString(3,  dto.getPass());
    		psmt.setString(4,  dto.getBirth());
    		psmt.setString(5, dto.getAddr());
    		psmt.setString(6, dto.getEmail());
    		
    		result = psmt.executeUpdate();
    	}
    	catch(Exception e) {
    		System.out.println("회원가입 입력 중 예외 발생");
    		e.printStackTrace();
    	}
    	return result;
    }
	
	public int memberCount() {
		int totalCount = 0; // 초기값 설정
		String query = "SELECT COUNT(*) FROM MEMBER ";
		try {
			stmt = con.createStatement(); // 쿼리문 생성
			rs = stmt.executeQuery(query); // 쿼리 실행
			rs.next();
			totalCount = rs.getInt(1); // 첫번째 컬럼 값을 가져옴
		} catch(Exception e) {
			System.out.println("회원  수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount; // 5
	}
	
	// 게시물 목록 가져오기
	public List<MemberDTO> selectMemberList(){
		List<MemberDTO> bbs = new Vector<MemberDTO>(); // 결과(게시물 목록)를 담을 변수
		
		String query = "SELECT * FROM MEMBER ";
		query += " ORDER BY REGIDATE "; // 내림차순 정렬
		try {
			stmt = con.createStatement(); // 쿼리문 생성
			rs = stmt.executeQuery(query); // 쿼리문 실행
			
			while(rs.next()) { // 결과를 순차적으로 반복 출력
				// 한 행(게시물 하나)의 내용을 DTO로 보냄
				MemberDTO dto = new MemberDTO(); // dto객체 생성
				
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				dto.setRegidate(rs.getString("regidate"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				
				bbs.add(dto); // DTO를 LIST 컬렉션에 담는다.
			}
		} catch(Exception e) {
			System.out.println("회원  조회 중 예외 발생");
			e.printStackTrace(); // 예외 발생 시 로그 출력
		}
		return bbs; // 쿼리 결과를 list 컬렉션을 jsp 반환
	}
	
	public MemberDTO memberView(String id) {
		MemberDTO dto = new MemberDTO();
		
		// 쿼리 생성
		String query = "SELECT * FROM MEMBER " 
				+ " WHERE id=? ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id); 
			rs = psmt.executeQuery(); 
			
			if(rs.next()) { // ResultSet 객체로 반환된 행을 next() 확인
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
				dto.setBirth(rs.getString("birth"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				
			}
		} catch(Exception e) {
			System.out.println("member 상세보기 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}
	
	public int deleteMember(MemberDTO dto) {
		int result = 0;
		
		try {
			// 쿼리문 템플릿
			String query = "DELETE FROM member WHERE id=? ";
			
			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			
			// 쿼리문 실행
			result = psmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("회원 삭제 중 예외 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	
		public int updateMemberEdit(MemberDTO dto) { 
			int result = 0;
			
			try { // 쿼리문 작성
				String query = "UPDATE member SET "
						+ " pass=?, name=?, birth=?, addr=?, email=? "
						+ " WHERE id=? ";
				
				// 쿼리문 완성 -> 인파라미터 제공
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getPass());
				psmt.setString(2, dto.getName());
				psmt.setString(3, dto.getBirth());
				psmt.setString(4, dto.getAddr());
				psmt.setString(5, dto.getEmail());
				psmt.setString(6, dto.getId());
				
				// 쿼리문 실행
				result = psmt.executeUpdate();
			} catch(Exception e) {
				System.out.println("member 수정 중 예외 발생");
				e.printStackTrace();
			}
			
			return result;
		}
}
