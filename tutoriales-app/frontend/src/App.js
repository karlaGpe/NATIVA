// frontend/src/App.js
import React from 'react';
// Importa el archivo CSS global para el layout y las variables de estilo neón
import './components/layout.css';
// Importa BrowserRouter, Route y Routes de react-router-dom para la navegación
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

// Importa el proveedor de autenticación para que el estado de usuario sea global
import { AuthProvider } from './components/AuthContext';

// Importa los componentes principales de la interfaz de usuario
import Navbar from './components/Navbar';
import Footer from './components/Footer';

// Importa la página de inicio con el diseño neón y los enlaces
import HomePage from './components/HomePage';

// Importa las páginas de autenticación
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import DashboardPage from './components/DashboardPage'; // Página protegida para usuarios logueados

// Importa las páginas de contenido de los cursos (con estilo neón)
import HtmlPage from './components/HtmlPage';
import CssPage from './components/CssPage';
import PythonPage from './components/PythonPage';
import ReactPage from './components/ReactPage';

// Importa las páginas de ejemplo a las que redirigen los enlaces del HomePage
import PythonExamplePage from './components/PythonExamplePage';
import FrontendExamplePage from './components/FrontendExamplePage';
import BackendExamplePage from './components/BackendExamplePage';
import MobileExamplePage from './components/MobileExamplePage';
import DataAIPage from './components/DataAIPage';
import FreeCoursesPage from './components/FreeCoursesPage';

// Importa los estilos comunes para todas las páginas de contenido
import './components/PageStyles.css';


function App() {
  return (
    // Router envuelve toda la aplicación para habilitar la navegación
    <Router>
      {/* AuthProvider envuelve toda la aplicación para que el estado de autenticación
          (currentUser, login, logout) esté disponible para cualquier componente descendiente. */}
      <AuthProvider>
        {/* Navbar se renderiza fuera de Routes para que siempre esté visible */}
        <Navbar />
        {/* Un div principal para el contenido, puedes añadirle estilos si es necesario */}
        <div className="main-content">
          {/* Routes define las diferentes rutas de la aplicación */}
          <Routes>
            {/* Ruta para la página de inicio */}
            <Route path="/" element={<HomePage />} />

            {/* Rutas para las páginas de autenticación */}
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
            {/* Ruta para el dashboard, que es una página protegida */}
            <Route path="/dashboard" element={<DashboardPage />} />

            {/* Rutas para las páginas de cursos individuales */}
            <Route path="/html" element={<HtmlPage />} />
            <Route path="/css" element={<CssPage />} />
            <Route path="/python" element={<PythonPage />} />
            <Route path="/react" element={<ReactPage />} />

            {/* Rutas para las páginas de ejemplo a las que se enlaza desde HomePage */}
            <Route path="/ejemplo-python-django" element={<PythonExamplePage />} />
            <Route path="/ejemplo-frontend" element={<FrontendExamplePage />} />
            <Route path="/ejemplo-backend" element={<BackendExamplePage />} />
            <Route path="/ejemplo-movil" element={<MobileExamplePage />} />
            <Route path="/ejemplo-data-ai" element={<DataAIPage />} />
            <Route path="/cursos-gratis" element={<FreeCoursesPage />} />

            {/* Opcional: Ruta para manejar páginas no encontradas (404) */}
            {/* <Route path="*" element={<div><h1>404 - Página no encontrada</h1><p>La URL que buscas no existe.</p></div>} /> */}

          </Routes>
        </div>
        {/* Footer se renderiza fuera de Routes para que siempre esté visible */}
        <Footer />
      </AuthProvider>
    </Router>
  );
}

export default App;