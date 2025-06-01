// frontend/src/api/auth.js
import axios from 'axios';

// La URL base de tu backend Flask
// Asegúrate de que coincida con la dirección y puerto donde está corriendo tu backend
const API_URL = 'http://127.0.0.1:5000/api/auth'; 

// Crear una instancia de Axios con la configuración para enviar credenciales (cookies)
// Esto es CRUCIAL para que las cookies de sesión de Flask se envíen y reciban
// correctamente entre tu frontend (React) y tu backend (Flask).
const apiClient = axios.create({
  baseURL: API_URL,
  withCredentials: true, 
});

/**
 * Función para registrar un nuevo usuario.
 * @param {string} username - El nombre de usuario.
 * @param {string} email - El correo electrónico del usuario.
 * @param {string} password - La contraseña del usuario.
 * @returns {Promise<AxiosResponse>} Una promesa que resuelve con la respuesta de la API.
 */
const register = (username, email, password) => {
  return apiClient.post('/register', {
    username,
    email,
    password,
  });
};

/**
 * Función para iniciar sesión.
 * @param {string} username - El nombre de usuario.
 * @param {string} password - La contraseña del usuario.
 * @returns {Promise<AxiosResponse>} Una promesa que resuelve con la respuesta de la API.
 */
const login = (username, password) => {
  return apiClient.post('/login', {
    username,
    password,
  });
};

/**
 * Función para cerrar la sesión.
 * @returns {Promise<AxiosResponse>} Una promesa que resuelve con la respuesta de la API.
 */
const logout = () => {
  return apiClient.post('/logout');
};

/**
 * Función para verificar el estado de autenticación actual del usuario.
 * @returns {Promise<AxiosResponse>} Una promesa que resuelve con la respuesta de la API.
 */
const checkAuthStatus = () => {
  return apiClient.get('/current-user');
};

// Exportar todas las funciones del servicio de autenticación
export default {
  register,
  login,
  logout,
  checkAuthStatus,
};