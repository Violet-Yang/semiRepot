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
		String smain_categoryNum = req.getParameter("main_categoryNum");
		String spageNum = req.getParameter("pageNum");
		String sselectNum = req.getParameter("selectNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int main_categoryNum=0;
		if(smain_categoryNum!=null) {
			main_categoryNum=Integer.parseInt(smain_categoryNum);
		}
		int selectNum=1;
		if(sselectNum!=null) {
			selectNum=Integer.parseInt(sselectNum);
		}
		int startRow=(pageNum-1)*8+1;
		int endRow=pageNum*8;
		itemsDao dao = new itemsDao();
		ArrayList<itemsTotalVo> totalList = new ArrayList<itemsTotalVo>();
		ArrayList<itemsTotalVo> newtotalList = new ArrayList<itemsTotalVo>();
		ArrayList<itemsVo> itemsList = dao.list(startRow,endRow,pre_categoryNum,main_categoryNum);
		ArrayList<itemsVo> newItemsList = dao.newList(pre_categoryNum,main_categoryNum);
		ArrayList<itemsVo> priceHighList = dao.priceHighList(startRow,endRow,pre_categoryNum,main_categoryNum);
		ArrayList<itemsVo> priceRowList = dao.priceRowList(startRow,endRow,pre_categoryNum,main_categoryNum);
		//아이템 뽑아서 vo에 담아서 가져가기
		items_imgDao imgdao = new items_imgDao();
		for(int i=0;i<newItemsList.size();i++) {
			items_imgVo imgvo = imgdao.list(newItemsList.get(i).getItems_num());
			itemsVo vo = newItemsList.get(i);
			itemsTotalVo totalvo = new itemsTotalVo(
					vo.getItems_num(),vo.getMain_category_num(),
					vo.getName(),vo.getPrice(),vo.getInfo(),vo.getItem_date(),
					imgvo.getItems_img_num(),imgvo.getFile_name(),imgvo.getFile_type()
					);
			newtotalList.add(totalvo);
		}
		if(selectNum==1) {
			for(int i=0;i<itemsList.size();i++) {
				items_imgVo imgvo = imgdao.list(itemsList.get(i).getItems_num());
				itemsVo vo = itemsList.get(i);
				itemsTotalVo totalvo = new itemsTotalVo(
						vo.getItems_num(),vo.getMain_category_num(),
						vo.getName(),vo.getPrice(),vo.getInfo(),vo.getItem_date(),
						imgvo.getItems_img_num(),imgvo.getFile_name(),imgvo.getFile_type()
						);
				totalList.add(totalvo);
			}
		}else if(selectNum==2) {
			for(int i=0;i<priceHighList.size();i++) {
				items_imgVo imgvo = imgdao.list(priceHighList.get(i).getItems_num());
				itemsVo vo = priceHighList.get(i);
				itemsTotalVo totalvo = new itemsTotalVo(
						vo.getItems_num(),vo.getMain_category_num(),
						vo.getName(),vo.getPrice(),vo.getInfo(),vo.getItem_date(),
						imgvo.getItems_img_num(),imgvo.getFile_name(),imgvo.getFile_type()
						);
				totalList.add(totalvo);
			}
		}else{
			for(int i=0;i<priceRowList.size();i++) {
				items_imgVo imgvo = imgdao.list(priceRowList.get(i).getItems_num());
				itemsVo vo = priceRowList.get(i);
				itemsTotalVo totalvo = new itemsTotalVo(
						vo.getItems_num(),vo.getMain_category_num(),
						vo.getName(),vo.getPrice(),vo.getInfo(),vo.getItem_date(),
						imgvo.getItems_img_num(),imgvo.getFile_name(),imgvo.getFile_type()
						);
				totalList.add(totalvo);
			}
		}
		
		int pageCount=(int)Math.ceil(dao.getCount()/8.0);//페이지 갯수
		int startPageNum=((pageNum-1)/5)*5+1;
		int endPageNum=startPageNum+4;
		if(pageCount<endPageNum) {
			endPageNum=pageCount;
		}
		req.setAttribute("newtotalList", newtotalList);
		req.setAttribute("totalList", totalList);
		req.setAttribute("selectNum", selectNum);
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

