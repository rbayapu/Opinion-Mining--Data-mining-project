import java.lang.Math;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;
import java.net.*;
import java.io.*;
 
public class Csv {
 
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName="example.csv";
		//String fileName="training_dataSet.csv";

		String[] data=new String[1000];
		String s,t,p,q,m;
		int j=1,y1=1,y11=0,z=0;
		String[][] multi=new String[1000][50];
		String[][] table=new String[5000][4];
		
		 
		 table[0][0] = "Keyword";  
		 table[0][1] = "Excellent";
		 table[0][2] = "Poor";
	     table[0][3] = "Value";
	//	System.out.println("we will list the contents of array here:\n");
		try {
			
					
			BufferedReader br = new BufferedReader( new FileReader(fileName));
			String strLine = null;
			StringTokenizer st = null, x = null, y=null, y21=null;
			int lineNumber = 0, tokenNumber = 0;
 
 // Applying preprocessing steps to remove unwanted symbols, missing values here
 // Retriving the Twitter dataset and storing them in array along with applying the preprocessing steps such as data cleaning.
			
			while( (fileName = br.readLine()) != null)
				{
					lineNumber++;
 
					//break comma separated line using ";"
					st = new StringTokenizer(fileName, ";");
 
					while(st.hasMoreTokens())
					{
						//display csv values
						tokenNumber++;
				 		s = st.nextToken();
						//System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber + ", Token : "+ s);
						if(tokenNumber == 6)
						{
							//data[lineNumber]=s;		
							z = s.length();
							m = s.substring(2,z-2);
							//System.out.println(m);
							data[lineNumber]=m;
					
					
						}

					}
 
					//reset token number
					tokenNumber = 0;
 	
				}
		


				/*		System.out.println("The string array consists of:\n");
			
						for(int i=1;i<lineNumber;i++)	
						System.out.println("\n"+data[i]);	
*/
					for(int i=1;i<=lineNumber;i++)
					{
						x = new StringTokenizer(data[i]);
    						//	System.out.println("The total no. of tokens generated for line "+i+"is: " + x.countTokens());
    						while(x.hasMoreTokens())
						{
      					
							t=x.nextToken();
							//System.out.println(t);
							multi[i][j]=t;  // creating an array of individual words
							j++;
						}
						j=1;
					}
						//	System.out.println(multi[23][2].charAt(0));
						//	System.out.println(multi[1].length);
	
	/*					FileWriter fresult = new FileWriter("result1.txt");
       			 		BufferedWriter bresult = new BufferedWriter(fresult);
					// displaying the contents of array
						for(int i=1; i<24;i++)
						{
						System.out.println("\nThe contents of record:"+i+" is\n");
						for(int k=1 ; k<multi[i].length;k++)
						{
						if(multi[i][k] == null)
						continue;
						else
						System.out.println(multi[i][k]);
						
						bresult.write(multi[i][k]);
						bresult.write("\r\n");
						
						}
						//if(multi[i] == null)		
						//break;
						} 

							bresult.close();
*/
		


						for(int c=1; c<multi.length;c++)
						{
							//	System.out.println("\nThe contents of record:"+c+" is\n");
							for(int d=1 ; d<multi[c].length;d++)
							{
								if(multi[c][d] == null || multi[c][d].charAt(0) == '@' || multi[c][d].charAt(0) == '#')
								continue;
								else
								{
								//	System.out.println(multi[c][d]);
						




				// creating a connection to web.
	
 

                        
		//Searching the results in google for excellent condition and storing them in a file

									URL url = new URL("http://www.google.com/search?q=excellent+"+ multi[c][d]);
                       							URL url1 = new URL("http://www.google.com/search?q=poor+"+ multi[c][d]);
                       							
									 URLConnection conn =  url.openConnection();
									URLConnection conn1 =  url1.openConnection();
                       							
									 conn.setRequestProperty("User-Agent","Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
                       						 									 
									BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        						String str;
									int a=0;
                        						// Create file 
   									 FileWriter fstream = new FileWriter("out.txt");
       			 						BufferedWriter out = new BufferedWriter(fstream);


									while ((str = in.readLine()) != null) {
                             						//  System.out.println(str);
				

    									out.write(str);
   

									a=a+1;
                        

									}

                        						in.close();
									out.close();

		// Searching the results in google for poor condition and storing them in a file
									 conn1.setRequestProperty("User-Agent","Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.8.1.6) Gecko/20070723 Iceweasel/2.0.0.6 (Debian-2.0.0.6-0etch1)");
                       						 									 
									BufferedReader in2 = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
                        						String str2;
									
                        						// Create file 
   									 FileWriter fstream2 = new FileWriter("out1.txt");
       			 						BufferedWriter out2 = new BufferedWriter(fstream2);


									while ((str2 = in2.readLine()) != null) {
                             						//  System.out.println(str2);
				

    									out2.write(str2);
   

									
                        

									}

                        						in2.close();
									out2.close();
								

		//Getting the search number of excellent condition and storing in array


									// Open the file that is the first 
    									// command line parameter
    									FileInputStream fstream1 = new FileInputStream("out.txt");
    									// Get the object of DataInputStream
    									DataInputStream in1 = new DataInputStream(fstream1);
        								BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
    									String strLine1,h,l;
										int i=0,b=0,k=0;
    									//Read File Line By Line
    									while ((strLine1 = br1.readLine()) != null)   
									{
      										// Print the content on the console
      										//System.out.println (strLine1);
										b=strLine1.contains("About") ? 1:0;
										k=strLine1.indexOf("About");
										i++;
										//if(b==1)
										//System.out.println("contains");    
		
										//System.out.println("index of About is "+k); 	
										//String h;
										h = strLine1.substring(k+6,k+18);
	
										y = new StringTokenizer(h, " ");
										h = y.nextToken();
			
										l = multi[c][d];
										y11 = y1;
										table[y1][0] = l;
										table[y1][1] = h.replaceAll("\\D", "");
										y1++;
			
				
										//System.out.println("\n results of:"+multi[c][d]+" are:"); 
				
										//System.out.println(h);
										//System.out.println(strLine1.substring(k+6,k+18)); 
									}
    									//System.out.println("\n\n\nno of lines in a file are:"+i);
	
									//Close the input stream
    									in.close();
									//System.out.println("Table conatins:"+ table[c][0]);




		//Getting the search number of poor condition and storing in array


									// Open the file that is the first 
    									// command line parameter
    									FileInputStream fstream21 = new FileInputStream("out1.txt");
    									// Get the object of DataInputStream
    									DataInputStream in21 = new DataInputStream(fstream21);
        								BufferedReader br21 = new BufferedReader(new InputStreamReader(in21));
    									String strLine21,h21,l21;
									int i21=0,b21=0,k21=0;
    									//Read File Line By Line
    									while ((strLine21 = br21.readLine()) != null)   
									{
      										// Print the content on the console
      										//System.out.println (strLine1);
										b21=strLine21.contains("About") ? 1:0;
										k21=strLine21.indexOf("About");
										i21++;
										//if(b21==1)
										//System.out.println("contains");    
		
										//System.out.println("index of About is "+k21); 	
										//String h;
										h21 = strLine21.substring(k21+6,k21+18);
	
										y21 = new StringTokenizer(h21, " ");
										h21 = y21.nextToken();
			
										l21 = multi[c][d];
				
										//System.out.println(h21);
										table[y11][2] = h21.replaceAll("\\D", "");
										//y21++;
			
				
										//System.out.println("\n results of:"+multi[c][d]+" are:"); 
				
										//System.out.println(h);
										//System.out.println(strLine1.substring(k+6,k+18)); 
									}
    									//System.out.println("\n\n\nno of lines in a file are:"+i);
	
									//Close the input stream
    									in.close();
									//System.out.println("Table conatins:"+ table[c][0]);





               							 }
                
							}
						}
						//if(multi[i] == null)		
						//break;
		
										
										
										FileWriter fresult = new FileWriter("result.txt");
       			 						BufferedWriter bresult = new BufferedWriter(fresult);

				
				System.out.println("\nThe contents of table are:\n\n\n");
				
				for(int ab=0;ab<table.length;ab++)
					{
					if (table[ab+1][0]==null || table[ab+1][0].length() == 0)
						{
						break;
						}
					else{
						p = new String(table[ab+1][1]);
						q = new String(table[ab+1][2]);
						int i5=1, i6=1;
						   
							for (int i2 = 0; i2 < p.length(); i2++) {

							//If we find a non-digit character we return false.
							 if (!Character.isDigit(p.charAt(i2)))
								{i5 = 0;
									break;}
								 }
							for (int i2 = 0; i2 < q.length(); i2++) {

							//If we find a non-digit character we return false.
							 if (!Character.isDigit(q.charAt(i2)))
								{i6 = 0;
									break;}
								 }
							
						if(i5 == 0 || i6 == 0)
						{
							table[ab+1][3] = Integer.toString(i5);
						}

							 
						else
						{

						int e= Integer.parseInt(p);
						int f= Integer.parseInt(q);
					
						table[ab+1][3] = Integer.toString(e-f);
						for(int bc=0;bc<4;bc++)
					
						{
    						bresult.write(table[ab][bc]);
							bresult.write(" ");
					
							System.out.print(table[ab][bc]+"     ");
						}
							System.out.println("\n"); 
							bresult.write("\r\n");
						}
					}
					}
				bresult.close();
	
		} //end of try block


			
		//System.out.println("Table conatins:"+ table[1][2]);
			


 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		catch (NumberFormatException e) {
			e.printStackTrace();
			}
		//catch (MalformedURLException e) {}
                //catch (IOException e) {}
        
	}
 
}









                
