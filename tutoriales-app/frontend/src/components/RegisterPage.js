// frontend/src/components/RegisterPage.js
import React, { useState } from 'react';
import { useAuth } from './AuthContext';
import { Link } from 'react-router-dom';
import './PageStyles.css';

const RegisterPage = () => {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [message, setMessage] = useState('');
  const { register } = useAuth();

  const handleRegister = async (e) => {
    e.preventDefault();
    setMessage('');

    if (password !== confirmPassword) {
      setMessage('Las contraseñas no coinciden.');
      return;
    }

    try {
      await register(username, email, password);
    } catch (error) {
      console.error('Registration error:', error);
      setMessage(error.response?.data?.message || 'Error al registrarse. Intenta de nuevo.');
    }
  };

  return (
    <div className="page-container auth-form-container">
      <h1 className="page-title">Registrarse</h1>
      <form onSubmit={handleRegister} className="auth-form">
        <div className="form-group">
          <label htmlFor="regUsername">Usuario:</label>
          <input
            type="text"
            id="regUsername"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
            className="form-input"
          />
        </div>
        <div className="form-group">
          <label htmlFor="regEmail">Email:</label>
          <input
            type="email"
            id="regEmail"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            className="form-input"
          />
        </div>
        <div className="form-group">
          <label htmlFor="regPassword">Contraseña:</label>
          <input
            type="password"
            id="regPassword"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            className="form-input"
          />
        </div>
        <div className="form-group">
          <label htmlFor="confirmPassword">Confirmar Contraseña:</label>
          <input
            type="password"
            id="confirmPassword"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
            className="form-input"
          />
        </div>
        <button type="submit" className="btn primary full-width">Registrar</button>
        {message && <p className="error-message">{message}</p>}
        <p className="auth-link-text">
          ¿Ya tienes cuenta? <Link to="/login" className="page-link">Inicia Sesión</Link>
        </p>
      </form>
    </div>
  );
};

export default RegisterPage;