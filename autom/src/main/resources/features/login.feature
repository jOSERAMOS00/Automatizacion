Feature: Login de usuarios en SauceDemo

  Scenario: Login exitoso
    Given que estoy en la página de login de SauceDemo
    When ingreso usuario "standard_user" y contraseña "secret_sauce"
    Then debería ingresar al inventario

  Scenario: Login fallido por usuario incorrecto
    Given que estoy en la página de login de SauceDemo
    When ingreso usuario "usuario_incorrecto" y contraseña "secret_sauce"
    Then debería ver un mensaje de error

  Scenario: Login fallido por contraseña incorrecta
    Given que estoy en la página de login de SauceDemo
    When ingreso usuario "standard_user" y contraseña "clave_mal"
    Then debería ver un mensaje de error

