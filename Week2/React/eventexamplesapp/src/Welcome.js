import React from "react";

function Welcome() {
  function sayWelcome(message) {
    alert("Welcome " + message);
  }

  return (
    <div>
      <button onClick={() => sayWelcome("welcome")}>
        Say Welcome
      </button>
    </div>
  );
}

export default Welcome;