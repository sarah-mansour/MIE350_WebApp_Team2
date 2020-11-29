package dao;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.Model;

public class CompareDao {
	
	private List<Model> compareList;
	
	
	public void addToCompare(Model model){
		int compareListSize = 2;
		//check if comparelist size is less than 2, if yes add, if no error
		if (compareList.size() < compareListSize){
			// check if model in compare list, if yes print: model already in list, if not, add model
			if (compareList.contains(model)){
				System.out.println("This model is already in the compare function");
			}
			else{
				//add the model to the list
				ModelDao modelDao = new ModelDao();
				Model addedModel = modelDao.getModelById(model.getId());
				compareList.add(addedModel);	
				
			}
		}
		else{
			System.out.println("Cannot add more than 2 models to compare");
		}			
	}
	
	public void deleteFromCompare(Model model){
		if (compareList.contains(model)){
			compareList.remove(model);
		}
	}
	
	public List<Model> getCompareList(){
		return compareList;
	}
}
