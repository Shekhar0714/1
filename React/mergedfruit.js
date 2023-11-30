import React from 'react';

const MergedFruitsList = () => {
  const fruits1 = ["apple", "banana"];
  const fruits2 = ["cherry", "orange"];

  const mergedFruits = [...fruits1, ...fruits2];

  return (
    <div>
      <h2>Merged Fruits List</h2>
      <ul>
        {mergedFruits.map((fruit, index) => (
          <li key={index}>Fruit {index + 1}: {fruit}</li>
        ))}
      </ul>
    </div>
  );
};

export default MergedFruitsList;
