# Generador de Frases de Motivación

## 📌 Descripción del Proyecto

Esta aplicación Android muestra frases motivacionales e inspiradoras obtenidas en tiempo real desde la API pública **[ZenQuotes](https://zenquotes.io/)**. Cada vez que el usuario presiona el botón "Nueva Frase", la app realiza una solicitud HTTP a la API, extrae la cita (`"q"`), y la muestra en pantalla con un diseño limpio y moderno.

El proyecto fue desarrollado como parte del **Reto Android + Vibecoding**, con el objetivo principal de aprender a formular **prompts efectivos** para herramientas de inteligencia artificial y aplicar la metodología de **vibecoding** (colaboración en pareja con consenso en el diseño y los prompts).

---

## 🛠️ Herramientas Utilizadas

- **Lenguaje**: Java  
- **API Nivel**: 24 (Android 7.0)  
- **IDE**: Android Studio  
- **Agente de IA**: **Google Gemini** (integrado en Android Studio)  
- **API Externa**: [ZenQuotes](https://zenquotes.io/api) – endpoint: `https://zenquotes.io/api/random`  
- **Diseño**: `ConstraintLayout`, recursos nativos de Android (sin librerías externas como Retrofit o Glide)  
- **Manejo de red**: `HttpURLConnection`  
- **Parseo de JSON**: `JSONObject` del SDK de Android  

---

## 👥 Roles del Equipo (Vibecoding)

Este proyecto se desarrolló en pareja bajo la metodología **vibecoding**, donde ambos miembros colaboraron en todas las etapas, pero con roles diferenciados durante la implementación:

| Miembro | Rol |
|--------|-----|
| **[Rafael Pérez 0905-24-5462]** | Utilizó **Google Gemini** como agente de IA en Android Studio para generar el código base y el rediseño de la interfaz. Se encargó de documentar los prompts, validar la funcionalidad y subir el repositorio final. |
| **[Josué Paniagua 0905-24-6495]** | Utilizó **GitHub Copilot** como agente de IA para desarrollar su propia versión del proyecto. Participó activamente en la lectura de la documentación de la API, la redacción consensuada de los prompts y la evaluación comparativa de resultados. |

> 💡 **Nota**: Ambos trabajamos juntos en la elección de la API, la definición de requisitos y la formulación inicial de los prompts. Luego, cada uno implementó su solución individual usando su agente asignado.

---
