// tutoriales-app/frontend/src/components/BackendExamplePage.js
import React from 'react';
import './PageStyles.css';

const BackendExamplePage = () => {
  return (
    <div className="page-container">
      <h1 className="page-title">💻 Desarrollo Web Backend: La Lógica Detrás de Escena</h1>
      <p className="page-intro">Descubre cómo funcionan los servidores, bases de datos y la lógica que impulsa las aplicaciones web.</p>

      <section className="page-section">
        <h2 className="section-title">Lenguajes y Herramientas</h2>
        <ul className="tech-stack">
          <li>Python (Django, Flask) 🐍</li>
          <li>Node.js (Express) 🟩</li>
          <li>PHP (Laravel) 🐘</li>
          <li>Java (Spring Boot) ☕</li>
          <li>Bases de Datos (SQL, NoSQL) 🗄️</li>
        </ul>
      </section>

      <section className="page-section">
        <h2 className="section-title">Ejemplo de API REST</h2>
        <div className="code-snippet-placeholder">
          <pre><code>
            // Ejemplo de endpoint en Node.js con Express
            const express = require('express');
            const app = express();
          </code></pre>
        </div>
      </section>

      <section className="page-section">
        <h2 className="section-title">Profundiza en Backend</h2>
        <p>Explora nuestro <a href="/python" className="page-link">curso de Python</a> para aprender más sobre desarrollo backend.</p>
      </section>
    </div>
  );
};

export default BackendExamplePage;