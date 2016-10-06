package com.xiaozhejun.traverse;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
	
	/**
	 * 图的广度优先遍历算法
	 * */
	public void BFSTravese(int[][] matrix,int root){
		LinkedList<Integer> queue = new LinkedList<Integer>();     // 存放待遍历节点的队列
		ArrayList<Integer> visited = new ArrayList<Integer>();     // 存放已经被遍历的节点
		queue.offer(root);            // 将首个被遍历的节点加入到队列中
		while(queue.isEmpty() == false){
			int visitNode = queue.poll();    // 访问并且弹出队列中的首个节点
			System.out.print(visitNode + " ");
			visited.add(visitNode);
			for(int i = 0;i < matrix.length;i++){
				if(matrix[visitNode][i] != 0){   // 表示节点visitNode与节点i之间存在一条边
					if(visited.contains(i) == false && queue.contains(i) == false){  // 节点i没有被访问过且不在待访问节点队列中
						queue.offer(i);
					}
				}
			}
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		BFS bfs = new BFS();
		bfs.BFSTravese(AdjacencyMatrix.matrix1,3);
		bfs.BFSTravese(AdjacencyMatrix.matrix2,2);
	}
}
