package Board;

public class BoardDTO {
		private int 	board_no; 			// 게시판 글번호
		private String 	board_title; 		// 게시판 제목
		private String 	board_author; 		// 게시판 제목
		private String 	board_content; 		// 게시판 내용
		private String 	board_hit; 			// 게시판 조회수
		private String 	board_date; 		// 게시판 작성일
		
		public BoardDTO(int board_no, String board_title,String board_author, String board_content, String board_hit, String board_date) {
			this.board_no	       = board_no;
			this.board_title	   = board_title;
			this.board_author	   = board_author;
			this.board_content     = board_content;
			this.board_hit	       = board_hit;
			this.board_date 	   = board_date;
		}

		public int getBoard_no() {
			return board_no;
		}

		public void setBoard_no(int board_no) {
			this.board_no = board_no;
		}

		public String getBoard_author() {
			return board_author;
		}

		public void setBoard_author(String board_author) {
			this.board_author = board_author;
		}
		
		public String getBoard_title() {
			return board_title;
		}

		public void setBoard_title(String board_title) {
			this.board_title = board_title;
		}

		public String getBoard_content() {
			return board_content;
		}

		public void setBoard_content(String board_content) {
			this.board_content = board_content;
		}

		public String getBoard_hit() {
			return board_hit;
		}

		public void setBoard_hit(String board_hit) {
			this.board_hit = board_hit;
		}

		public String getBoard_date() {
			return board_date;
		}

		public void setBoard_date(String board_date) {
			this.board_date = board_date;
		}



		
		
}


