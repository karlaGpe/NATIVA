// frontend/src/components/AuthContext.js
import React, { createContext, useState, useEffect, useContext } from 'react';
import authService from '../api/auth'; // Asegúrate de que la ruta sea correcta a auth.js
import { useNavigate } from 'react-router-dom';

// Crea el contexto de autenticación
const AuthContext = createContext();

// Proveedor de autenticación que envuelve tu aplicación
export const AuthProvider = ({ children }) => {
  const [currentUser, setCurrentUser] = useState(null); // Almacena el usuario actual logueado
  const [isLoading, setIsLoading] = useState(true);   // Indica si el estado de autenticación está cargando

  const navigate = useNavigate(); // Hook para la navegación programática

  // useEffect para cargar el estado del usuario al inicio de la aplicación
  useEffect(() => {
    const loadUser = async () => {
      try {
        const response = await authService.checkAuthStatus(); // Llama a la API para verificar el estado
        if (response.data.is_authenticated) {
          setCurrentUser({ username: response.data.username }); // Si está autenticado, guarda el username
        } else {
          setCurrentUser(null); // Si no, no hay usuario
        }
      } catch (error) {
        console.error("Error checking auth status:", error);
        setCurrentUser(null); // En caso de error, asume que no hay usuario
      } finally {
        setIsLoading(false); // La carga ha terminado
      }
    };
    loadUser(); // Ejecuta la función al montar el componente
  }, []); // El array vacío asegura que se ejecute solo una vez al inicio

  // Función para iniciar sesión
  const login = async (username, password) => {
    try {
      const response = await authService.login(username, password); // Llama al servicio de login
      setCurrentUser({ username: response.data.username }); // Guarda el username del usuario logueado
      navigate('/dashboard'); // Redirige al usuario al dashboard
      return { success: true, message: response.data.message, username: response.data.username };
    } catch (error) {
      console.error("Login failed:", error.response?.data?.message || error.message);
      // Propaga el error para que el componente que llama pueda manejarlo
      throw new Error(error.response?.data?.message || 'Error en el inicio de sesión');
    }
  };

  // Función para registrar un nuevo usuario
  const register = async (username, email, password) => {
    try {
      const response = await authService.register(username, email, password); // Llama al servicio de registro
      navigate('/login'); // Redirige al usuario a la página de login después de un registro exitoso
      return { success: true, message: response.data.message };
    } catch (error) {
      console.error("Registration failed:", error.response?.data?.message || error.message);
      // Propaga el error para que el componente que llama pueda manejarlo
      throw new Error(error.response?.data?.message || 'Error en el registro');
    }
  };

  // Función para cerrar sesión
  const logout = async () => {
    try {
      await authService.logout(); // Llama al servicio de logout
      setCurrentUser(null); // Limpia el usuario actual
      navigate('/'); // Redirige al usuario a la página de inicio
      return { success: true, message: "Sesión cerrada correctamente." };
    } catch (error) {
      console.error("Logout failed:", error.response?.data?.message || error.message);
      throw new Error(error.response?.data?.message || 'Error al cerrar sesión');
    }
  };

  // Valor del contexto que se proveerá a los componentes hijos
  const value = {
    currentUser,
    isLoading,
    login,
    register,
    logout,
  };

  return (
    // Provee el valor del contexto a los hijos
    // Solo renderiza los hijos una vez que el estado de autenticación inicial ha cargado
    <AuthContext.Provider value={value}>
      {!isLoading && children}
    </AuthContext.Provider>
  );
};

// Hook personalizado para consumir el contexto de autenticación fácilmente
export const useAuth = () => useContext(AuthContext);