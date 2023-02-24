import axios from "axios";
import React, { useState } from "react";
import styled from "styled-components";

const ModalCardBlock = styled.div`
  display: flex;
  flex-direction: column;
  margin: 0.5rem;
  padding: 20px;
  border: 1px #112211 solid;
`;
const CardTitle = styled.div`
  font-size: 1rem;
  color: black;
`;
const FintechUseNo = styled.div`
  font-size: 0.7rem;
  margin-bottom: 30px;
`;

const WithDrawButton = styled.button`
  border: none;
  padding: 0.3rem;
  background: #2aa450;
  color: white;
  margin-top: 0.3rem;
`;

const ModalCard = ({ bankName, fintechUseNo, tofintechno }) => {
  //fintechUseNo : 내계좌
  //tofintechno : QR 코드로 읽어온 핀테크 계좌
  const accessToken = localStorage.getItem("accessToken");

  const [amount, setamount] = useState("");

  const genTransId = () => {
    let countnum = Math.floor(Math.random() * 1000000000) + 1;
    const clientNo = "M202300409";
    let transId = clientNo + "U" + countnum; //이용기관번호 본인것 입력
    return transId;
  };

  const handlePayButtonClick = () => {
    //  출금 이체 발생시키기
    //  data params json
    //  tran_amg, fintech_use_num, requ_client_fintech_use
    //  axios option으로 요청을 작성하기 <-  api 요청
    //  application/json 은 데이터를 어떻게 전송?
    //  결과를 로그로 작성
    const data = {
      bank_tran_id: genTransId(),
      cntr_account_type: "N",
      cntr_account_num: "100000000001",
      dps_print_content: "사용료(김인태)",
      fintech_use_num: fintechUseNo,
      wd_print_content: "사용료",
      tran_amt: amount,
      tran_dtime: "20230224103900",
      req_client_name: "김인태",
      req_client_fintech_use_num: fintechUseNo,
      req_client_num: "KIT938639",
      transfer_purpose: "ST",
      recv_client_name: "김인태",
      recv_client_bank_code: "097",
      recv_client_account_num: "100000000001",
    };

    const option = {
      method: "POST",
      url: "/v2.0/transfer/withdraw/fin_num",
      headers: {
        Authorization: `Bearer ${accessToken}`,
      },
      data: data,
    };

    axios(option).then(({ data }) => {
      if (data.rsp_code === "A0000") {
        deposit();
      } else {
        alert("출금 이체 실패");
      }
      console.log(data);
    });
  };

  const deposit = () => {
    /**
     * #Last Work
     * 입금이체 작성해 주세요 !
     * 2legged token 사용 !
     * 입금을 하는 계좌를 잘 선택해 주세요
     */
    const twoLeggedToken =
      "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMzAwNDA5Iiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjg0OTgzMzQ2LCJqdGkiOiJjYTdiYTIwZS0wMGYwLTQxMzgtYWRmYS0wNWEzYjc0M2NjY2YifQ.YNDmfqrf8ugw8w0svtu400LHjI8I_9RcCmvwAOwBpvY";

    console.log(genTransId());

    const data = {
      cntr_account_type: "N",
      cntr_account_num: "200000000001",
      wd_pass_phrase: "NONE",
      wd_print_content: "오픈캐시백서비스",
      name_check_option: "on",
      sub_frnc_name: "하위가맹점",
      sub_frnc_num: "123456789012",
      sub_frnc_business_num: "1234567890",
      tran_dtime: "20230224113600",
      req_cnt: "1",
      req_list: [
        {
          tran_no: "1",
          bank_tran_id: genTransId(),
          fintech_use_num: fintechUseNo,
          print_content: "오픈캐시백서비스",
          tran_amt: amount,
          req_client_name: "김인태",
          req_client_bank_code: "097",
          req_client_account_num: "200000000001",
          req_client_num: "KIT938639",
          transfer_purpose: "TR",
          recv_bank_tran_id: genTransId(),
          cms_num: "93848103221",
          withdraw_bank_tran_id: genTransId(),
        },
      ],
    };

    const option = {
      method: "POST",
      url: "/v2.0/transfer/deposit/fin_num",
      headers: {
        Authorization: `Bearer ${twoLeggedToken}`,
        scope: "oob",
      },
      data: data,
    };

    axios(option).then(({ data }) => {
      if (data.rsp_code === "A0000") {
        alert("결제 완료!");
      }
      console.log(data);
    });
  };

  const handleChange = (e) => {
    const { value } = e.target;
    console.log(value);
    setamount(value);
  };

  return (
    <ModalCardBlock>
      <CardTitle>{bankName}</CardTitle>
      <FintechUseNo>{fintechUseNo}</FintechUseNo>
      <p>{tofintechno}로 돈을 보냅니다.</p>
      <input onChange={handleChange}></input>
      <WithDrawButton onClick={handlePayButtonClick}>결제하기</WithDrawButton>
    </ModalCardBlock>
  );
};

export default ModalCard;
