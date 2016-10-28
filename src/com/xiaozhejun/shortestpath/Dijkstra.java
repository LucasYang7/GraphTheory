package com.xiaozhejun.shortestpath;

import com.xiaozhejun.storage.AdjacencyMatrix;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.dijkstra(0, 2, AdjacencyMatrix.graph2);
	}
	
	public void dijkstra(int start,int destination,int[][] graphAdj){
		int numberOfNodes = graphAdj.length;            // 图中的结点个数
		int[] dist = new int[numberOfNodes];            // 图中各个顶点到起始顶点的距离
		boolean[] visited = new boolean[numberOfNodes]; // 判断顶点i是否已经加入到了已求出距离的顶点集合       
		for(int i = 0;i < numberOfNodes;i++){
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		dist[start] = 0;           // start顶点到自身的距离为０
		for(int i = 0;i < numberOfNodes;i++){
			int curVisitNode = -1;
			for(int j = 0;j < numberOfNodes;j++){
				if(visited[j] == true)
					continue;
				if(curVisitNode == -1 || dist[j] < dist[curVisitNode]){// 在未求出最短距离的顶点集合中找出一个距离start顶点最近的顶点
					curVisitNode = j;
				}
			}
			visited[curVisitNode] = true;
			// 将curVisitNode顶点加入到已求出最短路径的顶点集合后，更新图中其余各个顶点到start顶点的最短距离
			for(int j = 0;j < numberOfNodes;j++){
				// graphAdj[curVisitNode][j] != Integer.MAX_VALUE保证curVisitNode与j顶点之间有一条边
				if(graphAdj[curVisitNode][j] != Integer.MAX_VALUE){
					int minDistance = dist[curVisitNode] + graphAdj[curVisitNode][j];
					if(minDistance < dist[j]){
						dist[j] = minDistance;
					}
				}
			}
		}
		//System.out.println("start node to destination node's distance is " + dist[destination]);
		for(int i = 0;i < numberOfNodes;i++){
			System.out.println("start node " + start + " to destination " + i + " node's distance is " + dist[i]);
		}
		
	}

}
