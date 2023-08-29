import React from 'react'

export default function UserProgress() {
    return (
        <>
            <div className="top-btn">
                <button className="add-btn" id="add-user" onclick="openDialog()">
                    Update Details
                </button>
            </div>
            <h2>Customer Progress</h2>
            <div className="progress-cards">
                <div className="progress-card">
                    <h3>Current Weight</h3>
                    <p className="measurement">150 lbs</p>
                </div>

                <div className="progress-card">
                    <h3>Total Weight Loss</h3>
                    <p className="measurement">20 lbs</p>
                </div>

                <div className="progress-card">
                    <h3>Workout Duration</h3>
                    <p className="measurement">2 hours</p>
                </div>

                <div className="progress-card">
                    <h3>Total Calories Burnt</h3>
                    <p className="measurement">1200 kcal</p>
                </div>

            </div>
        </>
    )
}
