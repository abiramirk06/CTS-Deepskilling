import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor() {
    super();

    this.state = {
      employeeName: "",
      complaint: ""
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleSubmit(event) {
    event.preventDefault();

    const referenceNumber = Math.floor(10000 + Math.random() * 90000);

    alert(
      `Thanks ${this.state.employeeName}\nYour complaint has been submitted.\nReference Number: ${referenceNumber}`
    );

    this.setState({
      employeeName: "",
      complaint: ""
    });
  }

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h2>Ticket Raising Application</h2>

        <form onSubmit={this.handleSubmit}>

          <div>
            <label>Employee Name:</label><br />
            <input
              type="text"
              name="employeeName"
              value={this.state.employeeName}
              onChange={this.handleChange}
              required
            />
          </div>

          <br />

          <div>
            <label>Complaint:</label><br />
            <textarea
              name="complaint"
              rows="5"
              cols="30"
              value={this.state.complaint}
              onChange={this.handleChange}
              required
            />
          </div>

          <br />

          <button type="submit">
            Submit Complaint
          </button>

        </form>
      </div>
    );
  }
}

export default ComplaintRegister;