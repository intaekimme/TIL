import React from "react";
import { useLocation } from "react-router-dom";
import AppHeader from "../components/Common/AppHeader";
import queryString from "query-string";
import axios from "axios";

const AuthResultPage = () => {
  const code = useLocation().search;
  const authCode = queryString.parse(code).code;

  const handleAuthButtonClick = () => {
    let sendData = {
      code: authCode,
      client_id: "abbfc850-2b71-4e6a-b18b-994b9c8512d9",
      client_secret: "95747f61-1035-44de-a5f7-fb90ecb7b476",
      redirect_uri: "http://localhost:3000/authResult",
      grant_type: "authorization_code",
    };

    const parsedSendData = queryString.stringify(sendData);

    const option = {
      method: "POST",
      url: "/oauth/2.0/token",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
      },
      data: parsedSendData,
    };

    axios(option).then(({ data }) => {
      console.log(data.access_token);
      console.log(data.refresh_token);
      if (data.rsp_code !== "O0001") {
        localStorage.setItem("accessToken", data.access_token);
        localStorage.setItem("userSeqNo", data.user_seq_no);
      } else {
        alert("인증에 실패했습니다 다시 시도해 주세요");
      }

      console.log("accessToken: ", localStorage.getItem("accessToken"));
      console.log("userSeqNo: ", localStorage.getItem("userSeqNo"));
    });
  };

  return (
    <div>
      <AppHeader title={"인증완료 / 토큰 요청"}></AppHeader>
      사용자 authCode : {authCode}
      <button onClick={handleAuthButtonClick}>AccessToken 요청</button>
    </div>
  );
};

export default AuthResultPage;
