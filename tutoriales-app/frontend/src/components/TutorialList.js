import React from 'react';

const TutorialList = ({ tutorials }) => {
  return (
    <div>
      {tutorials.length === 0 ? (
        <p>No hay tutoriales disponibles.</p>
      ) : (
        <ul>
          {tutorials.map((t) => (
            <li key={t.id}>
              <h4>{t.titulo}</h4>
              <p>{t.descripcion}</p>
              <pre>{t.contenido}</pre>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default TutorialList;
