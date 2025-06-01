import React from 'react';
import { LiveProvider, LiveEditor, LiveError, LivePreview } from 'react-live';
import './LiveEditor.css';

const LiveCodeEditor = ({ code }) => {
  return (
    <LiveProvider code={code}>
      <div className="editor-box">
        <LiveEditor className="editor" />
        <div className="preview-wrapper">
          <LivePreview />
        </div>
        <LiveError className="error" />
      </div>
    </LiveProvider>
  );
};

export default LiveCodeEditor;
