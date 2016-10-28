package com.xiaozhejun.storage;

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
	
	public static int[][] graph = {
			{0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0},
           };
	
	public static final int MAX	= Integer.MAX_VALUE;
	
	public static int[][] graph2 = {
			{MAX, 2, MAX, 6, MAX},
            {2, MAX, 3, 8, 5},
            {MAX, 3, MAX, MAX, 7},
            {6, 8, MAX, MAX, 9},
            {MAX, 5, 7, 9, MAX},
           };
}
