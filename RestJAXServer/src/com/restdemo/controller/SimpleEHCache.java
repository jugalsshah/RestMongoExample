package com.restdemo.controller;

import java.io.InputStream;
//import java.lang.annotation.Annotation;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

//import javax.lang.model.element.AnnotationMirror;
//import javax.lang.model.element.Element;
//import javax.lang.model.element.ElementKind;
//import javax.lang.model.element.ElementVisitor;
//import javax.lang.model.element.Modifier;
//import javax.lang.model.element.Name;
//import javax.lang.model.type.TypeMirror;

import com.restdemo.bean.User;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class SimpleEHCache {

	private static final CacheManager cacheManager;
	
	static
    {
         
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("/ehcache.xml");
        cacheManager = CacheManager.create(resourceAsStream);
    };
	
    private Ehcache ehcache;
    public SimpleEHCache(){
    	
    	ehcache = cacheManager.getEhcache("users");
    }

    public boolean loaduserCache(String id, String fname, String lname, int age, String city, String state, long zipcode) throws CacheException{
//    	User usesrs= ;
    	addUser(id, new User(id, fname, lname, age, city, state, zipcode));
		return true;
    }
    public void addUser(String string, User user){
    	
    	Element element = new Element(string, user);
    	ehcache.put(element);
}
//    @SuppressWarnings("deprecation")
//	@SuppressWarnings("null")
	public User getUser(String id)
    {
        // Retrieve the element that contains the requested Employee
        Element element = (Element) ehcache.get(id);
        if (element != null)
        {
             
            return (User) element.getValue();
        }
         
        return null;
    }
}