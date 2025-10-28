Feature: Compra de tarjeta de regalo

  Scenario Outline: : Adquirir una tarjeta de regalo con valor seleccionado
    Given que el usuario accede al producto <data>
    When selecciona el valor del bono
    Then el sistema agrega la tarjeta de regalo  al carrito de compras
    Examples:
      | data                  |
      | compra_tarjeta_regalo |
