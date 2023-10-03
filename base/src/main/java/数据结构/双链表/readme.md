### 单链表与双链表的不同地方

单链表的 head = -1;

双链表的 head = 0, tail = 1;

单链表添加的时候,最后一个元素的ne[] = -1, 我们在写代码的时候注意一下,
添加到头结点与添加到第k个元素的函数需要分开写,才能达到目的;

单链表遍历时的条件
```java
for (int i = head; i != -1; i = ne[i]) {
    System.out.println(e[i] + " ");
}
```
双链表遍历时的临界条件
```java
for (int i = ne[head]; i != 1; i = ne[i]) {
    System.out.println(e[i] + " ");
}
```
