package main;

import java.util.ArrayList;

public class Indicted {
    
    private String name;
    private String lastName;
    private String identification;   
    private String gender;
    private int age;
    private ArrayList<CriminalRecord> criminalRecordList;
    
    public static final String FEMALE = "Female";
    public static final String MALE = "Male";
    public static final int ADULT = 18;
    public static final int MINIMAL_AGE = 5;

    public Indicted(String name, String lastName, String id, String gender, int age){
        this.name = name;
        this.lastName = lastName;
        this.identification = id;
        this.gender = gender;
        this.age = age;
        this.criminalRecordList = new ArrayList<CriminalRecord>();
    }
    
    public void addCriminalRecord(int crimeId, String type, String description){
        boolean isThereADouble = false;
        for (CriminalRecord crime : this.criminalRecordList){
            if(crime.getIdentifier() == crimeId){
                isThereADouble = true;
                break;
            }
        }
        if(isThereADouble == false){
            this.criminalRecordList.add(new CriminalRecord(crimeId, type, description));
        }
    }
    
    public CriminalRecord findCriminalRecord(int crimeId){
        if (!this.criminalRecordList.isEmpty()){
            for (CriminalRecord record : criminalRecordList){
                if(record.getIdentifier() == crimeId){
                    return record;
                }
            }
        }
        return null;
        //Colocar un error si buscan un crimen que no ha sucedido.
    }
    
    public int getAge(){
        return this.age;
    }
    
    public ArrayList<CriminalRecord> getCriminalRecord(){
        return this.criminalRecordList;
    }
    
    public int getCriminalRecordQuantity(){
        return this.getCriminalRecord().size();
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public String getIdentification(){
        return this.identification;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getYearsOfSentence(){
        int yearsOfSentence = 0;
        for (CriminalRecord record : criminalRecordList){
            yearsOfSentence += record.getYearSentence();
        }
        return yearsOfSentence;
    }
    
    public boolean haveCriminalRecordType(String type){
        for (CriminalRecord record : criminalRecordList){
            if (record.getType().equalsIgnoreCase(type)){
                return true;
            }
            break;
        }
        return false;
    }
    
    public boolean isAdult(){
        if (this.age >= ADULT){
            return true;
        }
        return false;
    }
    
    public void removeCriminalRecord(int crimeId){
        if (!this.criminalRecordList.isEmpty()){
            int index = -1;
            for (CriminalRecord record : criminalRecordList){
                if (record.getIdentifier()==crimeId){
                    index = criminalRecordList.indexOf(record);
                    break;
                }
            }
            if(index != -1){
                String crimeSeverity = criminalRecordList.get(index).getSeverity();
                if (crimeSeverity != null){
                    if (crimeSeverity.equalsIgnoreCase("Slight")){
                        criminalRecordList.remove(index);
                    }
                }
            }
        }
    //Aunque no produce un error, es ilógico remover un crimen que no existe.
    //Si se tipea el tipo de crimen mal, el sistema no lo reconocera como de severidad Slight, por lo que no lo eliminará.
    //Suponga que en vez de Kidnapping coloque Kidnappin. El sistema le asigna una severity de "null". No lo elimina.
    }
    
    public void sentenceIndicted(int crimeId, int sentence){
        if (!this.isAdult()){
            System.out.println("ERROR JOVEN");
            //Reportar error
            //Mirar si hay necesidad de colocar 0 en la sentencia.
        }else{
            for (CriminalRecord record : criminalRecordList){
                if (record.getIdentifier()==crimeId){
                    String sevs = record.getSeverity();
                    if(sevs == null){
                        //Reportar error sobre mala digitación.
                    }else{
                        if (sevs.equalsIgnoreCase("Slight")){
                            if(sentence >= 1 && sentence <= 5){
                                record.changeSentence(sentence);
                            }else{
                                System.out.println("ERROR");
                                //Reportar error
                            }
                        }
                        if (sevs.equalsIgnoreCase("Serious")){
                            if(sentence >= 6 && sentence <= 15){
                                record.changeSentence(sentence);
                            }else{
                                System.out.println("ERROR");
                                //Reportar error
                            }
                        }
                        if (sevs.equalsIgnoreCase("Very Serious")){
                            if(sentence >= 16){
                                record.changeSentence(sentence);
                            }else{
                                System.out.println("ERROR");
                                //Reportar error
                            }
                        }
                    }
                }
            }
        }
        //Aunque no produce un error, debería avisar al usuario que el crimen no
        //existe y que no se va a sentenciar ni monda.
    }
}
