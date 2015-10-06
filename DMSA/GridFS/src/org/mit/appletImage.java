package org.mit;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class appletImage extends Applet{
	
	Image img;
	File temp;
	MediaTracker tr;
	
	public void init(){
		try{
			Mongo mongo = new Mongo("localhost",27017);
			DB db = mongo.getDB("ImageData");
			
			File file = new File("/home/student/test.jpg");
			GridFS gridfs = new GridFS(db, "downloads");
			GridFSInputFile gfsfile = gridfs.createFile(file);
			gfsfile.setFilename("destfile");
			gfsfile.save();
			GridFSDBFile outfile = gridfs.findOne(gfsfile.getFilename());
			System.out.println("outfile"+outfile);
			temp = File.createTempFile("tempfile", ".tmp");
			   System.out.println("tempfile:"+temp.getPath());
			   outfile.writeTo(temp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g) {
		   
		  
	      tr = new MediaTracker(this);
	      img = getImage(getCodeBase(), temp.getPath());
	    
	      tr.addImage(img,0);
	      g.drawImage(img,50,50, 100,100,this);
	  
	   }
	

}
