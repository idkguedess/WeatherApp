# Práctica 1: Captura de datos a partir de fuentes externas.

---
**Desarrollo de Aplicaciones para Ciencia de Datos.**

**Grado en Ciencia e Ingeniería de Datos, Escuela Universitaria de Informática,
Universidad de Las Palmas de Gran Canaria.**

---

### Resumen de funcionalidad

El programa obtiene la predicción metereológica de los próximos 5 días a las 12 pm de las 8 islas de Canarias. Para ello,
consulta la API de [OpenWeatherMap](https://https://openweathermap.org/api "OpenWeatherMap"). Estos datos son posteriormente
almacenados en una base de datos de tipo SQL, con una tabla para cada isla con las fechas, temperaturas, humedad,
velocidad del viento y las nubes.

### Recursos utilizados

El desarrollo del proyecto se ha realizado en Maven utilizando el entorno Intellij. Se ha utilizado Git como herramienta
de control de versiones local y GitHub en línea. Para la obtención y persistencia de los datos, se han utilizado diferentes
librerías:
* HttpClient de Apache como cliente http.
* Jackson para deserialización.
* SQLite y JDBC para la persistencia.

### Diseño

La estructura del código se divide en dos capas.
1. Model: contiene todo el código referente a los objetos que contendrán los datos meteorológicos.
2. Control: contiene todo el código referente a obtener los datos, deserializarlos y almacenarlos en la base de datos.

Se ha intentado cumplir en la mayor medida posible con los siguientes principios:
1. DRY (Don't repeat yourself).
2. KISS (Keep it Simple Stupid).
3. SoC (Separation of Concerns).
4. YAGNI (You ain't gonna need it)
