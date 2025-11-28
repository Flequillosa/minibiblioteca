**Versión 1 - Vista estática**
- Qué hace: Muestra una lista fija de libros como Strings "Título - Autor". Todo es estático; no se pueden añadir ni eliminar libros.
- Aprendizaje:
  - Introducción a Spring MVC y Thymeleaf.
  - Uso de Model para enviar datos al HTML.
  - Uso de th:each para recorrer listas en la vista.

**Versión 2 - Lista dinámica de Strings**
- Qué hace: Permite añadir libros dinámicamente desde la URL usando /add?titulo=...&autor=.... La lista es dinámica (ArrayList) y se puede modificar en tiempo de ejecución.
- Cambios con respecto a la versión 1: La lista deja de ser estática y ahora se pueden añadir libros desde la URL.
- Aprendizaje:
  - Diferencia entre lista estática y lista dinámica.
  - Uso de @RequestParam para recibir parámetros de la URL.
  - Cómo enviar listas dinámicas al modelo y mostrarlas en la vista.

**Versión 3 - Objeto Libro y eliminación**
- Qué hace: Cada libro es un objeto Libro con id, titulo y autor. Se pueden añadir libros y eliminarlos usando /delete/{id}.
- Cambios con respecto a la versión 2: Se usan objetos en lugar de Strings, cada libro tiene su ID único para poder eliminarlo individualmente, se añade la funcionalidad eliminar libros con @PathVariable.
- Aprendizaje:
  - Diferencia entre @RequestParam y @PathVariable.
  - Manejo de objetos con atributos y listas dinámicas.

**Versión 4 - Cambiar estado prestado/no prestado**
- Qué hace: Cada libro tiene un atributo prestado (true/false). La vista permite marcar un libro como prestado o disponible.
- Cambios con respecto a la versión 3: Se añade un atributo extra (prestado) a la clase Libro, se implementan enlaces para cambiar el estado de cada libro.
- Aprendizaje:
  - Cómo modificar objetos dinámicamente desde la vista.
  - Reflejar cambios en la interfaz del usuario usando Thymeleaf.

**Versión 5 - Mostrar libros prestados visualmente con CSS**
- Qué hace: La vista aplica estilos CSS para diferenciar los libros prestados (color de fondo y negrita). Se mantienen todas las funcionalidades anteriores: añadir, eliminar y cambiar estado.
- Cambios con respecto a la versión 4: Mejora visual de la información con CSS, los libros prestados se muestran con un estilo distinto.
- Aprendizaje:
  - Integración de CSS con Thymeleaf.
  - Cómo usar estados dinámicos para cambiar la apariencia de la vista.

**Versión 6 -Ampliación de funcionalidades**
- Qué hace: La aplicación ahora permite filtrar libros por estado (“prestado” o “disponible”) y buscar por título o autor. Además, cada acción del usuario (añadir, eliminar o cambiar el estado de un libro)
muestra un mensaje de confirmación en la interfaz. Se mantienen todas las funcionalidades anteriores: añadir, eliminar, cambiar estado y estilos CSS para libros prestados.
- Cambios con respecto a la versión 5: Incorporación de filtros por estado y búsqueda por título o autor,visualización de mensajes de confirmación tras cada acción del usuario.
- Aprendizaje:
  - Cómo implementar filtrado y búsqueda en la vista usando Thymeleaf.
  - Uso de mensajes de confirmación dinámicos para mejorar la experiencia del usuario.
  - Refuerzo del patrón MVC y la integración de lógica de negocio con la presentación visual.
  - 
