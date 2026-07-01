import React from "react";
import Counter from "./Counter";
import Welcome from "./Welcome";
import ClickEvent from "./ClickEvent";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  return (
    <div style={{ textAlign: "center" }}>
      <h1>React Event Handling Example</h1>

      <Counter />
      <hr />

      <Welcome />
      <hr />

      <ClickEvent />
      <hr />

      <CurrencyConvertor />
    </div>
  );
}

export default App;