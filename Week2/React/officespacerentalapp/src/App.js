import officeImage from "./office.jpeg";

function App() {

  const office = {
    name: "Smart Work Office",
    rent: 55000,
    address: "Chennai"
  };

  const officeList = [
    {
      name: "Smart Work Office",
      rent: 55000,
      address: "Chennai"
    },
    {
      name: "Tech Park",
      rent: 75000,
      address: "Bangalore"
    },
    {
      name: "Cyber Hub",
      rent: 90000,
      address: "Hyderabad"
    },
    {
      name: "Business Tower",
      rent: 45000,
      address: "Coimbatore"
    }
  ];

  return (
    <div style={{ padding: "20px" }}>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office"
        width="500"
        height="300"
      />

      <h2>Featured Office</h2>

      <p><b>Name:</b> {office.name}</p>

      <p
        style={{
          color: office.rent < 60000 ? "red" : "green"
        }}
      >
        <b>Rent:</b> ₹{office.rent}
      </p>

      <p><b>Address:</b> {office.address}</p>

      <hr />

      <h2>Available Office Spaces</h2>

      {officeList.map((item, index) => (

        <div
          key={index}
          style={{
            border: "1px solid gray",
            marginBottom: "15px",
            padding: "10px",
            width: "350px"
          }}
        >

          <h3>{item.name}</h3>

          <p
            style={{
              color: item.rent < 60000 ? "red" : "green"
            }}
          >
            <b>Rent:</b> ₹{item.rent}
          </p>

          <p>
            <b>Address:</b> {item.address}
          </p>

        </div>

      ))}

    </div>
  );
}

export default App;