package com.xiaozhejun.mst;

import com.xiaozhejun.storage.AdjacencyMatrix;

public class Prim {

	// 图中的顶点个数
	private static final int V = 5;

	/**
	 * 从尚未加入MST的顶点集合中找出距离MST最近的顶点
	 * @param distToMST 图中每个节点到最小生成树的距离
	 * @param isInMST　标记图中某个顶点是否在MST中
	 */
	public int findMinDistToMST(int[] distToMST,boolean[] isInMST){
		int min_dist = Integer.MAX_VALUE;
		int min_index = -1;                // 尚未加入MST中且距离MST最近的顶点编号
		for(int v = 0;v < V;v++){
			if(isInMST[v] == false && distToMST[v] < min_dist){
				min_dist = distToMST[v];
				min_index = v;
			}
		}
		return min_index;
	}

	/**
	 * 打印最小生成树
	 * @param parent parent[v]用于存储MST中距离顶点v最近的节点
	 * @param V　图中的顶点个数
	 * @param graph 图的邻接矩阵
	 * */
	public void printMST(int[] parent,int V,int[][] graph){
		System.out.println("Prim’s Minimum Spanning Tree:");
		System.out.println("Edge Weight");
		for(int i = 1;i < V;i++){
			System.out.println(parent[i] + " - " + i + "  " + graph[i][parent[i]]);
		}
	}

	/***
	 * 使用prim算法生成最小生成树
	 * @param graph 图所对应的邻接矩阵
	 */
	public void primMST(int[][] graph){
		int[] parent = new int[V];          // 未加入MST的顶点与MST中距离最近的顶点
		int[] distToMST = new int[V];       // 保存图中每个顶点与MST之间的距离
		boolean[] isInMST = new boolean[V]; // 用于标记某个顶点是否在MST中
		for(int i = 0; i < V;i++){
			parent[i] = i;
			distToMST[i] = Integer.MAX_VALUE;
			isInMST[i] = false;
		}
		
		distToMST[0] = 0;
		parent[0] = -1;
		
		for(int count = 1;count <= V;count++){
			int u = findMinDistToMST(distToMST,isInMST);
			isInMST[u] = true;               // 将顶点u加入到MST中
			// 在顶点u加入到MST后，更新未加入MST顶点集合中的各个顶点到MST的最短距离
			for(int v = 0;v < V;v++){
				if(graph[u][v] != 0 && isInMST[v] == false && graph[u][v] < distToMST[v]){
					distToMST[v] = graph[u][v];
					parent[v] = u;          // u是MST集合中的顶点，v是尚未加入MST集合中的顶点
				}
			}
		}
		
		printMST(parent,V,graph);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prim prim = new Prim();
		prim.primMST(AdjacencyMatrix.graph);
	}

}
