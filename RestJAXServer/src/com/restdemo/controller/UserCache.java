package com.restdemo.controller;

//import java.awt.List;
import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;

import org.apache.jcs.JCS;
import org.apache.jcs.access.CacheAccess;
import org.apache.jcs.access.exception.CacheException;
import org.apache.jcs.engine.control.CompositeCacheManager;

import com.restdemo.bean.User;

public class UserCache {
	
	
	
	private CacheAccess cache;	
//	UserCache userCache;
	User user=new User();
	ArrayList<User> list= new ArrayList<>();
	
	//	CompositeCacheManager ccm = CompositeCacheManager.getUnconfiguredInstance();
//	Properties props = new Properties();
	
	
//	@SuppressWarnings("static-access")
//	public UserCache(){
//		try{
//			
//			//load cache
//			cache=JCS.getInstance("empCache");
////			CompositeCacheManager.getInstance("empCache");		
//			cache.put(user.getId(), new User(user.getId(),user.getFirstname(),user.getLastname(),user.getAge(),user.getCity(),user.getState(),user.getZipcode()));
//			
//		}
//		catch(CacheException e){
//			
//			e.printStackTrace();
//		}
////		
////		
//	}
	
	public boolean loaduserCache(String id, String fname, String lname, int age, String city, String state, long zipcode) throws CacheException{
	User users= new User(id, fname, lname, age, city, state, zipcode);
	try{
		cache=JCS.getInstance("empCache");
		addUser(id, users);
		
//		System.out.println(id+"="+fname);
//		cache.put(id, users);
		return true;
	}
		catch (CacheException ce) {
    return false;
  }
}
	
	
	public void cacheImpl(){
		
		CompositeCacheManager.getInstance().shutDown();
		
	}
	
	/*
	 *Simply adding the user in to cache. 
	 * */
	
	public void addUser(String id,User u){
	try{
//		cache=JCS.getInstance("empCache");
		cache.put(u.getId(), u);
//		System.out.println(u.getId()+"="+u.getFirstname());
		
	}
	catch( CacheException e )
    {
      e.printStackTrace();
    }
}
	
/*
		You can get user detail by doing below action or toString() method in the user class.
		If you use toString() method then you only need to do is to return User cache.get(id);

*/

public User getUser(String id) throws CacheException{
//	User us= null;
	
	
		cache=JCS.getInstance("empCache");
		User us= (User) cache.get(id);
		if(us!= null){
//			us= getUser(id);
			this.loaduserCache(us.getId(), us.getFirstname(), us.getLastname(), us.getAge(), us.getCity(), us.getState(), us.getZipcode());
//			System.out.println(us.getId()+ us.getFirstname()+us.getLastname()+ us.getAge()+ us.getCity()+ us.getState()+ us.getZipcode()+"**************");
		}
	

	return us;
}

public void removeUser(String id) throws CacheException{
		try{
		cache.remove(user.getId());
		}
	catch( CacheException e )
    {
      e.printStackTrace();
    } 
}

}






//props.put("jcs.default","DC");
//props.put("jcs.default.cacheattributes","org.apache.jcs.engine.CompositeCacheAttributes");
//props.put("jcs.default.cacheattributes.MaxObjects",1000);
//props.put("jcs.default.cacheattributes.MemoryCacheName","org.apache.jcs.engine.memory.lru.LRUMemoryCache");
//props.put("jcs.default.cacheattributes.UseMemoryShrinker","false");
//props.put("jcs.default.cacheattributes.MaxMemoryIdleTimeSeconds",36000);
//props.put("jcs.default.cacheattributes.ShrinkerIntervalSeconds",600);
//props.put("jcs.default.elementattributes","org.apache.jcs.engine.ElementAttributes");
//props.put("jcs.default.elementattributes.IsEternal","false");
//props.put("jcs.default.elementattributes.MaxLifeSeconds",210000);
//props.put("jcs.default.elementattributes.IdleTime",16800);
//props.put("jcs.default.elementattributes.IsSpool","true");
//props.put("jcs.default.elementattributes.IsRemote","true");
//props.put("jcs.default.elementattributes.IsLateral","true");
//
//
//
//props.put("jcs.region.empCache","DC");
//props.put("jcs.region.empCache.cacheattributes","org.apache.jcs.engine.CompositeCacheAttributes");
//props.put("jcs.region.empCache.cacheattributes.MemoryCacheName","org.apache.jcs.engine.memory.lru.LRUMemoryCache");
//props.put("jcs.region.empCache.cacheattributes.UseMemoryShrinker",2000);
//props.put("jcs.region.empCache.cacheattributes.MaxObjects",1000);
//props.put("jcs.region.empCache.cacheattributes.MaxMemoryIdleTimeSeconds",36000);
//props.put("jcs.region.empCache.cacheattributes.ShrinkerIntervalSeconds",600);
//props.put("jcs.region.empCache.cacheattributes.MaxSpoolPerRun",1000);
//props.put("jcs.region.empCache.elementattributes","org.apache.jcs.engine.ElementAttributes");
//props.put("jcs.region.empCache.elementattributes.IsEternal","false");
//
//
//
//
//props.put("jcs.auxiliary.DISK_REGION","org.apache.jcs.auxiliary.disk.indexed.IndexedDiskCacheFactory");
//props.put("jcs.auxiliary.DISK_REGION.attributes","org.apache.jcs.auxiliary.disk.indexed.IndexedDiskCacheAttributes");
//props.put("jcs.auxiliary.DISK_REGION.attributes.DiskPath","C:/JCS");
//props.put("jcs.auxiliary.DISK_REGION.attributes.MaxPurgatorySize",1000);
//props.put("jcs.auxiliary.DISK_REGION.attributes.MaxKeySize",1000);
//props.put("jcs.auxiliary.DISK_REGION.attributes.OptimizeAtRemoveCount",300000);
//props.put("jcs.auxiliary.DISK_REGION.attributes.MaxRecycleBinSize",7500);
//props.put("jcs.auxiliary.DC..attributes.ShutdownSpoolTimeLimi",60);
//