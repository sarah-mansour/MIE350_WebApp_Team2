package model;

import java.util.ArrayList;

public class Wishlist {
	
	private ArrayList<Integer> wishlist = new ArrayList<Integer>();
	
	public void addModel(Model model){
		wishlist.add(model.getModelId());
	}
		
	public void deleteModel(Model model){
		wishlist.remove(model.getModelId());
	}
	
	public ArrayList getWishlist(){
		return wishlist;
	}

}
