// ChildComponent.js
import React from 'react';

const ChildComponent = (props) => {
  const { name } = props;
  const uppercaseName = name.toUpperCase();

  return (
    <div>
      <h3>Child Component</h3>
      <p>My name is {uppercaseName}</p>
    </div>
  );
};

export default ChildComponent;
