import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor() {
    super();
    this.state = {
      rupees: "",
      euro: null,
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ rupees: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const euroValue = this.state.rupees / 90; // example rate
    this.setState({ euro: euroValue });
  }

  render() {
    return (
      <div>
        <h2>Currency Converter</h2>

        <form onSubmit={this.handleSubmit}>
          <input
            type="number"
            placeholder="Enter Rupees"
            value={this.state.rupees}
            onChange={this.handleChange}
          />

          <button type="submit">Convert</button>
        </form>

        {this.state.euro && (
          <h3>Euro: {this.state.euro.toFixed(2)}</h3>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;