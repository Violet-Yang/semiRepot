package team.project.controller.items;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.itemsDao;
import team.project.dao.items_imgDao;
import team.project.dao.items_optionDao;
import team.project.vo.item_optionVo;
import team.project.vo.itemsTotalVo;
import team.project.vo.itemsVo;
import team.project.vo.items_imgVo;

@WebServlet("/itemSelete")
public class ItemsSelete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		int pre_categoryNum = Integer.parseInt(req.getParameter("pre_categoryNum"));
		String main_categoryNum = req.getParameter("main_categoryNum");
		String spageNum = req.getParameter("spageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*8+1;
		int endRow=pageNum*8;
		itemsDao dao = new itemsDao();
		ArrayList<itemsVo> itemsList = null;
		ArrayList<items_imgVo> imgList = null;
		if(main_categoryNum==null) {
			itemsList = dao.list(startRow,endRow,pre_categoryNum,-1);
		}else {
			itemsList = dao.list(startRow,endRow,pre_categoryNum,Integer.parseInt(main_categoryNum));
		}
		items_imgDao imgdao = new items_imgDao();
		for(int i=0;i<itemsList.size();i++) {
			items_imgVo imgvo = imgdao.list(itemsList.get(i).getItems_num());
			imgList.add(imgvo);
		}
		/*items_optionDao optiondao = new items_optionDao();
		ArrayList<item_optionVo> optionList = optiondao.list();
		items_imgDao imgdao = new items_imgDao();
		ArrayList<items_imgVo> imgList = imgdao.list();
		itemsTotalVo total = null;
		for(int i=0;i<itemsList.size();i++) {
			itemsVo itemsvo = itemsList.get(i);
			itemsvo.getItems_num();
			while() {
				
			}*/
		int pageCount=(int)Math.ceil(dao.getCount()/8.0);//ÆäÀÌÁö °¹¼ö
		int startPageNum=((pageNum-1)/5)*5+1;
		int endPageNum=startPageNum+4;
		if(pageCount<endPageNum) {
			endPageNum=pageCount;
		}
		req.setAttribute("itemsList", itemsList);
		req.setAttribute("imgList", imgList);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("pre_categoryNum",pre_categoryNum);
		req.setAttribute("main_categoryNum",main_categoryNum);
		req.setAttribute("top", "/top.jsp");
		req.setAttribute("main", "/itemsList.jsp");
		req.setAttribute("bot", "/bottom.jsp");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}

