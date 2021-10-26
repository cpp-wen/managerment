package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:maidang
 * @date:2021/01/06
 **/
public class leetcode {


  public double[] calcEquation(List<List<String>> equations, double[] values,
                               List<List<String>> queries) {
    //这边并查集创建两个集合  正反各一个
    int equationsSize = equations.size();
    UnionFind unionFind = new UnionFind(2 * equationsSize);
    Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
    int id = 0;
    for (int i = 0; i < equationsSize; i++) {
      List<String> equation = equations.get(i);
      String var1 = equation.get(0);
      String var2 = equation.get(1);

      if (!hashMap.containsKey(var1)) {
        hashMap.put(var1, id);
        id++;
      }
      if (!hashMap.containsKey(var2)) {
        hashMap.put(var2, id);
        id++;
      }
      unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
    }
    // 第 2 步：做查询
    int queriesSize = queries.size();
    double[] res = new double[queriesSize];
    for (int i = 0; i < queriesSize; i++) {
      String var1 = queries.get(i).get(0);
      String var2 = queries.get(i).get(1);

      Integer id1 = hashMap.get(var1);
      Integer id2 = hashMap.get(var2);

      if (id1 == null || id2 == null) {
        res[i] = -1.0d;
      } else {
        res[i] = unionFind.isConnected(id1, id2);
      }
    }
    return res;
  }

  private class UnionFind {

    private int[] parent;
    private double[] weight;

    public UnionFind(int n) {
      parent = new int[n];
      weight = new double[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        weight[i] = 1.0d;
      }
    }

    //进行合并
    public void union(int x, int y, double value) {
      int rootx = find(x);
      int rooty = find(y);
      if (rootx == rooty) {
        return;
      }
      parent[rootx] = rooty;
      weight[rootx] = weight[y] * value / weight[x];
    }

    //这边是找父节点
    public int find(int x) {
      if (x != parent[x]) {
        int origin = parent[x];
        parent[x] = find(parent[x]);
        weight[x] *= weight[origin];
      }
      return parent[x];
    }

    public double isConnected(int x, int y) {
      int rootx = find(x);
      int rooty = find(y);
      if (rootx == rooty) {
        return weight[x] / weight[y];
      } else {
        return -1.0d;
      }
    }
  }

}
