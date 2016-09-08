package org.bupt.wangsijie.algorithm;
/**  
 * Copyright © 2016 王思杰. All rights reserved.
 *
 * @Title: TreeNode.java
 * @Prject: CodingInterviews
 * @Package: utils
 * @Description: TODO
 * @author: 王思杰  
 * @date: 2016年9月7日 上午10:25:48
 * @version: V1.0  
 */
public class TreeNode<T> {
	public T value;
	public TreeNode<T> leftNode;
	public TreeNode<T> rightNode;
	
	public TreeNode(T value) {
		this.value = value;
	}
	public TreeNode(T value, TreeNode<T> leftNode, TreeNode<T> rightNode){
		this(value);
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
}
