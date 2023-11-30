// ParentComponent.js
import React from 'react';
import ChildComponent from './ChildComponent';

const ParentComponent = () => {
  const name = 'John';

  return (
    <div>
      <h2>Parent Component</h2>
      <ChildComponent name={name} />
    </div>
  );
};

export default ParentComponent;
