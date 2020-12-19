Responsabilidades de las clases:

La clase Game sera la clase main del programa, dentro de esta se daran las peleas entre 
heroes y villanos.

Como atributos esta clase tendra 2 listas estaticas que contedran 
todos los personajes y todos los equipos que se creen.

Metodos:
fightByStat : A este metodo recibe como parametros 2 personajes o equipos de diferentes bandos, 
los cuales lucharan entre si. Ademas recibira un String que representara el atributo que decidira 
el ganador de la pelea. En caso de empate en dichos atributos, se realizara la comparacion entre otros atributos.
Y si todos los atributos de los luchadores son iguales, se declarara un empate.

fight: Este metodo es similar al metodo anterior, la diferencia es que se comparan todos los atributos
desde el inicio. El empate tambien se dara igual que en el metodo anterior

whoBeats: Este metodo recibe por parametro a un personaje y devuelve una lista con todos los personajes 
y equipos que vencen a dicho personaje teniendo en cuenta todos los atributos

whoBeatsByStat: Similar al anterior, pero con respecto a un atributo en particular



La clase Group es una interfaz que utiliza el patron composite para permitir crear equipos que contengan
personajes y otros equipos.

Esta interfaz es implementada por la clase Character y la clase Team

La clase Character tiene como atributos: 
Nombre real y ficticio
Un booleano que nos dice si es heroe o villano
Un atributo del tipo Stat(esta clase contiene los atributos comunes a todos los personajes que se creen)
Un lista de tipo Ability(esta clase contiene habilidades unicas que se le pueden agregar a algunos personajes
para modificar sus atributos comunes)

Metodos:

canAddCharacter: Se encarga de ver si el personaje que intentamos crear ya existe. Si es asi el constructor
de Character arrojara una IllegalArgumentException

addAbility: Añade determinada habilidad al personaje si este ya no la tiene o si pertenece al bando
indicado

La clase Team tiene como atributos:
Nombre del equipo
Lista de tipo Group que contendra todos los integrantes de ese equipo
Un booleano que indicara si el equipo es de heroes o villanos

Metodos:
addGroup: Añade el personaje o subequipo al equipo si se cumplen algunas condiciones:
Si es un personaje, tiene que ser del mismo bando y no tiene que encontrarse ya en el equipo ya que en un
equipo no puede encontrarse un personaje mas de 1 vez
Si es un subequipo,el nombre no puede ser el mismo, deben ser del mismo bando y dicho subequipo no 
puede tener a un personaje que se encuentre en el equipo

refreshAllTeams: Se encarga de actualizar la lista de todos los equipos

sortByCriteria: Retorna una lista de personajes ordenados teniendo en cuenta todos los criterios que se quieran
En el caso de que haya campos iguales(teniendo en cuenta los criterios de orden), se decidira el orden por el 
nombre ficticio ya que este es unico

Para realizar este ordenamiento se utiliza la clase CharacterComparator que contiene las comparaciones a realizar
para poder ordenar la lista de personajes

La clase Ability es una clase Abstracta que permite crear habilidades unicas que se podran asignar a los 
personajes

Los atributos de esta clase son:
Nombre 
Descripcion 
Un booleano que determina si la habilidad es heroica o no. Esto es asi debido a que las habilidades
son para villanos o heroes.

Despues, en cada clase hijo que creemos, tendremos que implementar el metodo abstracto refreshStats.
Este metodo actualizara las estadisticas del personaje al que se le asigno la habilidad(tambien se 
actualiza en la lista de todos los personajes)




