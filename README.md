# frameworkfravega
Framework de FrontEnd  y BackEnd para pruebas


Aclaraciones:
El el documento Challenge QA Automation

En el assert: Test Frontend
1 - Cada uno de los elementos contenga "samsung" en su title.
la palabra samsung arranca con la "s" minuscula y todos los elementos en 
el titulo contiene "Samsung" con "S" mayuscula. por ejemplo:
 * Heladera No Frost Inverter Samsung RT38K5932SL 396Lt

3 - En el breadcrumb de la página (atributo name="breadcrumb") se visualize "Heladeras con Frezzer"
 en el breadcrumb no existe "Heladeras con Frezzer".



El framework esta armado con:
- IDE intellij (la Version openSource)
- java 8
- Patrón "Page Object"
- lenguaje de programación Java 
- Maven
- TestNG
- Cucumber
- Allure(Para el reporte)

*Test Frontend:
- Selenium WebDriver

*Test Backend:
- Rest Assured


Repositorio Github: https://github.com/rorymer1989/frameworkfravega.git

clonar el repsitorio en esta ruta
C:\Workspace\
Con:
 git clone https://github.com/rorymer1989/frameworkfravega.git

Reporte: Allure
allure-commandline-2.13.3.zip
https://drive.google.com/drive/folders/1YbSpmYn7Nw5IGPjOT3rBmlykapi_3FVZ?usp=sharing
1 Descargar y la carpeta colocarla en C:\Program Files\
2 en el Path de la variable de entorno agregar C:\Program Files\allure-2.13.3\bin

****** Se corre el framework con la testng.xml *********

Luego de Correr la prueba pegar esta ruta en la consola CMD

allure serve C:\Workspace\frameworkfravega\allure-results

y presionar enter.
