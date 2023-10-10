
import './AutocompleteDropdown.css'
import { useState, useEffect } from 'react';

const AutocompleteDropdown = () => {
  const [inputValue, setInputValue] = useState("");
  const [data, setData] = useState([]);
  const [selectedValue, setSelectedValue] = useState('Option 2'); 

  useEffect(() => {
    const token = localStorage.getItem('token');

    if (!inputValue) {
      return;
    }
    const fetchData = async () => {
      console.log("entrando al fetching de datos...")
      const response = await fetch(`http://localhost:8080/api/v1/rentalInfo`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`,
        },
      });
      const jsonData = await response.json();
      setData(jsonData);
      console.log(jsonData);
    };

    fetchData();
  }, []);


  const handleChange = (e) => {
    setSelectedValue(e.target.value);
    console.log(selectedValue);
  };

  return (
    <div>
      <select
        id="data"
        className='autocomplete-dropdown'
        value={selectedValue} // Use the value prop to set the default value
        onChange={handleChange}
      >
        {data.map(item => (
          <option key={item.id} value={item.value}>
            {item.value}
          </option>
        ))}
      </select>
    </div>
  );
};

export default AutocompleteDropdown;
