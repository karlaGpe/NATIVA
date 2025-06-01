// frontend/src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom';
import { useAuth } from './AuthContext';
import './Navbar.css'; // ¡Asegúrate de que esta línea esté presente y apunte al archivo correcto!

const Navbar = () => {
  const { currentUser, logout } = useAuth();

  return (
    <nav className="navbar">
      <Link to="/" className="navbar-logo">
        🚀 Cursos Peralta
      </Link>
      <div className="navbar-links">
        <Link to="/html">HTML</Link>
        <Link to="/css">CSS</Link>
        <Link to="/python">Python</Link>
        <Link to="/react">React</Link>
        {currentUser && <Link to="/dashboard">Mi Dashboard</Link>}
      </div>
      <div className="navbar-actions">
        {currentUser ? (
          <>
            {/* El estilo in-line para el texto de bienvenida ya tiene el color neón */}
            <span style={{ color: 'var(--neon-green)', marginRight: '15px', textShadow: '0 0 5px var(--neon-green)' }}>
              Hola, {currentUser.username || 'Usuario'}!
            </span>
            <button onClick={logout} className="btn secondary">Cerrar Sesión</button>
          </>
        ) : (
          <>
            <Link to="/login" className="btn secondary">Iniciar Sesión</Link>
            <Link to="/register" className="btn primary">Regístrate Ahora</Link>
          </>
        )}
      </div>
    </nav>
  );
};

export default Navbar;