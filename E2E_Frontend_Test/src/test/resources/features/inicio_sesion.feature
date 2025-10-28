Feature: Inicio de sesión

  Scenario Outline: Acceso exitoso
    Given que el usuario tiene una cuenta registrada <data>
    When ingresa su correo y contraseña válidos
    Then el sistema redirige al panel de Mi cuenta
    Examples:
      | data          |
      | inicio_sesion |
