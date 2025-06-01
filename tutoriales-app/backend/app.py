# backend/app.py
from flask import Flask, request, jsonify, session, Blueprint
from flask_cors import CORS
from config import Config
from extensions import db  # ✅ este es el nuevo import
import os

# Inicializamos db fuera de la función, pero NO la asociamos a la app aquí.

# Crear un Blueprint para las rutas de autenticación
auth_bp = Blueprint('auth', __name__)

# Definimos las rutas DENTRO del Blueprint.
# No importa User aquí todavía. Se importará dentro de cada función de ruta.
@auth_bp.route('/register', methods=['POST'])
def register():
    # ¡Importar User aquí dentro de la función para asegurar que db ya está en el contexto!
    from models import User

    data = request.get_json()
    username = data.get('username')
    email = data.get('email')
    password = data.get('password')

    if not username or not email or not password:
        return jsonify({'message': 'Missing username, email, or password'}), 400

    if User.query.filter_by(username=username).first():
        return jsonify({'message': 'Username already taken'}), 409
    if User.query.filter_by(email=email).first():
        return jsonify({'message': 'Email already registered'}), 409

    new_user = User(username=username, email=email, password=password)

    db.session.add(new_user)
    db.session.commit()

    return jsonify({'message': 'User registered successfully'}), 201

@auth_bp.route('/login', methods=['POST'])
def login():
    # ¡Importar User aquí dentro de la función para asegurar que db ya está en el contexto!
    from models import User

    data = request.get_json()
    username = data.get('username')
    password = data.get('password')

    if not username or not password:
        return jsonify({'message': 'Missing username or password'}), 400

    user = User.query.filter_by(username=username).first()

    if user and user.password == password:
        session['user_id'] = user.id
        session['username'] = user.username
        return jsonify({'message': 'Logged in successfully', 'username': user.username}), 200
    else:
        return jsonify({'message': 'Invalid credentials'}), 401

@auth_bp.route('/logout', methods=['POST'])
def logout():
    session.pop('user_id', None)
    session.pop('username', None)
    return jsonify({'message': 'Logged out successfully'}), 200

@auth_bp.route('/current-user', methods=['GET'])
def get_current_user():
    user_id = session.get('user_id')
    username = session.get('username')

    if user_id:
        return jsonify(is_authenticated=True, username=username), 200
    return jsonify(is_authenticated=False), 200

# Función para crear y configurar la aplicación Flask
def create_app():
    app = Flask(__name__)
    app.config.from_object(Config)

    # 1. Asociar SQLAlchemy con la aplicación Flask
    # ESTO ES LO PRIMERO QUE DEBE PASAR DESPUÉS DE LA CONFIGURACIÓN DE LA APP
    db.init_app(app)

    # Configuración de CORS
    CORS(app, supports_credentials=True, resources={r"/api/*": {"origins": "http://localhost:3000"}})

    # Configuración de la sesión (clave secreta)
    app.secret_key = app.config['SECRET_KEY']

    # 2. Importar modelos y crear tablas DENTRO del app_context
    # Esto asegura que los modelos se carguen después de que 'db' esté inicializado
    with app.app_context():
        from models import User # Importa el modelo aquí para que db.create_all() lo encuentre
        db.create_all()

    # 3. Registrar el Blueprint después de que la app y la DB estén configuradas
    app.register_blueprint(auth_bp, url_prefix='/api/auth')

    return app

# Punto de entrada para ejecutar la aplicación
if __name__ == '__main__':
    app = create_app()
    app.run(debug=True)