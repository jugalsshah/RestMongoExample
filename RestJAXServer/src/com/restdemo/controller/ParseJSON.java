package com.restdemo.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.LinkedHashMap;
//import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Properties;

//import javax.swing.text.ZoneView;

//import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
//import org.apache.jcs.auxiliary.remote.ZombieRemoteCacheWatch;
//import org.apache.jcs.engine.control.CompositeCacheManager;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
//import com.mongodb.DBCursor;
//import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.restdemo.bean.User;

//import com.mongodemo.Test;

public class ParseJSON {

	// @SuppressWarnings("rawtypes")
	
ArrayList<User> l= new ArrayList<>();
ArrayList<String> ids= new ArrayList<>();
UserCache userCache= new UserCache();
//SimpleEHCache userCache = new SimpleEHCache();
User users= new User();
String s = null;

long L=0;
/*
 * 
 * 1)this method is parsing the objects(JSON data) came from userservice class into simple form. 
 * 2)Insert data into user object and mongoDb and calling the usercache to save(put) the object.
 * 3)Checking the condition wether the user is i serted first time or not. 
 * */



	public String insertJsontoDB(StringBuilder user, StringBuilder address) throws JSONException,
			UnknownHostException, CacheException {
//		UserCache userCache= new UserCache();
		JSONObject jsonuser = new JSONObject(user.toString());
		JSONArray user_json_array = jsonuser.getJSONArray("userRecords");
		JSONObject jsonaddress = new JSONObject(address.toString());
		JSONArray address_json_array = jsonaddress.getJSONArray("userAddress");
		//userRecords and userAddress data should be same numbers (equal numbers of ids in both the files)
		int size = user_json_array.length();
		ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
//		Map<String, String> map = null;
		// String sarray;

		Mongo client = new MongoClient("localhost", 27017);
		DB db = client.getDB("records");
		DBCollection collection = db.getCollection("userRecords");
		BasicDBObject document = new BasicDBObject();
		
		BasicDBObject findobject = new BasicDBObject();
		
		

		ArrayList<String> a= new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			
			JSONObject another_json_object = user_json_array.getJSONObject(i);
			JSONObject another_addressjson_object = address_json_array.getJSONObject(i);
		
			
			findobject.put("_id", another_json_object.getString("id"));
			DBCursor findQuery = collection.find(findobject);
//			System.out.println("Ssss");
			if(findQuery.size()== 0){
				System.out.println("collection is empty so firstime insertion********");
				users.setId(another_json_object.getString("id"));
				users.setFirstname(another_json_object.getString("firstname"));
				users.setLastname(another_json_object.getString("lastname"));
				users.setAge(another_json_object.getInt("age"));
				users.setCity(another_addressjson_object.getString("city"));
				users.setState(another_addressjson_object.getString("state"));
				users.setZipcode(another_addressjson_object.getLong("zipcode"));
				
				
				
				arrays.add(another_json_object);
				document.put("_id", users.getId());
				document.put("firstname", users.getFirstname());
				document.put("lastname", users.getLastname());
				document.put("age", users.getAge());
				document.put("city", users.getCity());
				document.put("state", users.getState());
				document.put("zipcode",users.getZipcode());
				a.add(document.toString());
				collection.insert(document);
				System.out.println("BasicDBObject example..." + document);
				
//				userCache.loaduserCache(users.getId(), users.getFirstname(), users.getLastname(), users.getAge(),users.getCity(),users.getState(),users.getZipcode());
				retrivefrommongo(document.toString());
//				userCache.getUser(users.getId());
//				l.add(userCache.getUser(users.getId()));
				
               

	
			}
			else{
				
			while (findQuery.hasNext()) { 
			
				if(findQuery.next().get("_id").equals(another_json_object.getString("id"))){
//					ids.add(s);
					long startTime = System.currentTimeMillis();
					System.out.println("checking weather object is there in the cache or not"+another_json_object.getString("id")+"dddd");
//					l.add(userCache.getUser(another_json_object.getString("id").toString()));
//					checkUser(another_json_object.getString("id").toString());
					System.out.println(retrivefrommongo(document.toString()));
		               long finishTime = System.currentTimeMillis();
					long T = finishTime - startTime;
		               System.out.println("That took: " + (T) + " ms");
						L = T + L;
						System.out.println("Total Time: " + (L) + " ms");
				}
//				else{
//					
//					System.out.println("collection is not empty so inserting after 1st insertion********");
//					users.setId(another_json_object.getString("id"));
//					users.setFirstname(another_json_object.getString("firstname"));
//					users.setLastname(another_json_object.getString("lastname"));
//					users.setAge(another_json_object.getInt("age"));
//					users.setCity(another_addressjson_object.getString("city"));
//					users.setState(another_addressjson_object.getString("state"));
//					users.setZipcode(another_addressjson_object.getLong("zipcode"));
//					
//					
//					
//					arrays.add(another_json_object);
//					document.put("_id", users.getId());
//					document.put("firstname", users.getFirstname());
//					document.put("lastname", users.getLastname());
//					document.put("age", users.getAge());
//					document.put("city", users.getCity());
//					document.put("state", users.getState());
//					document.put("zipcode",users.getZipcode());
//					a.add(document.toString());
//					collection.insert(document);
//					System.out.println("BasicDBObject example..." + document);
//					userCache.loaduserCache(users.getId(), users.getFirstname(), users.getLastname(), users.getAge(),users.getCity(),users.getState(),users.getZipcode());
////					userCache.getUser(users.id);
////					System.out.println("ss");
////					l.add(userCache.getUser(users.id));
//					
//				}
			}
		}
									
	}

		client.close();
//		userCache.cacheImpl();
//		checkUser(s1);
		System.out.println(l+"jugal shah");
		return l.toString();
	}
	
	/*
	 * this method is getting the data from the cache.
	 * 
	 * */
	
	public void checkUser(String s) throws CacheException{
			
		System.out.println(userCache.getUser(s)+"**************************");
//		
		System.out.println("data comes from cache");
		
//		return s;
//	System.out.println(CacheUtil.checkUSer());
		
	}

	public String retrivefrommongo(String s) {
		System.out.print("SSss");
		s = s.substring(0, s.length() - 1);
		String starr[] = s.split(",");
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 1; i < starr.length; i++) {
			if (!starr[i].contains("$id")) {
				String keyValue[] = starr[i].split(":");
				map.put(keyValue[0], keyValue[1]);
				System.out.println(keyValue[0] + "," + keyValue[1]);
			} else {
				String keyValue[] = starr[i].split(":");
				map.put(keyValue[0], keyValue[2]);
			}
		}
		return map.toString();

	}
	

}
