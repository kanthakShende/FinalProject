import React, { useState } from 'react'
import NavBar from '../component/NavBar';
import UserProgress from '../sections/UserProgress';
import UserTask from '../sections/UserTask';
import UserTrainer from '../sections/UserTrainer';
import UserMember from '../sections/UserMember';
import UserStoreHis from '../sections/UserStoreHis';

export default function UserDashboard() {

    const [option, setOption] = useState('progress');
    return (
        <>
        <NavBar/>
            <div className="body-container">
                <div className="a-container">
                    <div className="siderbar-menu">
                        <ul>
                            <li>
                                <div className={`menu-option ${option === 'progress' ? 'active-menu' : ''}`} onClick={() => setOption('progress')}>
                                    Progress
                                    <img src="img/line-angle-right-icon.svg" alt='' className="toggle-btn" />
                                </div>
                            </li>
                            <li>
                                <div className={`menu-option ${option === 'tasks' ? 'active-menu' : ''}`} onClick={() => setOption('tasks')}>
                                    Tasks
                                    <img src="img/line-angle-right-icon.svg" alt='' className="toggle-btn" />
                                </div>
                            </li>
                            <li>
                                <div className={`menu-option ${option === 'trainer' ? 'active-menu' : ''}`} onClick={() => setOption('trainer')} >
                                    Trainer
                                    <img src="img/line-angle-right-icon.svg" alt='' className="toggle-btn" />
                                </div>
                            </li>
                            <li>
                                <div className={`menu-option ${option === 'membership' ? 'active-menu' : ''}`} onClick={() => setOption('membership')}>
                                    Membership
                                    <img src="img/line-angle-right-icon.svg" alt='' className="toggle-btn" />
                                </div>
                            </li>
                            <li>
                                <div className={`menu-option ${option === 'purchese' ? 'active-menu' : ''}`} onClick={() => setOption('purchese')} >
                                    Store Purchese
                                    <img src="img/line-angle-right-icon.svg" alt='' className="toggle-btn" />
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div className="main-container" id="mainContainer">
                    {option==='progress'&&<UserProgress />}
                    {option==='tasks'&&<UserTask />}
                    {option==='trainer'&&<UserTrainer />}
                    {option==='membership'&&<UserMember />}
                    {option==='purchese'&&<UserStoreHis />}
                    </div>
                </div>
            </div>
            <footer>
        <div className="divider-y"></div>
        <p>&copy; 2023 Fitsta.com All rights reserved.</p>

    </footer>
        </>
    )
}
