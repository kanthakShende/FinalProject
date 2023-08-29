import React, { useState } from 'react'
import { addTrainer } from '../api-client/api-module';

export default function FormCustomer({ setSelect, selectItem }) {

    const [id, setId] = useState(selectItem?selectItem.id:0);
    const [name, setName] = useState(selectItem?selectItem.name:'');
    const [dob, setDob] = useState(selectItem?selectItem.dob:'');
    const [gender, setGender] = useState(selectItem?selectItem.gender:'Male');
    const [contactNo, setContactNo] = useState(selectItem?selectItem.contactno:'');
    const [address, setAddress] = useState(selectItem?selectItem.address:'');
    const [weight, setWeight] = useState(selectItem?selectItem.weight:'');
    const [height, setHeight] = useState(selectItem?selectItem.height:'');
    const [username, setUsername] = useState(selectItem?selectItem.username:'');
    const [password, setPassword] = useState(selectItem?selectItem.password:'');
    const [trainer, setTrainer] = useState(selectItem?selectItem.trainer:'');
    const [userPlansPurchase, setUserPlansPurchase] = useState(selectItem?selectItem.userPlansPurchase:'');
    const [tasks, setTasks] = useState([]);
    const [orders, setOrders] = useState([]);

    const handleSubmit = (e) => {
        e.preventDefault();

        // Collect form data into an object
        const formData = {
            id,
            name,
            dob,
            gender,
            contactNo,
            address,
            weight,
            height,
            username,
            password,
            trainer,
            userPlansPurchase,
            tasks,
            orders
        };

        // Now you can use the formData object for further processing
        console.log('Form Data:', formData);
    };

    function handelClose(params) {
        setSelect('');
    }

    return (
        <div id="equipmentAddModal" class="modal">
            <div class="modal-content entity-add-form">
                <span class="close" onClick={handelClose}>&times;</span>

                <h2>Update Customer</h2>
                <form onSubmit={handleSubmit}>
                    <label htmlFor="name">Name:</label>
                    <input type="text" id="name" value={name} onChange={(e) => setName(e.target.value)} required />


                    <div class="input-group">
                        <div>
                            <label htmlFor="dob">Date of Birth:</label>
                            <input type="date" id="dob" value={dob} onChange={(e) => setDob(e.target.value)} />

                        </div>
                        <div>
                            <label htmlFor="gender">Gender:</label>
                            <select id="gender" value={gender} onChange={(e) => setGender(e.target.value)}>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>

                        <div>
                            <label htmlFor="contactNo">Contact Number:</label>
                            <input type="tel" id="contactNo" value={contactNo} onChange={(e) => setContactNo(e.target.value)} required />

                        </div>
                        <div>
                            <label htmlFor="weight">Weight:</label>
                            <input type="number" id="weight" value={weight} onChange={(e) => setWeight(e.target.value)} />

                        </div>
                        <div>
                            <label htmlFor="height">Height:</label>
                            <input type="number" id="height" value={height} onChange={(e) => setHeight(e.target.value)} />
                        </div>
                        <div>
                            <label htmlFor="trainer">Trainer:</label>
                            <input type="number" id="trainer" value={trainer} onChange={(e) => setTrainer(e.target.value)} />
                        </div>
                        <div>

                            <label htmlFor="username">Username:</label>
                            <input type="text" id="username" value={username} onChange={(e) => setUsername(e.target.value)} required />

                        </div>
                        <div>
                            <label htmlFor="password">Password:</label>
                            <input type="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
                        </div>
                    </div>


                    <label htmlFor="address">Address:</label>
                    <input type="text" id="address" value={address} onChange={(e) => setAddress(e.target.value)} />


                    <label htmlFor="userPlansPurchase">User Plans Purchase:</label>
                    <input type="number" id="userPlansPurchase" value={userPlansPurchase} onChange={(e) => setUserPlansPurchase(e.target.value)} />
                    <div>
                        <label>Tasks:</label>
                        <ul>
                            {tasks.map((task, index) => (
                                <li key={index}>{task}</li>
                            ))}
                        </ul>
                    </div>
                    <div className='btn-container-1'>
                        <button type="submit" class="add-button btn">Update</button>
                    </div>
                </form>

            </div>
        </div>
    )
}
