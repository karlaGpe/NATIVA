// tutoriales-app/frontend/src/components/FreeCoursesPage.js
import React from 'react';
import './PageStyles.css';

const FreeCoursesPage = () => {
  return (
    <div className="page-container">
      <h1 className="page-title">🎁 Cursos Gratuitos para Empezar</h1>
      <p className="page-intro">¡No hay excusas! Comienza tu viaje en la programación con nuestros cursos gratuitos. Ideales para entender los fundamentos.</p>

      <section className="page-section">
        <h2 className="section-title">Cursos Disponibles</h2>
        <ul className="free-course-list">
          <li>📚 Introducción a HTML para Principiantes</li>
          <li>📚 Fundamentos de CSS: Estilizando tu Web</li>
          <li>📚 JavaScript Básico: Primeros Pasos en la Interactividad</li>
          <li>📚 Python Desde Cero: Tus Primeras Líneas de Código</li>
        </ul>
      </section>

      <section className="page-section">
        <h2 className="section-title">¡Inscríbete Ya!</h2>
        <p>Regístrate y accede a todo el contenido sin costo.</p>
        <button className="btn primary">Regístrate Gratis</button>
      </section>
    </div>
  );
};

export default FreeCoursesPage;