package com.restdemo.controller;

//import org.apache.jcs.JCS;
//import org.apache.jcs.access.exception.CacheException;

//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.jcs.access.exception.CacheException;
//import org.apache.jcs.utils.struct.LRUMap;
//
//import com.restdemo.model.User;
//
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Ehcache;
//
public class CacheUtil {

//	public static void main(String[] args) throws CacheException{
		public static String checkUSer(){
//		UserCache userCache= new UserCache();
		SimpleEHCache userCache= new SimpleEHCache();
//		JCS.getInstance("empCache");\
		if(userCache.getUser("4")!= null){
			return "hello";	
		}
		else{
			return "hi";
		}
//		System.out.println(userCache.getUser("1"));
//		System.out.println(userCache.getUser("2"));
//		System.out.println(userCache.getUser("3"));
//		System.out.println(userCache.getUser("4"));
		
		
		}
	
}
