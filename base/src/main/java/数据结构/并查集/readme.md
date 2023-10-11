并查集(基本是数的集合吧)两个重要特性:
1. 能够快速将两个集合合并在一起
2. 一般来说,并查集我们只需要写==路径压缩==优化,一般来说,不写按秩合并

其中find函数是关键
```java
int find(int x) {
    while (p[x] != x) p[x] = find(p[x]);
    return p[x];
}
```
对于p的初始化操作 
```java
for (int i = 1; i <= n; i++) {
    p[i] = i;    
}
```
