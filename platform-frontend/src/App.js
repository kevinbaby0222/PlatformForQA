import {useState} from 'react';
function App() {


  const [content, setContent] = useState('标签默认内容')
  function handleClick (e) {
    setContent('新内容') 
  }
  return (
    <>
        <div>{content}</div>
        <button onClick = {handleClick}>点击</button>
    </>
  );
}

export default App;
