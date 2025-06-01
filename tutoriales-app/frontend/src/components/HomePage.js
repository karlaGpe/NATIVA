// tutoriales-app/frontend/src/components/HomePage.js
import React from 'react';
import './HomePage.css'; // Asegúrate de que HomePage.css exista
import { Link } from 'react-router-dom'; // IMPORTANTE: Importa Link para la navegación interna

const HomePage = () => {
  return (
    <div className="home-page-container">
      {/* Sección Principal / Hero Section - Curso Destacado */}
      <section className="hero-section">
        <div className="hero-content">
          <span className="new-release-tag">¡NUEVO LANZAMIENTO!</span>
          <h1>Domina Python para Desarrollo Web con React</h1>
          <p>Aprende a construir aplicaciones web robustas y escalables desde cero utilizando Python y el potente framework React. ¡Ideal para principiantes y programadores que buscan expandir sus habilidades!</p>
          <div className="course-details">
            <span>⏱️ 40 horas de contenido</span> {/* Icono de reloj (emoji) */}
            <span>✅ Proyectos Prácticos</span>    {/* Icono de check (emoji) */}
            <span>🎓 Más de 500 estudiantes inscritos</span> {/* Icono de graduación (emoji) */}
          </div>
          <div className="action-buttons">
            {/* BOTÓN 1: Inscríbete Ahora - Redirige a la página de ejemplo de Python/Django */}
            <Link to="/ejemplo-python-django" className="btn primary">Inscríbete Ahora</Link>
            {/* BOTÓN 2: Ver Temario Completo - También redirige a la página de ejemplo de Python/Django */}
            <Link to="/ejemplo-python-django" className="btn secondary">Ver Temario Completo</Link>
          </div>
          <p className="note">*Primer módulo gratuito para empezar a programar hoy mismo.</p>
        </div>
        {/* Placeholder de icono sin imagen */}
        <div className="hero-placeholder-icon">
          <span role="img" aria-label="icono de código"></span>
          {/* Si usas React Icons, aquí iría, por ejemplo: <FaCode size="150" color="var(--neon-purple)" /> */}
        </div>
      </section>

      {/* Sección de "Explora Nuestros Caminos de Aprendizaje" */}
      <section className="goals-section">
        <h2>Explora Nuestros Caminos de Aprendizaje</h2>
        <p>Elige tu ruta y conviértete en un experto en los lenguajes de programación más demandados.</p>
        <div className="schools-grid">
          {/* TARJETA 1: Desarrollo Web Frontend */}
          <div className="school-card">
            <h3>🌐 Desarrollo Web Frontend</h3> {/* Icono de globo (emoji) */}
            <p>HTML, CSS, JavaScript, React, Angular, Vue.js</p>
            {/* ENLACE: Explora Cursos de Frontend */}
            <Link to="/ejemplo-frontend" className="explore-link">Explorar Cursos</Link>
          </div>
          {/* TARJETA 2: Desarrollo Web Backend */}
          <div className="school-card">
            <h3>💻 Desarrollo Web Backend</h3> {/* Icono de laptop (emoji) */}
            <p>Python, Node.js, PHP, Java, Bases de Datos</p>
            {/* ENLACE: Explora Cursos de Backend */}
            <Link to="/ejemplo-backend" className="explore-link">Explorar Cursos</Link>
          </div>
          {/* TARJETA 3: Programación Móvil */}
          <div className="school-card">
            <h3>📱 Programación Móvil</h3> {/* Icono de móvil (emoji) */}
            <p>Swift, Kotlin, React Native, Flutter</p>
            {/* ENLACE: Explora Cursos de Móvil */}
            <Link to="/ejemplo-movil" className="explore-link">Explorar Cursos</Link>
          </div>
          {/* TARJETA 4: Ciencia de Datos & IA */}
          <div className="school-card">
            <h3>🔬 Ciencia de Datos & IA</h3> {/* Icono de microscopio (emoji) */}
            <p>Python, R, Machine Learning, Deep Learning</p>
            {/* ENLACE: Explora Cursos de Ciencia de Datos / IA */}
            <Link to="/ejemplo-data-ai" className="explore-link">Explorar Cursos</Link>
          </div>
        </div>
      </section>

      {/* Sección: ¿Por qué elegirnos? - Beneficios clave */}
      <section className="why-us-section">
        <h2>¿Por Qué Aprender Programación con Nosotros?</h2>
        <div className="benefits-grid">
          <div className="benefit-item">
            <span className="icon">💡</span> {/* Icono de bombilla (emoji) */}
            <h3>Proyectos Reales</h3>
            <p>Construye un portafolio sólido con proyectos prácticos desde el primer día.</p>
          </div>
          <div className="benefit-item">
            <span className="icon">👨‍🏫</span> {/* Icono de profesor (emoji) */}
            <h3>Instructores Expertos</h3>
            <p>Aprende de profesionales con experiencia real en la industria tecnológica.</p>
          </div>
          <div className="benefit-item">
            <span className="icon">💬</span> {/* Icono de burbuja de diálogo (emoji) */}
            <h3>Comunidad Activa</h3>
            <p>Resuelve dudas y conecta con otros estudiantes y mentores.</p>
          </div>
          <div className="benefit-item">
            <span className="icon">🚀</span> {/* Icono de cohete (emoji) */}
            <h3>Preparación Laboral</h3>
            <p>Te ayudamos a prepararte para tu primer empleo o mejorar tu carrera.</p>
          </div>
        </div>
      </section>

      {/* Sección de Call to Action (CTA) - Cursos Gratis */}
      <section className="cta-free-courses">
        <h2>¡Empieza a Programar GRATIS Hoy Mismo!</h2>
        <p>Accede a introducciones a HTML, CSS, JavaScript y Python sin costo.</p>
        {/* BOTÓN CTA: Explorar Cursos Gratis - Redirige a la página de cursos gratis */}
        <Link to="/cursos-gratis" className="btn primary">Explorar Cursos Gratis</Link>
      </section>

      {/* Sección de Desarrolladores/Créditos */}
      <section className="developers-section">
        <h2>Desarrollado por:</h2>
        <div className="developer-names">
          <span>✨ Alejandro Mendoza</span> {/* Icono de brillo (emoji) */}
          <span>✨ Mauricio González</span> {/* Icono de brillo (emoji) */}
        </div>
        <p>Impulsando tu futuro en el código.</p>
      </section>
    </div>
  );
};

export default HomePage;