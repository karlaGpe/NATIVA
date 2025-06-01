# backend/config.py
import os
from dotenv import load_dotenv

# Carga las variables de entorno desde el archivo .env
load_dotenv()

class Config:
    # Configuración de la base de datos MySQL
    # Usaremos el formato URI de SQLAlchemy
    SQLALCHEMY_DATABASE_URI = (
        f"mysql+pymysql://{os.getenv('MYSQL_USER')}:"
        f"{os.getenv('MYSQL_PASSWORD')}@"
        f"{os.getenv('MYSQL_HOST')}:"
        f"{os.getenv('MYSQL_PORT')}/"
        f"{os.getenv('MYSQL_DB')}"
    )
    SQLALCHEMY_TRACK_MODIFICATIONS = False # Deshabilita el seguimiento de modificaciones del ORM (recomendado)

    # Clave secreta para la gestión de sesiones de Flask (cookies)
    SECRET_KEY = os.getenv('FLASK_SECRET_KEY') or 'supersecretkey'
    # Esta es una clave de fallback si FLASK_SECRET_KEY no se encuentra