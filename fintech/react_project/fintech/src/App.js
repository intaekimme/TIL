import logo from "./logo.svg";
import "./App.css";

import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import NewsPage from "./pages/NewsPage";
import IndexPage from "./pages/IndexPage";
import AuthResultPage from "./pages/AuthResultPage";
import MainPage from "./pages/MainPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<IndexPage />}></Route>
        <Route path="/authResult" element={<AuthResultPage />}></Route>
        <Route path="/news" element={<NewsPage />}></Route>
        <Route path="/main" element={<MainPage />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
