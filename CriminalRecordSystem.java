package main;

import java.util.ArrayList;

public class CriminalRecordSystem {
    private ArrayList<Indicted> indicteds;
    
    public CriminalRecordSystem(){
        this.indicteds = new ArrayList<Indicted>();
    }
    
    public void addIndictedAndRecord(String name, String lastname, String id,
                                     String gender, int age, int crimeId,
                                     String type, String description){
        if (!this.existsIndected(id) &&
            this.findCriminalRecord(crimeId) == null &&
            age >= 5){
            Indicted newIndicted = new Indicted(name, lastname, id, gender, age);
            newIndicted.addCriminalRecord(crimeId, type, description);
            this.indicteds.add(newIndicted);
        }else{
            /*if(age < 5){
                System.out.println("Error de edad");
            }else if(this.existsIndected(id)){
                System.out.println("Error de convicto");
            }else if(this.findCriminalRecord(crimeId) != null){
                System.out.println("Error de crimen");
            }*/
            //Reportar error de Id de convicto duplicado.
            //Reportar error de edad mínima.
            //Reportar error de Id de crimen duplicado.
        }
    }
    
    public void addRecordToIndicted(String id, int crimeId, String type,
                                    String description){
        if(this.findIndicted(id) != -1 && this.findCriminalRecord(crimeId) == null){
            this.getIndicted(this.findIndicted(id)).addCriminalRecord(crimeId, type, description);
        }
    }
    
    public boolean existsIndected(String id){
         for (Indicted guy : indicteds){
             if(guy.getIdentification().equalsIgnoreCase(id)){
                 return true;
             }
         }
        return false;
    }
    
    public CriminalRecord findCriminalRecord(int crimeId){
        if (!this.getIndicteds().isEmpty()){
            for(Indicted guy : this.getIndicteds()){
                CriminalRecord flag = guy.findCriminalRecord(crimeId);
                if (flag != null){
                    return flag;
                }
            }
        }
        return null;
    }
    
    public int findIndicted(String id){
        if (this.existsIndected(id)){
            for (Indicted guy : this.getIndicteds()){
                if(guy.getIdentification().equalsIgnoreCase(id)){
                    return this.getIndicteds().indexOf(guy);
                }
            }
        }
        return -1;
        //Básicamente devuelve la posición en la lista del convicto.
        //-1 indica que no lo encontró.
        //Agregar mensaje sobre que no lo encontró.
    }
    
    public ArrayList<Indicted> findIndictedsByCriminalRecord(String type){
        ArrayList<Indicted> indictedByType = new ArrayList<Indicted>();
        if(!this.getIndicteds().isEmpty()){
            for(Indicted guy : this.getIndicteds()){
                if(guy.haveCriminalRecordType(type)){
                    indictedByType.add(guy);
                }
            }
        }
        return indictedByType;
    }
    //Está mal nombrado. Sabiendo que el CriminalRecord es único pues
    //no se podría hacer una lista, sino máximo traer a un convicto.
    //El nombre correcto sería findIndictedByType.
    
    public int findIndictedWithGreaterSentence(){
        int flag = -1;
        if (!this.getIndicteds().isEmpty()){
            Indicted guyFlag = this.getIndicteds().get(0);
            for (Indicted guy : this.getIndicteds()){
                if(guy.getYearsOfSentence() > flag){
                    flag = guy.getYearsOfSentence();
                    guyFlag = guy;
                }
            }
            return this.getIndicteds().indexOf(guyFlag);
        }
        return -1;
        //Básicamente devuelve la posición en la lista del convicto.
        //-1 indica que no lo encontró.
        //Agregar mensaje sobre que no lo encontró.
    }
    
    public int findIndictedWithLessSentence(){
        if (!this.getIndicteds().isEmpty()){
            Indicted guyFlag = this.getIndicteds().get(0);
            for (Indicted guy : this.getIndicteds()){
                if(guy.getYearsOfSentence() < guyFlag.getYearsOfSentence()){
                    guyFlag = guy;
                }
            }
            return this.getIndicteds().indexOf(guyFlag);
        }
        return -1;
        //Básicamente devuelve la posición en la lista del convicto.
        //-1 indica que no lo encontró.
        //Agregar mensaje sobre que no lo encontró.
    }
    
    public int findIndictedWithMoreRecords(){
        if (!this.getIndicteds().isEmpty()){
            Indicted guyFlag = this.getIndicteds().get(0);
            for (Indicted guy : this.getIndicteds()){
                if(guy.getCriminalRecordQuantity() > guyFlag.getCriminalRecordQuantity()){
                    guyFlag = guy;
                }
            }
            return this.getIndicteds().indexOf(guyFlag);
        }
        return -1;
    }
    
    public Indicted getIndicted(int number){
        if(!this.getIndicteds().isEmpty() && number > -1 &&
           number <this.getIndicteds().size()){
            return this.getIndicteds().get(number);
        }
        return null;
    }
    
    public ArrayList<Indicted> getIndicteds(){
        return this.indicteds;
    }
    
    //No idea what these are used for.
    /*
    public String method1(){
        return;
    }
    
    public String method2(){
        return;
    }
    */
    
    public void removeCriminalRecordOfIndicted(String indictedId, int crimeId){
        int position = this.findIndicted(indictedId);
        if (position != -1){
            Indicted theGuy = this.getIndicteds().get(position);
            theGuy.removeCriminalRecord(crimeId);
        }   
    }
    
    public void removeIndicted(String id){
        int position = this.findIndicted(id);
        if (position != -1){
            this.getIndicteds().remove(position);
        }
    }
    
    public void sentenceIndicted(String indictedId, int crimeId, int sentence){
        int position = this.findIndicted(indictedId);
        if (position != -1){
            Indicted theGuy = this.getIndicteds().get(position);
            theGuy.sentenceIndicted(crimeId, sentence);
        }
    }
}
