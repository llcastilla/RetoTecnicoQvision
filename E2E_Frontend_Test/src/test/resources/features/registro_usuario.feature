Feature: Registro de usuario

  Scenario Outline: Registro exitoso
    Given que el usuario se encuentra en la página de registro <data>
    When completa todos los campos obligatorios con datos válidos
    Then el sistema debe mostrar un mensaje de confirmación
    Examples:
      | data             |
      | registro_usuario |