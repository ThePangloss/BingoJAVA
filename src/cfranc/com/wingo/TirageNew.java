package cfranc.com.wingo;

import java.util.ArrayList;

public class TirageNew {

	private ArrayList<Integer> usedNums = new ArrayList<Integer>(); 

	ArrayList<Integer> getUsedNums() {
		return usedNums;
	}


	void setUsedNums(ArrayList<Integer> usedNums) {
		this.usedNums = usedNums;
	}

	public TirageNew () {
		super();
		// TODO Auto-generated constructor stub
	}


	public int tirageNumero() {
		int newNum;
		boolean unique = false;

		do{
			newNum = (int) (Math.floor(Math.random()*75)+1); 
			boolean isExist=usedNums.contains(newNum);
			if(isExist){
				unique=false;
			}
			else{
				unique=true;
				usedNums.add(newNum);
			}

		}while(unique == false);
		return newNum;
	}

}
