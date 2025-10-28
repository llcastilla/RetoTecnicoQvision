Feature: Agregar producto al carrito

  Scenario Outline: Agregar un producto exitosamente
    Given que el usuario está en la página de inicio <data>
    When selecciona un producto y lo agrega al carrito
    Then el producto debe aparecer en el carrito de compras
    Examples:
      | data                     |
      | agregar_producto_carrito |
