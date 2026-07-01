import React from "react";
import CohortDetails from "./Components/CohortDetails";

function App() {

    return (

        <div>

            <h1>Cohort Dashboard</h1>

            <CohortDetails
                name="React Fundamentals"
                startDate="01-Jul-2026"
                status="Ongoing"
                coach="John"
                trainer="David"
            />

            <CohortDetails
                name="Java Full Stack"
                startDate="15-Jun-2026"
                status="Completed"
                coach="Alice"
                trainer="Bob"
            />

            <CohortDetails
                name="Spring Boot"
                startDate="20-Jul-2026"
                status="Ongoing"
                coach="Steve"
                trainer="James"
            />

        </div>

    );

}

export default App;