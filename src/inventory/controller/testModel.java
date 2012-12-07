package inventory.controller;

import java.util.ArrayList;
import java.util.List;

import inventory.service.BranchDaoList;
import inventory.service.CategoryDaoList;
import inventory.service.ItemDaoList;
import inventory.service.RoleDaoList;
import inventory.service.StockDaoList;
import inventory.service.TypeDaoList;
import inventory.service.UserDaoList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import todo.entity.Branch;
import todo.entity.Category;
import todo.entity.Item;

import todo.entity.Stock;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

import todo.entity.Status;
import todo.entity.Stock;
import todo.entity.ItemJSON;
import todo.entity.StockJSON;

import com.sun.jersey.api.json.JSONUnmarshaller;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;
import com.sun.jersey.json.impl.JSONUnmarshallerImpl;
import com.sun.jersey.json.impl.provider.entity.JSONJAXBElementProvider;

@Path("/")
public class testModel {
	private BranchDaoList branchDao;
	private CategoryDaoList categoryDao;
	private ItemDaoList itemDao;
	private RoleDaoList roleDao;
	private StockDaoList stockDao;
	private TypeDaoList typeDao;
	private UserDaoList userDao;

	public testModel() {
		this.branchDao = BranchDaoList.getInstance();
		this.categoryDao = CategoryDaoList.getInstance();
		this.itemDao = ItemDaoList.getInstance();
		this.roleDao = RoleDaoList.getInstance();
		this.stockDao = StockDaoList.getInstance();
		this.userDao = UserDaoList.getInstance();
	}

	@Path("/branch/{branc_id: \\d+}/{item_id: \\d+}")
	@Produces(MediaType.TEXT_HTML)
	public Viewable itemBranchJSP(@Context HttpServletRequest request,
			@PathParam("branch_id") int branch_id,
			@PathParam("item_id") int item_id) {
		request.setAttribute("CategoryList", categoryDao.findAll());
		Item item = itemDao.findByID(item_id);
		Branch branch = branchDao.findByID(branch_id);
		int quantity;
		quantity = stockDao.findByItemIDANDBranchID(item_id, branch_id)
				.getQuantity();

		System.out.println(branch.getBranchName());
		request.setAttribute("item", item);
		request.setAttribute("branch", branch);
		request.setAttribute("quantity", quantity);
		System.out.println("/itembranch called");
		return new Viewable("/itembranch.jsp", null);
	}

	// output :
	// {"categoryName":"categoryName","description":"description","image":"image","itemID":"itemID","itemName":"itemName","price":"price","size":"size"}
	@GET
	@Path("/branch/{branch_id: \\d+}/{item_id: \\d+}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public ItemJSON itemBranchJSON(@Context HttpServletRequest request,
			@PathParam("branch_id") int branch_id,
			@PathParam("item_id") int item_id) {
		Branch branch = branchDao.findByID(branch_id);
		Item item = itemDao.findByID(item_id);

		ItemJSON itemJ = new ItemJSON(item.getItemID(), item.getCategory()
				.getCategoryName(), item.getItemName(), item.getSize(),
				item.getDescription(), item.getPrice(), item.getItemID() + "");
		return itemJ;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Viewable show(@Context HttpServletRequest request) {
		request.setAttribute("CategoryList", categoryDao.findAll());

		System.out.println("/INDEXss");

		return new Viewable("/indextest.jsp", null);
	}

	// format "{branchID: branchID, itemID: itemID, quantity: quantity}"
	/**@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Status add(StockJSON info) {

		System.out.println("post");
		try {
			stockDao.add(info.getBranchID(), info.getItemID(),
					info.getQuantity());
		} catch (Exception x) {
			return new Status("Fail");
		}
		return new Status("Success");
	} */

	// format "{branchID: branchID, itemID: itemID, quantity: quantity}"
	@POST
	@Path("/test")
	@Consumes(MediaType.APPLICATION_JSON)
	public Status test(StockJSON info) {
		String result = "Test : " + info.getBranchID();
		System.out.println(result);
		System.out.println("post");
		try {
			stockDao.add(info.getBranchID(), info.getItemID(),
					info.getQuantity());
		} catch (Exception x) {
			return new Status("Fail");
		}
		return new Status("Success");
	}

	// format "{branchID: branchID, itemID: itemID, quantity: quantity}"
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Status delete(StockJSON info) {
		try {
			stockDao.delete(info.getBranchID(), info.getItemID(),
					info.getQuantity());
		} catch (Exception x) {
			return new Status("Fail");
		}
		return new Status("Success");

	}

	@GET
	@Path("/category/{categoryname}/{item_id: \\d+}")
	@Produces({ MediaType.TEXT_HTML })
	public Viewable item(@Context HttpServletRequest request,
			@PathParam("categoryname") String categoryname,
			@PathParam("item_id") int item_id) {
		request.setAttribute("CategoryList", categoryDao.findAll());
		Item item = itemDao.findByID(item_id);
		List<Branch> branchList = branchDao.findAll();
		int quantity;
		List<Object[]> arr = new ArrayList<Object[]>();
		int iter = 0;
		Object[] tmp = new Object[2];
		for (Branch i : branchList) {
			quantity = stockDao.findByItemIDANDBranchID(item_id,
					i.getBranchID()).getQuantity();
			tmp[0] = branchList.get(iter).getBranchName();
			tmp[1] = quantity;
			arr.add(tmp);
		}

		request.setAttribute("item", item);
		request.setAttribute("branchList", arr);
		System.out.println("/item called");
		return new Viewable("/item.jsp", null);
	}

	@GET
	@Path("/category")
	@Produces(MediaType.TEXT_HTML)
	public Viewable categoryIndex(@Context HttpServletRequest request) {
		request.setAttribute("CategoryList", categoryDao.findAll());
		System.out.println("/categoryList called");
		return new Viewable("/categoryList.jsp", null);
	}

	@GET
	@Path("/branch")
	@Produces(MediaType.TEXT_HTML)
	public Viewable branchIndex(@Context HttpServletRequest request) {
		request.setAttribute("CategoryList", categoryDao.findAll());
		request.setAttribute("branchList", branchDao.findAll());
		System.out.println("/branchList called");
		return new Viewable("/branchList.jsp", null);
	}

	@GET
	@Path("/show")
	@Produces(MediaType.TEXT_HTML)
	public Viewable showroom(@Context HttpServletRequest request) {

		System.out.println("/showroom called");
		return new Viewable("/showmain.jsp", null);
	}

	@GET
	@Path("/branch/{branchname}")
	@Produces(MediaType.TEXT_HTML)
	public Viewable branch(@Context HttpServletRequest request,
			@PathParam("branchname") String branchname) {
		request.setAttribute("CategoryList", categoryDao.findAll());
		System.out.println("/" + branchname + " called");
		return new Viewable("/branchList.jsp", null);
	}

	@GET
	@Path("/category/{categoryname}")
	@Produces(MediaType.TEXT_HTML)
	public Viewable category(@Context HttpServletRequest request,
			@PathParam("categoryname") String categoryname) {
		request.setAttribute("CategoryList", categoryDao.findAll());
		request.setAttribute("categoryName", categoryname);
		int categoryID = categoryDao.findByName(categoryname).getCategoryID();
		List<Item> itemList = itemDao.findByCategoryID(categoryID);
		request.setAttribute("itemList", itemList);
		System.out.println("/" + categoryname + " called");
		return new Viewable("/category.jsp", null);
	}

}