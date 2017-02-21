/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;



/**
 *
 * @author 14034305
 */
public class Books extends Publication{
    private String Author;

    
    
    public Books(){
    }
        public Books(String Author, String title, double price, int copies){
            super(title,price,copies);
            this.Author = Author;
        }
        public void orderCopies(int numCopies){            
        }
        
        @Override
        public String toString(){
            String b = "";
            b +=
             "\nAuthor " + getAuthor();
            return b;
        }

    /**
     * @return the Author
     */
    public String getAuthor() {
        return Author;
    }

    /**
     * @param Author the Author to set
     */
    public void setAuthor(String Author) {
        this.Author = Author;
    }
                
            
        
    }

