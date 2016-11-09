package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindPath {	
	
	private static Map<Integer, Map<Integer, Integer>> matrix;
	private static Set<Integer> nodes;
	private static Map<Integer, Integer> nodesvalues;
	private static final int value = Integer.MAX_VALUE/2;
	
	public static void main(String[] args){
		find(1, 5);
	}
	
	public static void find(int startpoint, int endpoint){	
		setUp();
		int start = startpoint;
		int end = endpoint;
		int pathvalue = 0;
		
		nodesvalues.put(start, 0);
		boolean found = false;
		if(nodes.contains(start) && nodes.contains(end)){
				while(start!=end){
					Map<Integer, Integer> edges = matrix.get(start);
						for(Entry<Integer, Integer> entry : edges.entrySet()){
							if(nodesvalues.get(entry.getKey())==value){
								nodesvalues.put(entry.getKey(), pathvalue + entry.getValue());	
									if(entry.getKey() == end)
										found = true;
							} else {								
								if(nodesvalues.get(entry.getKey()) > pathvalue + entry.getValue()){
									nodesvalues.put(entry.getKey(), pathvalue + entry.getValue());										
								} 								
							}			
						}
							
						int max = Integer.MAX_VALUE;
						for(Entry<Integer, Integer> values: nodesvalues.entrySet()){
							if(values.getValue() < max && values.getValue()!=value && values.getValue() > pathvalue){
								max = values.getValue();
								start = values.getKey();
							}								
						}
						if(max != Integer.MAX_VALUE){
							pathvalue = max;
						} else {
							break;
						}						
				}								
		}
		if(found){
			System.out.println("The length of the shortest path: " + pathvalue);
		} else {
			System.out.println("There are no path in this direction between this points ");
		}		
	}
	
	private static void setUp(){
		Graph graph = Graph.create();
		matrix = graph.getMatrix();
		nodes = matrix.keySet();
		nodesvalues = new HashMap<>();		
			
		for(Integer node: nodes){
			nodesvalues.put(node, value);
		}		
	}
}
