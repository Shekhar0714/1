// ChildComponent.js
import React from 'react';

const ChildComponent = (props) => {
  const { name } = props;

  return (
    <div>
      <h3>Child Component</h3>
      <p>Hi {name}!</p>
    </div>
  );
};

export default ChildComponent;
