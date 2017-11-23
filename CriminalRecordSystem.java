import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CriminalRecordSystem {

    private ArrayList<Indicted> indicteds;

    //Constructor: Inicializa el ArrayList, esta es la lista de procesados.
    public CriminalRecordSystem() {
        this.indicteds = new ArrayList<Indicted>();
    }

    //Agrega a un procesado y su primer delito al sistema.
    public void addIndictedAndRecord(String name, String lastname, String id,
            String gender, int age, int crimeId,
            String type, String description) {
        /*Verifica que no haya alguien con el mismo ID, que el crimen no esté
          repetido y que tenga una edad mínima de 5 años.*/
        if (!this.existsIndected(id)
                && this.findCriminalRecord(crimeId) == null
                && age >= 5) {
            /*De ser así, crea un procesado con los datos. Luego le agrega un crimen.
              Y finalmente añade al procesado a la lista de procesados del sistema.*/
            Indicted newIndicted = new Indicted(name, lastname, id, gender, age);
            newIndicted.addCriminalRecord(crimeId, type, description);
            this.indicteds.add(newIndicted);
            /*Muestra errores por casos.*/
        } else if (age < 5) {
            JOptionPane.showMessageDialog(null, "La edad mínima para un procesado es 5 años.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
        } else if (this.existsIndected(id)) {
            JOptionPane.showMessageDialog(null, "Ya existe alguien con esa identificación.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
        } else if (this.findCriminalRecord(crimeId) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un crimen con ese ID asignado.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    //Agrega un crimen a un procesado especifico.
    public void addRecordToIndicted(String id, int crimeId, String type,
            String description) {
        /*Comprueba que el ID del procesado se encuentra en el sistema y que el
          ID del crimen no está aún en el sistema (no puede estar repetido).
          De cumplir esto, entonces le agrega el crimen al procesado.*/
        if (this.findIndicted(id) != -1 && this.findCriminalRecord(crimeId) == null) {
            this.getIndicted(this.findIndicted(id)).addCriminalRecord(crimeId, type, description);
        //En caso de que no encuentre al procesado (mirar findIndicted), entonces muestre error.
        } else if (this.findIndicted(id) == -1) {
            JOptionPane.showMessageDialog(null, "No existe alguien con ese identificador.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
        //En caso de que el crimeID ya esté en el sistema (mirar findCriminalRecord), entonces muestre error.
        } else if (this.findCriminalRecord(crimeId) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un crimen con ese ID asignado.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    //Simplemente verifica si el id existe dentro de la lista de procesados.
    public boolean existsIndected(String id) {
        /*Para cada procesado en la lista de procesados, verifique si el ID que
          estoy buscando concuerda con el ID del procesado. Si es así, devuelva
          "true" (que significa que encontré en el sistema alguien con el ID que busco).
          Sino devuelva false, que significa que el id que busco no está en el sistema.*/
        for (Indicted guy : indicteds) {
            if (guy.getIdentification().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    //Devuelve el crimen asociado a un "crimeID".
    public CriminalRecord findCriminalRecord(int crimeId) {
        /*Revisa que la lista de procesados no esté vacía.
          Si es así, para cada procesado en la lista de procesados busquele si en
          su lista de crimenes cometidos se encuentrá el crimen asociado al
          crimeId que se busca.
          Entonces lo que hace es guardar cada crimen en "flag". Si "flag" es "null"
          significa que ese no es el crimen que estamos buscando. Si "flag" es
          diferente de "null" significa que ese crimen concuerda con el "crimeId"
          que estamos buscando.
          Si no encontró nada, entonces devuelve un "null".*/
        if (!this.getIndicteds().isEmpty()) {
            for (Indicted guy : this.getIndicteds()) {
                CriminalRecord flag = guy.findCriminalRecord(crimeId);
                if (flag != null) {
                    return flag;
                }
            }
        }
        return null;
    }

    //Devuelve la posición de un procesado dado su ID.
    public int findIndicted(String id) {
        /*Revisa que el ID del procesado esté en el sistema.
          Si está, entonces para cada procesado en la lista de procesados,
          si su identificación es igual a la que buscamos entonces devuelva la
          posición de ese procesado asociado a la ID que concuerda.
          Devuelve -1 en caso de que el ID que se busca no esté en el sistema.*/
        if (this.existsIndected(id)) {
            for (Indicted guy : this.getIndicteds()) {
                if (guy.getIdentification().equalsIgnoreCase(id)) {
                    return this.getIndicteds().indexOf(guy);
                }
            }
        }
        return -1;
    }

    /*Devuelve una lista con todos los procesados que tienen un crimen del tipo "type"*/
    public ArrayList<Indicted> findIndictedsByCriminalRecord(String type) {
        /*Crea una lista. Verifica que la lista de procesados no esté vacía.
          Para cada procesado en la lista de procesados, si ha cometido un crimen
          del tipo "type" que se busca entonces agreguelo a la lista que creamos al inicio.
          Finalmente devuelva la lista.
          Si no encuentra a ningún procesado que cumpla, entonces devuelve una lista vacía.
          Es decir, con tamaño 0. Esto es diferente de ser = "null"*/
        ArrayList<Indicted> indictedByType = new ArrayList<Indicted>();
        if (!this.getIndicteds().isEmpty()) {
            for (Indicted guy : this.getIndicteds()) {
                if (guy.haveCriminalRecordType(type)) {
                    indictedByType.add(guy);
                }
            }
        }
        return indictedByType;
    }
    /*En mi opinión: Está mal nombrado. Sabiendo que el CriminalRecord es único pues
      no se podría hacer una lista, sino máximo traer a un convicto.
      El nombre correcto sería findIndictedByType.*/
    
    /*Los 4 métodos que siguen son bastante similares. Utilizan un comparador (valor aleatorio)
      que se compara con todos los demás. En esa comparación, el comparador toma
      el valor MENOR/MAYOR según se necesite.*/
    
    /*Devuelve LA POSICIÓN del procesado con el MAYOR número de años de condena.*/
    public int findIndictedWithGreaterSentence() {
        /*Verifica que la lista de procesados no esté vacía.
          Luego utiliza una bandera o comparador. En este caso el procesado en la
          primera posición (0).
          Para cada procesado en la lista de procesados si el número de años de condena
          que tiene es MAYOR al número de años de condena de mi comparador (el de la posición 0)
          entonces ahora mi comparador será ese procesado.
          De esa manera recorro toda la lista y se garantiza que voy a finalizar
          con el comparador/bandera en el procesado con MAYOR número de años de condena,
          que es lo que se busca.
          Finalmente devuelvo la posición de esta bandera/comparador.
          Si la lista está vacía devuelvo -1. Este valor es importante para otros métodos.*/
        if (!this.getIndicteds().isEmpty()) {
            Indicted guyFlag = this.getIndicteds().get(0);
            for (Indicted guy : this.getIndicteds()) {
                if (guy.getYearsOfSentence() > guyFlag.getYearsOfSentence()) {
                    guyFlag = guy;
                }
            }
            return this.getIndicteds().indexOf(guyFlag);
        }
        return -1;
        //Básicamente devuelve la posición en la lista del convicto.
        //-1 indica que no lo encontró.
    }

    /*Devuelve LA POSICIÓN del procesado con el MENOR número de años de condena.
      Similar al método anterior "findIndictedWithGreaterSentence()"*/
    public int findIndictedWithLessSentence() {
        /*Verifica que la lista de procesados no esté vacía.
          Luego utiliza una bandera o comparador. En este caso el procesado en la
          primera posición (0).
          Para cada procesado en la lista de procesados si el número de años de condena
          que tiene es MENOR al número de años de condena de mi comparador (el de la posición 0)
          entonces ahora mi comparador será ese procesado.
          De esa manera recorro toda la lista y se garantiza que voy a finalizar
          con el comparador/bandera en el procesado con MENOR número de años de condena,
          que es lo que se busca.
          Finalmente devuelvo la posición de esta bandera/comparador.
          Si la lista está vacía devuelvo -1. Este valor es importante para otros métodos.*/
        if (!this.getIndicteds().isEmpty()) {
            Indicted guyFlag = this.getIndicteds().get(0);
            for (Indicted guy : this.getIndicteds()) {
                if (guy.getYearsOfSentence() < guyFlag.getYearsOfSentence()) {
                    guyFlag = guy;
                }
            }
            return this.getIndicteds().indexOf(guyFlag);
        }
        return -1;
    }

    /*Devuelve LA POSICIÓN del procesado con mayor número de antecedentes.*/
    public int findIndictedWithMoreRecords() {
        /*Verifica que la lista de procesados no esté vacía.
          Luego utiliza una bandera o comparador. En este caso el procesado en la
          primera posición (0).
          Para cada procesado en la lista de procesados si el número de antecedentes
          que tiene es MAYOR al número de antecedentes de mi comparador (el de la posición 0)
          entonces ahora mi comparador será ese procesado.
          De esa manera recorro toda la lista y se garantiza que voy a finalizar
          con el comparador/bandera en el procesado con MAYOR número de antecedentes,
          que es lo que se busca.
          Finalmente devuelvo la posición de esta bandera/comparador.
          Si la lista está vacía devuelvo -1. Este valor es importante para otros métodos.*/
        if (!this.getIndicteds().isEmpty()) {
            Indicted guyFlag = this.getIndicteds().get(0);
            for (Indicted guy : this.getIndicteds()) {
                if (guy.getCriminalRecordQuantity() > guyFlag.getCriminalRecordQuantity()) {
                    guyFlag = guy;
                }
            }
            return this.getIndicteds().indexOf(guyFlag);
        }
        return -1;
    }

    //Originally named method2(): String
    /*Devuelve LA POSICIÓN del procesado con menor número de antecedentes.
      Similar al método anterior findIndictedWithMoreRecords().*/
    public int findIndictedWithLessRecords() {
        /*Verifica que la lista de procesados no esté vacía.
          Luego utiliza una bandera o comparador. En este caso el procesado en la
          primera posición (0).
          Para cada procesado en la lista de procesados si el número de antecedentes
          que tiene es MENOR al número de antecedentes de mi comparador (el de la posición 0)
          entonces ahora mi comparador será ese procesado.
          De esa manera recorro toda la lista y se garantiza que voy a finalizar
          con el comparador/bandera en el procesado con MENOR número de antecedentes,
          que es lo que se busca.
          Finalmente devuelvo la posición de esta bandera/comparador.
          Si la lista está vacía devuelvo -1. Este valor es importante para otros métodos.*/
        if (!this.getIndicteds().isEmpty()) {
            Indicted guyFlag = this.getIndicteds().get(0);
            for (Indicted guy : this.getIndicteds()) {
                if (guy.getCriminalRecordQuantity() < guyFlag.getCriminalRecordQuantity()) {
                    guyFlag = guy;
                }
            }
            return this.getIndicteds().indexOf(guyFlag);
        }
        return -1;
    }

    /*Devuelve el procesado ubicado en la posición "number".
      
      Verifica que la lista de procesados no esté vacía (si está vacía, no se
      puede devolver a ningún procesado), y que la posición "number" introducida
      sea esté dentro de los limites de una lista (de 0 hasta sutamaño -1)
      Si pasa la verificación devuelve al procesado ubicado en la posición "number".
      En caso de que "number" no cumpla, sencillamente devuelve "null".*/
    public Indicted getIndicted(int number) {
        if (!this.getIndicteds().isEmpty() && number > -1
                && number < this.getIndicteds().size()) {
            return this.getIndicteds().get(number);
        }
        return null;
    }

    //Simplemente devuelve la lista de los procesados que hay en el sistema.
    public ArrayList<Indicted> getIndicteds() {
        return this.indicteds;
    }

    //Originally named method1(): String
    //Remueve todos los crimenes del tipo "type" del procesado identificado con indictedId.
    public void removeCrimeAccordingToType(String indictedId, String type) {
        /*Comprueba que el procesado está dentro del sistema.
          De ser así, crea una lista "crimesMatchingIdList" para luego guardar
          todos los ID de los crimenes del tipo requerido. Busca la posición
          "position" asociada al procesado, con ella luego consigue la lista de
          TODOS los crimenes del procesado.
          (En la parte del 1er for) Para cada crimen en la lista de todos los crimenes
          del procesado, si el crimen es del tipo "type" que estoy buscando entonces
          agregue el ID de ese crimen a la lista "crimesMatchingIdList"
          (En la parte del 2do for) Para cada ID en la lista "crimesMatchingIDList"
           quitele al procesado asociado cada uno de estos crimenes.*/
        if (this.existsIndected(indictedId)) {
            ArrayList<Integer> crimesMatchingIdList = new ArrayList<Integer>();
            int position = this.findIndicted(indictedId);
            ArrayList<CriminalRecord> crimes = this.getIndicted(position).getCriminalRecord();
            for (CriminalRecord crime : crimes) {
                if (crime.getType().equalsIgnoreCase(type)) {
                    crimesMatchingIdList.add(crime.getIdentifier());
                }
            }
            for (Integer crimeId : crimesMatchingIdList) {
                this.getIndicted(position).removeCriminalRecord(crimeId);
            }
        }
    }

    //Quita un crimen de un procesado.
    public void removeCriminalRecordOfIndicted(String indictedId, int crimeId) {
        /*En las dos primeras lineas comprueba que tanto el crimen como el procesado
          se encuentran en el sistema. Si la posición es -1, el procesado no se
          encuentra en el sistema, si el crimen = "null" significa que el crimen
          no se encuentra en el sistema. (mirar findIndicted y findCriminalRecord)*/
        int position = this.findIndicted(indictedId);
        CriminalRecord crime = this.findCriminalRecord(crimeId);
        /*Si tanto el procesado como el crimen se encuentran en el sistema entonces
          traiga al procesado asociado a la posición anteriormente encontrada y
          quitele el crimen asociado al "crimeId".*/
        if (position != -1 && crime != null) {
            Indicted theGuy = this.getIndicteds().get(position);
            theGuy.removeCriminalRecord(crimeId);
        /*Si la posición "position" = -1 significa que no se encontró al procesado
          en el sistema se coloca el mensaje correspondiente.*/
        }else if(position == -1){
            JOptionPane.showMessageDialog(null, "No existe alguien con ese identificador.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
        /*Si el crimen "crime" = "null" significa que no se encontró el crimen 
          en el sistema, se coloca el mensaje correspondiente.*/
        } else if (this.findCriminalRecord(crimeId) == null) {
            JOptionPane.showMessageDialog(null, "No existe un crimen con ese ID asignado.", "¡ERROR!", JOptionPane.PLAIN_MESSAGE);
        }
    }

    //Quita un procesado del sistema según su id.
    public void removeIndicted(String id) {
        /*Usando el id, busca la posición asociada. Si la posición da diferente a -1
          (mirar método findIndicted()) quiere decir que efectivamente el procesado
          asociado a ese id se encuentra en el sistema. Luego procede a quitarlo del sistema.*/
        int position = this.findIndicted(id);
        if (position != -1) {
            this.getIndicteds().remove(position);
        }
    }
    
    /*Le asigna "sentence" número de años al crimen "crimeId" del procesado con el id=indictedId*/ 
    public void sentenceIndicted(String indictedId, int crimeId, int sentence) {
        /*Ubica la posición asociada al id del procesado.
          Si la posición es diferente de -1 (mirar método findIndicted),
          significa que efectivamente este procesado se encuentra en el sistema.
          Usa la posición calculada para traer al procesado y luego se condena el crimen.*/
        int position = this.findIndicted(indictedId);
        if (position != -1) {
            Indicted theGuy = this.getIndicteds().get(position);
            theGuy.sentenceIndicted(crimeId, sentence);
        }
    }
    
    //Descomente lo siguiente en caso de que requiera crear y utilizar estos métodos.
    /*public String method1(){
        
    }
    
    public String method2(){
        
    }*/
}
