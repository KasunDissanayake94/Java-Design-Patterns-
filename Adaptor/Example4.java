/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.adapter;

interface English {
   public void doActivity(String activity, String language);
}

interface German {	
   public void talkGerman(String language);
   public void writeGerman(String language);
}



class Talk implements German{

    @Override
    public void talkGerman(String language) {
        System.out.println("Talking language : "+language);
    }

    @Override
    public void writeGerman(String language) {
        //do nothing
    }
   
}
class Write implements German{

    @Override
    public void talkGerman(String language) {
        //do nothing
    }

    @Override
    public void writeGerman(String language) {
        System.out.println("Writing language : "+language);
    }
}


class LanguageAdapter implements English {

   German german;

   public LanguageAdapter(String activity){
   
      if(activity.equalsIgnoreCase("talk") ){
         german = new Talk();			
         
      }else if (activity.equalsIgnoreCase("write")){
         german = new Write();
      }	
   }

   @Override
   public void doActivity(String activity, String language) {
   
      if(activity.equalsIgnoreCase("talk")){
         german.talkGerman(language);
      }
      else if(activity.equalsIgnoreCase("write")){
         german.writeGerman(language);
      }
   }
}


class Englishman implements English {
   LanguageAdapter languageAdapter;   

    @Override
    public void doActivity(String activity, String language) {
        //inbuilt support to play mp3 music files
      if(language.equalsIgnoreCase("English") && activity.equalsIgnoreCase("talk") ){
         System.out.println("Talking language : " + language);			
      }else if(language.equalsIgnoreCase("english") && activity.equalsIgnoreCase("write")){
          System.out.println("Writing language : " + language);
          
      }else if(language.equalsIgnoreCase("German")){
         languageAdapter = new LanguageAdapter(activity);
         languageAdapter.doActivity(activity, language);
      }
      else{
         System.out.println("Cannot write or talk "+language);
      }
    }
}
public class Example4 {
    public static void main(String[] args) {
        Englishman englishman = new Englishman();

      englishman.doActivity("talk", "English");
      englishman.doActivity("write", "English");
      englishman.doActivity("talk", "Sinhala");
      englishman.doActivity("talk", "German");
      englishman.doActivity("write", "German");
      
    }
    
}
