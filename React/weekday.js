import React from 'react';

const WeekDaysList = () => {
  const weekDays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];

  return (
    <div>
      <h2>Week Days List</h2>
      <ul>
        {weekDays.map((day, index) => (
          <li key={index}>Day {index + 1}: {day}</li>
        ))}
      </ul>
    </div>
  );
};

export default WeekDaysList;
