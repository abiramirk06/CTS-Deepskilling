import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard(props) {
  const theme = useContext(ThemeContext);

  return (
    <div className="card">
      <h2>{props.employee.name}</h2>
      <p>{props.employee.designation}</p>

      <button className={theme}>View</button>
      <button className={theme}>Edit</button>
      <button className={theme}>Delete</button>
    </div>
  );
}

export default EmployeeCard;