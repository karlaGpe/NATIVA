// tutoriales-app/frontend/src/components/Footer.js
import React from 'react';
// import './Footer.css'; // Si quieres estilos específicos para Footer aparte de layout.css

const Footer = () => {
  return (
    <footer className="footer">
      <p>&copy; {new Date().getFullYear()} Cursos Peralta. Desarrollado con 💖 por Alejandro Mendoza y Mauricio González.</p>
      {/* Puedes agregar enlaces a redes sociales o políticas aquí */}
    </footer>
  );
};

export default Footer;