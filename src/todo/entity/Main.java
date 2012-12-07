package todo.entity;

import inventory.service.CategoryDaoList;
import inventory.service.ItemDaoList;
import inventory.service.RoleDaoList;
import inventory.service.StockDaoList;
import inventory.service.UserDaoList;

public class Main {
	public static void main(String[] args) {

		// create new branch from web application.
		// BranchDaoList.getInstance().createNewBranch("Central Festival",
		// "Pattaya", "038-282828");

		// get itemByID
		// for(int i = 0 ; i < 4 ; i++){
		// System.out.println(ItemDaoList.getInstance().findByID(i).toString());
		// }

		// System.out.println(StockDaoList.getInstance().findAll().toString());
		// CategoryDaoList.getInstance().createNewCategory("Pant");

		// ItemDaoList.getInstance().findByID(2).setCategoryID(2);
		// System.out.println(ItemDaoList.getInstance().findByID(2).getCategory().getCategoryName());

		// System.out.println(StockDaoList.getInstance().findAll().toString());
		// System.out.println(StockDaoList.getInstance().add(4, 3, 5));
		// System.out.println(StockDaoList.getInstance().findByItemID(4).toString());'
		// StockDaoList.getInstance().add(3, 2, 1);
		// System.out.println(StockDaoList.getInstance().findByItemIDANDBranchID(3,
		// 2).toString());

		// ItemDaoList.getInstance().findByID(3).setItemName("juno mercury");

	}
}
