package com.orgz.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUploadUtils {
	/**
	 * 创建一个需要保存的文件的名字
	 * @param id 
	 * @param fileName 上传的文件的名字，通过文件名来得到保存文件的格式
	 * @return 一个文件名
	 */
	public static String getFileName(int id, String fileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int index = fileName.lastIndexOf(".");
		String type = fileName.substring(index, fileName.length());
		String path = sdf.format(new Date()) + "_" + Integer.toString(id) + type;
		return path;
	}
	
	public static String getFileName(String fileName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int index = fileName.lastIndexOf(".");
		String type = fileName.substring(index, fileName.length());
		String path = sdf.format(new Date()) + type;
		return path;
	}
	

	/**
	 * 
	 * @param file 上传过来的文件
	 * @param savePath 文件在服务器端保存的路径
	 * @param fileName 保存文件的名字
	 */
	public static void saveFile(File file, String savePath, String fileName){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			makeDir(savePath);
			fis = new FileInputStream(file);
			fos = new FileOutputStream(savePath+"/"+fileName);
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer)) > 0){
				fos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void makeDir(String savePath) {
		File fileDir = new File(savePath);
		if(!fileDir.exists()) {
			fileDir.mkdirs();
			System.out.println("创建路径");
		}
	}
	
}
