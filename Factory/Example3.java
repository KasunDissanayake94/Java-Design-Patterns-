/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.factory;

interface Mammal{
    void drintMilk();
}

class Human implements Mammal{

    @Override
    public void drintMilk() {
        System.out.println("Human Drinking...");
    }
    
}
class Zeebra implements Mammal{

    @Override
    public void drintMilk() {
        System.out.println("Zeebra Drinking...");
    }
    
}
class Factory {
	
   //use getMammal method to get object of type Mammal 
   public Mammal getMammal(String mammalType){
      if(mammalType == null){
         return null;
      }		
      if(mammalType.equalsIgnoreCase("Human")){
         return new Human();
         
      } else if(mammalType.equalsIgnoreCase("Zeebra")){
         return new Zeebra();
         
      } 
      
      return null;
   }
}



public class Example3 {
    public static void main(String[] args) {
         Factory factory = new Factory();
         
         
         //get an object of Mammal 
      Mammal mammal1 = factory.getMammal("Human");

      //call  drintMilk method of Human
      mammal1.drintMilk();
      
      //get an object of Mammal 
      Mammal mammal2 = factory.getMammal("Zeebra");

      //call  drintMilk method of Human
      mammal2.drintMilk();
    }
    
}
