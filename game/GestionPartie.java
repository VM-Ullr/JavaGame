package game;

public class GestionPartie {

	
	public static int [] trie (int a,int b , int c1 , int c2 ){
		int stock ; 
		int [] t = new int [2];
		int val;
		if (a > b){
			t[0] = c1;
			t[1] = c2;
		}
		if (a < b){
			t[0] = c2;
			t[1] = c1;
		}
		if (a == b){
			val =(int) (Math.random()*100) ;
			if (val < 50){
				t[0] = c1;
				t[1] = c2;
			} else {
				t[0] = c2;
				t[1] = c1;
			}
		}
		return t;
	}	
}
