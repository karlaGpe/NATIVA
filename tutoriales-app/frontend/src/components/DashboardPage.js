// frontend/src/components/DashboardPage.js
import React, { useEffect, useState } from 'react';
import { useAuth } from './AuthContext';
import { useNavigate } from 'react-router-dom';
import axios from 'axios'; // Para la ruta protegida de ejemplo
import './PageStyles.css';

const DashboardPage = () => {
  const { currentUser, isLoading, logout } = useAuth();
  const navigate = useNavigate();
  const [protectedMessage, setProtectedMessage] = useState(''); // Para mostrar el mensaje de la ruta protegida

  useEffect(() => {
    // Si no está cargando y no hay un usuario actual, redirige
    if (!isLoading && !currentUser) {
      navigate('/login');
    }

    // Si hay un usuario logueado, intenta cargar la ruta protegida
    if (currentUser) {
        const fetchProtectedData = async () => {
            try {
                const response = await axios.get('http://127.0.0.1:5000/api/auth/protected');
                setProtectedMessage(response.data.message);
            } catch (error) {
                console.error("Error fetching protected data:", error);
                setProtectedMessage("No se pudo cargar la información protegida. Sesión inválida o expirada.");
                // Aunque no usamos JWT, una sesión de Flask también tiene un límite de tiempo
                // o puede ser invalidada si el usuario cierra la pestaña del navegador (si no usas permanent sessions)
                // En este caso simple, si falla, asumimos que no está logueado y cerramos sesión localmente.
                logout(); // Fuerza un logout local para limpiar el estado
            }
        };
        fetchProtectedData();
    }
  }, [currentUser, isLoading, navigate, logout]);

  if (isLoading) {
    return <div className="page-container"><p>Cargando información del usuario...</p></div>;
  }

  // Si currentUser es null después de la carga, significa que no está logueado y ya fue redirigido por el useEffect.
  // Este return null es para evitar renderizar el dashboard mientras se está redirigiendo.
  if (!currentUser) {
    return null;
  }

  return (
    <div className="page-container">
      <h1 className="page-title">Bienvenido, {currentUser.username}!</h1>
      <p className="page-intro">Este es tu panel de control. Aquí verás contenido solo para usuarios registrados.</p>

      <section className="page-section">
        <h2 className="section-title">Contenido Exclusivo</h2>
        {protectedMessage ? (
            <p>{protectedMessage}</p>
        ) : (
            <p>Cargando mensaje de la ruta protegida...</p>
        )}
        <button onClick={logout} className="btn secondary" style={{ marginTop: '20px' }}>Cerrar Sesión</button>
      </section>

      <section className="page-section">
        <h2 className="section-title">Mis Cursos</h2>
        <ul className="course-list">
          <li>Curso avanzado de React Hooks</li>
          <li>Despliegue de Aplicaciones Flask</li>
          <li>Optimización de Bases de Datos MySQL</li>
        </ul>
      </section>
    </div>
  );
};

export default DashboardPage;