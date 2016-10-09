package com.xiaozhejun.traverse;

import java.util.ArrayList;
import java.util.Stack;

import com.xiaozhejun.storage.AdjacencyMatrix;

public class DFS {

	/**
	 * 图的深度优先遍历算法
	 * */
	public void DFSTravese(int[][] matrix,int root){
		Stack<Integer> stack = new Stack<Integer>();            // 深度优先遍历中所使用的栈
		ArrayList<Integer> visited = new ArrayList<Integer>();  // 用于保存已经被遍历过的节点
		stack.push(root);
		while(stack.isEmpty() == false){
			int visitNode = stack.pop();            // 弹出栈顶的元素
			System.out.print(visitNode + " ");
			visited.add(visitNode);                 // 将被访问的节点添加到已访问节点队列中
			for(int i = matrix.length - 1;i >= 0;i--){
				if(matrix[visitNode][i] != 0){       // 节点visitNode和节点i之间存在着一条边
					if(visited.contains(i) == false && stack.contains(i) == false){ //如果节点i没有被访问过且不在栈中，就将其压入到栈中
						stack.push(i);
					}
				}
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS dfs = new DFS();
		dfs.DFSTravese(AdjacencyMatrix.matrix1,3);
		dfs.DFSTravese(AdjacencyMatrix.matrix2,2);
	}

}
