
Now
- 16



### 线性结构和非线性结构

数据结构包括：**线性结构**和**非线性结构**。

- **线性结构**
  - 线性结构作为最常用的数据结构，其特点是数据元素之间存在一对一的线性关系
  - 线性结构有两种不同的存储结构，即顺序存储结构和链式存储结构。顺序存储的线性表称为顺序表，顺序表中的存储元素是连续的
  - 链式存储的线性表称为链表，链表中的存储元素不一定是连续的，元素节点中存放数据元素以及相邻元素的地址信息
  - 线性结构常见的有：数组、队列、链表和栈，后面我们会详细讲解.

* **非线性结构**
  * 非线性结构包括：二维数组，多维数组，广义表，树结构，图结构

### 稀疏数组

* **基本介绍**

>  当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。

稀疏数组的处理方法是:

* 记录数组一共有几行几列，有多少个不同的值

* 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模

**应用实例**

* 使用稀疏数组，来保留类似前面的二维数组(棋盘、地图等等)
* 把稀疏数组存盘，并且可以从新恢复原来的二维数组数
* 整体思路分析

![image-20201017124930303](\imgs\sparseArray.png)

![image-20201017125938262](imgs\sparseArray2.png)

**代码实现**

> 二维数组 转 稀疏数组的思路
>
> * 遍历 原始的二维数组，得到有效数据的个数 sum
> * 根据sum 就可以创建 稀疏数组 sparseArr  `int[sum + 1] [3]`
> * 将二维数组的有效数据数据存入到 稀疏数组
>
> 
>
> 稀疏数组转原始的二维数组的思路
>
> * 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 `chessArr2 = int [11][11]`
> * 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
>
>
> TODO


###  **队列**

**数组模拟队列**

* 队列本身是有序列表，若使用数组的结构来存储队列的数据，则队列数组的声明如下图, 其中 maxSize 是该队列的最大容量。

* 因为队列的输出、输入是分别从前后端来处理，因此需要两个变**量** **front**及**rear**分别记录队列前后端的下标，front 会随着数据输出而改变，而 rear则是随着数据输入而改变，如图所示:

![image-20201017123829992](imgs\queue.png)

- 当我们将数据存入队列时称为”addQueue”，addQueue 的处理需要有两个步骤：**思路分析** 
  - 将尾指针往后移：rear+1 , 当front == rear 【空】
  - 若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear所指的数组元素中，否则无法存入数据。 rear == maxSize - 1[队列满]

编码中常见的异常
- 线程结构作为最常用的数据结构，其特点是数据元素之间存在的一对一的线性关系
- 线性结构有两种不同的存储结构，即顺序存储结构的和链式存储结构

问题分析并优化

* 目前数组使用一次就不能用，没有达到复用的效果
* 将这个数组使用算法，改进成一个环形的队列 取模：%



**数组模拟环形队列**

对前面的数组模拟队列的优化，充分利用数组。因此将数组看做是一个环形的。(通过取模的方式来实现即可)

分析说明：

- 尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定,这个在做判断队列满的时候需要注意 (rear + 1) % maxSize == front 满] 
- rear == front [空]
- 测试示意图:

![image-20201017123829992](imgs\queue.png)

> 思路如下:
>
> 1. front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素front 的初始值 = 0
>
> 2. rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
>
>    rear 的初始值 = 0
>
> 3. 当队列满时，条件是 (rear + 1) % maxSize == front 【满】
>
> 4. 对队列为空的条件， rear == front 空
>
> 5. 当我们这样分析， 队列中有效的数据的个数  (rear + maxSize - front) % maxSize  // rear = 1 front = 0 
>
> 6. 我们就可以在原来的队列上修改得到，一个环形队列

### 链表(Linked List)

链表是有序的列表，但是它在**内存中是存储**如下

![image-20201020062608108](imgs\linked-list.png)

**小结:**

1. 链表是以节点的方式来存储,是链式存储

2. 每个节点包含 data 域， next 域：指向下一个节点.

3. 如图：发现链表的**各个节点不一定是连续存储**.

4. 链表分带头节点的链表和没有头节点的链表，根据实际的需求来确定

单链表(带头结点) **逻辑结构**示意图如下

![image-20201020062827393](imgs\linked-list-storage.png)

**单链表的应用实例**

![image-20201020063847176](imgs\hero.png)

使用带head头的**单向链表**实现 –水浒英雄排行榜管理完成对英雄人物的**增删改查**操作， 注: **删除和修改,查找可以考虑学员独立完成，也可带学员完成**

- 第一种方法在添加英雄时，直接添加到链表的尾部

![image-20201020063500946](imgs\linked-list-add.png)

- **第二种方式在添加英雄时**，根据排名将英雄插入到指定位置 (如果有这个排名，则添加失败，并给出提示)

![image-20201020063659978](imgs\linked-list-add2.png)

* 修改节点
  * 通过遍历，先找到该节点
  * temp.name = newHeroNode.name; temp.nickname = newHeroNode.nickname
* 删除节点

![image-20201020064212530](imgs\linked-list-delete.png)

-----

#### 单向链表

**单向链表(**单链表)是链表的一种，它由节点组成，每个节点都包含下一个节点的指针。

单链表的示意图如下：

![img](imgs\single-list.jpg)

表头为空，表头的后继节点是"节点10"(数据为10的节点)，"节点10"的后继节点是"节点20"(数据为10的节点)，...



**单链表删除节点**

![img](imgs\single-list-delete.jpg)

删除"节点30"
**删除之前**："节点20" 的后继节点为"节点30"，而"节点30" 的后继节点为"节点40"。
**删除之后**："节点20" 的后继节点为"节点40"。



 **单链表添加节点**

![img](imgs\single-list-add.jpg)

在"节点10"与"节点20"之间添加"节点15"
**添加之前**："节点10" 的后继节点为"节点20"。
**添加之后**："节点10" 的后继节点为"节点15"，而"节点15" 的后继节点为"节点20"。

单链表的特点是：节点的链接方向是单向的；相对于数组来说，单链表的的随机访问速度较慢，但是单链表删除/添加数据的效率很高。



#### **双向链表**

**双向链表**(双链表)是链表的一种。和单链表一样，双链表也是由节点组成，它的每个数据结点中都有两个指针，分别指向直接后继和直接前驱。所以，从双向链表中的任意一个结点开始，都可以很方便地访问它的前驱结点和后继结点。一般我们都构造双向循环链表。

双链表的示意图如下：

![img](imgs\doulbe-linked-list.jpg)

表头为空，表头的后继节点为"节点10"(数据为10的节点)；"节点10"的后继节点是"节点20"(数据为10的节点)，"节点20"的前继节点是"节点10"；"节点20"的后继节点是"节点30"，"节点30"的前继节点是"节点20"；...；末尾节点的后继节点是表头。

**双链表删除节点**

![img](imgs\doulbe-list-delete.jpg)

删除"节点30"
**删除之前**："节点20"的后继节点为"节点30"，"节点30" 的前继节点为"节点20"。"节点30"的后继节点为"节点40"，"节点40" 的前继节点为"节点30"。
**删除之后**："节点20"的后继节点为"节点40"，"节点40" 的前继节点为"节点20"。

 

**双链表添加节点**

![img](imgs\doulbe-list-add.jpg)

在"节点10"与"节点20"之间添加"节点15"
**添加之前**："节点10"的后继节点为"节点20"，"节点20" 的前继节点为"节点10"。
**添加之后**："节点10"的后继节点为"节点15"，"节点15" 的前继节点为"节点10"。"节点15"的后继节点为"节点20"，"节点20" 的前继节点为"节点15"。