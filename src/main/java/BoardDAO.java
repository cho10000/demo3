public BoardVO read(int b_no) {
	BoardVO boardVO = new BoardVO();
	    
	    try {
	        con = dbConnect.getCennection();
	        sql = new StringBuffer();
	        sql.append(" SELECT b_no, b_type, b_title, b_content, b_cnt, b_user, b_ymd, b_file");
	        sql.append(" FROM board");
	        sql.append(" WHERE b_no = ?");
	        
	        pstmt = con.prepareStatement(sql.toString());
	        pstmt.setInt(1,  b_no);
	        
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	            boardVO.setB_no(rs.getInt("b_no"));
	            boardVO.setB_type(rs.getString("b_type"));
	            boardVO.setB_title(rs.getString("b_title"));
	            boardVO.setB_content(rs.getString("b_content"));
	            boardVO.setB_cnt(rs.getInt("b_cnt"));
	            boardVO.setB_user(rs.getString("b_user"));
	            boardVO.setB_ymd(rs.getString("b_ymd"));
	            boardVO.setB_file(rs.getString("b_file"));
	        }
	    } catch(SQLException e){
	        e.printStackTrace();
	    } finally {
	        dbDisconnect.disconnect(con, pstmt, rs);
	    }
	    
	    return BoardVO;
}
