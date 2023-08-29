import React from 'react'

export default function PurchaseCard() {
    return (
        <div className="purchase-item">
            <p className="purchase-date">Date: 08/25/2023</p>
            <p className="purchase-details">Purchased: Treadmill</p>
            <p className="purchase-price">Price: $500.00</p>
            <button className="btn">Print Receipt</button>
        </div>
    )
}
