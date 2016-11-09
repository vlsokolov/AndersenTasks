package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Graph {

	private final Map<Integer, Map<Integer, Integer>> matrix;
	
	public static class Builder{
		
		private Map<Integer, Map<Integer, Integer>> graphBuilder = new HashMap<Integer, Map<Integer, Integer>>();
		
		public Builder edge(int start, int end, int value){
			if(graphBuilder.containsKey(start)){
				Map<Integer, Integer> internal = graphBuilder.get(start);
				internal.put(end, value);				
			} else {
				Map<Integer, Integer> internal = new TreeMap<>();
				internal.put(end, value);
				graphBuilder.put(start, internal);
			}
			return this;			
		}
		
		public Graph build(){
			return new Graph(this);
		}		
	}
	
	private Graph(Builder builder){
		matrix = builder.graphBuilder;
	}	
	
	public static Graph create(){
		Graph graph = new Graph.Builder()
				.edge(1, 2, 7)
				.edge(1, 3, 9)
				.edge(1, 6, 14)
				.edge(2, 3, 10)
				.edge(2, 4, 15)
				.edge(3, 4, 11)
				.edge(3, 6, 2)
				.edge(4, 5, 6)
				.edge(6, 5, 9)
				.edge(5, 4, 30)
				.build();	
		return graph;
	}
	
	public Map<Integer, Map<Integer, Integer>> getMatrix(){
		return new HashMap<Integer, Map<Integer, Integer>>(this.matrix);
	}
}
