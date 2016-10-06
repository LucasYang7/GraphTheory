package com.xiaozhejun.traverse;

public class AdjacencyMatrix {
	// 无向图matrix1
	public static int[][] matrix1 = {
			{0,1,1,1},
			{1,0,1,1},
			{1,1,0,0},
			{1,1,0,0}
	};
	// 有向图matrix2
	public static int[][] matrix2 = {
			{0,1,0,0,0},
			{1,0,0,0,1},
			{0,1,0,1,0},
			{1,0,0,0,0},
			{0,0,0,1,0}
	};
}
