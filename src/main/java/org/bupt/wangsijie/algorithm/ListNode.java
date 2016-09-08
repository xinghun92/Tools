package org.bupt.wangsijie.algorithm;
/**  
 * Copyright © 2016 王思杰. All rights reserved.
 *
 * @Title: ListNode.java
 * @Prject: CodingInterviews
 * @Package: utils
 * @Description: TODO
 * @author: 王思杰  
 * @date: 2016年9月6日 下午5:31:05
 * @version: V1.0  
 */
public class ListNode<T> {
	public T value;
	public ListNode<T> next;
	
	public ListNode(T value) {
		this.value = value;
	}
	
	public ListNode(T value, ListNode<T> next){
		this(value);
		this.next = next;
	}
}
