package main;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        /*
        ///Testing
        Indicted A = new Indicted("name","lastname", "ABC123", "male", 18);
        System.out.println(A.getAge() + " " + A.getCriminalRecord()  + " " + A.getCriminalRecordQuantity() + " " + A.getGender() + " " + A.getIdentification() + " " + A.getLastName() + " " + A.getName() + " " + A.getYearsOfSentence());
        //Get methods working fine.
        System.out.println(A.haveCriminalRecordType("Kidnapping")  + " " + A.isAdult());
        //Boolean method working fine.
        A.removeCriminalRecord(0);
        //Test cases: Empty list, unexisting criminal record and existing one.
        A.addCriminalRecord(0, "Kidnapping", "Testing");
        A.addCriminalRecord(1, "Theft", "Testing2");
        CriminalRecord X = A.findCriminalRecord(0);
        System.out.println(X);
        //Adding working fine. Finding tested with an unexisting crime and an existing one. Working fine.
        A.removeCriminalRecord(3);
        //Remove method working fine.
        A.sentenceIndicted(0, 20);
        //Sentencing method working fine.
        
        System.out.println("\n\n");
        System.out.println(X.getDescription() + " " + X.getIdentifier() + " " + X.getSeverity() + " " + X.getType() + " " + X.getYearSentence());
        System.out.println(X);
        //Getter and printing methods working fine.
        //Also determine_severity and change_sentence working fine.
        */
        
        /*
        CriminalRecordSystem LaPicota = new CriminalRecordSystem();
        LaPicota.sentenceIndicted("ABC", 0, 0);
        LaPicota.removeIndicted("XYZ");
        LaPicota.removeCriminalRecordOfIndicted("IJK", 0);
        LaPicota.getIndicteds();
        LaPicota.getIndicted(0);
        LaPicota.findIndictedWithMoreRecords();
        LaPicota.findIndictedWithLessSentence();
        LaPicota.findIndictedWithGreaterSentence();
        LaPicota.findIndictedsByCriminalRecord("OPQ");
        LaPicota.findIndicted("ESTE");
        LaPicota.findCriminalRecord(0);
        LaPicota.existsIndected("BEBE");
        LaPicota.addRecordToIndicted("ABC", 0, "XSD", "XSA");
        LaPicota.addIndictedAndRecord("A", "B", "SU", "ESTE", 0, 0, "JKL", "POPS");
        //All methods tested with null ground, working fine.
        */
        
        CriminalRecordSystem LaPicota = new CriminalRecordSystem();
        LaPicota.addIndictedAndRecord("A", "B", "C", "M", 17, 0, "Kidnapping", "Testing");
        LaPicota.addIndictedAndRecord("A", "B", "X", "W", 66, 1, "Kidnapping", "TS");
        LaPicota.addRecordToIndicted("X", 2, "Ecological", "TEST");
        //Adding methods working fine. They're responding to the duplicate problems.
        //Thus, existsIndected, findCriminalRecord & findIndected works fine.
        ArrayList<Indicted> X = LaPicota.findIndictedsByCriminalRecord("Kidnapping");
        //System.out.println(X.size());
        //findIndictedsByCriminalRecord working fine.
        //System.out.println(LaPicota.findIndictedWithLessSentence());
        //System.out.println(LaPicota.findIndictedWithMoreRecords());
        //System.out.println(LaPicota.getIndicted(1));
        //Finding and get methods doing well.
        LaPicota.removeCriminalRecordOfIndicted("X", 2);
        //LaPicota.removeIndicted("C");
        System.out.println(LaPicota.getIndicteds().size());
        //Removing systems are at match.
        LaPicota.sentenceIndicted("X", 1, 50);
        System.out.println(LaPicota.findIndictedWithGreaterSentence());
        System.out.println(LaPicota.findIndictedWithLessSentence());
        //All methods working.
    }
    
}
