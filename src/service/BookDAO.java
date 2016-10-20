package service;

import java.util.List;

import entity.author;
import entity.book;


public interface BookDAO {
public List<book> querryAllBook();
	
	public List<book> queryBookByAuthorID(int AuthorID);
	public author querryAuthorByID(int sid);
	public author queryAuthorByName(String Name);
	public boolean delBookBySid(int sid);

	public boolean addBook(book student);
	public boolean addAuthor(author author);
	public boolean updateBook(book student);
	public book queryBookByID(int id);
	public boolean Author_is_in(int AuthorID);
	
	
}
