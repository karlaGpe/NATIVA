// tutoriales-app/frontend/src/components/PythonExamplePage.js
import React from 'react';
import './PageStyles.css'; // Un archivo CSS genérico para todas las páginas de ejemplo

const PythonExamplePage = () => {
  return (
    <div className="page-container">
      <h1 className="page-title">🐍 Curso de Python para Desarrollo Web con Django</h1>
      <p className="page-intro">¡Bienvenido a la página de ejemplo de nuestro curso estrella de Python y Django! Aquí encontrarás una probadita de lo que te espera.</p>

      <section className="page-section">
        <h2 className="section-title">¿Qué Aprenderás?</h2>
        <ul className="course-list">
          <li>✨ Fundamentos de Python y programación orientada a objetos.</li>
          <li>✨ Manejo de bases de datos con Django ORM.</li>
          <li>✨ Creación de APIs RESTful.</li>
          <li>✨ Despliegue de aplicaciones web.</li>
          <li>✨ Construcción de proyectos prácticos paso a paso.</li>
        </ul>
      </section>

      <section className="page-section">
        <h2 className="section-title">Primeros Pasos (Video de Muestra)</h2>
        <div className="video-placeholder">
          <p>Video de introducción a Python...</p>
          {/* Aquí iría un iframe de YouTube o un componente de video */}
          <iframe width="560" height="315" src="https://www.youtube.com/embed/rfscVS0vtbw?si=tX92g6e3l84j5B-X" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
        </div>
      </section>

      <section className="page-section">
        <h2 className="section-title">Descarga el Módulo Gratuito</h2>
        <p>Inicia tu camino en Python. <a href="#" className="download-link">Descarga el PDF del primer módulo</a>.</p>
      </section>
    </div>
  );
};

export default PythonExamplePage;