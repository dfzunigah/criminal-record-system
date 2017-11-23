import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Indicted {
    //Atributos de un procesado:
    private String name; //Nombre del procesado.
    private String lastName; //Apellido del procesado.
    private String identification; //ID único del procesado.
    private String gender; //Genero del procesado.
    private int age; //Edad del procesado.
    private ArrayList<CriminalRecord> criminalRecordList; //Lista de los crimenes
                                                          //que el procesado ha cometido.
    
    //Estas constantes no son utilizadas, pero estaban en el UML.
    public static final String FEMALE = "Femenino";
    public static final String MALE = "Masculino";
    public static final int ADULT = 18;
    public static final int MINIMAL_AGE = 5;

    /*Constructor: El atributo "criminalRecordList" no se incluye como parámetro
      porque el procesado inicia en el sistema sin crimenes, el usuario los agrega después.*/
    public Indicted(String name, String lastName, String id, String gender, int age){
        this.name = name;
        this.lastName = lastName;
        this.identification = id;
        this.gender = gender;
        this.age = age;
        this.criminalRecordList = new ArrayList<CriminalRecord>();
    }
    
    //Agrega un crimen a este procesado.
    public void addCriminalRecord(int crimeId, String type, String description){
        /*Lo que indica "isThereADouble" es si ya existe un crimen con un "crimeId".
          Esto se hace porque no puede haber dos crimenes con un mismo identificador.
          
          
          Para cada crimen en la lista de crimenes, mirar si el identificador de
          ese crimen es igual al "crimeId" dado como parámetro. En caso de que eso
          sea verdad, entonces ya existe un crimen ese "crimeId". Es decir, ya hay
          un duplicado (isThereDouble = true) y rompemos/salimos del ciclo (break).
        
          Luego verificamos: Si no hay un duplicado (isThereDouble == false),
          entonces podemos agregar el crimen a la lista de crimenes.
          Si en algún momento isThereADouble = true, entonces simplemente no se
          hace nada, no se agrega ningún crimen.
        */
        boolean isThereADouble = false;
        for (CriminalRecord crime : this.criminalRecordList){
        //Estructura de estos ciclos: for (Clase unidad : listaDeUnidades).
            if(crime.getIdentifier() == crimeId){
                isThereADouble = true;
                break;
            }
        }
        if(isThereADouble == false){
            this.criminalRecordList.add(new CriminalRecord(crimeId, type, description));
        }
    }
    
    //Devuelve el crimen identificado con "crimeId".
    public CriminalRecord findCriminalRecord(int crimeId){
        /*Si la lista NO está vacía, es decir, si esta persona han cometido crimenes
          (desde el otro lado, si la lista está vacía pues no hay crimenes y no hay
           nada para encotrar.), entonces:
        */
        if (!this.criminalRecordList.isEmpty()){
            /*Para cada crimen en la lista de crimenes, verifique el identificador
              del crimen, si el identificador es igual al "crimeId" provisto, entonces
              encontró el crimen que buscaba y lo devuelve.*/
            for (CriminalRecord record : criminalRecordList){
                if(record.getIdentifier() == crimeId){
                    return record;
                }
            }
        }
        //Si no encuentra el crimen que buscaba, entonces devuelve un "null" (Vacío).
        return null;
    }
    
    /*Los siguientes seis (6) métodos sólo devuelven los atributos de este procesado.
      "getAge()" devuelve la edad del procesado, etc.*/
    public int getAge(){
        return this.age;
    }
    
    public ArrayList<CriminalRecord> getCriminalRecord(){
        return this.criminalRecordList;
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
    
    /*Este método devuelve el nñumero de crimenes que ha cometido esta persona.
      La manera de hacerlo es tomar la lista de crimenes (this.getCriminalRecord)
      y mirar su tamaño (con su atributo .size())*/
    public int getCriminalRecordQuantity(){
        return this.getCriminalRecord().size();
    }
    
    //Devuelve el total de años de condena de este procesado.
    public int getYearsOfSentence(){
        /*"yearsOfSentence" es un sumador (se inicia en 0 y se le va sumando valores
          mediante un ciclo).
        
          Para cada crimen en la lista de crimenes, sume el número de años condenado
          por ese crimen. Finalmente devuelve toda esta suma.
        
          Por ejemplo: Crimen 1 [5 años], Crimen 2 [2 años], Crimen 3 [0 años]
          El método devolvería 5 + 2 + 0, es decir 7 años.
        */
        int yearsOfSentence = 0;
        for (CriminalRecord record : criminalRecordList){
            yearsOfSentence += record.getYearSentence();
        }
        return yearsOfSentence;
    }
    
    /*Busca si esta persona tiene crimenes del tipo "type". Si tiene almenos
      un (1) crimen de este tipo, entonces devuelve "true", sino "false".*/
    public boolean haveCriminalRecordType(String type){
        /*Para cada crimen en la lista de crimenes, si el tipo del crimen es igual
          al que estás buscando "type", entonces devuelve "true" y rompe el ciclo
          pues sólo necesita un (1) crimen que cumpla. (Si no se coloca el "break"
          lo que sucede es que va a recorrer toda la lista.)*/
        for (CriminalRecord record : criminalRecordList){
            if (record.getType().equalsIgnoreCase(type)){
                return true;
            }
            break;
        }
        return false;
    }
    
    /*Comprueba si esta persona es un adulto. Si tiene >= 18 años, es un adulto y
      devuelve "true". Sino, devuelve "false", es decir, no es un adulto.*/
    public boolean isAdult(){
        if (this.age >= ADULT){
            return true;
        }
        return false;
    }
    
    //Le quita el crimen identificado con "crimeId" a esta persona.
    public void removeCriminalRecord(int crimeId){
        /*Si la lista de crimenes NO está vacía, es decir, si hay algún crimen
          (se coloca esta verificación porque si la lista está vacía pues no hay
           ningún crimen que quitar).*/
        if (!this.criminalRecordList.isEmpty()){
            /*"index" es una variable indicadora, se utiliza para poder referenciar
              a otras variables en por ejemplo una lista, como en este caso.
              Se inicia en "-1" para evitar referenciar a algún elemento de la lista,
              se pudo utilizar cualquier valor si se sabe que la lista nunca va a
              tener un valor en esa posición. La posición -1 no existe por ejemplo,
              o la posición 100000000 dificilmente se alcanza.
            
              Para cada crimen en la lista de crimenes, si el identificador del
              crimen es igual al "crimeId" que estoy buscando, entonces haga a la
              variable indicadora "index" igual a la posición de ese crimen que
              cumple con lo que busco y rompa el ciclo. (No se necesita recorrer
              más porque los identificadores son únicos).
              En últimas, si encuentro lo que busco "index" = a la posición donde
              está lo que busco, sino index queda = al valor incial, acá es -1.*/
            int index = -1;
            for (CriminalRecord record : criminalRecordList){
                if (record.getIdentifier()==crimeId){
                    index = criminalRecordList.indexOf(record);
                    break;
                }
            }
            /*Si la variable indicadora "index" es diferente al valor que le coloque
              inicialmente, -1 en este caso (es decir, si encontré el crimen con
              "crimeId" que buscaba), entonces:
            
              Es necesario verificar la severidad del crimen porque sólo los
              crimenes con "severidad leve" se pueden eliminar.
              
              Guardo la severidad del crimen que busco eliminar en la variable crimeSeverity.
              Si la severidad es diferente a "null" (mirar el método "determineSeverity" 
              de la clase CriminalRecord, el comentario acerca del significado de
              que la severidad = null), entonces:
              Compruebe que el crimen sea leve, si es así proceda a eliminar el
              crimen que buscaba, ubicado en la posición "index".
              Luego, muestre un mensaje diciendo que todo salió bien.
              Si el crimen no es leve, entonces muestre un mensaje diciendo que
              surgió un error porque el crimen no es leve.
            
              Estructura: JOptionPane.showMessageDialog(null, "Mensaje", "Titulo", JOptionPane.PLAIN_MESSAGE);
              */
            if(index != -1){
                String crimeSeverity = criminalRecordList.get(index).getSeverity();
                if (crimeSeverity != null){
                    if (crimeSeverity.equalsIgnoreCase("Leve")){
                        criminalRecordList.remove(index);
                        JOptionPane.showMessageDialog(null, "Delito eliminado exitosamente.", "Aviso", JOptionPane.PLAIN_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se puede eliminar un delito grave o muy grave.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        }
    }
    
    //Asigna "sentence" años al crimen identificado con "crimeId".
    public void sentenceIndicted(int crimeId, int sentence){
        /*Sólo es puede condenar a un adulto. Si no es adulto, entonces muestre un error.
          Estructura: JOptionPane.showMessageDialog(null, "Mensaje", "Titulo", JOptionPane.PLAIN_MESSAGE);*/
        if (!this.isAdult()){
            JOptionPane.showMessageDialog(null, "No se puede sentenciar a un menor de edad.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
        }else{
            /*Si la persona es un adulto, entonces:
            
              Necesito encontar el crimen así que para cada crimen en la lista
              de crimenes, verificar si el identificador del crimen es igual al
              crimeId que estoy buscando. Si encuentro un identificador = al crimeId
              entonces encontré el crimen que busco condenar. Ahora guardo en la
              variale "sevs" la severidad de este crimen.
            
              Si la severidad tiene un valor "null" entonces muestre un mensaje
              de error. (mirar el método "determineSeverity" de la clase CriminalRecord,
              el comentario acerca del significado de que la severidad = null).
            
              Si la severidad no es "null" entonces verifique por casos:
                 Si la severidad es leve, verifique que la condena esté entre
                 1 y 5 años, si es así entonces condene, sino muestre un error.
                 
                 Si la severidad es grave, verifique que la condena esté entre
                 6 y 15 años, si es así entonces condene, sino muestre un error.
            
                 Si la severidad es muy grave, verifique que la condena sea mayor
                 a 15 años, si es así entonces condene, sino muestre un error.*/
            for (CriminalRecord record : criminalRecordList){
                if (record.getIdentifier()==crimeId){
                    String sevs = record.getSeverity();
                    if(sevs == null){
                        JOptionPane.showMessageDialog(null, "Verifica la ortografía, el sistema no reconoce la severidad del crimen.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
                    }else{
                        if (sevs.equalsIgnoreCase("Leve")){
                            if(sentence >= 1 && sentence <= 5){
                                record.changeSentence(sentence);
                            }else{
                                JOptionPane.showMessageDialog(null, "Se requiere una sentencia de entre 1 y 5 años.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        if (sevs.equalsIgnoreCase("Grave")){
                            if(sentence >= 6 && sentence <= 15){
                                record.changeSentence(sentence);
                            }else{
                                JOptionPane.showMessageDialog(null, "Se requiere una sentencia de entre 6 y 15 años.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        if (sevs.equalsIgnoreCase("Muy grave")){
                            if(sentence >= 16){
                                record.changeSentence(sentence);
                            }else{
                                JOptionPane.showMessageDialog(null, "Se requiere una sentencia mayor a 15 años.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                    }
                }
            }
        }
    }
    
    /*Convierte a este procesado en una representación de texto.
      Cada atributo está en una línea (\n es un salto de línea)*/
    public String toString(){
        return "Nombre: " + this.getName() +
               "\nApellido: " + this.getLastName() +
               "\nID: " + this.getIdentification() +
               "\nEdad: " + this.getAge() +
               "\nAños de condena: " + this.getYearsOfSentence();
    }
}
