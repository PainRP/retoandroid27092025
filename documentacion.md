# Documentación del Proyecto: Generador de Frases de Motivación

## 1. Introducción

Este documento detalla el proceso de desarrollo de la aplicación **"Generador de Frases de Motivación"** para el reto **Android + Vibecoding**. El objetivo principal fue aprender a formular prompts efectivos para herramientas de IA (en este caso, **Google Gemini integrado en Android Studio**) y documentar su impacto en el desarrollo de una app Android sencilla que consume una API pública.

La aplicación muestra frases motivacionales obtenidas de la API **ZenQuotes** (`https://zenquotes.io/api/random`) cada vez que el usuario presiona un botón.

---

## 2. Prompts Utilizados

### Prompt 1: Generación de la funcionalidad básica

> **Prompt usado con Gemini:**
> 
> Estoy desarrollando una aplicación Android en Java (API nivel 24, Android 7.0) llamada "Generador de Frases de Motivación".  
> La app debe tener una interfaz sencilla con:  
> • Un TextView centrado que muestre una frase motivacional.  
> • Un Button debajo que, al ser presionado, realiza una llamada a la API pública ZenQuotes (https://zenquotes.io/api/random) y actualiza el TextView con la nueva frase.  
> Requisitos técnicos:  
> • Usa HttpURLConnection o OkHttp (sin Retrofit, ya que es un proyecto básico en Java).  
> • Maneja la respuesta JSON para extraer el campo "q" (la cita) y mostrarlo en el TextView.  
> • Realiza la llamada en un hilo secundario (no en el hilo principal) y actualiza la UI con runOnUiThread.  
> • Agrega manejo básico de errores (por ejemplo, si no hay conexión, muestra un mensaje en el TextView).  
> • Asegúrate de que el AndroidManifest.xml incluya el permiso de internet.  
> Por favor, genera:  
> 1. El código completo de MainActivity.java.  
> 2. El contenido necesario para activity_main.xml.  
> 3. La línea a añadir en AndroidManifest.xml para el permiso de internet.  
> Usa buenas prácticas de código legible y comentarios breves donde sea necesario.

> **Resultado:**  
> ✅ El agente generó un código funcional a la primera.  
> - `MainActivity.java` incluyó correctamente el uso de `HttpURLConnection`, parsing de JSON con `JSONObject`, y actualización segura de la UI con `runOnUiThread`.  
> - El archivo `activity_main.xml` tenía un diseño básico (TextView + Button).  
> - Se incluyó la línea `<uses-permission android:name="android.permission.INTERNET" />` en el `AndroidManifest.xml`.  
> - El manejo de errores mostraba "Error al cargar la frase" en caso de fallo de red o parsing.

---

### Prompt 2: Mejora del diseño visual

> **Prompt usado con Gemini:**
> 
> Estoy desarrollando una aplicación Android en Java (API nivel 24, Android 7.0) llamada "Generador de Frases de Motivación".  
> Actualmente, mi interfaz (activity_main.xml) solo tiene un TextView y un Button sobre un fondo blanco, pero quiero mejorar su apariencia con un diseño más moderno y atractivo, siguiendo esta guía visual:  
> • Fondo general: color beige suave (#F5F5DC o similar).  
> • El texto de la frase motivacional debe mostrarse dentro de un cuadro blanco con bordes ligeramente redondeados, sombra sutil (elevación visual), y centrado en la pantalla.  
> • El texto dentro del cuadro debe estar en negrita, con un tamaño legible (por ejemplo, 18sp o 20sp), centrado y con buen espaciado.  
> • El botón debe estar centrado horizontalmente, debajo del cuadro de la cita, con un color de acento suave (por ejemplo, tono terracota, verde oliva o azul apagado), texto blanco, bordes redondeados y un toque de elevación (elevation o sombra).  
> • Usa ConstraintLayout como contenedor principal para un diseño limpio y responsivo.  
> • Evita el uso de librerías externas de diseño (solo recursos nativos de Android).  
> Por favor, genera un archivo activity_main.xml completo que implemente este diseño, usando solo vistas estándar de Android (TextView, Button, ConstraintLayout) y recursos de color definidos en colors.xml si es necesario.

> **Resultado:**  
> ✅ El diseño generado cumplió con todas las especificaciones:  
> - Fondo beige suave (`#F5F5DC`).  
> - `TextView` dentro de un `CardView` simulado con un `LinearLayout` blanco, bordes redondeados y `elevation="4dp"`.  
> - Texto en negrita (`android:textStyle="bold"`) y tamaño `20sp`.  
> - Botón con fondo en tono terracota (`#CC5500`), texto blanco, `cornerRadius`, y sombra.  
> - Diseño responsivo con `ConstraintLayout`.  
> - Se sugirieron colores en `colors.xml` para mantener buenas prácticas.

---

## 3. Problemas Encontrados y Soluciones con IA

El unico problema es que el diseño me parecio muy básico, pero lo arregle con otro prompt

---

## 4. Reflexión Final

Usar **Google Gemini como agente en Android Studio** fue una experiencia muy positiva. Los prompts bien estructurados permitieron obtener código funcional desde el primer intento, tanto en lógica como en diseño. La clave fue ser **específico, técnico y claro** en las instrucciones.

Además, el enfoque en **vibecoding** (colaboración en pareja, consenso en prompts y comparación de resultados) ayudó a entender mejor cómo ajustar el lenguaje para obtener mejores respuestas de la IA. En futuros proyectos, exploraré cómo integrar más funcionalidades (como favoritos o modo oscuro) usando el mismo flujo de trabajo.

---

## 5. Capturas de Pantalla

> **Nota:** Las imágenes se encuentran en la carpeta `/screenshots` del repositorio.  
> - `screenshot_1.png`: Interfaz inicial básica (antes del rediseño).  
> - `screenshot_2.png`: Interfaz final con diseño moderno (beige, cuadro blanco, botón estilizado).  
> - `screenshot_3.png`: Ejemplo de frase cargada desde la API.  
> - `screenshot_4.png`: Mensaje de error en caso de fallo de conexión.
