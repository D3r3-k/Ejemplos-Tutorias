# Este es un comentario :u
print("Hola") #Otro comentario

# Amarillo
# Rojo
# Azul

"""
Este también es un comentario,
pero tiene varias líneas :u
Holi
"""

#Asignar valor a una variable
variable_entera = 5
variableDecimal = 1.4
VariableTexto = "Hola mundo"
lista_colores = ["Rojo", "Amarillo", "Azul"]

#String multilíneas
cadena = """Este es un String de
varias líneas...
    a e i o u
:u"""
print(cadena)

#Acceder a los caracteres de un String
cadena2 = "Gato"
print(cadena2[0])
print(cadena2[1])
print(cadena2[2])
print(cadena2[3])

#Saber el tamaño de un String
cadena3 = "Computadora"
print("Tamaño de cadena3:", len(cadena3))

#Saber si una frase o caracter determinado se encuentra en el String
texto = "Pizza, papas, soda, hamburguesa, queso"
print("queso" in texto)
print("manzana" in texto)
#Saber si una frase o caracter determinado no se encuentra en el String
print("manzana" not in texto)

#Pasar un String a mayúsculas
texto = "Hola mundo :u"
print(texto.upper())

#Pasar un String a minúsculas
texto = "HoLa MuNdO :U"
print(texto.lower())

#Quitar espacios en blanco al inicio y final de un String
texto = "   Hola Mundo :u             "
print(texto.strip())

#Reemplazar caracteres de un String
texto = "Gato"
print(texto.replace("G", "P"))
texto = "Manzana"
print(texto.replace("a", "e"))

#Separar un String
texto = "Sopa,Pescado,Ensalada,Limonada"
lista = texto.split(",")
print(lista)

#Asignar valores a más de una variable
boolean1, boolean2 = True, False

#Asignar un mismo valor a más de una variable
entero1 = entero2 = entero3 = 2

#Asignar un nuevo valor a lista_colores y asignar sus elementos a distintas variables
lista_colores = ["Verde", "Anaranjado", "Morado"]
color1, color2, color3 = lista_colores

#Imprimir el valor de una variable
print("Color1:", color1, "Color2:", color2, "Color3:", color3)
print("Hola número:", entero1)
print("Hola número: " + str(entero1))
print("---" + VariableTexto)

#Conocer el tipo de dato de una variable
variable = 5.4
print("variable -> ", type(variable))

#Castear datos
numero = 5.4852
numero_e = int(numero)
print("numero_e ->", type(numero_e), " -> ", numero_e)

numero = -85.6
texto = str(numero)
print("texto ->", type(texto), " -> ", texto)

#Ingreso de datos por parte del usuario
nombre = input("Ingrese su nombre:")
print(nombre)
edad = int(input("Ingrese su edad:"))
print(edad, "->", type(edad))

#Operadores aritméticos
print("\n---OPERADORES ARITMÉTICOS---")
print(5+6) #Suma
print(5-6) #Resta
print(5*6) #Multiplicación
print(12/5) #División
print(5%6) #Modulo
print(5**6) #Potencia
print(12//5) #División truncada

#Operadores de comparación
print("\n---OPERADORES DE COMPARACIÓN---")
print(5>6) #Mayor que
print(5>=6) #Mayor o igual que
print(5<6) #Menor que
print(5<=6) #Menor o igual que
print(5==6) #Igual que
print(5!=6) #No es igual que

#Operadores lógicos
print("\n---OPERADORES LÓGICOS---")
print(True and True) #Operador "y", devuelve True si ambos son True
print(True or False) #Operador "o", devuelve True si alguno de los dos es True
print(not True) #Operador "no", devuelve el valor contrario

#Lista
lista = ["Hola", 5, 1.2, False, [4,2,3]]
print(lista)

#Tamaño de una lista
print(len(lista))

#Acceder a elementos de una lista
print(lista[0])
print(lista[4])

#Saber si hay un elemento en una lista
print(5 in lista)

#Insertar un elemento en una posición determinada de la lista
lista.insert(1, "a")
print(lista)

#Agregar un elemento al final de la lista
lista.append(-8.359)
print(lista)

#Remover un elemento de una lista
lista.remove(False)
print(lista)

#Eliminar un elemento en una posición específica de una lista
lista.pop(0)
print(lista)

#Copiar una lista
lista = ["Rojo","Verde", "Amarillo"]
lista_copia = lista.copy()
print(lista_copia)

#Vaciar una lista
lista.clear()
print(lista)

#Ordenar una lista
#Numéricamente
lista = [5, 3, 8, 1, 10, 2]
lista.sort()
print(lista)
lista.sort(reverse=True)
print(lista)

#Alfabéticamente
lista = ["pera", "piña", "naranja", "manzana"]
lista.sort()
print(lista)
lista.sort(reverse=True)
print(lista)

#Diccionarios
#Clave - Valor
diccionario = {
  "marca": "Toyota",
  "colores": ["Rojo", "Azul", "Negro"],
  #"año": 2001,
  "año": 2010 #Se sobreescribe el valor
}
print(diccionario)

#Acceder a los valores de un diccionario
print(diccionario["año"])

#Tamaño del diccionario
print(len(diccionario))

#Obtener las claves de un diccionario
print(diccionario.keys())

#Obtener los valores de un diccionario
print(diccionario.values())

#Obtener los pares de un diccionario
print(diccionario.items())

#Cambiar valores
diccionario["año"] = 2008
print(diccionario)

#Agregar un par clave valor al diccionario
diccionario["ruedas"] = 4
print(diccionario)

#Remover un par de un diccionario con una clave específica
diccionario.pop("marca")
print(diccionario)

#Elimina el último par agregado a un diccionario
diccionario.popitem()
print(diccionario)

#Vaciar un diccionario
diccionario.clear()
print(diccionario)

#Diccionarios anidados
estudiantes = {
  "estudiante1" : {
    "nombre" : "Rosa",
    "edad" : 15
  },
  "estudiante2" : {
    "nombre" : "Mateo",
    "edad" : 16
  },
  "estudiante3" : {
    "nombre" : "Luis",
    "edad" : 14
  }
}
print(estudiantes["estudiante1"])
print(estudiantes["estudiante1"]["nombre"])
print(estudiantes["estudiante1"]["edad"])

#IF / ELIF/ ELSE
numero1 = 5
numero2 = 8
if numero1 > numero2:
  print(numero1, "es mayor que", numero2)
elif numero1 < numero2:
  print(numero1, "es menor que", numero2)
else:
  print("Los números son iguales")

#pass sirve para ignorar la condición y continuar la ejecución
booleanIf = True
if booleanIf:
  pass
else:
  print("Es falso")

#IF anidados
if 8 > 5 and 7 > 2:
  print("Sí")
  if "hola" == "hola" or "a" == "e":
    print("Sí x2")
    if not False:
      print("Holi")
    else:
      print("Adiós")
  else:
    print("Nope")
else:
  print("No")

#Ciclo While
i = 0
while i < 5:
  print("Hola")
  i += 1

#break termina la ejecución del ciclo
i = 0
while i < 5:
  print(i)
  if i == 3:
    break
  i += 1

#Ejemplo de un menú con while
booleanMenu = True
while booleanMenu:
  print("Menú:"
        "\n1- Saludo"
        "\n2- Salir")
  try:
    opcion = int(input("Ingrese la opción a realizar"))
    if opcion == 1:
      print("Hola :3")
    elif opcion == 2:
      print("Saliendo del menú")
      booleanMenu = False
    else:
      print("No ingresó una opción válida")
  except:
    print("Dato inválido")

#Ciclo for
#Va del 0 al 5
#Se ejecuta una cantidad específica de veces
#La función range() retorna los números de 0 al número enviado como parámetro - 1
for numero in range(6):
  print(numero)

#Del 2 al 8, sin incluir el 8
for numero in range(2, 8):
  print(numero)

#Ciclo for each
texto = "Hola mundo :D"
for caracter in texto:
  print(caracter)

lista_objetos = ["Pelota", "Lapiz", "Cuaderno"]
for objeto in lista_objetos:
  print(objeto)