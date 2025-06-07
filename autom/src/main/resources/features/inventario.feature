Feature: Prueba de Inventario en SauceDemo

  Scenario: Verificar que los productos se muestran correctamente
    Given El usuario ha iniciado sesión correctamente
    When El usuario navega a la página de inventario
    Then Los productos deben aparecer con su nombre, descripción, imagen y precio

  Scenario: Verificar el contador del carrito
    Given El usuario ha iniciado sesión correctamente
    When El usuario agrega la mochila al carrito
    Then El ícono del carrito debe mostrar el número "1"

  Scenario: Verificar el contador incorrecto del carrito
    Given El usuario ha iniciado sesión correctamente
    When El usuario agrega la 2 productos al carrito
    Then El ícono del carrito debe mostrar el número "1"
