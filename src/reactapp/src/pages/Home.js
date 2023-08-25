import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Home.css';

const Home = () => {
    const [employeeList, setEmployeeList] = useState([]);
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [email, setEmail] = useState('');

    useEffect(() => {
        fetchEmployeeData(); // Fetch employee data on component mount
    }, []);

    const fetchEmployeeData = () => {
        axios.get('http://localhost:8080/api/employees')
        .then(response => {
            setEmployeeList(response.data);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
    };

    const addEmployee = () => {
        const newEmployee = {
            name: name,
            age: age,
            email: email
        };
    
        axios.post('http://localhost:8080/api/addEmployee', newEmployee)
        .then(response => {
            console.log('Employee added:', response.data);
            fetchEmployeeData(); // Fetch updated employee data after adding
        })
        .catch(error => {
            console.error('Error adding employee:', error);
        });
    
        setName('');
        setAge('');
        setEmail('');
    };
    

    const deleteEmployee = (employeeId) => {
        axios.delete(`http://localhost:8080/api/deleteEmployee/${employeeId}`)
        .then(response => {
            console.log('Employee deleted:', employeeId);
            fetchEmployeeData(); // Fetch updated employee data after deleting
        })
        .catch(error => {
            console.error('Error deleting employee:', error);
        });
    };

    return (
        <div className="employee-list-container">
            <h1>Employee List</h1>
            <form>
                <input
                    type="text"
                    placeholder="Name"
                    value={name}
                    onChange={e => setName(e.target.value)}
                    required
                />
                <input
                    type="number"
                    placeholder="Age"
                    value={age}
                    onChange={e => setAge(e.target.value)}
                    required
                />
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                    required
                />
                <button type="button" onClick={addEmployee}>
                    Add Employee
                </button>
            </form>
            <h2>Employee:</h2>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {employeeList.map(employee => (
                        <tr key={employee.id}>
                            <td>{employee.name}</td>
                            <td>{employee.age}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button onClick={() => deleteEmployee(employee.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Home;
