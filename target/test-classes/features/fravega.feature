Feature: fravega Test
  This is example of using Cucumber-JVM with TestNG and Selenium
  # Para ver el reporte tenes que poner por consola esta direccion
  # allure serve C:\Users\pitt\IdeaProjects\FrameworkFravegaAutomation\allure-results
  # allure serve C:\Users\{User}\IdeaProjects\FrameworkFravegaAutomation\allure-results
  # allure serve C:\Workspace\frameworkfravega\allure-results

  @Test
  Scenario: 1 - Cada uno de los elementos contenga "samsung" en su title
    Given Se ingresa la home de Frávega
    When Se ingresa en el campo busqueda la palabra "Heladera"
    And Hace clic en el botón búsqueda
    And Se filtra por "Heladeras" en la subcategoria en la sección izquierda de la página
    And Se filtra por "Samsung" en marca en la sección izquierda de la página
    Then Verifica que cada uno de los elementos contenga "Samsung" en su title

  @Test
  Scenario: 2 - La cantidad de elementos de la lista coincida con los resultados mostrando por el frontend.
    Given Se ingresa la home de Frávega
    When Se ingresa en el campo busqueda la palabra "Heladera"
    And Hace clic en el botón búsqueda
    And Se filtra por "Heladeras" en la subcategoria en la sección izquierda de la página
    And Se filtra por "Samsung" en marca en la sección izquierda de la página
    Then Verifica la cantidad de elementos de la lista coincida con los resultados mostrando por el frontend

  @Test
     # Fail - No Existe breadcrumb "Heladeras con Frezzer"
     # breadcrumb Reemplazar --->  "Frávega" Por  "Heladeras con Frezzer"
     # breadcrumb Reemplazar --->  "Heladeras, Freezers y Cavas" Por  "Heladeras con Frezzer"
     # breadcrumb Reemplazar --->  "Heladeras" Por  "Heladeras con Frezzer"
  Scenario: 3 - En el breadcrumb de la página (atributo name="breadcrumb") se visualize "Heladeras con Frezzer"
    Given Se ingresa la home de Frávega
    When Se ingresa en el campo busqueda la palabra "Heladera"
    And Hace clic en el botón búsqueda
    And Se filtra por "Heladeras" en la subcategoria en la sección izquierda de la página
    And Se filtra por "Samsung" en marca en la sección izquierda de la página
    Then Verifica en el breadcrumb de la página se visualize "Heladeras con Frezzer"

  @Test
  Scenario: 4 - Test Backend
    Given Obtener una lista de cervecerías que contengan el texto "lagunitas" en su nombre
    When De la lista de resultados del punto 1, tomar aquellos que contengan en la key 'name', el valor "Lagunitas Brewing Co"
    When A través del siguiente servicio, obtener el detalle de cada cervecería de la lista del punto 2 y tomar solo el que contenga 'state' = "California"
    Then Sobre la cervecería resultante, assertar lo siguiente "761","Lagunitas Brewing Co","1280 N McDowell Blvd","7077694495"
