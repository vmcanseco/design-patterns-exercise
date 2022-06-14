# PATRONES DE DISEÑO

1. Hacer fork del proyecto y trabajarlo en sus propios repositorios
2. Ejecutar los archivos .bat del directorio lib para instalar las bibliotecas de prueba
3. Refactorizar el código para utilizar singleton para evitar crear múltiples instancias para las clases que representan
dispositivos (display, teclado, modem, gps, ethernet)
4. Refactorizar el código para utilizar builder para construir el objeto Transaction (tomar como ejemplo CardBuilder y ExpirationDateBuilder)
5. Refactorizar el código para utilizar un AbstractFactory y soportar múltiples modelos/marcas de terminal con el mismo código en Application basado 
en interfaces
6. Refactorizar el código para utilizar Strategy para manejar los dispositvos relacionados a la comunicación en el método doSale de Application
7. Modificar la lectura de la tarjeta para que se vea así
```java
CardProvider cardProvider = ...;


cardProvider.readCard(card -> {
    
});

```

Referencia: https://sourcemaking.com/design_patterns 

Fecha estimada de entrega: Martes 24 de marzo 
