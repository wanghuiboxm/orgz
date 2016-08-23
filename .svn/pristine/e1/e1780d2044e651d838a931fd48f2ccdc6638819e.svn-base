package com.mybatis;

public class MoveApple {
	public static void main(String[] args) {
		Stack stack = new Stack();
		PushApple pushApple = new PushApple(stack);
		PopApple popApple = new PopApple(stack);
		pushApple.start();
		popApple.start();
	}
}

class PushApple extends Thread {
	Stack stack;
	int count = 0;

	PushApple(Stack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		while (count < 1000) {
//			synchronized (stack) {

				if (!stack.isFull()) {
					System.out.println("线程" + Thread.currentThread().getName()
							+ "放入：" + count);
					stack.push(count);
					count++;
				}
//			}
		}
	}
}

class PopApple extends Thread {
	Stack stack;
	int count = 0;

	PopApple(Stack stack) {
		this.stack = stack;
	}

	@Override
	public void run() {
		while (count < 1000) {
//			synchronized (stack) {

				if (!stack.isEmpty()) {
					System.out.println("线程" + Thread.currentThread().getName()
							+ "卖出：" + stack.pop());
					count++;
				}
//			}
		}
	}
}

class Stack {
	int[] data = new int[5];
	int size = 0;

	public void push(int n) {
		synchronized (this) {
			if (size < 5)
				data[size++] = n;
		}
	}

	public synchronized int pop() {
		if (size > 0)
			return data[--size];
		return -1;
	}

	public synchronized boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public synchronized boolean isFull() {
		if (size >= 5)
			return true;
		return false;
	}
}