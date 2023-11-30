import {useState} from 'react';
import './App.css';

const Counter = () =>{
const [count,setcount] = useState(0);
const Incrementcount = () => setcount(count + 1);
const Decrementcount = () => setcount(count - 1);

  return (
    <div classname="main">
      <center>
    <h1>Counter App</h1>
    <h2>Counter : {count}</h2>
    <button className='btn' id='inc' onClick={Incrementcount}>Increment</button>
    <button className='btn' id='dec' onClick={Decrementcount}>Decrement</button>
   </center>
   </div>
  );
}

export default Counter;
