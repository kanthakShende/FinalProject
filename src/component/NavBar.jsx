import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { logoutUser } from "../api-client/api-module";

export default function NavBar() {
  const [login, setLogin] = useState();
  const navigate = useNavigate();

  useEffect(() => {
    setLogin(sessionStorage.getItem("login"));
  }, [login]);

  const handleLogout = async () => {
    await logoutUser();
    setLogin(false);
    navigate("/");
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <Link className="navbar-brand" to="/">
        <span>Fitsta</span>.com
      </Link>
      <button
        className="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav ml-auto">
          <li className="nav-item">
            <Link className="nav-link" to="/">
              Home
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/equipment-store">
              Store
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/home">
              Membership
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/home">
              About us
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to="/home">
              Contact Us
            </Link>
          </li>
          {!login && (
            <li className="nav-item">
              <Link className="nav-link" to="/login">
                Login/Sign Up
              </Link>
            </li>
          )}
          {login && (
            <li className="nav-item">
              <div className="nav-link" onClick={handleLogout}>
                LogOut
              </div>
            </li>
          )}
        </ul>
      </div>
    </nav>
  );
}
