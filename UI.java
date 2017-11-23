/*NOTA: Esta intefaz fue creada usando el GUI Creator de NetBeans y luego fue modificada.*/

/*El GUI Creator de NetBeans importa el elemento cada vez que lo va a utilizar,
  si se importan desde acá entonces el código se reduce y se hace más claro,
  además se mejora el desempeño.*/
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import java.util.ArrayList;

/*La clase UI es como tal un JFrame en el cual se le van a agregar
  todos estos elementos de acá abajo. (Exceptuando por "system" que es un
  CriminalRecordSystem y es independiente de los componentes visuales).

  Los componentes están separados según su tipo y su ubicacion.*/
public class UI extends javax.swing.JFrame {
    
    private JTextArea background;
    private JScrollPane jScrollPane;

    private JButton option1;
    private JButton option2;
    private JButton plus_condena;
    private JButton less_condena;
    private JButton seek_background;
    private JButton plus_background;
    private JButton less_background;

    private JButton change_sentence;
    private JButton see_sentence;
    private JButton add_sentence;
    private JButton eliminate_sentence;

    private JButton go_back;
    private JButton go_forward;
    private JButton search;
    private JButton delete;
    private JButton aggregate;

    private JSeparator actions_separator;

    private JLabel sentence_years;
    private JLabel indicted_age;
    private JLabel indicted_id;
    private JLabel indicted_lastname;
    private JLabel indicted_name;

    private JLabel indicted_title;
    private JLabel background_title;
    private JLabel actions_title;

    //Inicializamos nuestro sistema de antecedentes penales con el nombre de "system".
    private CriminalRecordSystem system = new CriminalRecordSystem();

    //Lo único que hace este método es llamar a otro método. Es sólo como por elegancia.
    //Método generado por el GUI Creator de NetBeans.
    public UI() {
        initComponents();
    }

    /*Acá se inicializan, se configuran los parámetros, se añaden los "listener"
      para los eventos, y luego se organiza espacialmente.*/
    private void initComponents() {
        //Este es el titulo de la barra superior.
        this.setTitle("Sistema de Antecedentes Penales");
        
        //Lo único que se hace acá es inicializar cada componente que se va a usar.
        /*Área de texto y un scroll bar para moverse si el texto es más grande
          que el área de texo. Ubicado en la parte superior derecha. El scroll bar
          sólo aparece cuando se necesite.*/
        background = new JTextArea();
        jScrollPane = new JScrollPane();
        
        /*Son los siete (7) botones ubicadoos en la parte inferior.
          option1 = Opción 1
          option2 = Opción 2
          plus_condena = Más años de condena
          less_condena = Menos años de condena
          seek_background = Buscar por antecendentes
          plus_background = Más antecedentes
          less_background = Menos antecedentes*/
        option1 = new JButton();
        option2 = new JButton();
        plus_condena = new JButton();
        less_condena = new JButton();
        seek_background = new JButton();
        plus_background = new JButton();
        less_background = new JButton();

        /*Son los cuatro (4) botones que están debajo del área de texto. A la derecha.
          change_sentence = Cambiar condena
          see_sentence = Ver
          add_sentence = Agregar
          Eliminate_sentence = Eliminar*/
        change_sentence = new JButton();
        see_sentence = new JButton();
        add_sentence = new JButton();
        eliminate_sentence = new JButton();

        /*Son los cinco (5) botones que están a la mitad a la izquierda.
          go_back = <<
          go_forward = >>
          search = Buscar
          delete = Eliminar
          aggregate = Agregar*/
        go_back = new JButton();
        go_forward = new JButton();
        search = new JButton();
        delete = new JButton();
        aggregate = new JButton();

        //Es el separador (línea) que está al lado del titulo "Acciones" en la parte de abajo.
        actions_separator = new JSeparator();

        /*Son los textos que aparecen en la parte superior izquierda.
          indicted_name = Nombre:
          indicted_lastname = Apellido:
          indicted_id = ID:
          indicted_age = Edad:
          sentence_years = Años de condena:*/
        sentence_years = new JLabel();
        indicted_age = new JLabel();
        indicted_id = new JLabel();
        indicted_lastname = new JLabel();
        indicted_name = new JLabel();

        /*Son los titulos que están repartidos por toda la interfaz.
          indicted_title = Procesado (Izquierda arriba)
          background_title = Antecedentes (Derecha arriba)
          actions_title = Acciones (Mitad derecha)*/
        indicted_title = new JLabel();
        background_title = new JLabel();
        actions_title = new JLabel();
        
        //Define que si se da click en la X de la pestaña entonces se sale del programa.
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //Define que la ventana no es redimensionable. Su tamaño es fijo.
        setResizable(false);
        
        /*Define las dimensiones del área de texto. Hace que el área sólo sea
          de lectura y luego añade una scroll bar al área de texto, en caso de
          que el texto sea más grande que el área de texto.*/
        background.setColumns(20);
        background.setRows(5);
        background.setEditable(false);
        jScrollPane.setViewportView(background);

        //Asigna el texto a mostrar con el correspondiente botón.
        option1.setText("Opción 1");
        option2.setText("Opción 2");
        plus_condena.setText("Más años de condena");
        less_condena.setText("Menos años de condena");
        seek_background.setText("Buscar por antecedentes");
        plus_background.setText("Más antecedentes");
        less_background.setText("Menos antecedentes");

        change_sentence.setText("Cambiar condena");
        see_sentence.setText("Ver");
        add_sentence.setText("Agregar");
        eliminate_sentence.setText("Eliminar");

        go_back.setText("<<");
        go_forward.setText(">>");
        search.setText("Buscar");
        delete.setText("Eliminar");
        aggregate.setText("Agregar");

        sentence_years.setText("Años de condena: ");
        indicted_age.setText("Edad: ");
        indicted_id.setText("ID: ");
        indicted_lastname.setText("Apellido: ");
        indicted_name.setText("Nombre: ");

        /*Estos son los titulos, entonces acá al texto a mostrar sencillamente
          se le coloca un nuevo tamaño. La fuente por defecto es Tahoma tamaño 11.
          No hay método para simplemente agrandar, toca colocar toda la línea
          indicando el tipo de fuente, el estilo y el tamaño.*/
        indicted_title.setText("Procesado");
        indicted_title.setFont(new Font("Tahoma", 0, 14));
        background_title.setText("Antecedentes");
        background_title.setFont(new Font("Tahoma", 0, 14));
        actions_title.setText("Acciones");
        actions_title.setFont(new Font("Tahoma", 0, 14));

        /*Aquí lo único que se hace es asignar un "MouseListener" a cada botón.
          Un MouseListener sencillamente permite a ese elemento, en este caso
          un botón, saber que el usuario está interactuando con él (haciendo click).
          Siguen la estructura:
        
          nombreBoton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                nombreBotonMouseClicked(evt);
            }
          });
          */
        less_condena.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                less_condenaMouseClicked(evt);
            }
        });

        plus_condena.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                plus_condenaMouseClicked(evt);
            }
        });

        plus_background.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                plus_backgroundMouseClicked(evt);
            }
        });

        less_background.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                less_backgroundMouseClicked(evt);
            }
        });

        delete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        seek_background.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                seek_backgroundMouseClicked(evt);
            }
        });

        aggregate.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                aggregateMouseClicked(evt);
            }
        });

        search.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });

        go_back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                go_backMouseClicked(evt);
            }
        });

        go_forward.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                go_forwardMouseClicked(evt);
            }
        });

        add_sentence.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                add_sentenceMouseClicked(evt);
            }
        });

        see_sentence.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                see_sentenceMouseClicked(evt);
            }
        });
        
        eliminate_sentence.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                eliminate_sentenceMouseClicked(evt);
            }
        });
        
        change_sentence.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                change_sentenceMouseClicked(evt);
            }
        });
        
        
        /*Todo este código es generado con el GUI Creator de NetBeans. Lo que
          hace es posicionar espacialmente los elementos. Cuando se crea es
          "inmodificable" manualmente, lo que se hace es que se copia el código y listo.*/
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(actions_title)
                        .addGap(18, 18, 18)
                        .addComponent(actions_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(option2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(plus_condena, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(50, 50, 50)
                                                                .addComponent(less_condena, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(seek_background, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(plus_background, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(less_background, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(66, 66, 66)
                                                        .addComponent(go_back)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(go_forward))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(indicted_age)
                                                                        .addComponent(indicted_id)
                                                                        .addComponent(indicted_lastname)
                                                                        .addComponent(indicted_name)
                                                                        .addComponent(sentence_years)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(8, 8, 8)
                                                                                .addComponent(aggregate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addComponent(indicted_title))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jScrollPane)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(add_sentence, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(change_sentence))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(see_sentence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(eliminate_sentence, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(background_title)
                                                        .addGap(101, 101, 101))))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(indicted_name)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(indicted_lastname)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(indicted_id)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(indicted_age)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sentence_years)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(delete)
                                                .addComponent(aggregate)
                                                .addComponent(search))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(go_back)
                                                .addComponent(go_forward)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(background_title, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(indicted_title, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(see_sentence)
                                                .addComponent(change_sentence))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(add_sentence)
                                                .addComponent(eliminate_sentence))))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(actions_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(actions_title))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(seek_background)
                                .addComponent(plus_background)
                                .addComponent(less_background))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(plus_condena)
                                .addComponent(less_condena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(option2)
                                .addComponent(option1))
                        .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>
    /*Esa última línea "setLocationRelativeTo(null)" es para centrar el cuadro.
      Se coloca después de "pack()" para que tenga el efecto de centarla en la
      mitad de la pantalla.*/

    /*Los siguientes son los métodos que responden a los Listeners de arriba.
      Es necesario que primero se hayan creado el método correspondiente de Listener. (lineas 193 - 203)
      Acá es donde se coloca lo que sucede si se interactua con el objeto.
      En este caso, acá se coloca lo que sucede si el usuario hace click en el botón.
     
      private void nombreMétodoMouseClicked(MouseEvent evt){
          Inserte aquí lo que sucede cuando se hace click.
      }
      */
    
    /*Utiliza el método "findIndictedWithLessSentence" de la clase CriminalRecordSystem
      para hallar la posición del procesado con menos sentencias y lo muestra en un cuadro aparte.*/
    private void less_condenaMouseClicked(MouseEvent evt) {
        /*Halla la posición del procesado con menos sentencias, esto es "position".
          Crea una variable "display" de tipo String, ahí almacenará lo que va a mostrar.
          Si al buscar el procesado correspondiente a la posición resulta un "null"
          significa que no hay ningún condenado. En "display" coloca el mensaje que mostrará.
          En otro caso, halla el procesado correspondiente con la posición "position"
          y almacena en forma de texto la información del procesado en "display", eso será lo que muestre.
          Finalmente muestra un mensaje.
        
          Estructura: JOptionPane.showMessageDialog(null, "Inserte aquí su mensaje", "Inserte aquí su titulo", JOptionPane.PLAIN_MESSAGE);
        */
        int position = system.findIndictedWithLessSentence();
        String display = "";
        if (system.getIndicted(position) == null) {
            display = "No hay datos suficientes.";
        } else {
            display = system.getIndicted(position).toString();
        }
        JOptionPane.showMessageDialog(null, display, "Procesado con menos años de condena", JOptionPane.PLAIN_MESSAGE);
    }
    
    /*Utiliza el método "findIndictedWithGreaterSentence" de la clase CriminalRecordSystem
      para hallar la posición del procesado con más sentencias y lo muestra en un cuadro aparte.*/
    private void plus_condenaMouseClicked(MouseEvent evt) {
        //La explicación es la misma del método anterior. (less_condenaMouseClicked)
        int position = system.findIndictedWithGreaterSentence();
        String display = "";
        if (system.getIndicted(position) == null) {
            display = "No hay datos suficientes.";
        } else {
            display = system.getIndicted(position).toString();
        }
        JOptionPane.showMessageDialog(null, display, "Procesado con más años de condena", JOptionPane.PLAIN_MESSAGE);
    }
    
    /*Utiliza el método "findIndictedWithMoreRecords" de la clase CriminalRecordSystem
      para hallar la posición del procesado con más crimenes y lo muestra en un cuadro aparte.*/
    private void plus_backgroundMouseClicked(MouseEvent evt) {
        //La explicación es la misma de los dos (2) métodos anteriores.
        //Mirar "less_condenaMouseClicked" y "plus_condenaMouseClicked".
        int position = system.findIndictedWithMoreRecords();
        String display = "";
        if (system.getIndicted(position) == null) {
            display = "No hay datos suficientes.";
        } else {
            display = system.getIndicted(position).toString();
        }
        JOptionPane.showMessageDialog(null, display, "Procesado con más antecedentes", JOptionPane.PLAIN_MESSAGE);
    }

    /*Utiliza el método "findIndictedWithLessRecords" de la clase CriminalRecordSystem
      para hallar la posición del procesado con menos crimenes y lo muestra en un cuadro aparte.*/
    private void less_backgroundMouseClicked(MouseEvent evt) {
        //La explicación es la misma de los tres (3) métodos anteriores.
        //Mirar "less_condenaMouseClicked", "plus_condenaMouseClicked" y "plus_backgroundMouseClicked".
        int position = system.findIndictedWithLessRecords();
        String display = "";
        if (system.getIndicted(position) == null) {
            display = "No hay datos suficientes.";
        } else {
            display = system.getIndicted(position).toString();
        }
        JOptionPane.showMessageDialog(null, display, "Procesado con menos antecedentes", JOptionPane.PLAIN_MESSAGE);
    }

    /*Busca los procesados que han hecho un crimen del tipo que el usuario coloque,
      posteriormente crea una lista de estos procesados en forma de texto,
      la estiliza y la muestra en un cuadro aparte.*/
    private void seek_backgroundMouseClicked(MouseEvent evt) {
        /*Estructura: JOptionPane.showInputDialog("Inserte su mensaje aquí")
         
          Pide al usuario que coloque el tipo de crimen que está buscando y lo
          lo guarda en la variable "type".
          Luego usando el método findIndictedsByCriminalRecord de la clase CriminalRecordSystem
          crea una lista con los procesados que han cometido un crimen del tipo "type".
          Guarda en la variable "quantity" el tamaño de la lista, esto es el número
          de procesados que han cometido un crimen del tipo "type".
          Se utilizará la variable "display" para almacenar la información de los procesados.
          Para cada procesado en la lista de los procesados, guarde en display su
          información y agregué un salto de línea. (Lo último es para que se pueda diferenciar
          un procesado de otro, para que se vea bien).
          El último procesado va a agregar un salto de línea al final, ese salto
          de línea no se necesita, por eso se usa el método .trim() para eliminar
          esos espacios/vaciós/saltos al final de un texto.
        */
        String type = JOptionPane.showInputDialog("Tipo de crimen:");
        ArrayList<Indicted> indictedList = system.findIndictedsByCriminalRecord(type);
        int quantity = indictedList.size();
        String display = "";
        for (Indicted oneIndicted : indictedList) {
            display += oneIndicted.toString() + "\n\n";
        }
        display = display.trim();
        /*Si el tamaño de la lista es 0, significa que no hay procesados que hayan
          cometido ese tipo de crimen. Se muestra el mensaje correspondiente.
          Si el tamaño de la lista es otro, entonces hay alguien que ha cometido
          ese tipo de crimen, se muestra el mensaje correspondiente.
        
          Estructura: JOptionPane.showMessageDialog(null, "Mensaje_AQUI","Titulo_AQUI", JOptionPane.PLAIN_MESSAGE);*/
        if (quantity == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos suficientes.","0 procesados por " + type, JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, display, quantity + " procesados por " + type, JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /*Agrega un procesado y su primer crimen. Sencillamente pide los datos y
      llama al método "addIndictedAndRecord" de la clase CriminalRecordSystem.
      De las excepciones (Que se repita el Id del procesado, el Id del crimen o
      que sea menor de 5 años) se encargan en el método anteriormente mencionado.*/
    private void aggregateMouseClicked(MouseEvent evt) {
        /*Estructura: JOptionPane.showInputDialog("MENSAJE");
          Para el caso de los números (age, crimeId) es necesario hacer un casting,
          es decir convertir el String que el usuario coloca en la caja de dialogo
          a el número como tal, eso se hace así: Integer.parseInt(String_AQUI)*/
        String name = JOptionPane.showInputDialog("Nombre del procesado:");
        String lastname = JOptionPane.showInputDialog("Apellido del procesado:");
        String id = JOptionPane.showInputDialog("Identificación del procesado [Alfanúmerico]");
        String gender = JOptionPane.showInputDialog("Genero del procesado:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Edad del procesado [Númerico]"));
        int crimeId = Integer.parseInt(JOptionPane.showInputDialog("ID para el crimen [Númerico]"));
        String type = JOptionPane.showInputDialog("Tipo de crimen:");
        String description = JOptionPane.showInputDialog("Descripción del crimen:");

        system.addIndictedAndRecord(name, lastname, id, gender, age, crimeId, type, description);
    }
    
    /*Elimina a un procesado según su identificación.*/
    private void deleteMouseClicked(MouseEvent evt) {
        /*Estructura: JOptionPane.showInputDialog("Mensaje")
          El usuario ingresa la identificación del procesado que quiere eliminar.
          Se verifica si el procesado ya está en el sistema, si no está (false)
          pues sencillamente no se puede sacar del sistema. Se muestra el mensaje correspondiente.
          Si el usuario si está en el sistema (la parte del else) se procede a
          eliminar al procesado y a mostar un mensaje diciendo que todobien todobonito.
        
          Estructura: JOptionPane.showMessageDialog(null, "Mensaje", "Titulo", JOptionPane.PLAIN_MESSAGE);*/
        String indictedId = JOptionPane.showInputDialog("Identificación del procesado [Alfanúmerico]");
        if (system.existsIndected(indictedId) == false) {
            JOptionPane.showMessageDialog(null, "No existe un procesado con esa identificación.", "Aviso", JOptionPane.PLAIN_MESSAGE);
        } else {
            system.removeIndicted(indictedId);
            JOptionPane.showMessageDialog(null, "Se ha eliminado el registro existosamente.", "Aviso", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /*Busca y muestra al procesado según su identificación. Similar al método
      anterior "deleteMouseClicked()"*/
    private void searchMouseClicked(MouseEvent evt) {
        /*Estructura: JOptionPane.showInputDialog("Mensaje")
          Estructura: JOptionPane.showMessageDialog(null, "Mensaje", "Titulo", JOptionPane.PLAIN_MESSAGE);
        
          Pide al usuario la identificación. Verifica que el procesado exista en el
          sistema, si el procesado no existe (false) entonces muestra el mensaje correspondiente.
          En caso contrario (parte del else) halla la posición "position" del
          procesado buscado y luego la usa para traer al procesado "theOneSearched".
          Finalmente imprime en una cuadro aparte la información del procesado.
          */
        String indictedId = JOptionPane.showInputDialog("Identificación del procesado [Alfanúmerico]");
        if (system.existsIndected(indictedId) == false) {
            JOptionPane.showMessageDialog(null, "No existe un procesado con esa identificación.", "Aviso", JOptionPane.PLAIN_MESSAGE);
        } else {
            int position = system.findIndicted(indictedId);
            Indicted theOneSearched = system.getIndicted(position);
            JOptionPane.showMessageDialog(null, theOneSearched.toString(), "Procesado " + indictedId, JOptionPane.PLAIN_MESSAGE);
        }
    }

    /*Permite navegar por la lista de procesados. Hacia ATRÁS. Actuliza los
      datos en los textos (arriba izquierda) y en el área de texto (arriba derecha)*/
    private void go_backMouseClicked(MouseEvent evt) {
        /*Caso 1 : Cuando es la primera vez que se hace click sobre el boton.
        
          Verifica que la exista algo en la lista (que no esté vacía).
          El estado original de los textos es "Atributo: ", así que comprobamos que
          estén en ese estado (puede ser con cualquier atributo, acá usamos ID).
          Si están en el estado original significa que no se han tocado los botones
          para ir atras/adelante.
          Como vamos para atrás y no se han tocado los botones entonces iniciamos
          mostrando el último procesado (ubicado en el tamaño de la lista - 1).
          Traemos al procesado ubicado en la última posición y actualizamos la información.
        
          La importancia de este caso es que la primera vez que se inicia.
          No se muestra un procesado al azar sino precisamente el último.*/
        if (!system.getIndicteds().isEmpty()) {
            if (indicted_id.getText().equalsIgnoreCase("ID: ")) {
                int position_last_indicted = system.getIndicteds().size() - 1;
                Indicted last_indicted = system.getIndicted(position_last_indicted);
                this.updateInfo(last_indicted);
        /*Caso 2 : Cuando ya se han clickeado los botones. Cuando ya se muestra alguna info.
                
          Ya se muestra alguno info en los textos y en el área de texto.
          El estado de los textos (arriba izquierda) será >> Aributo: ALGO.
          Usamos el atributo de ID, sabiendo que la información iniciará desde
          el cuarto (4) caracter >> ID: A (I>0, D>1, :>2, "espacio">3.
          Usamos el método substring(4) para tomar todo el texto que inicia en el
          caracter 4, es decir, en últimas el método nos devuelve el ID del procesado.
          Usamos ese ID para averiguar la posición del procesado que se está mostrando.
          Mirar abajo.*/
            } else {
                String currentIndictedDisplayed_id = this.indicted_id.getText().substring(4);
                /*Lo que hace esta línea es darlos la posición del procesado del
                  cual estamos mostrando la posición. Es la POSICIÓN ACTUAL.*/
                int currentIndictedDisplayed_position = system.findIndicted(currentIndictedDisplayed_id);
                /*Si la posición actual es 0 y vamos para atrás (<<) entonces debemos
                  volver al final. Buscamos la última posición (tamaño -1) y traemos
                  el procesado asociado a esa posición. Luego actualizamos la info
                  de los textos y del área de texto.*/
                if (currentIndictedDisplayed_position == 0) {
                    int position_last_indicted = system.getIndicteds().size() - 1;
                    Indicted last_indicted = system.getIndicted(position_last_indicted);
                    this.updateInfo(last_indicted);
                /*Si la posición actual es otra diferente de 0, sencillamente restamos 1 a la posición
                  actual y traemos al procesado asociado a ella. Actualizamos la
                  información con los datos de este procesado.*/
                } else {
                    Indicted indicted_before = system.getIndicted(currentIndictedDisplayed_position - 1);
                    this.updateInfo(indicted_before);
                }
            }
        }
    }
    
    /*Permite navegar por la lista de procesados. Hacia ADELANTE. Actuliza los
      datos en los textos (arriba izquierda) y en el área de texto (arriba derecha)
      SIMILAR AL METODO ANTERIOR: go_backMouseClicked()*/
    private void go_forwardMouseClicked(MouseEvent evt) {
        /*Caso 1 : Cuando es la primera vez que se hace click sobre el boton.
        
          Verifica que la exista algo en la lista (que no esté vacía).
          El estado original de los textos es "Atributo: ", así que comprobamos que
          estén en ese estado (puede ser con cualquier atributo, acá usamos ID).
          Si están en el estado original significa que no se han tocado los botones
          para ir atras/adelante.
          Como vamos para adelante y no se han tocado los botones entonces iniciamos
          mostrando el primer procesado (ubicado en la posición 0).
          Traemos al procesado ubicado esta primera posición (0) y actualizamos la información.
        
          La importancia de este caso es que es la primera vez que se inicia.
          No se muestra un procesado al azar sino precisamente el primero.*/
        if (!system.getIndicteds().isEmpty()) {
            if (indicted_id.getText().equalsIgnoreCase("ID: ")) {
                Indicted firs_indicted = system.getIndicted(0);
                this.updateInfo(firs_indicted);
            /*Caso 2 : Cuando ya se han clickeado los botones. Cuando ya se muestra alguna info.
                
              Ya se muestra alguno info en los textos y en el área de texto.
              El estado de los textos (arriba izquierda) será >> Aributo: ALGO.
              Usamos el atributo de ID, sabiendo que la información iniciará desde
              el cuarto (4) caracter >> ID: A (I>0, D>1, :>2, "espacio">3.
              Usamos el método substring(4) para tomar todo el texto que inicia en el
              caracter 4, es decir, en últimas el método nos devuelve el ID del procesado.
              Usamos ese ID para averiguar la posición del procesado que se está mostrando actualmente.
              Mirar abajo.*/
            } else {
                //Ubicamos la última posición (tamaño - 1) para posteriormente utilizarla.
                int last_position = system.getIndicteds().size() - 1;
                String currentIndictedDisplayed_id = this.indicted_id.getText().substring(4);
                /*Lo que hace esta línea es darlos la posición del procesado del
                  cual estamos mostrando la posición. Es la POSICIÓN ACTUAL.*/
                int currentIndictedDisplayed_position = system.findIndicted(currentIndictedDisplayed_id);
                /*Si la posición actual es la última y vamos para adelante (>>)
                  entonces debemos volver al inicio. Buscamos la primera posición (0)
                  y traemos el procesado asociado a esa posición. Luego actualizamos la info
                  de los textos y del área de texto.*/
                if (currentIndictedDisplayed_position == last_position) {
                    Indicted first_indicted = system.getIndicted(0);
                    this.updateInfo(first_indicted);
                /*Si la posición actual es otra diferente de la última (tamaño -1),
                  sencillamente SUMAMOS 1 a la posición actual y traemos al procesado
                  asociado a ella. Actualizamos la información con los datos de este procesado.*/
                } else {
                    Indicted indicted_after = system.getIndicted(currentIndictedDisplayed_position + 1);
                    this.updateInfo(indicted_after);
                }
            }
        }
    }

    /*Método adicional para simplificar. Encargado de actualizar la información
      en los textos (arriba izquierda) y en el área de texto (arriba derecha).
      Este método se creo para facilitar las cosas en los dos métodos anteriores:
      go_forwardMouseClicked() y go_backMouseClicked().*/
    private void updateInfo(Indicted indicted) {
        /*Tiene como parámetro un procesado llamado "indicted", lo que hace es
          tomar la información de este y la coloca en los textos.*/
        this.indicted_name.setText("Nombre: " + indicted.getName());
        this.indicted_lastname.setText("Apellido: " + indicted.getLastName());
        this.indicted_id.setText("ID: " + indicted.getIdentification());
        this.indicted_age.setText("Edad: " + indicted.getAge());
        this.sentence_years.setText("Años de condena: " + indicted.getYearsOfSentence());

        /*Trae la lista de crimenes del parámetro "indicted" y la itera guardando
          cada crimen en la variable "display" separandolos por un salto de línea(\n\n)
          Luego recorta los saltos de línea al final que son inncesarios y finalmente
          coloca estos antecedentes en el area de texto.*/
        ArrayList<CriminalRecord> crimes = indicted.getCriminalRecord();
        String display = "";
        for (CriminalRecord crime : crimes) {
            display += crime.toString() + "\n\n";
        }
        display = display.trim();
        this.background.setText(display);
    }

    /*Añade un crimen a un procesado.*/
    private void add_sentenceMouseClicked(MouseEvent evt) {
        /*Revisa que la lista de procesados no esté vacía (si está vacía pues no
          hay nadie a quien añadirle una condena).
          Le piden al usuario los parámetros necesarios y finalmente agrega el
          crimen al procesado.
          Las cuestiones de validación (que exista el ID del procesado y que no
          se repita el ID del crimen)se realizan en la clase CriminalRecordSystem.*/
        if (!system.getIndicteds().isEmpty()) {
            String indictedId = JOptionPane.showInputDialog("Identificación del procesado [Alfanúmerico]");
            int crimeId = Integer.parseInt(JOptionPane.showInputDialog("ID para el crimen [Númerico]"));
            String type = JOptionPane.showInputDialog("Tipo de crimen:");
            String description = JOptionPane.showInputDialog("Descripción del crimen:");
            system.addRecordToIndicted(indictedId, crimeId, type, description);
        }
    }
    
    /*Permite mirar un crimen específico.*/
    private void see_sentenceMouseClicked(MouseEvent evt) {
        /*Revisa que la lista de procesados no esté vacía (si está vacía pues no
          hay nadie, no hay ningún crimen para ver).
          Le piden al usuario el ID del crimen que quiere ver.
          Se busca en el sistema si existe ese ID de crimen. Si no existe (crime == null)
          entonces se muestra el mensaje correspondiente.
          En caso de que sí exista (parte del else) se muestra el crimen en un cuadro aparte.*/
        if (!system.getIndicteds().isEmpty()) {
            int crimeId = Integer.parseInt(JOptionPane.showInputDialog("ID para el crimen [Númerico]"));
            CriminalRecord crime = system.findCriminalRecord(crimeId);
            if (crime == null) {
                JOptionPane.showMessageDialog(null, "No existe un crimen con esa identificación.", "Aviso", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, crime.toString(), "Crimen #" + crimeId, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    /*Elimina un crimen de un procesado.*/
    private void eliminate_sentenceMouseClicked(MouseEvent evt) {
        /*Revisa que la lista de procesados no esté vacía (si está vacía pues no
          hay nadie, no hay ningún crimen para eliminar).
          Pide al usuario el ID del procesado y el ID del crimen.
          Elimina el crimen del procesado.
          Las validaciones para saber si existen los ID se realizan en la clase
          CriminalRecordSystem.*/
        if (!system.getIndicteds().isEmpty()) {
            String indictedId = JOptionPane.showInputDialog("Identificación del procesado [Alfanúmerico]");
            int crimeId = Integer.parseInt(JOptionPane.showInputDialog("ID para el crimen [Númerico]"));
            system.removeCriminalRecordOfIndicted(indictedId, crimeId);
        }
    }
    
    /*Condena un crimen de un procesado. En otras palabras, le asigna el número
      de años de condena que debe cumplir por ese crimen.*/
    private void change_sentenceMouseClicked(MouseEvent evt) {
        /*Revisa que la lista de procesados no esté vacía (si está vacía pues no
          hay nadie, no hay ningún crimen para condenar).
          Pide al usuario el ID del procesado, el ID del crimen a condenar y la
          condena que le va a imponer.
          Con el "crimeId" se trae el crimen "crime".
          Si este "crime" es igual a "null" significa que no existe el crimen con ese ID.
          Y también se verifica que existe el procesado (parte de else if ... false)
          Si existe el crimen y el procesado, se pasa a condenarlo. (Último else)
          Las verificaciones para saber si la condena está dentro del rango correcto
          se realizan en la clase CriminalRecorSystem.*/
        if (!system.getIndicteds().isEmpty()) {
            String indictedId = JOptionPane.showInputDialog("Identificación del procesado [Alfanúmerico]");
            int crimeId = Integer.parseInt(JOptionPane.showInputDialog("ID para el crimen [Númerico]"));
            int sentence = Integer.parseInt(JOptionPane.showInputDialog("Número de años para el crimen [Númerico]"));
            CriminalRecord crime = system.findCriminalRecord(crimeId);
            if (crime == null) {
                JOptionPane.showMessageDialog(null, "No existe un crimen con esa identificación.", "Aviso", JOptionPane.PLAIN_MESSAGE);
            }else if(system.existsIndected(indictedId) == false){
                JOptionPane.showMessageDialog(null, "No existe un procesado con esa identificación.", "Aviso", JOptionPane.PLAIN_MESSAGE);
            }else{
                system.sentenceIndicted(indictedId, crimeId, sentence);
            }            
        }
    }

    /*¡¡¡NOTA!!!
    
      Para crear una reacción al presionar un boton (para el caso Opción1/2), 
      sencillamente se crea el MouseListener (ver lineas 193 - 203) y luego se
      coloca el MouseClicked (ver lineas 431 - 439)
    
    */
    
    public static void main(String args[]) {
        /*Código auto generado por el GUI Creator de NetBeans para fijar la apariencia general.*/
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*Hace visible los componentes gráficos. Inicia el programa.*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

}
