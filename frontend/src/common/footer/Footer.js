import React from "react";
import {
  MDBFooter,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBIcon,
} from "mdb-react-ui-kit";
import mail from "../../assets/img/mail.png";
import { Link } from "react-router-dom";

import "./Footer.css";

export default function Footer() {
  return (
    <div>
      <MDBFooter
        bgColor="light"
        className="text-center text-lg-start text-muted"
      >
        <section className="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
          <div className="me-5 d-none d-lg-block">
            <div style={{ marginLeft: "8rem" }}>
              <img
                style={{ width: "1.5rem", height: "1.5rem" }}
                src={mail}
                alt="mail"
              ></img>
              <span style={{ marginLeft: 10 }}>errorshiftcom@gmail.com</span>
            </div>
          </div>
        </section>

        <section className="">
          <MDBContainer className="text-center text-md-start mt-5">
            <MDBRow className="mt-3">
              <MDBCol md="3" lg="4" xl="3" className="mx-auto mb-4">
                <h6 className="text-uppercase fw-bold mb-4">
                  <MDBIcon icon="gem" className="me-3" />
                  <Link className="link" to={"/"}>
                    ErrorShift
                  </Link>
                </h6>
              </MDBCol>

              <MDBCol md="2" lg="2" xl="2" className="mx-auto mb-4">
                <Link className="text-uppercase fw-bold mb-4 link" to={"/adv"}>
                  홍보 및 시연
                </Link>
              </MDBCol>

              <MDBCol md="3" lg="2" xl="2" className="mx-auto mb-4">
                <Link
                  className="text-uppercase fw-bold mb-4 link"
                  to={"/errortype"}
                >
                  에러 분류
                </Link>
              </MDBCol>

              <MDBCol md="4" lg="3" xl="3" className="mx-auto mb-md-0 mb-4">
                <Link
                  className="text-uppercase fw-bold mb-4 link"
                  to={"#github"}
                >
                  깃허브
                </Link>
              </MDBCol>
            </MDBRow>
          </MDBContainer>
        </section>

        <div
          className="text-center p-4"
          style={{ backgroundColor: "rgba(0, 0, 0, 0.05)" }}
        >
          © 2022 Copyright: E206
        </div>
      </MDBFooter>
    </div>
  );
}
