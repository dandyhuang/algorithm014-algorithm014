### 1.树
#### 1.1树的迭代遍历
* 前序
```
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList();
        if(root == null) {
            return resList;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            resList.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return resList;
    }

```
* 中序
```
public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            resList.add(root.val);
            root = root.right;
        }
        return resList;
    }
```
* 后序(leetcode上也有使用双向链表的方式来迭代的，（根右左遍历）向前插入)
```
public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList();
        if(root == null) {
            return resList;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root == null) {
                resList.add(stack.pop().val);
            } else {
                stack.push(root);
                stack.push(null);//标识根节点是否已经访问过
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return resList;
    }
```
### 2.堆
常见的有二叉堆（在堆中效率较差）、斐波那契堆
分类：
* 大顶堆/大根堆
* 小顶堆/小根堆
 #### 2.1 二叉堆
 完全二叉树来实现
 通过大顶堆来叙述
 * 是一棵完全树
 * 树中任意节点的值总是>=其子节点的值
 * 找最大值O(1)
 ###### 1、二叉堆一般通过“数组”实现
 ###### 2、假设第一个元素索引为0
 * 索引为i的左孩子索引：（2*i+1）
* 索引为i的右孩子索引：（2*i+2）
* 索引为i的父节点索引是：floor((i-1)/2) 
###### 3、插入操作
* 先插入到整个堆的尾部
* 依次向上调整整个堆的结构(HeapifyUp)
###### 4、删除操作
* 使用尾结点替换删除节点位置
* 依次向下调整(HeapifyDown)

### 3.图
做DFS/BFS搜索时一定要注意加上类似visited标识，防止重复访问