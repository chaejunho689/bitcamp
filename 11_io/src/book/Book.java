package book;

import java.io.IOException;
import java.util.ArrayList;

public interface Book {
	public void execute(ArrayList<BookDTO> list) throws IOException, ClassNotFoundException;
}
