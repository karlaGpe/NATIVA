import React from 'react';
import LiveCode from './LiveEditor';
import './ReactPage.css';

const codeExample = `
function App() {
  return <h2>¡Hola, este es un componente interactivo!</h2>;
}
render(<App />);
`;

const ReactPage = () => {
  return (
    <div className="container">
      <h1>Curso de React</h1>
      <p>Escribe tu propio componente React 👇</p>
      <LiveCode code={codeExample} />
    </div>
  );
};

export default ReactPage;
