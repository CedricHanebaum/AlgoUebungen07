package graph;

import java.util.ArrayList;

public class Graph {

	private ArrayList<ArrayList<Integer>> adjecentList;
	
	public Graph(int v){
		adjecentList = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < v + 1; ++i){
			adjecentList.add(new ArrayList<Integer>());
		}
	}
	
	public Graph(int[] list){
		adjecentList = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < list[0] + 1; ++i){
			adjecentList.add(new ArrayList<Integer>());
		}
		
		for(int i = 2; i < list.length; i += 2){
			adjecentList.get(list[i]).add(list[i + 1]);
		}
	}
	
	public int getVertexCount(){
		return adjecentList.size() - 1;
	}
	
	public int getEdgeCount(){
		int count = 0;
		for(int i = 1; i < adjecentList.size(); ++i){
			count += adjecentList.get(i).size();
		}
		return count;
	}
	
	public void addEdge(int from, int to){
		adjecentList.get(from).add(to);
	}
	
	public ArrayList<Integer> getAdjecent(int v){
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for(int i = 0; i < adjecentList.get(v).size(); ++i){
			copy.add(adjecentList.get(v).get(i));
		}
		return copy;
	}
	
	@Override
	public String toString() {
		return adjecentList.toString();
	}
	
	public static void main(String[] args) {
		int[] vlist = {6, 10, 1, 5, 1, 4, 2, 3, 2, 6, 3, 4, 3, 5, 4, 5, 4, 6, 5, 6, 6, 4};
		Graph g = new Graph(vlist);
		System.out.println(g);
	}
}
