# *Las diez palabras más repetidas*

Este proyecto consiste en leer un archivo de texto cualquiera y listar las 10 palabras más repetidas
en el texto contenido en el archivo. 

### *Esto se puede hacer de la siguiente manera:*

1. Leer cada línea y separarla por espacios mediante el método split() de String. A cada
palabra del arreglo generado deben pasarla a minúscula con el método toLowerCase()
de String y quitarle todo signo de puntuación.

2. Cada palabra deben insertarla en un árbol AVL en donde cada nodo tendrá una palabra y
una variable contador que indica cuantas veces se ha encontrado dicha palabra. El árbol
AVL se rebalanceará mediante las palabras. Al insertar deben chequear si la palabra existe.
Si existe se incrementa en 1 el contador de ese nodo. Si no existe entonces se crea un
nodo con esa palabra nueva y el contador en 0. Al terminar de examinar el archivo el árbol
AVL debe estar construido con todas las palabras diferentes.

3. Por último, deben crear un montículo con un tamaño igual a la cantidad de palabras
diferentes (Cantidad de nodos del árbol AVL). Deben recorrer el árbol AVL e insertar la
información de cada nodo en el montículo con la salvedad de que ahora el montículo se
reorganizará con el contador de cada palabra y no con la palabra misma.

4. Al insertar todas las palabras en el montículo deben extraer 10 veces e imprimir 10 líneas
de la siguiente forma: 
*palabra - contador*
---
### *Nota:*

La modificación que se le debe hacer al árbol AVL es más que todo en los métodos de
rotación utilizando el método compareTo() de String para comparar dos String
