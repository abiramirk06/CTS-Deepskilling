import React from "react";
import EmployeeCard from "./EmployeeCard";

function EmployeeList(props) {
  return (
    <div>
      {props.employees.map((employee) => (
        <EmployeeCard
          key={employee.id}
          employee={employee}
        />
      ))}
    </div>
  );
}

export default EmployeeList;