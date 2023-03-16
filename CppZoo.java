import java.time.LocalDateTime;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CppZoo
{
    static String[] hyenaNames = {"Shenzi", "Banzai", "Ed", "Zig", "Bud", "Lou", "Kamari", "Wema", "Nne", "Madoa", "Prince Nevarah"};
    static String[] lionNames = {"Scar", "Mufasa", "Simba", "Kiara", "King", "Drooper", "Kimba", "Nala", "Leo", "Samson", "Elsa", "Cecil"};
    static String[] bearNames = {"Yogi", "Smokey", "Paddington", "Lippy", "Bungle", "Baloo", "Rupert", "Winnie the Pooh", "Snuggles", "Bert"};
    static String[] tigerNames = {"Tony", "Tigger", "Amber", "Cosimia", "Cuddles", "Dave", "Jiba", "Rajah", "Rayas", "Ryker"};
    

    public static String genBirthDay(int age, String birthSeason){
        Random random = new Random();
        int birthYear = 2023 - age;
        int birthMonth = 0;
        int birthDay = 0;
        
        if(birthSeason.equals("spring")){
            birthMonth = 3 + random.nextInt(3);
            birthDay = 1 + random.nextInt(30);
        }else if(birthSeason.equals("summer")){
            birthMonth = 5 + random.nextInt(3);
            birthDay = 1 + random.nextInt(30);
        }else if(birthSeason.equals("spring")){
            birthMonth = 8 + random.nextInt(3);
            birthDay = 1 + random.nextInt(30);
        }else if(birthSeason.equals("spring")){
            birthMonth = 11 + random.nextInt(2);
            birthDay = 1 + random.nextInt(30);
        }else{
            birthMonth = random.nextInt(12) + 1;
            birthDay = random.nextInt(30) + 1;
        }
        
        if(birthMonth == 2 && (birthDay == 29 || birthDay == 30)){
            birthDay = 28;
        }
        
        LocalDate birthdate = LocalDate.of(birthYear, birthMonth, birthDay);
        return birthdate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }
    
    public static String genGetDay(){
        LocalDate getDate = java.time.LocalDate.now();
        return getDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }
    
    public static String genUAnimalID(String species, int counter){
        return species.substring(0,2) + "0" + counter;
    }

    public static String genAnimalName(String[] names) {
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
    
    /**
     * Constructor for objects of class Test
     */
    public CppZoo()
    {
        
    }
    
    public static void main(){
        try{
            processAnimals();   
        }
        catch(IOException e){
            
        }
    }
    
    public static void processAnimals() throws IOException{
        String[] hyenaHabitat = new String[4];
        String[] lionHabitat = new String[4];
        String[] bearHabitat = new String[4];
        String[] tigerHabitat = new String[4];
        
        File inputFile = new File("arrivingAnimals.txt");
        Scanner scanner = new Scanner(inputFile);
        
        int hyenaCounter = 1;
        int lionCounter = 1;
        int bearCounter = 1;
        int tigerCounter = 1;
        String uniqueID = "";

        // Open the output file
        FileWriter writer = new FileWriter("zooPopulation.txt");
        
        writer.write("Midterm Program Output; by Caleb Bergen, Spring 2023, Fresno, CA\n\n");
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            

            // Parse the animal data from the line
            String[] data = line.split(", ");
            String[] ageData = data[0].split(" ");
            int age = Integer.parseInt(ageData[0]);
            String sex = ageData[3];
            String species = ageData[4];
            String birthSeason = "unknown";
            String animalName = "";
            if (ageData.length == 6) {
                birthSeason = ageData[5];
            }
            String color = data[2];
            int weight = Integer.parseInt(data[3].split(" ")[0]);
            String origin = data[4];

            // Generate a birthday for the animal
            // String birthdate = genBirthDay(age, birthSeason);

            String birthdate = genBirthDay(age, birthSeason);
            String getDay = genGetDay();
            
            // Generate a unique ID for the animal
            if(species.equals("hyena")){
                uniqueID = genUAnimalID(species, hyenaCounter);
                hyenaCounter++;
                animalName = genAnimalName(hyenaNames);
                hyenaHabitat[hyenaCounter - 2] = uniqueID + "; " + animalName + "; " + age + " years old; birth date " + birthdate + "; " + color + "; " + sex + "; " + weight + " pounds; " + origin + "; arrived " + getDay + "\n";

                }
            if(species.equals("lion")){
                uniqueID = genUAnimalID(species, lionCounter);
                lionCounter++;
                animalName = genAnimalName(lionNames);
                lionHabitat[lionCounter - 2] = uniqueID + "; " + animalName + "; " + age + " years old; birth date " + birthdate + "; " + color + "; " + sex + "; " + weight + " pounds; " + origin + "; arrived " + getDay + "\n";

                }
            if(species.equals("bear")){
                uniqueID = genUAnimalID(species, bearCounter);
                bearCounter++;
                animalName = genAnimalName(bearNames);
                bearHabitat[bearCounter - 2] = uniqueID + "; " + animalName + "; " + age + " years old; birth date " + birthdate + "; " + color + "; " + sex + "; " + weight + " pounds; " + origin + "; arrived " + getDay + "\n";

            }
            if(species.equals("tiger")){
                uniqueID = genUAnimalID(species, tigerCounter);
                tigerCounter++;
                animalName = genAnimalName(tigerNames);
                tigerHabitat[tigerCounter - 2] = uniqueID + "; " + animalName + "; " + age + " years old; birth date " + birthdate + "; " + color + "; " + sex + "; " + weight + " pounds; " + origin + "; arrived " + getDay + "\n";

            }

            // Generate a name for the animal
            

            // Assign the animal to a habitat
            // String habitat = genZooHabitats(species);

            // Output the animal data to the output file
            // writer.write(habitat + ":\n");
            // writer.write(uniqueID + "; " + animalName + "; " + age + " years old; birth date " + birthdate + "; " + color + "; " + sex + "; " + weight + " pounds; from " + origin + "; arrived " + getCurrentDate() + "\n");
            // writer.write(uniqueID + "; " + animalName + "; " + age + " years old; birth date " + birthdate + "; " + color + "; " + sex + "; " + weight + " pounds; " + origin + "; arrived " + getDay + "\n");
            
        }
        writer.write("\n\nHyena Habitat:\n\n");
        for(int i = 0; i < hyenaHabitat.length; i++){
            writer.write(hyenaHabitat[i]);
        }
        
        writer.write("\n\nLion Habitat:\n\n");
        for(int i = 0; i < lionHabitat.length; i++){
            writer.write(lionHabitat[i]);
        }
        
        writer.write("\n\nBear Habitat:\n\n");
        for(int i = 0; i < bearHabitat.length; i++){
            writer.write(bearHabitat[i]);
        }
        
        writer.write("\n\nTiger Habitat:\n\n");
        for(int i = 0; i < tigerHabitat.length; i++){
            writer.write(tigerHabitat[i]);
        }
        
        writer.close();
    }
}
