package com.v5ent.distribut.util;

import java.util.UUID;

/**
 *UUID工具類
 */
public class UUIDUtils{
	/**
	 * String uuid
	 */
	public static String generateStringUuid(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	/**
	 * 前缀"/"的路径字符串
	 */
	public static String generatorTransactionPath(){
		StringBuilder builder=new StringBuilder();
		builder.append("/").append(generateStringUuid());
		return builder.toString();
	}
	/**
	 * 前缀"/"的路径字符串
	 * @param namespace 空间路径
	 */
	public static String generatorTransactionPath(String namespace){
		StringBuilder builder=new StringBuilder();
		builder.append("/").append(namespace).append("/").append(generateStringUuid());
		return builder.toString();
	}
}
