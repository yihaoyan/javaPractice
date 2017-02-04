package com.yihao.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Algorith : Topological sorting -- WIKI
 * 
 * Link: https://leetcode.com/problems/course-schedule/
 * 
 * @author yanyihao
 *
 */
public class TopologicalSort {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// edge from source to pre
		GraphNode[] nodes = new GraphNode[numCourses];

		for (int i = 0; i < numCourses; i++) {
			nodes[i] = new GraphNode(i);
		}

		int length = prerequisites.length;

		for (int i = 0; i < length; i++) {
			int[] edge = prerequisites[i];
			int in = edge[0];
			int out = edge[1];

			nodes[in].outcoming.add(out);
			nodes[out].incoming.add(in);
			// matrix[edge[0]][edge[1]] = 1;
		}

		LinkedList<GraphNode> queue = new LinkedList<>();
		// initialize queue with nodes who have no incoming edges.
		for (int i = 0; i < numCourses; i++) {
			GraphNode current = nodes[i];

			if (current.incoming.size() == 0)
				queue.add(current);
		}

		while (!queue.isEmpty()) {
			GraphNode current = queue.removeFirst();
			int id = current.id;
			Set<Integer> out = current.outcoming;

			for (Integer i : out) {
				nodes[i].incoming.remove(id);
			}

			for (Integer i : out) {
				GraphNode nodei = nodes[i];

				if (nodei.incoming.size() == 0) {
					queue.addLast(nodei);
				}
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (nodes[i].incoming.size() > 0)
				return false;
		}

		return true;
	}
}

class GraphNode {
	public int id;
	Set<Integer> incoming;
	Set<Integer> outcoming;

	public GraphNode(int id) {
		this.id = id;
		incoming = new HashSet<>();
		outcoming = new HashSet<>();
	}
}
