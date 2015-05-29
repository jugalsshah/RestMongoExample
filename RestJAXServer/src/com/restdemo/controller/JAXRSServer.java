package com.restdemo.controller;
//package com.restdemo.service;
//
//import java.net.URI;
//import java.net.UnknownHostException;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.UriInfo;
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//import com.restdemo.model.User;
//
//@Path("/mongo")
//
//public class Userservice {
//
////	EntityManager entityManager;
//	@Context
//	private UriInfo uriInfo; 
//	@Produces({MediaType.APPLICATION_JSON })
//	@Consumes({MediaType.APPLICATION_JSON })
//    public Response getUser(User user) throws UnknownHostException {
////		try {
//			
////			String s= new MongoTest().insertData("demo", "userRecords", user)
//			Mongo client = new MongoClient("localhost", 27017);
//			
//			DB db= client.getDB("demo");
//			DBCollection collection = db.getCollection("userRecords");
//
//			// 1. BasicDBObject example
//			System.out.println("BasicDBObject example...");
//			BasicDBObject document = new BasicDBObject();
//			document.put("firstname", user.getFirstname());
//			document.put("lastname", user.getLastname());
//			document.put("age", user.getAge());
//			document.put("address", user.getAddress());
//			collection.insert(document);
//			System.out.println("BasicDBObject example..."+document);
//			
//			URI uri= uriInfo.getAbsolutePathBuilder().path(user.getFirstname()).build();
////			BasicDBObject searchQuery = new BasicDBObject();
////			searchQuery.get("name");
////		 
////			DBCursor cursor = collection.find(searchQuery);
////		 
////			while (cursor.hasNext()) {
////				System.out.println(cursor.next());
////			}
////		}
//		/*	
//		 catch (UnknownHostException e) {
//			System.out.println(e + "mesg");
//
//		}
//*/		return Response.created(uri).build();
//	}
//
////    @DELETE
////    @Path("{id}")
////    public Response deleteBook(@PathParam("id") String id) {
////          entityManager.remove(entityManager.find(Book.class, id));
////          return Response.noContent().build();
////    }
//
////    @GET
////    @Path("{id}")
////    public Response getBook(@PathParam("id") String id) {
////          User book = entityManager.find(Book.class, id);
////          if (book == null) {
////                 throw new NotFoundException();
////          }
////          return Response.ok(book).build();
////    }
////
////    @GET
////    public Books getBooks() {               
////          TypedQuery<Book> query = entityManager.createNamedQuery("Book.findAll",Book.class);
////          Books books=new Books(query.getResultList());
////          return books;
////          //return Response.ok(books).build();
////    }
//}
//
