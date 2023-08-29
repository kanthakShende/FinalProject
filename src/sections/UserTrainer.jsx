import React from 'react'

export default function UserTrainer() {
    return (
        <>
            <h2>Trainers Management</h2>
            <div className="trainers-cards">
                <div className="trainer-card">
                    <div className="trainer-info">
                        <img src="/img/profile.jpg" alt='' />
                        <h3 className="trainer-name">Om Vastre</h3>
                        <p className="trainer-specialization">Specialization: Fitness & Nutrition</p>
                        <p className="contact-info-1">Email: trainer@example.com<br />Phone: 123-456-7890</p>
                    </div>
                    <button className="update-trainer-button">Update Trainer</button>
                </div>
            </div>
        </>
    )
}
