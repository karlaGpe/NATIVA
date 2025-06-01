// tutoriales-app/frontend/src/components/FrontendExamplePage.js
import React from 'react';
import './PageStyles.css';

const FrontendExamplePage = () => {
  return (
    <div className="page-container">
      <h1 className="page-title">🌐 Explorando el Desarrollo Web Frontend</h1>
      <p className="page-intro">Sumérgete en el mundo del diseño y la interactividad web. Descubre cómo construir interfaces de usuario impresionantes.</p>

      <section className="page-section">
        <h2 className="section-title">Tecnologías Clave</h2>
        <ul className="tech-stack">
          <li>HTML5 ✨ Estructura tus páginas</li>
          <li>CSS3 ✨ Dales estilo y vida</li>
          <li>JavaScript ✨ Añade interactividad</li>
          <li>React.js ✨ Construye componentes reutilizables</li>
          <li>Frameworks CSS (Bootstrap, Tailwind) ✨ Diseños rápidos y responsivos</li>
        </ul>
      </section>

      <section className="page-section">
        <h2 className="section-title">Proyecto Demo: Galería Interactiva</h2>
        <div className="project-demo">
          <p>Aquí podrías ver un pequeño proyecto interactivo (quizá un gif o una captura de pantalla con un enlace a un CodeSandbox).</p>
        </div>
      </section>

      <section className="page-section">
        <h2 className="section-title">Empieza con HTML y CSS</h2>
        <p>Visita nuestro <a href="/html" className="page-link">curso de HTML</a> y <a href="/css" className="page-link">curso de CSS</a> para los fundamentos.</p>
      </section>
    </div>
  );
};

export default FrontendExamplePage;