import logo from "./logo.svg";
import "./App.css";
import Welcome from "./components/Welcome";
import InputComponent from "./components/InputComponent";
import ListComponents from "./components/ListComponents";
import StyledComponent from "./components/StyledComponent";

function App() {
  return (
    <div className="App">
      <Welcome userName="김인태" userAge={29} userHeight={175}></Welcome>
      <Welcome userName="홍길동" userAge={48} userHeight={172}></Welcome>
      <Welcome userName="서장훈" userAge={50} userHeight={190}></Welcome>
      <Welcome userName="요정" userAge={1000} userHeight={1}></Welcome>
      <InputComponent></InputComponent>
      <ListComponents></ListComponents>
      <StyledComponent></StyledComponent>
    </div>
  );
}

export default App;
