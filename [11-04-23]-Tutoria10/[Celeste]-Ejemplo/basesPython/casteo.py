# Descripción: Casteo de variables en Python
edad = int(input("¿Cuál es tu edad?\n"))
print("Entonces tu edad es ", edad, " :)") 
nacimiento = str(2023 - edad)
nacimiento2 = int(2023 - edad)  
print("Tu año de nacimiento es: ", nacimiento) 
print("Si sumamos tu edad y tu año de nacimiento, el resultado es: ", edad + nacimiento2)
print("Tipos de dato: ","Edad: ", type(edad), "Nacimiento: ", type(nacimiento2), "Nacimiento casteado: ", type(nacimiento)) 

