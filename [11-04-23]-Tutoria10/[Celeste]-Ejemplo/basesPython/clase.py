class MiClase: 
    def __init__(self, nombre, edad, numero, frutas = [], posicion = 0):
        self.nombre = nombre
        self.edad = edad   
        self.numero = numero
        self.frutas = frutas
        self.posicion = posicion
    
    def miFuncion(self):
        print("\nHola, tu nombre es ", self.nombre, " y tienes ", self.edad, " años")

    def verificarEdad(self):
        if self.edad >= 18:
            print("Eres mayor de edad\n")
        else:
            print("Eres menor de edad\n") 

    def cicloWhile(self):
        i = 0
        print("Cuenta hasta el número: ", self.numero)
        while i <= self.numero:
            print(i)
            i += 1 
    
    def cicloFor(self):
        print("\nLista de frutas: ", self.frutas)
        i = 0
        for fruta in self.frutas:
            print("Posicion ", i, " ", fruta) 
            i += 1

    def buscarLista(self):
        print("\nLa fruta en la posición ", self.posicion, " es ", self.frutas[self.posicion])

    def getNombre(self):
        return self.nombre
    
    def getEdad(self):
        return self.edad
    
    def getNumero(self):
        return self.numero
    
    def getFrutas(self):
        return self.frutas
    
    def getPosicion(self):
        return self.posicion
    
    def setNombre(self, nombre):
        self.nombre = nombre

    def setEdad(self, edad):
        self.edad = edad

    def setNumero(self, numero):
        self.numero = numero
    
    def setFrutas(self, frutas):
        self.frutas = frutas
    
    def setPosicion(self, posicion):
        self.posicion = posicion
    
    