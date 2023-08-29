import React from 'react'
import PurchaseCard from '../component/PurchaseCard'

export default function UserStoreHis() {
    return (
        <>
            <h2>Purchase History</h2>
            <div className="purchase-history-list">
                <PurchaseCard/>
                <PurchaseCard/>
                <PurchaseCard/>
                <PurchaseCard/>
                <PurchaseCard/>
                <PurchaseCard/>
                <PurchaseCard/>
            </div>
        </>
    )
}
