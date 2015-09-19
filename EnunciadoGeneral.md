# Introduction #

El presente trabajo consiste en el desarrollo de un juego simil “Guitar Hero”.
Link con un juego similar online:
http://www.funny-games.biz/guitar-master-4.html


# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages

Descripción básica del juego:
Algo-Hero es un juego que pone a prueba las habilidades del jugador para manipular el teclado de la computadora y seguir un ritmo determinado. El juego consiste en una secuencia de niveles, en cada uno de los cuales el usuario debe presionar ciertas combinaciones de teclas según se lo va especificando el juego. A medida que el usuario pasa de nivel, estos se vuelven más complejos, agregando más combinaciones de teclas.
El juego permite al jugador tocar canciones con una guitarra electríca. La guitarra se simula con el teclado. Se definen 4 teclas que permiten al jugador tocar parte de la melodía.
El juego muestra al jugador cuales son las teclas que debe tocar. Las notas van moviendose hacia la parte inferior de la pantalla, y el jugador debe presionar la tecla asociada a cada nota en el momento justo que alcanza la parte inferior de la pantalla. Cada vez que el jugador toca la nota correcta, suma puntos.

Elementos del juego:
  * Canciones
Las canciones en general se representan en notación musical mediante una partitura. La partitura contiene los compases, y en ellos las notas (tonos), y cada nota está asociada a una figura musical que define la duración de la misma (ver más adelante).

  * Notas
Cada tecla habilitada en una canción, tiene asociada uno o más tonos musicales (notas). Por ejemplo en la canción "1" la tecla "A" puede tener asociada el tono musical correspondiente con DO, RE, RE#, y en la canción "2" la misma tecla "A" podría tener asociada otros tonos, por ejemplo FA y SOL. Los tonos que maneja el juego son:
DO, DO#, RE, RE#, MI, FA, FA#, SOL, SOL#, LA, LA#, SI
(# significa sostenido)
Cada una tiene una frequencia fundamental que la identifica.

  * Figuras musicales
Las figuras musicales representan el tiempo que suena cada nota:
REDONDA
BLANCA (equivalente en tiempo a 1/2  REDONDA)
NEGRA (equivalente en tiempo a 1/2 BLANCA)
CORCHEA (equivalente en tiempo a 1/2 NEGRA)
SEMICORCHEA (equivalente en tiempo a 1/2 CORCHEA).
Como se ve, los tiempos son relativos a la duración de la "redonda".
Pero la duración de la redonda no es fija (ver definición de "compás").

  * Compás
Una partitura se divide en compases. La longitud de un compás no se mide en tiempo físico, sino en figuras musicales. Por ejemplo, es típico en varios estilos musicales que un compás dure 4 “NEGRAS”. La duración de un compás se define en la partitura, por ende todos los compases de la partitura tendrán la misma duración.
Cada canción tiene asociado un tiempo de "compas". Por ejemplo, el "compas" para una canción en particular puede durar 2 segundos, pero para otra canción puede durar 3 segundos, independientemente de su duración en “figuras musicales”.
Por ejemplo, en una cancion el "compas" puede equivaler a una redonda, pero para otra canción puede equivaler a 3 blancas.
Dada una equivalencia y una duración para el compas, queda determinado el tiempo de la canción y la duración de cada figura.
Por ejemplo, si en una cancion el compas equivale a 3 blancas y dura 2 segundos, entonces, en esa cancion:
REDONDA = 1.32 segundos
BLANCA = 0.66 segundos
NEGRA = 0.33 segundos
CORCHEA = 0.16 segundos
SEMICORCHEA = 0.08 segundos

Una consecuencia de esto, es que agrandando o achicando el tiempo de compas, la misma cancion puede tocarse mas lenta o mas rapida, manteniendo la misma melodia.
Dinámica del juego:

El jugador selecciona una canción a tocar.
En base a la canción seleccionada, el modelo del juego arma la partitura (es decir, las notas y figuras musicales asociadas a la canción). A su vez cada canción tiene asociado un compás.
Dada la partitura, el compás, y el mapeo de cada nota a cada tecla, el juego puede calcular en qué momento debe presionarse cada tecla, y en base a eso armar un mapa temporal que más adelante se mostrará al usuario por pantalla.


Normas generales de entrega:

  * La estructura de carpetas que se entrega deberá tener como raíz una carpeta o paquete con el siguiente nombre: algo3c[1|2|3]g[número de grupo]. Donde 1, 2 o 3 es el curso en el cual está inscripto el grupo. Ej: algo3c1g8 es la carpeta que deberá usar el grupo 8 del curso 1 (turno tarde).
  * La documentación deberá estar en 1 sólo archivo (texto y diagramas) preferiblemente en formato .pdf o en su defecto como .doc.
  * Deberá coordinar con su ayudante asignado si se entregará el código fuente impreso y su formato.