# 1、git相关操作

* git init 初始化git仓库

* git config --global user.name "gufan" 配置用户名

* git config --global user.email "981943574@qq.com“ 配置邮箱  配置用户名和邮箱主要是显示提交时是谁操作的，不会做身份验证，如果邮箱是github中真实存在的邮箱，则commits里显示的就是这个邮箱对应的账号，否则显示的就是用户名（这两个都一定要配置，不然commit的时候会提示错误）

* git config --global --list 显示配置结果

* git status 查看状态

* git add ./文件名 将文件从工作区（已修改）添加到暂存区（已暂存）

* git commit -m "提交备注" 将文件从暂存区（已暂存）提交到git仓库（已提交）

* git log 查看提交记录

* git remote add origin(可自定义) git@github.com:sunshine12345678/learn_gittest.git

* git remote 查看添加的远程消息

* ssh-keygen -t rsa -C "981943574@qq.com" 生成公钥和私钥，复制公钥到github->settings->SSH and GPG keys

* ssh -T git@github.com 测试是否生成连接

* fatal: refusing to merge unrelated histories：这是因为远程仓库已经存在代码记录了，并且那部分代码没有和本地仓库进行关联，我们可以使用如下操作允许pull未关联的远程仓库旧代码：git pull origin master --allow-unrelated-histories

* git commit之后使用 git push -u origin master 提交到远程仓库

* git clone ssh的仓库地址（不要在已存在的仓库下克隆）

# 2、如何高效学习

  * 不要死磕
  * 五毒神掌，过遍数，不要只做一遍
  * 多看优质题解
  * leetcode中文站和国际站地址就差一个cn，当你刷到第4，第5遍的时候，最好去国际站看看一些高票的题解
  * 指法技巧 idea:
  * home跳到当前行行首
  * end跳到当前行行尾
  * ctrl+home跳到当前文档首行
  * ctrl+end跳到当前文档尾行
  * 选中整行：shirt+home/end/↓
  * top tips idea
  * 自顶向下的编程方式，先定义好主干

# 3、时间空间复杂度

  * 数组的长度n，如果是二维数组n^2

  * 递归的深度
  * 主定理：用渐近符号(大O符号)表示许多由分治法得到的递推关系式的方法，（算法导论作者提出）