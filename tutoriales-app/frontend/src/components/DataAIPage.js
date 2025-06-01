// tutoriales-app/frontend/src/components/DataAIPage.js
import React from 'react';
import './PageStyles.css';

const DataAIPage = () => {
  return (
    <div className="page-container">
      <h1 className="page-title">🔬 Ciencia de Datos e Inteligencia Artificial</h1>
      <p className="page-intro">Adéntrate en el futuro. Aprende a analizar grandes volúmenes de datos y a crear sistemas inteligentes.</p>

      <section className="page-section">
        <h2 className="section-title">Áreas y Herramientas</h2>
        <ul className="tech-stack">
          <li>Análisis de Datos 📊</li>
          <li>Machine Learning 🧠</li>
          <li>Deep Learning 🧬</li>
          <li>Python (Pandas, NumPy, Scikit-learn, TensorFlow) 🐍</li>
          <li>R (ggplot2, dplyr) 📈</li>
        </ul>
      </section>

      <section className="page-section">
        <h2 className="section-title">Ejemplo de Predicción (Placeholder)</h2>
        <div className="prediction-placeholder">
          <p>Gráfica de un modelo de predicción simple...</p>
        </div>
      </section>

      <section className="page-section">
        <h2 className="section-title">Inicia en la IA</h2>
        <p>Nuestro <a href="/python" className="page-link">curso de Python</a> es el punto de partida perfecto para la Ciencia de Datos.</p>
      </section>
    </div>
  );
};

export default DataAIPage;