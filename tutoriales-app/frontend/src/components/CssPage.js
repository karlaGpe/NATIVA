import React from 'react';
import './PageStyles.css';


const CssPage = () => {
 return (
 <div className="page-container">
 <h1 className="page-title">Curso Avanzado de CSS3</h1>
 <p className="page-intro">
 Domina el arte de los estilos con CSS3. Aprende selectores avanzados,
 animaciones, transiciones y diseño responsive.
 </p>


 <div className="page-section">
 <h2 className="section-title">Temario del Curso</h2>
 <ul>
 <li>Selectores CSS avanzados y especificidad.</li>
 <li>Modelo de caja (Box Model) y layouts (Flexbox y Grid).</li>
 <li>Transiciones y animaciones CSS para interfaces dinámicas.</li>
 <li>Media Queries y diseño web responsive para todos los dispositivos.</li>
 <li>Personalización con fuentes, iconos y pseudo-elementos.</li>
 </ul>
 </div>


 <div className="page-section">
 <h2 className="section-title">Ejemplo de Animación Neón con CSS</h2>
 <div
 style={{
 textAlign: 'center',
 padding: '20px',
 backgroundColor: '#1a1a2e',
 borderRadius: '8px',
 }}
 >
 <div
 style={{
 display: 'inline-block',
 padding: '15px 30px',
 border: '2px solid var(--neon-pink)',
 color: 'var(--neon-pink)',
 textShadow: '0 0 10px var(--neon-pink)',
 borderRadius: '5px',
 animation: 'neonGlow 1s infinite alternate',
 }}
 >
 Texto Neón CSS
 </div>
 <style>
 {`
 @keyframes neonGlow {
 from {
 box-shadow: 0 0 5px var(--neon-pink), 0 0 10px var(--neon-pink), 0 0 15px var(--neon-pink);
 }
 to {
 box-shadow: 0 0 15px var(--neon-pink), 0 0 25px var(--neon-pink), 0 0 35px var(--neon-pink);
 }
 }
 `}
 </style>
 </div>
 </div>


 <div className="page-section">
 <h2 className="section-title">Recursos Útiles</h2>
 <p>Revisa la documentación oficial de CSS:</p>
 <a
 href="https://developer.mozilla.org/es/docs/Web/CSS"
 target="_blank"
 rel="noopener noreferrer"
 className="btn primary"
 >
 MDN CSS Docs
 </a>
 </div>


 {/* Añade más contenido de CSS aquí */}
 </div>
 );
};


export default CssPage;