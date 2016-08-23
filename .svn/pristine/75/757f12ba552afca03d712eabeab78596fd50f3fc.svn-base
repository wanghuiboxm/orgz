package com.mybatis;

import java.util.Random;

public class PrintRandomNumber{
	int[] number = new int[1000];
	Random rand = new Random();
	public PrintRandomNumber(){
		for(int i=0; i<1000; ++i){
			number[i]=0;
		}
	}
	public void print(){
		int count = 0;
		int index = 0;
		while(count<=900){
			index = rand.nextInt(1001);
			if(index == 0)
				continue;
			if(number[index-1]==0){
				number[index-1]=1;
				++count;
				System.out.println(index);
			}
		}
	}
	public static void main(String[] args) {
		PrintRandomNumber p = new PrintRandomNumber();
		p.print();
	}
}
