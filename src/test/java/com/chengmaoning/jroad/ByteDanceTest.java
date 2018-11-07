/**
 * 
 */
package com.chengmaoning.jroad;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import org.junit.Test;

/**
 * ByteDanceTest.java
 * 
 * @author chengmaoning
 *
 *         2018年11月1日下午10:21:26
 */
public class ByteDanceTest {

	@Test
	public void testZhijing() {
		Scanner scanner = new Scanner(System.in);
		int batchNum = scanner.nextInt();
		for (int i = 0; i < batchNum; i++) {
			int nodeNum = scanner.nextInt();
			// 矩阵图,初始化为0
			int[][] arr = new int[nodeNum + 1][nodeNum + 1];
			for (int j = 0; j < nodeNum + 1; j++) {
				for (int k = 0; k < nodeNum + 1; k++) {
					arr[j][k] = 0;
				}
			}
			// 原数据
			int[][] datas = new int[nodeNum - 1][2];
			for (int j = 0; j < nodeNum - 1; j++) {
				int pre = scanner.nextInt();
				int aft = scanner.nextInt();
				datas[j][0] = pre;
				datas[j][1] = aft;
			}
			System.out.println(Arrays.deepToString(datas));

			// 矩阵图赋值
			for (int j = 0; j < nodeNum + 1 && j < datas.length; j++) {
				int tmpi = datas[j][0];
				int tmpj = datas[j][1];
				arr[tmpi][tmpj] = 1;
			}
			
			// 打印有向图
			for (int j = 0; j < nodeNum + 1; j++) {
				for (int k = 0; k < nodeNum + 1; k++) {
					System.out.print("[" + arr[j][k] + "]");
				}
				System.out.println();
			}
			
			//深度遍历计算直径
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				Stack<Integer> stack = new Stack<>();
				for (int k = 0; k < arr.length; k++) {					
					if (arr[j][k] == 1) {
						stack.push(k);
					}
				}
				if (!stack.isEmpty()) {
					//
				}
			}
		}
	}
}
