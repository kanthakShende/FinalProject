import React from 'react'

export default function UserMember() {
    return (
        <>
            <h2>Membership Management</h2>
            <div className="membership-cards overflow-scroll">
                <div className="membership-card">
                    <div className="membership-icon">
                        <img src="/img/diamond.png" alt="Membership Icon" />
                    </div>
                    <div className="membership-details">
                        <h3 className="membership-type">Gold Membership</h3>
                        <p className="membership-duration">Valid until 08/31/2023</p>
                        <p className="renewal-option">Renewal: Auto</p>
                    </div>
                    <button className="print-receipt-button" >Print Receipt</button>
                </div>

            </div>
        </>
    )
}
