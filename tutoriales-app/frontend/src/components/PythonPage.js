import React from 'react';
import './PythonPage.css';

const PythonPage = () => {
  return (
    <div className="container">
      <h1>Curso de Python</h1>
      <p>Ejercicio: Imprimir los números del 1 al 5 en consola.</p>
      <pre>
        {`
for i in range(1, 6):
    print(i)
        `}
      </pre>
      <p><strong>Explicación:</strong> El bucle `for` recorre los números del 1 al 5 y los imprime uno por uno.</p>
    </div>
  );
};

export default PythonPage;
