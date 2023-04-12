from clase import MiClase

nombre = str(input("\n¿Cuál es tu nombre?\n"))
edad = int(input("\n¿Cuál es tu edad?\n"))
numero = int(input("\n¿Hasta que número quieres que cuente?\n"))
frutas = str(input("\nIngresa una lista de las frutas que más te gustan separadas por comas\n")).split(",")
posicion = int(input("\n¿Qué posición de la lista de frutas quieres que te muestre?\n"))

objeto = MiClase(nombre, edad, numero, frutas, posicion)
objeto.miFuncion()
objeto.verificarEdad()
objeto.cicloWhile()
objeto.cicloFor()
objeto.buscarLista()

print("\nEn conclusión los datos que fueron ingresados son: \n", "Nombre: ", objeto.getNombre(), 
      "\n", "Edad: ", objeto.getEdad(), "\n", 
      "Número hasta el cual me pediste que contara: ", objeto.getNumero(), "\n", 
      "Frutas que ingresaste: ", objeto.getFrutas(), "\n", 
      "Posición que me pediste que te enseñara de la lista de frutas: ", objeto.getPosicion())  