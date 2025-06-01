// tutoriales-app/frontend/src/components/MobileExamplePage.js
import React from 'react';
import './PageStyles.css';

const MobileExamplePage = () => {
  return (
    <div className="page-container">
      <h1 className="page-title">📱 Creación de Aplicaciones Móviles</h1>
      <p className="page-intro">Lleva tus ideas al bolsillo de millones de usuarios. Aprende a desarrollar apps para iOS y Android.</p>

      <section className="page-section">
        <h2 className="section-title">Plataformas y Frameworks</h2>
        <ul className="tech-stack">
          <li>Swift / SwiftUI (iOS) 🍎</li>
          <li>Kotlin / Android Jetpack Compose (Android) 🤖</li>
          <li>React Native (Multiplataforma) ⚛️</li>
          <li>Flutter (Multiplataforma) 🦋</li>
        </ul>
      </section>

      <section className="page-section">
        <h2 className="section-title">Diseño de UI/UX Móvil</h2>
        <div className="design-placeholder">
          <p>Muestra de diseño de interfaz de usuario para apps.</p>
        </div>
      </section>

      <section className="page-section">
        <h2 className="section-title">Primeros pasos con React Native</h2>
        <p>Descubre el poder de React para crear apps en nuestro <a href="/react" className="page-link">curso de React</a>.</p>
      </section>
    </div>
  );
};

export default MobileExamplePage;