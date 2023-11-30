import React, { useState } from 'react'
import "./App.css"
import Input from './Component/Input'
import Todolist from './Component/TodoList';
function App() {
  const [listTodo,setListTodo]=useState([]);
  let addList = (inputText)=>{
    if(inputText!=='')
      setListTodo([...listTodo,inputText]);
  }
  const deleteListItem = (key)=>{
    let newListTodo = [...listTodo];
    newListTodo.splice(key,1)
    setListTodo([...newListTodo])
  }
  const count=listTodo.length;
  return (
    <div className="main-container">
      <div className="center-container">
<h3>Todo count:{count}</h3>
        <Input addList={addList}/>
        <h1 className="app-heading">TODO List</h1>
        <hr/>
        {listTodo.map((listItem,i)=>{
          return (
            <Todolist key={i} index={i} item={listItem} deleteItem={deleteListItem}/>
          )
        })}
      </div>
    </div>
  )
}

export default App
