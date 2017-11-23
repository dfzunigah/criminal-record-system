public class CriminalRecord {
    /*Constantes que identifican el tipo de crimen.
      Usadas más adelante para determinar la severidad*/
    public static final String BREAKING_AND_ENTERING = "Allanamiento de morada";
    public static final String DRUG_TRAFFICKING = "Tráfico de drogas";
    public static final String DRUG_USE = "Consumo de drogas";
    public static final String ECOLOGICAL = "Ecológico";
    public static final String FRAUD = "Estafa";
    public static final String HOMICIDE = "Homicidio";
    public static final String KIDNAPPING = "Secuestro";
    public static final String THEFT = "Robo";
    public static final String TRAFFIC = "Tránsito";
    public static final String VIOLENCE = "Violencia";
    
    //Estas constantes no son utilizadas, pero estaban en el UML.
    public static final int MAXIMUM_CONVICTION_SLIGHT = 5;
    public static final int MAXIMUM_CONVICTION_SERIOUS = 15;
    public static final int MAXIMUM_CONVICTION_VERY_SERIOUS = 16;
    
    /*Constantes que identifican la severidad.
      Usadas más tarde para determinar la severidad.*/
    public static final String SLIGHT = "Leve";
    public static final String SERIOUS = "Grave";
    public static final String VERY_SERIOUS = "Muy grave";
    
    //Atributos de un crimen: 
    private String description; //Descripción del crimen.
    private int identifier; //ID númerico único que identifica el crimen.
    private String type; //Tipo de crimen. Los tipos usados son los que están arriba como constantes.
    private String severity; //Calculada de acuerdo al tipo de crimen. (Mirar más adelante)
    private int yearSentence; //Años de sentencia para este crimen.
                              //Por defecto se coloca en 0 (mirar el siguiente método)
                              //pues la sentencia luego la coloca el usuario.
    
    /*Constructor: La severidad la determina el tipo y los años de sentencia los coloca el usuario después.*/
    public CriminalRecord(int id, String type, String description){
        this.identifier = id;
        this.type = type;
        this.description = description;
        this.yearSentence = 0;
        this.determineSeverity(); //Este método (mirar más adelante) permite
                                  //calcular la severidad de acuerdo al tipo de crimen.
    }
    
    /*Asigna un nuevo valor a los años de sentencia por este crimen.
      Se utiliza en el método "sentenceIndicted" de la clase "Indicted".*/
    public void changeSentence(int newSentence){
        this.yearSentence = newSentence;
    }
    
    /*Determina la severidad del este crimen si encuadra con alguno de los crimenes.
      Suponga que el usuario se equivocó digitando el tipo de crimen (mala ortografia
      o ganas de trollear), entonces el sistema no puede asignarle una severidad
      determinado y se queda en su valor predeterminado, que es "null". Esto es
      importante en los métodos de las otras clases.*/
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
    
    /*Los siguientes cinco (5) métodos sólo devuelven los atributos de este crimen.
      "getDescription()" devuelve la descripción de este crimen, etc.*/
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
    
    /*Convierte a este crimen en una representación de texto.
      Cada atributo está en una línea (\n es un salto de línea)*/
    public String toString(){
        
        return "Id: " + this.getIdentifier() +
               "\nTipo: " + this.getType() +
               "\nDescripción: " + this.getDescription() +
               "\nAños de sentencia: " + this.getYearSentence() +
               "\nSeveridad: " + this.getSeverity();
    }
}
