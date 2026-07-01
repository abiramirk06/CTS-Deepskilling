import React from "react";
import "../mystyle.css";

function CalculateScore() {

  const student = {
    name: "Abirami",
    school: "PSNA College of Engineering and Technology",
    total: 500,
    goal: 450
  };

  const average = student.total / 5;

  return (
    <div className="container">
      <h1>Student Score Card</h1>

      <p><strong>Name :</strong> {student.name}</p>
      <p><strong>School :</strong> {student.school}</p>
      <p><strong>Total Marks :</strong> {student.total}</p>
      <p><strong>Goal :</strong> {student.goal}</p>
      <p><strong>Average :</strong> {average}</p>

    </div>
  );
}

export default CalculateScore;