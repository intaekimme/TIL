import { useState } from "react";

const InputComponent = (props) => {
  let value = "test";
  const [name, setName] = useState("test");

  const handleChangeInput = (event) => {
    console.log(event.target.value);
    setName(event.target.value);
  };

  const handleClickButton = () => {
    alert(name);
  };

  return (
    <>
      <p>{name} </p>
      <input onChange={handleChangeInput}></input>
      <button on onClick={handleClickButton}>
        입력
      </button>
    </>
  );
};

export default InputComponent;
