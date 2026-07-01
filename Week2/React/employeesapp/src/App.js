import React, { Component } from "react";
import EmployeeList from "./EmployeeList";
import ThemeContext from "./ThemeContext";
import "./App.css";

class App extends Component {
  constructor() {
    super();

    this.state = {
      theme: "light",
      employees: [
        {
          id: 1,
          name: "Abirami",
          designation: "Software Engineer"
        },
        {
          id: 2,
          name: "Rahul",
          designation: "UI Developer"
        },
        {
          id: 3,
          name: "Priya",
          designation: "QA Engineer"
        }
      ]
    };
  }

  toggleTheme = () => {
    this.setState({
      theme: this.state.theme === "light" ? "dark" : "light"
    });
  };

  render() {
    return (
      <ThemeContext.Provider value={this.state.theme}>
        <div className="App">
          <h1>Employee Management Application</h1>

          <button onClick={this.toggleTheme}>
            Switch Theme
          </button>

          <EmployeeList employees={this.state.employees} />
        </div>
      </ThemeContext.Provider>
    );
  }
}

export default App;