package com.restdemo.controller;
//package com.restdemo.service;
//
//import org.apache.jcs.JCS;
//import org.apache.jcs.access.CacheAccess;
//
//import com.restdemo.model.User;
//	
//
//
//public class JCSCacheManager{
//	
//	private static JCSCacheManager instance;
//	private static int checkedOut = 0;
//    private static CacheAccess cache;
//	
//    
//    public JCSCacheManager(){
//    	
//    	
//    	try{
//    		cache=JCS.getInstance("empCache");
//    		
//    	}
//    	 catch (Exception e)
//         {
//             e.printStackTrace();
//    		 // Handle cache region initialization failure
//         }
//    }
//    
//    public static JCSCacheManager getInstance()
//    {
//        synchronized (JCSCacheManager.class)
//        {
//            if (instance == null)
//            {
//                instance = new JCSCacheManager();
//            }
//        }
//
//        synchronized (instance)
//        {
//            instance.checkedOut++;
//        }
//
//        return instance;
//    }
//    
//    
//    public User getUser(String id)
//    {
//        return getUser(id,true);
//    }
//
//    public User getUser(String id, boolean fromCache)
//    {
//        User user = null;
//
//        // First, if requested, attempt to load from cache
//
//        if (fromCache)
//        {
//            user = (User) cache.get(id);
//            System.out.println("retreive from cahce"+user);
//        }
//
//        // Either fromCache was false or the object was not found, so
//        // call loadBookVObj to create it
//
//        if (user == null)
//        {
//            user = loadUser(id);
//        }
//
//        return  user;
//    }
//
//    public User loadUser(String id)
//    {
//        User u= new User();
//
//        u.id = id;
//
//        try
//        {
//            boolean found = false;
//
//            // load the data and set the rest of the fields
//            // set found to true if it was found
//
//            found = true;
//
//            // cache the value object if found
//
//            if (found)
//            {
//                // could use the defaults like this
//                // bookCache.put( "BookVObj" + id, vObj );
//                // or specify special characteristics
//
//                // put to cache
//
//                cache.put(u.getId(), new User(u.getId(),u.getFirstname(),u.getLastname(),u.getAge(),u.getCity(),u.getState(),u.getZipcode()));
//                System.out.println("goes into cache"+u);
//            }
//
//        }
//        catch (Exception e)
//        {
//            // Handle failure putting object to cache
//        }
//
//        return u;
//    }
//    
////    public int storeUser(User user)
////    {
////        try
////        {
////            // since any cached data is no longer valid, we should
////            // remove the item from the cache if it an update.
////
////            if (user.id!=0)
////            {
////                cache.remove("BookVObj" + vObj.bookID);
////            }
////
////            // put the new object in the cache
////
////            cache.put("BookVObj" + id, vObj);
////        }
////        catch (Exception e)
////        {
////            // Handle failure removing object or putting object to cache.
////        }
////    }
//
//}