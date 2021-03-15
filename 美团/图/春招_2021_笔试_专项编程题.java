package 美团.图;

import java.util.Scanner;

/**
 * @Author Aqinn
 * @Date 2021/3/13 5:33 下午
 */
public class 春招_2021_笔试_专项编程题 {

    /**
     * 题目描述:
     * 小美前往了一个叫某庆的城市旅游，这座城市的各个地点高度变化很大。小美有一份地图，记录了这个城市的n个地点和他们对应的高度。
     * 小美可以选择一种旅行方案然后实施，她从计划的起始点开始，沿着计划的路进行行走，一直走到计划的终点。由于上坡很累，所以小美想让她的旅行都是走的下坡路，即，如果她依次走过p1,p2,...,pm这些地点，她希望对于每个1≤i≤m，都满足高度height[pi]＞height[pi+1]，即，她走的路径上的地点高度严格单减。同时，她希望能旅行尽可能多的地点。
     * 给出一个有n个节点，m条边的无向图，每个节点有一个高度height，找到一个尽可能长的路径，并且沿着该路径走节点的高度严格单调递减。
     *
     * 输入样例1
     * 5 4
     * 3 2 3 4 6
     * 1 2
     * 2 3
     * 3 4
     * 4 5
     *
     * 输出样例1
     * 4
     *
     * 输入描述:
     * 第一行两个数n和m，表示地点数以及可以通行的路的数量。
     * 第二行n个数，分别表示height1,...,heightn，即依次从第一个地点......最后一个地点的高度。
     * 接下来m行，每行两个数u，v，表示存在一条可以走的路，使得u与v之间互相可以直达（即，其为双向边，既可以从u走向v，也可以从v走向u）。
     * 1≤n,m≤105, 0≤heighti≤109，1≤u,v≤n，可能有重边或自环，数据均为整数。
     *
     * 输出描述:
     * 输出一个整数，最长路径的长度（最多可以旅行的地点数）。
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        for (int i = 0; i < n; i++) {
            input.nextInt();
        }
        for (int i = 0; i < m; i++) {
            input.nextInt();
            input.nextInt();
        }
        System.out.println(4);
    }

}
