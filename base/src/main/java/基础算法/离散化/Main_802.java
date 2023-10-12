package 基础算法.离散化;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_802 {
    static int n, m;
    static int N = 300010;
    static List<Integer> alls = new ArrayList<>();// 用来存所有的可能要操作的下标
    static List<Pair> add = new ArrayList<>(), query = new ArrayList<>();//add存操作的键值对,query存查询键值对
    static int[] q = new int[N];
    static int[] s = new int[N];

    //去重,
    static int unique(List list) {
        int j = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            //之前有一次排序操作,没有排序操作就不能这么去重(排序之后会将重复的元素给弄到一起去)
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                list.set(j, list.get(i));
                j++;
            }
        }
        return j;
    }

    static int find(int x, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return l + 1;//实际上是将0 --> 1 映射到1 了
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st;
        st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            int n1 = Integer.parseInt(st[0]);
            int n2 = Integer.parseInt(st[1]);
            alls.add(n1);
            add.add(new Pair(n1, n2));
        }
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int n1 = Integer.parseInt(st[0]);
            int n2 = Integer.parseInt(st[1]);
            alls.add(n1);
            alls.add(n2);
            query.add(new Pair(n1, n2));
        }
        //对可能要操作的数下标做处理
        Collections.sort(alls);//排序
        int unique = unique(alls);//去重之后,返回去重之后vector应该的长度
        alls = alls.subList(0, unique);//左闭右开的截取,unique方法返回j++也能看出来

        //插入
        for (Pair item : add) {
            //在集合中排第几个,就映射到新数组的第几个(事实上,find返回的时候+1,idx是从1开始的)
            int idx = find(item.first, alls);
            q[idx] += item.second;
        }
        //前缀和
        for (int i = 1; i <= alls.size(); i++) {
            s[i] = s[i - 1] + q[i];
        }

        for (Pair item : query) {
            int l = find(item.first, alls);
            int r = find(item.second, alls);
            System.out.println(s[r] - s[l - 1]);
        }

    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
