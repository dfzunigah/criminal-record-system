package main;

public class CriminalRecord {
    public static final String BREAKING_AND_ENTERING = "Breaking and entering";
    public static final String DRUG_TRAFFICKING = "Drug trafficking";
    public static final String DRUG_USE = "Drug use";
    public static final String ECOLOGICAL = "Ecological";
    public static final String FRAUD = "Fraud";
    public static final String HOMICIDE = "Homicide";
    public static final String KIDNAPPING = "Kidnapping";
    public static final String THEFT = "Theft";
    public static final String TRAFFIC = "Traffic";
    public static final String VIOLENCE = "Violence";
    
    public static final int MAXIMUM_CONVICTION_SLIGHT = 5;
    public static final int MAXIMUM_CONVICTION_SERIOUS = 15;
    public static final int MAXIMUM_CONVICTION_VERY_SERIOUS = 16;
    
    public static final String SLIGHT = "Slight";
    public static final String SERIOUS = "Serious";
    public static final String VERY_SERIOUS = "Very Serious";
    
    private String description;
    private int identifier;
    private String type;
    private String severity;
    private int yearSentence;
    
    public CriminalRecord(int id, String type, String description){
        this.identifier = id;
        this.type = type;
        this.description = description;
        this.yearSentence = 0;
        this.determineSeverity();
    }
    
    public void changeSentence(int newSentence){
        this.yearSentence = newSentence;
    }
    
    public void determineSeverity(){
        String crime = this.getType();
        if (crime.equalsIgnoreCase(ECOLOGICAL) || crime.equalsIgnoreCase(TRAFFIC) || crime.equalsIgnoreCase(DRUG_USE)){
            this.severity = SLIGHT;
        }
        if (crime.equalsIgnoreCase(BREAKING_AND_ENTERING) || crime.equalsIgnoreCase(THEFT) || crime.equalsIgnoreCase(FRAUD)){
            this.severity = SERIOUS;
        }
        if (crime.equalsIgnoreCase(HOMICIDE) || crime.equalsIgnoreCase(VIOLENCE) || crime.equalsIgnoreCase(KIDNAPPING) || crime.equalsIgnoreCase(DRUG_TRAFFICKING)){
            this.severity = VERY_SERIOUS;
        }
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public int getIdentifier(){
        return this.identifier;
    }
    
    public String getSeverity(){
        return this.severity;
    }
    
    public String getType(){
        return this.type;
    }
    
    public int getYearSentence(){
        return this.yearSentence;
    }
    
    public String toString(){
        
        return "Id: " + this.getIdentifier() +
               "\nType: " + this.getType() +
               "\nDescription: " + this.getDescription() +
               "\nSentence (Years): " + this.getYearSentence() +
               "\nSeverity: " + this.getSeverity();
    }
}
