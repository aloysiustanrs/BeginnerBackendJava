import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Home.css';

const Home = () => {
    const [userList, setUserList] = useState([]);
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [email, setEmail] = useState('');

    useEffect(() => {
        fetchUserData(); // Fetch user data on component mount
    }, []);

    const fetchUserData = () => {
        axios.get('http://localhost:8080/api/users')
        .then(response => {
            setUserList(response.data);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
    };

    const addUser = () => {
        const newUser = {
            name: name,
            age: age,
            email: email
        };
    
        axios.post('http://localhost:8080/api/addUser', newUser)
        .then(response => {
            console.log('User added:', response.data);
            fetchUserData(); // Fetch updated user data after adding
        })
        .catch(error => {
            console.error('Error adding user:', error);
        });
    
        setName('');
        setAge('');
        setEmail('');
    };
    

    const deleteUser = (userId) => {
        axios.delete(`http://localhost:8080/api/deleteUser/${userId}`)
        .then(response => {
            console.log('User deleted:', userId);
            fetchUserData(); // Fetch updated user data after deleting
        })
        .catch(error => {
            console.error('Error deleting user:', error);
        });
    };

    return (
        <div className="user-list-container">
            <h1>User List</h1>
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
                <button type="button" onClick={addUser}>
                    Add User
                </button>
            </form>
            <h2>Users:</h2>
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
                    {userList.map(user => (
                        <tr key={user.id}>
                            <td>{user.name}</td>
                            <td>{user.age}</td>
                            <td>{user.email}</td>
                            <td>
                                <button onClick={() => deleteUser(user.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Home;
