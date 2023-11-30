import React from 'react';

const FruitsList = () => {
  const fruits = [{ category: "Fruits", name: "Apple" },
	{ category: "Fruits",name: "banana" },
  { category: "Fruits",name: "cherry" },
	{ category: "other",name: "bat" }];

  const filteredFruits = fruits.filter(fruit => fruit !== "bat");

  return (
    <div>
      <h2>Fruits List</h2>
      <ul>
        {filteredFruits.map((fruit, index) => (
          <li key={index}>Fruit {index + 1}: {fruit}</li>
        ))}
      </ul>
    </div>
  );
};

export default FruitsList;
