Responsabilidades de las clases:

La clase Game es la clase principal del programa, contendra por lo menos
2 equipos(1 de heroes y otro de villanos) que lucharan entre si . 
El programa no permite que 2 equipos de heroes peleen entre si.

Las peleas se desarrollaran por turnos, donde en cada turno 
luchara 1 heroe vs 1 villano . Ganara el personaje que ,mediante un 
calculo de las estadisticas, obtenga un valor de poder mayor al otro.
Adjunto una imagen que facilitara el entendimiento y calculo de dichos 
valores de poder.
El personaje perdedor luego podra enfrentarse nuevamente a otro personaje
del equipo contrario. Ganara el equipo que logre ganar peleas con todos
sus integrantes
Un ejemplo de una pelea:

Equipo Heroes. 
Integrantes:
HeroeA
HeroeB
HeroeC

Equipo Villanos.
Integrantes:
VillanoA
VillanoB
VillanoC

Ronda1:(el programa los elegira aleatoriamente, en este caso utilizaremos
un orden para facilitar el ejemplo)

HeroeA 
vs
VillanoA

Gana HeroeA, por lo tanto no podra volver a pelear

Ronda2

Equipo Heroes.
Integrantes:
HeroeA //gano
HeroeB
HeroeC

Equipo Villanos
Integrantes:
VillanoA
VillanoB
VillanoC

HeroeB vs VillanoA

Gano VillanoA, por lo tnato no podra volver a pelear

Ronda3

Equipo Heroes.
Integrantes:
HeroeA //gano
HeroeB
HeroeC

Equipo Villanos
Integrantes:
VillanoA//gano
VillanoB
VillanoC

HeroeB vs VillanoB

Gana HeroeB, por lo tanto no podra volver a pelear

Ronda4 
Equipo Heroes.
Integrantes:
HeroeA //gano
HeroeB //gano
HeroeC

Equipo Villanos
Integrantes:
VillanoA//gano
VillanoB
VillanoC

HeroeC vs VillanoB

Gana HeroeC, como ya ganaron todos los integrantes de ese equipo
El ganador de la pelea es el equipo de heroes.
(En el caso de que haya menor cantidad de integrantes de un equipo
que del otro, la cantidad de victorias necesarias sera igual a la cantidad
de integrantes del equipo...//extraño pero capaz lo mejoro luego)

La interfaz Group permitira que, a traves del patron composite, puede
construir objetos mas complejos partiendo de otros mas sencillos. De esta 
forma podremos, por ejemplo, crear un equipo a partir de personajes y/o equipos

La clases Stats contendra los atributos de cada personaje(fuerza,agilidad,etc)
que podran ser modificados segun las habilidades que posea dicho personaje

La clase Ability es una clase abstracta que nos permitira crear nuevas habilidades
que se le asginaran a cada personaje.
Esta clase tendra un nombre y una descripcion.Ademas tendra un efecto 
especial, por lo cual, modificara los stats de los personajes
Ademas, esta clase permitira diferenciar entre habilidades heroicas y no heroicas
De esta forma no podremos agregar habilidades heroicas a un villano



La clase Character implementa Group para lo que explicamos previamente.
Esta clase contendra el nombre real y nombre de heroe para reconocerlos .
Tambien tendra un booleano que nos dira si el personaje es heroe o villano.
Contendra un atributo de la clase Stats y una lista de Ability. Debido
a que un heroe puede tener ninguna o muchas habilidades(no se pueden repetir)

La clase Team nos permitira crear equipos de Character o Team utilizando 
la interfaz group. La condicion para agregar elementos en un team son:
Los bandos deben coincidir(equipo heroes contiene solo heroes), el nombre
de un subequipo no puede ser el mismo que el del equipo y por ultimo 
los personajes de un equipo no pueden repetirse 
