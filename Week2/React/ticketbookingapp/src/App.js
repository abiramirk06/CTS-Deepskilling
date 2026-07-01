import React, { Component } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";
import LoginButton from "./LoginButton";
import LogoutButton from "./LogoutButton";

class App extends Component {
  constructor() {
    super();

    this.state = {
      isLoggedIn: false
    };
  }

  login = () => {
    this.setState({
      isLoggedIn: true
    });
  };

  logout = () => {
    this.setState({
      isLoggedIn: false
    });
  };

  render() {
    const isLoggedIn = this.state.isLoggedIn;

    let button;
    let page;

    if (isLoggedIn) {
      button = <LogoutButton onClick={this.logout} />;
      page = <UserPage />;
    } else {
      button = <LoginButton onClick={this.login} />;
      page = <GuestPage />;
    }

    return (
      <div style={{ textAlign: "center" }}>
        <h1>Ticket Booking App</h1>

        {button}

        <hr />

        {page}
      </div>
    );
  }
}

export default App;