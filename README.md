
# Transaction Report

Esta aplicación de línea de comandos procesa un archivo CSV con transacciones bancarias y genera un reporte con el balance final, la transacción de mayor monto y el conteo de transacciones por tipo (Crédito/Débito).


## Instrucciones de Ejecución

### Requisitos Previos

-  Java 17 o superior instalado.

### Compilación y Ejecución

1- Compilar el código:

    javac TransactionReport.java

2- Ejecutar la aplicación pasando el archivo CSV como argumento:

    java TransactionReport ruta_del_archivo.csv


## Enfoque y Solución

- Se lee el archivo CSV e ignora la primera línea (encabezado).

- Se almacena cada transacción en una lista de objetos Transaction.

- Se calcula el balance sumando los créditos y restando los débitos.

- Se identifica la transacción de mayor monto utilizando max().

- Se cuentan las transacciones de cada tipo con filter() y count().
## Estructura del Proyecto

- TransactionReport.java  # Código principal de la aplicación
- README.md               # Documentación del proyecto
- transactions.csv        # Archivo de ejemplo con datos de prueba
## Authors

- [@molleapaza98](https://github.com/molleapaza98)
