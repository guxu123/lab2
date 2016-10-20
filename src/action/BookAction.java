package action;

import java.util.ArrayList;
import java.util.List;

import service.BookDAO;

import service.impl.BookDaoimpl;


import com.opensymphony.xwork2.ModelDriven;

import entity.author;
import entity.book;



public class BookAction extends SuperAction implements ModelDriven<book> {
	private book book = new book();
	public book getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	private static final long serialVersionUID = 1L;

	private book students=new book();
	
	public String query(){
		BookDAO sDao=new BookDaoimpl();
		List<book> list=sDao.querryAllBook();
		
		if(list.size()>0){
			session.setAttribute("allBook_list", list);
			return "querryAllBook_success";
		}else{
			return "querryAllBook_failure";
		}
	}
	public String delete(){
		BookDAO sDao=new BookDaoimpl();
		String sid=request.getParameter("ISBN");
		int i;
		i=new Integer(sid);
		
		sDao.delBookBySid(i);
		
		return "deleteBook_success";
	}
	//根据作者姓名查询图书
	public String bookinfo(){
		
		BookDAO bdao =new BookDaoimpl();
		String Aname = request.getParameter("Aname");
		author au =null;
		au = bdao.queryAuthorByName(Aname);
		if(au == null){
			return "query_failer";
		}
		
		List<book> list = bdao.queryBookByAuthorID(au.getAuthorID());
		if(list.size()>0){
			session.setAttribute("AuthorBook_list", list);
			return "query_success";
		}
		else{
			return "query_failer";
		}
		
	}
	public String bookandauthor(){
		BookDAO sDao=new BookDaoimpl();
		String sid=request.getParameter("ISBN1");
		int i;
		List<book> list1 = new ArrayList<book>();
		List<author> list2 = new ArrayList<author>();
		i=new Integer(sid);
		book b = sDao.queryBookByID(i);
		author au = sDao.querryAuthorByID(b.getAuthorID());
		list1.add(b);
		list2.add(au);
		session.setAttribute("Book_list", list1);
		session.setAttribute("Author_list", list2);
		return "information_success";
	}
	
	
	public String modify(){
		BookDAO sDao=new BookDaoimpl();
		String sid = request.getParameter("ISBN2");
		int i;
		i=new Integer(sid);
		book b = sDao.queryBookByID(i);
		session.setAttribute("modify_Book", b);
		return "modify_success";
	}
	public String save(){
		book b = new book();
		b.setAuthorID(new Integer(request.getParameter("AuthorID")));
		b.setISBN(new Integer(request.getParameter("ISBN")));
		b.setPrice(new Integer(request.getParameter("Price")));
		b.setPublishDate(request.getParameter("PublishDate"));
		b.setPublisher(request.getParameter("Publisher"));
		b.setTitle(request.getParameter("Title"));
		BookDAO sDao=new BookDaoimpl();
		sDao.updateBook(b);
		int i = b.getAuthorID();
		boolean boo = sDao.Author_is_in(i);
		
		
		if(boo == true){
			return "save_success1";
		}else
		{
			return "save_success2";
		}
		
	}
	public String add(){
		book b = new book();
		b.setAuthorID(new Integer(request.getParameter("AuthorID")));
		b.setISBN(new Integer(request.getParameter("ISBN")));
		b.setPrice(new Integer(request.getParameter("Price")));
		b.setPublishDate(request.getParameter("PublishDate"));
		b.setPublisher(request.getParameter("Publisher"));
		b.setTitle(request.getParameter("Title"));
		BookDAO sDao=new BookDaoimpl();
		sDao.addBook(b);
		int i = b.getAuthorID();
		boolean boo = sDao.Author_is_in(i);
		
		
		if(boo == true){
			return "add_success1";
		}else
		{
			return "add_success2";
		}
		
	}
	public String addAuthor(){
		author au = new author();
		au.setAge(new Integer(request.getParameter("Age")));
		au.setAuthorID(new Integer(request.getParameter("AuthorID")));
		au.setCountry(request.getParameter("Country"));
		au.setName(request.getParameter("Name"));
		BookDAO b = new BookDaoimpl();
		b.addAuthor(au);
		return "addAuthor_success";
	}

}
