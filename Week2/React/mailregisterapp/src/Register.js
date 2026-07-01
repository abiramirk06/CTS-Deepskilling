import React, { Component } from "react";

class Register extends Component {
  constructor() {
    super();

    this.state = {
      name: "",
      email: "",
      password: "",
      errors: {}
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  validate = () => {
    const errors = {};

    if (this.state.name.length < 5) {
      errors.name = "Name should have at least 5 characters";
    }

    if (
      !this.state.email.includes("@") ||
      !this.state.email.includes(".")
    ) {
      errors.email = "Enter a valid Email";
    }

    if (this.state.password.length < 8) {
      errors.password = "Password should have at least 8 characters";
    }

    return errors;
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const errors = this.validate();

    if (Object.keys(errors).length === 0) {
      alert("Registration Successful!");

      this.setState({
        name: "",
        email: "",
        password: "",
        errors: {}
      });
    } else {
      this.setState({ errors });
    }
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h2>Mail Registration Form</h2>

        <form onSubmit={this.handleSubmit}>

          <div>
            <label>Name:</label><br />
            <input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
            />
            <br />
            <span style={{ color: "red" }}>
              {this.state.errors.name}
            </span>
          </div>

          <br />

          <div>
            <label>Email:</label><br />
            <input
              type="text"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />
            <br />
            <span style={{ color: "red" }}>
              {this.state.errors.email}
            </span>
          </div>

          <br />

          <div>
            <label>Password:</label><br />
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
            <br />
            <span style={{ color: "red" }}>
              {this.state.errors.password}
            </span>
          </div>

          <br />

          <button type="submit">
            Register
          </button>

        </form>
      </div>
    );
  }
}

export default Register;