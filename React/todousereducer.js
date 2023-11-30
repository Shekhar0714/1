import React, { useReducer, useState } from 'react';

const taskReducer = (state, action) => {
  switch (action.type) {
    case 'ADD_TASK':
      return [...state, action.payload];
    case 'REMOVE_TASK':
      return state.filter((task, index) => index !== action.payload);
    default:
      return state;
  }
};

const TodoApp = () => {
  const [tasks, dispatch] = useReducer(taskReducer, []);
  const [newTask, setNewTask] = useState('');

  const addTask = () => {
    if (newTask.trim() !== '') {
      dispatch({ type: 'ADD_TASK', payload: newTask });
      setNewTask('');
    }
  };

  const removeTask = (index) => {
    dispatch({ type: 'REMOVE_TASK', payload: index });
  };

  return (
    <div>
      <center>
      <h1>Todo List</h1>

      <form
        onSubmit={(e) => {
          e.preventDefault();
          addTask();
        }}
      >
        <input
          type="text"
          value={newTask}
          onChange={(e) => setNewTask(e.target.value)}
        />
        <button type="submit">Add Task</button>
      </form>

      <h2>Tasks</h2>
      <ul>
        {tasks.map((task, index) => (
          <li key={index}>
            {task}
            <button onClick={() => removeTask(index)}>Remove</button>
          </li>
        ))}
      </ul>

      <p>Total tasks: {tasks.length}</p>
      </center>
    </div>
  );
};

export default TodoApp;