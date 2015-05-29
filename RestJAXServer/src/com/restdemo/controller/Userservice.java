package com.restdemo.controller;

//import java.net.URI;
import java.io.BufferedReader;
//import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.net.UnknownHostException;
//import java.nio.file.Files;
import java.util.List;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;

import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Respon/se;

//import org.apache.commons.io.FileUtils;
import org.apache.jcs.access.exception.CacheException;
//import org.bson.types.ObjectId;
//import org.codehaus.jackson.JsonParseException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.type.TypeReference;
//import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.omg.CORBA.ARG_IN;
//import org.omg.CORBA.PUBLIC_MEMBER;

import com.restdemo.bean.User;
//import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;
//imposcrt com.sun.jersey.server.impl.model.method.dispatch.MultipartFormDispatchProvider;




@Path("/mongo")
@Produces({MediaType.APPLICATION_JSON })
@Consumes({MediaType.APPLICATION_JSON })
public class Userservice {

	
	@POST
	@Path("/post")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
    public List<User> getUser(@FormDataParam("file") InputStream uploadedInputStream,
    		                @FormDataParam("file2") InputStream uploadedInputStream1
    		                ) throws JSONException, CacheException{
    
		ParseJSON parseJSON = new ParseJSON();
		BufferedReader reader = new BufferedReader(new InputStreamReader(uploadedInputStream));
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(uploadedInputStream1));
		StringBuilder user= new StringBuilder();
		StringBuilder address= new StringBuilder();
		String line = null;
		String line1 = null;
		 try
	        {
            while ((line = reader.readLine()) != null)
            {
                    address.append(line + "\n");
            } 
            System.out.println(address.toString());
            while ((line1 = reader1.readLine()) != null)
            {
                    user.append(line1 + "\n");
            } 
            System.out.println(user.toString());

            parseJSON.insertJsontoDB(user, address);
            System.out.println("A");
                    }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		 return parseJSON.l;
      }
		

//
//@POST
//@Path("/postaddress")
//@Consumes(MediaType.APPLICATION_JSON)
//
//public String getUseraddress(InputStream s) throws JSONException, UnknownHostException, CacheException{
//
////	String s1 = null;
//	BufferedReader reader = new BufferedReader(new InputStreamReader(s));
//    StringBuilder sb1 = new StringBuilder();
//    ParseJSON pjson = new ParseJSON();
//    String line = null;
//    String retrivestring= new String();
//	 try
//        {
//        while ((line = reader.readLine()) != null)
//        {
//                sb1.append(line + "\n");
//        } 
//        s.close();
//        System.out.println(sb1.toString()+"sdsdsd");
//    }
//    catch (IOException e)
//    {
//        e.printStackTrace();
//    }	
//return sb1.toString();
//    }
}
	