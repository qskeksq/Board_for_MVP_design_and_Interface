package com.nadan.java.mybbs.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BbsUtil {
	
	//경로 만드는 메소드
	public static void makeDir(String file){
		File dir = new File(file);
		if(!dir.exists()){ //없다면 만든다.
			dir.mkdirs();
		}
	}
	
	//파일을 생성하거나 불러오는 메소드
	public static File makeFile(String path){
		File file = new File(path);
		if(!file.exists()){
			try {
				file.createNewFile(); //파일이 없다면 새로 만든다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	//파일 값을 넣어주면 파일을 읽어주는 메소드
	public static int reader(File file){
		int result = 0;
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String temp = br.readLine(); //카운트 값을 읽어온다.
			
			if(temp == null){ //아무 값도 없다면 1로 지정(첫 값이기 때문)
				result = 1;
			} else {
				result = Integer.parseInt(temp) + 1; //이미 이전 값이 있다면 +1
			}
			br.close();
		} catch(Exception e){
			
		}
		return result;
	}

	//값을 넣어주면 파일에 값을 저장하는 메소드
	public static void writer(File path, int result){
		try{
			FileWriter fw = new FileWriter(path); //파일에 값 저장
			fw.write(result+"");
			fw.close();
		} catch(Exception e){
			
		}
	}
	
	
}
