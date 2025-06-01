import React from 'react';
import './PageStyles.css';


const HtmlPage = () => {
 return (
 <div className="page-container">
 <h1 className="page-title">Curso Completo de HTML5</h1>
 <p className="page-intro">
 ¡Bienvenido al curso fundamental de HTML5! Aprende las bases para construir la
 estructura de cualquier página web.
 </p>


 <div className="page-section">
 <h2 className="section-title">¿Qué aprenderás en este curso?</h2>
 <ul>
 <li>Fundamentos de la estructura HTML: etiquetas, atributos y elementos.</li>
 <li>Uso semántico de HTML5 para una web accesible y optimizada.</li>
 <li>Manejo de formularios, tablas y elementos multimedia.</li>
 <li>Introducción a la integración con CSS y JavaScript.</li>
 </ul>
 </div>


 <div className="page-section">
 <h2 className="section-title">Video Introductorio</h2>
 <div style={{ textAlign: 'center', margin: '20px 0' }}>
 <iframe
 width="800"
 height="450"
 src="https://www.youtube.com/embed/videoseries?si=XyZ9oQk2xNq1_g8V&list=PLPl81lqhg_E6B3s8sD9h6R2R_m7V7500K"
 title="YouTube video player"
 frameBorder="0"
 allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;
 picture-in-picture; web-share"
 referrerPolicy="strict-origin-when-cross-origin"
 allowFullScreen
 style={{ border: 'none', maxWidth: '100%' }}
 ></iframe>
 </div>
 </div>


 <div className="page-section">
 <h2 className="section-title">Recursos Adicionales</h2>
 <p>Descarga la guía rápida de etiquetas HTML:</p>
 <a href="/recursos/guia_html.pdf" download className="btn primary">Descargar Guía
 HTML</a>
 <p style={{ marginTop: '20px' }}>Visita MDN Web Docs para más información:</p>
 <a
 href="https://developer.mozilla.org/es/docs/Web/HTML"
 target="_blank"
 rel="noopener noreferrer"
 className="btn secondary"
 >
 MDN HTML Docs
 </a>
 </div>


 {/* Puedes añadir más secciones aquí */}
 </div>
 );
};


export default HtmlPage;