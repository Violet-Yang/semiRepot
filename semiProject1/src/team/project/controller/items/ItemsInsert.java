package team.project.controller.items;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import team.project.dao.itemsDao;
import team.project.dao.items_imgDao;
import team.project.dao.items_optionDao;
import team.project.dao.main_categoryDao;
import team.project.dao.sub_optionDao;
import team.project.vo.item_optionVo;
import team.project.vo.itemsVo;
import team.project.vo.items_imgVo;
import team.project.vo.sub_optionVo;
@WebServlet("/itemsInsert")
public class ItemsInsert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String upload = req.getServletContext().getRealPath("/upload");
		MultipartRequest mr = new MultipartRequest(
				req,
				upload,
				1025*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		String categoryName = mr.getParameter("categoryName");
		String itemName = mr.getParameter("itemName");
		String title = mr.getParameter("title");
		String price = mr.getParameter("price");
		String info = mr.getParameter("info");
		String[] size = mr.getParameterValues("size");
		String[] color = mr.getParameterValues("color");
		String[] count = mr.getParameterValues("count");
		String orgfileName = mr.getOriginalFileName("file1");
		String savefileName = mr.getFilesystemName("file1");
		itemsDao ItemsDao = new itemsDao();
		items_imgDao imgDao = new items_imgDao();
		items_optionDao itemoptionDao = new items_optionDao();
		sub_optionDao suboptionDao = new sub_optionDao();
		main_categoryDao categoryDao = new main_categoryDao();
		// currval로 꺼내오기
		//위에 dao 변수명까지 변경함(dao getNum도 수정하기)
		
		
		int categoryNum = categoryDao.getNum(categoryName);
		int itemNum = ItemsDao.getNum();
		ItemsDao.insert(new itemsVo(
				itemNum,categoryNum,itemName,
				Integer.parseInt(price),info,null));
		imgDao.insert(new items_imgVo(
				0,itemNum,orgfileName,
				savefileName));
		int optionNum = itemoptionDao.getNum();
		for(int i=0;i<size.length;i++) {
			if(size[i]!=null) {
				itemoptionDao.insert(new item_optionVo(optionNum,itemNum,size[i]));
			}
		}
		for(int i=0;i<color.length;i++) {
			if(color[i]!=null && count[i]!=null) {
				suboptionDao.insert(new sub_optionVo(0,optionNum,color[i],Integer.parseInt(count[i])));
			}
		}
		//백업
		/*int categoryNum = categoryDao.getNum(categoryName);
		ItemsDao.insert(new itemsVo(
				0,categoryNum,itemName,
				Integer.parseInt(price),info,null));
		int itemNum = ItemsDao.getNum();
		imgDao.insert(new items_imgVo(
				0,itemNum,orgfileName,
				savefileName));
		for(int i=0;i<size.length;i++) {
			if(size[i]!=null) {
				itemoptionDao.insert(new item_optionVo(0,itemNum,size[i]));
			}
		}
		int optionNum = itemoptionDao.getNum();
		for(int i=0;i<color.length;i++) {
			if(color[i]!=null && count[i]!=null) {
				suboptionDao.insert(new sub_optionVo(0,optionNum,color[i],Integer.parseInt(count[i])));
			}
		}*/
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/main.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/enroll.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
