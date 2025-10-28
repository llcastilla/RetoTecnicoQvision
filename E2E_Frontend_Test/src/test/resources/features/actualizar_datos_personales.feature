Feature: Mi cuenta
  Scenario Outline: Modificar datos personales
    Given que el usuario ha iniciado sesión <data>
    When actualiza su número de teléfono y guarda los cambios
    Then el sistema debe mostrar un mensaje de confirmación de actualizacion
    Examples:
      |data  |
    |   modificar_datos_personales   |