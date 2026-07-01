import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 82 },
        { name: "Shubman Gill", score: 68 },
        { name: "KL Rahul", score: 72 },
        { name: "Hardik Pandya", score: 65 },
        { name: "Ravindra Jadeja", score: 77 },
        { name: "R Ashwin", score: 60 },
        { name: "Mohammed Shami", score: 58 },
        { name: "Jasprit Bumrah", score: 80 },
        { name: "Kuldeep Yadav", score: 55 },
        { name: "Mohammed Siraj", score: 74 }
    ];

    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>

            <table border="1" cellPadding="10">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Score</th>
                    </tr>
                </thead>

                <tbody>
                    {players.map((player, index) => (
                        <tr key={index}>
                            <td>{player.name}</td>
                            <td>{player.score}</td>
                        </tr>
                    ))}
                </tbody>
            </table>

            <br />

            <h2>Players with Score Below 70</h2>

            <ul>
                {lowScorePlayers.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

        </div>
    );
}

export default ListofPlayers;