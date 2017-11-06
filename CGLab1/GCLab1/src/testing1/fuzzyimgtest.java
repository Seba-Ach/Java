package testing1;


import java.io.*; 
import java.awt.Color;
import java.awt.image.*; 
import java.awt.Color.*;

import javax.imageio.*; 

public class fuzzyimgtest
{ 
  public static void main(String[] args)  
  { 
     System.out.println("FUZZY BLEND OF JPG IMAGES pattern synthesis"); 
       
     
      int x_res, y_res;   // Image resolution 
      int  x_c, y_c;  	  // Ring center coordinates 
      int  i, j;   // Loop variables - indices of the current row and column 
      final int w = 10; // Fixed ring width 
     
      BufferedImage img=null, img2=null;
      File f=null,f2=null; 
      
      try{
          f = new File("view.jpg");
          img = ImageIO.read(f);
        }catch(IOException e){
          System.out.println(e);
        }
      try{
          f2 = new File("viewnormal.jpg");
          img2 = ImageIO.read(f2);
        }catch(IOException e){
          System.out.println(e);
        }
      
      x_res = img.getWidth(); // Get required image resolution from command line arguments 
      y_res = img.getHeight(); 
      
      x_c = x_res / 2; 		// Find coordinates of the image center 
      y_c = y_res / 2;
         
      for ( i = 0; i < y_res; i++) 
         for ( j = 0; j < x_res; j++)    
        { 
           double dist; 
           double r;
           
           
           
           dist = Math.sqrt( (360-y_c)*(360-y_c) + (j-x_c)*(j-x_c) );  //distance to center of img
         //  r =(int) (128*(Math.sin((Math.PI*dist)/(w*10))+1)); // Find the ring index
           r = (Math.sin((Math.PI*dist)/(w*10))+1);
           r=r/2;
           
           int clr1=img.getRGB(j, i);
           int clr2=img2.getRGB(j,i);
           
           Color c1 = new Color(img.getRGB(j, i));
           int c1red, c1green, c1blue;
           c1red=c1.getRed();
           c1green=c1.getGreen();
           c1blue=c1.getBlue();
           
           Color c2 = new Color(img2.getRGB(j, i));
           int c2red, c2green, c2blue;
           c2red=c2.getRed();
           c2green=c2.getGreen();
           c2blue=c2.getBlue();
           
           int fred, fgreen, fblue;
           
           fred=(int)(c1red+((c2red-c1red)*r));
           fgreen=(int)(c1green+((c2green-c1green)*r));
           fblue=(int)(c1blue+((c2blue-c1blue)*r));
           
           
           int rgbcol=int2RGB(fred,fgreen,fblue);
           if(j<350){
        	   img.setRGB(j,i,clr1);
           }
           else if(j>750){
        	   img.setRGB(j,i,clr2);
           }
           else{ 
           img.setRGB(j,i,rgbcol);
           }
       }   
   
       // Save the created image in a graphics file 
       try  
       { 
          ImageIO.write( img , "bmp", new File( args[0]) ); 
          System.out.println( "Ring image created successfully");   
       } 
       catch (IOException e) 
       { 
          System.out.println( "The image cannot be stored" );   
       } 
  }
 
  // This method assembles RGB color intensities into single  
  // packed integer. Arguments must be in <0..255> range 
  static int int2RGB( int red, int green, int blue) 
  { 
     // Make sure that color intensities are in 0..255 range  
     red   = red   & 0x000000FF; 
     green = green & 0x000000FF; 
     blue  = blue  & 0x000000FF; 
 
     // Assemble packed RGB using bit shift operations 
     return (red << 16) + (green << 8) + blue; 
  }   
} 

