package com.alexis.annuaire;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneBook{
    
    // Constante globale d'environnement 
    public static final String PHONE_BOOK_FILE_PATH = "/Users/fkahope/Java/annuaire/phonebook.txt";
    public static Scanner sc = null;
    public static void main(String[] args) {
        
        sc = new Scanner(System.in);

        String userLastName     = getUserInput("Entrez un nom de famille : ");
        String userFirstName    = getUserInput("Entrez un prénom : ");
        String userPhoneNumber  = getUserInput("Entrez un numéro de telephone : ");

         Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);
      
         System.out.println(newContact.toString());

        File phoneBookFile = getOrCreatePhoneBookFile(PHONE_BOOK_FILE_PATH);
        appendContactToPhoneBook( phoneBookFile,newContact);

        sc.close();// Certains type d'objet qui vont avoir des problemes de mémoire vive et va consommer cette mémoire, il faut donc le fermer via cette méthode 
    }


    public static String getUserInput(String userRequest){
        
        System.out.println(userRequest);
        return sc.nextLine(); // La méthode permet de demander au scanner d'ouvrir les inputs pour que l'utilisateur entre qlq chose et qu'elle passe à la ligne suivante  

    }

    public static File getOrCreatePhoneBookFile(String phoneBookFilePath){
        
        File phoneBookFile = new File(phoneBookFilePath);

        if(phoneBookFile.exists()){
            return phoneBookFile;
        }

        try{

            phoneBookFile.createNewFile();
            System.out.print("le fichier a été crée (" + phoneBookFilePath + ")");
            return phoneBookFile;

        }catch(IOException e){

            e.printStackTrace();
        }

    return null;
    }

    public static void appendContactToPhoneBook(File phoneBookFile,Contact newContact){

        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(phoneBookFile, true))) { // TO DO : use try with resources
            fileWriter.append(newContact.toString() + '\n');
            System.out.println("Contact ajouté");
        }catch(IOException e){
            e.printStackTrace();
        }
       
    }
}