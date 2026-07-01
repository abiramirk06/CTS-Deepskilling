import React from "react";

function ClickEvent() {
  function handleClick(event) {
    console.log(event); // Synthetic event
    alert("I was clicked");
  }

  return (
    <div>
      <button onClick={handleClick}>OnPress</button>
    </div>
  );
}

export default ClickEvent;