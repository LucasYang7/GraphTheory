package com.xiaozhejun.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.xiaozhejun.storage.AdjacencyMatrix;

public class Kruskal {

	private final int V = 5;
	private int[] parent = new int[V];

	// 保存边的信息
	class Edge implements Comparable<Edge>{
		int start;              // 边的起点
		int end;                // 边的终点
		int weight;             // 边的权值
		@Override
		public int compareTo(Edge compareEdge) {       // 按照边权值由小到大进行排序
			// TODO Auto-generated method stub
			return this.weight - compareEdge.weight;
		}
	}

	/**
	 * 初始化图中的每个顶点的父节点信息
	 * @param numberOfNodes  图的顶点个数
	 * */
	public void init(int numberOfNodes){
		for(int v = 0;v < V;v++){
			parent[v] = v;
		}
	}

	/**
	 * 查找图中中的每个顶点的根节点
	 * @param node  待查找的顶点
	 * */
	public int findRoot(int node){
		int root = node;
		if(node != parent[node]){
			root = findRoot(parent[node]);
		}
		return root;
	}
	
	/**
	 * 判断图中某条边所对应的两个顶点是否已经加入到MST中
	 * @param x 边的起始顶点
	 * @param y 边的终止顶点
	 * */
	public boolean union(int x,int y){
		boolean isInTheSameSet = true;
		int rootX = findRoot(x);
		int rootY = findRoot(y);
		if(rootX != rootY){
			parent[rootX] = rootY;
			isInTheSameSet = false;
		}
		return isInTheSameSet;
	}

	/**
	 * 使用kruskal算法生成最小生成树
	 * @param graph 存储图所用的邻接矩阵
	 * */
	public void kruskalMST(int[][] graph){
		ArrayList<Edge> edgeList = new ArrayList<Edge>();       // 保存图中所有的边
		for(int i = 0;i < V;i++){
			for(int j = i + 1;j < V;j++){
				if(graph[i][j] != 0){
					Edge edge = new Edge();
					edge.start = i;
					edge.end = j;
					edge.weight = graph[i][j];
					edgeList.add(edge);
				}
			}
		}
		
		Collections.sort(edgeList);   // 按照边权值由小到大进行排序
		
		init(V);
		int numberEdgeInMST = 0;      // 已经加入MST的边数
		System.out.println("Kruskal’s Minimum Spanning Tree:");
		System.out.println("Edge Weight");
		for(Edge edge:edgeList){
			boolean isInSameSet = union(edge.start,edge.end);
			if(isInSameSet == false){
				System.out.println(edge.start + " - " + edge.end + "  " + edge.weight);
				numberEdgeInMST++;
				if(numberEdgeInMST == V-1){
					break;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kruskal kruskal = new Kruskal();
		kruskal.kruskalMST(AdjacencyMatrix.graph);
	}

}
