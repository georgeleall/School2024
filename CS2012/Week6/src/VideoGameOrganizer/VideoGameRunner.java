package VideoGameOrganizer;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;


public class VideoGameRunner {
	
	public static void main(String []args) throws IOException {
		
		VideoGame[] videoGames = new VideoGame[1499];
		
		File myFile = new File("/Users/george/Documents/CS2012/Week6/src/VideoGameOrganizer/vgsales.csv");
		Scanner fileReader = new Scanner (myFile);
        Scanner keyboard = new Scanner(System.in);
        
        printMenu();

        fileReader.nextLine();

        int idx = 0;
        int limit = 1500;
        String selection;
        String choice;
        char command;
        int rFyear = 0;
        double rFNAsales = 0;
        double rFJPsales = 0;
        double rFEusales = 0;
        double rFGsales = 0;

        
        
        while(fileReader.hasNext() && limit > 0) {
            String[] rowFields = fileReader.nextLine().split(","); 
            String rFname = rowFields[1];
            String rFplat = rowFields[2];
            String rFgenre = rowFields[4];
            String rFpub = rowFields[5];       	
         	
            if (rowFields[3].equals("N/A") || !rowFields[3].matches("\\d+")) {
                rFyear = 0; 
            } else {
                rFyear = Integer.parseInt(rowFields[3]);
            }
            if(rowFields[6].equals("N/A")|| !rowFields[6].matches("\\d+")) {
            	rFNAsales = 0;
            }
            else {
            	rFNAsales = Double.parseDouble(rowFields[6]);
            }
            if(rowFields[7].equals("N/A")|| !rowFields[7].matches("\\d+")) {
            	rFJPsales = 0;
            }
            else {
            	rFJPsales = Double.parseDouble(rowFields[7]);
            }
            if(rowFields[8].equals("N/A")|| !rowFields[8].matches("\\d+")) {
            	rFEusales = 0;
            }
            else {
            	rFEusales = Double.parseDouble(rowFields[8]);
            }
            if(rowFields[9].equals("N/A")|| !rowFields[9].matches("\\d+")) {
            	rFGsales = 0;
            }
            else {
            	rFGsales = Double.parseDouble(rowFields[9]);
            }
            
            videoGames[idx] = new VideoGame(rFname,rFplat,rFyear,rFgenre, rFpub,rFNAsales,rFJPsales,rFEusales,rFGsales);
            
            
            idx++;
            limit--;
                                   
            }    

        do
        {
            choice = keyboard.next().toLowerCase();
            keyboard.nextLine();
            command = choice.charAt(0);
            double usernumber = 0;

            int counter = 0;
            switch (command)
             {
                  case 'a': 
                      System.out.println("Please type in a genre!");
                      selection = keyboard.nextLine();                      
 
                      if(selection.equalsIgnoreCase("Action")) {
                    	  FileWriter pwt = new FileWriter("Action.txt");
                      	for (int i = 0; i < videoGames.length; i++) {                     		
                  		 if(videoGames[i].getGenre().equalsIgnoreCase("Action")) {
                  			pwt.write(videoGames[i].getName() + "\n");
                  			 
                  			 counter++;
                  		 }
 
                  	 	}
                      	pwt.close();
                      	System.out.print(counter + " games were collected!");
                      }
                      
                      if(selection.equalsIgnoreCase("Shooter")) {
                    	  FileWriter pwt = new FileWriter("Shooter.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Shooter")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Fighting")) {
                    	  FileWriter pwt = new FileWriter("Fighting.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Fighting")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Adventure")) {
                    	  FileWriter pwt = new FileWriter("Adventure.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Adventure")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Racing")) {
                    	  FileWriter pwt = new FileWriter("Racing.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Racing")) {
                    			 pwt.write(videoGames[i].getName() + "\n");    
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Simulation")) {
                    	  FileWriter pwt = new FileWriter("Simulation.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Simulation")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Platform")) {
                    	  FileWriter pwt = new FileWriter("Platform.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Platform")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Role-Playing")) {
                    	  FileWriter pwt = new FileWriter("Role-Playing.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Role-Playing")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Puzzle")) {
                    	  FileWriter pwt = new FileWriter("PuzzleGames.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Puzzle")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Misc")) {
                    	  FileWriter pwt = new FileWriter("MiscGames.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Misc")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Strategy")) {
                    	  FileWriter pwt = new FileWriter("StrategyGames.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Strategy")) {
                    			 pwt.write(videoGames[i].getName() + "\n");;
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                      
                      if(selection.equalsIgnoreCase("Sports")) {
                          FileWriter pwt = new FileWriter("Sports.txt");
                        	for (int i = 0; i < videoGames.length; i++) {                     		
                    		 if(videoGames[i].getGenre().equalsIgnoreCase("Simulation")) {
                    			 pwt.write(videoGames[i].getName() + "\n");
                    			 
                    			 counter++;
                    		 }
   
                    	 	}
                        	pwt.close();
                        	System.out.print(counter + " games were collected!");
                        }
                       break;

                  case 'b': 
                       System.out.println("Please type in a Platform!");
                       selection = keyboard.nextLine();                      
                       
                       if(selection.equalsIgnoreCase("Wii")) {
                     	  FileWriter pwt = new FileWriter("Wii.txt");
                       	for (int i = 0; i < videoGames.length; i++) {                     		
                   		 if(videoGames[i].getPlatform().equalsIgnoreCase("Wii")) {
                   			pwt.write(videoGames[i].getName() + "\n");
                   			 
                   			 counter++;
                   		 }
  
                   	 	}
                       	pwt.close();
                       	System.out.print(counter + " games were collected!");
                       }
                       
                       if(selection.equalsIgnoreCase("NES")) {
                     	  FileWriter pwt = new FileWriter("NES.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("NES")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("GB")) {
                     	  FileWriter pwt = new FileWriter("GB.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("GB")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("DS")) {
                     	  FileWriter pwt = new FileWriter("DS.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("DS")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("X360")) {
                     	  FileWriter pwt = new FileWriter("X360.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("X360")) {
                     			 pwt.write(videoGames[i].getName() + "\n");    
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("PS3")) {
                     	  FileWriter pwt = new FileWriter("PS3.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("PS3")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("PS2")) {
                     	  FileWriter pwt = new FileWriter("PS2.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("PS2")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("SNES")) {
                     	  FileWriter pwt = new FileWriter("SNES.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("SNES")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("GBA")) {
                     	  FileWriter pwt = new FileWriter("GBA.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("GBA")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("3DS")) {
                     	  FileWriter pwt = new FileWriter("3DS.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("3DS")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("N64")) {
                     	  FileWriter pwt = new FileWriter("N64.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("N64")) {
                     			 pwt.write(videoGames[i].getName() + "\n");;
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("XB")) {
                           FileWriter pwt = new FileWriter("XB.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("XB")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("GC")) {
                           FileWriter pwt = new FileWriter("GC.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("GC")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("WiiU")) {
                           FileWriter pwt = new FileWriter("WiiU.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("WiiU")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("GEN")) {
                           FileWriter pwt = new FileWriter("GEN.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("GEN")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("PSP")) {
                           FileWriter pwt = new FileWriter("PSP.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("PSP")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                       
                       if(selection.equalsIgnoreCase("PC")) {
                           FileWriter pwt = new FileWriter("PC.txt");
                         	for (int i = 0; i < videoGames.length; i++) {                     		
                     		 if(videoGames[i].getPlatform().equalsIgnoreCase("PC")) {
                     			 pwt.write(videoGames[i].getName() + "\n");
                     			 
                     			 counter++;
                     		 }
    
                     	 	}
                         	pwt.close();
                         	System.out.print(counter + " games were collected!");
                         }
                        break;
                        
                  case 'c': 
                      System.out.println("Please type in a Publisher!");
                      selection = keyboard.nextLine(); 
                      
                        if(selection.equalsIgnoreCase("Nintendo")) {
                            FileWriter pwt = new FileWriter("Nintendo.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Nintendo")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Microsoft Game Studios")) {
                            FileWriter pwt = new FileWriter("Microsoft Game Studios.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Microsoft Game Studios")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Take-Two Interactive")) {
                            FileWriter pwt = new FileWriter("Take-Two Interactive.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Take-Two Interactive")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Sony Computer Entertainment")) {
                            FileWriter pwt = new FileWriter("Sony Computer Entertainment.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Sony Computer Entertainment")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Activision")) {
                            FileWriter pwt = new FileWriter("Activision.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Activision")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Electronic Arts")) {
                            FileWriter pwt = new FileWriter("Electronic Arts.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Electronic Arts")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Ubisoft")) {
                            FileWriter pwt = new FileWriter("Ubisoft.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Ubisoft")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Sega")) {
                            FileWriter pwt = new FileWriter("Sega.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Sega")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Konami Digital Entertainment")) {
                            FileWriter pwt = new FileWriter("Konami Digital Entertainment.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Konami Digital Entertainment")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Warner Bros. Interactive Entertainment")) {
                            FileWriter pwt = new FileWriter("Warner Bros. Interactive Entertainment.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Warner Bros. Interactive Entertainment")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Capcom")) {
                            FileWriter pwt = new FileWriter("Capcom.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Capcom")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("505 Games")) {
                            FileWriter pwt = new FileWriter("505 Games.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("505 Games")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("SquareSoft")) {
                            FileWriter pwt = new FileWriter("SquareSoft.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("SquareSoft")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Atari")) {
                            FileWriter pwt = new FileWriter("Atari.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Atari")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Bethesda Softworks")) {
                            FileWriter pwt = new FileWriter("Bethesda Softworks.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Bethesda Softworks")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Square Enix")) {
                            FileWriter pwt = new FileWriter("Square Enix.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Square Enix")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("GT Interactive")) {
                            FileWriter pwt = new FileWriter("GT Interactive.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("GT Interactive")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("LucasArts")) {
                            FileWriter pwt = new FileWriter("LucasArts.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("LucasArts")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                        
                        if(selection.equalsIgnoreCase("Eidos Interactive")) {
                            FileWriter pwt = new FileWriter("Eidos Interactive.txt");
                          	for (int i = 0; i < videoGames.length; i++) {                     		
                      		 if(videoGames[i].getPublisher().equalsIgnoreCase("Eidos Interactive")) {
                      			 pwt.write(videoGames[i].getName() + "\n");
                      			 
                      			 counter++;
                      		 }
     
                      	 	}
                          	pwt.close();
                          	System.out.print(counter + " games were collected!");
                          }
                         break;
                  case 'd': 
                  	   System.out.println("Please type in a Revenue!");
                         usernumber = keyboard.nextDouble(); 
                         FileWriter pwt = new FileWriter("GameRevenue.txt");
                       	for (int i = 0; i < videoGames.length; i++) { 
                       		if(videoGames[i].getNASales()+ videoGames[i].getJPNSales()+ 
                       		videoGames[i].getEuSales()+ videoGames[i].getGSales() <= usernumber) {
                       			pwt.write(videoGames[i].getName() + "\n");
                       			
                       			counter++;
                       		}
                       	}
                       	pwt.close();
                       	System.out.print(counter + " games were collected!");
                  	   break;
                  case '?':
                       printMenu();
                       break;
                  case 'q':
                       break;
                  default:
                  	  System.out.println("Invalid input!");
             }

         } while (command != 'q');
       
       keyboard.close();

     }
    
    public static void printMenu()
    {
    	System.out.println("Welcome, User! Please select an option below!");
     System.out.print("\nCommand Options\n"
                    + "-----------------------------------\n"
                    + "a: Generate a text file based on Genre!\n"
                    + "b: Generate a text file based on Platfrom!\n"
                    + "c: Generate a text file based on Publisher!\n"
                    + "d: Generate a text file based on Total Revenue!\n"
                    + "q: quit this program\n\n");

     }
    	
}
    
