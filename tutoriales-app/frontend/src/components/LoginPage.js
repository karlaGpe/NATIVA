// frontend/src/components/LoginPage.js
import React, { useState } from 'react';
import { useAuth } from './AuthContext';
import { Link } from 'react-router-dom';
import './PageStyles.css';

const LoginPage = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');
  const { login } = useAuth();

  const handleLogin = async (e) => {
    e.preventDefault();
    setMessage('');
    try {
      await login(username, password);
    } catch (error) {
      console.error('Login error:', error);
      setMessage(error.response?.data?.message || 'Error al iniciar sesión. Verifica tus credenciales.');
    }
  };

  return (
    <div className="page-container auth-form-container">
      <h1 className="page-title">Iniciar Sesión</h1>
      <form onSubmit={handleLogin} className="auth-form">
        <div className="form-group">
          <label htmlFor="username">Usuario:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
            className="form-input"
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Contraseña:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            className="form-input"
          />
        </div>
        <button type="submit" className="btn primary full-width">Entrar</button>
        {message && <p className="error-message">{message}</p>}
        <p className="auth-link-text">
          ¿No tienes cuenta? <Link to="/register" className="page-link">Regístrate Aquí</Link>
        </p>
      </form>
    </div>
  );
};

export default LoginPage;