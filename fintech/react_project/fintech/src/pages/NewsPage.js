import axios from "axios";
import React, { useState } from "react";
import AppHeader from "../components/Common/AppHeader";
import InputComponents from "../components/InputComponent";
import ListComponents from "../components/ListComponents";

const NewsPage = () => {
  const [searchInputText, setSearchInputText] = useState("");
  const [newsList, setNewsList] = useState([]);
  const handleSearchInputChange = (e) => {
    const { value } = e.target;
    setSearchInputText(value);
    console.log(value);
  };
  const handleSearchButtonClick = () => {
    //  axios 통해서 news API 에 요청 보내기
    console.log("서버로 요청을 보냅니다.");
    const requestUrl = `https://newsapi.org/v2/everything?q=${searchInputText}&from=2023-01-22&sortBy=popularity&apiKey=1e04b42558b24390996ab19ada0e6d3b&language=ko`;
    axios.get(requestUrl).then(({ data }) => {
      console.log(data.articles);
      const articles = data.articles;
      setNewsList(articles); //???
    });
    console.log("뉴스 데이터 내용");
  };

  return (
    <div>
      <AppHeader title={"뉴스 검색"}></AppHeader>
      <InputComponents
        handleChange={handleSearchInputChange}
        handleClick={handleSearchButtonClick}
      ></InputComponents>
      <ListComponents newsList={newsList}></ListComponents>
    </div>
  );
};

export default NewsPage;
