package org.bupt.wangsijie.algorithm;

import java.util.ArrayDeque;
import java.util.LinkedList;

import org.junit.Test;

/**
 * Created by wangsijie on 16/4/23.
 */

public class TreeHelper<T> {
	/**
	 * postorderTraversal (根据前序和中序遍历结果返回后续遍历结果)
	 * 第一版还很不完整 仅为一个示例
	 * @param preorderTraversal 前序遍历
	 * @param innerorderTraversal 中序遍历
	 * @return
	 *String
	 * @exception
	 * @since  1.0.0
	*/
	public String postorderTraversal(String preorderTraversal, String innerorderTraversal) {
		if (preorderTraversal.isEmpty()) {
			return "";
		}
		char root = preorderTraversal.charAt(0);
		int index = innerorderTraversal.indexOf(root);
		String leftPreorderTraversal = new String(), rightPreorderTraversal = new String(),
				leftInnerorderTraversal = new String(), rightInnerorderTraversal = new String();
		if (index + 1 >= 1) {
			leftPreorderTraversal = preorderTraversal.substring(1, index + 1);
		}
		if (index + 1 <= preorderTraversal.length()) {
			rightPreorderTraversal = preorderTraversal.substring(index + 1, preorderTraversal.length());
		}
		if (index - 1 >= 0) {
			leftInnerorderTraversal = innerorderTraversal.substring(0, index);
		}
		if (index + 1 <= innerorderTraversal.length()) {
			rightInnerorderTraversal = innerorderTraversal.substring(index + 1, innerorderTraversal.length());
		}
		String leftPostorderTraversal = postorderTraversal(leftPreorderTraversal, leftInnerorderTraversal);
		String rightPostorderTraversal = postorderTraversal(rightPreorderTraversal, rightInnerorderTraversal);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(leftPostorderTraversal);
		stringBuffer.append(rightPostorderTraversal);
		stringBuffer.append(root);
		return stringBuffer.toString();
	}

	/**
	 * treeBuilder (以null为空值构造树)
	 * @param treeSeq
	 * @return
	 *TreeNode<T>
	 * @exception
	 * @since  1.0.0
	*/
	public TreeNode<T> treeBuilder(T[] treeSeq){
		return treeBuilder(treeSeq, null);
	}
	/**
	 * treeBuilder (根据给定数组构造Tree)
	 * 
	 * @param treeSeq
	 * @param nullVal
	 *            定义的空值，以判断哪些位置是空节点
	 * @return TreeNode<T>
	 * @exception @since
	 *                1.0.0
	 */
	public TreeNode<T> treeBuilder(T[] treeSeq, T nullVal) {
		int length = treeSeq.length;
		if (length <= 0) {
			return null;
		}
		TreeNode<T> root = new TreeNode<T>(treeSeq[0]);
		TreeNode<T> head = root;
		ArrayDeque<TreeNode<T>> treeNodeQueue = new ArrayDeque<>();
		treeNodeQueue.push(root);
		int index = 1;
		while (index < length) {
			root = treeNodeQueue.removeFirst();
			if (index < length && !(treeSeq[index] == nullVal || treeSeq[index].equals(nullVal))) {
				TreeNode<T> leftTreeNode = new TreeNode<T>(treeSeq[index]);
				treeNodeQueue.addLast(leftTreeNode);
				root.leftNode = leftTreeNode;
			}
			index++;
			if (index < length && !(treeSeq[index] == nullVal || treeSeq[index].equals(nullVal))) {
				TreeNode<T> rightTreeNode = new TreeNode<T>(treeSeq[index]);
				treeNodeQueue.addLast(rightTreeNode);
				root.rightNode = rightTreeNode;
			}
			index++;
		}
		return head;
	}

	/**
	 * maxDepth (计算树的最大深度) 
	 * 
	 * @param root
	 * @return int
	 * @exception @since
	 *                1.0.0
	 */
	public int maxDepth(TreeNode<T> root) {
		if (root == null) {
			return 0;
		}
		TreeNode<T> left = root.leftNode;
		TreeNode<T> right = root.rightNode;
		return 1 + Math.max(maxDepth(left), maxDepth(right));
	}

	/**
	 * printTree (打印树) 
	 * 仅支持每个节点的值占一个字符的树
	 * 还需要继续改进
	 * @param root
	 *            void
	 * @exception @since
	 *                1.0.0
	 */
	public void printTree(TreeNode<T> root) {
		LinkedList<TreeNode<T>> tempList = new LinkedList<>();
		if (root == null) {
			return;
		}
		int depth = maxDepth(root);
		int interval = (int) Math.pow(2, depth - 1)-1;
		int num = 1;
		TreeNode<T> currentNode = root;
		while (interval >= 0) {
			printChar(interval, ' ');
			boolean isEven = true;
			for (int i = 0; i < num; i++) {
				if (currentNode != null) {
					System.out.print(currentNode.value);
					tempList.addLast(currentNode.leftNode);
					tempList.addLast(currentNode.rightNode);
				} else {
					System.out.print(" ");
					tempList.addLast(null);
					tempList.addLast(null);
				}
				isEven = !isEven;
				if(i!=num-1){
					if(isEven){
						printChar(2*interval+1,' ');
					}else{
						printChar(interval,'-');
						System.out.print(' ');
						printChar(interval,'-');
					}
				}
				currentNode = tempList.removeFirst();
			}
			System.out.println();
			if(interval==0){
				interval=-1;
			}else{
				interval /= 2;
			}
			num *= 2;
		}
	}

	private void printChar(int num, char c) {
		for (int i = 0; i < num; i++) {
			System.out.print(c);
		}
	}

	@Test
	public void Test() {
		// TreeHelper treeHelper = new TreeHelper();
		// String PreorderTraversal = "ABDGHECKFIJ";
		// String InnerorderTraversal = "GDHBEAKCIJF";
		// System.out.println(treeHelper.PostorderTraversal(PreorderTraversal,
		// InnerorderTraversal));
		// System.out.println("GHDEBKJIFCA");
		Character[] TreeSeq = new Character[] { '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '#', '#',
				'#', '#', '1' };
		TreeHelper<Character> helper = new TreeHelper<>();
		TreeNode<Character> root = helper.treeBuilder(TreeSeq, '#');
		helper.printTree(root);
	}
}
